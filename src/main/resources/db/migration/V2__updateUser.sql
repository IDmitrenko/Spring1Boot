/*ALTER TABLE IF EXISTS users
  ADD COLUMN first_name varchar(50) NOT NULL,
  ADD COLUMN last_name varchar(50) NOT NULL,
  ADD COLUMN email varchar(50) NOT NULL;*/

DROP TABLE IF EXISTS users_roles CASCADE;

INSERT INTO roles (name)
VALUES
('ROLE_EMPLOYEE'),
('ROLE_MANAGER');

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (
    id bigserial PRIMARY KEY,
    username varchar(50) NOT NULL,
    password varchar(100) NOT NULL,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    email varchar(50) NOT NULL
);

INSERT INTO users (username, password, first_name, last_name, email)
VALUES
('alex', '{noop}123', 'Алексей', 'Семенов', 'alex@mail.ru'),
('bob', '{noop}123', 'Боб', 'Трамп', 'bob@mail.com');

CREATE TABLE users_roles (
	user_id bigint NOT NULL ,
    role_id  bigint NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT FK_USER FOREIGN KEY (user_id)
    REFERENCES users (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT FK_ROLE FOREIGN KEY (role_id)
    REFERENCES roles (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);

INSERT INTO users_roles (user_id, role_id)
VALUES
(1, 1),
(1, 2),
(2, 2);