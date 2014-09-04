CREATE SCHEMA `TIME`;

CREATE TABLE TIME.TIME_TAG
(
  TIME_TAG_KEY bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Surrogate key for TimeTag entity, uniquely identifies entity inside system.',
  TIME_TAG_DESC varchar(255) DEFAULT NULL COMMENT 'String description giving more information about Time Tag.',
  TIME_TAG_NAME varchar(255) NOT NULL COMMENT 'Short name of the TimeTag.',
  TIME_TAG_TS datetime NOT NULL COMMENT 'The date and time this tag was created.',
  PRIMARY KEY (TIME_TAG_KEY),
  UNIQUE KEY TIME_TAG_KEY (TIME_TAG_KEY)
) COMMENT = 'Table for the most base entity represents tag of the time with name and description as a string.';
