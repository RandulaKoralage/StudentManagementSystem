/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.ijse.sms.controller.AttendanceController;
import com.ijse.sms.controller.SelectClassController;
import com.ijse.sms.controller.StudentController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.Attendance;
import com.ijse.sms.model.SelectClass;

/**
 *
 * @author Randula
 */
public class ModifyClasses extends javax.swing.JDialog {

    /**
     * Creates new form ManageClasses
     */
    public ModifyClasses(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void matchClassId() {
        try {
            String year = yearTxt.getText();
            
            classIdCombo.removeAllItems();   
            
            String[] array = SelectClassController.classIdOfAYear(year);
            for (String id : array) {
                classIdCombo.addItem(id);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void searchItems(){
        String classId=(String)classIdCombo.getSelectedItem();
        if(classId!=null){
        try {
           
            SelectClass selectClass=SelectClassController.searchClass(classId);
            if(selectClass!=null){
                courseIdTxt.setText(selectClass.getCourseID());
                classNameTxt.setText(selectClass.getClassName());
                classDayTxt.setText(selectClass.getClassDay());
                capacityTxt.setText(Integer.toString(selectClass.getNoOfStudents()));
                startTimeTxt.setText(Double.toString(selectClass.getStartTime()));
                endTimeTxt.setText(Double.toString(selectClass.getEndTime()));
                startDayTxt.setText(selectClass.getFirstDate());
                
            }else{
                JOptionPane.showMessageDialog(this, "Class Not Available");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModifyClasses.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModifyClasses.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
           courseIdTxt.setText(null);
                classNameTxt.setText(null);
                classDayTxt.setText(null);
                capacityTxt.setText(null);
                startTimeTxt.setText(null);
                endTimeTxt.setText(null);
                startDayTxt.setText(null);
        }
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        classdLbl1 = new javax.swing.JLabel();
        courseIdLbl1 = new javax.swing.JLabel();
        classNameLbl1 = new javax.swing.JLabel();
        dayLbl1 = new javax.swing.JLabel();
        courseIdTxt = new javax.swing.JTextField();
        classDayTxt = new javax.swing.JTextField();
        capacityTxt = new javax.swing.JTextField();
        capacityLbl1 = new javax.swing.JLabel();
        startTimeLbl1 = new javax.swing.JLabel();
        startTimeTxt = new javax.swing.JTextField();
        endTimeTxt = new javax.swing.JTextField();
        endTimeLbla1 = new javax.swing.JLabel();
        startDateLbl1 = new javax.swing.JLabel();
        startDayTxt = new javax.swing.JTextField();
        clearBtn = new javax.swing.JButton();
        editBtn1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        deleteBtn1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        classIdCombo = new javax.swing.JComboBox();
        classNameTxt = new javax.swing.JTextField();
        nameLbl1 = new javax.swing.JLabel();
        yearTxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modify Classes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        classdLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        classdLbl1.setText("Class ID");
        getContentPane().add(classdLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 70, 40));

        courseIdLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        courseIdLbl1.setText("Course ID");
        getContentPane().add(courseIdLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 60, 30));

        classNameLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        classNameLbl1.setText("Class Name");
        getContentPane().add(classNameLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 70, 30));

        dayLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dayLbl1.setText("Class Day");
        getContentPane().add(dayLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 70, 40));

        courseIdTxt.setEditable(false);
        courseIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(courseIdTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 450, 40));

        classDayTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        classDayTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                classDayTxtKeyReleased(evt);
            }
        });
        getContentPane().add(classDayTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 155, 450, 40));

        capacityTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        capacityTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                capacityTxtKeyTyped(evt);
            }
        });
        getContentPane().add(capacityTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 450, 35));

        capacityLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        capacityLbl1.setText("Capacity");
        getContentPane().add(capacityLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 60, 30));

        startTimeLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        startTimeLbl1.setText("Start Time");
        getContentPane().add(startTimeLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 70, 30));

        startTimeTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        startTimeTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                startTimeTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                startTimeTxtKeyTyped(evt);
            }
        });
        getContentPane().add(startTimeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 450, 35));

        endTimeTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        endTimeTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                endTimeTxtKeyTyped(evt);
            }
        });
        getContentPane().add(endTimeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 450, 35));

        endTimeLbla1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        endTimeLbla1.setText("End Time");
        getContentPane().add(endTimeLbla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 60, 30));

        startDateLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        startDateLbl1.setText("Started Date");
        getContentPane().add(startDateLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, -1, 35));

        startDayTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(startDayTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 450, 35));

        clearBtn.setBackground(new java.awt.Color(255, 233, 248));
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        getContentPane().add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 110, 30));

        editBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Edit.png"))); // NOI18N
        editBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtn1MouseClicked(evt);
            }
        });
        getContentPane().add(editBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, 70, 70));

        jLabel6.setText("Save Changes");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, 80, 20));

        deleteBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/Delete.png"))); // NOI18N
        deleteBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtn1MouseClicked(evt);
            }
        });
        getContentPane().add(deleteBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 70, 70));

        jLabel7.setText("Remove");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, 60, 20));

        classIdCombo.setEditable(true);
        classIdCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        classIdCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        classIdCombo.setPreferredSize(new java.awt.Dimension(2, 16));
        classIdCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                classIdComboFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                classIdComboFocusLost(evt);
            }
        });
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
        classIdCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                classIdComboKeyPressed(evt);
            }
        });
        getContentPane().add(classIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 450, 40));

        classNameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        getContentPane().add(classNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 450, 35));

        nameLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl1.setText("Academic Year");
        getContentPane().add(nameLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, 40));

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
        getContentPane().add(yearTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 450, 40));

        jButton1.setText("Previous Classes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 120, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void yearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTxtActionPerformed

    }//GEN-LAST:event_yearTxtActionPerformed

    private void yearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTxtKeyTyped
       
        if (yearTxt.getText().length() == 3) {
          classIdCombo.requestFocusInWindow();
            
        }
    }//GEN-LAST:event_yearTxtKeyTyped

    private void classIdComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_classIdComboFocusGained
      
        matchClassId();
    }//GEN-LAST:event_classIdComboFocusGained

    private void classIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classIdComboActionPerformed
       searchItems();
    }//GEN-LAST:event_classIdComboActionPerformed

    private void classIdComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classIdComboMouseClicked
         
    }//GEN-LAST:event_classIdComboMouseClicked

    private void classIdComboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_classIdComboKeyPressed
         
          
    }//GEN-LAST:event_classIdComboKeyPressed

    private void classIdComboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_classIdComboFocusLost
       
       
    }//GEN-LAST:event_classIdComboFocusLost

    private void editBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtn1MouseClicked
       int res=JOptionPane.showOptionDialog(this, "Dou you want to save changes?","Options", 0,0,null,null,null );
            if(res==0){  
        try {
            String classId=(String)classIdCombo.getSelectedItem();
            String cId=courseIdTxt.getText();
            String name=classNameTxt.getText();
            String day=classDayTxt.getText();
            int capacity=Integer.parseInt(capacityTxt.getText());
            double startTime=Double.parseDouble(startTimeTxt.getText());
            double endTime=Double.parseDouble(endTimeTxt.getText());
            String startedDate=startDayTxt.getText();
            
            SelectClass selectClass=new SelectClass(classId, cId, name, day, capacity, startTime, endTime, startedDate);
            boolean isUpdated=SelectClassController.updateClass(selectClass);
            if(isUpdated){
                JOptionPane.showMessageDialog(this, "Saved Changes");
            }else{ 
                JOptionPane.showMessageDialog(this, "Can not update Class Details");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModifyClasses.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModifyClasses.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
    }//GEN-LAST:event_editBtn1MouseClicked

    private void deleteBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtn1MouseClicked
                                         
         int res=JOptionPane.showOptionDialog(this, "Dou you want to delete this Class Detail?","Options", 0,0,null,null,null );
        if(res==0){
             String classId=(String)classIdCombo.getSelectedItem();
            
            try {
                boolean isDeleted=SelectClassController.deleteClass(classId);
                if(isDeleted){
                    JOptionPane.showMessageDialog(this, "Successfully Deleted");
                    classIdCombo.removeAllItems();
                    matchClassId();
                }else{
                    JOptionPane.showMessageDialog(this, "Try Again");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageCertificate.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ManageCertificate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteBtn1MouseClicked

    private void classDayTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_classDayTxtKeyReleased
        String name=classNameTxt.getText();
        String[] arr=name.split(" ",2);
        String second=arr[1];
        classNameTxt.setText(classDayTxt.getText()+" "+second);
        
    }//GEN-LAST:event_classDayTxtKeyReleased

    private void startTimeTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startTimeTxtKeyReleased
        String name=classNameTxt.getText();
        String[] arr = name.split(" ");    
        String first=arr[0];
        String second=arr[1];
        String third=arr[2];
       
        classNameTxt.setText(first+" "+startTimeTxt.getText()+" "+third);
    }//GEN-LAST:event_startTimeTxtKeyReleased

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        courseIdTxt.setText(null);
                classNameTxt.setText(null);
                classDayTxt.setText(null);
                capacityTxt.setText(null);
                startTimeTxt.setText(null);
                endTimeTxt.setText(null);
                startDayTxt.setText(null);
    }//GEN-LAST:event_clearBtnActionPerformed

    private void startTimeTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startTimeTxtKeyTyped
       Validation.textYear(startTimeTxt);
    }//GEN-LAST:event_startTimeTxtKeyTyped

    private void endTimeTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_endTimeTxtKeyTyped
       Validation.textYear(endTimeTxt);
    }//GEN-LAST:event_endTimeTxtKeyTyped

    private void capacityTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_capacityTxtKeyTyped
       Validation.numberOnly( capacityTxt);
    }//GEN-LAST:event_capacityTxtKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Classes().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ModifyClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModifyClasses dialog = new ModifyClasses(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel capacityLbl1;
    private javax.swing.JTextField capacityTxt;
    private javax.swing.JTextField classDayTxt;
    private javax.swing.JComboBox classIdCombo;
    private javax.swing.JLabel classNameLbl1;
    private javax.swing.JTextField classNameTxt;
    private javax.swing.JLabel classdLbl1;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel courseIdLbl1;
    private javax.swing.JTextField courseIdTxt;
    private javax.swing.JLabel dayLbl1;
    private javax.swing.JLabel deleteBtn1;
    private javax.swing.JLabel editBtn1;
    private javax.swing.JLabel endTimeLbla1;
    private javax.swing.JTextField endTimeTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel nameLbl1;
    private javax.swing.JLabel startDateLbl1;
    private javax.swing.JTextField startDayTxt;
    private javax.swing.JLabel startTimeLbl1;
    private javax.swing.JTextField startTimeTxt;
    private javax.swing.JTextField yearTxt;
    // End of variables declaration//GEN-END:variables
}
