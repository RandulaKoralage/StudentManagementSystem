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
import com.ijse.sms.controller.IdGenerator;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.Examination;

/**
 *
 * @author Randula
 */
public class ManageExams extends javax.swing.JPanel {

    /**
     * Creates new form ManageExams
     */
    public ManageExams() {
        initComponents();
        getCourseList();
        arrangeId();
    }

     public void getCourseList() {
        try {
            String array[] = CourseController.viewCourses();
            for (String d : array) {
                courseCombo.addItem(d);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private void arrangeId(){
        try {
            String id=IdGenerator.getNewId("Examination", "ExamID", "E0");
            eIdTxt.setText(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageExams.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageExams.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        dateLbl = new javax.swing.JLabel();
        examIdLbl = new javax.swing.JLabel();
        feeLbl = new javax.swing.JLabel();
        examNameLbl = new javax.swing.JLabel();
        courseIdLbl = new javax.swing.JLabel();
        timeLbl = new javax.swing.JLabel();
        placeLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        timeTxt = new javax.swing.JTextField();
        placeTxt = new javax.swing.JTextField();
        dateTxt = new javax.swing.JTextField();
        feeTxt = new javax.swing.JTextField();
        eIdTxt = new javax.swing.JTextField();
        courseCombo = new javax.swing.JComboBox();
        clearBtn1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JLabel();
        modifyBtn = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        typeCombo = new javax.swing.JComboBox();
        placeLbl1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(900, 630));
        jPanel2.setLayout(null);

        dateLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dateLbl.setText(" Date");
        jPanel2.add(dateLbl);
        dateLbl.setBounds(140, 290, 60, 20);

        examIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        examIdLbl.setText("Exam ID");
        jPanel2.add(examIdLbl);
        examIdLbl.setBounds(140, 90, 70, 20);

        feeLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        feeLbl.setText(" Fee");
        jPanel2.add(feeLbl);
        feeLbl.setBounds(140, 240, 70, 20);

        examNameLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        examNameLbl.setText("Name");
        jPanel2.add(examNameLbl);
        examNameLbl.setBounds(140, 180, 70, 35);

        courseIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        courseIdLbl.setText("Course ID");
        jPanel2.add(courseIdLbl);
        courseIdLbl.setBounds(140, 140, 60, 20);

        timeLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        timeLbl.setText("Time");
        jPanel2.add(timeLbl);
        timeLbl.setBounds(140, 340, 70, 20);

        placeLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        placeLbl.setText("Type");
        jPanel2.add(placeLbl);
        placeLbl.setBounds(140, 430, 60, 40);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Manage Examinations");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(0, 0, 900, 40);

        timeTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        timeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeTxtActionPerformed(evt);
            }
        });
        timeTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                timeTxtKeyTyped(evt);
            }
        });
        jPanel2.add(timeTxt);
        timeTxt.setBounds(220, 330, 500, 35);

        placeTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel2.add(placeTxt);
        placeTxt.setBounds(220, 380, 500, 35);

        dateTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        dateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTxtActionPerformed(evt);
            }
        });
        dateTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dateTxtKeyReleased(evt);
            }
        });
        jPanel2.add(dateTxt);
        dateTxt.setBounds(220, 280, 500, 35);

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
        jPanel2.add(feeTxt);
        feeTxt.setBounds(220, 230, 500, 35);

        eIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel2.add(eIdTxt);
        eIdTxt.setBounds(220, 80, 500, 35);

        courseCombo.setEditable(true);
        courseCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        courseCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel2.add(courseCombo);
        courseCombo.setBounds(220, 130, 500, 40);

        clearBtn1.setBackground(new java.awt.Color(255, 233, 248));
        clearBtn1.setText("Clear");
        clearBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtn1ActionPerformed(evt);
            }
        });
        jPanel2.add(clearBtn1);
        clearBtn1.setBounds(220, 500, 110, 30);

        jLabel9.setText("Save New");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(320, 580, 60, 20);

        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/new.png"))); // NOI18N
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveBtnMouseClicked(evt);
            }
        });
        jPanel2.add(saveBtn);
        saveBtn.setBounds(310, 510, 70, 80);

        modifyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/modify.png"))); // NOI18N
        modifyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modifyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyBtnMouseClicked(evt);
            }
        });
        jPanel2.add(modifyBtn);
        modifyBtn.setBounds(540, 510, 70, 80);

        jLabel10.setText("Modifications");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(540, 580, 70, 20);

        nameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        nameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTxtActionPerformed(evt);
            }
        });
        jPanel2.add(nameTxt);
        nameTxt.setBounds(220, 180, 500, 35);

        typeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Final", "Repeate" }));
        jPanel2.add(typeCombo);
        typeCombo.setBounds(220, 430, 500, 40);

        placeLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        placeLbl1.setText("Place");
        jPanel2.add(placeLbl1);
        placeLbl1.setBounds(140, 390, 60, 20);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background2.png"))); // NOI18N
        jPanel2.add(jLabel8);
        jLabel8.setBounds(0, 90, 835, 520);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtn1ActionPerformed
        nameTxt.setText(null);
        feeTxt.setText(null);
        dateTxt.setText(null);
        timeTxt.setText(null);
        placeTxt.setText(null);
        feeTxt.setText(null);
    }//GEN-LAST:event_clearBtn1ActionPerformed

    private void modifyBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyBtnMouseClicked
        new ModifyExams(null, true).setVisible(true);
    }//GEN-LAST:event_modifyBtnMouseClicked

    private void dateTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateTxtKeyReleased
         if(dateTxt.getText().length()==4){
           dateTxt.setText(dateTxt.getText()+"-");
           
       }
       if(dateTxt.getText().length()==7){
               dateTxt.setText(dateTxt.getText()+"-");
       }
    }//GEN-LAST:event_dateTxtKeyReleased

    private void saveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseClicked
       if(courseCombo.getSelectedItem().equals("none")){
           JOptionPane.showMessageDialog(this, "Please Select A Course Before Save");
       }else{
        try {
            String id=eIdTxt.getText();
            String courseName=(String)courseCombo.getSelectedItem();
            String cId=CourseController.matchId(courseName);
            double fee=Double.parseDouble(feeTxt.getText());
            String name=nameTxt.getText();
            double time=Double.parseDouble(timeTxt.getText());
            String date=dateTxt.getText();
            String place=placeTxt.getText();
            String type=(String)typeCombo.getSelectedItem();
            Examination examination=new Examination(id, cId, name, fee, time, date, place,type);
            boolean isAdded=ExaminationController.addExamination(examination);
            if(isAdded){
                JOptionPane.showMessageDialog(this, "Successfully Saved");
                arrangeId();
            }else{
                  JOptionPane.showMessageDialog(this, "Saving Failed");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageExams.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageExams.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
    }//GEN-LAST:event_saveBtnMouseClicked

    private void nameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTxtActionPerformed
        feeTxt.requestFocusInWindow();
    }//GEN-LAST:event_nameTxtActionPerformed

    private void feeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feeTxtActionPerformed
        dateTxt.requestFocusInWindow();
    }//GEN-LAST:event_feeTxtActionPerformed

    private void dateTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTxtActionPerformed
       timeTxt.requestFocusInWindow();
    }//GEN-LAST:event_dateTxtActionPerformed

    private void timeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeTxtActionPerformed
        placeTxt.requestFocusInWindow();
    }//GEN-LAST:event_timeTxtActionPerformed

    private void feeTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_feeTxtKeyTyped
        Validation.priceText(feeTxt);
    }//GEN-LAST:event_feeTxtKeyTyped

    private void timeTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timeTxtKeyTyped
        Validation.priceText(timeTxt);
    }//GEN-LAST:event_timeTxtKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn1;
    private javax.swing.JComboBox courseCombo;
    private javax.swing.JLabel courseIdLbl;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JTextField eIdTxt;
    private javax.swing.JLabel examIdLbl;
    private javax.swing.JLabel examNameLbl;
    private javax.swing.JLabel feeLbl;
    private javax.swing.JTextField feeTxt;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel modifyBtn;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel placeLbl;
    private javax.swing.JLabel placeLbl1;
    private javax.swing.JTextField placeTxt;
    private javax.swing.JLabel saveBtn;
    private javax.swing.JLabel timeLbl;
    private javax.swing.JTextField timeTxt;
    private javax.swing.JComboBox typeCombo;
    // End of variables declaration//GEN-END:variables
}
