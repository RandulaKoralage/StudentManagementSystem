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
import com.ijse.sms.controller.CertificateController;
import com.ijse.sms.controller.ExaminationController;
import com.ijse.sms.controller.ResultTableController;
import com.ijse.sms.model.Certificate;

/**
 *
 * @author Randula
 */
public class ModifyCertificates extends javax.swing.JDialog {

    /**
     * Creates new form ModifyCertificates
     */
    public ModifyCertificates(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        //getResultList();
    }

    public void getCertificateList() {
        try {
            String eId = (String) examCombo.getSelectedItem();
            String array[] = CertificateController.viewCertificateIdListOfExam(eId);
            certIdCombo.setSelectedItem("none");
            for (String d : array) {
                certIdCombo.addItem(d);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void getResultId() {
        try {
            String eId = (String) examCombo.getSelectedItem();

            resultCombo.removeAllItems();
            resultCombo.addItem("none");
            String[] array = ResultTableController.getResultId(eId);
            for (String id : array) {
                resultCombo.addItem(id);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageCertificate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageCertificate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        editBtn = new javax.swing.JLabel();
        clearBtn2 = new javax.swing.JButton();
        deleteBtn = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        statusTxt = new javax.swing.JTextField();
        statusId1 = new javax.swing.JLabel();
        dateLbl1 = new javax.swing.JLabel();
        certIdLbl1 = new javax.swing.JLabel();
        dateTxt = new javax.swing.JTextField();
        certIdCombo = new javax.swing.JComboBox();
        nameLbl2 = new javax.swing.JLabel();
        yearTxt = new javax.swing.JTextField();
        examCombo = new javax.swing.JComboBox();
        examIdLbl2 = new javax.swing.JLabel();
        resultIdLbl2 = new javax.swing.JLabel();
        resultCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modify Certificates");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Save Changes");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 70, 20));

        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Edit.png"))); // NOI18N
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtnMouseClicked(evt);
            }
        });
        getContentPane().add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 80, 70));

        clearBtn2.setBackground(new java.awt.Color(255, 233, 248));
        clearBtn2.setText("Clear");
        clearBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtn2ActionPerformed(evt);
            }
        });
        getContentPane().add(clearBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 110, 30));

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Delete.png"))); // NOI18N
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });
        getContentPane().add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 70, 70));

        jLabel3.setText("Remove");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 440, 50, 20));

        statusTxt.setEditable(false);
        statusTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(statusTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 450, 40));

        statusId1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        statusId1.setText("Status");
        getContentPane().add(statusId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 70, 40));

        dateLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dateLbl1.setText("Date");
        getContentPane().add(dateLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 60, 35));

        certIdLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        certIdLbl1.setText("Certificate ID");
        getContentPane().add(certIdLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 80, 30));

        dateTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(dateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 450, 40));

        certIdCombo.setEditable(true);
        certIdCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        certIdCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                certIdComboActionPerformed(evt);
            }
        });
        getContentPane().add(certIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 450, 40));

        nameLbl2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl2.setText("Exam Year");
        getContentPane().add(nameLbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 70, 40));

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
        getContentPane().add(yearTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 450, 40));

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
        getContentPane().add(examCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 450, 40));

        examIdLbl2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        examIdLbl2.setText("Exam ID");
        getContentPane().add(examIdLbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 60, 20));

        resultIdLbl2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        resultIdLbl2.setText("Result ID");
        getContentPane().add(resultIdLbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, 30));

        resultCombo.setEditable(true);
        resultCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        resultCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                resultComboFocusGained(evt);
            }
        });
        resultCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultComboMouseClicked(evt);
            }
        });
        getContentPane().add(resultCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 450, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked

        int res = JOptionPane.showOptionDialog(this, "Dou you want to save changes?", "Options", 0, 0, null, null, null);
        if (res == 0) {
            try {
                String certificateId = (String) certIdCombo.getSelectedItem();
                String resultId = (String) resultCombo.getSelectedItem();
                String date = dateTxt.getText();
                String status = statusTxt.getText();

                Certificate certificate = new Certificate(certificateId, resultId, date, status);

                boolean isUpdated = CertificateController.updateCertificate(certificate);
                if (isUpdated) {
                    JOptionPane.showMessageDialog(this, "Saved Changes");
                    dateTxt.setText(null);
                    statusTxt.setText(null);
                } else {
                    JOptionPane.showMessageDialog(this, "Can not update Certificate Details");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ModifyCertificates.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ModifyCertificates.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_editBtnMouseClicked

    private void clearBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtn2ActionPerformed
        resultCombo.setSelectedItem("none");
        dateTxt.setText(null);
        statusTxt.setText(null);
    }//GEN-LAST:event_clearBtn2ActionPerformed

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
        int res = JOptionPane.showOptionDialog(this, "Dou you want to delete this Certificate Detail?", "Options", 0, 0, null, null, null);
        if (res == 0) {
            String certificateId = (String) certIdCombo.getSelectedItem();
            try {
                boolean isDeleted = CertificateController.deleteCertificate(certificateId);
                if (isDeleted) {
                    JOptionPane.showMessageDialog(this, "Successfully Deleted");
                    certIdCombo.removeAllItems();
                    getCertificateList();
                    dateTxt.setText(null);
                    statusTxt.setText(null);
                } else {
                    JOptionPane.showMessageDialog(this, "Try Again");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageCertificate.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ManageCertificate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteBtnMouseClicked

    private void certIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_certIdComboActionPerformed
        String certificateId = (String) certIdCombo.getSelectedItem();
        if (certificateId != "none") {
            try {

                Certificate certificate = CertificateController.searchCertificate(certificateId);
                if (certificate != null) {
                    resultCombo.setSelectedItem(certificate.getResultID());
                    dateTxt.setText(certificate.getIssueDate());
                    statusTxt.setText(certificate.getStatus());
                } else {
                    JOptionPane.showMessageDialog(this, "Certificate Not Found");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ModifyCertificates.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ModifyCertificates.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_certIdComboActionPerformed

    private void yearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTxtActionPerformed

    }//GEN-LAST:event_yearTxtActionPerformed

    private void yearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTxtKeyTyped

        if (yearTxt.getText().length() == 3) {
            examCombo.requestFocusInWindow();

        }
    }//GEN-LAST:event_yearTxtKeyTyped

    private void examComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_examComboFocusGained

        getExamList();
    }//GEN-LAST:event_examComboFocusGained

    private void examComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examComboActionPerformed
        resultCombo.requestFocusInWindow();
        getCertificateList();
    }//GEN-LAST:event_examComboActionPerformed

    private void resultComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_resultComboFocusGained
        getResultId();
    }//GEN-LAST:event_resultComboFocusGained

    private void resultComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultComboMouseClicked

    }//GEN-LAST:event_resultComboMouseClicked

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
            java.util.logging.Logger.getLogger(ModifyCertificates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyCertificates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyCertificates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyCertificates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModifyCertificates dialog = new ModifyCertificates(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox certIdCombo;
    private javax.swing.JLabel certIdLbl1;
    private javax.swing.JButton clearBtn2;
    private javax.swing.JLabel dateLbl1;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JLabel deleteBtn;
    private javax.swing.JLabel editBtn;
    private javax.swing.JComboBox examCombo;
    private javax.swing.JLabel examIdLbl2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel nameLbl2;
    private javax.swing.JComboBox resultCombo;
    private javax.swing.JLabel resultIdLbl2;
    private javax.swing.JLabel statusId1;
    private javax.swing.JTextField statusTxt;
    private javax.swing.JTextField yearTxt;
    // End of variables declaration//GEN-END:variables
}
