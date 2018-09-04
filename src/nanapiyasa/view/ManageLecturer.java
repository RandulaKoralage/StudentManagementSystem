/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import com.ijse.sms.controller.IdGenerator;
import com.ijse.sms.controller.LecturerController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.Lecturer;

/**
 *
 * @author Randula
 */
public class ManageLecturer extends javax.swing.JPanel {

    /**
     * Creates new form ManageLecturers
     */
    public ManageLecturer() {
        initComponents();
        setLectId();
    }

    private void setLectId() {
        try {
            String lectId = IdGenerator.getNewId("Lecturer", "LectID", "L");
            lectIdTxt.setText(lectId);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageLecturer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    boolean validateTelNum(String TelNum) {
        boolean status = false;
        String telNumCheck = TelNum;
        Pattern pattern = Pattern.compile("[0-9]{10}");
        Matcher matcher = pattern.matcher(telNumCheck);
        if (matcher.matches()) {
            status = true;
        } else {
            status = false;

        }
        return status;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dobLbl = new javax.swing.JLabel();
        lectIdLbl = new javax.swing.JLabel();
        telLbl = new javax.swing.JLabel();
        addressLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dobTxt = new javax.swing.JTextField();
        telTxt = new javax.swing.JTextField();
        addressTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        lectIdTxt = new javax.swing.JTextField();
        clearBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        modifyBtn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 630));
        jPanel1.setLayout(null);

        dobLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dobLbl.setText("DOB");
        jPanel1.add(dobLbl);
        dobLbl.setBounds(120, 290, 60, 20);

        lectIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lectIdLbl.setText("Lecturer ID");
        jPanel1.add(lectIdLbl);
        lectIdLbl.setBounds(120, 100, 70, 20);

        telLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        telLbl.setText("Telephone");
        jPanel1.add(telLbl);
        telLbl.setBounds(120, 240, 70, 20);

        addressLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        addressLbl.setText("Address");
        jPanel1.add(addressLbl);
        addressLbl.setBounds(120, 190, 60, 35);

        nameLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl.setText("Name  ");
        jPanel1.add(nameLbl);
        nameLbl.setBounds(120, 150, 50, 20);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Manage Lecturer Details");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 50);

        dobTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        dobTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobTxtActionPerformed(evt);
            }
        });
        dobTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dobTxtKeyReleased(evt);
            }
        });
        jPanel1.add(dobTxt);
        dobTxt.setBounds(200, 290, 570, 35);

        telTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        telTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telTxtActionPerformed(evt);
            }
        });
        telTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telTxtKeyTyped(evt);
            }
        });
        jPanel1.add(telTxt);
        telTxt.setBounds(200, 240, 570, 35);

        addressTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        addressTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTxtActionPerformed(evt);
            }
        });
        jPanel1.add(addressTxt);
        addressTxt.setBounds(200, 190, 570, 35);

        nameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        nameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTxtActionPerformed(evt);
            }
        });
        jPanel1.add(nameTxt);
        nameTxt.setBounds(200, 140, 570, 35);

        lectIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        lectIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lectIdTxtActionPerformed(evt);
            }
        });
        jPanel1.add(lectIdTxt);
        lectIdTxt.setBounds(200, 90, 570, 35);

        clearBtn.setBackground(new java.awt.Color(255, 233, 248));
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        jPanel1.add(clearBtn);
        clearBtn.setBounds(200, 350, 110, 30);

        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/new.png"))); // NOI18N
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveBtnMouseClicked(evt);
            }
        });
        jPanel1.add(saveBtn);
        saveBtn.setBounds(300, 400, 70, 80);

        jLabel6.setText("Save New");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(310, 470, 60, 20);

        jLabel10.setText("Modifications");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(530, 470, 70, 20);

        modifyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/modify.png"))); // NOI18N
        modifyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modifyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyBtnMouseClicked(evt);
            }
        });
        jPanel1.add(modifyBtn);
        modifyBtn.setBounds(530, 400, 70, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background2.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 90, 835, 520);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void modifyBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyBtnMouseClicked
        new ModifyLecturers(null, true).setVisible(true);
    }//GEN-LAST:event_modifyBtnMouseClicked

    private void lectIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lectIdTxtActionPerformed
        nameTxt.requestFocusInWindow();
    }//GEN-LAST:event_lectIdTxtActionPerformed

    private void nameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTxtActionPerformed
        addressTxt.requestFocusInWindow();
    }//GEN-LAST:event_nameTxtActionPerformed

    private void addressTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTxtActionPerformed
        telTxt.requestFocusInWindow();
    }//GEN-LAST:event_addressTxtActionPerformed

    private void telTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telTxtActionPerformed

        String telNumber = telTxt.getText();
        if (telNumber.length() > 0) {
            if (validateTelNum(telNumber)) {
                dobTxt.requestFocusInWindow();
            } else {
                JOptionPane.showMessageDialog(this, "Check Telephone Number Again");
            }
        } else {
            dobTxt.requestFocusInWindow();
        }

    }//GEN-LAST:event_telTxtActionPerformed

    private void dobTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dobTxtActionPerformed

    private void dobTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dobTxtKeyReleased
        if (dobTxt.getText().length() == 4) {
            dobTxt.setText(dobTxt.getText() + "-");

        }
        if (dobTxt.getText().length() == 7) {
            dobTxt.setText(dobTxt.getText() + "-");
        }
    }//GEN-LAST:event_dobTxtKeyReleased

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        nameTxt.setText(null);
        addressTxt.setText(null);
        telTxt.setText(null);
        dobTxt.setText(null);
    }//GEN-LAST:event_clearBtnActionPerformed

    private void saveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseClicked
        try {
            String lecId = lectIdTxt.getText();
            String name = nameTxt.getText();
            String address = addressTxt.getText();
            String tel = telTxt.getText();
            String dob = dobTxt.getText();
            Lecturer lecturer = new Lecturer(lecId, name, address, tel, dob);

            boolean isAdded = LecturerController.addLecturer(lecturer);
            if (isAdded) {
                JOptionPane.showMessageDialog(this, "Saved Succssfully");
                setLectId();
            } else {
                JOptionPane.showMessageDialog(this, "Saving Faild");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageLecturer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveBtnMouseClicked

    private void telTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telTxtKeyTyped
       Validation.phoneNumber(telTxt, evt);
    }//GEN-LAST:event_telTxtKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLbl;
    private javax.swing.JTextField addressTxt;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel dobLbl;
    private javax.swing.JTextField dobTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lectIdLbl;
    private javax.swing.JTextField lectIdTxt;
    private javax.swing.JLabel modifyBtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel saveBtn;
    private javax.swing.JLabel telLbl;
    private javax.swing.JTextField telTxt;
    // End of variables declaration//GEN-END:variables
}
