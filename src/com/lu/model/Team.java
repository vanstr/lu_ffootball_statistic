package com.lu.model;

import com.avaje.ebean.Ebean;
import com.lu.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
        .where().eq("scoredTeam", this).findRowCount();
    return goalsAmount;
  }

  public int getScoredGoalInMainTime() {
    int goalsAmount = Ebean.find(Goal.class)
        .where().eq("scoredTeam", this)
        .le("goalTimeInSeconds", Constants.SIXTEE_MINUTES_IN_SECOND)
        .findRowCount();

    return goalsAmount;
  }

  public int getLostGoalInMainTime() {
    int goalsAmount = Ebean.find(Goal.class)
        .where().eq("lostTeam", this)
        .le("goalTimeInSeconds", Constants.SIXTEE_MINUTES_IN_SECOND)
        .findRowCount();
    return goalsAmount;
  }

  public int getLostGoals() {
    int goalsAmount = Ebean.find(Goal.class)
        .where().eq("lostTeam", this).findRowCount();

    return goalsAmount;
  }

  public int getWonTeamGamesAmount() {
    int amount = Ebean.find(TeamGame.class)
        .where().eq("team", this).eq("winners", true).findRowCount();

    return amount;
  }

  public int getLostTeamGamesAmount() {
    int amount = Ebean.find(TeamGame.class)
        .where().eq("team", this).eq("winners", false).findRowCount();

    return amount;
  }

  @Override
  public String toString() {
    return "Team{" +
        "id=" + id +
        ", name=" + name +
        ", points=" + getPoints() +
        ", win=" + getWonTeamGamesAmount() +
        ", loose=" + getLostTeamGamesAmount() +
        ", TotalScoredGoals=" + getScoredGoals() +
        ", TotalLostGoals=" + getLostGoals() +
        ", ScoredGoalsInMainTime=" + getScoredGoalInMainTime() +
        ", LostGoalsInMainTime=" + getLostGoalInMainTime() +
        "}";
  }
}
