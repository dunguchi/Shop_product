drop database if exists shop_dunguchi;

create database if not exists shop_dunguchi;
use shop_dunguchi;

create table role(
	id bigint primary key auto_increment,
    role_name varchar(255)
);

create table user(
	id bigint primary key auto_increment,
    username varchar(255) unique not null,
    password varchar(255) not null,
    email varchar(255) unique not null,
    full_name varchar(255),
    avatar_url varchar(255),
    address varchar(255),
    is_active bit
);
create table user_role(
	user_id bigint,
    role_id bigint,
    constraint pk_user_role primary key(user_id, role_id),
    constraint fk_user_role_user foreign key(user_id) references user(id),
    constraint fk_user_role_role foreign key(role_id) references role(id)
);

create table menu(
	id bigint primary key auto_increment,
    title varchar(255) unique not null,
    parent_id bigint,
    link_url varchar(255) unique not null,
    create_by bigint(255),
    constraint fk_create_by_user foreign key(create_by) references user(id)
);

create table product(
	id bigint primary key auto_increment,
    product_name varchar(255) unique not null,
    price bigint not null,
    image varchar(255) not null,
    category_id bigint(255),
	created_date date,
    edited_date date,
    constraint fk_category_id foreign key(category_id) references menu(id)
);


