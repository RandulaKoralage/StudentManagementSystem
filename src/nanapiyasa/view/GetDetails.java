/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import com.sun.glass.events.KeyEvent;
import java.awt.Component;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.ijse.sms.controller.CourseController;
import com.ijse.sms.controller.RegistrationController;
import com.ijse.sms.controller.SelectClassController;
import com.ijse.sms.controller.StudentController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.db.DBConnection;
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
public class GetDetails extends javax.swing.JPanel {

    /**
     * Creates new form GetDetails
     */
     private AdminSettings as;
    public GetDetails() {
        initComponents();
        getCourseList();
        getClassList();
        backBtn.setEnabled(false);
        //set date
        String date = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
        dateTxt.setText(date);
        
        yearTxt.setText(new SimpleDateFormat("yyyy").format(new Date()));
         panelAdjestment();
         countPanel.setVisible(false);
          feesPanel.setVisible(false);
    }

    public GetDetails(String id, String name) {
        initComponents();
        getCourseList();
        getClassList();
        stIdTxt.setText(id);
        nameTxt.setText(name);
        //set date
        String date = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
        dateTxt.setText(date);
        
        yearTxt.setText(new SimpleDateFormat("yyyy").format(new Date()));
         tipPanel.setVisible(false);
         countPanel.setVisible(false);
          feesPanel.setVisible(false);
    }

    public void getCourseList() {
        try {
            String array[] = CourseController.viewCourses();
            
            for (String d : array) {
                courseCombo.addItem(d);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getClassList() {
        try {
            String year=yearTxt.getText();
            String cName=(String)courseCombo.getSelectedItem();
            String cId=CourseController.matchId(cName);
            classCombo.removeAllItems();

            String[] array = SelectClassController.classNamesOfAYearToCourse(year,cId);
            classCombo.addItem("none");
            for (String name : array) {
                classCombo.addItem(name);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   private void panelAdjestment(){
        try {
            String stId = stIdTxt.getText();
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            String[] list=CourseController.giveRegCourses(stId);
            if(list.length!=0){
            for(String s:list){
                Object[]row={s};
                dtm.addRow(row);
            }
              tipPanel.setVisible(true);
            }else{
                 tipPanel.setVisible(false);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GetDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   }
   private void countAdjestment(){
       if(classCombo.getSelectedItem()!="none"){
           try {
               String classDetail=(String)classCombo.getSelectedItem();
               String year=yearTxt.getText();
               
               int total=SelectClassController.numOfStudents(classDetail, year);
               int count=RegistrationController.numOfRegistrations(classDetail);
               
               int availability=total-count;
               
               availableLbl.setText(Integer.toString(availability));
               totalLbl.setText(Integer.toString(total));
               countPanel.setVisible(true);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(GetDetails.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(GetDetails.class.getName()).log(Level.SEVERE, null, ex);
           }
       }else{
           countPanel.setVisible(false);
       }
   }
   private void feesPanelAdjesments(){
        try {
            String cName=(String)courseCombo.getSelectedItem();
            double fees=CourseController.courseFee(cName);
            courseFeeLbl.setText(Double.toString(fees));
            feesPanel.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GetDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    private void printBill() {
        try {
            String regId = regIdTxt.getText();
           // String payId = payIdTxt.getText();            
            String fee = feeTxt.getText();            
            String date = dateTxt.getText();
            String cName = (String)courseCombo.getSelectedItem();
            String address = StudentController.getAddress(stIdTxt.getText());
            String name = nameTxt.getText();
            String[] s = regId.split("/");
            System.out.println("");
            
            String s1=s[1];
            String s3=s[2];
            String id=s1+s3;
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
    private void save(){
         try {
            String name = ((String) courseCombo.getSelectedItem());
            String cId = CourseController.matchId(name);
            String detail = (String) classCombo.getSelectedItem();
            String stId = stIdTxt.getText();
            String regId = regIdTxt.getText();
            String date = dateTxt.getText();
            Double fee = Double.parseDouble(feeTxt.getText());

            Registration registration = new Registration(regId, stId, cId, fee, date, detail);

            boolean isAdded = RegistrationController.addRegistrationDetail(registration);
            if (isAdded) {
                JOptionPane.showMessageDialog(this, "Registration Successed");
                printBill();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GetDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        feesPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        courseFeeLbl = new javax.swing.JLabel();
        tipPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        countPanel = new javax.swing.JPanel();
        availableLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        feeTxt = new javax.swing.JTextField();
        stIdLbl = new javax.swing.JLabel();
        regIdLbl = new javax.swing.JLabel();
        courseLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        feeLbl = new javax.swing.JLabel();
        classLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateTxt = new javax.swing.JTextField();
        regIdTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        stIdTxt = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        courseCombo = new javax.swing.JComboBox();
        classCombo = new javax.swing.JComboBox();
        saveBtn1 = new javax.swing.JButton();
        nameLbl1 = new javax.swing.JLabel();
        yearTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(900, 630));
        panel.setLayout(null);

        feesPanel.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel5.setText("Course Fee Rs.");

        courseFeeLbl.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        courseFeeLbl.setForeground(new java.awt.Color(255, 51, 51));
        courseFeeLbl.setText("10000");
        courseFeeLbl.setMaximumSize(new java.awt.Dimension(96, 21));
        courseFeeLbl.setMinimumSize(new java.awt.Dimension(96, 21));
        courseFeeLbl.setPreferredSize(new java.awt.Dimension(96, 21));

        javax.swing.GroupLayout feesPanelLayout = new javax.swing.GroupLayout(feesPanel);
        feesPanel.setLayout(feesPanelLayout);
        feesPanelLayout.setHorizontalGroup(
            feesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseFeeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );
        feesPanelLayout.setVerticalGroup(
            feesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(courseFeeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel.add(feesPanel);
        feesPanel.setBounds(550, 410, 220, 40);

        tipPanel.setOpaque(false);

        table.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null}
            },
            new String [] {
                "Already Registered In..."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setFillsViewportHeight(true);
        table.setGridColor(new java.awt.Color(255, 255, 255));
        table.setRowHeight(20);
        table.setSelectionBackground(new java.awt.Color(255, 204, 102));
        table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(0).setPreferredWidth(400);
        }

        javax.swing.GroupLayout tipPanelLayout = new javax.swing.GroupLayout(tipPanel);
        tipPanel.setLayout(tipPanelLayout);
        tipPanelLayout.setHorizontalGroup(
            tipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tipPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tipPanelLayout.setVerticalGroup(
            tipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tipPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );

        panel.add(tipPanel);
        tipPanel.setBounds(300, 510, 470, 110);

        countPanel.setOpaque(false);

        availableLbl.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        availableLbl.setForeground(new java.awt.Color(255, 51, 51));
        availableLbl.setText("50");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel3.setText("Total Vacancies");

        totalLbl.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        totalLbl.setForeground(new java.awt.Color(255, 51, 51));
        totalLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalLbl.setText("50");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel4.setText("Chairs Free From");

        javax.swing.GroupLayout countPanelLayout = new javax.swing.GroupLayout(countPanel);
        countPanel.setLayout(countPanelLayout);
        countPanelLayout.setHorizontalGroup(
            countPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(countPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(availableLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        countPanelLayout.setVerticalGroup(
            countPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(countPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(countPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(availableLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panel.add(countPanel);
        countPanel.setBounds(430, 240, 339, 60);

        feeTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        feeTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                feeTxtFocusGained(evt);
            }
        });
        feeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feeTxtActionPerformed(evt);
            }
        });
        feeTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                feeTxtKeyTyped(evt);
            }
        });
        panel.add(feeTxt);
        feeTxt.setBounds(300, 410, 470, 35);

        stIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        stIdLbl.setText("Student ID");
        panel.add(stIdLbl);
        stIdLbl.setBounds(200, 60, 70, 20);

        regIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        regIdLbl.setText("Registration ID");
        panel.add(regIdLbl);
        regIdLbl.setBounds(200, 200, 90, 30);

        courseLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        courseLbl.setText("Course");
        panel.add(courseLbl);
        courseLbl.setBounds(200, 150, 70, 30);

        nameLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl.setText("Name  ");
        panel.add(nameLbl);
        nameLbl.setBounds(200, 100, 50, 20);

        dateLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dateLbl.setText("Date");
        panel.add(dateLbl);
        dateLbl.setBounds(200, 360, 70, 35);

        feeLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        feeLbl.setText("Registration Fee");
        panel.add(feeLbl);
        feeLbl.setBounds(200, 410, 100, 30);

        classLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        classLbl.setText("Class ");
        panel.add(classLbl);
        classLbl.setBounds(200, 300, 70, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registration Details");
        panel.add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 40);

        dateTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        panel.add(dateTxt);
        dateTxt.setBounds(300, 360, 470, 35);

        regIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        regIdTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                regIdTxtFocusGained(evt);
            }
        });
        regIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regIdTxtActionPerformed(evt);
            }
        });
        panel.add(regIdTxt);
        regIdTxt.setBounds(300, 200, 470, 35);

        nameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        panel.add(nameTxt);
        nameTxt.setBounds(300, 100, 470, 35);

        stIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
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
        panel.add(stIdTxt);
        stIdTxt.setBounds(300, 50, 470, 35);

        backBtn.setBackground(new java.awt.Color(255, 233, 248));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        panel.add(backBtn);
        backBtn.setBounds(410, 460, 110, 30);

        courseCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseComboActionPerformed(evt);
            }
        });
        panel.add(courseCombo);
        courseCombo.setBounds(300, 150, 470, 40);

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
        panel.add(classCombo);
        classCombo.setBounds(300, 300, 470, 40);

        saveBtn1.setBackground(new java.awt.Color(255, 233, 248));
        saveBtn1.setText("Save");
        saveBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtn1ActionPerformed(evt);
            }
        });
        panel.add(saveBtn1);
        saveBtn1.setBounds(560, 460, 110, 30);

        nameLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl1.setText("Academic Year");
        panel.add(nameLbl1);
        nameLbl1.setBounds(200, 250, 100, 30);

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
        yearTxt.setBounds(300, 250, 470, 35);

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

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        Registrations f1 = new Registrations();
        panel.removeAll();
        f1.setSize(panel.getSize());
        Component add = panel.add(f1);
        panel.repaint();
        panel.revalidate();
    }//GEN-LAST:event_backBtnActionPerformed

    private void saveBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtn1ActionPerformed
        save();
    }//GEN-LAST:event_saveBtn1ActionPerformed

    private void courseComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseComboActionPerformed
        
           
        String stId = stIdTxt.getText();
        if (stId.length() > 0) {
            String last3 = stId.substring(stId.length() - 4);
            regIdTxt.setText("GB/" + "" + "/" + last3);
        }
        regIdTxt.requestFocusInWindow();
    }//GEN-LAST:event_courseComboActionPerformed

    private void stIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stIdTxtActionPerformed
         String stId = stIdTxt.getText();
        try {
            
            
           
            Student student = StudentController.searchStudent(stId);
            if(student!=null){
            nameTxt.setText(student.getStName());
            }else{
                JOptionPane.showMessageDialog(this,"Please Register Student Before Choose a Course" );
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GetDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        panelAdjestment();
    }//GEN-LAST:event_stIdTxtActionPerformed

    private void yearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTxtActionPerformed
            getClassList();
            classCombo.requestFocusInWindow();
    }//GEN-LAST:event_yearTxtActionPerformed

    private void yearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTxtKeyTyped

    }//GEN-LAST:event_yearTxtKeyTyped

    private void regIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regIdTxtActionPerformed
       yearTxt.requestFocusInWindow();
    }//GEN-LAST:event_regIdTxtActionPerformed

    private void stIdTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stIdTxtKeyTyped

    }//GEN-LAST:event_stIdTxtKeyTyped

    private void regIdTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_regIdTxtFocusGained
       tipPanel.setVisible(false);
    }//GEN-LAST:event_regIdTxtFocusGained

    private void classComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classComboActionPerformed
        countAdjestment();
    }//GEN-LAST:event_classComboActionPerformed

    private void classComboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_classComboKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            feeTxt.requestFocusInWindow();
        }
    }//GEN-LAST:event_classComboKeyPressed

    private void feeTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_feeTxtFocusGained
        countPanel.setVisible(false);
       feesPanelAdjesments();
    }//GEN-LAST:event_feeTxtFocusGained

    private void feeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feeTxtActionPerformed
        save();
    }//GEN-LAST:event_feeTxtActionPerformed

    private void feeTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_feeTxtKeyTyped
        Validation.priceText(feeTxt);
    }//GEN-LAST:event_feeTxtKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel availableLbl;
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox classCombo;
    private javax.swing.JLabel classLbl;
    private javax.swing.JPanel countPanel;
    private javax.swing.JComboBox courseCombo;
    private javax.swing.JLabel courseFeeLbl;
    private javax.swing.JLabel courseLbl;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JLabel feeLbl;
    private javax.swing.JTextField feeTxt;
    private javax.swing.JPanel feesPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel nameLbl1;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel regIdLbl;
    private javax.swing.JTextField regIdTxt;
    private javax.swing.JButton saveBtn1;
    private javax.swing.JLabel stIdLbl;
    private javax.swing.JTextField stIdTxt;
    private javax.swing.JTable table;
    private javax.swing.JPanel tipPanel;
    private javax.swing.JLabel totalLbl;
    private javax.swing.JTextField yearTxt;
    // End of variables declaration//GEN-END:variables
}
