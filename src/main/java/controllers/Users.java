package controllers;

import dbutil.DBUtil;
import java.util.HashMap;
import models.User;

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
    
    public User login(String username, String password) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        dbUtil.close("dbutil.UserMapper");
        return dbUtil.runQuery("dbutil.UserMapper").selectOne("getUser", map);
    }
    
}
