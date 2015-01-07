create table game (
  id                        integer not null,
  spectators_amount         integer,
  place                     varchar(255),
  playing_team_one_id       integer,
  playing_team_two_id       integer,
  constraint pk_game primary key (id))
;

create table goal (
  id                        integer not null,
  playing_team_id           integer,
  goal_author_id            integer,
  pass_player_first_id      integer,
  pass_player_second_id     integer,
  goal_time_in_seconds      bigint,
  goal_type                 varchar(255),
  constraint pk_goal primary key (id))
;

create table player (
  id                        integer not null,
  team_id                   integer,
  name                      varchar(255),
  number                    integer,
  last_name                 varchar(255),
  constraint uq_player_number unique (number),
  constraint pk_player primary key (id))
;

create table playing_team (
  id                        integer not null,
  team_id                   integer,
  game_id                   integer,
  points                    integer,
  constraint pk_playing_team primary key (id))
;

create table team (
  id                        integer not null,
  name                      varchar(255),
  constraint pk_team primary key (id))
;


create table MAIN_PLAYERS_IN_TEAM_GAME (
  player_id                      integer not null,
  playing_team_id                integer not null,
  constraint pk_MAIN_PLAYERS_IN_TEAM_GAME primary key (player_id, playing_team_id))
;

create table ENROLLED_PLAYERS_IN_TEAM_GAME (
  player_id                      integer not null,
  playing_team_id                integer not null,
  constraint pk_ENROLLED_PLAYERS_IN_TEAM_GAME primary key (player_id, playing_team_id))
;
create sequence game_seq;

create sequence goal_seq;

create sequence player_seq;

create sequence playing_team_seq;

create sequence team_seq;

alter table game add constraint fk_game_playingTeamOne_1 foreign key (playing_team_one_id) references playing_team (id) on delete restrict on update restrict;
create index ix_game_playingTeamOne_1 on game (playing_team_one_id);
alter table game add constraint fk_game_playingTeamTwo_2 foreign key (playing_team_two_id) references playing_team (id) on delete restrict on update restrict;
create index ix_game_playingTeamTwo_2 on game (playing_team_two_id);
alter table goal add constraint fk_goal_playingTeam_3 foreign key (playing_team_id) references playing_team (id) on delete restrict on update restrict;
create index ix_goal_playingTeam_3 on goal (playing_team_id);
alter table goal add constraint fk_goal_goalAuthor_4 foreign key (goal_author_id) references player (id) on delete restrict on update restrict;
create index ix_goal_goalAuthor_4 on goal (goal_author_id);
alter table goal add constraint fk_goal_passPlayerFirst_5 foreign key (pass_player_first_id) references player (id) on delete restrict on update restrict;
create index ix_goal_passPlayerFirst_5 on goal (pass_player_first_id);
alter table goal add constraint fk_goal_passPlayerSecond_6 foreign key (pass_player_second_id) references player (id) on delete restrict on update restrict;
create index ix_goal_passPlayerSecond_6 on goal (pass_player_second_id);
alter table player add constraint fk_player_team_7 foreign key (team_id) references team (id) on delete restrict on update restrict;
create index ix_player_team_7 on player (team_id);
alter table playing_team add constraint fk_playing_team_team_8 foreign key (team_id) references team (id) on delete restrict on update restrict;
create index ix_playing_team_team_8 on playing_team (team_id);
alter table playing_team add constraint fk_playing_team_game_9 foreign key (game_id) references game (id) on delete restrict on update restrict;
create index ix_playing_team_game_9 on playing_team (game_id);



alter table MAIN_PLAYERS_IN_TEAM_GAME add constraint fk_MAIN_PLAYERS_IN_TEAM_GAME__01 foreign key (player_id) references playing_team (id) on delete restrict on update restrict;

alter table MAIN_PLAYERS_IN_TEAM_GAME add constraint fk_MAIN_PLAYERS_IN_TEAM_GAME__02 foreign key (playing_team_id) references player (id) on delete restrict on update restrict;

alter table ENROLLED_PLAYERS_IN_TEAM_GAME add constraint fk_ENROLLED_PLAYERS_IN_TEAM_G_01 foreign key (player_id) references playing_team (id) on delete restrict on update restrict;

alter table ENROLLED_PLAYERS_IN_TEAM_GAME add constraint fk_ENROLLED_PLAYERS_IN_TEAM_G_02 foreign key (playing_team_id) references player (id) on delete restrict on update restrict;
