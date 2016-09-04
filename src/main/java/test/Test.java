/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import static spark.Spark.*;
import controllers.Books;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;


/**
 *
 * @author willyaguirre
 */
public class Test {
    
    public static void main(String[] args){
        
        Books book = new Books();
        
        Map<String, Object> map = new HashMap<>();
        map.put("welcome", "Welcome to the System!!");
        map.put("listBooks", book.list());
                
        get("/", (req, res) ->  new ModelAndView(map, "test"), new JadeTemplateEngine());
    }
    
}
