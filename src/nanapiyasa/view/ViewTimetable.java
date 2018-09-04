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
import javax.swing.table.DefaultTableModel;
import com.ijse.sms.controller.CourseController;
import com.ijse.sms.controller.LecturerController;
import com.ijse.sms.controller.SelectClassController;
import com.ijse.sms.controller.TimetableController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.Lecturer;
import com.ijse.sms.model.SelectClass;
import com.ijse.sms.model.Timetable;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Randula
 */
public class ViewTimetable extends javax.swing.JPanel {

    /**
     * Creates new form ViewTimetable
     */
    public ViewTimetable() {
        initComponents();

        getCourseList();
    }
    DefaultTableModel dtm;

    public void allSchedules() {

        try {
            ArrayList<Timetable> scheduleList = TimetableController.viewSchedual();

            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            for (Timetable timetable : scheduleList) {
                try {
                    SelectClass selectClass = SelectClassController.searchClass(timetable.getClassID());
                    Lecturer lecturer = LecturerController.searchLecturer(timetable.getLectID());
                    Object[] rows = {timetable.getClassID(), selectClass.getClassName(), timetable.getLectID(), lecturer.getLectName(), selectClass.getClassDay(), selectClass.getStartTime(), selectClass.getEndTime()};
                    dtm.addRow(rows);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ViewTimetable.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ViewTimetable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewTimetable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewTimetable.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    private void arrangeTable() {
        try {
            String year = yearTxt.getText();

            String cName = (String) courseCombo.getSelectedItem();
            String cId = CourseController.matchId(cName);

            dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            ArrayList<Timetable> list = TimetableController.timetableView(cId, year);
            for (Timetable timetable : list) {
                String classId = timetable.getClassID();
                SelectClass selectClass = SelectClassController.searchClass(timetable.getClassID());
                String className = SelectClassController.matchName(classId);
                String lectName = LecturerController.matchName(timetable.getLectID());
                String day = SelectClassController.matchNameWithDay(classId);

                Object[] rows = {timetable.getClassID(), className, timetable.getLectID(), lectName, day, selectClass.getStartTime(), selectClass.getEndTime()};
                dtm.addRow(rows);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageTimetable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageTimetable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void printTimetable() {
        try {
            String cName = (String) courseCombo.getSelectedItem();
            String year = yearTxt.getText();
            // InputStream is=getClass().getResourceAsStream("./src/nanapiyasa/reports/AttendanceSheet.jrxml");
            JasperReport jr = JasperCompileManager.compileReport("./src/com/ijse/sms/reports/Timetable1.jrxml");
            HashMap hm = new HashMap();
            hm.put("cName", cName);
            hm.put("year", year);

            JasperPrint jp = JasperFillManager.fillReport(jr, hm, new JRTableModelDataSource(dtm));
            //  JasperPrint jp = JasperFillManager.fillReport(jr, hm, DBConnection.getDBConnection().getConnection());
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        reloadBtn = new javax.swing.JButton();
        durationLbl2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        modifyBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        yearLbl = new javax.swing.JLabel();
        yearTxt = new javax.swing.JTextField();
        courseLbl = new javax.swing.JLabel();
        courseCombo = new javax.swing.JComboBox();

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(900, 630));
        panel.setLayout(null);

        jButton1.setText("Print Timetable");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel.add(jButton1);
        jButton1.setBounds(380, 460, 140, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("View Timetable");
        panel.add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 40);

        reloadBtn.setBackground(new java.awt.Color(255, 233, 248));
        reloadBtn.setText("View All Timetables");
        reloadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadBtnActionPerformed(evt);
            }
        });
        panel.add(reloadBtn);
        reloadBtn.setBounds(210, 460, 130, 30);

        durationLbl2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        durationLbl2.setText("Reason");
        panel.add(durationLbl2);
        durationLbl2.setBounds(-420, 410, 60, 30);

        table.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Class Id", "Class Name", "Lecturer Id", "Lecturer Name", "Day", "Start Time", "End Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            table.getColumnModel().getColumn(0).setMinWidth(100);
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(0).setMaxWidth(100);
            table.getColumnModel().getColumn(2).setMinWidth(100);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setMaxWidth(100);
            table.getColumnModel().getColumn(4).setMinWidth(75);
            table.getColumnModel().getColumn(4).setPreferredWidth(75);
            table.getColumnModel().getColumn(4).setMaxWidth(75);
            table.getColumnModel().getColumn(5).setMinWidth(100);
            table.getColumnModel().getColumn(5).setPreferredWidth(100);
            table.getColumnModel().getColumn(5).setMaxWidth(100);
            table.getColumnModel().getColumn(6).setMinWidth(100);
            table.getColumnModel().getColumn(6).setPreferredWidth(100);
            table.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        panel.add(jScrollPane1);
        jScrollPane1.setBounds(60, 100, 780, 350);

        modifyBtn.setBackground(new java.awt.Color(255, 233, 248));
        modifyBtn.setText("Teacher's Schedules");
        modifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBtnActionPerformed(evt);
            }
        });
        panel.add(modifyBtn);
        modifyBtn.setBounds(560, 460, 130, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background2.png"))); // NOI18N
        panel.add(jLabel1);
        jLabel1.setBounds(0, 90, 835, 520);

        yearLbl.setText("Year");
        panel.add(yearLbl);
        yearLbl.setBounds(490, 60, 40, 30);

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
        yearTxt.setBounds(530, 60, 160, 30);

        courseLbl.setText("Course");
        panel.add(courseLbl);
        courseLbl.setBounds(60, 60, 50, 30);

        courseCombo.setEditable(true);
        courseCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        panel.add(courseCombo);
        courseCombo.setBounds(110, 60, 270, 30);

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

    private void modifyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyBtnActionPerformed
        new TeachersSchedule(null, true).setVisible(true);
    }//GEN-LAST:event_modifyBtnActionPerformed

    private void yearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTxtKeyTyped
        Validation.textYear(yearTxt);

    }//GEN-LAST:event_yearTxtKeyTyped

    private void yearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTxtActionPerformed

        arrangeTable();
    }//GEN-LAST:event_yearTxtActionPerformed

    private void reloadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadBtnActionPerformed
        allSchedules();
    }//GEN-LAST:event_reloadBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        printTimetable();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox courseCombo;
    private javax.swing.JLabel courseLbl;
    private javax.swing.JLabel durationLbl2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JPanel panel;
    private javax.swing.JButton reloadBtn;
    private javax.swing.JTable table;
    private javax.swing.JLabel yearLbl;
    private javax.swing.JTextField yearTxt;
    // End of variables declaration//GEN-END:variables
}
