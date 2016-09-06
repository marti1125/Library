/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.Authors;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;

/**
 *
 * @author willyaguirre
 */
public class AuthorView {
    
    Authors authors = new Authors();
    
    public ModelAndView index() throws Exception{
        Map<String, Object> map = new HashMap<>();
        map.put("listAuthors", authors.listAuthors());
        return new ModelAndView(map, "author");
    }
    
}
