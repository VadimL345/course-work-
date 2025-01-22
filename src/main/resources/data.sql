-- Таблиця Room
INSERT INTO room (type, capacity, price, available)
VALUES
    ('Standard', 2, 100.0, true),
    ('Deluxe', 4, 200.0, true),
    ('Suite', 6, 500.0, false);

-- Таблиця Client
INSERT INTO client (name, email, phone)
VALUES
    ('John Doe', 'john@example.com', '1234567890'),
    ('Jane Smith', 'jane.smith@example.com', '9876543210');

-- Таблиця Booking
INSERT INTO booking (client_id, room_id, check_in_date, check_out_date)
VALUES
    (1, 1, '2025-01-16', '2025-01-20'),
    (2, 2, '2025-01-18', '2025-01-25');
