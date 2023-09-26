create schema "giro-cloud";
SET search_path to "giro-cloud";

create table if not exists Giro_Order (
    id bigserial primary key,
    delivery_Name varchar(50) not null,
    delivery_Street varchar(50) not null,
    delivery_City varchar(50) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_cvv varchar(3) not null,
    placed_at timestamp not null);

create table if not exists Giro (
    id bigserial primary key,
    name varchar(50) not null,
    giro_order bigint not null,
    giro_order_key bigint not null,
    created_at timestamp not null);

create table if not exists Ingredient_Ref (
    ingredient varchar(4) not null primary key,
    giro bigint not null,
    giro_key bigint not null);

create table if not exists Ingredient (
    id varchar(4) not null primary key,
    name varchar(25) not null,
    type varchar(10) not null);


create table if not exists users (
    id bigserial primary key,
    username varchar,
    password varchar,
    fullname varchar,
    street varchar,
    city varchar,
    phonenumber varchar);
insert into users (username, password, fullname, street, city,phonenumber)
values ('admin','$2a$12$WA/Xd/DU/VaIkopWmF61xelxAIFPNka13EWeE.UEvntR2Zs1eDKr6',
        'admin', 'lenina', 'pyatigorsk','88008008080');

insert into Ingredient(id,name,type)
                    values ( 'FLPI', 'Flour Pita', 'WRAP');
                    ( 'COPI', 'Corn Pita', 'WRAP');
                    ( 'GRCH', 'Ground Chicken', 'PROTEIN');
                    ( 'CHIC', 'Chicken', 'PROTEIN');
                    ( 'SLTO', 'Sliced Tomatoes', 'VEGGIES');
                    ( 'SLCU', 'Sliced Cucumber', 'VEGGIES');
                    ( 'BRCH', 'Brynza cheese', 'CHEESE');
                    ( 'PACH', 'Parmesan cheese', 'CHEESE');
                    ( 'SOCR', 'Sour Cream', 'SAUCE');
                    ( 'TZSA', 'Tzatziki sauce', 'SAUCE');


alter table Giro
    add foreign key (giro_order) references  Giro_Order(id);

alter table Ingredient_Ref
    add foreign key (ingredient) references  Ingredient(id);

