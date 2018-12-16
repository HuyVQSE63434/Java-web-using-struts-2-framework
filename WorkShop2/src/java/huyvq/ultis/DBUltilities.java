/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyvq.ultis;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author huyvqse63434
 */
public class DBUltilities {
    public static Connection getConnection() throws NamingException, SQLException{
        Connection conn=null;
        Context cont= new InitialContext();
        Context tomcat= (Context) cont.lookup("java:comp/env");
        DataSource data= (DataSource) tomcat.lookup("DB01");
        conn= data.getConnection();
        return conn;
    }
}
