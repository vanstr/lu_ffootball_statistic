package com.lu.model;

import com.avaje.ebean.Ebean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PLAYER",
    uniqueConstraints = @UniqueConstraint(columnNames = "TEAM_ID, NUMBER")
)
public class Player implements Comparable<Player> {

  @Id
  private int id;

  @ManyToOne
  private Team team;
  private int number;
  private String name;
  private String lastName;
  private String role;

  @OneToMany
  private List<Goal> goals;

  @ManyToMany
  private List<Goal> gavePass;

  @ManyToMany(mappedBy = "enrolledPlayers", cascade = CascadeType.ALL)
  private List<TeamGame> teamGamesAsEnrolledPlayer;

  @ManyToMany(mappedBy = "mainPlayers", cascade = CascadeType.ALL)
  private List<TeamGame> teamGamesAsMainPlayer;

  public Player() {

  }

  public Player(Team team, int nr, String vards, String uzvards, String loma) {
    setTeam(team);
    setNumber(nr);
    setLastName(uzvards);
    setName(vards);
    setRole(loma);
  }

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

  public List<TeamGame> getTeamGamesAsEnrolledPlayer() {
    return teamGamesAsEnrolledPlayer;
  }

  public void setTeamGamesAsEnrolledPlayer(List<TeamGame> teamGamesAsEnrolledPlayer) {
    this.teamGamesAsEnrolledPlayer = teamGamesAsEnrolledPlayer;
  }

  public List<TeamGame> getTeamGamesAsMainPlayer() {
    return teamGamesAsMainPlayer;
  }

  public void setTeamGamesAsMainPlayer(List<TeamGame> teamGamesAsMainPlayer) {
    this.teamGamesAsMainPlayer = teamGamesAsMainPlayer;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public static Player getByNumber(int nr, Team team) {
    return Ebean.find(Player.class).where().eq("number", nr).eq("team", team).findUnique();
  }

  public List<Goal> getGoals() {
    return Ebean.find(Goal.class).where().eq("goalAuthor", this).findList();
  }

  public void setGoals(List<Goal> goals) {
    this.goals = goals;
  }

  public List<Goal> getGavePass() {
    return gavePass;
  }

  public void setGavePass(List<Goal> gavePass) {
    this.gavePass = gavePass;
  }

  public static List<Player> findAll() {
    return Ebean.find(Player.class).findList();
  }


  public int getGoalAmount() {
    List<Goal> goals1 = getGoals();
    if (goals1 == null) {
      return 0;
    }
    else {
      return goals1.size();
    }
  }

  public int getPassAmount() {
    List<Goal> passes1 = getGavePass();
    if (passes1 == null) {
      return 0;
    }
    else {
      return passes1.size();
    }
  }

  @Override
  public int compareTo(Player o) {
    int res = o.getGoalAmount() - this.getGoalAmount();
    if(res == 0){
      res = o.getPassAmount() - this.getPassAmount();
    }
    return res;
  }
}
