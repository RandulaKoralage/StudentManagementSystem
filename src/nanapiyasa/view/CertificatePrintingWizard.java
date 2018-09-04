/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import com.ijse.sms.controller.CertificateController;
import com.ijse.sms.controller.CourseController;
import com.ijse.sms.controller.ResultTableController;
import com.ijse.sms.controller.SelectClassController;
import com.ijse.sms.controller.StudentController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.db.DBConnection;
import com.ijse.sms.model.ResultTable;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Randula
 */
public class CertificatePrintingWizard extends javax.swing.JFrame {

    /**
     * Creates new form CertificatePrintingWizard
     */
    public CertificatePrintingWizard() {
        initComponents();
    }

    public CertificatePrintingWizard(String eName, String year, String cName) throws HeadlessException {
        initComponents();
        examTxt.setText(eName);
        yearTxt.setText(year);

    }

    private void fillTable() {

        try {
            String eName = examTxt.getText();
            String year = yearTxt.getText();
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            ArrayList<ResultTable> list = ResultTableController.viewResultToPrint(eName, year);
            for (ResultTable resultTable : list) {
                String stId = resultTable.getStID();
                String stName = StudentController.getStNameFromId(stId);
                String resId = resultTable.getResultID();
                String date = CertificateController.getCertDate(resId);
                String certId = CertificateController.getCertId(resId);
                Object[] rows = {certId, resId, stId, stName, resultTable.getPracticalMark(), resultTable.getTheoryMark(), resultTable.getGrade(), resultTable.getStatus(), date};
                dtm.addRow(rows);

            }
            String courseName = CourseController.matchCourseForExams(eName);
            courseTxt.setText(courseName);
            String firstDate = SelectClassController.firstDate(eName, year);
            startedDateTxt.setText(firstDate);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CertificatePrintingWizard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CertificatePrintingWizard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void printCertificates() {
        try {
            JasperPrint jp = null;
            JasperReport jr = JasperCompileManager.compileReport("./src/com/ijse/sms/reports/Certificate_1.jrxml");

            for (int i = 0; i < table.getRowCount(); i++) {
                String certId = (String) table.getValueAt(i, 0);

                String name = (String) table.getValueAt(i, 3);

                String cName = courseTxt.getText();
                String firstDate = startedDateTxt.getText();
                String lastDate = endDateTxt.getText();
                String issueDate = (String) table.getValueAt(i, 8);

                // InputStream is = getClass().getResourceAsStream("PaymentReceipt3.jrxml");
                Map hm = new HashMap();
                hm.put("id", certId);
                hm.put("name", name);
                hm.put("first", firstDate);
                hm.put("last", lastDate);
                hm.put("course", cName);
                hm.put("issu", issueDate);

                jp = JasperFillManager.fillReport(jr, hm, DBConnection.getDBConnection().getConnection());
                JasperViewer.viewReport(jp, false);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl6 = new javax.swing.JLabel();
        examTxt1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        printBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        examTxt = new javax.swing.JTextField();
        endDateTxt = new javax.swing.JTextField();
        courseTxt = new javax.swing.JTextField();
        startedDateTxt = new javax.swing.JTextField();
        lbl5 = new javax.swing.JLabel();
        yearTxt = new javax.swing.JTextField();

        lbl6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl6.setText("Exam Name");

        examTxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examTxt1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Print Certificate");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        printBtn.setText("Print All");
        printBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });
        jPanel1.add(printBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 590, 160, 40));

        jButton1.setText("Cancel Without Printing");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 590, 160, 40));

        table.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Certificate Id", "Result ID", "Student ID", "Name", "Practical Mark", "Theory Mark", "Grade", "Status", "Issue Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false, false, true, true, true
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
        jScrollPane2.setViewportView(table);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 870, 370));

        lbl1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl1.setText("Exam Name");
        jPanel1.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, 27));

        lbl2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl2.setText("Started Date");
        jPanel1.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, 27));

        lbl3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl3.setText("Final Date");
        jPanel1.add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 66, 27));

        lbl4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl4.setText("Course");
        jPanel1.add(lbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 66, 27));

        examTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examTxtActionPerformed(evt);
            }
        });
        jPanel1.add(examTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 166, 27));

        endDateTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                endDateTxtKeyReleased(evt);
            }
        });
        jPanel1.add(endDateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 166, 27));
        jPanel1.add(courseTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 166, 27));
        jPanel1.add(startedDateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 166, 27));

        lbl5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl5.setText("Exam Year");
        jPanel1.add(lbl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, 27));

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
        jPanel1.add(yearTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 166, 27));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void printBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBtnActionPerformed

        printCertificates();
    }//GEN-LAST:event_printBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void examTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examTxtActionPerformed
        fillTable();
    }//GEN-LAST:event_examTxtActionPerformed

    private void yearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearTxtActionPerformed

    private void examTxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examTxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_examTxt1ActionPerformed

    private void endDateTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_endDateTxtKeyReleased
        if (endDateTxt.getText().length() == 4) {
            endDateTxt.setText(endDateTxt.getText() + "-");

        }
        if (endDateTxt.getText().length() == 7) {
            endDateTxt.setText(endDateTxt.getText() + "-");
        }
    }//GEN-LAST:event_endDateTxtKeyReleased

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
            java.util.logging.Logger.getLogger(CertificatePrintingWizard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CertificatePrintingWizard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CertificatePrintingWizard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CertificatePrintingWizard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CertificatePrintingWizard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField courseTxt;
    private javax.swing.JTextField endDateTxt;
    private javax.swing.JTextField examTxt;
    private javax.swing.JTextField examTxt1;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JButton printBtn;
    private javax.swing.JTextField startedDateTxt;
    private javax.swing.JTable table;
    private javax.swing.JTextField yearTxt;
    // End of variables declaration//GEN-END:variables
}
