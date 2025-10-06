DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
                          id           BIGINT PRIMARY KEY AUTO_INCREMENT,
                          name         VARCHAR(100) NOT NULL,
                          email        VARCHAR(150) UNIQUE,
                          created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Another example table
DROP TABLE IF EXISTS product;

CREATE TABLE product (
                         id           BIGINT PRIMARY KEY AUTO_INCREMENT,
                         sku          VARCHAR(50) NOT NULL UNIQUE,
                         title        VARCHAR(120) NOT NULL,
                         price_cents  INT NOT NULL,
                         active       BOOLEAN DEFAULT TRUE
);
