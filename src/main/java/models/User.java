/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import lombok.Data;

/**
 *
 * @author willyaguirre
 */

@Data
public class User {
    
    private long idUser;
    private KindofUser idKindofUser;
    private String username;
    private String password;
    private String lastname;
    private String motherslastname;
    private String name;
    private String photo;
    
}
