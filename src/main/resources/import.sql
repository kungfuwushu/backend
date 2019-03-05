INSERT INTO category (id, name) VALUES (1, 'Catégorie 1');
INSERT INTO category (id, name) VALUES (2, 'Catégorie 2');

INSERT INTO exercise (id, dtype, type, categoryId, name, description, measurementUnit, objective, image) VALUES (1, 'PHYSICAL', 'PHYSICAL', 1, 'Exo Physique 1', 'Petite description', 'METER', 'MAXIMUM', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeAgs19U6GP04mttvxSAKmc_631I2zOjCHkGmtUnYsXt0Ze582hA');
INSERT INTO exercise (id, dtype, type, categoryId, name, description, measurementUnit, objective, image) VALUES (2, 'PHYSICAL', 'PHYSICAL', 1, 'Exo Physique 2', 'Une description', 'SECOND', 'MINIMUM', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeAgs19U6GP04mttvxSAKmc_631I2zOjCHkGmtUnYsXt0Ze582hA');
INSERT INTO exercise (id, dtype, type, categoryId, name, description, image) VALUES (3, 'TAOLU', 'TAOLU', 2, 'Exo Taolu 1', 'Une description', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeAgs19U6GP04mttvxSAKmc_631I2zOjCHkGmtUnYsXt0Ze582hA');
INSERT INTO exercise (id, dtype, type, categoryId, name, description, image) VALUES (4, 'TAOLU', 'TAOLU', 2, 'Exo Taolu 2', 'Une description', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeAgs19U6GP04mttvxSAKmc_631I2zOjCHkGmtUnYsXt0Ze582hA');
INSERT INTO exercise (id, dtype, type, categoryId, name, description, image) VALUES (5, 'FIGHT', 'FIGHT', 2, 'Exo Fight 1', 'Une description', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeAgs19U6GP04mttvxSAKmc_631I2zOjCHkGmtUnYsXt0Ze582hA');
INSERT INTO exercise (id, dtype, type, categoryId, name, description, image) VALUES (6, 'FIGHT', 'FIGHT', 2, 'Exo Fight 2', 'Une description', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeAgs19U6GP04mttvxSAKmc_631I2zOjCHkGmtUnYsXt0Ze582hA');

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

INSERT INTO rank (id, name, description, maximumScore, image) VALUES (1, 'Petit Panda', 'Une description', 100, 'https://i1.wp.com/www.getbeautified.com/wp-content/uploads/2018/07/How-to-Draw-a-Cartoon-Panda-21.png?fit=591%2C520&ssl=1');
INSERT INTO rank (id, name, description, maximumScore, image) VALUES (2, 'Grand Tigre', 'Une description', 70, 'https://us.123rf.com/450wm/makstrv/makstrv1604/makstrv160400005/54905547-stock-vector-aggressive-tiger-face-sign-symbol-vector-illustration.jpg?ver=6');
INSERT INTO rank (id, name, description, maximumScore, image) VALUES (3, 'Moyen Dragon', 'Une description', 150, 'https://friendlystock.com/wp-content/uploads/2018/05/9-cute-dragon-breathing-fire-cartoon-clipart.jpg');

INSERT INTO rankExercise (id, dtype, rankId, exerciseId, coefficient) VALUES (1, 'TAOLU', 1, 3, 0.5);
INSERT INTO rankExercise (id, dtype, rankId, exerciseId, coefficient) VALUES (2, 'TAOLU', 1, 4, 1.5);
INSERT INTO rankExercise (id, dtype, rankId, exerciseId, coefficient) VALUES (3, 'PHYSICAL', 1, 1, 2.5);
INSERT INTO rankExercise (id, dtype, rankId, exerciseId, coefficient) VALUES (4, 'PHYSICAL', 1, 2, 1.0);
INSERT INTO rankExercise (id, dtype, rankId, exerciseId, coefficient) VALUES (5, 'FIGHT', 1, 5, 2.5);
INSERT INTO rankExercise (id, dtype, rankId, exerciseId, coefficient) VALUES (6, 'FIGHT', 1, 6, 1.0);

INSERT INTO rankCriteria (id, criteriaId, maximumScore, rankExerciseId) VALUES (1, 1, 5, 1);
INSERT INTO rankCriteria (id, criteriaId, maximumScore, rankExerciseId) VALUES (2, 2, 10, 1);
INSERT INTO rankCriteria (id, criteriaId, maximumScore, rankExerciseId) VALUES (3, 3, 3, 1);
INSERT INTO rankCriteria (id, criteriaId, maximumScore, rankExerciseId) VALUES (4, 4, 4, 1);
INSERT INTO rankCriteria (id, criteriaId, maximumScore, rankExerciseId) VALUES (5, 1, 5, 2);
INSERT INTO rankCriteria (id, criteriaId, maximumScore, rankExerciseId) VALUES (6, 2, 10, 2);

INSERT INTO rankRound (id, roundId, rankExerciseId) VALUES (1, 1, 5);
INSERT INTO rankRound (id, roundId, rankExerciseId) VALUES (2, 2, 5);
INSERT INTO rankRound (id, roundId, rankExerciseId) VALUES (3, 3, 5);
INSERT INTO rankRound (id, roundId, rankExerciseId) VALUES (4, 2, 6);
INSERT INTO rankRound (id, roundId, rankExerciseId) VALUES (5, 3, 6);

INSERT INTO rankCriteria (id, criteriaId, maximumScore, rankRoundId) VALUES (7, 1, 5, 1);
INSERT INTO rankCriteria (id, criteriaId, maximumScore, rankRoundId) VALUES (8, 2, 10, 1);
INSERT INTO rankCriteria (id, criteriaId, maximumScore, rankRoundId) VALUES (9, 3, 3, 1);
INSERT INTO rankCriteria (id, criteriaId, maximumScore, rankRoundId) VALUES (10, 4, 4, 1);
INSERT INTO rankCriteria (id, criteriaId, maximumScore, rankRoundId) VALUES (11, 1, 5, 2);
INSERT INTO rankCriteria (id, criteriaId, maximumScore, rankRoundId) VALUES (12, 2, 10, 2);
INSERT INTO rankCriteria (id, criteriaId, maximumScore, rankRoundId) VALUES (13, 3, 3, 2);
INSERT INTO rankCriteria (id, criteriaId, maximumScore, rankRoundId) VALUES (14, 1, 5, 3);
INSERT INTO rankCriteria (id, criteriaId, maximumScore, rankRoundId) VALUES (15, 1, 5, 4);
INSERT INTO rankCriteria (id, criteriaId, maximumScore, rankRoundId) VALUES (16, 2, 10, 4);
INSERT INTO rankCriteria (id, criteriaId, maximumScore, rankRoundId) VALUES (17, 3, 3, 4);
INSERT INTO rankCriteria (id, criteriaId, maximumScore, rankRoundId) VALUES (18, 1, 5, 5);

INSERT INTO evaluation (id, name, date, address, city, postalCode, type) VALUES (1, 'Evaluation n°1', '2019-06-01', 'Rue Christian Pauc', 'Nantes', '44300', 'RANK');
INSERT INTO evaluation (id, name, date, address, city, postalCode, type) VALUES (2, 'Evaluation n°2', '2019-01-01', 'Rue Christian Pauc', 'Nantes', '44300', 'OTHER');
INSERT INTO evaluation (id, name, date, address, city, postalCode, type) VALUES (3, 'Evaluation n°3', '2019-03-01', 'Rue Christian Pauc', 'Nantes', '44300', 'OTHER');

INSERT INTO evaluation_exercise (evaluationId, exerciseId) VALUES (1, 1);
INSERT INTO evaluation_exercise (evaluationId, exerciseId) VALUES (1, 2);
INSERT INTO evaluation_exercise (evaluationId, exerciseId) VALUES (1, 3);
INSERT INTO evaluation_exercise (evaluationId, exerciseId) VALUES (1, 4);
INSERT INTO evaluation_exercise (evaluationId, exerciseId) VALUES (1, 5);
INSERT INTO evaluation_exercise (evaluationId, exerciseId) VALUES (1, 6);
INSERT INTO evaluation_exercise (evaluationId, exerciseId) VALUES (2, 1);
INSERT INTO evaluation_exercise (evaluationId, exerciseId) VALUES (3, 2);

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

INSERT INTO evaluation_group (evaluationId, groupId) VAlUES (1, 1);
INSERT INTO evaluation_group (evaluationId, groupId) VAlUES (2, 2);
INSERT INTO evaluation_group (evaluationId, groupId) VAlUES (3, 1);