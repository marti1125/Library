package view;


import java.util.HashMap;
import java.util.Map;
import models.User;
import spark.ModelAndView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willyaguirre
 */
public class UserView {
    
    User user = new User();
    
    public ModelAndView index() throws Exception {
        Map<String, Object> map = new HashMap<>();
        return new ModelAndView(map, "login");
    }
    
}
