insert into author(id, name) values(1, 'Robert Schulz');
insert into author(id, name) values(2, 'Harold Lewis');
insert into author(id, name) values(3, 'Juan Ignacio Ibarra');

insert into book(id, title) values(1, 'Spring Data Jpa');
insert into book(id, title) values(2, 'Spring Hibernate');
insert into book(id, title) values(3, 'Spring Mobile');

insert into author_books(authors_id, books_id) VALUES(1, 1);
insert into author_books(authors_id, books_id) VALUES(1, 2);
insert into author_books(authors_id, books_id) VALUES(2, 3);
insert into author_books(authors_id, books_id) VALUES(3, 1);
insert into author_books(authors_id, books_id) VALUES(3, 2);
insert into author_books(authors_id, books_id) VALUES(3, 3);