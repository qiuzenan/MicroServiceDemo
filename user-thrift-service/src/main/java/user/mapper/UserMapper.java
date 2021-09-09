package user.mapper;

import UserInfo.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select id,usernamae form  pe_user where id=#{id}")
    UserInfo getUserInfoById(@Param("id")int id);

    @Select("select id,usernamae form  pe_user where username=#{username}")
    public UserInfo getUserByname(@Param("username") String username);

    @Insert("inser into pe_user(id,username) values(#{info.id},#{info.username})")
    void regiserUser(@Param("info") UserInfo userInfo);
}
