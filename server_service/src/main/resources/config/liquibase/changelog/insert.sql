-- liquibase formatted sql

-- changeset abelov:insert_into_passport
insert into passport(id, series, number, expiry_date, authority)
values (1, '1111', '111111', '2021-09-01 00:00:00', 'Ekaterinburg'),
       (2, '2222', '222222', '2021-10-01 00:00:00', 'Ekaterinburg'),
       (3, '3333', '333333', '2021-11-01 00:00:00', 'Ekaterinburg'),
       (4, '4444', '444444', '2021-12-01 00:00:00', 'Ekaterinburg'),
       (5, '5555', '555555', '2022-01-01 00:00:00', 'Ekaterinburg'),
       (6, '6666', '666666', '2022-02-01 00:00:00', 'Ekaterinburg'),
       (7, '7777', '777777', '2022-03-01 00:00:00', 'Ekaterinburg'),
       (8, '8888', '888888', '2022-04-01 00:00:00', 'Ekaterinburg')