/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbutil;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author willyaguirre
 */
public class DBUtil {
    
    public static SqlSessionFactory factory = null;
        
    public SqlSession runQuery(String classMapperName) throws Exception {
        Class classMapper = Class.forName(classMapperName);
        String resource = "mybatis/config.xml";
        Reader reader = null;
        SqlSession session = null;

        reader = Resources.getResourceAsReader(resource);

        factory = new SqlSessionFactoryBuilder().build(reader);
        factory.getConfiguration().addMapper(classMapper);
        
        return factory.openSession();
        
    }
    
    public void close(String classMapperName) throws Exception {
        runQuery(classMapperName).commit();
        runQuery(classMapperName).close();
    };
    
}
