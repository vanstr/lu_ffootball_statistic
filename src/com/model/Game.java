package com.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Game{

  @Id
  private int id;
  private int spectatorsAmount;
  private String place;

  @OneToOne
  private PlayingTeam playingTeamOne;
  @OneToOne
  private PlayingTeam playingTeamTwo;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getSpectatorsAmount() {
    return spectatorsAmount;
  }

  public void setSpectatorsAmount(int spectatorsAmount) {
    this.spectatorsAmount = spectatorsAmount;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public PlayingTeam getPlayingTeamOne() {
    return playingTeamOne;
  }

  public void setPlayingTeamOne(PlayingTeam playingTeamOne) {
    this.playingTeamOne = playingTeamOne;
  }

  public PlayingTeam getPlayingTeamTwo() {
    return playingTeamTwo;
  }

  public void setPlayingTeamTwo(PlayingTeam playingTeamTwo) {
    this.playingTeamTwo = playingTeamTwo;
  }

}
