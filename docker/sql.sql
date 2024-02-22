CREATE DATABASE jym;
CREATE USER user_test WITH PASSWORD '123456';
GRANT ALL ON SCHEMA public TO user_test;
GRANT ALL PRIVILEGES ON DATABASE jym to user_test;
ALTER DATABASE jym OWNER TO user_test;

/*
CREATE TABLE  if not exists cycles
(
    id          serial PRIMARY KEY UNIQUE,
    title        TEXT    NOT NULL,
    comment      TEXT,
    default_type INTEGER NOT NULL,
    img          TEXT,
    start_date   TEXT    NOT NULL,
    finish_date  TEXT    NOT NULL,
    default_img  TEXT
);
CREATE TABLE if not exists "exercise_description"
(
    id         serial PRIMARY KEY UNIQUE,
    default_img TEXT,
    title       TEXT,
    img         TEXT
);
CREATE TABLE  IF NOT EXISTS exercises
(
    id            serial PRIMARY KEY UNIQUE,
    comment        TEXT,
    description_id INTEGER,
    type_exercise  TEXT,
    default_type   INTEGER NOT NULL,
    template       INTEGER NOT NULL,
    start_date     TEXT    NOT NULL,
    finish_date    TEXT    NOT NULL,
    parent_id      INTEGER
);
CREATE TABLE  if not exists sets
(
    id         serial PRIMARY KEY UNIQUE,
    comment     TEXT,
    weight      REAL,
    reps        INTEGER,
    start_date  TEXT    NOT NULL,
    finish_date TEXT    NOT NULL,
    parent_id   INTEGER
);
CREATE TABLE  if not exists user_antropom
(
    id          serial PRIMARY KEY UNIQUE,
    name         TEXT,
    weight       REAL,
    height       REAL,
    fat          REAL,
    neck         REAL,
    shoulder     REAL,
    pectoral     REAL,
    right_hand   REAL,
    left_hand    REAL,
    abs          REAL,
    right_leg    REAL,
    left_leg     REAL,
    left_calves  REAL,
    right_calves REAL,
    date         TEXT    NOT NULL
);
CREATE TABLE  if not exists workouts
(
    id          serial PRIMARY KEY UNIQUE,
    title        TEXT    NOT NULL,
    comment      TEXT,
    week_even    INTEGER NOT NULL,
    default_type INTEGER NOT NULL,
    template     INTEGER NOT NULL,
    day          TEXT,
    start_date   TEXT    NOT NULL,
    finish_date  TEXT    NOT NULL,
    parent_id    INTEGER
);*/