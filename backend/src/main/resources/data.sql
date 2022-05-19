
INSERT INTO WIZARDS (ID, firstname, lastname, house, username) VALUES(1, 'Harry', 'Potter', 'Gryffindor', 'hpotter1980');
INSERT INTO WIZARDS (ID, firstname, lastname, house, username) VALUES(2, 'Ronald', 'Weasley', 'Gryffindor', 'rweasley1980');
INSERT INTO WIZARDS (ID, firstname, lastname, house, username) VALUES(3, 'Hermione', 'Granger', 'Gryffindor', 'hgranger1980');
INSERT INTO WIZARDS (ID, firstname, lastname, house, username) VALUES(4, 'Filius', 'Flitwick', 'Ravenclaw', 'fflitwickT');
INSERT INTO WIZARDS (ID, firstname, lastname, house, username) VALUES(5, 'Pomona', 'Sprout', 'Hufflepuff', 'psproutT');
INSERT INTO WIZARDS (ID, firstname, lastname, house, username) VALUES(6, 'Minvera', 'McGonagall', 'Gryffindor', 'mmcgonagallT');
INSERT INTO WIZARDS (ID, firstname, lastname, house, username) VALUES(7, 'Severus', 'Snape', 'Slytherin', 'ssnapeT');


INSERT INTO ROOMS (id, name) VALUES (1, 'Gryffindor Common Room');
INSERT INTO ROOMS (id, name) VALUES (2, 'Hufflepuff Common Room');
INSERT INTO ROOMS (id, name) VALUES (3, 'Slytherin Common Room');
INSERT INTO ROOMS (id, name) VALUES (4, 'Ravenclaw Common Room');

INSERT INTO WIZARDS_ROOMS (room_id, wizard_id) VALUES (1, 1);
INSERT INTO WIZARDS_ROOMS (room_id, wizard_id) VALUES (1, 2);
INSERT INTO WIZARDS_ROOMS (room_id, wizard_id) VALUES (1, 3);
INSERT INTO WIZARDS_ROOMS (room_id, wizard_id) VALUES (1, 6);
INSERT INTO WIZARDS_ROOMS (room_id, wizard_id) VALUES (2, 5);
INSERT INTO WIZARDS_ROOMS (room_id, wizard_id) VALUES (3, 7);
INSERT INTO WIZARDS_ROOMS (room_id, wizard_id) VALUES (4, 4);