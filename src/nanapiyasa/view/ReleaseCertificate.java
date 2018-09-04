/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.ijse.sms.controller.CertificateController;
import com.ijse.sms.controller.ExaminationController;
import com.ijse.sms.controller.StudentController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.Certificate;
import com.ijse.sms.model.Student;

/**
 *
 * @author Randula
 */
public class ReleaseCertificate extends javax.swing.JPanel {

    /**
     * Creates new form ReleaseCertificate
     */
    public ReleaseCertificate() {
        initComponents();
        arrangeCombo();
    }
    
    public void arrangeCombo() {
        try {
            ArrayList<Student> studentList = StudentController.viewAllStudent();
            for (Student student : studentList) {
                studentCombo.addItem(student.getStID());
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private void getStudentList() {
        
        if (examCombo.getSelectedItem() != "none") {
            try {
                String eName = ExaminationController.matchName((String) examCombo.getSelectedItem());
                exNameTxt.setText(eName);
                String eId = (String) examCombo.getSelectedItem();
                
                studentCombo.removeAllItems();
                studentCombo.addItem("none");
                String[] array = StudentController.studentForExams(eId);
                for (String name : array) {
                    studentCombo.addItem(name);
                }
                certIdTxt.setText(null);
                dateTxt.setText(null);
                resultIdTxt.setText(null);
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void getcertificateDetail() {
        
        try {
            String eId = (String) examCombo.getSelectedItem();
            String name = (String) studentCombo.getSelectedItem();
            String stId = StudentController.getStIdFromName(name);
            
            Certificate certificate = CertificateController.searchCertificate(eId, stId);
            if (certificate != null) {
                certIdTxt.setText(certificate.getCertificateID());
                resultIdTxt.setText(certificate.getResultID());
                dateTxt.setText(certificate.getIssueDate());
                statusCombo.setSelectedItem(certificate.getStatus());
            } else {
                JOptionPane.showMessageDialog(this, "No Certificate Exists");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReleaseCertificate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReleaseCertificate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        certIdLbl = new javax.swing.JLabel();
        statusId = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        resultIdLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateTxt = new javax.swing.JTextField();
        resultIdTxt = new javax.swing.JTextField();
        certIdTxt = new javax.swing.JTextField();
        modifyBtn = new javax.swing.JButton();
        statusCombo = new javax.swing.JComboBox();
        saveBtn = new javax.swing.JButton();
        nameLbl1 = new javax.swing.JLabel();
        yearTxt = new javax.swing.JTextField();
        examCombo = new javax.swing.JComboBox();
        examIdLbl1 = new javax.swing.JLabel();
        stIdLbl1 = new javax.swing.JLabel();
        studentCombo = new javax.swing.JComboBox();
        exNameLb = new javax.swing.JLabel();
        exNameTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(900, 630));
        panel.setLayout(null);

        certIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        certIdLbl.setText("Certificate ID");
        panel.add(certIdLbl);
        certIdLbl.setBounds(180, 300, 77, 30);

        statusId.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        statusId.setText("Status");
        panel.add(statusId);
        statusId.setBounds(180, 450, 70, 20);

        dateLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dateLbl.setText("Date");
        panel.add(dateLbl);
        dateLbl.setBounds(180, 400, 60, 35);

        resultIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        resultIdLbl.setText("Result ID");
        panel.add(resultIdLbl);
        resultIdLbl.setBounds(180, 360, 70, 20);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Release Certificates");
        panel.add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 40);

        dateTxt.setEditable(false);
        dateTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        dateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTxtActionPerformed(evt);
            }
        });
        panel.add(dateTxt);
        dateTxt.setBounds(260, 400, 370, 35);

        resultIdTxt.setEditable(false);
        resultIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        resultIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultIdTxtActionPerformed(evt);
            }
        });
        panel.add(resultIdTxt);
        resultIdTxt.setBounds(260, 350, 370, 35);

        certIdTxt.setEditable(false);
        certIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        certIdTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                certIdTxtFocusGained(evt);
            }
        });
        certIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                certIdTxtActionPerformed(evt);
            }
        });
        panel.add(certIdTxt);
        certIdTxt.setBounds(260, 300, 370, 35);

        modifyBtn.setBackground(new java.awt.Color(255, 233, 248));
        modifyBtn.setText("Modify");
        modifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBtnActionPerformed(evt);
            }
        });
        panel.add(modifyBtn);
        modifyBtn.setBounds(480, 520, 110, 30);

        statusCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Not Released", "Released" }));
        panel.add(statusCombo);
        statusCombo.setBounds(260, 450, 370, 35);

        saveBtn.setBackground(new java.awt.Color(255, 233, 248));
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        panel.add(saveBtn);
        saveBtn.setBounds(280, 520, 110, 30);

        nameLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl1.setText("Exam Year");
        panel.add(nameLbl1);
        nameLbl1.setBounds(180, 100, 62, 30);

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
        panel.add(yearTxt);
        yearTxt.setBounds(260, 100, 370, 35);

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
        panel.add(examCombo);
        examCombo.setBounds(260, 150, 370, 35);

        examIdLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        examIdLbl1.setText("Exam ID");
        panel.add(examIdLbl1);
        examIdLbl1.setBounds(180, 150, 51, 40);

        stIdLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        stIdLbl1.setText("Student ID");
        panel.add(stIdLbl1);
        stIdLbl1.setBounds(180, 250, 62, 40);

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
        studentCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                studentComboKeyPressed(evt);
            }
        });
        panel.add(studentCombo);
        studentCombo.setBounds(260, 250, 370, 35);

        exNameLb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        exNameLb.setText("Exam Name");
        panel.add(exNameLb);
        exNameLb.setBounds(180, 200, 69, 30);

        exNameTxt.setEditable(false);
        exNameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        exNameTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                exNameTxtFocusGained(evt);
            }
        });
        exNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exNameTxtActionPerformed(evt);
            }
        });
        panel.add(exNameTxt);
        exNameTxt.setBounds(260, 200, 370, 35);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background2.png"))); // NOI18N
        panel.add(jLabel1);
        jLabel1.setBounds(0, 90, 835, 520);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dateTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTxtActionPerformed
        statusCombo.requestFocusInWindow();
    }//GEN-LAST:event_dateTxtActionPerformed

    private void resultIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultIdTxtActionPerformed
        dateTxt.requestFocusInWindow();
    }//GEN-LAST:event_resultIdTxtActionPerformed

    private void certIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_certIdTxtActionPerformed
        resultIdTxt.requestFocusInWindow();
    }//GEN-LAST:event_certIdTxtActionPerformed

    private void modifyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyBtnActionPerformed
        new ModifyCertificates(null, true).setVisible(true);
    }//GEN-LAST:event_modifyBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        int res = JOptionPane.showOptionDialog(this, "Dou you want to save changes?", "Options", 0, 0, null, null, null);
        if (res == 0) {
            try {
                String certificateId = certIdTxt.getText();
                String resultId = resultIdTxt.getText();
                String date = dateTxt.getText();
                String status = (String) statusCombo.getSelectedItem();
                
                Certificate certificate = new Certificate(certificateId, resultId, date, status);
                
                boolean isUpdated = CertificateController.updateCertificate(certificate);
                if (isUpdated) {
                    JOptionPane.showMessageDialog(this, "Certificate Issued");                    
                    certIdTxt.setText(null);
                    dateTxt.setText(null);
                    resultIdTxt.setText(null);
                } else {
                    JOptionPane.showMessageDialog(this, "Can not update Certificate Details");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ModifyCertificates.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ModifyCertificates.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void yearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTxtActionPerformed

    }//GEN-LAST:event_yearTxtActionPerformed

    private void yearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTxtKeyTyped
        Validation.textYear(yearTxt);
        if (yearTxt.getText().length() == 3) {
            examCombo.requestFocusInWindow();
            
        }
    }//GEN-LAST:event_yearTxtKeyTyped

    private void examComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_examComboFocusGained
        
        getExamList();
    }//GEN-LAST:event_examComboFocusGained

    private void examComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examComboActionPerformed
        
        studentCombo.requestFocusInWindow();
        getStudentList();
    }//GEN-LAST:event_examComboActionPerformed

    private void studentComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentComboFocusGained

    }//GEN-LAST:event_studentComboFocusGained

    private void studentComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentComboActionPerformed
        certIdTxt.requestFocusInWindow();
    }//GEN-LAST:event_studentComboActionPerformed

    private void studentComboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentComboKeyPressed

    }//GEN-LAST:event_studentComboKeyPressed

    private void certIdTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_certIdTxtFocusGained
        if (examCombo.getSelectedItem() != "none" && studentCombo.getSelectedItem() != "none") {
            getcertificateDetail();
            studentCombo.setSelectedItem("none");
        }
    }//GEN-LAST:event_certIdTxtFocusGained

    private void exNameTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_exNameTxtFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_exNameTxtFocusGained

    private void exNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exNameTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel certIdLbl;
    private javax.swing.JTextField certIdTxt;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JLabel exNameLb;
    private javax.swing.JTextField exNameTxt;
    private javax.swing.JComboBox examCombo;
    private javax.swing.JLabel examIdLbl1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JLabel nameLbl1;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel resultIdLbl;
    private javax.swing.JTextField resultIdTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel stIdLbl1;
    private javax.swing.JComboBox statusCombo;
    private javax.swing.JLabel statusId;
    private javax.swing.JComboBox studentCombo;
    private javax.swing.JTextField yearTxt;
    // End of variables declaration//GEN-END:variables
}
