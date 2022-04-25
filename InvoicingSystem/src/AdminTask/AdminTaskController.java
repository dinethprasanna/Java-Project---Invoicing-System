
package AdminTask;

import DBConnection.DBConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdminTaskController {
    
    //add task 
    public static int addTask(AdminTask t)throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
            //System.out.println(dtf.format(now));
        String time=dtf.format(now);
        String sql="insert into admin_task(task_date,task_information) values('"+time+"','"+t.getTaskInformation()+"')";
        int i=stmt.executeUpdate(sql);
        return i;
    }
    
    //display all task that have done earlier
    public static void getTasks()throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="select * from admin_task";
        ResultSet rs=stmt.executeQuery(sql);
        
        while(rs.next()){
        
            String tID=rs.getString("task_id");
            String tDate=rs.getString("task_date");
            String tInfo=rs.getString("task_information");
            
            System.out.println("Task ID="+tID+"--------->Date and Time="+tDate+"--------->"+tInfo);
        
        }
    }
}
