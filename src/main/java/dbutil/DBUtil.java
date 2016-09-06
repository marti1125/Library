/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbutil;

import java.io.Reader;
import java.util.List;
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
        
    public SqlSession runQuery() throws Exception {
        
        String resource = "mybatis/config.xml";
        Reader reader = null;
        SqlSession session = null;

        reader = Resources.getResourceAsReader(resource);

        factory = new SqlSessionFactoryBuilder().build(reader);
        factory.getConfiguration().addMapper(Mapper.class);
        
        return factory.openSession();
        
    }
    
    public void close() throws Exception {
        runQuery().commit();
        runQuery().close();
    };
    
}
