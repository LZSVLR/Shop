CREATE TABLE client
(
    id   uuid    NOT NULL,
    name VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE item
(
    id    uuid    NOT NULL,
    name  VARCHAR NOT NULL,
    price double precision,
    PRIMARY KEY (id)
);

CREATE TABLE order_items
(
    client_id uuid NOT NULL,
    item_id   uuid NOT NULL,
    PRIMARY KEY (client_id, item_id),
    FOREIGN KEY (client_id) REFERENCES client (id),
    FOREIGN KEY (item_id) REFERENCES item (id)
)