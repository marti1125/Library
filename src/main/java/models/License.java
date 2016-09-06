/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author willyaguirre
 */

@Data
public class License {
    
    private long idLicense;
    private User idUser;
    private char status;
    private Date observation;
    
}
