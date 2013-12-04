/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tuc02096
 */
public class ConnectDB {
	// DB connection information is fuzzed for the time being
    private static final String UserName = "";
    private static final String Password = "";
    private static final String ConnectionString =
            "";
    
        public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(ConnectionString, UserName, 
                Password);
    }
}
