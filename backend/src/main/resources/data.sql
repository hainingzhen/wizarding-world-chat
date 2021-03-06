DELETE FROM WIZARDS_ROOMS;
DELETE FROM ROOMS;
DELETE FROM WIZARDS;

ALTER SEQUENCE WIZARDS_ID_SEQ RESTART WITH 1;
ALTER SEQUENCE ROOMS_ID_SEQ RESTART WITH 1;
ALTER SEQUENCE MESSAGES_ID_SEQ WITH 1;
ALTER SEQUENCE WIZARDS_ROOMS_ID_SEQ WITH 1;

INSERT INTO WIZARDS (firstname, lastname, house, username) VALUES('Harry', 'Potter', 'Gryffindor', 'hpotter1980');
INSERT INTO WIZARDS (firstname, lastname, house, username) VALUES('Ronald', 'Weasley', 'Gryffindor', 'rweasley1980');
INSERT INTO WIZARDS (firstname, lastname, house, username) VALUES('Hermione', 'Granger', 'Gryffindor', 'hgranger1980');
INSERT INTO WIZARDS (firstname, lastname, house, username) VALUES('Filius', 'Flitwick', 'Ravenclaw', 'fflitwickT');
INSERT INTO WIZARDS (firstname, lastname, house, username) VALUES('Pomona', 'Sprout', 'Hufflepuff', 'psproutT');
INSERT INTO WIZARDS (firstname, lastname, house, username) VALUES('Minvera', 'McGonagall', 'Gryffindor', 'mmcgonagallT');
INSERT INTO WIZARDS (firstname, lastname, house, username) VALUES('Severus', 'Snape', 'Slytherin', 'ssnapeT');


INSERT INTO ROOMS (name) VALUES ('Gryffindor Common Room');
INSERT INTO ROOMS (name) VALUES ('Hufflepuff Common Room');
INSERT INTO ROOMS (name) VALUES ('Slytherin Common Room');
INSERT INTO ROOMS (name) VALUES ('Ravenclaw Common Room');


INSERT INTO WIZARDS_ROOMS (room_id, wizard_id, left_room) VALUES (1, 1, FALSE);
INSERT INTO WIZARDS_ROOMS (room_id, wizard_id, left_room) VALUES (1, 2, FALSE);
INSERT INTO WIZARDS_ROOMS (room_id, wizard_id, left_room) VALUES (1, 3, FALSE);
INSERT INTO WIZARDS_ROOMS (room_id, wizard_id, left_room) VALUES (1, 6, FALSE);
INSERT INTO WIZARDS_ROOMS (room_id, wizard_id, left_room) VALUES (2, 5, FALSE);
INSERT INTO WIZARDS_ROOMS (room_id, wizard_id, left_room) VALUES (3, 7, FALSE);
INSERT INTO WIZARDS_ROOMS (room_id, wizard_id, left_room) VALUES (4, 4, FALSE);


