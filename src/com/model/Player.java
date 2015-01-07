package com.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Player {
  @Id
  private int id;

  @ManyToOne
  private Team team;
  private String name;
  @Column(unique = true)
  private int number;
  private String lastName;

  @ManyToMany(mappedBy = "enrolledPlayers", cascade = CascadeType.ALL)
  private List<PlayingTeam> enrolledPlayersInGame;

  @ManyToMany(mappedBy = "mainPlayers",  cascade = CascadeType.ALL)
  private List<PlayingTeam> mainPlayersInGame;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public List<PlayingTeam> getEnrolledPlayersInGame() {
    return enrolledPlayersInGame;
  }

  public void setEnrolledPlayersInGame(List<PlayingTeam> enrolledPlayersInGame) {
    this.enrolledPlayersInGame = enrolledPlayersInGame;
  }

  public List<PlayingTeam> getMainPlayersInGame() {
    return mainPlayersInGame;
  }

  public void setMainPlayersInGame(List<PlayingTeam> mainPlayersInGame) {
    this.mainPlayersInGame = mainPlayersInGame;
  }
}
