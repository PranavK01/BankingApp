insert into customer (user_id,email, first_name, last_name, password, contact_num) values ('PK01', 'pranav.kalra3@wipro.com', 'Pranav', 'Kalra', '123', '9717275141');
insert into customer (user_id,email, first_name, last_name, password, contact_num) values ('RS01', 'ram.sharma@wipro.com', 'Ram', 'Sharma', '123', '9717276869');
insert into customer (user_id,email, first_name, last_name, password, contact_num) values ('TK01', 'tavleen.Khanna@wipro.com', 'Tavleen', 'Khanna', '123', '9710076869');

insert into customer (user_id,email, first_name, last_name, password, contact_num) values ('RK01', 'rohan.kumar@wipro.com', 'Rohan', 'Kumar', '123', '7684553522');
insert into customer (user_id,email, first_name, last_name, password, contact_num) values ('MB01', 'mohit.bhalla@wipro.com', 'Mohit', 'Bhalla', '123', '7684590909');
insert into customer (user_id,email, first_name, last_name, password, contact_num) values ('AK01', 'anil.kathuria@wipro.com', 'Anil', 'Kathuria', '123', '9088450909');

insert into saving_account (account_type, balance, currency, status, user_id,account_number) values ('Saving', 18000.0, 'INR', 'Active', 'PK01',20049);
insert into saving_account (account_type, balance, currency, status, user_id,account_number) values ('Saving', 10000.0, 'INR', 'Active', 'RS01',20050);
insert into saving_account (account_type, balance, currency, status, user_id,account_number) values ('Saving', 0, 'INR', 'Closed', 'TK01',20005);

insert into current_account (account_type, balance, currency, status, user_id, account_number) values ('Current', 6000.0, 'INR', 'Active','RK01',40056);
insert into current_account (account_type, balance, currency, status, user_id, account_number) values ('Current', 1000.0, 'INR', 'Active','MB01',40057);
insert into current_account (account_type, balance, currency, status, user_id, account_number) values ('Current', 0, 'INR', 'Closed','AK01',40010);

