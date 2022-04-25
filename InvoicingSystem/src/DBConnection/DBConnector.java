
package DBConnection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class DBConnector {
    public static Connection getConnection()throws ClassNotFoundException,SQLException{
    
        Connection con;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/invoicesystem","root", "");
        return con;
    }
}
