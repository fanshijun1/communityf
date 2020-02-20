CREATE TABLE comment
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    parent_id BIGINT NOT NULL,
    type INT,
    content VARCHAR(1024),
    commentator BIGINT,
    gmt_create BIGINT,
    gmt_modified BIGINT,
    like_count BIGINT DEFAULT 0,
    comment_count INT DEFAULT 0
);