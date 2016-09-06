/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controllers.Authors;
import static spark.Spark.*;
import controllers.Books;
import controllers.Util;

import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;
import view.AuthorView;


/**
 *
 * @author willyaguirre
 */
public class App {
    
    public static void main(String[] args) throws Exception {
        
        Books book = new Books();
        Util util = new Util();
        
        Map<String, Object> map = new HashMap<>();
        map.put("welcome", "Welcome to the System!!");
        map.put("listBooks", book.list());
        map.put("mysqlversion", util.getVersion());
                
        get("/", (req, res) ->  new ModelAndView(map, "index"), new JadeTemplateEngine());
        
        get("/author", (req, res) ->  new AuthorView().index(), new JadeTemplateEngine());
        
    }
    
}
