INSERT INTO `user`(name, birth_date)
VALUES ("Adam", CURRENT_DATE()),
       ("Eve", CURRENT_DATE()),
       ("Jack", CURRENT_DATE());

INSERT INTO  `post` (description, user_id)
VALUES ("Text", 1),
        ("Some text", 1),
        ("Description", 2),
        ("Some description", 3);
