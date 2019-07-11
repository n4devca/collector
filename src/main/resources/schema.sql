drop table if exists events;
create table events (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    app_name VARCHAR(250) NOT NULL,
    event_type VARCHAR(250) NOT NULL,
    event_data VARCHAR(4000) DEFAULT NULL
);