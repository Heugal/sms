package studentmanagementsystem.managers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Blob;
import studentmanagementsystem.ConnectDB;

public class ItemManager {
    public static ResultSet getItems() throws SQLException
    {
        String sql = "SELECT * FROM STUDENTS";
        Connection conn = null; 
	Statement stmt = null;  
	ResultSet rs = null; 
        
	try {
            conn = ConnectDB.getConnection();
            stmt = conn.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            System.err.println("Error Message: " + ex.getMessage());
            System.err.println("Error Code: " + ex.getErrorCode());
            System.err.println("SQL State: " + ex.getSQLState());
	}
        return null;
    }
    
    public static ResultSet getSearchItems(String sql) throws SQLException{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            conn = ConnectDB.getConnection();
            stmt = conn.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
                System.err.println("Error Message: " + ex.getMessage());
                System.err.println("Error Code: " + ex.getErrorCode());
                System.err.println("SQL State: " + ex.getSQLState());
        }
        return null;
    }
    
    public static ResultSet getAllPictures() throws SQLException{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            conn = ConnectDB.getConnection();
            stmt = conn.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from student_photo");
            return rs;
        }catch (SQLException ex) {
                System.err.println("Error Message: " + ex.getMessage());
                System.err.println("Error Code: " + ex.getErrorCode());
                System.err.println("SQL State: " + ex.getSQLState());
        }
        return null;
    }
    
    public static Blob getPicture(int studentID) throws SQLException{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            conn = ConnectDB.getConnection();
            stmt = conn.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from student_photo where student_id = "+studentID);
            if (rs.next())
                return rs.getBlob("picture");
            else
                return null;
        }catch (SQLException ex) {
                System.err.println("Error Message: " + ex.getMessage());
                System.err.println("Error Code: " + ex.getErrorCode());
                System.err.println("SQL State: " + ex.getSQLState());
        }
        return null;
    }
    
    public static boolean checkIfPhotoPresent(int studentID){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs =  null;
    
        try{
            conn = ConnectDB.getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("select count(*) from student_photo where student_id = "+studentID);
            if (rs.next()){
                if (rs.getInt("count(*)") > 0)
                    return true;
                return false;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally{
            if (rs != null)
                rs = null;
            if (stmt != null)
                stmt = null;
            if (conn != null)
                conn = null;
        }
        return false;
    }
}
