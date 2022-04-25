
package Admin;

public class Admin {
    
    //member variables
    private String adminID;
    private String adminName;
    private String adminPassword;
    
    //constructors

    public Admin() {
    }

    public Admin(String adminID, String adminName, String adminPassword) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    
    //setters
    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
    
    //getters

    public String getAdminID() {
        return adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }
    
    
}
