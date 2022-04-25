/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.UserInf;

import Interfaces.SystemLoginInf;
import TaskTrack.TaskTrack;
import TaskTrack.TaskTrackController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Namal Prdeep
 */
public class UserPanel extends javax.swing.JFrame {

    /**
     * Creates new form User_panel
     */
    public UserPanel() {
        initComponents();
        setResizable(false);
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
        jLabel1 = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        userMangeCustomerButton = new javax.swing.JButton();
        userProductManageButton = new javax.swing.JButton();
        invoicesDetailsButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        invoiceGenerateButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User Panel");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 750, 70));

        exitButton.setBackground(new java.awt.Color(255, 0, 0));
        exitButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        exitButton.setForeground(new java.awt.Color(255, 255, 255));
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jPanel1.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 600, 200, 39));

        userMangeCustomerButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        userMangeCustomerButton.setText("Manage Customers");
        userMangeCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userMangeCustomerButtonActionPerformed(evt);
            }
        });
        jPanel1.add(userMangeCustomerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 356, 39));

        userProductManageButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        userProductManageButton.setText("Manage Products");
        userProductManageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userProductManageButtonActionPerformed(evt);
            }
        });
        jPanel1.add(userProductManageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 356, 39));

        invoicesDetailsButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        invoicesDetailsButton.setText("Invoices Details");
        invoicesDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoicesDetailsButtonActionPerformed(evt);
            }
        });
        jPanel1.add(invoicesDetailsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 356, 39));

        logOutButton.setBackground(new java.awt.Color(102, 102, 102));
        logOutButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        logOutButton.setForeground(new java.awt.Color(255, 255, 0));
        logOutButton.setText("LogOut");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });
        jPanel1.add(logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 530, 200, 39));

        invoiceGenerateButton1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        invoiceGenerateButton1.setText("Invoice Generation");
        invoiceGenerateButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceGenerateButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(invoiceGenerateButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 356, 39));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 660));

        setSize(new java.awt.Dimension(916, 697));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        
        try {
            TaskTrack t1=new TaskTrack();
            t1.setTaskInformation("User Logged out from the System");
            TaskTrackController.addTask(t1);
            System.exit(0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        
        try {
            SystemLoginInf sys1=new SystemLoginInf();
            
            TaskTrack t1=new TaskTrack();
            t1.setTaskInformation("User Logged out from the System");
            TaskTrackController.addTask(t1);
            
            sys1.setVisible(true);
            this.dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void userMangeCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userMangeCustomerButtonActionPerformed
        try {
            ManageCustomerUsers manageCustomer2=new ManageCustomerUsers();
            manageCustomer2.setVisible(true);
            this.dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_userMangeCustomerButtonActionPerformed

    private void userProductManageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userProductManageButtonActionPerformed
        
        try {
            ManageProductUser manageProduct1=new ManageProductUser();
            manageProduct1.setVisible(true);
            this.dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_userProductManageButtonActionPerformed

    private void invoicesDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoicesDetailsButtonActionPerformed
        
        try {
            ShowGeneratedInvoicesUser showInvoices=new ShowGeneratedInvoicesUser();
            showInvoices.setVisible(true);
            this.dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_invoicesDetailsButtonActionPerformed

    private void invoiceGenerateButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceGenerateButton1ActionPerformed
        
        try {
            InvoiceGenerateStep01User invGen1=new InvoiceGenerateStep01User();
            invGen1.setVisible(true);
            this.dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_invoiceGenerateButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(UserPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JButton invoiceGenerateButton1;
    private javax.swing.JButton invoicesDetailsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton userMangeCustomerButton;
    private javax.swing.JButton userProductManageButton;
    // End of variables declaration//GEN-END:variables
}
