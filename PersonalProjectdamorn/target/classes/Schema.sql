CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    starting_price DOUBLE,
    current_bid DOUBLE,
    seller_id BIGINT,
    auction_end TIMESTAMP,
    image1 VARCHAR(255),
    image2 VARCHAR(255),
    image3 VARCHAR(255),
    image4 VARCHAR(255),
    image5 VARCHAR(255)
);

CREATE TABLE messages (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id BIGINT,
    sender_name VARCHAR(255),
    content TEXT,
    sent_time TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES products(id)
);
