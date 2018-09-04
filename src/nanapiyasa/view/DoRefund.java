/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.ijse.sms.controller.CourseController;
import com.ijse.sms.controller.PaymentController;
import com.ijse.sms.controller.RefundController;
import com.ijse.sms.controller.RegistrationController;
import com.ijse.sms.controller.StudentController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.Course;
import com.ijse.sms.model.Payment;
import com.ijse.sms.model.Refund;
import com.ijse.sms.model.Registration;
import com.ijse.sms.model.Student;

/**
 *
 * @author Randula
 */
public class DoRefund extends javax.swing.JPanel {

    /**
     * Creates new form DoRefund
     */
    public DoRefund() {
        initComponents();
        arrangeId();
        arrangeCombo();
        String date=new SimpleDateFormat("YYYY-MM-dd").format(new Date());
        dateTxt.setText(date);
    }
     public void arrangeId(){
        try {
            String id=null;
            ArrayList<Refund>refundList=RefundController.viewAllRefund();
            for(Refund refund:refundList){
                id=refund.getRefID();
            }
            String last4 = id.substring(id.length() - 4);
            int idTemp=Integer.parseInt(last4)+1;
            refIdTxt.setText("R"+idTemp);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void arrangeCombo(){
        try {
            ArrayList<Registration>registrationList=RegistrationController.viewAllRegistrationDetail();
            for(Registration registration:registrationList){
                  regIdCombo.addItem(registration.getRegID());
            }
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    public void countPaidAmount(){
        try {
        String regId=(String)regIdCombo.getSelectedItem();
        Registration registration =RegistrationController.searchRegistrationDetail(regId);
        double regFee=registration.getRegFee();
        double count=0.0;
     
            ArrayList<Payment>list=PaymentController.setPaidAmount(regId);
            for(Payment payment:list){
                count+=payment.getPayment();
            }
            Double paidAmount=count+regFee;
            paidAmountTxt.setText(paidAmount.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        deductionLbl = new javax.swing.JLabel();
        regIdLbl = new javax.swing.JLabel();
        paidAmountLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        stIdLbl = new javax.swing.JLabel();
        refundAmountLbl = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        refundAmountTxt = new javax.swing.JTextField();
        dateTxt = new javax.swing.JTextField();
        deductionTxt = new javax.swing.JTextField();
        paidAmountTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        stIdTxt = new javax.swing.JTextField();
        clearBtn = new javax.swing.JButton();
        refIdLbl = new javax.swing.JLabel();
        refIdTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        reasonLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reasonTxt = new javax.swing.JTextArea();
        coureLbl = new javax.swing.JLabel();
        courseTxt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        regIdCombo = new javax.swing.JComboBox();
        regIdCombo1 = new javax.swing.JComboBox();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(900, 630));
        jPanel3.setLayout(null);

        deductionLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        deductionLbl.setText("Deduction");
        jPanel3.add(deductionLbl);
        deductionLbl.setBounds(180, 280, 90, 30);

        regIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        regIdLbl.setText("Registration ID");
        jPanel3.add(regIdLbl);
        regIdLbl.setBounds(180, 50, 90, 30);

        paidAmountLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        paidAmountLbl.setText("Paid Amount");
        jPanel3.add(paidAmountLbl);
        paidAmountLbl.setBounds(180, 210, 90, 30);

        nameLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl.setText("Name");
        jPanel3.add(nameLbl);
        nameLbl.setBounds(180, 130, 90, 35);

        stIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        stIdLbl.setText("Student ID");
        jPanel3.add(stIdLbl);
        stIdLbl.setBounds(180, 90, 90, 30);

        refundAmountLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        refundAmountLbl.setText("Refund Amount");
        jPanel3.add(refundAmountLbl);
        refundAmountLbl.setBounds(180, 320, 90, 30);

        dateLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dateLbl.setText("Date");
        jPanel3.add(dateLbl);
        dateLbl.setBounds(180, 390, 90, 30);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Refunds");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(0, 0, 900, 40);

        refundAmountTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel3.add(refundAmountTxt);
        refundAmountTxt.setBounds(270, 320, 470, 35);

        dateTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel3.add(dateTxt);
        dateTxt.setBounds(270, 390, 470, 35);

        deductionTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        deductionTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deductionTxtActionPerformed(evt);
            }
        });
        deductionTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                deductionTxtKeyTyped(evt);
            }
        });
        jPanel3.add(deductionTxt);
        deductionTxt.setBounds(270, 280, 470, 35);

        paidAmountTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel3.add(paidAmountTxt);
        paidAmountTxt.setBounds(270, 210, 470, 35);

        nameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel3.add(nameTxt);
        nameTxt.setBounds(270, 130, 470, 35);

        stIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel3.add(stIdTxt);
        stIdTxt.setBounds(270, 90, 190, 35);

        clearBtn.setBackground(new java.awt.Color(255, 233, 248));
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        jPanel3.add(clearBtn);
        clearBtn.setBounds(540, 560, 110, 30);

        refIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        refIdLbl.setText("Refund ID");
        jPanel3.add(refIdLbl);
        refIdLbl.setBounds(480, 50, 70, 30);

        refIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel3.add(refIdTxt);
        refIdTxt.setBounds(550, 50, 190, 35);

        saveBtn.setBackground(new java.awt.Color(255, 233, 248));
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        jPanel3.add(saveBtn);
        saveBtn.setBounds(350, 560, 110, 30);

        reasonLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        reasonLbl.setText("Reason");
        jPanel3.add(reasonLbl);
        reasonLbl.setBounds(180, 460, 90, 35);

        reasonTxt.setColumns(20);
        reasonTxt.setRows(5);
        reasonTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jScrollPane1.setViewportView(reasonTxt);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(270, 440, 470, 94);

        coureLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        coureLbl.setText("Course");
        jPanel3.add(coureLbl);
        coureLbl.setBounds(180, 170, 90, 35);

        courseTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel3.add(courseTxt);
        courseTxt.setBounds(270, 170, 470, 35);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background2.png"))); // NOI18N
        jPanel3.add(jLabel16);
        jLabel16.setBounds(0, 90, 835, 520);

        regIdCombo.setEditable(true);
        regIdCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        regIdCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regIdComboActionPerformed(evt);
            }
        });
        jPanel3.add(regIdCombo);
        regIdCombo.setBounds(270, 50, 190, 30);

        regIdCombo1.setEditable(true);
        regIdCombo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        regIdCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regIdCombo1ActionPerformed(evt);
            }
        });
        jPanel3.add(regIdCombo1);
        regIdCombo1.setBounds(270, 50, 190, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void regIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regIdComboActionPerformed

        String id= (String)regIdCombo.getSelectedItem();
        if(id!="none"){
            try {
                Registration registration=RegistrationController.searchRegistrationDetail(id);
                String cId=registration.getCourseID();
                Course course=CourseController.searchCourse(cId);
                String sId=registration.getStID();
                Student student=StudentController.searchStudent(sId);

                stIdTxt.setText(registration.getStID());
                courseTxt.setText(course.getCourseName());
                nameTxt.setText(student.getStName());

                countPaidAmount();
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            courseTxt.setText(null);
            stIdTxt.setText(null);
            nameTxt.setText(null);
            regIdCombo.removeAllItems();
            regIdCombo.addItem("none");
            arrangeCombo();
        }
    }//GEN-LAST:event_regIdComboActionPerformed

    private void regIdCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regIdCombo1ActionPerformed

        String id= (String)regIdCombo.getSelectedItem();
        if(id!="none"){
            try {
                Registration registration=RegistrationController.searchRegistrationDetail(id);
                String cId=registration.getCourseID();
                Course course=CourseController.searchCourse(cId);
                String sId=registration.getStID();
                Student student=StudentController.searchStudent(sId);

                stIdTxt.setText(registration.getStID());
                courseTxt.setText(course.getCourseName());
                nameTxt.setText(student.getStName());

                countPaidAmount();
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            courseTxt.setText(null);
            stIdTxt.setText(null);
            nameTxt.setText(null);
            regIdCombo.removeAllItems();
            regIdCombo.addItem("none");
            arrangeCombo();
        }
    }//GEN-LAST:event_regIdCombo1ActionPerformed

    private void deductionTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deductionTxtActionPerformed
        refundAmountTxt.requestFocusInWindow();
        double deduction=Double.parseDouble(deductionTxt.getText());
        double paidAmount=Double.parseDouble(paidAmountTxt.getText());
        Double refundAmount=paidAmount-deduction;
        refundAmountTxt.setText(refundAmount.toString());
    }//GEN-LAST:event_deductionTxtActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
          try {
            String regId=(String)regIdCombo.getSelectedItem();
            String refId=refIdTxt.getText();
            double paidAmount=Double.parseDouble(paidAmountTxt.getText());
            double deduction=Double.parseDouble(deductionTxt.getText());
            double refundAmount=Double.parseDouble(refundAmountTxt.getText());
            String date=dateTxt.getText();
            String reason=reasonTxt.getText();
            Refund refund=new Refund(refId, regId,paidAmount,refundAmount, deduction,date,reason);
            boolean isAdded=RefundController.addRefund(refund);
            if(isAdded){
                JOptionPane.showMessageDialog(this,"Successfully Saved");
            }else{
                 JOptionPane.showMessageDialog(this,"Saving Faild");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        stIdTxt.setText(null);
        courseTxt.setText(null);
        nameTxt.setText(null);
        paidAmountTxt.setText(null);
        deductionTxt.setText(null);
        refundAmountTxt.setText(null);
        reasonTxt.setText(null);
        
        regIdCombo.setSelectedItem("none");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void deductionTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deductionTxtKeyTyped
       Validation.priceText(deductionTxt);
    }//GEN-LAST:event_deductionTxtKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel coureLbl;
    private javax.swing.JTextField courseTxt;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JLabel deductionLbl;
    private javax.swing.JTextField deductionTxt;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JLabel paidAmountLbl;
    private javax.swing.JTextField paidAmountTxt;
    private javax.swing.JLabel reasonLbl;
    private javax.swing.JTextArea reasonTxt;
    private javax.swing.JLabel refIdLbl;
    private javax.swing.JTextField refIdTxt;
    private javax.swing.JLabel refundAmountLbl;
    private javax.swing.JTextField refundAmountTxt;
    private javax.swing.JComboBox regIdCombo;
    private javax.swing.JComboBox regIdCombo1;
    private javax.swing.JLabel regIdLbl;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel stIdLbl;
    private javax.swing.JTextField stIdTxt;
    // End of variables declaration//GEN-END:variables
}
