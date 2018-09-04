/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.ijse.sms.controller.CertificateController;
import com.ijse.sms.controller.ExaminationController;
import com.ijse.sms.controller.ResultTableController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.Certificate;

/**
 *
 * @author Randula
 */
public class ManageCertificate extends javax.swing.JPanel {

    /**
     * Creates new form ManageCertificate
     */
    public ManageCertificate() {
        initComponents();
        arrangeId();
       // getResultList();
         //set date
        String date=new SimpleDateFormat("YYYY-MM-dd").format(new Date());
        dateTxt.setText(date);
    }

    public void arrangeId() {

        try {

            String year = new SimpleDateFormat("yyyy").format(new Date());

            String id = null;
            ArrayList<Certificate> certList = CertificateController.viewAllCertificate();
            for (Certificate certificate : certList) {
                id = certificate.getCertificateID();
            }
            String last4 = id.substring(8);
            int idTemp = Integer.parseInt(last4) + 1;

            certIdTxt.setText("GB/" + year + "/00" + idTemp);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageCertificate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageCertificate.class.getName()).log(Level.SEVERE, null, ex);
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
    private void getResultId(){
        try {
            String eId =(String)examCombo.getSelectedItem();
            
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

        panel = new javax.swing.JPanel();
        certIdLbl = new javax.swing.JLabel();
        statusId = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        resultIdLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateTxt = new javax.swing.JTextField();
        certIdTxt = new javax.swing.JTextField();
        clearBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        resultCombo = new javax.swing.JComboBox();
        modifyBtn1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        statusCombo = new javax.swing.JComboBox();
        yearTxt = new javax.swing.JTextField();
        nameLbl1 = new javax.swing.JLabel();
        examIdLbl1 = new javax.swing.JLabel();
        examCombo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(900, 630));
        panel.setLayout(null);

        certIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        certIdLbl.setText("Certificate ID");
        panel.add(certIdLbl);
        certIdLbl.setBounds(120, 50, 80, 40);

        statusId.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        statusId.setText("Status");
        panel.add(statusId);
        statusId.setBounds(120, 290, 80, 40);

        dateLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dateLbl.setText("Date");
        panel.add(dateLbl);
        dateLbl.setBounds(120, 250, 80, 30);

        resultIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        resultIdLbl.setText("Result ID");
        panel.add(resultIdLbl);
        resultIdLbl.setBounds(120, 200, 80, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Manage Certificates");
        panel.add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 40);

        dateTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        dateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTxtActionPerformed(evt);
            }
        });
        panel.add(dateTxt);
        dateTxt.setBounds(200, 250, 540, 35);

        certIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        certIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                certIdTxtActionPerformed(evt);
            }
        });
        panel.add(certIdTxt);
        certIdTxt.setBounds(200, 50, 540, 40);

        clearBtn.setBackground(new java.awt.Color(255, 233, 248));
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        panel.add(clearBtn);
        clearBtn.setBounds(200, 360, 110, 30);

        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/new.png"))); // NOI18N
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveBtnMouseClicked(evt);
            }
        });
        panel.add(saveBtn);
        saveBtn.setBounds(310, 400, 70, 80);

        jLabel6.setText("Save New");
        panel.add(jLabel6);
        jLabel6.setBounds(320, 470, 60, 20);

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
        panel.add(resultCombo);
        resultCombo.setBounds(200, 200, 540, 40);

        modifyBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/modify.png"))); // NOI18N
        modifyBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modifyBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyBtn1MouseClicked(evt);
            }
        });
        panel.add(modifyBtn1);
        modifyBtn1.setBounds(510, 400, 70, 80);

        jLabel11.setText("Modifications");
        panel.add(jLabel11);
        jLabel11.setBounds(510, 470, 70, 20);

        statusCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Not Released", "Released" }));
        panel.add(statusCombo);
        statusCombo.setBounds(200, 290, 540, 40);

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
        yearTxt.setBounds(200, 100, 540, 40);

        nameLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl1.setText("Exam Year");
        panel.add(nameLbl1);
        nameLbl1.setBounds(120, 100, 70, 40);

        examIdLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        examIdLbl1.setText("Exam ID");
        panel.add(examIdLbl1);
        examIdLbl1.setBounds(120, 150, 51, 30);

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
        examCombo.setBounds(200, 150, 540, 40);

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

    private void saveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseClicked
        String certificateId = certIdTxt.getText();
        String resultId = (String)resultCombo.getSelectedItem();
        String date = dateTxt.getText();
        String status = (String) statusCombo.getSelectedItem();

        Certificate certificate = new Certificate(certificateId, resultId, date, status);
        try {
            boolean isAdded = CertificateController.addCertificate(certificate);
            if (isAdded) {
                JOptionPane.showMessageDialog(this, "Successfully Saved");
            } else {
                JOptionPane.showMessageDialog(this, "Try Again");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageCertificate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageCertificate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveBtnMouseClicked

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        
        resultCombo.removeAllItems();
        getResultId();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void certIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_certIdTxtActionPerformed
        resultCombo.requestFocusInWindow();
    }//GEN-LAST:event_certIdTxtActionPerformed

    private void dateTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTxtActionPerformed
        statusCombo.requestFocusInWindow();
    }//GEN-LAST:event_dateTxtActionPerformed

    private void modifyBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyBtn1MouseClicked
        new ModifyCertificates(null, true).setVisible(true);
    }//GEN-LAST:event_modifyBtn1MouseClicked

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
    resultCombo.requestFocusInWindow();
      
    }//GEN-LAST:event_examComboActionPerformed

    private void resultComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultComboMouseClicked
       
    }//GEN-LAST:event_resultComboMouseClicked

    private void resultComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_resultComboFocusGained
      getResultId();
    }//GEN-LAST:event_resultComboFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel certIdLbl;
    private javax.swing.JTextField certIdTxt;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JComboBox examCombo;
    private javax.swing.JLabel examIdLbl1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel modifyBtn1;
    private javax.swing.JLabel nameLbl1;
    private javax.swing.JPanel panel;
    private javax.swing.JComboBox resultCombo;
    private javax.swing.JLabel resultIdLbl;
    private javax.swing.JLabel saveBtn;
    private javax.swing.JComboBox statusCombo;
    private javax.swing.JLabel statusId;
    private javax.swing.JTextField yearTxt;
    // End of variables declaration//GEN-END:variables
}
