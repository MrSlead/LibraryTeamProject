
alter table if exists book
drop constraint if exists FKmrhfp9wfi5dy4bwl87bx8ivua;


alter table if exists lnk_book_author
drop constraint if exists FK9gihjage8hs51wgw6s118mn92;


alter table if exists lnk_book_author
drop constraint if exists FKr7c7iwsbkamrbnxm5l4j5elf5;


alter table if exists lnk_book_genre
drop constraint if exists FKkp3b8w2uow4pa9122isx7qcb9;


alter table if exists lnk_book_genre
drop constraint if exists FKgaq5shd4lcvbpxcxr9vjr1i1m;


drop table if exists author cascade;

drop table if exists book cascade;

drop table if exists client cascade;

drop table if exists genre cascade;

drop table if exists language cascade;

drop table if exists lnk_book_author cascade;

drop table if exists lnk_book_genre cascade;

drop sequence if exists author_seq;

drop sequence if exists book_seq;

drop sequence if exists genre_seq;

drop sequence if exists language_seq;

drop sequence if exists client_seq;

create sequence author_seq start 1 increment 1;
create sequence book_seq start 1 increment 1;
create sequence genre_seq start 1 increment 1;
create sequence language_seq start 1 increment 1;
create sequence client_seq start 3 increment 1;


create table author (
                        id int8 not null,
                        name varchar(255),
                        patronymic varchar(255),
                        surname varchar(255),
                        primary key (id)
);
create table book (
                      id int8 not null,
                      date_of_publication timestamp,
                      name varchar(255),
                      number_of_pages int4 not null,
                      language_id int8,
                      primary key (id)
);
create table client (
                        id int8 not null,
                        login varchar(255),
                        email varchar(255),
                        password varchar(255),
                        role varchar(255),
                        primary key (id)
);
create table genre (
                       id int8 not null,
                       name varchar(255),
                       primary key (id)
);
create table language (
                          id int8 not null,
                          name varchar(255),
                          primary key (id)
);
create table lnk_book_author (
                                 author_id int8 not null,
                                 book_id int8 not null,
                                 primary key (author_id, book_id)
);
create table lnk_book_genre (
                                book_id int8 not null,
                                genre_id int8 not null,
                                primary key (book_id, genre_id)
);

alter table if exists book
    add constraint FKmrhfp9wfi5dy4bwl87bx8ivua
    foreign key (language_id)
    references language;

alter table if exists lnk_book_author
    add constraint FK9gihjage8hs51wgw6s118mn92
    foreign key (author_id)
    references author;

alter table if exists lnk_book_author
    add constraint FKr7c7iwsbkamrbnxm5l4j5elf5
    foreign key (book_id)
    references book;

alter table if exists lnk_book_genre
    add constraint FKkp3b8w2uow4pa9122isx7qcb9
    foreign key (book_id)
    references book;

alter table if exists lnk_book_genre
    add constraint FKgaq5shd4lcvbpxcxr9vjr1i1m
    foreign key (genre_id)
    references genre;