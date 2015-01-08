package com.model;

import com.avaje.ebean.Ebean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team {

  @Id
  private int id;
  @Column(unique = true)
  private String name;

  //private Query<Team> FINDER = Ebean.find(Team.class);

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
}
