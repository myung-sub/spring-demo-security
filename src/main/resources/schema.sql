CREATE TABLE IF NOT EXISTS tb_user (
   id INT NOT NULL AUTO_INCREMENT,
   emp_no varchar(250) not null,
   password varchar(250) not null,
   name varchar(250) not null,
   PRIMARY KEY (emp_no)
);

CREATE UNIQUE INDEX IDX_USER_EMP_NO ON tb_user (emp_no);

CREATE TABLE IF NOT EXISTS tb_user_role (
   id INT NOT NULL AUTO_INCREMENT,
   emp_no varchar(250) not null,
   role varchar(250) NOT NULL,
   PRIMARY KEY (id)
);
