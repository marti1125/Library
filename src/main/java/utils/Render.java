/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import spark.Response;

/**
 *
 * @author willyaguirre
 */
public class Render {
    
    public Render(){}
    
    Log log = new Log();
    
    public static void file(Response res,byte[] data, String fileType, String fileName) {
        try {
            HttpServletResponse httpServletResponse = res.raw();
            httpServletResponse.setContentType(fileType);
            httpServletResponse.addHeader("Content-Disposition", "inline; filename="+fileName);
            httpServletResponse.getOutputStream().write(data);
            httpServletResponse.getOutputStream().close();
        } catch (IOException e) {
            Log.status("ERROR", Render.class, e.getMessage());
        }
    }

}
