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
import com.ijse.sms.controller.CourseController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.Course;

/**
 *
 * @author Randula
 */
public class ModifyCourses extends javax.swing.JDialog {

    /**
     * Creates new form ModifyCourses
     */
    public ModifyCourses(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getCourseList();
    }

   public void getCourseList(){
        try {
            String array[]=CourseController.viewCourseId();
            courseIdCombo.setSelectedItem("none");
            for(String d:array){
                courseIdCombo.addItem(d);
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

        jLabel5 = new javax.swing.JLabel();
        editBtn = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        clearBtn1 = new javax.swing.JButton();
        durationTxt = new javax.swing.JTextField();
        durationLbl1 = new javax.swing.JLabel();
        descriptionLbl1 = new javax.swing.JLabel();
        descriptionTxt = new javax.swing.JTextField();
        feeTxt = new javax.swing.JTextField();
        feeLbl1 = new javax.swing.JLabel();
        nameLbl1 = new javax.swing.JLabel();
        cNameTxt = new javax.swing.JTextField();
        cIdLbl1 = new javax.swing.JLabel();
        courseIdCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modify Courses");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Save Changes");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 70, 20));

        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Edit.png"))); // NOI18N
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtnMouseClicked(evt);
            }
        });
        getContentPane().add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 80, 70));

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Delete.png"))); // NOI18N
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });
        getContentPane().add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 70, 70));

        jLabel3.setText("Remove");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 50, 20));

        clearBtn1.setBackground(new java.awt.Color(255, 233, 248));
        clearBtn1.setText("Clear");
        clearBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtn1ActionPerformed(evt);
            }
        });
        getContentPane().add(clearBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 110, 30));

        durationTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(durationTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 470, 35));

        durationLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        durationLbl1.setText("Duration");
        getContentPane().add(durationLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 60, 20));

        descriptionLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        descriptionLbl1.setText("Description");
        getContentPane().add(descriptionLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 70, 20));

        descriptionTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(descriptionTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 470, 35));

        feeTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        feeTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                feeTxtKeyTyped(evt);
            }
        });
        getContentPane().add(feeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 470, 35));

        feeLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        feeLbl1.setText("Fee");
        getContentPane().add(feeLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 60, 35));

        nameLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl1.setText("Name  ");
        getContentPane().add(nameLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 50, 20));

        cNameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(cNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 470, 35));

        cIdLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cIdLbl1.setText("Course ID");
        getContentPane().add(cIdLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 70, 40));

        courseIdCombo.setEditable(true);
        courseIdCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        courseIdCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseIdComboActionPerformed(evt);
            }
        });
        getContentPane().add(courseIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 470, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked
        int res=JOptionPane.showOptionDialog(this, "Dou you want to save changes?","Options", 0,0,null,null,null );
            if(res==0){
                try {
                    String cId=(String)courseIdCombo.getSelectedItem();
                    String name=cNameTxt.getText();
                    Double fee=Double.parseDouble(feeTxt.getText());
                    String description=descriptionTxt.getText();
                    String duration=durationTxt.getText();
                    
                    Course course=new Course(cId, name, res, duration, description);
                    
                    
                    boolean isUpdated=CourseController.updateCourse(course);
                    if(isUpdated){
                        JOptionPane.showMessageDialog(this, "Saved Changes");
                    }else{
                        JOptionPane.showMessageDialog(this, "Can not update Course Details");
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ModifyCertificates.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ModifyCertificates.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
    }//GEN-LAST:event_editBtnMouseClicked

    private void clearBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtn1ActionPerformed
        courseIdCombo.removeAllItems();
        getCourseList();
        cNameTxt.setText(null);
        feeTxt.setText(null);
        durationTxt.setText(null);
        descriptionTxt.setText(null);
    }//GEN-LAST:event_clearBtn1ActionPerformed

    private void courseIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseIdComboActionPerformed
        String cId=(String)courseIdCombo.getSelectedItem();
        if(cId!="none"){
        try {
            
            Course course=CourseController.searchCourse(cId);
            if(course!=null){
                cNameTxt.setText(course.getCourseName());
                feeTxt.setText(Double.toString(course.getCourseFee()));
                descriptionTxt.setText(course.getDescription());
                durationTxt.setText(course.getCourseDuration());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModifyCourses.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModifyCourses.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
                cNameTxt.setText(null);
                feeTxt.setText(null);
                descriptionTxt.setText(null);
                durationTxt.setText(null);
        }
        
    }//GEN-LAST:event_courseIdComboActionPerformed

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
       int res=JOptionPane.showOptionDialog(this, "Dou you want to delete this Course Detail?","Options", 0,0,null,null,null );
        if(res==0){
             String cId=(String)courseIdCombo.getSelectedItem();
            
            try {
                boolean isDeleted=CourseController.deleteCourse(cId);
                if(isDeleted){
                    JOptionPane.showMessageDialog(this, "Successfully Deleted");
                    courseIdCombo.removeAllItems();
                    getCourseList();
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

    private void feeTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_feeTxtKeyTyped
        Validation.priceText(feeTxt);
    }//GEN-LAST:event_feeTxtKeyTyped

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
            java.util.logging.Logger.getLogger(ModifyCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModifyCourses dialog = new ModifyCourses(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel cIdLbl1;
    private javax.swing.JTextField cNameTxt;
    private javax.swing.JButton clearBtn1;
    private javax.swing.JComboBox courseIdCombo;
    private javax.swing.JLabel deleteBtn;
    private javax.swing.JLabel descriptionLbl1;
    private javax.swing.JTextField descriptionTxt;
    private javax.swing.JLabel durationLbl1;
    private javax.swing.JTextField durationTxt;
    private javax.swing.JLabel editBtn;
    private javax.swing.JLabel feeLbl1;
    private javax.swing.JTextField feeTxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel nameLbl1;
    // End of variables declaration//GEN-END:variables
}
