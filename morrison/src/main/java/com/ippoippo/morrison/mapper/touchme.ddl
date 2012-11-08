CREATE TABLE TOUCH_ME (
	ID integer not null,
	NAME varchar(128) not null,
	TOUCH boolean NOT NULL DEFAULT true,
	primary key (ID));