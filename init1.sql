CREATE TABLE movie (id serial PRIMARY KEY, 
					movie_name varchar (50), 
					movie_description varchar (500));
					
CREATE TABLE seat (id serial PRIMARY KEY, 
					seat_number varchar (2));
					
CREATE TABLE movie_session (id serial PRIMARY KEY, 
							movie_id int references movie(id), 
							movie_date timestamp, 
							price numeric (10,2));
							
CREATE TABLE ticket (id serial PRIMARY KEY, 
						seat_id int references seat(id), 
						session_id int references movie_session(id), 
						is_buyed boolean);

SELECT * 
FROM movie_session;
INSERT INTO movie_session(movie_id, movie_date, price) values (1, NOW(), 500);

DELETE FROM movie WHERE id = 4;

DROP TABLE ticket;

create function generate_place()
language plpgsql
