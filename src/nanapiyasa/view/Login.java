/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.ijse.sms.controller.UserAccountController;

/**
 *
 * @author Randula
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        try {
            String array[] = UserAccountController.viewUser();
            for (String d : array) {
                userCombo.addItem(d);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void checkPassword(){
        String userName = (String) userCombo.getSelectedItem();
        String password = String.valueOf(passwordTxt.getPassword());

        try {
            String pass = UserAccountController.matchPassword(userName);
            String type=UserAccountController.selectType(userName);
            if (pass.equals(password)) {
                if(type.equals("Admin")){
                    NanapiyasaHome f1 = new NanapiyasaHome("Admin");
                    f1.setVisible(true);
                    this.dispose();
                }else{
                    NanapiyasaHome f1 = new NanapiyasaHome("User");
                    f1.setVisible(true);
                    this.dispose();
                }
            } else {
                verification.setText("Please check your password and username again");
                passwordTxt.setText(null);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        exitLbl = new javax.swing.JLabel();
        logInBtn = new javax.swing.JButton();
        verification = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login...");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userCombo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        userCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userComboActionPerformed(evt);
            }
        });
        getContentPane().add(userCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 240, 40));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 60, 20));

        passwordTxt.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        passwordTxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        passwordTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTxtActionPerformed(evt);
            }
        });
        getContentPane().add(passwordTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 240, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("User Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 70, 20));

        exitLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/power.png"))); // NOI18N
        exitLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLblMouseClicked(evt);
            }
        });
        exitLbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                exitLblKeyPressed(evt);
            }
        });
        getContentPane().add(exitLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, 70, 70));

        logInBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/login btn.png"))); // NOI18N
        logInBtn.setContentAreaFilled(false);
        logInBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInBtnActionPerformed(evt);
            }
        });
        getContentPane().add(logInBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 440, 252, 44));

        verification.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        verification.setForeground(new java.awt.Color(255, 0, 0));
        verification.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(verification, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 240, 70));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/login.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitLblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_exitLblKeyPressed

    }//GEN-LAST:event_exitLblKeyPressed

    private void exitLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLblMouseClicked
        this.dispose();
    }//GEN-LAST:event_exitLblMouseClicked

    private void logInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInBtnActionPerformed
        checkPassword();

    }//GEN-LAST:event_logInBtnActionPerformed

    private void passwordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTxtActionPerformed
         checkPassword();
    }//GEN-LAST:event_passwordTxtActionPerformed

    private void userComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userComboActionPerformed
       passwordTxt.requestFocusInWindow();
    }//GEN-LAST:event_userComboActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exitLbl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton logInBtn;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JComboBox userCombo;
    private javax.swing.JLabel verification;
    // End of variables declaration//GEN-END:variables
}
