package com.lu;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import com.lu.model.*;
import com.lu.schema.*;
import com.lu.structure.Statistic;
import com.lu.structure.TeamTop;
import dnl.utils.text.table.TextTable;

import javax.swing.*;
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

    File footballDataFolder = new File("C:\\Users\\imi\\IdeaProjects\\trash\\lu_ffootball_statistic\\resources\\data");
    List<File> files = getXmlFilesInFolder(footballDataFolder);
    for (File file : files) {
      SpeleType speleType = getParsedObject(file.getAbsolutePath());
      if (isNewGame(speleType)) {
        System.out.println("Save to db :" + file.getName());
        saveDataToDb(speleType);
      }
      else {
        System.out.println("Slipped " + file.getName());
      }
    }


    Statistic teamTop = new TeamTop();
    TextTable tt = new TextTable(teamTop.getColumns(), teamTop.getData());
    // this adds the numbering on the left
    tt.setAddRowNumbering(true);
    // sort by the first column
    tt.setSort(2, SortOrder.DESCENDING);

    tt.printTable();

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

      if ((teamName1.equalsIgnoreCase(newTeamName1) || teamName1.equalsIgnoreCase(newTeamName2))
          && (teamName2.equalsIgnoreCase(newTeamName1) || teamName2.equalsIgnoreCase(newTeamName2))
          ) {
        return false;
      }
    }
    return true;
  }

  private static void saveDataToDb(SpeleType speleType) {
    Game game = new Game();

    String vieta = speleType.getVieta();
    game.setPlace(vieta);

    Date convertedDate = parseStringToDate(speleType.getLaiks());
    game.setDate(convertedDate);

    int spectatorsAmount = Integer.parseInt(speleType.getSkatitaji());
    game.setSpectatorsAmount(spectatorsAmount);
    Ebean.save(game);

    KomandaType firstKomandaType = speleType.getKomanda().get(0);
    TeamGame teamGameOne = generatePlayingTeam(firstKomandaType, game);
    game.setTeamGameOne(teamGameOne);

    KomandaType secondKomandaType = speleType.getKomanda().get(1);
    TeamGame teamGameTwo = generatePlayingTeam(speleType.getKomanda().get(1), game);
    game.setTeamGameTwo(teamGameTwo);

    processGoals(firstKomandaType, teamGameOne, secondKomandaType, teamGameTwo);

    calcualteTeamsPoints(teamGameOne, teamGameTwo);

    //TODO process referee
    Ebean.update(game);
  }

  private static void calcualteTeamsPoints(TeamGame teamGameOne, TeamGame teamGameTwo) {
    List<Goal> team1Goals = teamGameOne.getGoals();
    List<Goal> team2Goals = teamGameTwo.getGoals();

    boolean isAdditionalTime;
    if (team2Goals == null || (team1Goals != null && team1Goals.size() > team2Goals.size())) {
      isAdditionalTime = hasPlayedAdditionalTime(team1Goals);
      teamGameOne.setWinners(true);
      teamGameTwo.setWinners(false);
    }
    else if (team1Goals == null || (team1Goals.size() < team2Goals.size())) {
      isAdditionalTime = hasPlayedAdditionalTime(team2Goals);
      teamGameOne.setWinners(false);
      teamGameTwo.setWinners(true);
    }
    else {
      throw new RuntimeException("Incorrect game result");
    }
    teamGameOne.setPlayedAdditionalTime(isAdditionalTime);
    teamGameTwo.setPlayedAdditionalTime(isAdditionalTime);
    teamGameOne.calculatePoints();
    teamGameTwo.calculatePoints();

    Ebean.update(teamGameOne);
    Ebean.update(teamGameTwo);
  }


  private static boolean hasPlayedAdditionalTime(List<Goal> teamGoals) {
    boolean additionalTime = false;
    long latestGoalTimeInSeconds = 0;
    for (Goal goal : teamGoals) {
      if (goal.getGoalTimeInSeconds() > latestGoalTimeInSeconds) {
        latestGoalTimeInSeconds = goal.getGoalTimeInSeconds();
      }
    }
    if (latestGoalTimeInSeconds > Constants.SIXTEE_MINUTES_IN_SECOND) {
      additionalTime = true;
    }
    return additionalTime;
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

    Ebean.update(tg);

    return tg;
  }

  private static void processGoals(KomandaType firstKomandaType, TeamGame teamGameOne, KomandaType secondKomandaType, TeamGame teamGameTwo) {

    List<Goal> goals = new ArrayList<>();

    List<Goal> teamOneGoals = processTeamGoals(firstKomandaType, secondKomandaType);
    if (teamOneGoals != null) {
      goals.addAll(teamOneGoals);
      teamGameOne.setGoals(teamOneGoals);
      Ebean.update(teamGameOne);
    }

    List<Goal> teamTwoGoals = processTeamGoals(secondKomandaType, firstKomandaType);
    if (teamTwoGoals != null) {
      goals.addAll(teamTwoGoals);
      teamGameTwo.setGoals(teamTwoGoals);
      Ebean.update(teamGameTwo);
    }
  }

  private static List<Goal> processTeamGoals(KomandaType firstKomandaType, KomandaType secondKomandaType) {
    VartiType varti = firstKomandaType.getVarti();
    if (varti == null) {
      return null;
    }

    Team scoredTeam = Team.getByName(firstKomandaType.getNosaukums());
    Team lostTeam = Team.getByName(secondKomandaType.getNosaukums());
    List<VGType> vartuGuvumi = varti.getVG();
    List<Goal> goals = new ArrayList<>();
    for (VGType vg : vartuGuvumi) {
      int playerNumber = Integer.parseInt(vg.getNr());
      Player goalAuthor = Player.getByNumber(playerNumber, scoredTeam);
      long goalTimaInSecond = parseStringToSeconds(vg.getLaiks());
      Goal goal = new Goal(goalAuthor, goalTimaInSecond, vg.getSitiens(), scoredTeam, lostTeam);

      // Process player passes
      List<Player> passPlayers = processPlayerPasses(scoredTeam, vg);
      goal.setPassPlayers(passPlayers);

      Ebean.save(goal);

      goals.add(goal);
    }
    return goals;
  }

  private static List<Player> processPlayerPasses(Team team, VGType vg) {
    List<Player> passPlayers = new ArrayList<>();
    List<PType> pTypes = vg.getP();
    if (!pTypes.isEmpty()) {

      for (PType pt : pTypes) {
        int passPlayerNumber1 = Integer.parseInt(pt.getNr());
        Player passPlayer = Player.getByNumber(passPlayerNumber1, team);
        passPlayers.add(passPlayer);
      }
    }
    return passPlayers;
  }

  private static long parseStringToSeconds(String time) {
    //String time = "12:32:22";
    String[] values = time.split(":");
    long res = (Integer.parseInt(values[0]) * 60 + Integer.parseInt(values[1]));
    return res;
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
