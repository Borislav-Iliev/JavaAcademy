INSERT INTO employee (first_name, last_name, email, password)
VALUES ("Leslie", "Andrews", "leslie@love2code.com", "1234"),
       ("Emma", "Baumgarten", "emma@love2code.com", "1234"),
       ("Avani", "Gupta", "avani@love2code.com", "1234");

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