/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import com.ijse.sms.model.Lecturer;
import com.ijse.sms.model.SelectClass;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import com.ijse.sms.controller.LecturerController;
import com.ijse.sms.controller.SelectClassController;
import com.ijse.sms.util.Validation;


/**
 *
 * @author Randula
 */
public class TeachersSchedule extends javax.swing.JDialog {

    /**
     * Creates new form TeachersSchedule
     */
    public TeachersSchedule(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        arrangeLecturerCombo();
    }

    public void arrangeLecturerCombo() {

        try {
            ArrayList<Lecturer> lecturerList = LecturerController.viewAllLecturer();
            for (Lecturer lecturer : lecturerList) {
                lectIdCombo.addItem(lecturer.getLectID());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TeachersSchedule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TeachersSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void arrangeTable() {

        try {
            String year = yearTxt.getText();
            String lectId = (String) lectIdCombo.getSelectedItem();

            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            ArrayList<SelectClass> list = SelectClassController.teachersInchargeOfClass(lectId, year);
            for (SelectClass selectClass : list) {

                Object[] rows = {selectClass.getClassDay(), selectClass.getClassName(), selectClass.getStartTime(), selectClass.getEndTime()};
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

        nameLbl1 = new javax.swing.JLabel();
        yearTxt = new javax.swing.JTextField();
        lectIdLbl = new javax.swing.JLabel();
        lectIdCombo = new javax.swing.JComboBox();
        lectNameLbl = new javax.swing.JLabel();
        lectNameTxt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Teachers' Schedules");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl1.setText("Year");
        getContentPane().add(nameLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 70, 35));

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
        getContentPane().add(yearTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 500, 40));

        lectIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lectIdLbl.setText("Lecturer ID");
        getContentPane().add(lectIdLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 80, 40));

        lectIdCombo.setEditable(true);
        lectIdCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        lectIdCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        lectIdCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lectIdComboActionPerformed(evt);
            }
        });
        getContentPane().add(lectIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 500, 40));

        lectNameLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lectNameLbl.setText("Lect Name");
        getContentPane().add(lectNameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 70, 40));

        lectNameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(lectNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 500, 40));

        table.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
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
        table.setFillsViewportHeight(true);
        table.setGridColor(new java.awt.Color(204, 0, 0));
        table.setRowHeight(20);
        table.setSelectionBackground(new java.awt.Color(255, 204, 153));
        table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(table);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 300, 720, 150));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void yearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTxtActionPerformed
        arrangeTable();
    }//GEN-LAST:event_yearTxtActionPerformed

    private void yearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTxtKeyTyped
        Validation.textYear(yearTxt);
    }//GEN-LAST:event_yearTxtKeyTyped

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
            java.util.logging.Logger.getLogger(TeachersSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeachersSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeachersSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeachersSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TeachersSchedule dialog = new TeachersSchedule(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox lectIdCombo;
    private javax.swing.JLabel lectIdLbl;
    private javax.swing.JLabel lectNameLbl;
    private javax.swing.JTextField lectNameTxt;
    private javax.swing.JLabel nameLbl1;
    private javax.swing.JTable table;
    private javax.swing.JTextField yearTxt;
    // End of variables declaration//GEN-END:variables
}
