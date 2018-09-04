/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.ijse.sms.controller.LecturerController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.Lecturer;
/**
 *
 * @author Randula
 */
public class ModifyLecturers extends javax.swing.JDialog {

    /**
     * Creates new form ModifyLecturers
     */
    public ModifyLecturers(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        arrangeIdCombo();
    }

    private void arrangeIdCombo(){
        try {
            String[] array=LecturerController.viewLectId();
            lectIdCombo.addItem("none");
            for(String id:array){
                lectIdCombo.addItem(id);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModifyLecturers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModifyLecturers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telLbl1 = new javax.swing.JLabel();
        addressTxt = new javax.swing.JTextField();
        deleteBtn = new javax.swing.JLabel();
        editBtn = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        dobTxt = new javax.swing.JTextField();
        telTxt = new javax.swing.JTextField();
        nameLbl2 = new javax.swing.JLabel();
        dobLbl1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lectIdLbl1 = new javax.swing.JLabel();
        clearBtn1 = new javax.swing.JButton();
        addressLbl1 = new javax.swing.JLabel();
        lectIdCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modify Lecturer");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        telLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        telLbl1.setText("Telephone");
        getContentPane().add(telLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 70, 40));

        addressTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(addressTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 440, 35));

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Delete.png"))); // NOI18N
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });
        getContentPane().add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, 70, 70));

        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Edit.png"))); // NOI18N
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtnMouseClicked(evt);
            }
        });
        getContentPane().add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 80, 70));

        nameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(nameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 440, 35));

        dobTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(dobTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 440, 35));

        telTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        telTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telTxtKeyTyped(evt);
            }
        });
        getContentPane().add(telTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 440, 35));

        nameLbl2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl2.setText("Name  ");
        getContentPane().add(nameLbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 50, 30));

        dobLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dobLbl1.setText("DOB");
        getContentPane().add(dobLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 80, 30));

        jLabel5.setText("Save Changes");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, 70, 20));

        jLabel3.setText("Remove");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 50, 20));

        lectIdLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lectIdLbl1.setText("Lecturer ID");
        getContentPane().add(lectIdLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 70, 40));

        clearBtn1.setBackground(new java.awt.Color(255, 233, 248));
        clearBtn1.setText("Clear");
        getContentPane().add(clearBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 110, 30));

        addressLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        addressLbl1.setText("Address");
        getContentPane().add(addressLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 185, 60, 30));

        lectIdCombo.setEditable(true);
        lectIdCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        lectIdCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lectIdComboActionPerformed(evt);
            }
        });
        getContentPane().add(lectIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 440, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lectIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lectIdComboActionPerformed
          String lectId=(String)lectIdCombo.getSelectedItem();
        if(lectId!="none"){
        try {
            
            Lecturer lecturer=LecturerController.searchLecturer(lectId);
            if(lecturer!=null){
                nameTxt.setText(lecturer.getLectName());
                addressTxt.setText(lecturer.getLectAddress());
                telTxt.setText(lecturer.getLectTelephone());
                dobTxt.setText(lecturer.getLectDOB());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModifyCourses.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModifyCourses.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
                nameTxt.setText(null);
                addressTxt.setText(null);
                telTxt.setText(null);
                dobTxt.setText(null);
        }
        
    }//GEN-LAST:event_lectIdComboActionPerformed

    private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked
      int res=JOptionPane.showOptionDialog(this, "Dou you want to save changes?","Options", 0,0,null,null,null );
            if(res==0){
        try {
            String lecId=(String)lectIdCombo.getSelectedItem();
            String name=nameTxt.getText();
            String address=addressTxt.getText();
            String tel=telTxt.getText();
            String dob=dobTxt.getText();
            Lecturer lecturer=new Lecturer(lecId, name, address, tel, dob);
            
            boolean isUpdated=LecturerController.updateLecturer(lecturer);
            if(isUpdated){
                JOptionPane.showMessageDialog(this, "Saved Changes"); 
            }else{
                JOptionPane.showMessageDialog(this, "Can not update Course Details");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModifyLecturers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModifyLecturers.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
    }//GEN-LAST:event_editBtnMouseClicked

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
         int res=JOptionPane.showOptionDialog(this, "Dou you want to delete this Lecturer Detail?","Options", 0,0,null,null,null );
        if(res==0){
             String lectId=(String)lectIdCombo.getSelectedItem();
            
            try {
                boolean isDeleted=LecturerController.deleteLecturer(lectId);
                if(isDeleted){
                    JOptionPane.showMessageDialog(this, "Successfully Deleted");
                    lectIdCombo.removeAllItems();
                    arrangeIdCombo();
                }else{
                    JOptionPane.showMessageDialog(this, "Try Again");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageCertificate.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ManageCertificate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteBtnMouseClicked

    private void telTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telTxtKeyTyped
        Validation.phoneNumber(telTxt, evt);
    }//GEN-LAST:event_telTxtKeyTyped

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
            java.util.logging.Logger.getLogger(ModifyLecturers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyLecturers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyLecturers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyLecturers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModifyLecturers dialog = new ModifyLecturers(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLbl1;
    private javax.swing.JTextField addressTxt;
    private javax.swing.JButton clearBtn1;
    private javax.swing.JLabel deleteBtn;
    private javax.swing.JLabel dobLbl1;
    private javax.swing.JTextField dobTxt;
    private javax.swing.JLabel editBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox lectIdCombo;
    private javax.swing.JLabel lectIdLbl1;
    private javax.swing.JLabel nameLbl2;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel telLbl1;
    private javax.swing.JTextField telTxt;
    // End of variables declaration//GEN-END:variables
}
