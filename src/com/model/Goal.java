package com.model;

import javax.persistence.*;

@Entity
public class Goal {

  @Id
  private int id;

  @ManyToOne
  private PlayingTeam playingTeam;
  @ManyToOne
  private Player goalAuthor;
  @ManyToOne
  private Player passPlayerFirst;
  @ManyToOne
  private Player passPlayerSecond;

  private long goalTimeInSeconds;
  private String goalType;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public PlayingTeam getPlayingTeam() {
    return playingTeam;
  }

  public void setPlayingTeam(PlayingTeam playingTeam) {
    this.playingTeam = playingTeam;
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
