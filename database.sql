
CREATE TABLE "PROPERTY" (
	`id_property`	INTEGER,
	`avg_tree_height`	INTEGER,
	`area`	INTEGER,
	`name`	TEXT,
	`visit_count`	INTEGER,
	`last_drone_inspection`	TEXT,
	`soil_quality`	TEXT,
	PRIMARY KEY(`id_property`)
);
INSERT INTO `PROPERTY` VALUES (1,10,100,'property1',10,'01-01-2017','good');
INSERT INTO `PROPERTY` VALUES (2,20,200,'property2',20,'02-02-2017','medium');
INSERT INTO `PROPERTY` VALUES (3,30,300,'property3',30,'03-03-2017','bad');

