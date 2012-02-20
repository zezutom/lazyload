drop table addresses if exists;
create table addresses (
    id bigint not null,
	street varchar(255),
	city varchar(255),
	zip_code varchar(255),
	person_id bigint not null,
    primary key (id)
);

drop table people if exists;
create table people (
    id bigint not null,
    first_name varchar(255),
    last_name varchar(255),
    primary key (id)
);

alter table addresses 
	add constraint person_fk 
    foreign key (person_id) 
    references people;

delete from addresses;
delete from people;

insert into people (id, first_name, last_name) values (1, 'John', 'Doe');
insert into people (id, first_name, last_name) values (2, 'Mary', 'Adams');
insert into people (id, first_name, last_name) values (3, 'Peter', 'Smith');

insert into addresses(id, street, city, zip_code, person_id) values (1, 'Street One', 'London',    'OWAFEWFEW', 1);
insert into addresses(id, street, city, zip_code, person_id) values (2, 'Street Two', 'Birmingham', 'AFILWFEWE', 1);
insert into addresses(id, street, city, zip_code, person_id) values (3, 'Street Three', 'Liverpool', 'WAFEIWEWE', 1);
insert into addresses(id, street, city, zip_code, person_id) values (4, 'Street Four', 'Edinburgh',    'AFAEWEEFW', 2);
insert into addresses(id, street, city, zip_code, person_id) values (5, 'Street Five', 'Glasgow',    'WEWFWEEEW', 2);
insert into addresses(id, street, city, zip_code, person_id) values (6, 'Street Six', 'Leeds', 'WAFEIWEWE', 3);