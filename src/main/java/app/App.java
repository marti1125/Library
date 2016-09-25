/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.google.gson.Gson;
import static spark.Spark.*;
import controllers.Books;
import controllers.Users;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;
import reports.UserReport;
import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;
import utils.Message;
import utils.Render;
import utils.ViewUtil;
import view.AuthorView;


/**
 *
 * @author willyaguirre
 */
public class App {
    
    public static void main(String[] args) throws Exception {
    
        staticFiles.location("/public");
        
        ViewUtil viewUtil = new ViewUtil();
        
        Gson gson = new Gson();
        
        Users users = new Users();
        
        Books book = new Books();
        
        Map<String, Object> map = new HashMap<>();
        map.put("welcome", "Welcome to the System!!");
        map.put("listBooks", book.list());
        
        get("/", (req, res) ->  {
            return viewUtil.validate(req, res, map, "index");
        });
        
        get("/login", (req, res) ->  new ModelAndView(map, "login"), new JadeTemplateEngine());
        
        get("/logout", (req, res) ->  {
            req.session().attribute("logged", false);
            req.session().attribute("user", null);
            res.redirect("/login");
            return null;   
        });
        
        get("/author", (req, res) ->  new AuthorView().index(), new JadeTemplateEngine());
        
        post("/secure", (req, res) -> {
            Message message;
            User user;
            try {
                user = users.login(req.queryParams("username"), req.queryParams("password"));
                if(user != null){
                    req.session().attribute("logged", true);
                    req.session().attribute("user", user.getName());
                    return new Message("ok","ok");
                } else {
                    return new Message("warning","The username or password is incorrect");
                }
            } catch (Exception ex) {
                message = new Message("danger","problem with connection to data base");
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
            return message;
        }, gson::toJson);
        
        get("/report", (req, res) ->  {
            UserReport uReport = new UserReport();
            Render render = new Render();
            Render.file(res, uReport.reportPDF(), "application/pdf", "users.pdf");
            return "report";
        });
        
        get("*", (req, res) -> {
            if(!req.pathInfo().startsWith("/public")){
                res.status(404);
                return new JadeTemplateEngine().render(new ModelAndView(new HashMap<>(), "404"));
            }
            return null;
        });
        
    }
    
}
