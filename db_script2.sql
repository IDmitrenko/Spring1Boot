BEGIN;

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
    username varchar(50) NOT NULL,
    password varchar(100) NOT NULL,
    enabled boolean NOT NULL,
    PRIMARY KEY (username)
);

INSERT INTO users (username, password, enabled)
VALUES
('alex', '{noop}123', true),
('bob', '{noop}123', true);

DROP TABLE IF EXISTS authorities CASCADE;
CREATE TABLE authorities (
    username varchar(50) NOT NULL,
    authority varchar(50) NOT NULL,
    CONSTRAINT USERS_AUTHORITIES_FK UNIQUE (username, authority),
    CONSTRAINT AUTHORITIES_FK1 FOREIGN KEY (username)
    REFERENCES users (username)
);

INSERT INTO authorities
VALUES
('alex', 'ROLE_ADMIN'),
('alex', 'ROLE_USER'),
('bob', 'ROLE_USER');

COMMIT;