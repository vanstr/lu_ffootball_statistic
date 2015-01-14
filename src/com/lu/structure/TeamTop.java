package com.lu.structure;

import com.lu.model.Team;

import java.util.List;

/**
 * Created by imi on 14.01.2015..
 */
public class TeamTop extends Statistic {


  public TeamTop() {
    List<Team> teams = Team.findAll();
    int size = teams.size();
    Object[][] statistic = new Object[size][];
    for (int i = 0; i < size ; i++) {
      Team team = teams.get(i);
      Object[] row = {team.getName(), team.getPoints(),
          team.getWonTeamGamesAmount(), team.getLostTeamGamesAmount(),
          team.getScoredGoals(), team.getLostGoals(),
          team.getScoredGoalInMainTime(), team.getLostGoalInMainTime()
      };
      statistic[i] = row;
    }
    setData(statistic);
    String[] columnNames = {"Name", "Points",
        "Won Games", "Lost Games",
        "Scored Goals", "Lost Goals",
        "Scored Goal In Main Time", "Lost Goal In Main Time"
    };
    setColumns(columnNames);
  }

}
