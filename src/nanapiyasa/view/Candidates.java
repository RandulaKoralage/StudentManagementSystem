/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import com.ijse.sms.controller.ExaminationController;
import com.ijse.sms.controller.RegistrationController;
import com.ijse.sms.controller.StudentController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.Registration;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
public class Candidates extends javax.swing.JFrame {

    /**
     * Creates new form Candidates
     */
    DefaultTableModel dtm = null;

    public Candidates() {
        initComponents();
        repeateBtn.setEnabled(false);

    }
    boolean isPassed = false;

    private void getExamList() {
        try {
            String year = eYearTxt.getText();

            examIdCombo.removeAllItems();
            examIdCombo.addItem("none");
            String[] array = ExaminationController.finalExamNameOfAYear(year);
            for (String name : array) {
                examIdCombo.addItem(name);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void arrangeTable() {
        try {
            String eYear = eYearTxt.getText();
            String acYear = acYearTxt.getText();
            String eName = (String) examIdCombo.getSelectedItem();
            ArrayList<Registration> list = RegistrationController.viewAllCandidates(eYear, acYear, eName);
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            for (Registration registration : list) {
                String name = StudentController.getStNameFromId(registration.getStID());
                Object[] row = {registration.getStID(), registration.getRegID(), name};
                dtm.addRow(row);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewAllExaminations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllExaminations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void compareDate() {
        try {
            String eName = (String) examIdCombo.getSelectedItem();
            String eYear = eYearTxt.getText();
            String day1 = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
            String day2 = ExaminationController.getDate(eName, eYear);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse(day1);
            Date date2 = sdf.parse(day2);

            if (date1.after(date2)) {
                messageTxt.setText("Examination Date Passed, May be There have Repeate Exam Candidates");
                repeateBtn.setEnabled(true);
            }

            if (date1.before(date2)) {
                messageTxt.setText("Examination Date Will Come Soon");
                repeateBtn.setEnabled(false);
            }

            if (date1.equals(date2)) {
                messageTxt.setText("Today is Examination Date");
                repeateBtn.setEnabled(false);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Candidates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Candidates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Candidates.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void arrangeRepeateTable() {
        try {
            String eYear = eYearTxt.getText();
            String acYear = acYearTxt.getText();
            String eName = (String) examIdCombo.getSelectedItem();
            ArrayList<Registration> list = RegistrationController.viewRepeateCandidates(eYear, acYear, eName);
            dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            for (Registration registration : list) {
                String name = StudentController.getStNameFromId(registration.getStID());
                Object[] row = {registration.getStID(), registration.getRegID(), name};
                dtm.addRow(row);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewAllExaminations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllExaminations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void printCandidates() {
        try {
            String eName = examNameTxt.getText();
            String eYear = eYearTxt.getText();
            // InputStream is=getClass().getResourceAsStream("./src/nanapiyasa/reports/AttendanceSheet.jrxml");
            JasperReport jr = JasperCompileManager.compileReport("./src/com/ijse/sms/reports/Candidates.jrxml");
            HashMap hm = new HashMap();
            hm.put("eName", eName);
            hm.put("year", eYear);

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
        yearLbl = new javax.swing.JLabel();
        eYearTxt = new javax.swing.JTextField();
        examIdCombo = new javax.swing.JComboBox();
        examIdLbl1 = new javax.swing.JLabel();
        yearLbl1 = new javax.swing.JLabel();
        acYearTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        messageTxt = new javax.swing.JLabel();
        repeateBtn = new javax.swing.JButton();
        printBtn = new javax.swing.JButton();
        examNameTxt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Candidates");

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        yearLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        yearLbl.setText("Exam Year");
        panel.add(yearLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        eYearTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        eYearTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eYearTxtActionPerformed(evt);
            }
        });
        eYearTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                eYearTxtKeyTyped(evt);
            }
        });
        panel.add(eYearTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 120, 40));

        examIdCombo.setEditable(true);
        examIdCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        examIdCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        examIdCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                examIdComboFocusGained(evt);
            }
        });
        examIdCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examIdComboActionPerformed(evt);
            }
        });
        examIdCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                examIdComboKeyPressed(evt);
            }
        });
        panel.add(examIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 290, 40));

        examIdLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        examIdLbl1.setText("Exam ID");
        panel.add(examIdLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 60, 40));

        yearLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        yearLbl1.setText("Acedemic  Year");
        panel.add(yearLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, -1, -1));

        acYearTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        acYearTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acYearTxtMouseClicked(evt);
            }
        });
        acYearTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acYearTxtActionPerformed(evt);
            }
        });
        acYearTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                acYearTxtKeyTyped(evt);
            }
        });
        panel.add(acYearTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 120, 40));

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
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "St Id", "Reg Id", "Name"
            }
        ));
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(100);
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(0).setMaxWidth(100);
            table.getColumnModel().getColumn(1).setMinWidth(150);
            table.getColumnModel().getColumn(1).setPreferredWidth(150);
            table.getColumnModel().getColumn(1).setMaxWidth(150);
            table.getColumnModel().getColumn(2).setMinWidth(250);
            table.getColumnModel().getColumn(2).setPreferredWidth(250);
            table.getColumnModel().getColumn(2).setMaxWidth(250);
        }

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 500, 400));

        messageTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        messageTxt.setForeground(new java.awt.Color(255, 0, 0));
        messageTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel.add(messageTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 570, 50));

        repeateBtn.setText("Find Repeate Candidates");
        repeateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repeateBtnActionPerformed(evt);
            }
        });
        panel.add(repeateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 180, 40));

        printBtn.setText("Print List");
        printBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });
        panel.add(printBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 180, 40));

        examNameTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        examNameTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        examNameTxt.setText("jLabel1");
        panel.add(examNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 490, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background2.png"))); // NOI18N
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 660, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void eYearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eYearTxtActionPerformed
        if (examIdCombo.getSelectedItem() != "none") {
            acYearTxt.requestFocusInWindow();
        }
    }//GEN-LAST:event_eYearTxtActionPerformed

    private void eYearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eYearTxtKeyTyped
        Validation.textYear(eYearTxt);
        if (eYearTxt.getText().length() == 3) {
            examIdCombo.requestFocusInWindow();

        }
    }//GEN-LAST:event_eYearTxtKeyTyped

    private void examIdComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_examIdComboFocusGained
        getExamList();
    }//GEN-LAST:event_examIdComboFocusGained

    private void examIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examIdComboActionPerformed
        examNameTxt.setText((String) examIdCombo.getSelectedItem());
        repeateBtn.setEnabled(false);
    }//GEN-LAST:event_examIdComboActionPerformed

    private void acYearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acYearTxtActionPerformed
        arrangeTable();

        if (examIdCombo.getSelectedItem() != "none") {
            if (table.getRowCount() > 0) {
                compareDate();
            } else {
                JOptionPane.showMessageDialog(this, "No Candidates Found");
            }
        }
    }//GEN-LAST:event_acYearTxtActionPerformed

    private void acYearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_acYearTxtKeyTyped
        Validation.textYear(acYearTxt);
        if (acYearTxt.getText().length() == 3) {
            arrangeTable();

        }
    }//GEN-LAST:event_acYearTxtKeyTyped

    private void repeateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repeateBtnActionPerformed
        arrangeRepeateTable();
        if (examNameTxt.getText() == (String) examIdCombo.getSelectedItem()) {
            examNameTxt.setText(examNameTxt.getText() + "- Repeate");
        }
    }//GEN-LAST:event_repeateBtnActionPerformed

    private void examIdComboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_examIdComboKeyPressed

    }//GEN-LAST:event_examIdComboKeyPressed

    private void acYearTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acYearTxtMouseClicked
        messageTxt.setText(null);
        examNameTxt.setText((String) examIdCombo.getSelectedItem());
    }//GEN-LAST:event_acYearTxtMouseClicked

    private void printBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBtnActionPerformed
        printCandidates();
    }//GEN-LAST:event_printBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Candidates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Candidates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Candidates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Candidates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Candidates().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField acYearTxt;
    private javax.swing.JTextField eYearTxt;
    private javax.swing.JComboBox examIdCombo;
    private javax.swing.JLabel examIdLbl1;
    private javax.swing.JLabel examNameTxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel messageTxt;
    private javax.swing.JPanel panel;
    private javax.swing.JButton printBtn;
    private javax.swing.JButton repeateBtn;
    private javax.swing.JTable table;
    private javax.swing.JLabel yearLbl;
    private javax.swing.JLabel yearLbl1;
    // End of variables declaration//GEN-END:variables
}
