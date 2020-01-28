package life.majiang.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.*;
import life.majiang.community.model.User;
/**
 * Created by fanshijun on 2020/1/27.
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}
