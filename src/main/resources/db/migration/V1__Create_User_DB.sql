create table if not exists user
(
	id bigint auto_increment
		primary key,
	first_name varchar(255) null,
	last_name varchar(255) null,
	password varchar(255) null
);

