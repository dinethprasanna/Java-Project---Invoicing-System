
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
    
}
