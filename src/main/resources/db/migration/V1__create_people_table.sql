CREATE TABLE PEOPLE (
                       id BIGINT NOT NULL PRIMARY KEY,
                       name VARCHAR(255),
                       email VARCHAR(255)
);

INSERT INTO PEOPLE (id, name, email) VALUES
                                        (1, 'John Doe', 'john.doe@example.com'),
                                        (2, 'Jane Doe', 'jane.doe@example.com'),
                                        (3, 'Mike Smith', 'mike.smith@example.com'),
                                        (4, 'Amy Johnson', 'amy.johnson@example.com'),
                                        (5, 'David Lee', 'david.lee@example.com');