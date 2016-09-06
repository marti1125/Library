/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbutil;

import java.util.List;
import models.Author;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author willyaguirre
 */
public interface Mapper {
    
    @Select("SELECT VERSION()")
    public String getMySQLVersion();
    
    @Select("SELECT * FROM Author")
    public List<Author> listAuthors();
    
}
