/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.ijse.sms.controller.AttendanceController;
import com.ijse.sms.controller.SelectClassController;
import com.ijse.sms.controller.StudentController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.Attendance;
import com.ijse.sms.model.Student;

/**
 *
 * @author Randula
 */
public class AdvancedSearchAttendance extends javax.swing.JPanel {

    /**
     * Creates new form StudentAttendance
     */
    public AdvancedSearchAttendance() {
        initComponents();
        arrangeCombo();

    }

    public void arrangeCombo() {
        try {
            ArrayList<Student> studentList = StudentController.viewAllStudent();
            for (Student student : studentList) {
                stIdCombo.addItem(student.getStID());
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void matchClassId() {
        try {
            String year = yearTxt.getText();

            classIdCombo.removeAllItems();
            classIdCombo.addItem("none");
            classIdCombo.addItem("All");
            String[] array = SelectClassController.classNamesOfAYear(year);
            for (String name : array) {
                classIdCombo.addItem(name);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void toGivenClass() {
        try {
            String stId = (String) stIdCombo.getSelectedItem();
            String firstDate = firstDateTxt.getText();
            String secondDate = secondDateTxt.getText();
            String className = (String) classIdCombo.getSelectedItem();
            String year = yearTxt.getText();
            String classId = SelectClassController.matchId(className, year);

            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            ArrayList<Attendance> list = AttendanceController.viewStudentAttendanceGivenClass(firstDate, secondDate, stId, classId);
            for (Attendance attendance : list) {
                String name = StudentController.getStNameFromId(attendance.getStID());
                Object[] row = {attendance.getAttendID(), name, attendance.getScheduleID(), attendance.getCurrentDate(), attendance.getStatus()};
                dtm.addRow(row);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdvancedSearchAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdvancedSearchAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void toAllClassesOfAStudent() {
        try {
            String stId = (String) stIdCombo.getSelectedItem();
            String firstDate = firstDateTxt.getText();
            String secondDate = secondDateTxt.getText();
            String className = (String) classIdCombo.getSelectedItem();
            String year = yearTxt.getText();
            String classId = SelectClassController.matchId(className, year);

            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            ArrayList<Attendance> list = AttendanceController.viewStudentAttendanceAllClass(firstDate, secondDate, stId);

            for (Attendance attendance : list) {
                String name = StudentController.getStNameFromId(attendance.getStID());
                Object[] row = {attendance.getAttendID(), name, attendance.getScheduleID(), attendance.getCurrentDate(), attendance.getStatus()};
                dtm.addRow(row);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdvancedSearchAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdvancedSearchAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void toAllStudentInGivenClass() {
        try {

            String firstDate = firstDateTxt.getText();
            String secondDate = secondDateTxt.getText();
            String className = (String) classIdCombo.getSelectedItem();
            String year = yearTxt.getText();
            String classId = SelectClassController.matchId(className, year);
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            ArrayList<Attendance> list = AttendanceController.viewAllStudentAttendanceGivenClass(firstDate, secondDate, classId);
            for (Attendance attendance : list) {
                String name = StudentController.getStNameFromId(attendance.getStID());
                Object[] row = {attendance.getAttendID(), name, attendance.getScheduleID(), attendance.getCurrentDate(), attendance.getStatus()};
                dtm.addRow(row);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdvancedSearchAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdvancedSearchAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    boolean validateYear(String year) {
        boolean status = false;
        String valueToTest = year;
        Pattern pattern = Pattern.compile("[0-9]{4}");
        Matcher matcher = pattern.matcher(valueToTest);
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

        panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        durationLbl2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        studentAttentance = new javax.swing.JPanel();
        stIdCombo = new javax.swing.JComboBox();
        idLbl1 = new javax.swing.JLabel();
        classdLbl1 = new javax.swing.JLabel();
        nameLbl1 = new javax.swing.JLabel();
        yearTxt = new javax.swing.JTextField();
        classIdCombo = new javax.swing.JComboBox();
        firstDateTxt = new javax.swing.JTextField();
        secondDateTxt = new javax.swing.JTextField();
        toLbl = new javax.swing.JLabel();
        classBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(900, 630));
        panel.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Advanced Search Attendance");
        panel.add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 40);

        durationLbl2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        durationLbl2.setText("Reason");
        panel.add(durationLbl2);
        durationLbl2.setBounds(-420, 410, 60, 30);

        table.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Att ID", "Student ID", "Schedule ID", "Date", "Staus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setFillsViewportHeight(true);
        table.setGridColor(new java.awt.Color(204, 0, 0));
        table.setRowHeight(20);
        table.setSelectionBackground(new java.awt.Color(255, 204, 153));
        table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(75);
            table.getColumnModel().getColumn(0).setPreferredWidth(75);
            table.getColumnModel().getColumn(0).setMaxWidth(75);
            table.getColumnModel().getColumn(1).setMinWidth(200);
            table.getColumnModel().getColumn(1).setPreferredWidth(200);
            table.getColumnModel().getColumn(1).setMaxWidth(200);
            table.getColumnModel().getColumn(2).setMinWidth(100);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setMaxWidth(100);
            table.getColumnModel().getColumn(4).setMinWidth(50);
            table.getColumnModel().getColumn(4).setPreferredWidth(50);
            table.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        panel.add(jScrollPane1);
        jScrollPane1.setBounds(60, 230, 790, 350);

        studentAttentance.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Student's Attendance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        studentAttentance.setOpaque(false);
        studentAttentance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentAttentanceMouseClicked(evt);
            }
        });
        studentAttentance.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stIdCombo.setEditable(true);
        stIdCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        stIdCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        stIdCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stIdComboActionPerformed(evt);
            }
        });
        studentAttentance.add(stIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 250, 30));

        idLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        idLbl1.setText("Student ID");
        studentAttentance.add(idLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        classdLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        classdLbl1.setText("Class");
        studentAttentance.add(classdLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 70, 30));

        nameLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl1.setText("Academic Year");
        studentAttentance.add(nameLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 30));

        yearTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        yearTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                yearTxtFocusLost(evt);
            }
        });
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
        studentAttentance.add(yearTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 250, 30));

        classIdCombo.setEditable(true);
        classIdCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        classIdCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        classIdCombo.setPreferredSize(new java.awt.Dimension(2, 16));
        classIdCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                classIdComboFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                classIdComboFocusLost(evt);
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
        classIdCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                classIdComboKeyPressed(evt);
            }
        });
        studentAttentance.add(classIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 250, 30));

        panel.add(studentAttentance);
        studentAttentance.setBounds(60, 60, 370, 160);

        firstDateTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        firstDateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstDateTxtActionPerformed(evt);
            }
        });
        firstDateTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                firstDateTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                firstDateTxtKeyTyped(evt);
            }
        });
        panel.add(firstDateTxt);
        firstDateTxt.setBounds(440, 80, 140, 35);

        secondDateTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        secondDateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondDateTxtActionPerformed(evt);
            }
        });
        secondDateTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                secondDateTxtKeyReleased(evt);
            }
        });
        panel.add(secondDateTxt);
        secondDateTxt.setBounds(700, 80, 140, 35);

        toLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        toLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toLbl.setText("To");
        panel.add(toLbl);
        toLbl.setBounds(600, 80, 80, 30);

        classBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        classBox.setText("I Want to Check Attendance Of All Students In Given Class");
        classBox.setContentAreaFilled(false);
        panel.add(classBox);
        classBox.setBounds(440, 190, 390, 23);

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

    private void stIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stIdComboActionPerformed


    }//GEN-LAST:event_stIdComboActionPerformed

    private void yearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTxtActionPerformed

    }//GEN-LAST:event_yearTxtActionPerformed

    private void yearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTxtKeyTyped
            Validation.textYear(yearTxt);
            if (yearTxt.getText().length() == 3) {
                classIdCombo.requestFocusInWindow();
            }

       
    }//GEN-LAST:event_yearTxtKeyTyped

    private void classIdComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_classIdComboFocusGained

        matchClassId();
    }//GEN-LAST:event_classIdComboFocusGained

    private void classIdComboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_classIdComboFocusLost

    }//GEN-LAST:event_classIdComboFocusLost

    private void classIdComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classIdComboMouseClicked

    }//GEN-LAST:event_classIdComboMouseClicked

    private void classIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classIdComboActionPerformed

    }//GEN-LAST:event_classIdComboActionPerformed

    private void classIdComboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_classIdComboKeyPressed

    }//GEN-LAST:event_classIdComboKeyPressed

    private void secondDateTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondDateTxtActionPerformed

        if (classIdCombo.getSelectedItem() != "none" && classIdCombo.getSelectedItem() != "All") {
            toGivenClass();
        } else if (classIdCombo.getSelectedItem() == "All") {
            toAllClassesOfAStudent();
        } else if (classIdCombo.getSelectedItem() == "none") {
            JOptionPane.showMessageDialog(this, "Select a class");

        }
        if (classBox.isSelected()) {
            if (classIdCombo.getSelectedItem() != "none" && classIdCombo.getSelectedItem() != "All") {
                toAllStudentInGivenClass();
            } else {
                JOptionPane.showMessageDialog(this, "Select a class");

            }
        }
    }//GEN-LAST:event_secondDateTxtActionPerformed

    private void secondDateTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_secondDateTxtKeyReleased
        if (secondDateTxt.getText().length() == 4) {
            secondDateTxt.setText(secondDateTxt.getText() + "-");

        }
        if (secondDateTxt.getText().length() == 7) {
            secondDateTxt.setText(secondDateTxt.getText() + "-");
        }
    }//GEN-LAST:event_secondDateTxtKeyReleased

    private void firstDateTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstDateTxtActionPerformed
        secondDateTxt.requestFocusInWindow();
    }//GEN-LAST:event_firstDateTxtActionPerformed

    private void firstDateTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstDateTxtKeyReleased
        if (firstDateTxt.getText().length() == 4) {
            firstDateTxt.setText(firstDateTxt.getText() + "-");

        }
        if (firstDateTxt.getText().length() == 7) {
            firstDateTxt.setText(firstDateTxt.getText() + "-");
        }
    }//GEN-LAST:event_firstDateTxtKeyReleased

    private void firstDateTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstDateTxtKeyTyped
       
    }//GEN-LAST:event_firstDateTxtKeyTyped

    private void studentAttentanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentAttentanceMouseClicked

    }//GEN-LAST:event_studentAttentanceMouseClicked

    private void yearTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_yearTxtFocusLost
        if (validateYear(yearTxt.getText())) {
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Number Format");
        }
   
    }//GEN-LAST:event_yearTxtFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox classBox;
    private javax.swing.JComboBox classIdCombo;
    private javax.swing.JLabel classdLbl1;
    private javax.swing.JLabel durationLbl2;
    private javax.swing.JTextField firstDateTxt;
    private javax.swing.JLabel idLbl1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLbl1;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField secondDateTxt;
    private javax.swing.JComboBox stIdCombo;
    private javax.swing.JPanel studentAttentance;
    private javax.swing.JTable table;
    private javax.swing.JLabel toLbl;
    private javax.swing.JTextField yearTxt;
    // End of variables declaration//GEN-END:variables
}
