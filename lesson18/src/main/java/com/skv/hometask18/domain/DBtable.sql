create table if not exists students(
                                       id int primary key ,
                                       first_name varchar,
                                       second_name varchar,
                                       isman boolean,
                                       city_id int references cities(id) on delete set null
    );
drop table if exists students;
insert into students(id, first_name, second_name, isman, city_id) values (1, 'Sveta', 'Kr.', false, 2),
                                                                         (2, 'Vlad', 'M.', true, 5),
                                                                         (3, 'Nastya', 'K.', false, 1),
                                                                         (4, 'Yana', 'D.', false, 3),
                                                                         (5, 'Ilya', 'K.', true, 1),
                                                                         (6, 'Denis', 'M.', true, 4),
                                                                         (7, 'Alex', 'S', true, 7),
                                                                         (8, 'Sergey', 'M', true, 2),
                                                                         (9, 'Anna', 'L', false, 6),
                                                                         (10, 'Ivan', 'W', true, 3);

create table if not exists cities(
                                     id int primary key ,
                                     name varchar
);
drop table if exists cities;
insert into cities(id, name) values (1, 'Minsk'),
                                    (2, 'Grodno'),
                                    (3, 'Brest'),
                                    (4, 'Vitebsk'),
                                    (5, 'Borisov'),
                                    (6, 'Pinsk'),
                                    (7, 'Lida');