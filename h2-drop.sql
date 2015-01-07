SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists game;

drop table if exists goal;

drop table if exists player;

drop table if exists ENROLLED_PLAYERS_IN_TEAM_GAME;

drop table if exists MAIN_PLAYERS_IN_TEAM_GAME;

drop table if exists playing_team;

drop table if exists team;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists game_seq;

drop sequence if exists goal_seq;

drop sequence if exists player_seq;

drop sequence if exists playing_team_seq;

drop sequence if exists team_seq;

