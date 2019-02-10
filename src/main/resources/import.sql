INSERT INTO category (id, name) VALUES (1, 'Catégorie 1');
INSERT INTO category (id, name) VALUES (2, 'Catégorie 2');

INSERT INTO exercise (id, dtype, type, categoryId, name, description, measurementUnit, objective, image) VALUES (1, 'PHYSICAL', 'PHYSICAL', 1, 'Exo Physique 1', 'Petite description', 'METER', 'MAXIMUM', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeAgs19U6GP04mttvxSAKmc_631I2zOjCHkGmtUnYsXt0Ze582hA');
INSERT INTO exercise (id, dtype, type, categoryId, name, description, measurementUnit, objective, image) VALUES (2, 'PHYSICAL', 'PHYSICAL', 1, 'Exo Physique 2', 'Une description', 'SECOND', 'MINIMUM', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeAgs19U6GP04mttvxSAKmc_631I2zOjCHkGmtUnYsXt0Ze582hA');
INSERT INTO exercise (id, dtype, type, categoryId, name, description, image) VALUES (3, 'TAOLU', 'TAOLU', 2, 'Exo Taolu 1', 'Une description', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeAgs19U6GP04mttvxSAKmc_631I2zOjCHkGmtUnYsXt0Ze582hA');
INSERT INTO exercise (id, dtype, type, categoryId, name, description, image) VALUES (4, 'TAOLU', 'TAOLU', 2, 'Exo Taolu 2', 'Une description', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeAgs19U6GP04mttvxSAKmc_631I2zOjCHkGmtUnYsXt0Ze582hA');

INSERT INTO criteria (id, exerciseId, name) VALUES (1, 3, 'critère 1');
INSERT INTO criteria (id, exerciseId, name) VALUES (2, 3, 'critère 2');
INSERT INTO criteria (id, exerciseId, name) VALUES (3, 3, 'critère 3');
INSERT INTO criteria (id, exerciseId, name) VALUES (4, 3, 'critère 4');
INSERT INTO criteria (id, exerciseId, name) VALUES (5, 4, 'critère 1');
INSERT INTO criteria (id, exerciseId, name) VALUES (6, 4, 'critère 2');

INSERT INTO rank (id, name, description, maximumScore) VALUES (1, 'Grade 1', 'Une description', 100);
INSERT INTO rank (id, name, description, maximumScore) VALUES (2, 'Grade 2', 'Une description', 70);
INSERT INTO rank (id, name, description, maximumScore) VALUES (3, 'Grade 3', 'Une description', 150);

INSERT INTO rankExercise (id, dtype, rankId, exerciseId, coefficient) VALUES (1, 'TAOLU', 1, 3, 0.5);
INSERT INTO rankExercise (id, dtype, rankId, exerciseId, coefficient) VALUES (2, 'TAOLU', 1, 4, 1.5);
INSERT INTO rankExercise (id, dtype, rankId, exerciseId, coefficient) VALUES (3, 'PHYSICAL', 1, 1, 2.5);
INSERT INTO rankExercise (id, dtype, rankId, exerciseId, coefficient) VALUES (4, 'PHYSICAL', 1, 2, 1.0);

INSERT INTO rankCriteria (id, criteriaId, rankExerciseId, maximumScore) VALUES (1, 1, 1, 5);
INSERT INTO rankCriteria (id, criteriaId, rankExerciseId, maximumScore) VALUES (2, 2, 1, 10);
INSERT INTO rankCriteria (id, criteriaId, rankExerciseId, maximumScore) VALUES (3, 3, 1, 3);
INSERT INTO rankCriteria (id, criteriaId, rankExerciseId, maximumScore) VALUES (4, 4, 1, 4);
INSERT INTO rankCriteria (id, criteriaId, rankExerciseId, maximumScore) VALUES (5, 5, 2, 7);
INSERT INTO rankCriteria (id, criteriaId, rankExerciseId, maximumScore) VALUES (6, 6, 2, 5);

INSERT INTO evaluation (id, date, address, city, postalCode) VALUES (1, '2019-01-30', 'Rue Christian Pauc', 'Nantes', '44300');

INSERT INTO evaluation_exercise (evaluationId, exerciseId, exerciseOrder) VALUES (1, 1, 0);
INSERT INTO evaluation_exercise (evaluationId, exerciseId, exerciseOrder) VALUES (1, 2, 1);
INSERT INTO evaluation_exercise (evaluationId, exerciseId, exerciseOrder) VALUES (1, 3, 2);
INSERT INTO evaluation_exercise (evaluationId, exerciseId, exerciseOrder) VALUES (1, 4, 3);

INSERT INTO account (id, firstName, lastName, emailAddress, privilege) VALUES (1, 'Ximeng', 'Zhang', 'xz@polytech.com', 'NONE'), ;
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

INSERT INTO evaluation_group (evaluationId, groupId, groupOrder) VAlUES (1, 1, 0);