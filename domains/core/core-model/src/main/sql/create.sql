CREATE SCHEMA TIME;

CREATE TABLE TIME.TIME_TAG
(
  TIME_TAG_KEY bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate key for TimeTag entity, uniquely identifies entity inside system.',
  USER_KEY bigint(20) NOT NULL COMMENT 'Users table foreign key',
  TIME_TAG_DESC varchar(255) DEFAULT NULL COMMENT 'String description giving more information about Time Tag.',
  TIME_TAG_NAME varchar(255) NOT NULL COMMENT 'Short name of the TimeTag.',
  TIME_TAG_TS datetime NOT NULL COMMENT 'The date and time this tag was created.',
  CONSTRAINT TIME_TAG_PK PRIMARY KEY (TIME_TAG_KEY)
) COMMENT = 'Table for the most base entity represents tag of the time with name and description as a string.';

CREATE TABLE TIME.USER
(
  USER_KEY bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate key for User entity, uniquely identifies entity inside system.',
  EMAIL varchar(40) NOT NULL COMMENT 'User\'s email',
  PASSWORD varchar(40) NOT NULL COMMENT 'User\'s password',
  SALT varchar(16) NULL COMMENT 'Some additional data',
  CONSTRAINT USER_KEY_PK PRIMARY KEY (USER_KEY)
) COMMENT = 'Table for base User entities';

ALTER TABLE TIME.TIME_TAG ADD (CONSTRAINT USER_KEY_FK FOREIGN KEY (USER_KEY) REFERENCES USER(USER_KEY));
