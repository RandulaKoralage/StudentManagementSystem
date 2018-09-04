/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import com.ijse.sms.controller.AlertController;
import com.ijse.sms.controller.CourseController;
import com.ijse.sms.controller.RegistrationController;
import com.ijse.sms.controller.SelectClassController;
import com.ijse.sms.controller.StudentController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.ClassAlert;
import com.ijse.sms.model.Registration;
import com.ijse.sms.model.SelectClass;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Randula
 */
public class ClassAlerts extends javax.swing.JFrame {

    /**
     * Creates new form ClassAlerts
     */
    public ClassAlerts() {
        initComponents();
    }
    
    private void arrangeRegistrationsTable() {
        
        try {
            
            String acYear = acYearTxt.getText();
            
            ArrayList<ClassAlert> list = AlertController.registrations(acYear);
            DefaultTableModel dtm = (DefaultTableModel) table2.getModel();
            dtm.setRowCount(0);
            for (ClassAlert classAlert : list) {
                
                Object[] row = {classAlert.getCourseDetail(), classAlert.getTot()};
                dtm.addRow(row);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewAllExaminations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllExaminations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void arrangeAllTable() {
        
        try {
            
            String acYear = acYearTxt.getText();
            
            ArrayList<SelectClass> list = SelectClassController.allClasses(acYear);
            DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
            dtm.setRowCount(0);
            for (SelectClass selectClass : list) {
                
                Object[] row = {selectClass.getClassName(), selectClass.getNoOfStudents()};
                dtm.addRow(row);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewAllExaminations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllExaminations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void arrangeAllInCourseTable() {
        
        try {
            
            String acYear = acYearTxt.getText();
            
            ArrayList<ClassAlert> list = AlertController.allClasses(acYear);
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            for (ClassAlert classAlert : list) {
                String cId = classAlert.getCourseId();
                String cName = CourseController.matchName(cId);
                Object[] row = {cName, classAlert.getCourseRegs()};
                dtm.addRow(row);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewAllExaminations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllExaminations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lbl2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        lbl1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        lbl3 = new javax.swing.JLabel();
        acYearTxt = new javax.swing.JTextField();
        yearLbl1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Class States");

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl2.setForeground(new java.awt.Color(255, 51, 0));
        lbl2.setText("Regisrations For Courses");
        panel.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 200, 40));

        table.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Course", "Registrations"
            }
        ));
        table.setFillsViewportHeight(true);
        table.setGridColor(new java.awt.Color(204, 0, 0));
        table.setRowHeight(20);
        table.setSelectionBackground(new java.awt.Color(255, 204, 153));
        table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(300);
            table.getColumnModel().getColumn(0).setPreferredWidth(300);
            table.getColumnModel().getColumn(0).setMaxWidth(300);
            table.getColumnModel().getColumn(1).setMinWidth(100);
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 400, 180));

        table1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Class Name", "Capacity"
            }
        ));
        table1.setFillsViewportHeight(true);
        table1.setGridColor(new java.awt.Color(204, 0, 0));
        table1.setRowHeight(20);
        table1.setSelectionBackground(new java.awt.Color(255, 204, 153));
        table1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setMinWidth(300);
            table1.getColumnModel().getColumn(0).setPreferredWidth(300);
            table1.getColumnModel().getColumn(0).setMaxWidth(300);
            table1.getColumnModel().getColumn(1).setMinWidth(100);
            table1.getColumnModel().getColumn(1).setPreferredWidth(100);
            table1.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        panel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 400, 250));

        lbl1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 51, 0));
        lbl1.setText("Classes Of This Year");
        panel.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 170, 40));

        table2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Class Name", "Registrations"
            }
        ));
        table2.setFillsViewportHeight(true);
        table2.setGridColor(new java.awt.Color(204, 0, 0));
        table2.setRowHeight(20);
        table2.setSelectionBackground(new java.awt.Color(255, 204, 153));
        table2.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(0).setMinWidth(300);
            table2.getColumnModel().getColumn(0).setPreferredWidth(300);
            table2.getColumnModel().getColumn(0).setMaxWidth(300);
            table2.getColumnModel().getColumn(1).setMinWidth(100);
            table2.getColumnModel().getColumn(1).setPreferredWidth(100);
            table2.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        panel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 400, 240));

        lbl3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl3.setForeground(new java.awt.Color(255, 51, 0));
        lbl3.setText("Registrations For Classes");
        panel.add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 200, 40));

        acYearTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
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
        panel.add(acYearTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 120, 40));

        yearLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        yearLbl1.setText("Acedemic  Year");
        panel.add(yearLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background2.png"))); // NOI18N
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 660, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void acYearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acYearTxtActionPerformed
        arrangeRegistrationsTable();
        arrangeAllTable();
        arrangeAllInCourseTable();
    }//GEN-LAST:event_acYearTxtActionPerformed

    private void acYearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_acYearTxtKeyTyped
        Validation.textYear(acYearTxt);
        if (acYearTxt.getText().length() == 3) {
            
        }
    }//GEN-LAST:event_acYearTxtKeyTyped

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
            java.util.logging.Logger.getLogger(ClassAlerts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassAlerts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassAlerts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassAlerts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassAlerts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField acYearTxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JPanel panel;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JLabel yearLbl1;
    // End of variables declaration//GEN-END:variables
}
