package dbutil;


import java.util.List;
import models.User;
import org.apache.ibatis.annotations.Select;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willyaguirre
 */
public interface UserMapper {
    
    @Select("SELECT * FROM User")
    List<User> users();
    
    @Select("SELECT * FROM User WHERE username = #{username} and password = #{password}")
    User getUser(String username, String password);
    
}
