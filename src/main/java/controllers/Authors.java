/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dbutil.DBUtil;
import java.util.List;
import models.Author;

/**
 *
 * @author willyaguirre
 */
public class Authors {
    
    DBUtil dbUtil = new DBUtil();
    
    public List<Author> listAuthors() throws Exception {
        dbUtil.close("dbutil.AuthorMapper");
        return dbUtil.runQuery("dbutil.AuthorMapper").selectList("getUser");
    }
    
}
