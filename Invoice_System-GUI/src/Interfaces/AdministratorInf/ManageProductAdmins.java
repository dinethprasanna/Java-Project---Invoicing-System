/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.AdministratorInf;

import Interfaces.AdministratorInf.AdminPanel;
import DBConnection.DBConnector;
import Product.Product;
import Product.ProductController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Namal Prdeep
 */
public class ManageProductAdmins extends javax.swing.JFrame {

    /**
     * Creates new form ManageCustomers
     */
    public ManageProductAdmins() throws ClassNotFoundException, SQLException {
        initComponents();
        setResizable(false);
        productTableLoad();
        
    }
    
    //this method for load the product table data inside gui table
    public void productTableLoad() throws ClassNotFoundException,SQLException{
    
        ResultSet rs=ProductController.getProducts();
        manageProductTable.setModel(DbUtils.resultSetToTableModel(rs));
    }
    
    //this method for set the table data to text boxes
    public void setProductTableData(){
    
        int r =manageProductTable.getSelectedRow();
        
        String proID=manageProductTable.getValueAt(r,0).toString();
        String proName=manageProductTable.getValueAt(r,1).toString();
        String proDescription=manageProductTable.getValueAt(r,2).toString();
        String purchasePrice=manageProductTable.getValueAt(r,3).toString();
        String sellingPrice=manageProductTable.getValueAt(r,4).toString();
        String quantity=manageProductTable.getValueAt(r,5).toString();
        
        productIDBox.setText(proID);
        productNameBox.setText(proName);
        productDescriptionBox.setText(proDescription);
        productPurchasePriceBox.setText(purchasePrice);
        productSellingPriceBox.setText(sellingPrice);
        productQuantityBox.setText(quantity);
        
    }
    
    //this for clear all texboxes
    public void clearFields(){
        
        productIDBox.setText("");
        productNameBox.setText("");
        productDescriptionBox.setText("");
        productPurchasePriceBox.setText("");
        productSellingPriceBox.setText("");
        productQuantityBox.setText("");
    }
    
    //this for search mechanism
    public void searchProduct() throws ClassNotFoundException,SQLException{
    
        String srch=searchProductBox.getText();
        ResultSet rs=ProductController.searchProduct(srch);
        manageProductTable.setModel(DbUtils.resultSetToTableModel(rs));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mangeCustomerBackButton = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        searchProductBox = new javax.swing.JTextField();
        productPurchasePriceBox = new javax.swing.JTextField();
        productNameBox = new javax.swing.JTextField();
        productDescriptionBox = new javax.swing.JTextField();
        productQuantityBox = new javax.swing.JTextField();
        productSellingPriceBox = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        updateProductButton = new javax.swing.JButton();
        addProductButton = new javax.swing.JButton();
        deleteProductButton = new javax.swing.JButton();
        resetProductFieldsButton = new javax.swing.JButton();
        productIDBox = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        manageProductTable = new javax.swing.JTable();
        customerBackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 650));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mangeCustomerBackButton.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        mangeCustomerBackButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mangeCustomerBackButton.setText("Manage Products");
        jPanel1.add(mangeCustomerBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 780, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Product ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Product Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Description");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Purchase Price");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Selling Price");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Quantity");

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(0, 0, 51))); // NOI18N

        searchProductBox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        searchProductBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchProductBoxKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchProductBox)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(searchProductBox, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        productPurchasePriceBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        productNameBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        productDescriptionBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        productQuantityBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        productSellingPriceBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));

        updateProductButton.setBackground(new java.awt.Color(204, 204, 255));
        updateProductButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        updateProductButton.setForeground(new java.awt.Color(51, 51, 51));
        updateProductButton.setText("Update");
        updateProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProductButtonActionPerformed(evt);
            }
        });

        addProductButton.setBackground(new java.awt.Color(51, 153, 0));
        addProductButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        addProductButton.setForeground(new java.awt.Color(255, 255, 255));
        addProductButton.setText("Add");
        addProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductButtonActionPerformed(evt);
            }
        });

        deleteProductButton.setBackground(new java.awt.Color(51, 0, 51));
        deleteProductButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        deleteProductButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteProductButton.setText("Delete");
        deleteProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductButtonActionPerformed(evt);
            }
        });

        resetProductFieldsButton.setBackground(new java.awt.Color(0, 102, 102));
        resetProductFieldsButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        resetProductFieldsButton.setForeground(new java.awt.Color(255, 255, 255));
        resetProductFieldsButton.setText("Reset");
        resetProductFieldsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetProductFieldsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resetProductFieldsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(addProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(updateProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(deleteProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addProductButton)
                    .addComponent(updateProductButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetProductFieldsButton)
                    .addComponent(deleteProductButton))
                .addGap(22, 22, 22))
        );

        productIDBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        productIDBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productIDBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productNameBox, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(productPurchasePriceBox)
                            .addComponent(productDescriptionBox)
                            .addComponent(productSellingPriceBox)
                            .addComponent(productQuantityBox)
                            .addComponent(productIDBox))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(productIDBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productDescriptionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productPurchasePriceBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productSellingPriceBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productQuantityBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(34, 34, 34)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 390, 580));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageProductTable.setBackground(new java.awt.Color(0, 255, 204));
        manageProductTable.setModel(new javax.swing.table.DefaultTableModel(
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
        manageProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                manageProductTableMouseReleased(evt);
            }
        });
        manageProductTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                manageProductTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(manageProductTable);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 580));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 750, 580));

        customerBackButton.setBackground(new java.awt.Color(204, 204, 204));
        customerBackButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        customerBackButton.setForeground(new java.awt.Color(255, 0, 0));
        customerBackButton.setText("Back");
        customerBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerBackButtonActionPerformed(evt);
            }
        });
        jPanel1.add(customerBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 10, 90, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 650));

        setSize(new java.awt.Dimension(1170, 689));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductButtonActionPerformed

        try {
            Product p1=new Product();
            p1.setProductID(productIDBox.getText());
            p1.setProductName(productNameBox.getText());
            p1.setDescription(productDescriptionBox.getText());
            p1.setPurchasePrice(Double.parseDouble(productPurchasePriceBox.getText()));
            p1.setSellingPrice(Double.parseDouble(productSellingPriceBox.getText()));
            p1.setQuantity(Integer.parseInt(productQuantityBox.getText()));
            
            int i=ProductController.addProduct(p1);
            if(i!=0){
                JOptionPane.showMessageDialog(null,"Product Added");
                productTableLoad();
                clearFields();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageProductAdmins.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageProductAdmins.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_addProductButtonActionPerformed

    private void customerBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerBackButtonActionPerformed
        
        AdminPanel adminPanel2=new AdminPanel();
        adminPanel2.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_customerBackButtonActionPerformed

    private void resetProductFieldsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetProductFieldsButtonActionPerformed
        clearFields();
    }//GEN-LAST:event_resetProductFieldsButtonActionPerformed

    private void manageProductTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_manageProductTableKeyReleased
        
        setProductTableData();
        
    }//GEN-LAST:event_manageProductTableKeyReleased

    private void manageProductTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageProductTableMouseReleased
        
        setProductTableData();
    }//GEN-LAST:event_manageProductTableMouseReleased

    private void updateProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateProductButtonActionPerformed
        
        try {
            Product p2=new Product();
            p2.setProductID(productIDBox.getText());
            p2.setProductName(productNameBox.getText());
            p2.setDescription(productDescriptionBox.getText());
            p2.setPurchasePrice(Double.parseDouble(productPurchasePriceBox.getText()));
            p2.setSellingPrice(Double.parseDouble(productSellingPriceBox.getText()));
            p2.setQuantity(Integer.parseInt(productQuantityBox.getText()));
            
            int i=ProductController.updateProduct(p2);
            if(i!=0){
                JOptionPane.showMessageDialog(null,"Product Updated");
                productTableLoad();
                clearFields();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageProductAdmins.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageProductAdmins.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_updateProductButtonActionPerformed

    private void deleteProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductButtonActionPerformed
        
        try {
            Product p3=new Product();
            p3.setProductID(productIDBox.getText());
            
            int i=ProductController.deleteProduct(p3);
            if(i!=0){
                JOptionPane.showMessageDialog(null,"Product Deleted");
                productTableLoad();
                clearFields();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageProductAdmins.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageProductAdmins.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_deleteProductButtonActionPerformed

    private void searchProductBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchProductBoxKeyReleased
        
        try {
            searchProduct();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageProductAdmins.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageProductAdmins.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchProductBoxKeyReleased

    private void productIDBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productIDBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productIDBoxActionPerformed

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
            java.util.logging.Logger.getLogger(ManageProductAdmins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageProductAdmins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageProductAdmins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageProductAdmins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                    new ManageProductAdmins().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ManageProductAdmins.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ManageProductAdmins.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProductButton;
    private javax.swing.JButton customerBackButton;
    private javax.swing.JButton deleteProductButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable manageProductTable;
    private javax.swing.JLabel mangeCustomerBackButton;
    private javax.swing.JTextField productDescriptionBox;
    private javax.swing.JTextField productIDBox;
    private javax.swing.JTextField productNameBox;
    private javax.swing.JTextField productPurchasePriceBox;
    private javax.swing.JTextField productQuantityBox;
    private javax.swing.JTextField productSellingPriceBox;
    private javax.swing.JButton resetProductFieldsButton;
    private javax.swing.JTextField searchProductBox;
    private javax.swing.JButton updateProductButton;
    // End of variables declaration//GEN-END:variables
}