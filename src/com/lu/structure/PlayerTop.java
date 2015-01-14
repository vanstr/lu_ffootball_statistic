package com.lu.structure;

import com.lu.model.Player;

import java.util.Collections;
import java.util.List;

/**
 * Created by imi on 14.01.2015..
 */
public class PlayerTop extends Statistic {

  public PlayerTop(){
    List<Player> players = Player.findAll();
    Collections.sort(players);

    int size = players.size();
    if( size > 10 ) size = 10;
    Object[][] statistic = new Object[size][];
    for (int i = 0; i < size ; i++) {
      Player player = players.get(i);
      Object[] row = {player.getName(), player.getLastName(),
          player.getGoalAmount(), player.getPassAmount(),
          player.getTeam().getName()
      };
      statistic[i] = row;
    }
    setData(statistic);
    String[] columnNames = {"Name", "LastName",
        "Goals", "Passes",
        "TeamName"
    };
    setColumns(columnNames);

  }
}
