
package Product;

import DBConnection.DBConnector;
import TaskTrack.TaskTrack;
import TaskTrack.TaskTrackController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductController {
    
    //add product 
    public static int addProduct(Product product)throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="insert into product values('"+product.getProductID()+"','"+product.getProductName()+"','"+product.getProductDescription()+"',"+product.getPurchasePrice()+","+product.getSellingPrice()+","+product.getQuantity()+")";
        int i = stmt.executeUpdate(sql);
        
        TaskTrack t1=new TaskTrack();
        t1.setTaskInformation("A New Product Added | "+product.getProductID()+"---"+product.getProductName());
        TaskTrackController.addTask(t1);
        
        return i;
    }
    
    
    //delete product
    public static int deleteProduct(Product product)throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="delete from product where product_id='"+product.getProductID()+"'";
        int i = stmt.executeUpdate(sql);
        
        TaskTrack t1=new TaskTrack();
        t1.setTaskInformation("A Product Deleted | "+product.getProductID());
        TaskTrackController.addTask(t1);
        
        return i;
    }
    
    
    //update product
    public static int updateProduct(Product product)throws ClassNotFoundException,SQLException{
    
        Connection con = DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="update product set product_name='"+product.getProductName()+"',product_description='"+product.getProductDescription()+"',purchase_price="+product.getPurchasePrice()+",selling_price="+product.getSellingPrice()+",quantity="+product.getQuantity()+" where product_id='"+product.getProductID()+"'";
        int i=stmt.executeUpdate(sql);
        
        TaskTrack t1=new TaskTrack();
        t1.setTaskInformation("A Product Updated | "+product.getProductID()+"---"+product.getProductName());
        TaskTrackController.addTask(t1);
        
        return i;
    }
    
    
    //display or retrive one product details
    public static void getProduct(Product product)throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="select * from product where product_id='"+product.getProductID()+"'";
        ResultSet rs=stmt.executeQuery(sql);
        
        while(rs.next()){
        
            String proID=rs.getString("product_id");
            String proName=rs.getString("product_name");
            String proDescription=rs.getString("product_description");
            String proPurchasePrice=rs.getString("purchase_price");
            String proSellingPrice=rs.getString("selling_price");
            String proQuantity=rs.getString("quantity");
            
            System.out.println("Product ID="+proID+"    Product Name="+proName+"    Description="+proDescription+"  "
                    + " Purchase Price="+proPurchasePrice+"     Selling Price="+proSellingPrice+"   Quantity="+proQuantity);
        }
        
    }
    
    public static ResultSet getProducts()throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="select * from product";
        ResultSet rs=stmt.executeQuery(sql);
        
        return rs;
        
    }
    
    
    //checking product quantity available or not
    public static boolean checkProductQuantityAvailability(Product pro)throws ClassNotFoundException,SQLException{
        
        boolean available;
        String availableQuantity="0";
        
        
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="SELECT quantity FROM product WHERE product_id='"+pro.getProductID()+"'";
        ResultSet rs=stmt.executeQuery(sql);
        
        while(rs.next()){
            availableQuantity=rs.getString("quantity"); 
        }
        
        int QTY=Integer.parseInt(availableQuantity);
        if(pro.getQuantity()<=QTY){
            available=true;
        }else{
            available=false;
        }
        
        return available;        
    }

    
    //check customer exists
    public static boolean checkProductExists(Product product)throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="select product_id from product where product_id='"+product.getProductID()+"'";
        ResultSet rs=stmt.executeQuery(sql);
        boolean i=false;
        while(rs.next()){
            
            String productID=rs.getString("product_id");
            
            
            if(productID.equals(product.getProductID())){
                i=true;
            }else{ i=false;}
        }
        
        return i;
    }
    
    //take product unit pice according to product id
    public static double getProductUnitPrice(Product product)throws ClassNotFoundException,SQLException{
    
        double unitPrice=0.0;
        
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="SELECT selling_price FROM product WHERE product_id='"+product.getProductID()+"'";
        ResultSet rs=stmt.executeQuery(sql);
        
        while(rs.next()){
            String productPrice=rs.getString("selling_price");
            unitPrice=Double.parseDouble(productPrice);
        }
        
        return unitPrice;
    }
    
    //update product stock
    public static int updateProductStock(Product product)throws ClassNotFoundException,SQLException{
    
        int updateRecord;
        
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="UPDATE product set quantity=quantity-"+product.getQuantity()+" WHERE product_id='"+product.getProductID()+"'";
        updateRecord=stmt.executeUpdate(sql);
        return updateRecord;
    }
    
    
    //serach product
    public static ResultSet searchProduct(String search)throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="SELECT * FROM product WHERE product_id LIKE '%"+search+"%' OR product_name LIKE '%"+search+"%' OR product_description LIKE '%"+search+"%'";
        ResultSet rs=stmt.executeQuery(sql);
        
        return rs;
    }
}
