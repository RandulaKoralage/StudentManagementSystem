/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import com.ijse.sms.controller.LecturerController;
import com.ijse.sms.controller.StudentController;
import com.ijse.sms.model.Lecturer;
import com.ijse.sms.model.Student;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Randula
 */
public class AdvancedSearchStudent extends javax.swing.JPanel {

    /**
     * Creates new form AdvancedSearchStudent
     */
    public AdvancedSearchStudent() {
        initComponents();
        nameTxt.requestFocusInWindow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        modifyBtn = new javax.swing.JButton();
        durationLbl2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        reloadBtn1 = new javax.swing.JButton();
        nameTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(900, 630));
        panel.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Advanced Search Students");
        panel.add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 40);

        modifyBtn.setBackground(new java.awt.Color(255, 233, 248));
        modifyBtn.setText("Modify");
        modifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBtnActionPerformed(evt);
            }
        });
        panel.add(modifyBtn);
        modifyBtn.setBounds(470, 520, 110, 30);

        durationLbl2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        durationLbl2.setText("Reason");
        panel.add(durationLbl2);
        durationLbl2.setBounds(-420, 410, 60, 30);

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
                "St Id", "Name", "Address", "Telephone", "DOB", "Gender", "Duardiant Name", "Ocupation", "G.Telephone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, true
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

        panel.add(jScrollPane1);
        jScrollPane1.setBounds(30, 130, 810, 350);

        reloadBtn1.setBackground(new java.awt.Color(255, 233, 248));
        reloadBtn1.setText("Reload");
        reloadBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadBtn1ActionPerformed(evt);
            }
        });
        panel.add(reloadBtn1);
        reloadBtn1.setBounds(240, 520, 110, 30);

        nameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        nameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTxtActionPerformed(evt);
            }
        });
        nameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameTxtKeyTyped(evt);
            }
        });
        panel.add(nameTxt);
        nameTxt.setBounds(110, 70, 210, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background2.png"))); // NOI18N
        panel.add(jLabel1);
        jLabel1.setBounds(0, 90, 835, 520);

        nameLbl.setText("Student Name");
        panel.add(nameLbl);
        nameLbl.setBounds(30, 70, 90, 30);

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

    }//GEN-LAST:event_modifyBtnActionPerformed

    private void reloadBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadBtn1ActionPerformed

    }//GEN-LAST:event_reloadBtn1ActionPerformed

    private void nameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTxtActionPerformed

    }//GEN-LAST:event_nameTxtActionPerformed

    private void nameTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTxtKeyTyped
        try {
            ArrayList<Student> list = StudentController.viewAllStudent(nameTxt.getText());
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            for (Student student : list) {
                Object row[] = {student.getStID(), student.getStName(), student.getStAddress(), student.getStTelephone(), student.getdOB(), student.getGender(), student.getGuardName(), student.getGuardOccupation(), student.getStTelephone()};
                dtm.addRow(row);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewAllLecturers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllLecturers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nameTxtKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel durationLbl2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JPanel panel;
    private javax.swing.JButton reloadBtn1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
