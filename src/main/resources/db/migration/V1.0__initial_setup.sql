CREATE TABLE IF NOT EXISTS user (
  id BIGINT(10) PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  email VARCHAR(255),
  password VARCHAR(8),
  insert_datetime DATETIME,
  update_datetime DATETIME,
  delete_datetime DATETIME
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS todo (
  id BIGINT(10) PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT(10) NOT NULL,
  text VARCHAR(255),
  complete_datetime DATETIME,
  insert_datetime DATETIME,
  update_datetime DATETIME,
  delete_datetime DATETIME,
  INDEX user_id(user_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;