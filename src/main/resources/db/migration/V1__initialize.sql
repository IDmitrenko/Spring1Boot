DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product (
    id bigserial PRIMARY KEY,
    title VARCHAR(255),
    price numeric(8, 2)
);
INSERT INTO product (title, price) VALUES
('women''s dress', 35500.00),
('women''s boots', 20500.00),
('men''s shoes', 5900.00),
('electric drill', 6500.00),
('screwdriver', 12450.00),
('winter tires', 48000.00),
('perfume', 18240.00),
('shaving cream', 190.00),
('robot vacuum cleaner', 25500.00),
('Tefal frying pan', 5500.00),
('computer keyboard', 1820.00),
('computer mouse', 3500.00),
('glasses case', 1200.00),
('shaver', 35000.00),
('table clock', 8200.00),
('headphones', 16350.00),
('computer chair', 52300.00),
('bedroom Slippers', 3100.00),
('electric chandelier', 7500.00),
('dashboard camera', 12160.00);

DROP TABLE IF EXISTS students CASCADE;
CREATE TABLE students (
	id bigserial PRIMARY KEY,
    name VARCHAR(100)
);

INSERT INTO students (name) VALUES
('Igor'),
('Olga'),
('Andrew'),
('Alex'),
('Jana');

DROP TABLE IF EXISTS courses CASCADE;
CREATE TABLE courses (
	id bigserial PRIMARY KEY,
    title VARCHAR(100)
);

DROP TABLE IF EXISTS students_courses CASCADE;
CREATE TABLE students_courses (
	student_id bigint NOT NULL ,
    course_id  bigint NOT NULL,
    PRIMARY KEY (student_id, course_id),
    CONSTRAINT FK_STUDENT FOREIGN KEY (student_id)
    REFERENCES students (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT FK_COURSE FOREIGN KEY (course_id)
    REFERENCES courses (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS books CASCADE;
CREATE TABLE books (
    id bigserial PRIMARY KEY,
    title VARCHAR(100),
    description VARCHAR(255),
    year_of_issue CHARACTER(4)
);

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (
    id bigserial PRIMARY KEY,
    username varchar(50) NOT NULL,
    password varchar(100) NOT NULL
);

INSERT INTO users (username, password)
VALUES
('alex', '{noop}123'),
('bob', '{noop}123');

DROP TABLE IF EXISTS roles CASCADE;
CREATE TABLE roles (
    id bigserial PRIMARY KEY,
    name varchar(50) NOT NULL
);

INSERT INTO roles (name)
VALUES
('ROLE_ADMIN'),
('ROLE_USER');

DROP TABLE IF EXISTS users_roles CASCADE;
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