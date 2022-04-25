
package Customer;

import DBConnection.DBConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class CustomerController {
    
    
    //insert customer data
    public static int addCustomer(Customer customer) throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="update customer set customer_name='"+customer.getCustomerName()+"',email='"+customer.getEmail()+"',address='"+customer.getAddress()+"',contact_number="+customer.getContactNumber()+",date_of_birth='"+customer.getDateOfBirth()+"',gender='"+customer.getGender()+"' where customer_id='"+customer.getCustomerID()+"' ";
        int i=stmt.executeUpdate(sql);
        return i;        
    }
    
    
    //delete customer data
    public static int deleteCustomer(Customer customer)throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="delete from customer where customer_id='"+customer.getCustomerID()+"'";
        int i=stmt.executeUpdate(sql);
        return i;        
    }
    
    
    //update customer data
    public static int updateCustomer(Customer customer)throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="update customer set customer_name='"+customer.getCustomerName()+"',"
                   + "email='"+customer.getEmail()+"',address='"+customer.getAddress()+"'"
                   + "contact_number="+customer.getContactNumber()+",date_of_birth='"+customer.getDateOfBirth()+"'"
                   + "gender='"+customer.getGender()+"' where customer_id='"+customer.getCustomerID()+"' ";
        int i = stmt.executeUpdate(sql);
        return i;
    }
    
    
    //RETRIEVE ONE cUSTOMER RECORD FROM THE TABLE
    public static void getCustomer(Customer customer)throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="select * from customer where customer_id='"+customer.getCustomerID()+"'";
        ResultSet rs=stmt.executeQuery(sql);
        
        while(rs.next()){
        
            String cusID=rs.getString("customer_id");
            String cusName=rs.getString("customer_name");
            String cusEmail=rs.getString("email");
            String cusAddress=rs.getString("address");
            String cusContactNo=rs.getString("contact_number");
            String cusDateOfBirth=rs.getString("date_of_birth");
            String cusGender=rs.getString("gender");
            
            System.out.println("Customer ID = "+cusID+" Customer Name = "+cusName+" Email = "+cusEmail+" Address = "
                    + ""+cusAddress+"  Contact Number = "+cusContactNo+"    Date of Birth = "+cusDateOfBirth+"  Gender = "+cusGender);
        }
    }
    
    //Retrieve all the customer data 
    public static void getCustomers()throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="select * from customer";
        ResultSet rs=stmt.executeQuery(sql);
        
        while(rs.next()){
        
            String cusID=rs.getString("customer_id");
            String cusName=rs.getString("customer_name");
            String cusEmail=rs.getString("email");
            String cusAddress=rs.getString("address");
            String cusContactNo=rs.getString("contact_number");
            String cusDateOfBirth=rs.getString("date_of_birth");
            String cusGender=rs.getString("gender");
            
            System.out.println("Customer ID = "+cusID+" Customer Name = "+cusName+" Email = "+cusEmail+" Address = "
                    + ""+cusAddress+"  Contact Number = "+cusContactNo+"    Date of Birth = "+cusDateOfBirth+"  Gender = "+cusGender);
        }
    }
    
    
    //check customer exists
    public static boolean customerCheck(Customer customer)throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="select * from customer where customer_id='"+customer.getCustomerID()+"'";
        ResultSet rs=stmt.executeQuery(sql);
        boolean i=false;
        while(rs.next()){
            
            String cusID=rs.getString("customer_id");
            
            
            if(cusID.equals(customer.getCustomerID())){
                i=true;
            }
        }
        
        return i;
    }
    
}
