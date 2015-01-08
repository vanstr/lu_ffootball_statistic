package com;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.model.*;
import com.schema.*;

import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 06.01.2015..
 */
public class Main {

  public static void main(String[] args) throws Exception {

    testConnection();

    SpeleType object = getParsedObject("resources/data/futbols20.xml");

    saveDataToDb(object);
  }

  private static void saveDataToDb(SpeleType object) {
    Game game = new Game();
    game.setPlace(object.getVieta());
    game.setSpectatorsAmount(Integer.parseInt(object.getSkatitaji()));
    Ebean.save(game);
    game.setTeamGameOne(generatePlayingTeam(object.getKomanda().get(0), game));
    game.setTeamGameTwo(generatePlayingTeam(object.getKomanda().get(1), game));
    //TODO process referee
    Ebean.update(game);
  }

  private static TeamGame generatePlayingTeam(KomandaType komandaType, Game game) {
    TeamGame tg = new TeamGame();

    tg.setGame(game);

    Team team = processTeam(komandaType);
    tg.setTeam(team);

    Ebean.save(tg);

    List<Player> enrolledPlayers = processEnrolledPlayers(komandaType);
    tg.setEnrolledPlayers(enrolledPlayers);

    List<Player> mainPlayers = processMainPlayers(komandaType);
    tg.setMainPlayers(mainPlayers);

    List<Goal> goals = processGoals(komandaType, tg);
    tg.setGoals(goals);
    int points = 0;// TODO calculate
    tg.setPoints(points);

    Ebean.update(tg);

    return tg;
  }

  private static List<Goal> processGoals(KomandaType komandaType, TeamGame tg) {
    VartiType varti = komandaType.getVarti();
    if (varti == null) {
      return null;
    }
    List<VGType> vartuGuvumi = varti.getVG();
    List<Goal> goals = new ArrayList<>();
    for (VGType vg : vartuGuvumi) {
      int playerNumber = Integer.parseInt(vg.getNr());
      Player goalAuthor = Player.getByNumber(playerNumber, tg.getTeam());
      long goalTimaInSecond = 0;// TODO vg.getLaiks();
      Goal goal = new Goal(goalAuthor, goalTimaInSecond, tg, vg.getSitiens());

      // Process player passes
      List<PType> pTypes = vg.getP();
      if (!pTypes.isEmpty()) {
        int passPlayerNumber1 = Integer.parseInt(pTypes.get(0).getNr());
        Player p1 = Player.getByNumber(passPlayerNumber1, tg.getTeam());
        goal.setPassPlayerFirst(p1);
        if (pTypes.size() > 1) {
          int passPlayerNumber2 = Integer.parseInt(pTypes.get(1).getNr());
          Player p2 = Player.getByNumber(passPlayerNumber2, tg.getTeam());
          goal.setPassPlayerSecond(p2);
        }
      }

      Ebean.save(goal);

      goals.add(goal);
    }
    return goals;
  }

  private static List<Player> processMainPlayers(KomandaType komandaType) {
    List<SpeletajsType> playersType = komandaType.getPamatsastavs().getSpeletajs();
    Team team = Team.getByName(komandaType.getNosaukums());
    return processPlayers(playersType, team);
  }

  private static List<Player> processEnrolledPlayers(KomandaType komandaType) {
    List<SpeletajsType> playersType = komandaType.getSpeletaji().getSpeletajs();
    Team team = Team.getByName(komandaType.getNosaukums());
    return processPlayers(playersType, team);
  }

  private static List<Player> processPlayers(List<SpeletajsType> playersType, Team team) {
    List<Player> players = new ArrayList<>();
    for (SpeletajsType p : playersType) {
      Player player = processPlayer(p, team);
      players.add(player);
    }
    return players;
  }

  private static Player processPlayer(SpeletajsType p, Team team) {
    int playerNumber = Integer.parseInt(p.getNr());
    Player player = Player.getByNumber(playerNumber, team);
    if (player == null) {
      player = new Player(team, playerNumber, p.getVards(), p.getUzvards(), p.getLoma());
      Ebean.save(player);
    }
    return player;
  }

  private static Team processTeam(KomandaType komandaType) {
    Team team = Team.getByName(komandaType.getNosaukums());
    if (team == null) {
      team = new Team(komandaType.getNosaukums());
      Ebean.save(team);
    }
    return team;
  }

  private static SpeleType getParsedObject(String fileName) throws JAXBException, FileNotFoundException {

    JAXBContext jx = JAXBContext.newInstance(ObjectFactory.class);

    Unmarshaller unmarshaller = jx.createUnmarshaller();
    StreamSource xml = new StreamSource(fileName);

    JAXBElement<SpeleType> some = unmarshaller.unmarshal(xml, SpeleType.class);
    SpeleType speleType = some.getValue();

    /*Marshaller marshaller = jx.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "src/com/xsd/exampl.xsd");
    marshaller.marshal(some, System.out);*/

    return speleType;
  }

  private static void testConnection() {
    String sql = "select count(*) as count from dual";
    SqlRow row = Ebean.createSqlQuery(sql).findUnique();
    Integer i = row.getInteger("count");

    System.out.println("Got " + i + "  - DataSource good.");
    System.out.println("Test connection done");
  }
}
