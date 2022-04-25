
package DBConnection;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    
    public static Connection getConnection() throws ClassNotFoundException,SQLException{
    
        Connection con=null;
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/invoice_system_gui","root","");
            

        
        return con;
    }
}
