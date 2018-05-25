
create table "users" (
  "name"      varchar(20)   primary key,
  "passwd"    varchar(20)   not null,
  "icon"      varchar(3)    null        default       null,
  "reg_time"  timestamp     not null    default       current_timestamp,
  "last_con"  timestamp     null        default       null
);

create table "communities" (
  "name"      varchar(25)   primary key,
  "descrip"   varchar(255)  null        default       null,
  "time"      timestamp     not null    default       current_timestamp,
  "icon"      varchar(3)    null        default       null,
  "color"     char(6)       null        default       null,
  "bg_color"  char(6)       null        default       null,
  "admin"     varchar(20)   references  "users"       on delete set null
);

create table "threads" (
  "id"        serial        primary key,
  "title"     varchar(100)  not null,
  "content"   varchar(2500) not null,
  "time"      timestamp     not null    default       current_timestamp,
  "votes"     integer       not null    default       0,
  "edited"    timestamp     null        default       null,
  "community" varchar(25)   not null    references    "communities"
                            on delete   cascade,
  "user"      varchar(20)   references  "users"       on delete set null
);

create table "comments" (
  "id"        serial        primary key,
  "content"   varchar(1000) not null,
  "time"      timestamp     not null    default       current_timestamp,
  "votes"     integer       not null    default       0,
  "edited"    timestamp     null        default       null,
  "parent"    integer       null        default       null
                            references  "comments"    on delete cascade,
  "thread"    integer       not null    references    "threads"
                            on delete   cascade,
  "user"      varchar(20)   references  "users"       on delete set null
);

create table "users_communities" (
  "user"      varchar(20)   references  "users"       on delete cascade,
  "community" varchar(25)   references  "communities" on delete cascade,
  primary key ("user", "community")
);

create table "votes_threads" (
  "user"      varchar(20)   references  "users"       on delete cascade,
  "thread"    integer       references  "threads"     on delete cascade,
  "vote"      boolean       not null,
  primary key ("user", "thread")
);

create table "votes_comments" (
  "user"      varchar(20)   references  "users"       on delete cascade,
  "comment"   integer       references  "comments"    on delete cascade,
  "vote"      boolean       not null,
  primary key ("user", "comment")
);

create table "chatrooms" (
  "name"      varchar(25)   primary key,
  "descrip"   varchar(255)  null        default       null,
  "icon"      varchar(3)    null        default       null,
  "community" varchar(25)   not null    references    "communities"
                            on delete   cascade,
  "admin"     varchar(20)   references  "users"       on delete set null
);

create table "messages" (
  "id"        serial        primary key,
  "content"   varchar(255)  not null,
  "time"      timestamp     not null    default       current_timestamp,
  "room"      varchar(25)   not null    references    "chatrooms"
                            on delete   cascade,
  "user"      varchar(20)   references  "users"       on delete cascade
);
