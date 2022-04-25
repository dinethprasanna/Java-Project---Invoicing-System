
package Customer;

import DBConnection.DBConnector;
import TaskTrack.TaskTrack;
import TaskTrack.TaskTrackController;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class CustomerController {
    
    
    //insert customer data
    public static int addCustomer(Customer customer) throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="insert into customer values('"+customer.getCustomerID()+"','"+customer.getCustomerName()+"',"
                + "'"+customer.getEmail()+"','"+customer.getAddress()+"',"+customer.getContactNumber()+","
                + "'"+customer.getDateOfBirth()+"','"+customer.getGender()+"')";
        int i=stmt.executeUpdate(sql);
        
        TaskTrack t1=new TaskTrack();
        t1.setTaskInformation("Added a New Customer | "+customer.getCustomerID());
        TaskTrackController.addTask(t1);
        
        return i;        
    }
    
    
    //delete customer data
    public static int deleteCustomer(Customer customer)throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="delete from customer where customer_id='"+customer.getCustomerID()+"'";
        int i=stmt.executeUpdate(sql);
        
        TaskTrack t1=new TaskTrack();
        t1.setTaskInformation("Deleted a Customer | "+customer.getCustomerID());
        TaskTrackController.addTask(t1);
        
        return i;        
    }
    
    
    //update customer data
    public static int updateCustomer(Customer customer)throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="update customer set customer_name='"+customer.getCustomerName()+"',email='"+customer.getEmail()+"',address='"+customer.getAddress()+"',contact_number="+customer.getContactNumber()+",date_of_birth='"+customer.getDateOfBirth()+"',gender='"+customer.getGender()+"' where customer_id='"+customer.getCustomerID()+"' ";
        int i = stmt.executeUpdate(sql);
        
        
        TaskTrack t1=new TaskTrack();
        t1.setTaskInformation("Update a Customer | "+customer.getCustomerID()+"---"+customer.getCustomerName());
        TaskTrackController.addTask(t1);
        
        return i;
    }
    

    
    //Retrieve all the customer data 
    public static ResultSet getCustomers()throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="select * from customer";
        ResultSet rs=stmt.executeQuery(sql);
        
        return rs;
        
    }
    
    
    

    
    //customer search
    public static ResultSet customerSearch(String search) throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="SELECT * FROM customer WHERE customer_id LIKE '%"+search+"%' OR customer_name LIKE '%"+search+"%'";
        ResultSet rs=stmt.executeQuery(sql);
        return rs;
        
    }
    


    
}
