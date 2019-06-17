delete
from costume;

delete
from armor;

delete
from store;

----------------------------------------------------------------------

INSERT INTO costume (name_costume, max_count_armor, type, status)
VALUES ('MARK1', 2, 'WARRIOR', 'RELEASE');

INSERT INTO costume (name_costume, max_count_armor, type, status)
VALUES ('MARK2', 3, 'WARRIOR', 'RELEASE');

INSERT INTO costume (name_costume, max_count_armor, type, status)
VALUES ('MARK3', 3, 'WARRIOR', 'RELEASE');

----------------------------------------------------------------------

INSERT INTO armor (id_costume, name_armor, artifact, unit_max)
VALUES ((SELECT id FROM costume WHERE name_costume = 'MARK1'), 'servo', 'power increase', 5);

INSERT INTO armor (id_costume, name_armor, artifact, unit_max)
VALUES ((SELECT id FROM costume WHERE name_costume = 'MARK1'), 'armor', 'health increase', 10);


----------------------------------------------------------------------

INSERT INTO store (id_armor, left_amount)
VALUES ((SELECT id FROM armor WHERE name_armor = 'servo'), 500);