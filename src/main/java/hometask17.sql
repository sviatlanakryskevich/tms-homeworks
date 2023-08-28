create table if not exists persons(
                                      id int primary key,
                                      name varchar,
                                      isMan boolean,
                                      birthday date
);
drop table if exists persons;

insert into persons(id, name, isMan, birthday) values (1, 'Ivan', true, '1983-12-09'),
                                                      (2, 'Anna', false, '1995-04-02'),
                                                      (3, 'Yana', false, '1979-03-11'),
                                                      (4, 'Alex', true, '1999-01-10'),
                                                      (5, 'Ilya', true, '1990-10-28'),
                                                      (6, 'Alina', false, '1993-05-13'),
                                                      (7, 'Sergey', true, '1984-01-12'),
                                                      (8, 'Ivan', true, '1987-06-10'),
                                                      (9, 'Denis', true, '1976-07-18'),
                                                      (10, 'Diana', false, '1991-11-30');

create table if not exists hobby(
                                    id int primary key,
                                    name varchar,
                                    type int constraint fk_types references type_of_hobby(id)
    );
drop table if exists hobby;

insert into hobby(id, name, type) values (1, 'hockey', 1),
                                         (2, 'reading', 2),
                                         (3, 'swimming', 1),
                                         (4, 'painting', 2),
                                         (5, 'hiking', 1),
                                         (6, 'singing', 2),
                                         (7, 'skating', 1),
                                         (8, 'diving', 1);

create table if not exists type_of_hobby(
                                            id int primary key,
                                            name varchar
);
drop table if exists type_of_hobby;

insert into type_of_hobby(id, name) values (1, 'active'),
                                           (2, 'passive');

create table if not exists person_hobby(
                                           id int primary key,
                                           person_id int constraint fk_person references persons (id),
    hobby_id int constraint fk_hobby references hobby (id)
    );
drop table if exists person_hobby;

insert into person_hobby(id, person_id, hobby_id) values (1, 1, 2),
                                                         (2, 2, 5),
                                                         (3, 2, 6),
                                                         (4, 3, 4),
                                                         (5, 4, 3),
                                                         (6, 4, 2),
                                                         (7, 5, 1),
                                                         (8, 6, 7),
                                                         (9, 7, 8),
                                                         (10, 7, 5),
                                                         (11, 8, 1),
                                                         (12, 9, 3),
                                                         (13, 10, 7),
                                                         (14, 10, 4);

select * from persons p join person_hobby ph on p.id = ph.person_id
                        join hobby h on  h.id = ph.hobby_id;
--• Вывести всех людей старше какого-либо возраста
select * from persons where birthday < '1991-04-26';
--• Вывести сколько людей каждого пола есть в бд
select isMan, count(*) from persons group by isMan;
--	• Вывести информацию о людях и их хобби
select p.id, p.name as person, p.isMan, p.birthday, h.name as hobby, toh.name as type from persons p
   join person_hobby ph on p.id = ph.person_id join hobby h on  h.id = ph.hobby_id join type_of_hobby toh on toh.id = h.type;
--	• Вывести список людей у которых более одного хобби
select p.name, count(*) as count_hobby from persons p join person_hobby ph on p.id = ph.person_id join hobby h on  h.id = ph.hobby_id
group by p.id having count(*) > 1;
--	• Вывести какое количество активных хобби и пассивных хобби есть в бд
select toh.name as type, count(*) from hobby join type_of_hobby toh on toh.id = hobby.type group by toh.name;
--	• Вывести информацию какое хобби активное а какое пассивное
select hobby.name as hobby, toh.name as type from hobby join type_of_hobby toh on toh.id = hobby.type group by hobby.name, toh.name;