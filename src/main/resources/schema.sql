-- Таблиця Room
CREATE TABLE room (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      type VARCHAR(255) NOT NULL,
                      capacity INT NOT NULL,
                      price DOUBLE NOT NULL,
                      available BOOLEAN NOT NULL
);

-- Таблиця Client
CREATE TABLE client (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        email VARCHAR(255) UNIQUE NOT NULL,
                        phone VARCHAR(20) UNIQUE NOT NULL
);

-- Таблиця Booking
CREATE TABLE booking (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         client_id BIGINT,
                         room_id BIGINT,
                         check_in_date DATE NOT NULL,
                         check_out_date DATE NOT NULL,
                         FOREIGN KEY (client_id) REFERENCES client(id),
                         FOREIGN KEY (room_id) REFERENCES room(id)
);
