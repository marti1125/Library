/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author willyaguirre
 */
public class Message {
    
    public String type;
    
    @Getter
    @Setter
    public String message;
    
    public Message(String type, String message){
        this.type = type;
        this.message = message;
    }
    
}
