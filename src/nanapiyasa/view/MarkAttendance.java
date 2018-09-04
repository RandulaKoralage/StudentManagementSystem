/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.ijse.sms.controller.AttendanceController;
import com.ijse.sms.controller.SelectClassController;
import com.ijse.sms.controller.StudentController;
import com.ijse.sms.controller.TimetableController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.Attendance;
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
public class MarkAttendance extends javax.swing.JPanel {

    /**
     * Creates new form MarkAttendance
     */
     
    public MarkAttendance() {
        initComponents();
        String date = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
        dateTxt.setText(date);
          saveBtn.setEnabled(false);
    }
        DefaultTableModel dtm =null;
    private void matchClassNames() {
        try {
            String year = yearTxt.getText();
            classCombo.removeAllItems();
            
            String[] array = SelectClassController.classNamesOfAYear(year);
            for (String names : array) {
                classCombo.addItem(names);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getStudentNameList() {
        try {
            String year = yearTxt.getText();
            String className = (String) classCombo.getSelectedItem();
            String[] array = StudentController.studentNames(year, className);
             dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            for (String names : array) {
                String stId = StudentController.getStIdFromName(names);
                Object[] row = {stId, names,false};
                dtm.addRow(row);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setScheduleId(String className) {
        try {
            String scheduleId = TimetableController.giveScheduleIdToClassName(className);
            scheduleIdLbl.setText(scheduleId);  
            if(table.getRowCount()>0 && scheduleId!=null){
                saveBtn.setEnabled(true);
            }else{
                 saveBtn.setEnabled(false);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  private void printAttendanceSheet(){
        try {
            String className=(String)classCombo.getSelectedItem();
            String date=dateTxt.getText();
         // InputStream is=getClass().getResourceAsStream("./src/nanapiyasa/reports/AttendanceSheet.jrxml");
            JasperReport jr=JasperCompileManager.compileReport("./src/com/ijse/sms/reports/Attendance_1.jrxml");
            HashMap hm=new HashMap();
            hm.put("cName",className);
           hm.put("date",date);
            
            JasperPrint jp=JasperFillManager.fillReport(jr, hm, new JRTableModelDataSource(dtm));
             //  JasperPrint jp = JasperFillManager.fillReport(jr, hm, DBConnection.getDBConnection().getConnection());
            JasperViewer.viewReport(jp,false);
        } catch (JRException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
  }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        scheduleIdLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        durationLbl2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        classCombo = new javax.swing.JComboBox();
        clearBtn = new javax.swing.JButton();
        classLbl = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        yearTxt = new javax.swing.JTextField();
        nameLbl1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(900, 630));
        panel.setLayout(null);
        panel.add(scheduleIdLbl);
        scheduleIdLbl.setBounds(640, 10, 180, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mark Attendance");
        panel.add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 50);

        dateTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        dateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTxtActionPerformed(evt);
            }
        });
        panel.add(dateTxt);
        dateTxt.setBounds(640, 80, 180, 40);

        saveBtn.setBackground(new java.awt.Color(255, 233, 248));
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        panel.add(saveBtn);
        saveBtn.setBounds(290, 560, 110, 30);

        durationLbl2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        durationLbl2.setText("Reason");
        panel.add(durationLbl2);
        durationLbl2.setBounds(-420, 410, 60, 30);

        table.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "St ID", "Name", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(204, 0, 0));
        table.setOpaque(false);
        table.setRowHeight(20);
        table.setSelectionBackground(new java.awt.Color(255, 204, 153));
        table.setSelectionForeground(new java.awt.Color(51, 51, 0));
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(100);
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(0).setMaxWidth(100);
            table.getColumnModel().getColumn(1).setMinWidth(400);
            table.getColumnModel().getColumn(1).setPreferredWidth(400);
            table.getColumnModel().getColumn(1).setMaxWidth(400);
            table.getColumnModel().getColumn(2).setMinWidth(100);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        panel.add(jScrollPane1);
        jScrollPane1.setBounds(160, 180, 600, 350);

        classCombo.setEditable(true);
        classCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        classCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        classCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        classCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                classComboFocusGained(evt);
            }
        });
        classCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classComboActionPerformed(evt);
            }
        });
        panel.add(classCombo);
        classCombo.setBounds(390, 80, 180, 40);

        clearBtn.setBackground(new java.awt.Color(255, 233, 248));
        clearBtn.setText("Print Empty Sheet");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        panel.add(clearBtn);
        clearBtn.setBounds(480, 560, 120, 30);

        classLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        classLbl.setText("Class Name");
        panel.add(classLbl);
        classLbl.setBounds(310, 80, 70, 40);

        dateLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dateLbl.setText("Date");
        panel.add(dateLbl);
        dateLbl.setBounds(600, 80, 40, 40);

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
        yearTxt.setBounds(150, 80, 140, 40);

        nameLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl1.setText("Academic Year");
        panel.add(nameLbl1);
        nameLbl1.setBounds(50, 80, 90, 40);

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

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        printAttendanceSheet();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void dateTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTxtActionPerformed

    private void yearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTxtActionPerformed

    }//GEN-LAST:event_yearTxtActionPerformed

    private void yearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTxtKeyTyped
       Validation.textYear(yearTxt);
        if (yearTxt.getText().length() == 3) {
            classCombo.requestFocusInWindow();

        }
    }//GEN-LAST:event_yearTxtKeyTyped

    private void classComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_classComboFocusGained
        matchClassNames();
    }//GEN-LAST:event_classComboFocusGained

    private void classComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classComboActionPerformed
        getStudentNameList();
        String className = (String) classCombo.getSelectedItem();

        setScheduleId(className);

    }//GEN-LAST:event_classComboActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            ArrayList<Attendance> list = new ArrayList<Attendance>();

            for (int i = 0; i < table.getRowCount(); i++) {

                int attId = 0;
                String stId = (String) table.getValueAt(i, 0);
                String date = dateTxt.getText();
                String status = "AB";
                if ((Boolean) table.getValueAt(i, 2) == true) {
                    status = "PR";
                }
                
                String scheduleId = scheduleIdLbl.getText();
                Attendance attendance = new Attendance(attId, stId, scheduleId, date, status);
                list.add(attendance);
            }

            boolean isAdded = AttendanceController.addAttendance(list);
            if (isAdded) {
                JOptionPane.showMessageDialog(this, "Attendance Saved");
            } else {
                JOptionPane.showMessageDialog(this, "Saving Failed");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_saveBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox classCombo;
    private javax.swing.JLabel classLbl;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JLabel durationLbl2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLbl1;
    private javax.swing.JPanel panel;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel scheduleIdLbl;
    private javax.swing.JTable table;
    private javax.swing.JTextField yearTxt;
    // End of variables declaration//GEN-END:variables
}
