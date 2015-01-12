package com.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Goal {

  @Id
  private int id;

  @ManyToOne
  private TeamGame teamGame;
  @ManyToOne
  private Player goalAuthor;
  @ManyToMany
  @JoinTable(name = "GOAL_PASS_PLAYER",
      joinColumns = @JoinColumn(name = "player_id"),
      inverseJoinColumns = @JoinColumn(name = "goal_id"))
  private List<Player> passPlayers;

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

  public List<Player> getPassPlayers() {
    return passPlayers;
  }

  public void setPassPlayers(List<Player> passPlayers) {
    this.passPlayers = passPlayers;
  }
}
