/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.data;

import com.mysql.jdbc.JDBC4CallableStatement;
import com.mysql.jdbc.MySQLConnection;
import java.sql.*;
/**
 *
 * @author LAB-CA
 */
public class ConnectionUtilities {
    private static Connection con;
    
    public static Connection getConnection(){
        if(con==null)
        {
            //error handling
            try{
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan", "root", "");
            }catch(SQLException ex)
            {
                ex.toString();
            }
        }
        return con;
    }
}
