INSERT INTO category (id, name) VALUES (1, 'Catégorie 1');
INSERT INTO category (id, name) VALUES (2, 'Catégorie 2');

INSERT INTO exercise (id, type, categoryId, name, description, measurementUnit, objective, image) VALUES (1, 'PHYSICAL', 1, 'Exercice Physique 1', 'Description exercice physique n°1', 'METER', 'MAXIMUM', 'http://de1.iconarchive.com/download/i61348/majdi-khawaja/kung-fu-panda/Po-3.ico');
INSERT INTO exercise (id, type, categoryId, name, description, measurementUnit, objective, image) VALUES (2, 'PHYSICAL', 1, 'Exo Physique 2', 'La description du physique 2', 'SECOND', 'MINIMUM', 'https://freepngimg.com/download/kung_fu_panda/1-2-kung-fu-panda-fighting-png.png');
INSERT INTO exercise (id, type, categoryId, name, description, image) VALUES (3, 'TAOLU', 2, 'Exercice Taolu 1', 'Voici la description de l exercice Taolu n°1', 'http://www.iconarchive.com/download/i61351/majdi-khawaja/kung-fu-panda/Po.ico');
INSERT INTO exercise (id, type, categoryId, name, description, image) VALUES (4, 'TAOLU', 2, 'Exercice Taolu 2', 'Une description pour l exercice taolu 2', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTSt5xTFwgOJ16PwdkVPNmlRvegjsA2hxFLAwSozFuvnm5uQY7C');
INSERT INTO exercise (id, type, categoryId, name, description, image) VALUES (5, 'FIGHT', 2, 'Exercice Fight 1', 'Description exercice combat 1', 'http://aux4.iconspalace.com/uploads/7798440781491586594.png');
INSERT INTO exercise (id, type, categoryId, name, description, image) VALUES (6, 'FIGHT', 2, 'Exercice Fight 2', 'La description du combat 2', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRW__xUrkOYSKT_Ys07Op6PeaeCdSVAoNCy1P2J8QpxCNbF3VTS');
INSERT INTO exercise (id, type, categoryId, name, description, question, image) VALUES (7, 'THEORETICAL', 2, 'Exercice Theorique', 'La description de l exo','Quelle est la capitale de la Chine ?', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRW__xUrkOYSKT_Ys07Op6PeaeCdSVAoNCy1P2J8QpxCNbF3VTS');

INSERT INTO criteria (id, name) VALUES (1, 'critère 1');
INSERT INTO criteria (id, name) VALUES (2, 'critère 2');
INSERT INTO criteria (id, name) VALUES (3, 'critère 3');
INSERT INTO criteria (id, name) VALUES (4, 'critère 4');

INSERT INTO exercise_criteria (exerciseId, criteriaId) VALUES (3, 1);
INSERT INTO exercise_criteria (exerciseId, criteriaId) VALUES (3, 2);
INSERT INTO exercise_criteria (exerciseId, criteriaId) VALUES (3, 3);
INSERT INTO exercise_criteria (exerciseId, criteriaId) VALUES (3, 4);
INSERT INTO exercise_criteria (exerciseId, criteriaId) VALUES (4, 1);
INSERT INTO exercise_criteria (exerciseId, criteriaId) VALUES (4, 2);

INSERT INTO round (id) VALUES (1);
INSERT INTO round (id) VALUES (2);
INSERT INTO round (id) VALUES (3);

INSERT INTO exercise_round (exerciseId, roundId) VALUES (5, 1);
INSERT INTO exercise_round (exerciseId, roundId) VALUES (5, 2);
INSERT INTO exercise_round (exerciseId, roundId) VALUES (5, 3);
INSERT INTO exercise_round (exerciseId, roundId) VALUES (6, 2);
INSERT INTO exercise_round (exerciseId, roundId) VALUES (6, 3);

INSERT INTO round_criteria (roundId, criteriaId) VALUES (1, 1);
INSERT INTO round_criteria (roundId, criteriaId) VALUES (1, 2);
INSERT INTO round_criteria (roundId, criteriaId) VALUES (1, 3);
INSERT INTO round_criteria (roundId, criteriaId) VALUES (1, 4);
INSERT INTO round_criteria (roundId, criteriaId) VALUES (2, 1);
INSERT INTO round_criteria (roundId, criteriaId) VALUES (2, 2);
INSERT INTO round_criteria (roundId, criteriaId) VALUES (2, 3);
INSERT INTO round_criteria (roundId, criteriaId) VALUES (3, 1);

INSERT INTO program (id, type, position, name, description, image) VALUES (1, 'RANK', 0, 'Petit Panda', 'Une description', 'https://www.searchpng.com/wp-content/uploads/2019/03/kung-fu-Panda-PNG.png');
INSERT INTO program (id, type, position, name, description, image) VALUES (2, 'RANK', 1, 'Grand Tigre', 'Une description', 'https://us.123rf.com/450wm/makstrv/makstrv1604/makstrv160400005/54905547-stock-vector-aggressive-tiger-face-sign-symbol-vector-illustration.jpg?ver=6');
INSERT INTO program (id, type, position, name, description, image) VALUES (3, 'RANK', 2, 'Moyen Dragon', 'Une description', 'https://friendlystock.com/wp-content/uploads/2018/05/9-cute-dragon-breathing-fire-cartoon-clipart.jpg');
INSERT INTO program (id, type, name, description) VALUES (4, 'PROGRAM', 'Programme 1', 'Une description');
INSERT INTO program (id, type, name, description) VALUES (5, 'PROGRAM', 'Programme 2', 'Une description');
INSERT INTO program (id, type, name, description) VALUES (6, 'PROGRAM', 'Programme 3', 'Une description');
INSERT INTO program (id, type, name, description) VALUES (7, 'PROGRAM', 'Programme 4', 'Une description');

INSERT INTO test (id, type, name, date, address, city, postalCode) VALUES (1, 'RANK', 'Test n°1', '2019-06-29 14:00:00', 'Rue Christian Pauc', 'Nantes', '44300');
INSERT INTO test (id, type, programId, name, date, address, city, postalCode) VALUES (2, 'PROGRAM', 5, 'Test n°2', '2019-01-15 08:00:00', 'Rue Christian Pauc', 'Nantes', '44300');
INSERT INTO test (id, type, programId, name, date, address, city, postalCode) VALUES (3, 'PROGRAM', 4, 'Test n°3', '2019-03-01 15:00:00', 'Rue Christian Pauc', 'Nantes', '44300');

INSERT INTO account (id, firstName, lastName, emailAddress, privilege) VALUES (1, 'Ximeng', 'Zhang', 'xz@polytech.com', 'NONE');
INSERT INTO account (id, firstName, lastName, emailAddress, privilege) VALUES (2, 'Tiphaine', 'Besnard', 'tb@polytech.com', 'NONE');
INSERT INTO account (id, firstName, lastName, emailAddress, privilege) VALUES (3, 'Johan', 'Sorette', 'js@polytech.com', 'NONE');
INSERT INTO account (id, firstName, lastName, emailAddress, privilege) VALUES (4, 'François-Régis', 'Jaunatre', 'frj@polytech.com', 'NONE');
INSERT INTO account (id, firstName, lastName, emailAddress, privilege) VALUES (5, 'Matthieu', 'Perreira Da Silva', 'mpds@polytech.com', 'TEACHER');
INSERT INTO account (id, firstName, lastName, emailAddress, privilege) VALUES (6, 'Nassim', 'Berrichi', 'nb@polytech.com', 'TEACHER');

INSERT INTO group_table (id, name) VALUES (1, 'Groupe 1');
INSERT INTO group_table (id, name) VALUES (2, 'Groupe 2');

INSERT INTO member (id, accountId, groupId, rankId, firstName, lastName, emailAddress) VALUES (1, 1, 1, 1, 'Ximeng', 'Zhang', 'xz@polytech.com');
INSERT INTO member (id, accountId, groupId, rankId, firstName, lastName, emailAddress) VALUES (2, 2, 1, 1, 'Tiphaine', 'Besnard', 'tb@polytech.com');
INSERT INTO member (id, accountId, groupId, rankId, firstName, lastName, emailAddress) VALUES (3, 3, 1, 1, 'Johan', 'Sorette', 'js@polytech.com');
INSERT INTO member (id, accountId, groupId, rankId, firstName, lastName, emailAddress) VALUES (4, 4, 2, 1, 'François-Régis', 'Jaunatre', 'frj@polytech.com');
INSERT INTO member (id, accountId, groupId, rankId, firstName, lastName, emailAddress) VALUES (5, 5, 2, 1, 'Matthieu', 'Perreira Da Silva', 'mpds@polytech.com');
INSERT INTO member (id, accountId, groupId, rankId, firstName, lastName, emailAddress) VALUES (6, 6, 2, 1, 'Nassim', 'Berrichi', 'nb@polytech.com');

INSERT INTO test_group (testId, groupId) VAlUES (1, 1);
INSERT INTO test_group (testId, groupId) VAlUES (2, 2);
INSERT INTO test_group (testId, groupId) VAlUES (3, 1);

INSERT INTO roles(name) VALUES('USER');
INSERT INTO roles(name) VALUES('ADMIN');