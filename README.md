##码匠社区
[spring web]
[github Oauth]https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/
[auth app]https://developer.github.com /apps/building-oauth-apps/authorizing-oauth-apps/
```sql
CREATE TABLE USER
(
    ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ACCOUNT_ID VARCHAR(100),
    NAME VARCHAR(50),
    TOKEN VARCHAR(36),
    GMT_CREATE BIGINT,
    GMT_MODIFIED BIGINT
);
COMMENT ON COLUMN USER.ID IS '';
COMMENT ON COLUMN USER.ACCOUNT_ID IS '';
COMMENT ON COLUMN USER.NAME IS '';
COMMENT ON COLUMN USER.TOKEN IS '';
COMMENT ON COLUMN USER.GMT_CREATE IS '';
COMMENT ON COLUMN USER.GMT_MODIFIED IS '';
```