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
public class ModifyTimetable extends javax.swing.JDialog {

    /**
     * Creates new form ModifyTimetable
     */
    public ModifyTimetable(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getScheduleList();
        arrangeLecturerCombo();
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
        
        lectIdCombo.addItem("none");
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
       public void getScheduleList(){
        try {
            
            String array[]=TimetableController.viewScheduleId();
           
            scheduleIdCombo.addItem("none");
            for(String d:array){
                scheduleIdCombo.addItem(d);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void arrangeTable(){
        try {
            String year =yearTxt.getText();
        
            String lectId=(String) lectIdCombo.getSelectedItem();
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            ArrayList<SelectClass>list=SelectClassController.teachersInchargeOfClass(lectId,year);
            for(SelectClass selectClass: list){
                Object[] rows={selectClass.getClassID(),selectClass.getClassDay(),selectClass.getClassName(),selectClass.getStartTime(),selectClass.getEndTime()};
                dtm.addRow(rows);
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModifyTimetable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModifyTimetable.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     }
    public void matchLectName(String lectId){
       
            try {
                
                Lecturer lecturer = LecturerController.searchLecturer(lectId);
                lectNameTxt.setText(lecturer.getLectName());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageTimetable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ManageTimetable.class.getName()).log(Level.SEVERE, null, ex);
            }
            arrangeTable();
        
    }
    public void matchYear(){
        try {
            String classId=(String)classIdCombo.getSelectedItem();
            String year=SelectClassController.year(classId);
            yearTxt.setText(year);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModifyTimetable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModifyTimetable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void idNotKonow(){
        
            try {
                String classId=(String)classIdCombo.getSelectedItem();
                String lectId=(String)lectIdCombo.getSelectedItem();
                String scheduleId=TimetableController.giveScheduleId(classId, lectId);
                scheduleIdCombo.setSelectedItem(scheduleId);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ModifyTimetable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ModifyTimetable.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scheduleIdLbl = new javax.swing.JLabel();
        yearTxt = new javax.swing.JTextField();
        nameLbl1 = new javax.swing.JLabel();
        classIdLbl = new javax.swing.JLabel();
        classIdCombo = new javax.swing.JComboBox();
        nameTxt = new javax.swing.JTextField();
        nameLbl = new javax.swing.JLabel();
        lectIdLbl = new javax.swing.JLabel();
        lectIdCombo = new javax.swing.JComboBox();
        lectNameTxt = new javax.swing.JTextField();
        lectNameLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        scheduleIdCombo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        editBtn = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modify Timetable");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scheduleIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        scheduleIdLbl.setText("Schedule ID");
        getContentPane().add(scheduleIdLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, 40));

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
        getContentPane().add(yearTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 500, 40));

        nameLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl1.setText("Year");
        getContentPane().add(nameLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 70, 35));

        classIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        classIdLbl.setText("Class ID");
        getContentPane().add(classIdLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 70, 40));

        classIdCombo.setEditable(true);
        classIdCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        classIdCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
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
        getContentPane().add(classIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 500, 40));

        nameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        nameTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameTxtFocusGained(evt);
            }
        });
        getContentPane().add(nameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 185, 500, 40));

        nameLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl.setText("Name");
        getContentPane().add(nameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 185, 70, 35));

        lectIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lectIdLbl.setText("Lecturer ID");
        getContentPane().add(lectIdLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 235, 80, 40));

        lectIdCombo.setEditable(true);
        lectIdCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        lectIdCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        lectIdCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lectIdComboActionPerformed(evt);
            }
        });
        getContentPane().add(lectIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 235, 500, 40));

        lectNameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(lectNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 285, 500, 40));

        lectNameLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lectNameLbl.setText("Lect Name");
        getContentPane().add(lectNameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 285, 70, 40));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Class ID", "Day", "Class Name", "Start Time", "End Time"
            }
        ));
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 405, 720, 90));

        scheduleIdCombo.setEditable(true);
        scheduleIdCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        scheduleIdCombo.setToolTipText("");
        scheduleIdCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        scheduleIdCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scheduleIdComboMouseClicked(evt);
            }
        });
        scheduleIdCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleIdComboActionPerformed(evt);
            }
        });
        getContentPane().add(scheduleIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 500, 40));

        jLabel5.setText("Save Changes");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, 70, 20));

        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Edit.png"))); // NOI18N
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtnMouseClicked(evt);
            }
        });
        getContentPane().add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, 80, 70));

        jLabel3.setText("Remove");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 380, 50, 20));

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Delete.png"))); // NOI18N
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });
        getContentPane().add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 310, 70, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void yearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTxtActionPerformed
        
    }//GEN-LAST:event_yearTxtActionPerformed

    private void classIdComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classIdComboMouseClicked

    }//GEN-LAST:event_classIdComboMouseClicked

    private void classIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classIdComboActionPerformed
          matchNames();         
          if(lectIdCombo.getSelectedItem()!="none"&&classIdCombo.getSelectedItem()!="none"&&scheduleIdCombo.getSelectedItem()=="none"){
          idNotKonow();         
          }else{
              matchYear();
          }
    }//GEN-LAST:event_classIdComboActionPerformed

    private void nameTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTxtFocusGained

        
    }//GEN-LAST:event_nameTxtFocusGained

    private void lectIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lectIdComboActionPerformed
     
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
            if(lectIdCombo.getSelectedItem()!="none"&&classIdCombo.getSelectedItem()!="none"&&scheduleIdCombo.getSelectedItem()=="none"){
            idNotKonow();
            }
    }//GEN-LAST:event_lectIdComboActionPerformed

    private void scheduleIdComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scheduleIdComboMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_scheduleIdComboMouseClicked

    private void scheduleIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleIdComboActionPerformed
      
            try {
                String scheduleId=(String)scheduleIdCombo.getSelectedItem();
                Timetable timetable=TimetableController.searchTimetable(scheduleId);
                String classId=timetable.getClassID();
                classIdCombo.setSelectedItem(classId);
                String lectId=timetable.getLectID();
                lectIdCombo.setSelectedItem(lectId);
                matchLectName(lectId);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ModifyTimetable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ModifyTimetable.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }//GEN-LAST:event_scheduleIdComboActionPerformed

    private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked
        int res=JOptionPane.showOptionDialog(this, "Dou you want to save changes?","Options", 0,0,null,null,null );
        if(res==0){
            try {
                String scheduleId=(String)scheduleIdCombo.getSelectedItem();
                String classId=(String)classIdCombo.getSelectedItem();
                String lectId=(String)lectIdCombo.getSelectedItem();
               Timetable timetable=new Timetable(scheduleId, lectId, classId);

                boolean isUpdated=TimetableController.updateTimetable(timetable);
                if(isUpdated){
                    JOptionPane.showMessageDialog(this, "Saved Changes");
                }else{
                    JOptionPane.showMessageDialog(this, "Can not update Timetable");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ModifyCertificates.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ModifyCertificates.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_editBtnMouseClicked

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
        int res=JOptionPane.showOptionDialog(this, "Dou you want to delete this Preparation","Options", 0,0,null,null,null );
        if(res==0){
            String scheduleId=(String)scheduleIdCombo.getSelectedItem();
            try {
                boolean isDeleted=TimetableController.deleteTimetable(scheduleId);
                if(isDeleted){
                    JOptionPane.showMessageDialog(this, "Successfully Deleted");
                   
                }else{
                    JOptionPane.showMessageDialog(this, "Try Again");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageCertificate.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ManageCertificate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteBtnMouseClicked

    private void yearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTxtKeyTyped
      Validation.textYear(yearTxt);
    }//GEN-LAST:event_yearTxtKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModifyTimetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyTimetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyTimetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyTimetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModifyTimetable dialog = new ModifyTimetable(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox classIdCombo;
    private javax.swing.JLabel classIdLbl;
    private javax.swing.JLabel deleteBtn;
    private javax.swing.JLabel editBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox lectIdCombo;
    private javax.swing.JLabel lectIdLbl;
    private javax.swing.JLabel lectNameLbl;
    private javax.swing.JTextField lectNameTxt;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel nameLbl1;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JComboBox scheduleIdCombo;
    private javax.swing.JLabel scheduleIdLbl;
    private javax.swing.JTable table;
    private javax.swing.JTextField yearTxt;
    // End of variables declaration//GEN-END:variables
}
