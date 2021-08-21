-- Remove old rows.

DELETE FROM antenna_type;

INSERT INTO antenna_type (antenna_type_code, date_created, description, name)
VALUES 	('C', NOW(), 'Types an antenna as a container that contains sub-antennas.', 'Container');

INSERT INTO antenna_type (antenna_type_code, date_created, description, name)
VALUES 	('B', NOW(), 'Types an antenna as a base antenna that may contain no or some sub-antennas.', 'Base');

INSERT INTO antenna_type			(antenna_type_code, date_created, description, name)
VALUES 	('S', NOW(), 'Types an antenna as a sub-antenna of a base antenna that contains it.', 'Sub-Antenna');

select * from antenna_type;

-- Remove old rows.

DELETE FROM antenna;	


INSERT INTO antenna (antenna_code,date_created,description,name,main_antenna_code,antenna_type_code)
VALUES	('ANT001', NOW(), 'Base antenna without sub-antennas', 'ANT001-SA1', 'ANT001', 'B');

INSERT INTO antenna (antenna_code,date_created,description,name,main_antenna_code,antenna_type_code)
VALUES	('ANT002', NOW(), 'Base antenna without sub-antennas', 'ANT002-SA2', 'ANT002', 'B');

INSERT INTO antenna (antenna_code,date_created,description,name,main_antenna_code,antenna_type_code)
VALUES	('ANT003', NOW(), 'Base antenna with sub-antennas', 'ANT001-SA3', 'ANT003', 'B');

INSERT INTO antenna (antenna_code,date_created,description,name,main_antenna_code,antenna_type_code)
VALUES	('ANT004', NOW(), 'Sub-antenna of ANT003', 'ANT001-SA4', 'ANT003', 'S');

INSERT INTO antenna (antenna_code,date_created,description,name,main_antenna_code,antenna_type_code)
VALUES	('ANT005', NOW(), 'Sub-antenna of ANT003', 'ANT001-SA5', 'ANT003', 'S');

INSERT INTO antenna (antenna_code,date_created,description,name,main_antenna_code,antenna_type_code)
VALUES	('ANT006', NOW(), 'Container for ANT007', 'ANT001-SA6', 'ANT006', 'C');

INSERT INTO antenna (antenna_code,date_created,description,name,main_antenna_code,antenna_type_code)
VALUES	('ANT007', NOW(), 'Sub-antenna contained in ANT006', 'ANT001-SA7', 'ANT006', 'S');

