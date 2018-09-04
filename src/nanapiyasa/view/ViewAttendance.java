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
import com.ijse.sms.controller.AttendanceController;
import com.ijse.sms.controller.SelectClassController;
import com.ijse.sms.controller.StudentController;
import com.ijse.sms.controller.TimetableController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.Attendance;
/**
 *
 * @author Randula
 */
public class ViewAttendance extends javax.swing.JPanel {

    /**
     * Creates new form ViewAttendance
     */
    public ViewAttendance() {
        initComponents();
    }

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
     
     private void setDateList(){
         
         
          try {
           String className=(String)classCombo.getSelectedItem();
            dateCombo.removeAllItems();
            
            String[] array = AttendanceController.viewAttendanceDates(className);
            for (String names : array) {
                dateCombo.addItem(names);
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
            String givenDate=(String)dateCombo.getSelectedItem();
            ArrayList<Attendance>list=AttendanceController.viewSelectedAttendance(year, givenDate, className);
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            for (Attendance attendance :list) {
                String name=StudentController.getStNameFromId(attendance.getStID());
                Object[] row = {attendance.getAttendID(),attendance.getStID(),name,attendance.getStatus()};
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
            scheduleIdTxt.setText(scheduleId);  
            
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
        jLabel2 = new javax.swing.JLabel();
        durationLbl2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        dateCombo = new javax.swing.JComboBox();
        classLbl = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        stIdLbl = new javax.swing.JLabel();
        stIdTxt = new javax.swing.JTextField();
        scheduleIdTxt = new javax.swing.JTextField();
        scheduleIdLbl = new javax.swing.JLabel();
        attIdLbl = new javax.swing.JLabel();
        attIdTxt = new javax.swing.JTextField();
        dateTxt = new javax.swing.JTextField();
        givenDateLbl = new javax.swing.JLabel();
        statusLbl = new javax.swing.JLabel();
        statusTxt = new javax.swing.JTextField();
        clearBtn1 = new javax.swing.JButton();
        editBtn = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameLbl1 = new javax.swing.JLabel();
        yearTxt = new javax.swing.JTextField();
        classCombo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(900, 630));
        panel.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("View Attendance");
        panel.add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 40);

        durationLbl2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        durationLbl2.setText("Reason");
        panel.add(durationLbl2);
        durationLbl2.setBounds(-420, 410, 60, 30);

        table.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Att ID", "St ID", "Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(204, 0, 0));
        table.setRowHeight(20);
        table.setRowMargin(5);
        table.setSelectionBackground(new java.awt.Color(255, 204, 153));
        table.setSelectionForeground(new java.awt.Color(51, 0, 51));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(75);
            table.getColumnModel().getColumn(0).setPreferredWidth(75);
            table.getColumnModel().getColumn(0).setMaxWidth(75);
            table.getColumnModel().getColumn(1).setMinWidth(100);
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(1).setMaxWidth(100);
            table.getColumnModel().getColumn(3).setMinWidth(50);
            table.getColumnModel().getColumn(3).setPreferredWidth(50);
            table.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        panel.add(jScrollPane1);
        jScrollPane1.setBounds(400, 190, 490, 410);

        dateCombo.setEditable(true);
        dateCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        panel.add(dateCombo);
        dateCombo.setBounds(690, 80, 160, 40);

        classLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        classLbl.setText("Class Name");
        panel.add(classLbl);
        classLbl.setBounds(310, 80, 70, 40);

        dateLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dateLbl.setText("Date");
        panel.add(dateLbl);
        dateLbl.setBounds(640, 80, 40, 40);

        jButton1.setText("Reload");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel.add(jButton1);
        jButton1.setBounds(400, 150, 140, 30);

        stIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        stIdLbl.setText("Student ID");
        panel.add(stIdLbl);
        stIdLbl.setBounds(20, 250, 70, 20);

        stIdTxt.setEditable(false);
        stIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        panel.add(stIdTxt);
        stIdTxt.setBounds(100, 240, 280, 35);

        scheduleIdTxt.setEditable(false);
        scheduleIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        panel.add(scheduleIdTxt);
        scheduleIdTxt.setBounds(100, 290, 280, 35);

        scheduleIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        scheduleIdLbl.setText("Schedule ID");
        panel.add(scheduleIdLbl);
        scheduleIdLbl.setBounds(20, 300, 70, 20);

        attIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        attIdLbl.setText("Att ID");
        panel.add(attIdLbl);
        attIdLbl.setBounds(20, 190, 60, 35);

        attIdTxt.setEditable(false);
        attIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        panel.add(attIdTxt);
        attIdTxt.setBounds(100, 190, 280, 35);

        dateTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        panel.add(dateTxt);
        dateTxt.setBounds(100, 340, 280, 35);

        givenDateLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        givenDateLbl.setText("Date");
        panel.add(givenDateLbl);
        givenDateLbl.setBounds(20, 340, 70, 30);

        statusLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        statusLbl.setText("Status");
        panel.add(statusLbl);
        statusLbl.setBounds(20, 390, 60, 30);

        statusTxt.setToolTipText("Absent/Present");
        statusTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        panel.add(statusTxt);
        statusTxt.setBounds(100, 390, 280, 35);

        clearBtn1.setBackground(new java.awt.Color(255, 233, 248));
        clearBtn1.setText("Clear");
        panel.add(clearBtn1);
        clearBtn1.setBounds(100, 460, 110, 30);

        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Edit.png"))); // NOI18N
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtnMouseClicked(evt);
            }
        });
        panel.add(editBtn);
        editBtn.setBounds(100, 510, 80, 70);

        jLabel5.setText("Save Changes");
        panel.add(jLabel5);
        jLabel5.setBounds(100, 580, 70, 20);

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Delete.png"))); // NOI18N
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });
        panel.add(deleteBtn);
        deleteBtn.setBounds(260, 510, 70, 70);

        jLabel3.setText("Remove");
        panel.add(jLabel3);
        jLabel3.setBounds(270, 580, 50, 20);

        nameLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl1.setText("Academic Year");
        panel.add(nameLbl1);
        nameLbl1.setBounds(50, 80, 90, 40);

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
     
        setDateList();
       
    }//GEN-LAST:event_classComboActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      getStudentNameList();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int i=table.getSelectedRow();
        
        setScheduleId((String)classCombo.getSelectedItem());
            
	attIdTxt.setText((String)table.getValueAt(i,0).toString());
	stIdTxt.setText((String)table.getValueAt(i,1));
        dateTxt.setText((String)dateCombo.getSelectedItem());
        statusTxt.setText((String)table.getValueAt(i,3).toString());
       
     
    }//GEN-LAST:event_tableMouseClicked

    private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked
       int res=JOptionPane.showOptionDialog(this, "Dou you want to save changes?","Options", 0,0,null,null,null );
            if(res==0){
           try {
               int attId=Integer.parseInt(attIdTxt.getText());
               String currentDate=dateTxt.getText();
               String scheduleId=scheduleIdTxt.getText();
               String status=statusTxt.getText();
               String stId=stIdTxt.getText();
               Attendance attendance=new Attendance( attId, stId,scheduleId, currentDate, status);
               boolean isUpdated=AttendanceController.updateAttendance(attendance);
               
               if(isUpdated){
                   JOptionPane.showMessageDialog(this, "Saved Changes");
               }else{
                   JOptionPane.showMessageDialog(this, "Can not update Attendance Record");
               }  } catch (ClassNotFoundException ex) {
               Logger.getLogger(ViewAttendance.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(ViewAttendance.class.getName()).log(Level.SEVERE, null, ex);
           }
            }
    }//GEN-LAST:event_editBtnMouseClicked

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
           int res=JOptionPane.showOptionDialog(this, "Dou you want to Delete this Record?","Options", 0,0,null,null,null );
            if(res==0){
             try {
                 String id=attIdTxt.getText();
                 boolean isDeleted=AttendanceController.deleteAttendance(id);
                 if(isDeleted){
                       JOptionPane.showMessageDialog(this,"Attendance Record Removed");
                       getStudentNameList();
                 }else{
                       JOptionPane.showMessageDialog(this,"Try Again");
                 }
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
             } catch (SQLException ex) {
                 Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
             }
                
            }
    }//GEN-LAST:event_deleteBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attIdLbl;
    private javax.swing.JTextField attIdTxt;
    private javax.swing.JComboBox classCombo;
    private javax.swing.JLabel classLbl;
    private javax.swing.JButton clearBtn1;
    private javax.swing.JComboBox dateCombo;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JLabel deleteBtn;
    private javax.swing.JLabel durationLbl2;
    private javax.swing.JLabel editBtn;
    private javax.swing.JLabel givenDateLbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLbl1;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel scheduleIdLbl;
    private javax.swing.JTextField scheduleIdTxt;
    private javax.swing.JLabel stIdLbl;
    private javax.swing.JTextField stIdTxt;
    private javax.swing.JLabel statusLbl;
    private javax.swing.JTextField statusTxt;
    private javax.swing.JTable table;
    private javax.swing.JTextField yearTxt;
    // End of variables declaration//GEN-END:variables
}
