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
import com.ijse.sms.controller.ExaminationController;
import com.ijse.sms.controller.ResultTableController;
import com.ijse.sms.controller.StudentController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.ResultTable;

/**
 *
 * @author Randula
 */
public class ModifyMarks extends javax.swing.JDialog {

    /**
     * Creates new form ModifyMatks
     */
    public ModifyMarks(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void getExamList() {
        try {
            String year = yearTxt.getText();

            examCombo.removeAllItems();
            examCombo.addItem("none");
            String[] array = ExaminationController.examIdOfAYear(year);
            for (String id : array) {
                examCombo.addItem(id);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getStudentList() {
        if (examCombo.getSelectedItem() != "none") {
            try {
                String eId = (String) examCombo.getSelectedItem();

                studentCombo.removeAllItems();
                studentCombo.addItem("none");
                String[] array = StudentController.studentForExams(eId);
                for (String name : array) {
                    studentCombo.addItem(name);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void getResult() {
        if (studentCombo.getSelectedItem() != "none" && examCombo.getSelectedItem() != "none") {
            try {
                String name = (String) studentCombo.getSelectedItem();
                String stId = StudentController.getStIdFromName(name);

                String eId = (String) examCombo.getSelectedItem();

                ResultTable resultTable = ResultTableController.searchResultByIds(eId, stId);
                if (resultTable != null) {
                    resultTxt.setText(resultTable.getResultID());
                    practicalTxt.setText(Double.toString(resultTable.getPracticalMark()));
                    theoryTxt.setText(Double.toString(resultTable.getTheoryMark()));
                    gradeTxt.setText(resultTable.getGrade());
                    statusTxt.setText(resultTable.getStatus());
                } else {
                    JOptionPane.showMessageDialog(this, " Result Does Not Exist");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ModifyMarks.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ModifyMarks.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            resultTxt.setText(null);
            practicalTxt.setText(null);
            theoryTxt.setText(null);
            gradeTxt.setText(null);
            statusTxt.setText(null);
        }

    }
private void getGrade() {
        
       double pm=Double.parseDouble(practicalTxt.getText());
         double tm=Double.parseDouble(theoryTxt.getText());
        double tot=pm+tm;
        double avg=tot/2;
          

            String grade = "A";
            if (avg >= 75) {
                grade = "A";
            } else if (avg >= 65) {
                grade = "B";
            } else if (avg >= 55) {
                grade = "C";
            } else if (avg >= 35) {
                grade = "S";
            } else {
                grade = "F";
            }
          gradeTxt.setText(grade);
        if (grade.equals("F")) {
               statusTxt.setText("Repeate");
            } else {
                 statusTxt.setText("Pass");
            }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusLbl1 = new javax.swing.JLabel();
        statusTxt = new javax.swing.JTextField();
        gradeTxt = new javax.swing.JTextField();
        practicalTxt = new javax.swing.JTextField();
        gradeLbl1 = new javax.swing.JLabel();
        theoryLbl1 = new javax.swing.JLabel();
        theoryTxt = new javax.swing.JTextField();
        practicalLbl1 = new javax.swing.JLabel();
        stIdLbl1 = new javax.swing.JLabel();
        studentCombo = new javax.swing.JComboBox();
        examIdLbl1 = new javax.swing.JLabel();
        resultIdLbl1 = new javax.swing.JLabel();
        clearBtn3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        deleteBtn1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        editBtn1 = new javax.swing.JLabel();
        resultTxt = new javax.swing.JTextField();
        nameLbl1 = new javax.swing.JLabel();
        yearTxt = new javax.swing.JTextField();
        examCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modify Marks");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        statusLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        statusLbl1.setText("Status");
        getContentPane().add(statusLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 60, 30));

        statusTxt.setEditable(false);
        statusTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(statusTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 370, 35));

        gradeTxt.setEditable(false);
        gradeTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(gradeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 370, 35));

        practicalTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        practicalTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                practicalTxtActionPerformed(evt);
            }
        });
        practicalTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                practicalTxtKeyTyped(evt);
            }
        });
        getContentPane().add(practicalTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 370, 35));

        gradeLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        gradeLbl1.setText("Grade");
        getContentPane().add(gradeLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 70, 30));

        theoryLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        theoryLbl1.setText("Theory Marks");
        getContentPane().add(theoryLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 90, 20));

        theoryTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        theoryTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theoryTxtActionPerformed(evt);
            }
        });
        theoryTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                theoryTxtKeyTyped(evt);
            }
        });
        getContentPane().add(theoryTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 370, 35));

        practicalLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        practicalLbl1.setText("Practical Marks");
        getContentPane().add(practicalLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, 20));

        stIdLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        stIdLbl1.setText("Student ID");
        getContentPane().add(stIdLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 89, 35));

        studentCombo.setEditable(true);
        studentCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        studentCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        studentCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentComboFocusGained(evt);
            }
        });
        studentCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentComboActionPerformed(evt);
            }
        });
        getContentPane().add(studentCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 370, 40));

        examIdLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        examIdLbl1.setText("Exam ID");
        getContentPane().add(examIdLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 60, 20));

        resultIdLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        resultIdLbl1.setText("Result ID");
        getContentPane().add(resultIdLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 70, 20));

        clearBtn3.setBackground(new java.awt.Color(255, 233, 248));
        clearBtn3.setText("Clear");
        clearBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtn3ActionPerformed(evt);
            }
        });
        getContentPane().add(clearBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 110, 30));

        jLabel7.setText("Remove");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 490, 50, 20));

        deleteBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Delete.png"))); // NOI18N
        deleteBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtn1MouseClicked(evt);
            }
        });
        getContentPane().add(deleteBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, 70, 70));

        jLabel6.setText("Save Changes");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, 70, 20));

        editBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Edit.png"))); // NOI18N
        editBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtn1MouseClicked(evt);
            }
        });
        getContentPane().add(editBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 80, 70));

        resultTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        resultTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                resultTxtFocusGained(evt);
            }
        });
        resultTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultTxtMouseClicked(evt);
            }
        });
        getContentPane().add(resultTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 370, 35));

        nameLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl1.setText("Exam Year");
        getContentPane().add(nameLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 70, 40));

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
        getContentPane().add(yearTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 370, 40));

        examCombo.setEditable(true);
        examCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        examCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        examCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                examComboFocusGained(evt);
            }
        });
        examCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examComboActionPerformed(evt);
            }
        });
        getContentPane().add(examCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 370, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void theoryTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theoryTxtActionPerformed
        gradeTxt.requestFocusInWindow();
        getGrade();
    }//GEN-LAST:event_theoryTxtActionPerformed

    private void yearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTxtActionPerformed

    }//GEN-LAST:event_yearTxtActionPerformed

    private void yearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTxtKeyTyped

        if (yearTxt.getText().length() == 3) {
            examCombo.requestFocusInWindow();

        }
    }//GEN-LAST:event_yearTxtKeyTyped

    private void studentComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentComboFocusGained
      
    }//GEN-LAST:event_studentComboFocusGained

    private void studentComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentComboActionPerformed
          
    }//GEN-LAST:event_studentComboActionPerformed

    private void examComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_examComboFocusGained

        getExamList();
    }//GEN-LAST:event_examComboFocusGained

    private void examComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examComboActionPerformed

        studentCombo.requestFocusInWindow();
        getStudentList();

    }//GEN-LAST:event_examComboActionPerformed

    private void resultTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_resultTxtFocusGained
if(studentCombo.getSelectedItem()!="none" && examCombo.getSelectedItem()!="none"){
             getResult();
        }

    }//GEN-LAST:event_resultTxtFocusGained

    private void resultTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultTxtMouseClicked
       
    }//GEN-LAST:event_resultTxtMouseClicked

    private void clearBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtn3ActionPerformed
        resultTxt.setText(null);
        practicalTxt.setText(null);
        theoryTxt.setText(null);
        gradeTxt.setText(null);
        statusTxt.setText(null);
    }//GEN-LAST:event_clearBtn3ActionPerformed

    private void editBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtn1MouseClicked
        int res = JOptionPane.showOptionDialog(this, "Dou you want to save changes?", "Options", 0, 0, null, null, null);
        if (res == 0) {
            try {
                String resultId = resultTxt.getText();
                String eId = (String) examCombo.getSelectedItem();
                String name = (String) studentCombo.getSelectedItem();
                String stId = StudentController.getStIdFromName(name);
                double practicalMark = Double.parseDouble(practicalTxt.getText());
                double theoryMarh = Double.parseDouble(theoryTxt.getText());
                String status = statusTxt.getText();
                String grade = gradeTxt.getText();

                ResultTable resultTable = new ResultTable(resultId, eId, stId, practicalMark, theoryMarh, grade, status);
                boolean isUpdated = ResultTableController.updateResultTable(resultTable);
                if (isUpdated) {
                    JOptionPane.showMessageDialog(this, "Saved Changes");
                    resultTxt.setText(null);
                    practicalTxt.setText(null);
                    theoryTxt.setText(null);
                    gradeTxt.setText(null);
                    statusTxt.setText(null);
                    getStudentList();
                } else {
                    JOptionPane.showMessageDialog(this, "Can not update Class Details");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ModifyMarks.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ModifyMarks.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_editBtn1MouseClicked

    private void deleteBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtn1MouseClicked
        int res = JOptionPane.showOptionDialog(this, "Dou you want to delete this Result?", "Options", 0, 0, null, null, null);
        if (res == 0) {
            String resultId = resultTxt.getText();

            try {
                boolean isDeleted = ResultTableController.deleteResultTable(resultId);
                if (isDeleted) {
                    JOptionPane.showMessageDialog(this, "Successfully Deleted");
                    resultTxt.setText(null);
                    practicalTxt.setText(null);
                    theoryTxt.setText(null);
                    gradeTxt.setText(null);
                    statusTxt.setText(null);
                    getStudentList();
                } else {
                    JOptionPane.showMessageDialog(this, "Try Again");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageCertificate.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ManageCertificate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteBtn1MouseClicked

    private void practicalTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_practicalTxtActionPerformed
       theoryTxt.requestFocusInWindow();
       getGrade();
    }//GEN-LAST:event_practicalTxtActionPerformed

    private void practicalTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_practicalTxtKeyTyped
        Validation.priceText(practicalTxt);
    }//GEN-LAST:event_practicalTxtKeyTyped

    private void theoryTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_theoryTxtKeyTyped
      Validation.priceText(theoryTxt);
    }//GEN-LAST:event_theoryTxtKeyTyped

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
            java.util.logging.Logger.getLogger(ModifyMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModifyMarks dialog = new ModifyMarks(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton clearBtn3;
    private javax.swing.JLabel deleteBtn1;
    private javax.swing.JLabel editBtn1;
    private javax.swing.JComboBox examCombo;
    private javax.swing.JLabel examIdLbl1;
    private javax.swing.JLabel gradeLbl1;
    private javax.swing.JTextField gradeTxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel nameLbl1;
    private javax.swing.JLabel practicalLbl1;
    private javax.swing.JTextField practicalTxt;
    private javax.swing.JLabel resultIdLbl1;
    private javax.swing.JTextField resultTxt;
    private javax.swing.JLabel stIdLbl1;
    private javax.swing.JLabel statusLbl1;
    private javax.swing.JTextField statusTxt;
    private javax.swing.JComboBox studentCombo;
    private javax.swing.JLabel theoryLbl1;
    private javax.swing.JTextField theoryTxt;
    private javax.swing.JTextField yearTxt;
    // End of variables declaration//GEN-END:variables
}
