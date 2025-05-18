CREATE TABLE Films (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    available_tickets INT NOT NULL DEFAULT 3,
    sold_tickets INT NOT NULL DEFAULT 0
);

CREATE TABLE Tickets (
    id SERIAL PRIMARY KEY,
    user_id INT,
    film_id INT,
    moovie_time TIME,
    moovie_date DATE,
    ticket_number INT,
    status VARCHAR(20) DEFAULT 'available',
    FOREIGN KEY (film_id) REFERENCES Films(id)
);

CREATE TABLE Users (
    id SERIAL PRIMARY KEY,
    status VARCHAR(20) DEFAULT 'guest',
    timeAction TIMESTAMP,
    dateAction CURRENT_DATE
);

CREATE TABLE UserActions (
    id SERIAL PRIMARY KEY,
    user_id INT,
    action_type VARCHAR(50),
    ticket_id INT,
    film_id INT,
    film_title VARCHAR(255),
    action_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);