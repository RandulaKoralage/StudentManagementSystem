/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import com.ijse.sms.controller.AttendanceController;
import com.ijse.sms.controller.ExaminationController;
import com.ijse.sms.controller.PaymentController;
import com.ijse.sms.controller.RegistrationController;
import com.ijse.sms.controller.SelectClassController;
import com.ijse.sms.controller.TimetableController;
import com.ijse.sms.model.Attendance;
import com.ijse.sms.model.Payment;
import com.ijse.sms.model.Registration;
import com.ijse.sms.model.Timetable;
import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Randula
 */
public class Reports extends javax.swing.JFrame {

    /**
     * Creates new form Reports
     */
    public Reports() {
        initComponents();
        inputPanel.setVisible(false);
        inputPanel1.setVisible(false);
    }

    private void setRegistrationGraph() {

        try {
            DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();

            ArrayList<Registration> list = RegistrationController.countRegistrations();

            for (Registration registration : list) {
                double val = Double.parseDouble(registration.getRegID());
                String year = registration.getClassDetail();
                categoryDataset.setValue(val, "Registrations", year);
            }
            JFreeChart freeChart = ChartFactory.createBarChart("Development Of Registrations", "Year", "Students", categoryDataset, PlotOrientation.VERTICAL, false, true, false);

            CategoryPlot categoryPlot = freeChart.getCategoryPlot();

            categoryPlot.setRangeGridlinePaint(Color.YELLOW);
            categoryPlot.setRangeGridlinesVisible(false);
            categoryPlot.setBackgroundPaint(Color.WHITE);
            categoryPlot.setOutlinePaint(Color.BLUE);
            categoryPlot.setDomainCrosshairPaint(Color.RED);

            /*ChartFrame chartFrame = new ChartFrame("View", freeChart);
             chartFrame.setVisible(true);
             chartFrame.setSize(450,400);*/
            
            ChartPanel chartPanel = new ChartPanel(freeChart);
            chartPanel.setOpaque(false);
            viewPanel.removeAll();
            chartPanel.setSize(viewPanel.getSize());
            viewPanel.add(chartPanel);
            viewPanel.repaint();
            viewPanel.revalidate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClassAlerts.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClassAlerts.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public  void loadPanel(){
        
        try {
            String year=yearTxt.getText();
            String eName=(String)examCombo.getSelectedItem();
            
            int passes=ExaminationController.numOfPass(eName, year);
            int allCandidates=ExaminationController.numOfCandidates(eName, year);
            int failed=allCandidates-passes;
            
            DefaultPieDataset dataset = new DefaultPieDataset();
            dataset.setValue("Pass", passes);
            dataset.setValue("Repeate", failed);
            
            
            JFreeChart freeChart = ChartFactory.createPieChart("Exam Result Analyze", dataset, true, true, true);
            PiePlot piePlot = (PiePlot) freeChart.getPlot();
            
            ChartPanel chartPanel = new ChartPanel(freeChart);
            chartPanel.setOpaque(true);
            viewPanel.removeAll();
            chartPanel.setSize(viewPanel.getSize());
            viewPanel.add(chartPanel);
            viewPanel.repaint();
            viewPanel.revalidate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
          
          
       }
private void getExamList() {
        try {
            String year = yearTxt.getText();

            examCombo.removeAllItems();
            examCombo.addItem("none");
            
            String[] array = ExaminationController.examNameOfAYear(year);
            for (String name : array) {
                examCombo.addItem(name);              
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
private void getClassList() {
    
        try {
            String stId = stIdTxt.getText();
           
            classCombo.removeAllItems();
            classCombo.addItem("none");
            
            String[] array = RegistrationController.viewClassNames(stId);
            for (String name : array) {
                classCombo.addItem(name);              
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
private void teachersChart(String year){
        try {
            DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
            
            ArrayList<Timetable> list = TimetableController.teachersInvolvement(year);

            for (Timetable timetable : list) {
                double val = Double.parseDouble(timetable.getScheduleID());
                String lectId = timetable.getLectID();
                categoryDataset.setValue(val, "Classes", lectId);
            }
            JFreeChart freeChart = ChartFactory.createBarChart("Teachers Involment In Classes", "Lect Id", "No Of Classes", categoryDataset, PlotOrientation.VERTICAL, false, true, false);

            CategoryPlot categoryPlot = freeChart.getCategoryPlot();

            categoryPlot.setRangeGridlinePaint(Color.BLACK);
            categoryPlot.setRangeGridlinesVisible(false);
            categoryPlot.setBackgroundPaint(Color.WHITE);
            categoryPlot.setOutlinePaint(Color.BLUE);
            categoryPlot.setDomainCrosshairPaint(Color.ORANGE);
            
            ChartPanel chartPanel = new ChartPanel(freeChart);
            chartPanel.setOpaque(false);
            viewPanel.removeAll();
            chartPanel.setSize(viewPanel.getSize());
            viewPanel.add(chartPanel);
            viewPanel.repaint();
            viewPanel.revalidate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
}
private void attendanceChart(){
        try {
            String stId=stIdTxt.getText();
            String className=(String)classCombo.getSelectedItem();
            
            String classId=SelectClassController.matchId(className, acYearTxt.getText());
            DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
            ArrayList<Attendance>list=AttendanceController.attendanceVariation(stId, classId);
            for (Attendance attendance : list) {
                double val = Double.parseDouble(attendance.getCurrentDate());
                String month = attendance.getStatus();
                categoryDataset.setValue(val, "Attendance", month);
            }
            
            JFreeChart freeChart = ChartFactory.createLineChart("Students Attendance Variation", "Month", "Present Dates", categoryDataset,PlotOrientation.VERTICAL,false,true,false);
            
            CategoryPlot categoryPlot = freeChart.getCategoryPlot();
            
            ChartPanel chartPanel = new ChartPanel(freeChart);
            chartPanel.setOpaque(false);
            viewPanel.removeAll();
            chartPanel.setSize(viewPanel.getSize());
            viewPanel.add(chartPanel);
            viewPanel.repaint();
            viewPanel.revalidate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
}
private void incomeGrowth(){
     
        try {
            DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
            ArrayList<Registration>list=RegistrationController.totalRegFee();
            for (Registration registration : list) { 
                String year=registration.getClassDetail();            
                double totPayOfYear=PaymentController.totalPayments(year);             
                double val=totPayOfYear+Double.parseDouble(registration.getRegID());              
                categoryDataset.setValue(val, "Total", year);
            }            
            JFreeChart freeChart = ChartFactory.createLineChart("Growth Of Income", "Month", "Present Dates", categoryDataset,PlotOrientation.VERTICAL,false,true,false);

            CategoryPlot categoryPlot = freeChart.getCategoryPlot();

            categoryPlot.setRangeGridlinePaint(Color.BLACK);
            categoryPlot.setRangeGridlinesVisible(false);
            categoryPlot.setBackgroundPaint(Color.WHITE);
            categoryPlot.setOutlinePaint(Color.BLUE);
            categoryPlot.setDomainCrosshairPaint(Color.ORANGE);
            
            ChartPanel chartPanel = new ChartPanel(freeChart);
            chartPanel.setOpaque(false);
            viewPanel.removeAll();
            chartPanel.setSize(viewPanel.getSize());
            viewPanel.add(chartPanel);
            viewPanel.repaint();
            viewPanel.revalidate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
}
private void studentInvolvement(String year){
     
        try {
            DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
            ArrayList<Registration>list=RegistrationController.studensOfCourses(year);
            for (Registration registration : list) {
                double noOfStudents=Double.parseDouble(registration.getRegID());
                          
                categoryDataset.setValue(noOfStudents, "Total", registration.getClassDetail());
            }            
            JFreeChart freeChart = ChartFactory.createBarChart("Student Involvement Of Courses", "Course ID", "No of Students", categoryDataset,PlotOrientation.VERTICAL,false,true,false);
            
            CategoryPlot categoryPlot = freeChart.getCategoryPlot();
            
            ChartPanel chartPanel = new ChartPanel(freeChart);
            chartPanel.setOpaque(false);
            viewPanel.removeAll();
            chartPanel.setSize(viewPanel.getSize());
            viewPanel.add(chartPanel);
            viewPanel.repaint();
            viewPanel.revalidate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
}
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        viewPanel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        inputPanel = new javax.swing.JPanel();
        examCombo = new javax.swing.JComboBox();
        nameLbl3 = new javax.swing.JLabel();
        yearTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        inputPanel1 = new javax.swing.JPanel();
        classCombo = new javax.swing.JComboBox();
        nameLbl4 = new javax.swing.JLabel();
        stIdTxt = new javax.swing.JTextField();
        nameLbl5 = new javax.swing.JLabel();
        acYearTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reports");
        setResizable(false);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 204, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Student Registration Development");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 260, 60));

        viewPanel.setBackground(new java.awt.Color(255, 255, 255));
        viewPanel.setOpaque(false);

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        panel.add(viewPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 570, 450));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Examination Pass Rates");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 260, 60));

        inputPanel.setBackground(new java.awt.Color(255, 255, 255));
        inputPanel.setOpaque(false);
        inputPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        examCombo.setEditable(true);
        examCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        examCombo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
        examCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                examComboKeyPressed(evt);
            }
        });
        inputPanel.add(examCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 220, 20));

        nameLbl3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        nameLbl3.setText("Exam Year");
        inputPanel.add(nameLbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 20));

        yearTxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
        inputPanel.add(yearTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 220, 20));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel1.setText("Exam Name");
        inputPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 60, 20));

        panel.add(inputPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 320, 50));

        inputPanel1.setBackground(new java.awt.Color(255, 255, 255));
        inputPanel1.setOpaque(false);
        inputPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        classCombo.setEditable(true);
        classCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        classCombo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        classCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                classComboFocusGained(evt);
            }
        });
        classCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classComboActionPerformed(evt);
            }
        });
        classCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                classComboKeyPressed(evt);
            }
        });
        inputPanel1.add(classCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 220, 20));

        nameLbl4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        nameLbl4.setText("St Id");
        inputPanel1.add(nameLbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 20));

        stIdTxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        stIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stIdTxtActionPerformed(evt);
            }
        });
        stIdTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stIdTxtKeyTyped(evt);
            }
        });
        inputPanel1.add(stIdTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 220, 20));

        nameLbl5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        nameLbl5.setText("Acd Year");
        inputPanel1.add(nameLbl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 20));

        acYearTxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
        inputPanel1.add(acYearTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 220, 20));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("Class");
        inputPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 60, 20));

        panel.add(inputPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 320, 60));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Teachers' Involvement in Classes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 260, 60));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Variation Of Student Attendance");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panel.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 260, 60));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Income Growth ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 260, 60));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Students' Involvement Of Courses");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        panel.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 260, 60));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         setRegistrationGraph();
         
           inputPanel.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     inputPanel.setVisible(true); 
      int value = JOptionPane.showConfirmDialog(this, inputPanel, "Select Year", JOptionPane.OK_CANCEL_OPTION);
        if (value == JOptionPane.OK_OPTION){
            loadPanel();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void examComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_examComboFocusGained
        getExamList();
    }//GEN-LAST:event_examComboFocusGained

    private void examComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examComboActionPerformed

    }//GEN-LAST:event_examComboActionPerformed

    private void examComboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_examComboKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_examComboKeyPressed

    private void yearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTxtActionPerformed

    }//GEN-LAST:event_yearTxtActionPerformed

    private void yearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTxtKeyTyped
        if (yearTxt.getText().length() == 3) {
            examCombo.requestFocusInWindow();
        }
    }//GEN-LAST:event_yearTxtKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         inputPanel.setVisible(false);
         
          
          String year=JOptionPane.showInputDialog(Reports.this, "Input Acedemic Year", "Teachers' Involvement In Classes", 3);
           teachersChart(year);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void classComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_classComboFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_classComboFocusGained

    private void classComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_classComboActionPerformed

    private void classComboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_classComboKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_classComboKeyPressed

    private void stIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stIdTxtActionPerformed
        getClassList();
    }//GEN-LAST:event_stIdTxtActionPerformed

    private void stIdTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stIdTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_stIdTxtKeyTyped

    private void acYearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acYearTxtActionPerformed
        stIdTxt.requestFocusInWindow();
    }//GEN-LAST:event_acYearTxtActionPerformed

    private void acYearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_acYearTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_acYearTxtKeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
          inputPanel1.setVisible(true); 
          inputPanel.setVisible(false); 
        int value = JOptionPane.showConfirmDialog(this, inputPanel1, "Select Class & Student", JOptionPane.OK_CANCEL_OPTION);
        if (value == JOptionPane.OK_OPTION){
            attendanceChart();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        incomeGrowth();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String year=JOptionPane.showInputDialog(Reports.this, "Input Acedemic Year", "Students' Involvement of Classes", 3);
           studentInvolvement(year);
    }//GEN-LAST:event_jButton6ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField acYearTxt;
    private javax.swing.JComboBox classCombo;
    private javax.swing.JComboBox examCombo;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JPanel inputPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel nameLbl3;
    private javax.swing.JLabel nameLbl4;
    private javax.swing.JLabel nameLbl5;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField stIdTxt;
    public javax.swing.JPanel viewPanel;
    private javax.swing.JTextField yearTxt;
    // End of variables declaration//GEN-END:variables
}
