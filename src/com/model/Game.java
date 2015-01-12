package com.model;


import com.avaje.ebean.Ebean;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Game{

  @Id
  private int id;
  private int spectatorsAmount;
  private String place;
  private Date date;

  @OneToOne
  private TeamGame teamGameOne;
  @OneToOne
  private TeamGame teamGameTwo;

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

  public TeamGame getTeamGameOne() {
    return teamGameOne;
  }

  public void setTeamGameOne(TeamGame teamGameOne) {
    this.teamGameOne = teamGameOne;
  }

  public TeamGame getTeamGameTwo() {
    return teamGameTwo;
  }

  public void setTeamGameTwo(TeamGame teamGameTwo) {
    this.teamGameTwo = teamGameTwo;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public static Game getByDateAndPlace(Date date, String place) {
    return Ebean.find(Game.class).where().eq("date", date).eq("place", place).findUnique();
  }
}
