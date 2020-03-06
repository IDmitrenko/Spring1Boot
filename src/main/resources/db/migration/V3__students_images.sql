DROP TABLE IF EXISTS students_images CASCADE;

CREATE TABLE students_images (
  id bigserial PRIMARY KEY,
  student_id  bigint NOT NULL,
  path   VARCHAR(250) NOT NULL,
  CONSTRAINT FK_STUDENT_ID_IMG FOREIGN KEY (student_id)
  REFERENCES students (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION
);

INSERT INTO students_images (student_id, path) VALUES
(1, '1.bmp'),
(2, ''),
(3, '');