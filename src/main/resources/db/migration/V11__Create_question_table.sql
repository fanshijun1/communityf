CREATE TABLE question
(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    title VARCHAR(50),
    description TEXT,
    tag VARCHAR(256),
    gmt_create BIGINT,
    gmt_modified BIGINT,
    creator BIGINT,
    comment_count INT DEFAULT 0,
    view_count INT DEFAULT 0,
    like_count INT DEFAULT 0
);