##码匠社区
[spring web]
[github Oauth]https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/
[auth app]https://developer.github.com /apps/building-oauth-apps/authorizing-oauth-apps/
##[官方文档]
[flyway:migration]https://flywaydb.org/getstarted/firststeps/maven
[thymeleaf官方文档]https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#contexts
[mybatis整合spring-boot]https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/
[springboot]https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/html/
##[相关网址]
bootstrap:https://v3.bootcss.com/css/#grid
elastic中文社区:https://elasticsearch.cn/
lombok:https://projectlombok.org/setup/maven
##问题解决
[mac idea lombok不生效]https://blog.csdn.net/ytangdigl/article/details/104014904
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
[git]

git add .
git status
git commit -m "add"
git push
##[cmd]
mvn flyway:migrate