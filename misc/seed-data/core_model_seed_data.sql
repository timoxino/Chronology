-- Cleaning
DELETE FROM TIME.TIME_TAG;

-- Populating
INSERT INTO TIME.TIME_TAG (LST_UPDT_TS, TIME_TAG_DESC, TIME_TAG_NAME, TIME_TAG_TS) VALUES (STR_TO_DATE('12/8/12 8:00', '%m/%d/%y %H:%i'),'Woke up', 'first', STR_TO_DATE('12/8/12 8:00', '%m/%d/%y %H:%i'));
INSERT INTO TIME.TIME_TAG (LST_UPDT_TS, TIME_TAG_DESC, TIME_TAG_NAME, TIME_TAG_TS) VALUES (STR_TO_DATE('12/8/12 8:05', '%m/%d/%y %H:%i'),'Stand up', 'managed', STR_TO_DATE('12/8/12 8:05', '%m/%d/%y %H:%i'));
INSERT INTO TIME.TIME_TAG (LST_UPDT_TS, TIME_TAG_DESC, TIME_TAG_NAME, TIME_TAG_TS) VALUES (STR_TO_DATE('12/8/12 8:30', '%m/%d/%y %H:%i'),'Have a breakfast', 'eat', STR_TO_DATE('12/8/12 8:30', '%m/%d/%y %H:%i'));
INSERT INTO TIME.TIME_TAG (LST_UPDT_TS, TIME_TAG_DESC, TIME_TAG_NAME, TIME_TAG_TS) VALUES (STR_TO_DATE('12/8/12 9:00', '%m/%d/%y %H:%i'),'Went to work', 'on the way', STR_TO_DATE('12/8/12 9:00', '%m/%d/%y %H:%i'));
INSERT INTO TIME.TIME_TAG (LST_UPDT_TS, TIME_TAG_DESC, TIME_TAG_NAME, TIME_TAG_TS) VALUES (STR_TO_DATE('12/8/12 9:30', '%m/%d/%y %H:%i'),'Arrived at work', 'let\'s start', STR_TO_DATE('12/8/12 9:30', '%m/%d/%y %H:%i'));
INSERT INTO TIME.TIME_TAG (LST_UPDT_TS, TIME_TAG_DESC, TIME_TAG_NAME, TIME_TAG_TS) VALUES (STR_TO_DATE('12/8/12 12:30', '%m/%d/%y %H:%i'),'Have a lunch', 'eat again', STR_TO_DATE('12/8/12 12:30', '%m/%d/%y %H:%i'));

