/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.Reader;
import dbutil.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author willyaguirre
 */
public class Util {
    
    public static SqlSessionFactory factory = null;
        
    public String getVersion() throws Exception {
        
        String resource = "mybatis/config.xml";
        Reader reader = null;
        SqlSession session = null;

        reader = Resources.getResourceAsReader(resource);

        factory = new SqlSessionFactoryBuilder().build(reader);
        factory.getConfiguration().addMapper(Mapper.class);
        
        try {
            session = factory.openSession();
            String version = session.selectOne("getMySQLVersion");
            return version;
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            if (session != null) {
                session.close();
            }
        }  
        
    }
    
}
