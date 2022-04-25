
package User;

import DBConnection.DBConnector;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class UserController {
    
    //login function
    public static boolean loginUser(User u)throws ClassNotFoundException,SQLException{
    
        Connection con=DBConnector.getConnection();
        Statement stmt=con.createStatement();
        String sql="select * from user where user_id='"+u.getUserID()+"' and password='"+u.getUserPassword()+"'";
        ResultSet rs=stmt.executeQuery(sql);
        boolean i=false;
        while(rs.next()){
            
            String uID=rs.getString("user_id");
            String pass=rs.getString("password");
            
            if(uID.equals(u.getUserID()) & pass.equals(u.getUserPassword())){
                i=true;
            }
        }
        
        return i;
    }
    
}
