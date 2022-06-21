-- Users
INSERT INTO user_entity(name, age) VALUES
                                       ('name1', 5),
                                       ('name2', 10),
                                       ('name3', 15),
                                       ('name4', 20),
                                       ('name5', 25),
                                       ('name6', 30),
                                       ('name7', 35),
                                       ('name8', 40),
                                       ('name9', 45),
                                       ('name10', 50);


-- Articles
INSERT INTO article_entity(text, color, user_id) VALUES
                                      ('Test1', 'WHITE', 1),
                                      ('Test2', 'BLACK', 1),
                                      ('Test3', 'YELLOW', 1),
                                      ('Test4', 'RED', 1),
                                      ('Test4', 'WHITE', 2),
                                      ('Test4', 'RED', 2),
                                      ('Test5', 'BLUE', 3);

--UserAndArticles
INSERT INTO user_entity_articles (user_id, articles_id) values
                                     (1,1),
                                     (1,2),
                                     (1,3),
                                     (1,4),
                                     (2,5),
                                     (2,6),
                                     (3,7);