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
public class Editorial {
    
    private long idEditorial;
    private String name;
    private String agent;
    private String address;
    private String phonenumber;
    
}
