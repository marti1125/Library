/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Map;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.jade.JadeTemplateEngine;

/**
 *
 * @author willyaguirre
 */
public class ViewUtil {
 
    public String validate(Request req, Response res, Map<String, Object> map, String templateName) {
        boolean logged = ( req.session().attribute("logged") == null )? false : req.session().attribute("logged");
        if(logged){
            map.put("user", getUser(req));
            return new JadeTemplateEngine().render(new ModelAndView(map, templateName));
        } else {
            res.redirect("/login");
            return null;
        }
    }
    
    public String getUser(Request req) {
        String userName = ( req.session().attribute("user").toString() == null )? "" : req.session().attribute("user").toString();
        return userName;
    }
    
}
