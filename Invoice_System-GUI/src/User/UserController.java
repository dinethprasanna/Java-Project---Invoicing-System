
package User;

import DBConnection.DBConnector;
import TaskTrack.TaskTrack;
import TaskTrack.TaskTrackController;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class UserController {
    
    //login function
    public static boolean loginUser(User u)throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="select * from user where user_id='"+u.getUserID()+"' and password='"+u.getUserPassword()+"'";
        ResultSet rs=stmt.executeQuery(sql);
        boolean i=false;
        while(rs.next()){
            
            String uID=rs.getString("user_id");
            String pass=rs.getString("password");
            
            if(uID.equals(u.getUserID()) & pass.equals(u.getUserPassword())){
                i=true;
                TaskTrack t1=new TaskTrack();
                t1.setTaskInformation("User Logged Into The System | "+u.getUserID());
                TaskTrackController.addTask(t1); 
            }
        }
        
        return i;
    }
    
    //display all admin account details
    public static ResultSet getUserAccounts()throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="SELECT * FROM user";
        ResultSet rs=stmt.executeQuery(sql);
        return rs;
    }
    
    //create new user
    public static int addNewUser(User user) throws SQLException, ClassNotFoundException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="INSERT INTO user VALUES('"+user.getUserID()+"','"+user.getUserName()+"','"+user.getUserPassword()+"')";
        int addUser=stmt.executeUpdate(sql);
        
        TaskTrack t1=new TaskTrack();
        t1.setTaskInformation("Created A New User Account | "+user.getUserID()+"---"+user.getUserName());
        TaskTrackController.addTask(t1);
        
        return addUser;
    }
    
    //delete
    public static int deleteUser(User user) throws SQLException, ClassNotFoundException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="DELETE FROM user WHERE user_id='"+user.getUserID()+"'";
        int deleteUser=stmt.executeUpdate(sql);
        
        TaskTrack t1=new TaskTrack();
        t1.setTaskInformation("Deleted an User Account | "+user.getUserID());
        TaskTrackController.addTask(t1);
        
        return deleteUser;
    }
    
    //update
    public static int updateUser(User user) throws SQLException, ClassNotFoundException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="UPDATE user SET user_name='"+user.getUserName()+"', password='"+user.getUserPassword()+"' WHERE user_id='"+user.getUserID()+"'";
        int updateUser=stmt.executeUpdate(sql);
        
        TaskTrack t1=new TaskTrack();
        t1.setTaskInformation("Updated an User Account | "+user.getUserID());
        TaskTrackController.addTask(t1);
        
        return updateUser;
    }
    
}
