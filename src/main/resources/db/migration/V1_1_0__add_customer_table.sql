CREATE TABLE IF NOT EXISTS customers
(
    id         UUID NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    CONSTRAINT pk_customers PRIMARY KEY (id)
);
