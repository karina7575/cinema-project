CREATE SEQUENCE place_seq START 1;

CREATE OR REPLACE FUNCTION generate_place(postfix varchar)
RETURNS varchar
LANGUAGE plpgsql
AS $$
BEGIN
	RETURN nextval('place_seq') || postfix;
END;
$$;


CREATE OR REPLACE PROCEDURE create_seat ()
LANGUAGE plpgsql
AS $$
	BEGIN
		FOR i in 1..5 LOOP
		INSERT INTO seat (seat_number) values(generate_place('A'));
		END LOOP;
		ALTER SEQUENCE place_seq RESTART WITH 1;
		FOR i in 1..5 LOOP
		INSERT INTO seat (seat_number) values(generate_place('B'));
		END LOOP;
	END;
$$;

CALL create_seat();


