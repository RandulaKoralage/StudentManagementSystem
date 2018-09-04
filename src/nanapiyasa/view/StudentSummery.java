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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.ijse.sms.controller.AttendanceController;
import com.ijse.sms.controller.CertificateController;
import com.ijse.sms.controller.CourseController;
import com.ijse.sms.controller.ExaminationController;
import com.ijse.sms.controller.PaymentController;
import com.ijse.sms.controller.RegistrationController;
import com.ijse.sms.controller.ResultTableController;
import com.ijse.sms.controller.SelectClassController;
import com.ijse.sms.controller.StudentController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.db.DBConnection;
import com.ijse.sms.model.Certificate;
import com.ijse.sms.model.Course;
import com.ijse.sms.model.Examination;
import com.ijse.sms.model.Payment;
import com.ijse.sms.model.Registration;
import com.ijse.sms.model.ResultTable;
import com.ijse.sms.model.Student;
import com.sun.org.apache.xml.internal.dtm.DTM;
import java.io.InputStream;
import java.util.HashMap;
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
public class StudentSummery extends javax.swing.JPanel {

    /**
     * Creates new form AdvancedSearchExam
     */
    public StudentSummery() {
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

    private void getRegistrationDetails() {

        try {
            String stId = (String) stIdCombo.getSelectedItem();
            ArrayList<Registration> list = RegistrationController.viewAllRegistrationDetail(stId);
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            for (Registration registration : list) {

                String courseId = registration.getCourseID();
                String cName = CourseController.matchName(courseId);
                Object[] row = {registration.getRegID(), cName, registration.getClassDetail(), registration.getRegDate()};
                dtm.addRow(row);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentSummery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentSummery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void buildExamCombo(String regId) {
        try {
            examCombo.removeAllItems();
            String[] array = ExaminationController.examNameOfAStudent(regId);
            for (String s : array) {
                examCombo.addItem(s);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentSummery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentSummery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getResultDetails() {
        try {
            String eName = (String) examCombo.getSelectedItem();
            String eId = ExaminationController.matchId(eName);

            String stId = (String) stIdCombo.getSelectedItem();

            ResultTable resultTable = ResultTableController.searchResultByIds(eId, stId);
            if (examCombo.equals(null)) {

            } else {
                if (resultTable != null) {
                   
                    pm.setText(Double.toString(resultTable.getPracticalMark()));
                    tm.setText(Double.toString(resultTable.getTheoryMark()));
                    grd.setText(resultTable.getGrade());
                    status.setText(resultTable.getStatus());

                } else {
                    JOptionPane.showMessageDialog(this, "No Result Released Yet");
                }
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentSummery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentSummery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getCertificateDetails() {
        try {
            String eName = (String) examCombo.getSelectedItem();
            String eId = ExaminationController.matchId(eName);

            String stId = (String) stIdCombo.getSelectedItem();

            Certificate certificate = CertificateController.searchCertificate(eId, stId);
            if (examCombo.equals(null)) {

            } else {
                if (certificate != null) {
                    certId.setText(certificate.getCertificateID());
                    statusCer.setText(certificate.getStatus());

                } else {
                    JOptionPane.showMessageDialog(this, "No Certificate Issued Yet");
                }
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentSummery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentSummery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public double countPaidAmount(String regId) {
        double paidAmount = 0.0;
        try {

            Registration registration = RegistrationController.searchRegistrationDetail(regId);
            double regFee = registration.getRegFee();
            double count = 0.0;

            ArrayList<Payment> list = PaymentController.setPaidAmount(regId);
            for (Payment payment : list) {
                count += payment.getPayment();
            }
            paidAmount = count + regFee;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paidAmount;
    }

    public void countDueAmount(String regId) {
        try {

            Registration registration = RegistrationController.searchRegistrationDetail(regId);
            String cId = registration.getCourseID();
            Course course = CourseController.searchCourse(cId);

            double paidAmount = (countPaidAmount(regId));
            double courseFee = course.getCourseFee();
            Double dueAmount = courseFee - paidAmount;

            paid.setText(dueAmount.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DoPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void matchStName() {
        try {
            String stId = (String) stIdCombo.getSelectedItem();
            String name = StudentController.getStNameFromId(stId);
            nameLbl.setText(name);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentSummery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentSummery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 private void printReportCard(){
       
        try {
            String name=nameLbl.getText();
            String cName=(String)table.getValueAt(table.getSelectedRow(), 1);
            String noOfDays=day1.getText();
            String ab=day3.getText();
            String pr=day2.getText();
            String eName=(String)examCombo.getSelectedItem();
            String pmV=pm.getText();
            String tmV=tm.getText();
            String grade=grd.getText();
            String statusIs=status.getText();
            
           // InputStream is=getClass().getResourceAsStream("./src/com/ijse/sms/reports/ReportCard1.jrxml");
           JasperReport jr=JasperCompileManager.compileReport("./src/com/ijse/sms/reports/ReportCard1.jrxml");
            HashMap hm=new HashMap();
            hm.put("name",name);
            hm.put("cName",cName);
            hm.put("noOfDays",noOfDays);
            hm.put("ab",ab);
            hm.put("pr",pr);
            hm.put("eName",eName);
            hm.put("pmV",pmV);
            hm.put("tmV",tmV);
            hm.put("grade",grade);
            hm.put("statusIs",statusIs);
            
            //JasperPrint jp=JasperFillManager.fillReport(jr, hm, new JRTableModelDataSource(dtm));
            JasperPrint jp = JasperFillManager.fillReport(jr, hm, DBConnection.getDBConnection().getConnection());
            JasperViewer.viewReport(jp,false);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentSummery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentSummery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(StudentSummery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        durationLbl2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        stLb = new javax.swing.JLabel();
        stIdCombo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        day1 = new javax.swing.JLabel();
        day2 = new javax.swing.JLabel();
        day3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        examCombo = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        grd = new javax.swing.JLabel();
        tm = new javax.swing.JLabel();
        pm = new javax.swing.JLabel();
        view = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        statusCer = new javax.swing.JLabel();
        certId = new javax.swing.JLabel();
        yearTxt = new javax.swing.JTextField();
        nameLbl1 = new javax.swing.JLabel();
        paid = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(900, 630));
        panel.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Student Status");
        panel.add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 40);

        durationLbl2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        durationLbl2.setText("Reason");
        panel.add(durationLbl2);
        durationLbl2.setBounds(-420, 410, 60, 30);

        table.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Registration Id", "Course", "Selected Class", "Reg Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(150);
            table.getColumnModel().getColumn(0).setPreferredWidth(150);
            table.getColumnModel().getColumn(0).setMaxWidth(150);
            table.getColumnModel().getColumn(1).setMinWidth(200);
            table.getColumnModel().getColumn(1).setPreferredWidth(200);
            table.getColumnModel().getColumn(1).setMaxWidth(200);
            table.getColumnModel().getColumn(2).setMinWidth(200);
            table.getColumnModel().getColumn(2).setPreferredWidth(200);
            table.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        panel.add(jScrollPane1);
        jScrollPane1.setBounds(30, 130, 780, 150);

        stLb.setText("Student Id");
        panel.add(stLb);
        stLb.setBounds(310, 80, 80, 40);

        stIdCombo.setEditable(true);
        stIdCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        stIdCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        stIdCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stIdComboActionPerformed(evt);
            }
        });
        panel.add(stIdCombo);
        stIdCombo.setBounds(370, 80, 440, 40);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Total No Of Class Days");
        panel.add(jLabel3);
        jLabel3.setBounds(480, 280, 150, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Grade");
        panel.add(jLabel4);
        jLabel4.setBounds(40, 530, 150, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Present Days");
        panel.add(jLabel5);
        jLabel5.setBounds(480, 320, 150, 30);

        day1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        day1.setForeground(new java.awt.Color(204, 0, 0));
        panel.add(day1);
        day1.setBounds(650, 280, 70, 30);

        day2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        day2.setForeground(new java.awt.Color(204, 0, 0));
        panel.add(day2);
        day2.setBounds(650, 320, 70, 30);

        day3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        day3.setForeground(new java.awt.Color(204, 0, 0));
        panel.add(day3);
        day3.setBounds(650, 360, 70, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Absence Days");
        panel.add(jLabel6);
        jLabel6.setBounds(480, 360, 150, 30);

        examCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        examCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        examCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examComboActionPerformed(evt);
            }
        });
        panel.add(examCombo);
        examCombo.setBounds(160, 430, 200, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Status");
        panel.add(jLabel7);
        jLabel7.setBounds(40, 560, 150, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Examinations");
        panel.add(jLabel8);
        jLabel8.setBounds(40, 430, 150, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Practical Mark");
        panel.add(jLabel9);
        jLabel9.setBounds(40, 470, 150, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Theory Mark");
        panel.add(jLabel10);
        jLabel10.setBounds(40, 500, 150, 30);

        status.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        status.setForeground(new java.awt.Color(204, 0, 0));
        panel.add(status);
        status.setBounds(160, 560, 180, 30);

        grd.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        grd.setForeground(new java.awt.Color(204, 0, 0));
        panel.add(grd);
        grd.setBounds(160, 530, 40, 30);

        tm.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tm.setForeground(new java.awt.Color(204, 0, 0));
        panel.add(tm);
        tm.setBounds(160, 500, 40, 30);

        pm.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pm.setForeground(new java.awt.Color(204, 0, 0));
        panel.add(pm);
        pm.setBounds(160, 470, 40, 30);

        view.setText("View");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        panel.add(view);
        view.setBounds(390, 430, 55, 30);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Certificate ID");
        panel.add(jLabel11);
        jLabel11.setBounds(490, 470, 100, 30);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Status");
        panel.add(jLabel12);
        jLabel12.setBounds(490, 500, 110, 30);

        statusCer.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        statusCer.setForeground(new java.awt.Color(204, 0, 0));
        panel.add(statusCer);
        statusCer.setBounds(620, 500, 170, 30);

        certId.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        certId.setForeground(new java.awt.Color(204, 0, 0));
        panel.add(certId);
        certId.setBounds(620, 470, 190, 30);

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
        panel.add(yearTxt);
        yearTxt.setBounds(130, 80, 150, 35);

        nameLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl1.setText("Academic Year");
        panel.add(nameLbl1);
        nameLbl1.setBounds(30, 80, 100, 30);

        paid.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        paid.setForeground(new java.awt.Color(204, 0, 0));
        panel.add(paid);
        paid.setBounds(160, 360, 70, 30);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Due Amount");
        panel.add(jLabel13);
        jLabel13.setBounds(40, 360, 150, 30);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Name");
        panel.add(jLabel14);
        jLabel14.setBounds(40, 290, 120, 30);

        nameLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl.setForeground(new java.awt.Color(204, 0, 0));
        panel.add(nameLbl);
        nameLbl.setBounds(160, 290, 270, 30);

        jButton1.setText("Print Report Card");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel.add(jButton1);
        jButton1.setBounds(670, 580, 140, 30);

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

    private void stIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stIdComboActionPerformed
        getRegistrationDetails();
        matchStName();
        pm.setText(null);
        tm.setText(null);
        grd.setText(null);
        status.setText(null);
        certId.setText(null);
        statusCer.setText(null);

    }//GEN-LAST:event_stIdComboActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

        try {
            int i = table.getSelectedRow();
            String stId = (String) stIdCombo.getSelectedItem();
            String regId = ((String) table.getValueAt(i, 0));
            String className = ((String) table.getValueAt(i, 2));
            String year = yearTxt.getText();

            String classId = SelectClassController.matchId(className, year);

            String totDays = AttendanceController.totalDays(classId);
            String presentDays = AttendanceController.presentDays(classId, stId);
            int tot = Integer.parseInt(totDays);
            int pr = Integer.parseInt(presentDays);
            int ab = tot - pr;

            day1.setText(totDays);
            day2.setText(presentDays);
            day3.setText(Integer.toString(ab));
            buildExamCombo(regId);
            countDueAmount(regId);
            
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        
            Logger.getLogger(StudentSummery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void examComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examComboActionPerformed

    }//GEN-LAST:event_examComboActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        getResultDetails();
        getCertificateDetails();
    }//GEN-LAST:event_viewActionPerformed

    private void yearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTxtActionPerformed

    }//GEN-LAST:event_yearTxtActionPerformed

    private void yearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTxtKeyTyped
        Validation.textYear(yearTxt);
        if(yearTxt.getText().length()==3){
            stIdCombo.requestFocusInWindow();
        }
    }//GEN-LAST:event_yearTxtKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        printReportCard();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel certId;
    private javax.swing.JLabel day1;
    private javax.swing.JLabel day2;
    private javax.swing.JLabel day3;
    private javax.swing.JLabel durationLbl2;
    private javax.swing.JComboBox examCombo;
    private javax.swing.JLabel grd;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel nameLbl1;
    private javax.swing.JLabel paid;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel pm;
    private javax.swing.JComboBox stIdCombo;
    private javax.swing.JLabel stLb;
    private javax.swing.JLabel status;
    private javax.swing.JLabel statusCer;
    private javax.swing.JTable table;
    private javax.swing.JLabel tm;
    private javax.swing.JButton view;
    private javax.swing.JTextField yearTxt;
    // End of variables declaration//GEN-END:variables
}
