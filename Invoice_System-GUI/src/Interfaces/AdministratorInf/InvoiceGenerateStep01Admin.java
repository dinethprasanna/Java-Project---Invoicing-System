/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.AdministratorInf;

import Customer.CustomerController;
import Invoice.InvoiceController;
import Product.ProductController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Namal Prdeep
 */
public class InvoiceGenerateStep01Admin extends javax.swing.JFrame {

    /**
     * Creates new form ManageCustomers
     */
    public InvoiceGenerateStep01Admin() throws ClassNotFoundException,SQLException {
        initComponents();
        setResizable(false);
        customerSelectiontableLoad();
       
    }
    
    
    
    //this is for customer table load to jTable
    public void customerSelectiontableLoad() throws ClassNotFoundException,SQLException{
    
        ResultSet rs=CustomerController.getCustomers();
        customerSelectionTable.setModel(DbUtils.resultSetToTableModel(rs));
        
    }
    
    //customer search from table
    public void searchcustomerSelection()throws ClassNotFoundException,SQLException{
    
        String srch=customerSelectionSearchBox.getText();
        ResultSet rs=CustomerController.customerSearch(srch);
        customerSelectionTable.setModel(DbUtils.resultSetToTableModel(rs));
    }
    
    //display selected customer details-- setting customer details into lables
    public void setSelectedCustomerDetails(){
    
        int r=customerSelectionTable.getSelectedRow();
        
        String cusID=customerSelectionTable.getValueAt(r, 0).toString();
        String cusName=customerSelectionTable.getValueAt(r, 1).toString();
        String cusTele=customerSelectionTable.getValueAt(r, 4).toString();
        
        settingIDLable.setText(cusID);
        settingnameLable.setText(cusName);
        settingTelelable.setText(cusTele);
    }

    


    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        customerSelectionSearchBox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerSelectionTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        settingTelelable = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        settingIDLable = new javax.swing.JLabel();
        settingnameLable = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 650));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 102, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Invoice Generation");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 480, 53));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Search");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Telephone :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 310, -1, -1));

        customerSelectionSearchBox.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        customerSelectionSearchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerSelectionSearchBoxActionPerformed(evt);
            }
        });
        customerSelectionSearchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customerSelectionSearchBoxKeyReleased(evt);
            }
        });
        jPanel1.add(customerSelectionSearchBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 230, 30));

        customerSelectionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        customerSelectionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                customerSelectionTableMouseReleased(evt);
            }
        });
        customerSelectionTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customerSelectionTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(customerSelectionTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 770, 460));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Please Select a Customer");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("selected Customer Details");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, -1, -1));

        settingTelelable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        settingTelelable.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(settingTelelable, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 340, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Name :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("ID :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 170, -1, -1));

        settingIDLable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        settingIDLable.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(settingIDLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 200, -1, -1));

        settingnameLable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        settingnameLable.setForeground(new java.awt.Color(153, 0, 0));
        jPanel1.add(settingnameLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 270, -1, -1));

        jButton1.setBackground(new java.awt.Color(102, 255, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Continue");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 410, -1, -1));

        jPanel6.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1080, 590));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 0));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 30, 110, 40));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 690));

        setSize(new java.awt.Dimension(1133, 730));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void customerSelectionSearchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerSelectionSearchBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerSelectionSearchBoxActionPerformed

    private void customerSelectionSearchBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerSelectionSearchBoxKeyReleased
        try {
            searchcustomerSelection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InvoiceGenerateStep01Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceGenerateStep01Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_customerSelectionSearchBoxKeyReleased

    private void customerSelectionTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerSelectionTableKeyReleased
        setSelectedCustomerDetails();
    }//GEN-LAST:event_customerSelectionTableKeyReleased

    private void customerSelectionTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerSelectionTableMouseReleased
        setSelectedCustomerDetails();
    }//GEN-LAST:event_customerSelectionTableMouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AdminPanel admin1=new AdminPanel();
        admin1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            
            
            InvoiceGeneratesStep02Admin invGen2=new InvoiceGeneratesStep02Admin(settingIDLable.getText(),settingnameLable.getText());

            invGen2.setVisible(true);
            this.dispose();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InvoiceGenerateStep01Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceGenerateStep01Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InvoiceGenerateStep01Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceGenerateStep01Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceGenerateStep01Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceGenerateStep01Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InvoiceGenerateStep01Admin().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(InvoiceGenerateStep01Admin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(InvoiceGenerateStep01Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField customerSelectionSearchBox;
    private javax.swing.JTable customerSelectionTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel settingIDLable;
    private javax.swing.JLabel settingTelelable;
    private javax.swing.JLabel settingnameLable;
    // End of variables declaration//GEN-END:variables
}
