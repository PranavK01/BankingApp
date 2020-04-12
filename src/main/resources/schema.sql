-- Table structure for table Customer
--

DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
  user_id varchar(200) NOT NULL,
  email varchar(200) NOT NULL,
  first_name varchar(200) DEFAULT NULL,
  last_name varchar(200) DEFAULT NULL,
  password varchar(200) DEFAULT NULL,
  contact_num varchar(200) DEFAULT NULL,
  current_accountNum bigint(20) DEFAULT NULL,
  saving_accountNum bigint(20) DEFAULT NULL,
  PRIMARY KEY (user_id),
  UNIQUE KEY UK_email (email));
  
--INSERT INTO customer (user_id, email, first_name, last_name, password, contact_num, current_accountNum, saving_accountNum) VALUES ("s", "hfjkdasf@kfj.com", "Swet", "Sahu", "123", "758275325", 20050, 20057);
  
  
--
-- Table structure for table saving_account
--
DROP TABLE IF EXISTS saving_account;

  CREATE TABLE saving_account (
  account_number bigint(20) NOT NULL IDENTITY(20050,21),
  account_type varchar(200),
  balance decimal(19,2) DEFAULT NULL,
  currency varchar(200),
  status varchar(200),
  user_id varchar(200),
  
  PRIMARY KEY (account_number));
--  FOREIGN KEY (user_id) REFERENCES customer (user_id));
  

DROP TABLE IF EXISTS saving_transaction;
CREATE TABLE saving_transaction (
  id bigint(20) NOT NULL IDENTITY(1,1),
  amount double NOT NULL,
  available_balance decimal(19,2) DEFAULT NULL,
  date datetime DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  status varchar(255) DEFAULT NULL,
  transfer_type varchar(255) DEFAULT NULL,
  account_number bigint(20) DEFAULT NULL,
  
  PRIMARY KEY (id));
--  ,  FOREIGN KEY (account_number) REFERENCES saving_account (account_number));
  

--
-- Table structure for table `current_account`
--
DROP TABLE IF EXISTS current_account;

CREATE TABLE current_account (
  account_number bigint(20) NOT NULL IDENTITY(20050,21),
  account_type varchar(200),
  balance decimal(19,2) DEFAULT NULL,
  currency varchar(200),
  status varchar(200),
  user_id varchar(200),
  
  PRIMARY KEY (account_number));
--  ,  FOREIGN KEY (user_id) REFERENCES customer (user_id));
  
  
DROP TABLE IF EXISTS current_transaction;

CREATE TABLE current_transaction (
  id bigint(20) NOT NULL IDENTITY(1,1),
  amount double NOT NULL,
  available_balance decimal(19,2) DEFAULT NULL,
  date datetime DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  status varchar(255) DEFAULT NULL,
  transfer_type varchar(255) DEFAULT NULL,
  account_number bigint(20) DEFAULT NULL,
  
  PRIMARY KEY (id));
--  ,  FOREIGN KEY (account_number) REFERENCES current_account (account_number));
