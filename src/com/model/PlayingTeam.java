package com.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class PlayingTeam {

  @Id
  private int id;
  @ManyToOne
  private Team team;
  @OneToOne
  private Game game;
  private int points;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "MAIN_PLAYERS_IN_TEAM_GAME",
      joinColumns = @JoinColumn(name = "player_id"),
      inverseJoinColumns = @JoinColumn(name = "playing_team_id"))
  private List<Player> mainPlayers;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "ENROLLED_PLAYERS_IN_TEAM_GAME",
      joinColumns = @JoinColumn(name = "player_id"),
      inverseJoinColumns = @JoinColumn(name = "playing_team_id"))
  private List<Player> enrolledPlayers;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public List<Player> getMainPlayers() {
    return mainPlayers;
  }

  public void setMainPlayers(List<Player> mainPlayers) {
    this.mainPlayers = mainPlayers;
  }

  public List<Player> getEnrolledPlayers() {
    return enrolledPlayers;
  }

  public void setEnrolledPlayers(List<Player> enrolledPlayers) {
    this.enrolledPlayers = enrolledPlayers;
  }
}