/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem.managers;

import studentmanagementsystem.beans.UserBean;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import studentmanagementsystem.ConnectDB;

/**
 *
 * @author tuc02096
 */
public class UserManager {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    public void insertUser(String username,
                                String password,
                                String firstName,
                                String lastName) throws SQLException{
        try{
            conn = ConnectDB.getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("insert into users (username, password, first_name, last_name) values ('"
                    +username +"', '"+ password+"', '"+firstName+"', '"+lastName+"')");
            rs = stmt.executeQuery("commit");
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        finally{
             if(rs != null){
                rs.close();
            }
              if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
        }
    }
    
    public static UserBean getUser(String username) throws SQLException{
        String sql = "select * from users where upper(username) = upper(?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = ConnectDB.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            
            if (rs.next()){
                UserBean bean = new UserBean();
                bean.setUserName(username);
                bean.setPassword(rs.getString("password"));
                bean.setFirstName(rs.getString("first_name"));
                bean.setLastName(rs.getString("last_name"));
                return bean;
            } else{
                return null;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
        finally{
             if(rs != null){
                rs.close();
            }
              if(pstmt != null){
                pstmt.close();
            }
            if(conn != null){
                conn.close();
            }
        }
    }
    
    public static void logUserHistory(String username) throws SQLException{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = ConnectDB.getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("insert into user_history (username, login_date, login_time)"
                    + " values ('"+username+"', sysdate, to_char(systimestamp, 'HH:MI:SS'))");
            rs = stmt.executeQuery("commit");
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        finally{
             if(rs != null){
                rs.close();
            }
              if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
        }
    }
    
    public static void executeQuery(String sql) throws SQLException{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = ConnectDB.getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            rs = stmt.executeQuery("commit");
        }catch (SQLException ex) {
            System.err.println(ex);
        }
        finally{
             if(rs != null){
                rs.close();
            }
              if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
        }
    }
}
