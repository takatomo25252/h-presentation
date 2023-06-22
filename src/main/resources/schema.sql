


-- お店のテーブル
CREATE TABLE eat
(
   id SERIAL PRIMARY KEY,
   name TEXT,
   area TEXT,
   genre TEXT,
   detail TEXT,
   star NUMERIC,
   link TEXT
);


-- 口コミテーブル
CREATE TABLE comments
(
   id SERIAL PRIMARY KEY,
   name TEXT,
   comment TEXT
);


-- ユーザーテーブル
CREATE TABLE user
(
  id SERIAL PRIMARY KEY,
  name TEXT,
  password TEXT
);

