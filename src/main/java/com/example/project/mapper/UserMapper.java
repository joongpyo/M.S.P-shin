package com.example.project.mapper;

import com.example.project.dto.UserDto;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {


    @Insert("INSERT INTO user VALUES (NULL,#{userId},#{userPasswd},#{userName}, #{userEmail})")
    public void setRegister(UserDto userDto);

    @Select("SELECT * FROM user WHERE user_id = #{userId} AND user_passwd = #{userPasswd}")
    public UserDto setLogin(UserDto userDto);

    @Select("SELECT * FROM user ORDER BY u_id DESC LIMIT #{startNum}, #{offset}")
    public List<UserDto> getUserList(Map<String, Object> map);

    @Select("SELECT COUNT(*) FROM user")
    public int getUserCount();

    @Delete("delete from user where u_id = #{uId}")
    public void deleteUser(UserDto userDto);

    @Update("update user set user_passwd = #{userPasswd} where u_id = #{uId}")
    public void updateUser(UserDto userDto);
}

