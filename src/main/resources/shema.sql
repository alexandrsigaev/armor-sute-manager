DROP TABLE IF EXISTS costume;
DROP TABLE IF EXISTS armor;


CREATE TABLE IF NOT EXISTS costume
(
  id               serial PRIMARY KEY  NOT NULL,
  name_costume     VARCHAR(100) UNIQUE NOT NULL,
  max_count_armor  INTEGER,
  create_user_date DATE                NOT NULL DEFAULT now()
);


CREATE TABLE IF NOT EXISTS armor
(
  id         SERIAL PRIMARY KEY NOT NULL,
  id_costume INTEGER            NOT NULL,
  name_armor VARCHAR(255)       NOT NULL,
  artifact   VARCHAR(255)       NOT NULL,
  CONSTRAINT costume
    FOREIGN KEY (id_costume) REFERENCES costume (id)
      ON DELETE CASCADE
);

