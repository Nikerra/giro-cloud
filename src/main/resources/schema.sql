create table if not exists Giro_Order (
    id identity,
    delivery_Name varchar(50) not null,
    delivery_Street varchar(50) not null,
    delivery_City varchar(50) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_cvv varchar(3) not null,
    placed_at timestamp not null);

create table if not exists Giro (
    id identity,
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

alter table Giro
    add foreign key (giro_order) references  Giro_Order(id);

alter table Ingredient_Ref
    add foreign key (ingredient) references  Ingredient(id);
