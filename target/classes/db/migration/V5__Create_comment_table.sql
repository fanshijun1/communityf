CREATE TABLE PUBLIC.comment
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    parent_id BIGINT NOT NULL,
    type INT,
    commentator INT,
    gmt_create BIGINT,
    gmt_modified BIGINT,
    like_count BIGINT DEFAULT 0
);
