/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import com.sun.glass.events.KeyEvent;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.ijse.sms.controller.CourseController;
import com.ijse.sms.controller.PaymentController;
import com.ijse.sms.controller.RegistrationController;
import com.ijse.sms.controller.StudentController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.db.DBConnection;
import com.ijse.sms.model.Course;
import com.ijse.sms.model.Payment;
import com.ijse.sms.model.Registration;
import com.ijse.sms.model.Student;
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
public class DoPayment extends javax.swing.JPanel {

    /**
     * Creates new form DoPayment
     */
    public DoPayment() {
        initComponents();
        arrangeId();
        arrangeCombo();
        //set date
        String date = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
        dateTxt.setText(date);
    }

    public void arrangeId() {
        try {
            String id = null;
            ArrayList<Payment> paymentList = PaymentController.viewAllPayment();
            for (Payment payment : paymentList) {
                id = payment.getPayID();
            }
            String last4 = id.substring(id.length() - 4);
            int idTemp = Integer.parseInt(last4) + 1;
            payIdTxt.setText("P" + idTemp);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void arrangeCombo() {
        try {
            ArrayList<Registration> registrationList = RegistrationController.viewAllRegistrationDetail();
            for (Registration registration : registrationList) {
                regIdCombo.addItem(registration.getRegID());
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    public void countPaidAmount() {
        try {
            String regId = (String) regIdCombo.getSelectedItem();
            Registration registration = RegistrationController.searchRegistrationDetail(regId);
            double regFee = registration.getRegFee();
            double count = 0.0;
            
            ArrayList<Payment> list = PaymentController.setPaidAmount(regId);
            for (Payment payment : list) {
                count += payment.getPayment();
            }
            Double paidAmount = count + regFee;
            paidAmountTxt.setText(paidAmount.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void countDueAmount() {
        try {
            String regId = (String) regIdCombo.getSelectedItem();
            
            Registration registration = RegistrationController.searchRegistrationDetail(regId);
            String cId = registration.getCourseID();
            Course course = CourseController.searchCourse(cId);
            
            double paidAmount = Double.parseDouble(paidAmountTxt.getText());
            double courseFee = course.getCourseFee();
            Double dueAmount = courseFee - paidAmount;
            
            dueAmountTxt.setText(dueAmount.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void printBill() {
        try {
            String regId = (String) regIdCombo.getSelectedItem();
            String payId = payIdTxt.getText();            
            String fee = paymentTxt.getText();            
            String date = dateTxt.getText();
            String cName = courseTxt.getText();
            String address = StudentController.getAddress(stIdTxt.getText());
            String name = nameTxt.getText();
            String id = payId.substring(1, payId.length());
            // InputStream is = getClass().getResourceAsStream("PaymentReceipt3.jrxml");
            
            JasperReport jr = JasperCompileManager.compileReport("./src/com/ijse/sms/reports/PaymentReceipt.jrxml");
            Map hm = new HashMap();
            hm.put("no", id);           
            hm.put("name", name);   
            hm.put("regId", regId);
            hm.put("address", address);
            hm.put("course", cName);
            hm.put("fee", fee);
            hm.put("date", date);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, hm, DBConnection.getDBConnection().getConnection());
            JasperViewer.viewReport(jp, false);
            
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

        reasonGroup = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        balanceTxt = new javax.swing.JTextField();
        dueAmountLbl = new javax.swing.JLabel();
        regIdLbl = new javax.swing.JLabel();
        paidAmountLbl = new javax.swing.JLabel();
        coureLbl = new javax.swing.JLabel();
        reasonLbl = new javax.swing.JLabel();
        stIdLbl = new javax.swing.JLabel();
        paymentLbl = new javax.swing.JLabel();
        cashLbl = new javax.swing.JLabel();
        balanceLbl = new javax.swing.JLabel();
        amountLbl = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        paymentTxt = new javax.swing.JTextField();
        cashTxt = new javax.swing.JTextField();
        amountTxt = new javax.swing.JTextField();
        dueAmountTxt = new javax.swing.JTextField();
        paidAmountTxt = new javax.swing.JTextField();
        courseTxt = new javax.swing.JTextField();
        stIdTxt = new javax.swing.JTextField();
        clearBtn = new javax.swing.JButton();
        payIdLbl = new javax.swing.JLabel();
        payIdTxt = new javax.swing.JTextField();
        courseBtn = new javax.swing.JRadioButton();
        examBtn = new javax.swing.JRadioButton();
        otherBtn = new javax.swing.JRadioButton();
        saveBtn = new javax.swing.JButton();
        discountLbl = new javax.swing.JLabel();
        discountTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        nameLbl1 = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        dateTxt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        regIdCombo = new javax.swing.JComboBox();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(900, 630));
        jPanel3.setLayout(null);

        balanceTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel3.add(balanceTxt);
        balanceTxt.setBounds(270, 510, 470, 35);

        dueAmountLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dueAmountLbl.setText("Due Amount");
        jPanel3.add(dueAmountLbl);
        dueAmountLbl.setBounds(180, 260, 90, 30);

        regIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        regIdLbl.setText("Registration ID");
        jPanel3.add(regIdLbl);
        regIdLbl.setBounds(180, 50, 90, 30);

        paidAmountLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        paidAmountLbl.setText("Paid Amount");
        jPanel3.add(paidAmountLbl);
        paidAmountLbl.setBounds(180, 220, 90, 30);

        coureLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        coureLbl.setText("Course");
        jPanel3.add(coureLbl);
        coureLbl.setBounds(180, 170, 90, 35);

        reasonLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        reasonLbl.setText("Reason");
        jPanel3.add(reasonLbl);
        reasonLbl.setBounds(180, 310, 90, 35);

        stIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        stIdLbl.setText("Student ID");
        jPanel3.add(stIdLbl);
        stIdLbl.setBounds(180, 90, 90, 30);

        paymentLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        paymentLbl.setText("Payment");
        jPanel3.add(paymentLbl);
        paymentLbl.setBounds(180, 470, 90, 35);

        cashLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cashLbl.setText("Cash");
        jPanel3.add(cashLbl);
        cashLbl.setBounds(180, 350, 90, 30);

        balanceLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        balanceLbl.setText("Balance");
        jPanel3.add(balanceLbl);
        balanceLbl.setBounds(180, 510, 90, 30);

        amountLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        amountLbl.setText("Amount");
        jPanel3.add(amountLbl);
        amountLbl.setBounds(180, 390, 90, 30);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Payments");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(0, 0, 900, 40);

        paymentTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        paymentTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentTxtActionPerformed(evt);
            }
        });
        jPanel3.add(paymentTxt);
        paymentTxt.setBounds(270, 470, 470, 35);

        cashTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        cashTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashTxtActionPerformed(evt);
            }
        });
        cashTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cashTxtKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cashTxtKeyTyped(evt);
            }
        });
        jPanel3.add(cashTxt);
        cashTxt.setBounds(270, 350, 470, 35);

        amountTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        amountTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountTxtActionPerformed(evt);
            }
        });
        amountTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amountTxtKeyTyped(evt);
            }
        });
        jPanel3.add(amountTxt);
        amountTxt.setBounds(270, 390, 470, 35);

        dueAmountTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel3.add(dueAmountTxt);
        dueAmountTxt.setBounds(270, 260, 470, 35);

        paidAmountTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel3.add(paidAmountTxt);
        paidAmountTxt.setBounds(270, 220, 470, 35);

        courseTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel3.add(courseTxt);
        courseTxt.setBounds(270, 170, 470, 35);

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

        payIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        payIdLbl.setText("Payment ID");
        jPanel3.add(payIdLbl);
        payIdLbl.setBounds(480, 50, 70, 30);

        payIdTxt.setText(" ");
        payIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel3.add(payIdTxt);
        payIdTxt.setBounds(550, 50, 190, 35);

        reasonGroup.add(courseBtn);
        courseBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        courseBtn.setText("Course Instalment");
        courseBtn.setContentAreaFilled(false);
        courseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseBtnActionPerformed(evt);
            }
        });
        courseBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                courseBtnKeyPressed(evt);
            }
        });
        jPanel3.add(courseBtn);
        courseBtn.setBounds(270, 320, 130, 25);

        reasonGroup.add(examBtn);
        examBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        examBtn.setText("Examination Fee");
        examBtn.setContentAreaFilled(false);
        examBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examBtnActionPerformed(evt);
            }
        });
        examBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                examBtnKeyPressed(evt);
            }
        });
        jPanel3.add(examBtn);
        examBtn.setBounds(470, 320, 140, 25);

        reasonGroup.add(otherBtn);
        otherBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        otherBtn.setText("Other");
        otherBtn.setContentAreaFilled(false);
        otherBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherBtnActionPerformed(evt);
            }
        });
        otherBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                otherBtnKeyPressed(evt);
            }
        });
        jPanel3.add(otherBtn);
        otherBtn.setBounds(680, 320, 60, 23);

        saveBtn.setBackground(new java.awt.Color(255, 233, 248));
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        jPanel3.add(saveBtn);
        saveBtn.setBounds(350, 560, 110, 30);

        discountLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        discountLbl.setText("Discount");
        jPanel3.add(discountLbl);
        discountLbl.setBounds(180, 430, 90, 35);

        discountTxt.setText("0");
        discountTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        discountTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountTxtActionPerformed(evt);
            }
        });
        jPanel3.add(discountTxt);
        discountTxt.setBounds(270, 430, 470, 35);

        nameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel3.add(nameTxt);
        nameTxt.setBounds(270, 130, 470, 35);

        nameLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl1.setText("Name");
        jPanel3.add(nameLbl1);
        nameLbl1.setBounds(180, 130, 90, 35);

        dateLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dateLbl.setText("Date");
        jPanel3.add(dateLbl);
        dateLbl.setBounds(480, 90, 50, 30);

        dateTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel3.add(dateTxt);
        dateTxt.setBounds(550, 90, 190, 35);

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
        
        String id = (String) regIdCombo.getSelectedItem();
        if (id != "none") {
            try {
                Registration registration = RegistrationController.searchRegistrationDetail(id);
                String cId = registration.getCourseID();
                Course course = CourseController.searchCourse(cId);
                String sId = registration.getStID();
                Student student = StudentController.searchStudent(sId);
                
                stIdTxt.setText(registration.getStID());
                courseTxt.setText(course.getCourseName());
                nameTxt.setText(student.getStName());
                
                countPaidAmount();
                countDueAmount();
                courseBtn.requestFocusInWindow();
                courseBtn.setSelected(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            courseTxt.setText(null);
            stIdTxt.setText(null);
            nameTxt.setText(null);            
            regIdCombo.removeAllItems();
            regIdCombo.addItem("none");
            arrangeCombo();
        }
    }//GEN-LAST:event_regIdComboActionPerformed

    private void cashTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashTxtActionPerformed
        amountTxt.requestFocusInWindow();
    }//GEN-LAST:event_cashTxtActionPerformed

    private void amountTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountTxtActionPerformed
        discountTxt.requestFocusInWindow();
    }//GEN-LAST:event_amountTxtActionPerformed

    private void discountTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountTxtActionPerformed
        paymentTxt.requestFocusInWindow();
        double givenAmount = Double.parseDouble(cashTxt.getText());
        double amountToPay = Double.parseDouble(amountTxt.getText());
        double discountAmount = Double.parseDouble(discountTxt.getText());
        Double finalPayment = (amountToPay - discountAmount);
        Double balance = givenAmount - finalPayment;
        
        paymentTxt.setText(finalPayment.toString());
        balanceTxt.setText(balance.toString());        
    }//GEN-LAST:event_discountTxtActionPerformed

    private void paymentTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentTxtActionPerformed
        balanceTxt.requestFocusInWindow();
        
    }//GEN-LAST:event_paymentTxtActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            String regId = (String) regIdCombo.getSelectedItem();
            String payId = payIdTxt.getText();
            double paidAmount = Double.parseDouble(paymentTxt.getText());
            double discount = Double.parseDouble(discountTxt.getText());
            String date = dateTxt.getText();
            String reason = "Course";
            if (examBtn.isSelected()) {
                reason = "Exam";
            } else if (otherBtn.isSelected()) {
                reason = "Other";
            }
            Payment payment = new Payment(payId, regId, paidAmount, discount, date, reason);
            boolean isAdded = PaymentController.addPayment(payment);
            if (isAdded) {
                JOptionPane.showMessageDialog(this, "Successfully Saved");
                printBill();
            } else {
                JOptionPane.showMessageDialog(this, "Saving Faild");
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
        dueAmountTxt.setText(null);
        cashTxt.setText(null);
        amountTxt.setText(null);
        discountTxt.setText(null);
        paymentTxt.setText(null);
        balanceTxt.setText(null);
        
        regIdCombo.setSelectedItem("none");
        
    }//GEN-LAST:event_clearBtnActionPerformed

    private void courseBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_courseBtnKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_RIGHT){
           examBtn.requestFocusInWindow();
           examBtn.setSelected(true);
       }
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           cashTxt.requestFocusInWindow();
       }
    }//GEN-LAST:event_courseBtnKeyPressed

    private void examBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_examBtnKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_RIGHT){
           otherBtn.requestFocusInWindow();
           otherBtn.setSelected(true);
       }
        if(evt.getKeyCode()==KeyEvent.VK_LEFT){
           courseBtn.requestFocusInWindow();
           courseBtn.setSelected(true);
       }
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           cashTxt.requestFocusInWindow();
       }
    }//GEN-LAST:event_examBtnKeyPressed

    private void otherBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_otherBtnKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_LEFT){
           examBtn.requestFocusInWindow();
           examBtn.setSelected(true);
       }
          if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           cashTxt.requestFocusInWindow();
       }
    }//GEN-LAST:event_otherBtnKeyPressed

    private void courseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseBtnActionPerformed
        
    }//GEN-LAST:event_courseBtnActionPerformed

    private void examBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examBtnActionPerformed
     
    }//GEN-LAST:event_examBtnActionPerformed

    private void otherBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherBtnActionPerformed
      
    }//GEN-LAST:event_otherBtnActionPerformed

    private void cashTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashTxtKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_UP){
           courseBtn.requestFocusInWindow();
           courseBtn.setSelected(true);
       }
    }//GEN-LAST:event_cashTxtKeyPressed

    private void cashTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashTxtKeyTyped
       Validation.priceText(cashTxt);
    }//GEN-LAST:event_cashTxtKeyTyped

    private void amountTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountTxtKeyTyped
        Validation.priceText(amountTxt);
    }//GEN-LAST:event_amountTxtKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountLbl;
    private javax.swing.JTextField amountTxt;
    private javax.swing.JLabel balanceLbl;
    private javax.swing.JTextField balanceTxt;
    private javax.swing.JLabel cashLbl;
    private javax.swing.JTextField cashTxt;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel coureLbl;
    private javax.swing.JRadioButton courseBtn;
    private javax.swing.JTextField courseTxt;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JLabel discountLbl;
    private javax.swing.JTextField discountTxt;
    private javax.swing.JLabel dueAmountLbl;
    private javax.swing.JTextField dueAmountTxt;
    private javax.swing.JRadioButton examBtn;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel nameLbl1;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JRadioButton otherBtn;
    private javax.swing.JLabel paidAmountLbl;
    private javax.swing.JTextField paidAmountTxt;
    private javax.swing.JLabel payIdLbl;
    private javax.swing.JTextField payIdTxt;
    private javax.swing.JLabel paymentLbl;
    private javax.swing.JTextField paymentTxt;
    private javax.swing.ButtonGroup reasonGroup;
    private javax.swing.JLabel reasonLbl;
    private javax.swing.JComboBox regIdCombo;
    private javax.swing.JLabel regIdLbl;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel stIdLbl;
    private javax.swing.JTextField stIdTxt;
    // End of variables declaration//GEN-END:variables
}
