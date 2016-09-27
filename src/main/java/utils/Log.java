/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author willyaguirre
 */
public class Log {
    
    public static void status(String type, Class cla, String message){
        Logger logger = LoggerFactory.getLogger(cla.getClass());
        switch (type) {
            case "INFO":
                logger.info(message);
                break;
            case "ERROR":
                logger.error(message);
                break;
            case "WARN":
                logger.warn(message);
                break;
            case "TRACE":
                logger.trace(message);
                break;
            case "DEBUG":
                logger.debug(message);
                break;
            default:
                break;
        }
    }
    
}
