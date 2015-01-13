package com.lu.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Goal {

  @Id
  private int id;

  @ManyToOne
  private Game game;
  @ManyToOne
  private TeamGame teamGame;
  @ManyToOne
  private Team scoredTeam;
  @ManyToOne
  private Team lostTeam;
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

  public Goal(Player goalAuthor, long goalTimaInSecond, String goalType, Team scoredTeam, Team lostTeam) {
    setGoalAuthor(goalAuthor);
    setGoalTimeInSeconds(goalTimaInSecond);
    setGoalType(goalType);
    setLostTeam(lostTeam);
    setScoredTeam(scoredTeam);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public Team getLostTeam() {
    return lostTeam;
  }

  public void setLostTeam(Team lostTeam) {
    this.lostTeam = lostTeam;
  }

  public Team getScoredTeam() {
    return scoredTeam;
  }

  public void setScoredTeam(Team scoredTeam) {
    this.scoredTeam = scoredTeam;
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  public TeamGame getTeamGame() {
    return teamGame;
  }

  public void setTeamGame(TeamGame teamGame) {
    this.teamGame = teamGame;
  }
}
