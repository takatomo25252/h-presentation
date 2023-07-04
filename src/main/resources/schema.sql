DROP TABLE IF EXISTS eat;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS human;


-- お店のテーブル
CREATE TABLE eat
(
   id SERIAL PRIMARY KEY,
   name TEXT,
   area TEXT,
   genre TEXT,
   detail TEXT,
   star TEXT,
   link TEXT,
   pic TEXT,
   inside TEXT,
   outside TEXT,
   food TEXT,
   read TEXT
);


-- 口コミテーブル
CREATE TABLE comments
(
   id SERIAL PRIMARY KEY,
   eatid INTEGER,
   bango INTEGER,
   namae TEXT,
   comment TEXT
);


-- ユーザーテーブル
CREATE TABLE human
(
  bango SERIAL PRIMARY KEY,
  namae TEXT,
  password TEXT
);
