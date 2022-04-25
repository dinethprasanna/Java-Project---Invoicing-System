
package Invoice;

import DBConnection.DBConnector;
import TaskTrack.TaskTrack;
import TaskTrack.TaskTrackController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InvoiceController {
    
    //add invoice
    public static int addInvoice(Invoice inv)throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
            //System.out.println(dtf.format(now));
        String time=dtf.format(now);
        inv.setInvoiceCreateDate(time);
        String sql="INSERT INTO invoice VALUES('"+inv.getInvoiceNo()+"','"+inv.getCustomerID()+"','"+time+"',"
                + ""+inv.getInvoiceTotalAmount()+","+inv.getInvoiceTotalDiscount()+")";
        int i=stmt.executeUpdate(sql);
        
        TaskTrack t1=new TaskTrack();
        t1.setTaskInformation("A New Invoice Generated | "+inv.getInvoiceNo());
        TaskTrackController.addTask(t1);
        
        
        return i;
    }
    
    
    
    //display all generayed invoices
    public static ResultSet getInvoices()throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="select * from invoice";
        ResultSet rs=stmt.executeQuery(sql);
        
        return rs;
    }
    

    
    //auto generate invoice ID method
    public static String nextInvoiceID() throws ClassNotFoundException,SQLException{
    
        String nextInvID="No Invoice No";
        
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="SELECT COUNT(DISTINCT(invoice_no)) FROM invoice_item";
        ResultSet rs=stmt.executeQuery(sql);
        
        rs.next();
        int invoicesCount=rs.getInt(1)+1;
        
        nextInvID="T-"+invoicesCount;
        
        return nextInvID;
    }
    
    
    
}
