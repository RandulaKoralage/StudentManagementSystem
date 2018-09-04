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
import com.ijse.sms.controller.ExaminationController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.Examination;

/**
 *
 * @author Randula
 */
public class ModifyExams extends javax.swing.JDialog {

    /**
     * Creates new form ModifyExams
     */
    public ModifyExams(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getCourseList();
    }

    private void getExamList() {
        try {
            String year = yearTxt.getText();
            
            examIdCombo.removeAllItems();
            examIdCombo.addItem("none");
            String[] array = ExaminationController.examIdOfAYear(year);
            for (String id : array) {
                examIdCombo.addItem(id);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getCourseList(){
        try {
            String array[]=CourseController.viewCourses();
            courseCombo.setSelectedItem("none");
            for(String name:array){
                courseCombo.addItem(name);
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

        editBtn1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        deleteBtn1 = new javax.swing.JLabel();
        clearBtn2 = new javax.swing.JButton();
        placeTxt = new javax.swing.JTextField();
        placeLbl1 = new javax.swing.JLabel();
        timeLbl1 = new javax.swing.JLabel();
        timeTxt = new javax.swing.JTextField();
        dateTxt = new javax.swing.JTextField();
        dateLbl1 = new javax.swing.JLabel();
        feeLbl1 = new javax.swing.JLabel();
        feeTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        examNameLbl1 = new javax.swing.JLabel();
        courseIdLbl1 = new javax.swing.JLabel();
        examIdCombo = new javax.swing.JComboBox();
        examIdLbl1 = new javax.swing.JLabel();
        courseCombo = new javax.swing.JComboBox();
        nameLbl1 = new javax.swing.JLabel();
        yearTxt = new javax.swing.JTextField();
        placeLbl = new javax.swing.JLabel();
        typeCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modify Examinations");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Edit.png"))); // NOI18N
        editBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtn1MouseClicked(evt);
            }
        });
        getContentPane().add(editBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, 80, 70));

        jLabel6.setText("Save Changes");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 490, 70, 20));

        jLabel7.setText("Remove");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 490, 50, 20));

        deleteBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Delete.png"))); // NOI18N
        deleteBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtn1MouseClicked(evt);
            }
        });
        getContentPane().add(deleteBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, 70, 70));

        clearBtn2.setBackground(new java.awt.Color(255, 233, 248));
        clearBtn2.setText("Clear");
        clearBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtn2ActionPerformed(evt);
            }
        });
        getContentPane().add(clearBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 110, 30));

        placeTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(placeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 450, 35));

        placeLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        placeLbl1.setText("Place");
        getContentPane().add(placeLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 60, 30));

        timeLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        timeLbl1.setText("Time");
        getContentPane().add(timeLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 70, 30));

        timeTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        timeTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                timeTxtKeyTyped(evt);
            }
        });
        getContentPane().add(timeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 450, 35));

        dateTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(dateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 450, 35));

        dateLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dateLbl1.setText(" Date");
        getContentPane().add(dateLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 60, 30));

        feeLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        feeLbl1.setText(" Fee");
        getContentPane().add(feeLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 70, 30));

        feeTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        feeTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                feeTxtKeyTyped(evt);
            }
        });
        getContentPane().add(feeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 450, 35));

        nameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(nameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 450, 35));

        examNameLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        examNameLbl1.setText("Name");
        getContentPane().add(examNameLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 70, 35));

        courseIdLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        courseIdLbl1.setText("Course ID");
        getContentPane().add(courseIdLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 60, 30));

        examIdCombo.setEditable(true);
        examIdCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        examIdCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        examIdCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                examIdComboFocusGained(evt);
            }
        });
        examIdCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examIdComboActionPerformed(evt);
            }
        });
        getContentPane().add(examIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 450, 40));

        examIdLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        examIdLbl1.setText("Exam ID");
        getContentPane().add(examIdLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 70, 40));

        courseCombo.setEditable(true);
        courseCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        courseCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        courseCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseComboActionPerformed(evt);
            }
        });
        getContentPane().add(courseCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 450, 40));

        nameLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl1.setText("Academic Year");
        getContentPane().add(nameLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 90, 40));

        yearTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        yearTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearTxtActionPerformed(evt);
            }
        });
        yearTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                yearTxtKeyTyped(evt);
            }
        });
        getContentPane().add(yearTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 450, 40));

        placeLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        placeLbl.setText("Type");
        getContentPane().add(placeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 40, 40));

        typeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Final", "Repeate" }));
        getContentPane().add(typeCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 450, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clearBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearBtn2ActionPerformed

    private void yearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTxtActionPerformed

    }//GEN-LAST:event_yearTxtActionPerformed

    private void yearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTxtKeyTyped

        if (yearTxt.getText().length() == 3) {
            examIdCombo.requestFocusInWindow();

        }
    }//GEN-LAST:event_yearTxtKeyTyped

    private void examIdComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_examIdComboFocusGained
        getExamList();
    }//GEN-LAST:event_examIdComboFocusGained

    private void courseComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseComboActionPerformed
   
    }//GEN-LAST:event_courseComboActionPerformed

    private void examIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examIdComboActionPerformed
             String eId = (String) examIdCombo.getSelectedItem();
        if (eId != "none") {
            try {

                Examination examination = ExaminationController.searchExamination(eId);
                if (examination != null) {
                    nameTxt.setText(examination.getExamName());
                    feeTxt.setText(Double.toString(examination.getExamFee()));
                    timeTxt.setText(Double.toString(examination.getExamTime()));
                    placeTxt.setText(examination.getPlace());
                    dateTxt.setText(examination.getExamDate());
                    typeCombo.setSelectedItem(examination.getExamType());
                    String cId=examination.getCourseID();
                    String courseName=CourseController.matchName(cId);
                    
                    courseCombo.setSelectedItem(courseName);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ModifyCourses.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ModifyCourses.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            nameTxt.setText(null);
            feeTxt.setText(null);
            placeTxt.setText(null);
            timeTxt.setText(null);
            dateTxt.setText(null);
        }

    }//GEN-LAST:event_examIdComboActionPerformed

    private void editBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtn1MouseClicked
         int res=JOptionPane.showOptionDialog(this, "Dou you want to save changes?","Options", 0,0,null,null,null );
            if(res==0){  
        try {
            String id=(String)examIdCombo.getSelectedItem();
            String courseName=(String)courseCombo.getSelectedItem();
            String cId=CourseController.matchId(courseName);
            double fee=Double.parseDouble(feeTxt.getText());
            String name=nameTxt.getText();
            double time=Double.parseDouble(timeTxt.getText());
            String date=dateTxt.getText();
            String place=placeTxt.getText();
            String type=(String)typeCombo.getSelectedItem();
             Examination examination=new Examination(id, cId, name, fee, time, date, place,type);
            boolean isUpdate=ExaminationController.updateExamination(examination);
            if(isUpdate){
                JOptionPane.showMessageDialog(this, "Saved Changes");
                getExamList();
            }else{
                  JOptionPane.showMessageDialog(this, "Can not update Class Details");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModifyClasses.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModifyClasses.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
    }//GEN-LAST:event_editBtn1MouseClicked

    private void deleteBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtn1MouseClicked
                                         
         int res=JOptionPane.showOptionDialog(this, "Dou you want to delete this Class Detail?","Options", 0,0,null,null,null );
        if(res==0){
             String eId=(String)examIdCombo.getSelectedItem();
            
            try {
                boolean isDeleted=ExaminationController.deleteExamination(eId);
                if(isDeleted){
                    JOptionPane.showMessageDialog(this, "Successfully Deleted");
                    examIdCombo.removeAllItems();
                    getExamList();
                    
                }else{
                    JOptionPane.showMessageDialog(this, "Try Again");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageCertificate.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ManageCertificate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteBtn1MouseClicked

    private void feeTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_feeTxtKeyTyped
        Validation.priceText(feeTxt);
    }//GEN-LAST:event_feeTxtKeyTyped

    private void timeTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timeTxtKeyTyped
        Validation.priceText(timeTxt);
    }//GEN-LAST:event_timeTxtKeyTyped

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
            java.util.logging.Logger.getLogger(ModifyExams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyExams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyExams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyExams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModifyExams dialog = new ModifyExams(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton clearBtn2;
    private javax.swing.JComboBox courseCombo;
    private javax.swing.JLabel courseIdLbl1;
    private javax.swing.JLabel dateLbl1;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JLabel deleteBtn1;
    private javax.swing.JLabel editBtn1;
    private javax.swing.JComboBox examIdCombo;
    private javax.swing.JLabel examIdLbl1;
    private javax.swing.JLabel examNameLbl1;
    private javax.swing.JLabel feeLbl1;
    private javax.swing.JTextField feeTxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel nameLbl1;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel placeLbl;
    private javax.swing.JLabel placeLbl1;
    private javax.swing.JTextField placeTxt;
    private javax.swing.JLabel timeLbl1;
    private javax.swing.JTextField timeTxt;
    private javax.swing.JComboBox typeCombo;
    private javax.swing.JTextField yearTxt;
    // End of variables declaration//GEN-END:variables
}
