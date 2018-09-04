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
import javax.swing.table.DefaultTableModel;
import com.ijse.sms.controller.CourseController;
import com.ijse.sms.controller.ExaminationController;
import com.ijse.sms.controller.ResultTableController;
import com.ijse.sms.controller.StudentController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.ResultTable;
import javax.swing.JOptionPane;

/**
 *
 * @author Randula
 */
public class ViewAllResult extends javax.swing.JPanel {

    /**
     * Creates new form ViewAllResult
     */
    public ViewAllResult() {
        initComponents();
    }

    private void getExamList() {
        try {
            String year = yearTxt.getText();

            examCombo.removeAllItems();
            examCombo.addItem("none");
            String[] array = ExaminationController.examNameOfAYear(year);
            for (String id : array) {
                examCombo.addItem(id);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void passToFrame() {
        try {
            String eName = (String) examCombo.getSelectedItem();
            String year = yearTxt.getText();
            String cName = CourseController.matchCourseForExams(eName);
            new CertificatePrintingWizard(eName, year, cName).setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewAllResult.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllResult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        printCertificates = new javax.swing.JButton();
        durationLbl2 = new javax.swing.JLabel();
        modifyBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        stIdLbl = new javax.swing.JLabel();
        yearTxt = new javax.swing.JTextField();
        examLbl = new javax.swing.JLabel();
        examCombo = new javax.swing.JComboBox();
        eIdTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(900, 630));
        panel.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("View All Result");
        panel.add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 50);

        printCertificates.setBackground(new java.awt.Color(255, 233, 248));
        printCertificates.setText("Issue Certificates");
        printCertificates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printCertificatesActionPerformed(evt);
            }
        });
        panel.add(printCertificates);
        printCertificates.setBounds(240, 550, 140, 30);

        durationLbl2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        durationLbl2.setText("Reason");
        panel.add(durationLbl2);
        durationLbl2.setBounds(-420, 410, 60, 30);

        modifyBtn.setBackground(new java.awt.Color(255, 233, 248));
        modifyBtn.setText("Modify");
        modifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBtnActionPerformed(evt);
            }
        });
        panel.add(modifyBtn);
        modifyBtn.setBounds(490, 550, 140, 30);

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
                "Result ID", "Student ID", "Name", "Practical Mark", "Theory Mark", "Grade", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true, true
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
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(100);
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(0).setMaxWidth(100);
            table.getColumnModel().getColumn(1).setMinWidth(100);
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(1).setMaxWidth(100);
            table.getColumnModel().getColumn(2).setMinWidth(250);
            table.getColumnModel().getColumn(2).setPreferredWidth(250);
            table.getColumnModel().getColumn(2).setMaxWidth(250);
            table.getColumnModel().getColumn(3).setMinWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setMaxWidth(100);
            table.getColumnModel().getColumn(4).setMinWidth(100);
            table.getColumnModel().getColumn(4).setPreferredWidth(100);
            table.getColumnModel().getColumn(4).setMaxWidth(100);
            table.getColumnModel().getColumn(5).setPreferredWidth(75);
            table.getColumnModel().getColumn(6).setMinWidth(75);
            table.getColumnModel().getColumn(6).setPreferredWidth(75);
            table.getColumnModel().getColumn(6).setMaxWidth(75);
        }

        panel.add(jScrollPane2);
        jScrollPane2.setBounds(40, 190, 810, 350);

        stIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        stIdLbl.setText("Exam Year");
        panel.add(stIdLbl);
        stIdLbl.setBounds(70, 80, 80, 30);

        yearTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        yearTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                yearTxtKeyTyped(evt);
            }
        });
        panel.add(yearTxt);
        yearTxt.setBounds(140, 80, 180, 35);

        examLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        examLbl.setText("Exam Name");
        panel.add(examLbl);
        examLbl.setBounds(70, 130, 70, 40);

        examCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        examCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                examComboFocusGained(evt);
            }
        });
        examCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examComboActionPerformed(evt);
            }
        });
        panel.add(examCombo);
        examCombo.setBounds(140, 130, 180, 40);

        eIdTxt.setEditable(false);
        eIdTxt.setBackground(new java.awt.Color(255, 255, 255));
        eIdTxt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        eIdTxt.setBorder(null);
        panel.add(eIdTxt);
        eIdTxt.setBounds(730, 70, 110, 50);

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

    private void modifyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyBtnActionPerformed
        new ModifyMarks(null, true).setVisible(true);
    }//GEN-LAST:event_modifyBtnActionPerformed

    private void yearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTxtKeyTyped
        Validation.textYear(yearTxt);
        if (yearTxt.getText().length() == 3) {
            examCombo.requestFocusInWindow();

        }
    }//GEN-LAST:event_yearTxtKeyTyped

    private void examComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_examComboFocusGained
        getExamList();
    }//GEN-LAST:event_examComboFocusGained

    private void examComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examComboActionPerformed
        if (examCombo.getSelectedItem() != "none") {
            eIdTxt.setText(null);
            try {
                String eName = (String) examCombo.getSelectedItem();
                String year=yearTxt.getText();
                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                dtm.setRowCount(0);
                ArrayList<ResultTable> list = ResultTableController.viewAllResultsOfAnExam(eName,year);
                for (ResultTable resultTable : list) {
                    String stId = resultTable.getStID();
                    eIdTxt.setText(resultTable.getExamID());
                    String stName = StudentController.getStNameFromId(stId);
                    Object[] rows = {resultTable.getResultID(), stId, stName, resultTable.getPracticalMark(), resultTable.getTheoryMark(), resultTable.getGrade(), resultTable.getStatus()};
                    dtm.addRow(rows);

                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ViewAllResult.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ViewAllResult.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            eIdTxt.setText(null);
        }
    }//GEN-LAST:event_examComboActionPerformed

    private void printCertificatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printCertificatesActionPerformed
        if (table.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Please Select Exam");
        } else {
            passToFrame();
        }
    }//GEN-LAST:event_printCertificatesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel durationLbl2;
    private javax.swing.JTextField eIdTxt;
    private javax.swing.JComboBox examCombo;
    private javax.swing.JLabel examLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JPanel panel;
    private javax.swing.JButton printCertificates;
    private javax.swing.JLabel stIdLbl;
    private javax.swing.JTable table;
    private javax.swing.JTextField yearTxt;
    // End of variables declaration//GEN-END:variables
}
