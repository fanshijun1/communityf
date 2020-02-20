CREATE TABLE user
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    account_id VARCHAR(100),
    name VARCHAR(100),
    avatar_url VARCHAR(100),
    token VARCHAR(100),
    gmt_create BIGINT,
    gmt_modified BIGINT
);