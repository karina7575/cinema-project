CREATE USER administrator WITH PASSWORD 'secret';
GRANT USAGE ON SCHEMA public to administrator;
GRANT ALL PRIVILEGES ON TABLE movie TO administrator;
GRANT ALL PRIVILEGES ON TABLE movie_session TO administrator;
GRANT SELECT ON TABLE seat TO administrator;
GRANT ALL PRIVILEGES ON TABLE ticket TO administrator;


CREATE USER customer WITH PASSWORD 'custom';
GRANT USAGE ON SCHEMA public to customer;
GRANT SELECT ON TABLE movie TO customer;
GRANT UPDATE, SELECT ON TABLE ticket TO customer;
GRANT SELECT ON TABLE movie_session TO customer;
GRANT SELECT ON TABLE seat TO customer;

