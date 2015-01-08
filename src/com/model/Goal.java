package com.model;

import javax.persistence.*;

@Entity
public class Goal {

  @Id
  private int id;

  @ManyToOne
  private TeamGame teamGame;
  @ManyToOne
  private Player goalAuthor;
  @ManyToOne
  private Player passPlayerFirst;
  @ManyToOne
  private Player passPlayerSecond;

  private long goalTimeInSeconds;
  private String goalType;

  public Goal(){

  }

  public Goal(Player goalAuthor, long goalTimaInSecond, TeamGame tg, String goalType) {
    setGoalAuthor(goalAuthor);
    setGoalTimeInSeconds(goalTimaInSecond);
    setTeamGame(tg);
    setGoalType(goalType);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public TeamGame getTeamGame() {
    return teamGame;
  }

  public void setTeamGame(TeamGame teamGame) {
    this.teamGame = teamGame;
  }

  public Player getGoalAuthor() {
    return goalAuthor;
  }

  public void setGoalAuthor(Player goalAuthor) {
    this.goalAuthor = goalAuthor;
  }

  public Player getPassPlayerFirst() {
    return passPlayerFirst;
  }

  public void setPassPlayerFirst(Player passPlayerFirst) {
    this.passPlayerFirst = passPlayerFirst;
  }

  public Player getPassPlayerSecond() {
    return passPlayerSecond;
  }

  public void setPassPlayerSecond(Player passPlayerSecond) {
    this.passPlayerSecond = passPlayerSecond;
  }

  public long getGoalTimeInSeconds() {
    return goalTimeInSeconds;
  }

  public void setGoalTimeInSeconds(long goalTimeInSeconds) {
    this.goalTimeInSeconds = goalTimeInSeconds;
  }

  public String getGoalType() {
    return goalType;
  }

  public void setGoalType(String goalType) {
    this.goalType = goalType;
  }
}
