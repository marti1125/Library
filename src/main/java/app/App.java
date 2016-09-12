/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import static spark.Spark.*;
import controllers.Books;
import controllers.Users;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.jade.JadeTemplateEngine;
import view.AuthorView;


/**
 *
 * @author willyaguirre
 */
public class App {
    
    public static void main(String[] args) throws Exception {
        
        staticFiles.location("/public");
        
        Users users = new Users();
        
        Books book = new Books();
        
        Map<String, Object> map = new HashMap<>();
        map.put("welcome", "Welcome to the System!!");
        map.put("listBooks", book.list());
                
        get("/", (req, res) ->  new ModelAndView(map, "index"), new JadeTemplateEngine());
        
        get("/login", (req, res) ->  new ModelAndView(map, "login"), new JadeTemplateEngine());
        
        get("/author", (req, res) ->  new AuthorView().index(), new JadeTemplateEngine());
        
        post("/secure", (Request req, Response res) ->  {
            User user;
            try {
                user = users.login(req.queryParams("username"), req.queryParams("password"));
                if(user != null){
                    res.redirect("/");
                    return null;
                } else {
                    res.redirect("/login");
                    return null;
                }
            } catch (Exception ex) {
                res.redirect("/login");
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        });
        
    }
    
}
