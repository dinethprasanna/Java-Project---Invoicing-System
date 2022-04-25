
package Invoice;

import DBConnection.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class InvoiceItemController {

    //Item total price calculation
    public static double itemTotalPriceCalculation(double unitPrice,double discountPerUnit,int itemQuantity)throws ClassNotFoundException,SQLException{
    
        double itemTotal=0;
        
        itemTotal=(unitPrice-discountPerUnit)*itemQuantity;
        
        return itemTotal;
    }
    
    //add Invoice one particular item
    public static int addItemToInvoice(Invoice inv)throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="INSERT INTO invoice_item VALUES('"+inv.getInvoiceNo()+"','"+inv.getProductID()+"',"+inv.getUnitPerPrice()+","+inv.getItemQuantity()+","+inv.getPerItemDiscount()+","+inv.getPerItemTotal()+")";
        int i = stmt.executeUpdate(sql);
        
        return i;
    }
    
    public static ResultSet getInvoiceItem(String invoiceID)throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnection.DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="SELECT * FROM invoice_item WHERE invoice_no='"+invoiceID+"'";
        ResultSet rs=stmt.executeQuery(sql);
        return rs;
    }
    
        
    //get total Amount of current Invoice
    public static double getCurrentTotalAmountOfInvoice(String invID) throws ClassNotFoundException,SQLException{
    
        double totalAmount=0.0;
        
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="SELECT SUM(item_total_price) FROM invoice_item WHERE invoice_no='"+invID+"'";
        ResultSet rs=stmt.executeQuery(sql);
        rs.next();
        totalAmount=rs.getDouble(1);
        
        return totalAmount;
    }
    
    //get total Discount of current Invoice
    public static double getCurrentTotalDiscountOfInvoice(String invID) throws ClassNotFoundException,SQLException{
    
        double totalDiscount=0.0;
        
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        /*String sql="SELECT SUM(discount_per_unit) FROM invoice_item WHERE invoice_no='"+invID+"'";
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            totalDiscount=rs.getDouble(1);
        }
        
        */
        
        String getNoOfRows="SELECT * FROM invoice_item WHERE invoice_no='"+invID+"'";
        ResultSet rs=stmt.executeQuery(getNoOfRows);
        
        while(rs.next()){
            
            String proDiscount=rs.getString("discount_per_unit");
            String proQTY=rs.getString("quantity");
            
            totalDiscount=totalDiscount+(Double.parseDouble(proDiscount)*Double.parseDouble(proQTY));
        }
        
        return totalDiscount;
        
        
    }
    
}
