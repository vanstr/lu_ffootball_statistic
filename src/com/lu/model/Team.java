package com.lu.model;

import com.avaje.ebean.Ebean;
import com.lu.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

  @Id
  private int id;
  @Column(unique = true)
  private String name;

  public Team() {
  }

  public Team(String teamName) {
    setName(teamName);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static Team getByName(String name) {
    return Ebean.find(Team.class).where().eq("name", name).findUnique();
  }

  public static List<Team> findAll() {
    return Ebean.find(Team.class).findList();
  }

  public int getPoints() {
    List<TeamGame> teamGames = getTeamGames();
    int res = 0;
    for (TeamGame teamGame : teamGames) {
      res += teamGame.getPoints();
    }
    return res;
  }

  private List<TeamGame> getTeamGames() {
    return Ebean.find(TeamGame.class).where().eq("team", this).findList();
  }

  public int getScoredGoals() {
    int goalsAmount = Ebean.find(Goal.class)
        .where().in("scoredTeam", this).findRowCount();
    return goalsAmount;
  }

  public int getScoredGoalInMainTime() {
    int goalsAmount = Ebean.find(Goal.class)
        .where().in("scoredTeam", this)
        .le("goalTimeInSeconds", Constants.SIXTEE_MINUTES_IN_SECOND)
        .findRowCount();

    return goalsAmount;
  }

  public int getLostGoalInMainTime() {
    int goalsAmount = Ebean.find(Goal.class)
        .where().in("lostTeam", this)
        .le("goalTimeInSeconds", Constants.SIXTEE_MINUTES_IN_SECOND)
        .findRowCount();
    return goalsAmount;
  }

  public int getLostGoals() {
    int goalsAmount = Ebean.find(Goal.class)
        .where().in("lostTeam", this).findRowCount();

    return goalsAmount;
  }

  private List<TeamGame> getTeamGamesWithOponent() {
    List<TeamGame> teamGames = getTeamGames();
    List<Game> res1 = Ebean.find(Game.class).where().in("teamGameOne", teamGames).findList();
    List<Game> res2 = Ebean.find(Game.class).where().in("teamGameTwo", teamGames).findList();

    List<TeamGame> oponentTeamGames = new ArrayList<>();
    for (Game g : res2) {
      oponentTeamGames.add(g.getTeamGameOne());
    }
    for (Game g : res1) {
      oponentTeamGames.add(g.getTeamGameTwo());
    }
    return oponentTeamGames;
  }

  @Override
  public String toString() {
    return "Team{" +
        "id=" + id +
        ", name=" + name +
        ", points=" + getPoints() +
        ", TotalScoredGoals=" + getScoredGoals() +
        ", TotalLostGoals=" + getLostGoals() +
        ", ScoredGoalsInMainTime=" + getScoredGoalInMainTime() +
        ", LostGoalsInMainTime=" + getLostGoalInMainTime() +
        "}";
  }
}
