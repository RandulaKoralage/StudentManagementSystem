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
import com.ijse.sms.controller.IdGenerator;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.Course;
/**
 *
 * @author Randula
 */
public class ManageCourse extends javax.swing.JPanel {

    /**
     * Creates new form ManageCourse
     */
    public ManageCourse() {
        initComponents();
        arrangeId();
    }

    public void arrangeId() {
        try {
            String id=IdGenerator.getNewId("Course", "CourseID", "C");
            cIdTxt.setText(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageCourse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        modifyBtn = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        durationLbl = new javax.swing.JLabel();
        cIdLbl = new javax.swing.JLabel();
        descriptionLbl = new javax.swing.JLabel();
        feeLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        durationTxt = new javax.swing.JTextField();
        descriptionTxt = new javax.swing.JTextField();
        feeTxt = new javax.swing.JTextField();
        cNameTxt = new javax.swing.JTextField();
        cIdTxt = new javax.swing.JTextField();
        clearBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        modifyBtn1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel10.setText("Modifications");

        modifyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/modify.png"))); // NOI18N
        modifyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modifyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyBtnMouseClicked(evt);
            }
        });

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 630));
        jPanel1.setLayout(null);

        durationLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        durationLbl.setText("Duration");
        jPanel1.add(durationLbl);
        durationLbl.setBounds(120, 270, 80, 30);

        cIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cIdLbl.setText("Course ID");
        jPanel1.add(cIdLbl);
        cIdLbl.setBounds(120, 70, 80, 30);

        descriptionLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        descriptionLbl.setText("Description");
        jPanel1.add(descriptionLbl);
        descriptionLbl.setBounds(120, 220, 80, 30);

        feeLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        feeLbl.setText("Fee");
        jPanel1.add(feeLbl);
        feeLbl.setBounds(120, 170, 80, 35);

        nameLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl.setText("Name  ");
        jPanel1.add(nameLbl);
        nameLbl.setBounds(120, 120, 80, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Manage Course Details");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 50);

        durationTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel1.add(durationTxt);
        durationTxt.setBounds(200, 270, 530, 35);

        descriptionTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        descriptionTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionTxtActionPerformed(evt);
            }
        });
        jPanel1.add(descriptionTxt);
        descriptionTxt.setBounds(200, 220, 530, 35);

        feeTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        feeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feeTxtActionPerformed(evt);
            }
        });
        feeTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                feeTxtKeyTyped(evt);
            }
        });
        jPanel1.add(feeTxt);
        feeTxt.setBounds(200, 170, 530, 35);

        cNameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        cNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cNameTxtActionPerformed(evt);
            }
        });
        jPanel1.add(cNameTxt);
        cNameTxt.setBounds(200, 120, 530, 35);

        cIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        cIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cIdTxtActionPerformed(evt);
            }
        });
        jPanel1.add(cIdTxt);
        cIdTxt.setBounds(200, 70, 530, 35);

        clearBtn.setBackground(new java.awt.Color(255, 233, 248));
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        jPanel1.add(clearBtn);
        clearBtn.setBounds(200, 330, 110, 30);

        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/new.png"))); // NOI18N
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveBtnMouseClicked(evt);
            }
        });
        jPanel1.add(saveBtn);
        saveBtn.setBounds(300, 370, 70, 80);

        jLabel6.setText("Save New");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(310, 440, 60, 20);

        jLabel11.setText("Modifications");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(510, 440, 70, 20);

        modifyBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/modify.png"))); // NOI18N
        modifyBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modifyBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyBtn1MouseClicked(evt);
            }
        });
        jPanel1.add(modifyBtn1);
        modifyBtn1.setBounds(510, 370, 70, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background2.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 90, 835, 520);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 900, 630);
    }// </editor-fold>//GEN-END:initComponents

    private void cIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cIdTxtActionPerformed
        cNameTxt.requestFocusInWindow();
    }//GEN-LAST:event_cIdTxtActionPerformed

    private void cNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cNameTxtActionPerformed
        feeTxt.requestFocusInWindow();
    }//GEN-LAST:event_cNameTxtActionPerformed

    private void feeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feeTxtActionPerformed
        descriptionTxt.requestFocusInWindow();
    }//GEN-LAST:event_feeTxtActionPerformed

    private void descriptionTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionTxtActionPerformed
        durationTxt.requestFocusInWindow();
    }//GEN-LAST:event_descriptionTxtActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed

        cNameTxt.setText(null);
        feeTxt.setText(null);
        durationTxt.setText(null);
        descriptionTxt.setText(null);
    }//GEN-LAST:event_clearBtnActionPerformed

    private void saveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseClicked
        try {
            String cId = cIdTxt.getText();
            String name = cNameTxt.getText();
            double fee = Double.parseDouble(feeTxt.getText());
            String duration = durationTxt.getText();
            String description = descriptionTxt.getText();

            Course course = new Course(cId, name, fee, duration, description);
            boolean isAdded = CourseController.addCourse(course);
            if (isAdded) {
                JOptionPane.showMessageDialog(this, "Successfully Saved");
                 arrangeId();
            } else {
                JOptionPane.showMessageDialog(this, "Saving Faild");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageCourse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageCourse.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_saveBtnMouseClicked

    private void modifyBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyBtnMouseClicked
       // new ModifyMarks(null, true).setVisible(true);
    }//GEN-LAST:event_modifyBtnMouseClicked

    private void modifyBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyBtn1MouseClicked
        new ModifyCourses(null, true).setVisible(true);
    }//GEN-LAST:event_modifyBtn1MouseClicked

    private void feeTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_feeTxtKeyTyped
        Validation.priceText(feeTxt);
    }//GEN-LAST:event_feeTxtKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cIdLbl;
    private javax.swing.JTextField cIdTxt;
    private javax.swing.JTextField cNameTxt;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel descriptionLbl;
    private javax.swing.JTextField descriptionTxt;
    private javax.swing.JLabel durationLbl;
    private javax.swing.JTextField durationTxt;
    private javax.swing.JLabel feeLbl;
    private javax.swing.JTextField feeTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel modifyBtn;
    private javax.swing.JLabel modifyBtn1;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel saveBtn;
    // End of variables declaration//GEN-END:variables
}
