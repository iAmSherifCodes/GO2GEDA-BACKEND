-- 25252-+SET FOREIGN_KEY_CHECKS=0;
--
-- truncate table commuter_table;
-- truncate table commuter_profile_table;
-- truncate table driver_table;
-- truncate table driver_profile_table;
-- -- truncate table media_reactions;
--
-- insert into address(id, user_id, commuter_profile_id, state, country) values
--                                                                   (100, '4', 'Herbert Macaulay street', 'Lagos', 'Nigeria'),
--                                                                   (101, '4', 'Herbert Macaulay street', 'Lagos', 'Nigeria'),
--                                                                   (102, '4', 'Herbert Macaulay street', 'Lagos', 'Nigeria'),
--                                                                   (103, '4', 'Herbert Macaulay street', 'Lagos', 'Nigeria'),
--                                                                   (104, '4', 'Herbert Macaulay street', 'Lagos', 'Nigeria'),
--                                                                   (105, '4', 'Herbert Macaulay street', 'Lagos', 'Nigeria');
--
-- insert into users(id, email, password, is_active, address_id) values
--                                                                   (500, 'test@email.com', 'password', 0, 100),
--                                                                   (501, 'test1@email.com', 'password', 0, 101),
--                                                                   (502, 'test2@email.com', 'password', 0, 102),
--                                                                   (503, 'test3@email.com', 'password', 0, 103),
--                                                                   (504, 'test4@email.com', 'password', 0, 104),
--                                                                   (505, 'test5@email.com', 'password', 0, 105);