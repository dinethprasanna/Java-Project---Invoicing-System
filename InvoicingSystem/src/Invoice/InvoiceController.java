
package Invoice;

import DBConnection.DBConnector;
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
        String sql="INSERT INTO invoice VALUES('"+inv.getInvoiceNo()+"','"+inv.getCustomerID()+"','"+inv.getInvoiceCreateDate()+"',"
                + ""+inv.getInvoiceTotalAmount()+","+inv.getInvoiceTotalDiscount()+")";
        int i=stmt.executeUpdate(sql);
        return i;
    }
    
    
    
    //display all generayed invoices
    public static void getInvoices()throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="select * from invoice";
        ResultSet rs=stmt.executeQuery(sql);
        
        while(rs.next()){
        
            String invNo=rs.getString("invoice_no");
            String cusID=rs.getString("customer_id");
            String invDate=rs.getString("invoice_date");
            String invTotalPrice=rs.getString("total_price");
            String invTotalDiscount=rs.getString("total_discount");
            
            System.out.println("Invoice No="+invNo+"    Customer ID="+cusID+"   Invoice Isuued Date="+invDate+"   Total Amount= Rs."+invTotalPrice+"   Total Discount= Rs."+invTotalDiscount);
        }
    }
    
    //check invoice no not exists in the table
    public static boolean checkInvoiceNo(Invoice inv)throws ClassNotFoundException,SQLException{
    
        boolean invoiceExists=true;
        
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="SELECT invoice_no FROM invoice WHERE invoice_no='"+inv.getInvoiceNo()+"'";
        ResultSet rs=stmt.executeQuery(sql);
        
        while(rs.next()){
        
            String invID=rs.getString("invoice_no");
            
            if(invID.equals(inv.getInvoiceNo())){
                invoiceExists=false;
            }
        }
        
        return invoiceExists;
    }
    
    
        //auto generate invoice ID method
    public static String nextInvoiceID() throws ClassNotFoundException,SQLException{
    
        String nextInvID="No Invoice No";
        
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="SELECT COUNT(invoice_no) FROM invoice";
        ResultSet rs=stmt.executeQuery(sql);
        
        rs.next();
        int invoicesCount=rs.getInt(1)+1;
        
        nextInvID="T-"+invoicesCount;
        
        return nextInvID;
    }
    
    
    
    
}
