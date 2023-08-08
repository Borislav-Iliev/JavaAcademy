INSERT INTO employee (first_name, last_name, email, password)
VALUES ("Leslie", "Andrews", "leslie@love2code.com", "$2a$12$dhjUJMPn7Zj/NhjQKijIReRKiVdIygoQHMcYkNbPYLXS8gO1zz.cC"),
       ("Emma", "Baumgarten", "emma@love2code.com", "$2a$12$DZ5XUHDqO1hH4YskxiujRe1pAcRif7sCzuUKabsZeINrg8KtWaxKW"),
       ("Avani", "Gupta", "avani@love2code.com", "$2a$12$nBx/dbMOHUJwo5ZuzG/P2.QblbjCFLE3uTYQHPGyzUmh85KdJclXu");

INSERT INTO `role` (role)
VALUES ("EMPLOYEE"),
       ("MANAGER"),
       ("ADMIN");

INSERT INTO employee_role (employee_id, role_id)
VALUES (1, 1),
       (2, 1),
       (2, 2),
       (3, 1),
       (3, 2),
       (3, 3);