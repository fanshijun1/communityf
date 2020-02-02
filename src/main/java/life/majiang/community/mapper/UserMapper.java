package life.majiang.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.*;
import life.majiang.community.model.User;
/**
 * Created by fanshijun on 2020/1/27.
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);
    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);
    @Select("select * from user where id=#{id}")
    User findById(@Param("id") Integer id);
}
