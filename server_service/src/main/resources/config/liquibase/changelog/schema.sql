-- liquibase formatted sql

-- changeset abelov:create_table_passport
create table passport
(
    id int primary key not null auto_increment,
    series int not null,
    number int not null,
    expiry_date timestamp not null,
    authority varchar(50) not null
);
-- rollback drop table passport;

