/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.ijse.sms.controller.CourseController;
import com.ijse.sms.controller.IdGenerator;
import com.ijse.sms.controller.SelectClassController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.SelectClass;

/**
 *
 * @author Randula
 */
public class ManageClass extends javax.swing.JPanel {

    /**
     * Creates new form ManageClass
     */
    public ManageClass() {
        initComponents();
        getCourseList();
        arrangeId();
    }

    private void getCourseList(){
        try {
            String array[]=CourseController.viewCourses();
             courseCombo.addItem("none");
            for(String id:array){
                courseCombo.addItem(id);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private void arrangeId() {
        try {
            String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
            String prefix="CL";
            String id=IdGenerator.getNewId("SelectClass", "ClassId",prefix );
            classIdTxt.setText(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     private void generateClassName(){
         String day=classDayTxt.getText();
         String startTime=startTimeTxt.getText();
         String className=(day+" "+startTime+" ");
         classNameTxt.setText(className);
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        guardTelTxt = new javax.swing.JTextField();
        dobLbl = new javax.swing.JLabel();
        idLbl1 = new javax.swing.JLabel();
        telLbl = new javax.swing.JLabel();
        addressLbl = new javax.swing.JLabel();
        relationshipLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        occupationLbl = new javax.swing.JLabel();
        genderLbl = new javax.swing.JLabel();
        guardTelLbl = new javax.swing.JLabel();
        guardLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        occupationTxt = new javax.swing.JTextField();
        relationshipTxt = new javax.swing.JTextField();
        genderTxt = new javax.swing.JTextField();
        guardTxt = new javax.swing.JTextField();
        dobTxt = new javax.swing.JTextField();
        telTxt = new javax.swing.JTextField();
        addressTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        stIdTxt9 = new javax.swing.JTextField();
        clearBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        modifyBtn = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        capacityLbl = new javax.swing.JLabel();
        classdLbl = new javax.swing.JLabel();
        dayLbl = new javax.swing.JLabel();
        classNameLbl = new javax.swing.JLabel();
        courseIdLbl = new javax.swing.JLabel();
        startDateLbl = new javax.swing.JLabel();
        startTimeLbl = new javax.swing.JLabel();
        endTimeLbla = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        startDayTxt = new javax.swing.JTextField();
        startTimeTxt = new javax.swing.JTextField();
        endTimeTxt = new javax.swing.JTextField();
        capacityTxt = new javax.swing.JTextField();
        classDayTxt = new javax.swing.JTextField();
        classNameTxt = new javax.swing.JTextField();
        classIdTxt = new javax.swing.JTextField();
        courseCombo = new javax.swing.JComboBox();
        clearBtn1 = new javax.swing.JButton();
        saveBtn = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        modifyBtn1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 630));
        jPanel1.setLayout(null);

        guardTelTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel1.add(guardTelTxt);
        guardTelTxt.setBounds(270, 460, 470, 35);

        dobLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dobLbl.setText("DOB  ");
        jPanel1.add(dobLbl);
        dobLbl.setBounds(210, 230, 40, 20);

        idLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        idLbl1.setText("Student ID");
        jPanel1.add(idLbl1);
        idLbl1.setBounds(320, 60, 70, 20);

        telLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        telLbl.setText("Telephone ");
        jPanel1.add(telLbl);
        telLbl.setBounds(210, 190, 70, 20);

        addressLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        addressLbl.setText("Address");
        jPanel1.add(addressLbl);
        addressLbl.setBounds(210, 140, 60, 35);

        relationshipLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        relationshipLbl.setText("Relationship");
        jPanel1.add(relationshipLbl);
        relationshipLbl.setBounds(200, 420, 80, 35);

        nameLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl.setText("Name  ");
        jPanel1.add(nameLbl);
        nameLbl.setBounds(210, 100, 50, 20);

        occupationLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        occupationLbl.setText("Occupation");
        jPanel1.add(occupationLbl);
        occupationLbl.setBounds(200, 380, 70, 35);

        genderLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        genderLbl.setText("Gender");
        jPanel1.add(genderLbl);
        genderLbl.setBounds(210, 270, 50, 20);

        guardTelLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        guardTelLbl.setText(" Telephone ");
        jPanel1.add(guardTelLbl);
        guardTelLbl.setBounds(200, 470, 70, 20);

        guardLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        guardLbl.setText("Guardian");
        jPanel1.add(guardLbl);
        guardLbl.setBounds(200, 350, 60, 20);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Manage Student Details");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 40);

        occupationTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel1.add(occupationTxt);
        occupationTxt.setBounds(270, 380, 470, 35);

        relationshipTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel1.add(relationshipTxt);
        relationshipTxt.setBounds(270, 420, 470, 35);

        genderTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel1.add(genderTxt);
        genderTxt.setBounds(270, 260, 470, 35);

        guardTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel1.add(guardTxt);
        guardTxt.setBounds(270, 340, 470, 35);

        dobTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel1.add(dobTxt);
        dobTxt.setBounds(270, 220, 470, 35);

        telTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel1.add(telTxt);
        telTxt.setBounds(270, 180, 470, 35);

        addressTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel1.add(addressTxt);
        addressTxt.setBounds(270, 140, 470, 35);

        nameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel1.add(nameTxt);
        nameTxt.setBounds(270, 100, 470, 35);

        stIdTxt9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel1.add(stIdTxt9);
        stIdTxt9.setBounds(420, 50, 201, 35);

        clearBtn.setBackground(new java.awt.Color(255, 233, 248));
        clearBtn.setText("Clear");
        jPanel1.add(clearBtn);
        clearBtn.setBounds(760, 460, 110, 30);

        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Edit.png"))); // NOI18N
        jPanel1.add(editBtn);
        editBtn.setBounds(380, 510, 80, 70);

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Delete.png"))); // NOI18N
        jPanel1.add(deleteBtn);
        deleteBtn.setBounds(550, 520, 70, 60);

        jLabel5.setText("Save Changes");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(380, 580, 70, 20);

        jLabel3.setText("Remove");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(560, 580, 50, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background2.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 90, 835, 520);

        jLabel10.setText("Modifications");

        modifyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/modify.png"))); // NOI18N
        modifyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modifyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyBtnMouseClicked(evt);
            }
        });

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(900, 630));
        jPanel2.setLayout(null);

        capacityLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        capacityLbl.setText("Capacity");
        jPanel2.add(capacityLbl);
        capacityLbl.setBounds(120, 390, 60, 20);

        classdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        classdLbl.setText("Class ID");
        jPanel2.add(classdLbl);
        classdLbl.setBounds(120, 80, 70, 30);

        dayLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dayLbl.setText("Class Day");
        jPanel2.add(dayLbl);
        dayLbl.setBounds(120, 190, 70, 20);

        classNameLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        classNameLbl.setText("Class Name");
        jPanel2.add(classNameLbl);
        classNameLbl.setBounds(120, 330, 70, 35);

        courseIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        courseIdLbl.setText("Course ID");
        jPanel2.add(courseIdLbl);
        courseIdLbl.setBounds(120, 130, 60, 30);

        startDateLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        startDateLbl.setText("Started Date");
        jPanel2.add(startDateLbl);
        startDateLbl.setBounds(120, 430, 70, 35);

        startTimeLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        startTimeLbl.setText("Start Time");
        jPanel2.add(startTimeLbl);
        startTimeLbl.setBounds(120, 240, 70, 20);

        endTimeLbla.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        endTimeLbla.setText("End Time");
        jPanel2.add(endTimeLbla);
        endTimeLbla.setBounds(120, 290, 60, 20);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Manage Classes");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(0, 0, 900, 40);

        startDayTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        startDayTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                startDayTxtKeyReleased(evt);
            }
        });
        jPanel2.add(startDayTxt);
        startDayTxt.setBounds(200, 430, 530, 35);

        startTimeTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        startTimeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startTimeTxtActionPerformed(evt);
            }
        });
        startTimeTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                startTimeTxtKeyTyped(evt);
            }
        });
        jPanel2.add(startTimeTxt);
        startTimeTxt.setBounds(200, 230, 530, 35);

        endTimeTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        endTimeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endTimeTxtActionPerformed(evt);
            }
        });
        endTimeTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                endTimeTxtKeyTyped(evt);
            }
        });
        jPanel2.add(endTimeTxt);
        endTimeTxt.setBounds(200, 280, 530, 35);

        capacityTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        capacityTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capacityTxtActionPerformed(evt);
            }
        });
        capacityTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                capacityTxtKeyTyped(evt);
            }
        });
        jPanel2.add(capacityTxt);
        capacityTxt.setBounds(200, 380, 530, 35);

        classDayTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        classDayTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classDayTxtActionPerformed(evt);
            }
        });
        jPanel2.add(classDayTxt);
        classDayTxt.setBounds(200, 180, 530, 35);

        classNameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        classNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classNameTxtActionPerformed(evt);
            }
        });
        jPanel2.add(classNameTxt);
        classNameTxt.setBounds(200, 330, 530, 35);

        classIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel2.add(classIdTxt);
        classIdTxt.setBounds(200, 80, 530, 40);

        courseCombo.setEditable(true);
        courseCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        courseCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseComboActionPerformed(evt);
            }
        });
        jPanel2.add(courseCombo);
        courseCombo.setBounds(200, 130, 530, 40);

        clearBtn1.setBackground(new java.awt.Color(255, 233, 248));
        clearBtn1.setText("Clear");
        jPanel2.add(clearBtn1);
        clearBtn1.setBounds(200, 480, 110, 30);

        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/new.png"))); // NOI18N
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveBtnMouseClicked(evt);
            }
        });
        jPanel2.add(saveBtn);
        saveBtn.setBounds(320, 510, 70, 80);

        jLabel9.setText("Save New");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(320, 580, 60, 20);

        jLabel11.setText("Modifications");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(510, 580, 70, 20);

        modifyBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/modify.png"))); // NOI18N
        modifyBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modifyBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyBtn1MouseClicked(evt);
            }
        });
        jPanel2.add(modifyBtn1);
        modifyBtn1.setBounds(510, 510, 70, 80);

        jButton1.setText("Previous Classes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(740, 130, 113, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background2.png"))); // NOI18N
        jPanel2.add(jLabel8);
        jLabel8.setBounds(0, 90, 835, 520);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void modifyBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyBtnMouseClicked
        new ModifyMarks(null, true).setVisible(true);
    }//GEN-LAST:event_modifyBtnMouseClicked

    private void modifyBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyBtn1MouseClicked
        new ModifyClasses(null, true).setVisible(true);
    }//GEN-LAST:event_modifyBtn1MouseClicked

    private void saveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseClicked
        try {
            String classId=classIdTxt.getText();
            String courseName=(String)courseCombo.getSelectedItem();
            String cId=CourseController.matchId(courseName);
            String name=classNameTxt.getText();
            String day=classDayTxt.getText();
            int capacity=Integer.parseInt(capacityTxt.getText());
            Double startTime=Double.parseDouble(startTimeTxt.getText());
            Double endTime=Double.parseDouble(endTimeTxt.getText());
            String startedDate=startDayTxt.getText();
            
            SelectClass selectClass=new SelectClass(classId, cId, name, day, capacity, startTime, endTime, startedDate);
            boolean isAdded=SelectClassController.addClass(selectClass);
            if(isAdded){
                JOptionPane.showMessageDialog(this, "Saved Succssfully");
                 arrangeId();
            }else{ 
                JOptionPane.showMessageDialog(this, "Saving Faild");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_saveBtnMouseClicked

    private void courseComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseComboActionPerformed
        classDayTxt.requestFocusInWindow();
    }//GEN-LAST:event_courseComboActionPerformed

    private void classNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classNameTxtActionPerformed
        capacityTxt.requestFocusInWindow();
    }//GEN-LAST:event_classNameTxtActionPerformed

    private void classDayTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classDayTxtActionPerformed
         startTimeTxt.requestFocusInWindow();
    }//GEN-LAST:event_classDayTxtActionPerformed

    private void capacityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capacityTxtActionPerformed
        startDayTxt.requestFocusInWindow();
    }//GEN-LAST:event_capacityTxtActionPerformed

    private void startTimeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startTimeTxtActionPerformed
        endTimeTxt.requestFocusInWindow();
    }//GEN-LAST:event_startTimeTxtActionPerformed

    private void endTimeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endTimeTxtActionPerformed
       classNameTxt.requestFocusInWindow();
       generateClassName();
    }//GEN-LAST:event_endTimeTxtActionPerformed

    private void startDayTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startDayTxtKeyReleased
         if(startDayTxt.getText().length()==4){
           startDayTxt.setText(startDayTxt.getText()+"-");
           
       }
       if(startDayTxt.getText().length()==7){
               startDayTxt.setText(startDayTxt.getText()+"-");
       }
    }//GEN-LAST:event_startDayTxtKeyReleased

    private void startTimeTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startTimeTxtKeyTyped
       Validation.priceText(startTimeTxt);
    }//GEN-LAST:event_startTimeTxtKeyTyped

    private void endTimeTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_endTimeTxtKeyTyped
       Validation.priceText(endTimeTxt);
    }//GEN-LAST:event_endTimeTxtKeyTyped

    private void capacityTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_capacityTxtKeyTyped
        Validation.numberOnly(capacityTxt);
    }//GEN-LAST:event_capacityTxtKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Classes().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLbl;
    private javax.swing.JTextField addressTxt;
    private javax.swing.JLabel capacityLbl;
    private javax.swing.JTextField capacityTxt;
    private javax.swing.JTextField classDayTxt;
    private javax.swing.JTextField classIdTxt;
    private javax.swing.JLabel classNameLbl;
    private javax.swing.JTextField classNameTxt;
    private javax.swing.JLabel classdLbl;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton clearBtn1;
    private javax.swing.JComboBox courseCombo;
    private javax.swing.JLabel courseIdLbl;
    private javax.swing.JLabel dayLbl;
    private javax.swing.JLabel deleteBtn;
    private javax.swing.JLabel dobLbl;
    private javax.swing.JTextField dobTxt;
    private javax.swing.JLabel editBtn;
    private javax.swing.JLabel endTimeLbla;
    private javax.swing.JTextField endTimeTxt;
    private javax.swing.JLabel genderLbl;
    private javax.swing.JTextField genderTxt;
    private javax.swing.JLabel guardLbl;
    private javax.swing.JLabel guardTelLbl;
    private javax.swing.JTextField guardTelTxt;
    private javax.swing.JTextField guardTxt;
    private javax.swing.JLabel idLbl1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel modifyBtn;
    private javax.swing.JLabel modifyBtn1;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel occupationLbl;
    private javax.swing.JTextField occupationTxt;
    private javax.swing.JLabel relationshipLbl;
    private javax.swing.JTextField relationshipTxt;
    private javax.swing.JLabel saveBtn;
    private javax.swing.JTextField stIdTxt9;
    private javax.swing.JLabel startDateLbl;
    private javax.swing.JTextField startDayTxt;
    private javax.swing.JLabel startTimeLbl;
    private javax.swing.JTextField startTimeTxt;
    private javax.swing.JLabel telLbl;
    private javax.swing.JTextField telTxt;
    // End of variables declaration//GEN-END:variables
}
