

 create table author(
  id bigserial             not null ,
  book_id bigserial        not null ,
  first_name   varchar(64) not null ,
  created_on   timestamp   not null ,
  updated_on   timestamp   not null ,
  primary key(id)
  );

create table publisher(
  id bigserial             not null  ,
  book_id bigserial        not null  ,
  first_name   varchar(64) not null  ,
  created_on   timestamp   not null  ,
  updated_on   timestamp   not null  ,
  primary key(id)
);

create table book (
    id            bigserial   not null ,
    author_id     bigserial   not null ,
    genre         varchar(64) not null ,
    sub_genre     varchar(64) not null ,
    publisher_id  bigserial   not null ,
    height        varchar(8)  not null ,
    created_on    timestamp   not null ,
    updated_on    timestamp   not null ,
    primary key(id)
);


alter table book
add constraint FK_books_author_id
foreign key    (author_id)
references     author;

alter table book
add constraint FK_books_publisher_id
foreign key    (publisher_id)
references     publisher;

alter table author
add constraint FK_authors_book_id
foreign  key  (book_id)
references     book;

alter table publisher
add constraint FK_publishers_book_id
foreign  key   (book_id)
references      book;
