/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import com.ijse.sms.controller.CourseController;
import com.ijse.sms.controller.RegistrationController;
import com.ijse.sms.controller.SelectClassController;
import com.ijse.sms.controller.StudentController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.Course;
import com.ijse.sms.model.Registration;
import com.ijse.sms.model.SelectClass;
import com.ijse.sms.model.Student;

/**
 *
 * @author Randula
 */
public class ChangeRegistration extends javax.swing.JPanel {

    /**
     * Creates new form ChangeRegistration
     */
    public ChangeRegistration() {
        initComponents();
        arrangeCombo();

    }

    public void arrangeCombo() {
        try {
            ArrayList<Registration> registrationList = RegistrationController.viewAllRegistrationDetail();
            for (Registration registration : registrationList) {
                regIdCombo.addItem(registration.getRegID());
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getClassList() {
        try {

            String date = dateTxt.getText();
            String year = date.substring(0, 4);

            String cName = (String) courseCombo.getSelectedItem();

            String cId = CourseController.matchId(cName);

            classCombo.removeAllItems();

            String[] array = SelectClassController.classNamesOfAYearToCourse(year, cId);
            for (String name : array) {

                classCombo.addItem(name);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        feeTxt = new javax.swing.JTextField();
        regIdLbl = new javax.swing.JLabel();
        courseLbl = new javax.swing.JLabel();
        stNameLbl = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        feeLbl = new javax.swing.JLabel();
        classLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateTxt = new javax.swing.JTextField();
        stIdTxt = new javax.swing.JTextField();
        clearlBtn = new javax.swing.JButton();
        courseCombo = new javax.swing.JComboBox();
        regIdCombo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        editBtn = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        classCombo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(900, 630));
        panel.setLayout(null);

        feeTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        feeTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                feeTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                feeTxtFocusLost(evt);
            }
        });
        feeTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                feeTxtKeyTyped(evt);
            }
        });
        panel.add(feeTxt);
        feeTxt.setBounds(300, 350, 390, 35);

        regIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        regIdLbl.setText("Registration ID");
        panel.add(regIdLbl);
        regIdLbl.setBounds(200, 50, 90, 40);

        courseLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        courseLbl.setText("Course");
        panel.add(courseLbl);
        courseLbl.setBounds(200, 200, 70, 40);

        stNameLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        stNameLbl.setText("Student ID");
        panel.add(stNameLbl);
        stNameLbl.setBounds(200, 100, 70, 30);

        dateLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dateLbl.setText("Date");
        panel.add(dateLbl);
        dateLbl.setBounds(200, 300, 70, 30);

        feeLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        feeLbl.setText("Registration Fee");
        panel.add(feeLbl);
        feeLbl.setBounds(200, 350, 100, 30);

        classLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        classLbl.setText("Class ");
        panel.add(classLbl);
        classLbl.setBounds(200, 250, 70, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Change Registration Details");
        panel.add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 40);

        dateTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        dateTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dateTxtFocusGained(evt);
            }
        });
        panel.add(dateTxt);
        dateTxt.setBounds(300, 300, 390, 35);

        stIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        panel.add(stIdTxt);
        stIdTxt.setBounds(300, 100, 390, 35);

        clearlBtn.setBackground(new java.awt.Color(255, 233, 248));
        clearlBtn.setText("Clear");
        clearlBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearlBtnActionPerformed(evt);
            }
        });
        panel.add(clearlBtn);
        clearlBtn.setBounds(300, 400, 110, 30);

        courseCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        panel.add(courseCombo);
        courseCombo.setBounds(300, 200, 390, 40);

        regIdCombo.setEditable(true);
        regIdCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        regIdCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regIdComboActionPerformed(evt);
            }
        });
        panel.add(regIdCombo);
        regIdCombo.setBounds(300, 50, 390, 40);

        jLabel5.setText("Save Changes");
        panel.add(jLabel5);
        jLabel5.setBounds(370, 490, 70, 20);

        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Edit.png"))); // NOI18N
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtnMouseClicked(evt);
            }
        });
        panel.add(editBtn);
        editBtn.setBounds(370, 420, 80, 70);

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Delete.png"))); // NOI18N
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });
        panel.add(deleteBtn);
        deleteBtn.setBounds(530, 420, 70, 70);

        jLabel3.setText("Remove");
        panel.add(jLabel3);
        jLabel3.setBounds(540, 490, 50, 20);

        nameLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl.setText("Name");
        panel.add(nameLbl);
        nameLbl.setBounds(200, 150, 80, 30);

        nameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        panel.add(nameTxt);
        nameTxt.setBounds(300, 150, 390, 35);

        classCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                classComboFocusGained(evt);
            }
        });
        panel.add(classCombo);
        classCombo.setBounds(300, 250, 390, 40);

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

    private void regIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regIdComboActionPerformed

        String id = (String) regIdCombo.getSelectedItem();
        if (id != "none") {
            try {
                Registration registration = RegistrationController.searchRegistrationDetail(id);
                String cId = registration.getCourseID();
                Course course = CourseController.searchCourse(cId);

                String sId = registration.getStID();
                Student student = StudentController.searchStudent(sId);

                nameTxt.setText(student.getStName());
                stIdTxt.setText(registration.getStID());
                dateTxt.setText(registration.getRegDate());
                feeTxt.setText(Double.toString(registration.getRegFee()));
                classCombo.setSelectedItem(registration.getClassDetail());
                courseCombo.removeAllItems();
                courseCombo.addItem(course.getCourseName());
                courseCombo.setEnabled(false);

                classCombo.requestFocusInWindow();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            nameTxt.setText(null);
            stIdTxt.setText(null);
            dateTxt.setText(null);
            feeTxt.setText(null);
            classCombo.removeAllItems();
            getClassList();
            courseCombo.removeAllItems();
            regIdCombo.removeAllItems();
            regIdCombo.addItem("none");
        }
    }//GEN-LAST:event_regIdComboActionPerformed

    private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked
        int res = JOptionPane.showOptionDialog(this, "Dou you want to Save Changes?", "Options", 0, 0, null, null, null);
        if (res == 0) {
            try {
                String regId = (String) regIdCombo.getSelectedItem();
                Registration registration = RegistrationController.searchRegistrationDetail(regId);
                String cId = registration.getCourseID();
                String stId = stIdTxt.getText();
                String date = dateTxt.getText();
                Double fee = Double.parseDouble(feeTxt.getText());
                String classDetail = (String) classCombo.getSelectedItem();
                registration = new Registration(regId, stId, cId, fee, date, classDetail);

                boolean isUpdated = RegistrationController.updateRegistrationDetail(registration);
                if (isUpdated) {
                    JOptionPane.showMessageDialog(this, "Saved Changes");
                } else {
                    JOptionPane.showMessageDialog(this, "Saving Faild. Try Again");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GetDetails.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(GetDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_editBtnMouseClicked

    private void clearlBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearlBtnActionPerformed
        nameTxt.setText(null);
        stIdTxt.setText(null);
        dateTxt.setText(null);
        feeTxt.setText(null);
        classCombo.removeAllItems();
        getClassList();
        courseCombo.removeAllItems();
        regIdCombo.setSelectedItem("none");
        arrangeCombo();

    }//GEN-LAST:event_clearlBtnActionPerformed

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
        int res = JOptionPane.showOptionDialog(this, "Dou you want to Delete this Registration?", "Options", 0, 0, null, null, null);
        if (res == 0) {
            try {
                String regId = (String) regIdCombo.getSelectedItem();
                boolean isDeleted = RegistrationController.deleteRegistrationDetail(regId);
                if (isDeleted) {
                    JOptionPane.showMessageDialog(this, "Registration Removed");
                    //regIdCombo.addItem("none");
                    regIdCombo.setSelectedItem("none");
                    arrangeCombo();
                } else {
                    JOptionPane.showMessageDialog(this, "Try Again");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_deleteBtnMouseClicked

    private void feeTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_feeTxtFocusGained
            
    }//GEN-LAST:event_feeTxtFocusGained

    private void dateTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateTxtFocusGained

    }//GEN-LAST:event_dateTxtFocusGained

    private void classComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_classComboFocusGained
        getClassList();
    }//GEN-LAST:event_classComboFocusGained

    private void feeTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_feeTxtFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_feeTxtFocusLost

    private void feeTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_feeTxtKeyTyped
        Validation.priceText(feeTxt);
    }//GEN-LAST:event_feeTxtKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox classCombo;
    private javax.swing.JLabel classLbl;
    private javax.swing.JButton clearlBtn;
    private javax.swing.JComboBox courseCombo;
    private javax.swing.JLabel courseLbl;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JLabel deleteBtn;
    private javax.swing.JLabel editBtn;
    private javax.swing.JLabel feeLbl;
    private javax.swing.JTextField feeTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JPanel panel;
    private javax.swing.JComboBox regIdCombo;
    private javax.swing.JLabel regIdLbl;
    private javax.swing.JTextField stIdTxt;
    private javax.swing.JLabel stNameLbl;
    // End of variables declaration//GEN-END:variables
}
