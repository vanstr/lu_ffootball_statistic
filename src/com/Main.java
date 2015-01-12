package com;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.model.*;
import com.schema.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ivan on 06.01.2015..
 */
public class Main {


  public static void main(String[] args) throws Exception {

    testConnection();

    //File footballDataFolder = new File("resources/data");
    File footballDataFolder = new File("C:\\Users\\imi\\IdeaProjects\\trash\\lu_ffootball_statistic\\resources\\data");
    List<File> files = getXmlFilesInFolder(footballDataFolder);
    for (File file : files) {
      SpeleType speleType = getParsedObject(file.getAbsolutePath());
      if (isNewGame(speleType)) {
        System.out.println("Save to db :" + file.getName());
        saveDataToDb(speleType);
      }else{
        System.out.println("Slipped " + file.getName() );
      }
    }
  }


  private static List<File> getXmlFilesInFolder(File folder) {
    List<File> files = new ArrayList<>();
    for (final File fileEntry : folder.listFiles()) {
      if (!fileEntry.isDirectory() && isXmlFile(fileEntry)) {
        files.add(fileEntry);
        System.out.println(fileEntry.getName());
      }
    }
    return files;
  }

  private static boolean isXmlFile(File file) {
    String fileName = file.getName();
    String extension = "";

    int i = fileName.lastIndexOf('.');
    if (i > 0) {
      extension = fileName.substring(i + 1);
    }
    return extension.equalsIgnoreCase("xml");
  }

  private static boolean isNewGame(SpeleType speleType) {
    String place = speleType.getVieta();
    Date date = parseStringToDate(speleType.getLaiks());
    Game game = Game.getByDateAndPlace(date, place);

    if (game != null) {
      String teamName1 = game.getTeamGameOne().getTeam().getName();
      String teamName2 = game.getTeamGameTwo().getTeam().getName();

      String newTeamName1 = speleType.getKomanda().get(0).getNosaukums();
      String newTeamName2 = speleType.getKomanda().get(1).getNosaukums();

      if( (teamName1.equalsIgnoreCase(newTeamName1) || teamName1.equalsIgnoreCase(newTeamName2) )
          && (teamName2.equalsIgnoreCase(newTeamName1) || teamName2.equalsIgnoreCase(newTeamName2))
      ){
        return false;
      }
    }
    return true;

  }

  private static void saveDataToDb(SpeleType object) {
    Game game = new Game();

    String vieta = object.getVieta();
    game.setPlace(vieta);

    Date convertedDate = parseStringToDate(object.getLaiks());
    game.setDate(convertedDate);

    int spectatorsAmount = Integer.parseInt(object.getSkatitaji());
    game.setSpectatorsAmount(spectatorsAmount);
    Ebean.save(game);

    game.setTeamGameOne(generatePlayingTeam(object.getKomanda().get(0), game));
    game.setTeamGameTwo(generatePlayingTeam(object.getKomanda().get(1), game));
    //TODO process referee
    Ebean.update(game);
  }

  private static Date parseStringToDate(String date) {
    Date res = null;
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
      res = sdf.parse(date);
    }
    catch (ParseException e1) {
      e1.printStackTrace();
    }

    return res;
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
        List<Player> passPlayers = new ArrayList<>();
        for (PType pt : pTypes) {
          int passPlayerNumber1 = Integer.parseInt(pt.getNr());
          Player passPlayer = Player.getByNumber(passPlayerNumber1, tg.getTeam());
          passPlayers.add(passPlayer);
        }
        goal.setPassPlayers(passPlayers);
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
