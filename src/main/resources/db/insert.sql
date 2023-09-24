SET FOREIGN_KEY_CHECKS=0;

truncate table driver_table;
truncate table driver_profile_table;
truncate table go2geda_user;
truncate table user_basic_information;
--
insert into user_basic_information(id, first_name, last_name, email, phone_number, password) values
                                                                  (100, 'AdeTest', 'LastName', 'test@email.com', '090909090', 'password'),
                                                                  (101, 'AdeTest1', 'LastName1', 'test@email1.com', '090909091', 'password1'),
                                                                  (102, 'AdeTest2', 'LastName2', 'test@email2.com', '090909092', 'password2'),
                                                                  (103, 'AdeTest3', 'LastName3', 'test@email3.com', '090909093', 'password3'),
                                                                  (104, 'AdeTest4', 'LastName4', 'test@email4.com', '090909094', 'password4'),
                                                                  (105, 'AdeTest5', 'LastName5', 'test@email5.com', '090909095', 'password5');
--
-- insert into users(id, email, password, is_active, address_id) values
--                                                                   (500, 'test@email.com', 'password', 0, 100),
--                                                                   (501, 'test1@email.com', 'password', 0, 101),
--                                                                   (502, 'test2@email.com', 'password', 0, 102),
--                                                                   (503, 'test3@email.com', 'password', 0, 103),
--                                                                   (504, 'test4@email.com', 'password', 0, 104),
--                                                                   (505, 'test5@email.com', 'password', 0, 105);