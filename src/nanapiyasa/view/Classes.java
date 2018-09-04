/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import com.ijse.sms.controller.CourseController;
import com.ijse.sms.controller.SelectClassController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.SelectClass;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Randula
 */
public class Classes extends javax.swing.JFrame {

    /**
     * Creates new form Classes
     */
    public Classes() {
        initComponents();
        getCourseList();
    }

      private void getCourseList(){
        try {
            String array[]=CourseController.viewCourses();
             courseCombo.addItem("none");
            for(String id:array){
                courseCombo.addItem(id);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      private void arrangaTable(){
          try {
              String year=acYearTxt.getText();
              String cID=CourseController.matchId((String)courseCombo.getSelectedItem());
              
              try {
                  ArrayList<SelectClass>list=SelectClassController.classesOfACourse(cID, year);
                  DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                  dtm.setRowCount(0);
                  for(SelectClass selectClass: list){
                      Object[] rows={selectClass.getClassID(),selectClass.getClassName(),selectClass.getClassDay(),selectClass.getNoOfStudents(),selectClass.getStartTime(),selectClass.getEndTime(),selectClass.getStartTime()};
                      dtm.addRow(rows);
                  }
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(ViewPayment.class.getName()).log(Level.SEVERE, null, ex);
              } catch (SQLException ex) {
                  Logger.getLogger(ViewPayment.class.getName()).log(Level.SEVERE, null, ex);
              }
          } catch (ClassNotFoundException ex) {
            Logger.getLogger(Classes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Classes.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        yearLbl = new javax.swing.JLabel();
        acYearTxt = new javax.swing.JTextField();
        courseCombo = new javax.swing.JComboBox();
        examIdLbl1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        messageTxt = new javax.swing.JLabel();
        printBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        reloadBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Classes");

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        yearLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        yearLbl.setText("Acd Year");
        panel.add(yearLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

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
        panel.add(acYearTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 120, 40));

        courseCombo.setEditable(true);
        courseCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        courseCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        courseCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                courseComboFocusGained(evt);
            }
        });
        courseCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseComboActionPerformed(evt);
            }
        });
        courseCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                courseComboKeyPressed(evt);
            }
        });
        panel.add(courseCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 290, 40));

        examIdLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        examIdLbl1.setText("Exam ID");
        panel.add(examIdLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 60, 40));

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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Class Id", "Class Name", "Class Day", "Capacity", "Start Time", "End Time", "First Date"
            }
        ));
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
            table.getColumnModel().getColumn(3).setMinWidth(75);
            table.getColumnModel().getColumn(3).setPreferredWidth(75);
            table.getColumnModel().getColumn(3).setMaxWidth(75);
            table.getColumnModel().getColumn(5).setMinWidth(75);
            table.getColumnModel().getColumn(5).setPreferredWidth(75);
            table.getColumnModel().getColumn(5).setMaxWidth(75);
            table.getColumnModel().getColumn(6).setMinWidth(75);
            table.getColumnModel().getColumn(6).setPreferredWidth(75);
            table.getColumnModel().getColumn(6).setMaxWidth(75);
        }

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 720, 400));

        messageTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        messageTxt.setForeground(new java.awt.Color(255, 0, 0));
        messageTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel.add(messageTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 570, 50));

        printBtn.setText("Print List");
        printBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });
        panel.add(printBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 530, 180, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background2.png"))); // NOI18N
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 660, -1));

        reloadBtn.setText("Reload");
        reloadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadBtnActionPerformed(evt);
            }
        });
        panel.add(reloadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void acYearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acYearTxtActionPerformed
        if (courseCombo.getSelectedItem() != "none") {
            acYearTxt.requestFocusInWindow();
        }
    }//GEN-LAST:event_acYearTxtActionPerformed

    private void acYearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_acYearTxtKeyTyped
        Validation.textYear(acYearTxt);
        if (acYearTxt.getText().length() == 3) {
            courseCombo.requestFocusInWindow();

        }
    }//GEN-LAST:event_acYearTxtKeyTyped

    private void courseComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_courseComboFocusGained
      
        
    }//GEN-LAST:event_courseComboFocusGained

    private void courseComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseComboActionPerformed
       
        
    }//GEN-LAST:event_courseComboActionPerformed

    private void courseComboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_courseComboKeyPressed

    }//GEN-LAST:event_courseComboKeyPressed

    private void printBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBtnActionPerformed
      
    }//GEN-LAST:event_printBtnActionPerformed

    private void reloadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadBtnActionPerformed
        arrangaTable();
    }//GEN-LAST:event_reloadBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Classes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Classes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField acYearTxt;
    private javax.swing.JComboBox courseCombo;
    private javax.swing.JLabel examIdLbl1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel messageTxt;
    private javax.swing.JPanel panel;
    private javax.swing.JButton printBtn;
    private javax.swing.JButton reloadBtn;
    private javax.swing.JTable table;
    private javax.swing.JLabel yearLbl;
    // End of variables declaration//GEN-END:variables
}
