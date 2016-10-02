package controllers;

import dbutil.DBUtil;
import java.util.HashMap;
import java.util.List;
import models.User;
import utils.Sha;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willyaguirre
 */
public class Users {
    
    DBUtil dbUtil = new DBUtil();
    
    public List<User> users() throws Exception {
        dbUtil.close("dbutil.UserMapper");
        return dbUtil.runQuery("dbutil.UserMapper").selectList("users");
    }
    
    public User login(String username, String password) throws Exception {
        Sha sha = new Sha();
        HashMap<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", sha.get256(password));
        dbUtil.close("dbutil.UserMapper");
        return dbUtil.runQuery("dbutil.UserMapper").selectOne("getUser", map);
    }
    
}
