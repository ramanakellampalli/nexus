-- Customers
INSERT INTO customer (name, email) VALUES
                                       ('Alice Johnson', 'alice@example.com'),
                                       ('Bob Singh',     'bob@example.com'),
                                       ('Chitra Rao',    'chitra@example.com');

-- Products
INSERT INTO product (sku, title, price_cents, active) VALUES
                                                          ('SKU-1001', 'Wireless Mouse', 1999, TRUE),
                                                          ('SKU-1002', 'Mechanical Keyboard', 7499, TRUE),
                                                          ('SKU-1003', 'USB-C Hub', 2999, FALSE);
