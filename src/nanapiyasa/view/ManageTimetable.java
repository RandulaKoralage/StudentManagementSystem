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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.ijse.sms.controller.IdGenerator;
import com.ijse.sms.controller.LecturerController;
import com.ijse.sms.controller.SelectClassController;
import com.ijse.sms.controller.TimetableController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.Lecturer;
import com.ijse.sms.model.SelectClass;
import com.ijse.sms.model.Timetable;

/**
 *
 * @author Randula
 */
public class ManageTimetable extends javax.swing.JPanel {

    /**
     * Creates new form ManageTimetable
     */
    public ManageTimetable() {
        initComponents();
        arrangeLecturerCombo();
        arrangeId();
    }

    public void arrangeClassCombo() {
        String year = yearTxt.getText();
        classIdCombo.removeAllItems();
        classIdCombo.addItem("none");
        try {
            ArrayList<SelectClass> classtList = SelectClassController.searchClassByYear(year);
            for (SelectClass selectClass : classtList) {
                classIdCombo.addItem(selectClass.getClassID());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageTimetable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageTimetable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void arrangeLecturerCombo() {

        try {
            ArrayList<Lecturer> lecturerList = LecturerController.viewAllLecturer();
            for (Lecturer lecturer : lecturerList) {
                lectIdCombo.addItem(lecturer.getLectID());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageTimetable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageTimetable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void matchNames() {
    
            try {
                String classId = (String) classIdCombo.getSelectedItem();
                SelectClass selectClass = SelectClassController.searchClass(classId);
                nameTxt.setText(selectClass.getClassName());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageTimetable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ManageTimetable.class.getName()).log(Level.SEVERE, null, ex);
            }
       
}
     public void arrangeId(){
        try {
           String id=IdGenerator.getNewId("Timetable", "ScheduleID", "SD0");
            scheduleIdTxt.setText(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void arrangeTable(){
      
        try {
             String year = yearTxt.getText();
            String lectId=(String) lectIdCombo.getSelectedItem();
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            ArrayList<SelectClass>list=SelectClassController.teachersInchargeOfClass(lectId,year);
            for(SelectClass selectClass: list){
                Object[] rows={selectClass.getClassDay(),selectClass.getClassName(),selectClass.getStartTime(),selectClass.getEndTime()};
                dtm.addRow(rows);
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageTimetable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageTimetable.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        scheduleIdLbl = new javax.swing.JLabel();
        classIdLbl = new javax.swing.JLabel();
        lectNameLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        lectIdLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        scheduleIdTxt = new javax.swing.JTextField();
        lectNameTxt = new javax.swing.JTextField();
        yearTxt = new javax.swing.JTextField();
        lectIdCombo = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JLabel();
        modifyBtn = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nameLbl1 = new javax.swing.JLabel();
        classIdCombo = new javax.swing.JComboBox();
        nameTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(900, 630));
        jPanel2.setLayout(null);

        scheduleIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        scheduleIdLbl.setText("Schedule ID");
        jPanel2.add(scheduleIdLbl);
        scheduleIdLbl.setBounds(20, 60, 80, 40);

        classIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        classIdLbl.setText("Class ID");
        jPanel2.add(classIdLbl);
        classIdLbl.setBounds(20, 160, 70, 40);

        lectNameLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lectNameLbl.setText("Lect Name");
        jPanel2.add(lectNameLbl);
        lectNameLbl.setBounds(20, 310, 70, 40);

        nameLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl.setText("Name");
        jPanel2.add(nameLbl);
        nameLbl.setBounds(20, 210, 70, 35);

        lectIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lectIdLbl.setText("Lecturer ID");
        jPanel2.add(lectIdLbl);
        lectIdLbl.setBounds(20, 260, 80, 40);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Manage Timetable");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(0, 0, 900, 40);

        scheduleIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel2.add(scheduleIdTxt);
        scheduleIdTxt.setBounds(100, 60, 500, 40);

        lectNameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel2.add(lectNameTxt);
        lectNameTxt.setBounds(100, 310, 500, 40);

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
        jPanel2.add(yearTxt);
        yearTxt.setBounds(100, 110, 500, 40);

        lectIdCombo.setEditable(true);
        lectIdCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        lectIdCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        lectIdCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lectIdComboActionPerformed(evt);
            }
        });
        jPanel2.add(lectIdCombo);
        lectIdCombo.setBounds(100, 260, 500, 40);

        jLabel9.setText("Save New");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(630, 330, 60, 20);

        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/new.png"))); // NOI18N
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveBtnMouseClicked(evt);
            }
        });
        jPanel2.add(saveBtn);
        saveBtn.setBounds(620, 260, 70, 80);

        modifyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/modify.png"))); // NOI18N
        modifyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modifyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyBtnMouseClicked(evt);
            }
        });
        jPanel2.add(modifyBtn);
        modifyBtn.setBounds(810, 260, 70, 80);

        jLabel10.setText("Modifications");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(810, 330, 70, 20);

        nameLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl1.setText("Year");
        jPanel2.add(nameLbl1);
        nameLbl1.setBounds(20, 110, 70, 35);

        classIdCombo.setEditable(true);
        classIdCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        classIdCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        classIdCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                classIdComboFocusGained(evt);
            }
        });
        classIdCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classIdComboMouseClicked(evt);
            }
        });
        classIdCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classIdComboActionPerformed(evt);
            }
        });
        jPanel2.add(classIdCombo);
        classIdCombo.setBounds(100, 160, 500, 40);

        nameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        nameTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameTxtFocusGained(evt);
            }
        });
        jPanel2.add(nameTxt);
        nameTxt.setBounds(100, 210, 500, 40);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Day", "Class Name", "Start Time", "End Time"
            }
        ));
        jScrollPane1.setViewportView(table);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(100, 430, 720, 90);

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

    private void modifyBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyBtnMouseClicked
        new ModifyTimetable(null, true).setVisible(true);
    }//GEN-LAST:event_modifyBtnMouseClicked

    private void lectIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lectIdComboActionPerformed
        if (lectIdCombo.getSelectedItem() != "none") {
            try {
                String lectId = (String) lectIdCombo.getSelectedItem();
                Lecturer lecturer = LecturerController.searchLecturer(lectId);
                lectNameTxt.setText(lecturer.getLectName());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageTimetable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ManageTimetable.class.getName()).log(Level.SEVERE, null, ex);
            }
            arrangeTable();
        } else {
           lectNameTxt.setText(null);
       }
    }//GEN-LAST:event_lectIdComboActionPerformed

    private void classIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classIdComboActionPerformed
         nameTxt.requestFocusInWindow();
    }//GEN-LAST:event_classIdComboActionPerformed

    private void yearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTxtActionPerformed
        
    }//GEN-LAST:event_yearTxtActionPerformed

    private void classIdComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classIdComboMouseClicked
       
    }//GEN-LAST:event_classIdComboMouseClicked

    private void saveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseClicked
        try {
            String scheduleId=scheduleIdTxt.getText();
            String lectId=(String)lectIdCombo.getSelectedItem();
            String classId=(String)classIdCombo.getSelectedItem();
            
            Timetable timetable=new Timetable(scheduleId, lectId, classId);
            
            boolean isAdded=TimetableController.addTimetable(timetable);
            if(isAdded){
                JOptionPane.showMessageDialog(this,"Successfully Saved");
                 arrangeId();
            }else{
                JOptionPane.showMessageDialog(this,"Saving Faild");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageTimetable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageTimetable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveBtnMouseClicked

    private void nameTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTxtFocusGained
        if (classIdCombo.getSelectedItem() != "none") {
            try {
                String id = (String) classIdCombo.getSelectedItem();
                SelectClass selectClass = SelectClassController.searchClass(id);
                nameTxt.setText(selectClass.getClassName());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageTimetable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ManageTimetable.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
           nameTxt.setText(null);
       }
    }//GEN-LAST:event_nameTxtFocusGained

    private void yearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTxtKeyTyped
        Validation.textYear(yearTxt);
        if (yearTxt.getText().length() == 3) {
          classIdCombo.requestFocusInWindow();
            
        }
    }//GEN-LAST:event_yearTxtKeyTyped

    private void classIdComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_classIdComboFocusGained
       arrangeClassCombo();
    }//GEN-LAST:event_classIdComboFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox classIdCombo;
    private javax.swing.JLabel classIdLbl;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox lectIdCombo;
    private javax.swing.JLabel lectIdLbl;
    private javax.swing.JLabel lectNameLbl;
    private javax.swing.JTextField lectNameTxt;
    private javax.swing.JLabel modifyBtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel nameLbl1;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel saveBtn;
    private javax.swing.JLabel scheduleIdLbl;
    private javax.swing.JTextField scheduleIdTxt;
    private javax.swing.JTable table;
    private javax.swing.JTextField yearTxt;
    // End of variables declaration//GEN-END:variables
}
