
package TaskTrack;


import DBConnection.DBConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskTrackController {
    
    //add task 
    public static int addTask(TaskTrack t)throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
            //System.out.println(dtf.format(now));
        String time=dtf.format(now);
        String sql="insert into task_track(task_date,task_information) values('"+time+"','"+t.getTaskInformation()+"')";
        int i=stmt.executeUpdate(sql);
        return i;
    }
    
    //display all task that have done earlier
    public static ResultSet getTasks()throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="select * from task_track";
        ResultSet rs=stmt.executeQuery(sql);
        
        return rs;
        

    }
    
}
