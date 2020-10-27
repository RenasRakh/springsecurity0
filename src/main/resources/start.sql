insert into users (username, password, email)
values
('user', '100', 'user@gmail.com');

insert into roles (name)
values
('USER'), ('ADMIN'), ('SOMETHING');

insert into users_roles (user_id, role_id)
values
(1, 1),
(1, 2);