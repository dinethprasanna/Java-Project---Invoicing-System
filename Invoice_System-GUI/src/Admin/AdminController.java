
package Admin;

import DBConnection.DBConnector;
import TaskTrack.TaskTrack;
import TaskTrack.TaskTrackController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminController {
    
    
    //login function
    public static boolean loginUser(Admin admin)throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="select * from admin where admin_id='"+admin.getAdminID()+"' and admin_password='"+admin.getAdminPassword()+"'";
        ResultSet rs=stmt.executeQuery(sql);
        boolean i=false;
        while(rs.next()){
            
            String uID=rs.getString("admin_id");
            String pass=rs.getString("admin_password");
            
            if(uID.equals(admin.getAdminID()) & pass.equals(admin.getAdminPassword())){
                i=true;
                
                TaskTrack t1=new TaskTrack();
                t1.setTaskInformation("Admin Logged into the System | "+admin.getAdminID());
                TaskTrackController.addTask(t1);
                    }
        }
        
        return i;
    }
    
    //display all admin account details
    public static ResultSet getAdminAccounts()throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="SELECT * FROM admin";
        ResultSet rs=stmt.executeQuery(sql);
        return rs;
    }
    
    //add admin Account
    public static int addNewAdmin(Admin admin)throws ClassNotFoundException,SQLException{
    
        int adminAdded;
        
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="INSERT INTO admin VALUES('"+admin.getAdminID()+"','"+admin.getAdminName()+"','"+admin.getAdminPassword()+"')";
        adminAdded=stmt.executeUpdate(sql);
        
        TaskTrack t1=new TaskTrack();
        t1.setTaskInformation("Created A New Admin Account | "+admin.getAdminID()+"---"+admin.getAdminName());
        TaskTrackController.addTask(t1);
        
        return adminAdded;
    }
    
    //delete admin Account
    public static int deleteAdmin(Admin admin)throws ClassNotFoundException,SQLException{
    
        int adminDelete;
        
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="DELETE FROM admin WHERE admin_id='"+admin.getAdminID()+"'";
        adminDelete=stmt.executeUpdate(sql);
        
        TaskTrack t1=new TaskTrack();
        t1.setTaskInformation("Deleted an Admin Account | "+admin.getAdminID());
        TaskTrackController.addTask(t1);
        
        return adminDelete;
    }
    
    //update admin Account
    public static int updateAdmin(Admin admin)throws ClassNotFoundException,SQLException{
    
        int adminUpdate;
        
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="UPDATE admin SET admin_name='"+admin.getAdminName()+"',admin_password='"+admin.getAdminPassword()+"' WHERE admin_id='"+admin.getAdminID()+"'";
        adminUpdate=stmt.executeUpdate(sql);
        
        TaskTrack t1=new TaskTrack();
        t1.setTaskInformation("Updated an Admin Account | "+admin.getAdminID()+"---"+admin.getAdminName());
        TaskTrackController.addTask(t1);
        
        return adminUpdate;
    }
}
