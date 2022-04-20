create table book (

    id            bigserial  ,
    author_id     bigserial  ,
    genre         varchar(64) ,
    sub_genre     varchar(64) ,
    publisher_id  bigserial    ,
    height        varchar(8)  ,
    created_on    timestamp   ,
    updated_on    timestamp,
    primary key(id)
);

create table author(
  id bigserial             ,
  first_name   varchar(64) ,
  created_on   timestamp   ,
  updated_on   timestamp,
  primary key(id)
);

create table publisher(
  id bigserial             ,
  first_name   varchar(64),
  created_on   timestamp   ,
  updated_on   timestamp,
  primary key(id)
);

alter table book
add constraint FK_books_author_id
foreign key    (author_id)
references  author;

alter table book
add constraint FK_books_publisher_id
foreign key (publisher_id)
references publisher;