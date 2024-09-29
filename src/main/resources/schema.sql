CREATE TABLE IF NOT EXISTS tb_user (
   id INT NOT NULL AUTO_INCREMENT,
   soeid varchar(250) not null,
   password varchar(250) not null,
   name varchar(250) not null,
   PRIMARY KEY (soeid)
);

CREATE TABLE IF NOT EXISTS tb_user_role (
   id INT NOT NULL AUTO_INCREMENT,
   soeid varchar(250) not null,
   role varchar(250) NOT NULL,
   PRIMARY KEY (id)
);
