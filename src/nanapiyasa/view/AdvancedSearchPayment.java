/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import com.ijse.sms.controller.PaymentController;
import com.ijse.sms.controller.RegistrationController;
import com.ijse.sms.controller.StudentController;
import com.ijse.sms.model.Payment;
import com.ijse.sms.model.Registration;
import com.ijse.sms.model.Student;

/**
 *
 * @author Randula
 */
public class AdvancedSearchPayment extends javax.swing.JPanel {

    /**
     * Creates new form AdvancedSearch
     */
    public AdvancedSearchPayment() {
        initComponents();
        arrangeCombo();
    }
     public void arrangeCombo() {
        try {
            ArrayList<Student> studentList = StudentController.viewAllStudent();
            for (Student student : studentList) {
                stIdCombo.addItem(student.getStID());
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void searchByCategory(){
        try {
            String cat=(String)reasonCombo.getSelectedItem();
            ArrayList<Payment>paymentList=PaymentController.viewAllPayment();
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            for(Payment payment:paymentList){
                if(payment.getPaymentCategory().equals(cat)){
                   Object[] rows={payment.getPayID(),payment.getRegID(),payment.getPayment(),payment.getDiscount(),payment.getPayDate(),payment.getPaymentCategory()};
                   dtm.addRow(rows);
                }
            }    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdvancedSearchPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdvancedSearchPayment.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    public void searchByDate(){
        try {
            String date=dateTxt.getText();
            ArrayList<Payment>paymentList=PaymentController.viewAllPayment();
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            for(Payment payment:paymentList){
                if(payment.getPayDate().equals(date)){
                   Object[] rows={payment.getPayID(),payment.getRegID(),payment.getPayment(),payment.getDiscount(),payment.getPayDate(),payment.getPaymentCategory()};
                   dtm.addRow(rows);
                }
            }    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdvancedSearchPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdvancedSearchPayment.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    public void searchById(){
        try {
            String stId=(String)stIdCombo.getSelectedItem();
            
            ArrayList<Registration>registrationList=RegistrationController.viewAllRegistrationDetail();
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            for(Registration registration:registrationList){
                if(registration.getStID().equals(stId)){
                    String id=registration.getRegID();
                    ArrayList<Payment>paymentList=PaymentController.viewAllPayment();
                    

                    for(Payment payment:paymentList){
                        if(payment.getRegID().equals(id)){
                            Object[] rows={payment.getPayID(),payment.getRegID(),payment.getPayment(),payment.getDiscount(),payment.getPayDate(),payment.getPaymentCategory()};
                            dtm.addRow(rows);
                        }
                    }    
                }
            }               
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdvancedSearchPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdvancedSearchPayment.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    public void allPayments(){
        try {
            ArrayList<Payment>paymentList=PaymentController.viewAllPayment();
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            for(Payment payment: paymentList){
                Object[] rows={payment.getPayID(),payment.getRegID(),payment.getPayment(),payment.getDiscount(),payment.getPayDate(),payment.getPaymentCategory()};
		dtm.addRow(rows);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchGroup = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        modifyBtn = new javax.swing.JButton();
        durationLbl2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        reasonCombo = new javax.swing.JComboBox();
        reasonBtn = new javax.swing.JRadioButton();
        dateBtn = new javax.swing.JRadioButton();
        stIdBtn = new javax.swing.JRadioButton();
        reloadBtn1 = new javax.swing.JButton();
        stIdCombo = new javax.swing.JComboBox();
        dateTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(900, 630));
        panel.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Advanced Search Payments");
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
        modifyBtn.setBounds(470, 550, 110, 30);

        durationLbl2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        durationLbl2.setText("Reason");
        panel.add(durationLbl2);
        durationLbl2.setBounds(-420, 410, 60, 30);

        table.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Payment ID", "Reg ID", "Payment", "Discount", "Paid Date", "Reason"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
        jScrollPane1.setBounds(50, 160, 790, 350);

        reasonCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        reasonCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Course", "Exam", "Other" }));
        reasonCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reasonComboActionPerformed(evt);
            }
        });
        panel.add(reasonCombo);
        reasonCombo.setBounds(660, 80, 160, 40);

        searchGroup.add(reasonBtn);
        reasonBtn.setText("Category");
        reasonBtn.setContentAreaFilled(false);
        panel.add(reasonBtn);
        reasonBtn.setBounds(580, 80, 80, 30);

        searchGroup.add(dateBtn);
        dateBtn.setText("Date");
        dateBtn.setContentAreaFilled(false);
        panel.add(dateBtn);
        dateBtn.setBounds(320, 80, 50, 30);

        searchGroup.add(stIdBtn);
        stIdBtn.setText("Student ID");
        stIdBtn.setContentAreaFilled(false);
        panel.add(stIdBtn);
        stIdBtn.setBounds(50, 83, 80, 30);

        reloadBtn1.setBackground(new java.awt.Color(255, 233, 248));
        reloadBtn1.setText("Reload");
        reloadBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadBtn1ActionPerformed(evt);
            }
        });
        panel.add(reloadBtn1);
        reloadBtn1.setBounds(250, 550, 110, 30);

        stIdCombo.setEditable(true);
        stIdCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        stIdCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        stIdCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stIdComboActionPerformed(evt);
            }
        });
        panel.add(stIdCombo);
        stIdCombo.setBounds(130, 80, 160, 40);

        dateTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        dateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTxtActionPerformed(evt);
            }
        });
        dateTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dateTxtKeyReleased(evt);
            }
        });
        panel.add(dateTxt);
        dateTxt.setBounds(370, 80, 160, 40);

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
       ViewPayment f1=new ViewPayment();
        panel.removeAll();
        f1.setSize(panel.getSize());
        Component add = panel.add(f1);
        panel.repaint();
        panel.revalidate();
    }//GEN-LAST:event_modifyBtnActionPerformed

    private void reloadBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadBtn1ActionPerformed
        if(stIdBtn.isSelected()){           
            searchById();
        }else if(dateBtn.isSelected()){          
            searchByDate();
        }else if(reasonBtn.isSelected()){
            searchByCategory();
        }else{
            allPayments();
        }
    }//GEN-LAST:event_reloadBtn1ActionPerformed

    private void reasonComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reasonComboActionPerformed
        if(reasonBtn.isSelected()){
            searchByCategory();
        }
    }//GEN-LAST:event_reasonComboActionPerformed

    private void stIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stIdComboActionPerformed

           searchById();
    }//GEN-LAST:event_stIdComboActionPerformed

    private void dateTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateTxtKeyReleased
        if(dateTxt.getText().length()==4){
            dateTxt.setText(dateTxt.getText()+"-");

        }
        if(dateTxt.getText().length()==7){
            dateTxt.setText(dateTxt.getText()+"-");
        }
    }//GEN-LAST:event_dateTxtKeyReleased

    private void dateTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTxtActionPerformed
        searchByDate();
    }//GEN-LAST:event_dateTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton dateBtn;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JLabel durationLbl2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JPanel panel;
    private javax.swing.JRadioButton reasonBtn;
    private javax.swing.JComboBox reasonCombo;
    private javax.swing.JButton reloadBtn1;
    private javax.swing.ButtonGroup searchGroup;
    private javax.swing.JRadioButton stIdBtn;
    private javax.swing.JComboBox stIdCombo;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
