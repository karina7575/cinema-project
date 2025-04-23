CREATE TABLE movie (id serial PRIMARY KEY, movie_name varchar (50), movie_description varchar (500));
CREATE TABLE seat (id serial PRIMARY KEY, seat_number varchar (2));
CREATE TABLE movie_session (id serial PRIMARY KEY, movie_id int references movie(id), movie_date timestamp, price money);
CREATE TABLE ticket (id serial PRIMARY KEY, seat_id int references seat(id), is_buyed boolean);



DROP TABLE seat;