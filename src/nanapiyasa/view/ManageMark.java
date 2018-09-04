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
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import com.ijse.sms.controller.ExaminationController;
import com.ijse.sms.controller.IdGenerator;
import com.ijse.sms.controller.RegistrationController;
import com.ijse.sms.controller.ResultTableController;
import com.ijse.sms.controller.SelectClassController;
import com.ijse.sms.controller.StudentController;
import com.ijse.sms.model.Registration;
import com.ijse.sms.model.ResultTable;
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
public class ManageMark extends javax.swing.JPanel {

    /**
     * Creates new form ManageMark
     */
    public ManageMark() {
        initComponents();
        disableRepeatPanel();
        disableFinalPanel();
    }
    DefaultTableModel dtm = null;

    private void disableFinalPanel() {
        finalPanel.setEnabled(false);
        yearTxt.setEnabled(false);
        examCombo.setEnabled(false);
        acYearTxt.setEnabled(false);
        classCombo.setEnabled(false);
    }

    private void disableRepeatPanel() {
        repeatePanel.setEnabled(false);
        yearTxt1.setEnabled(false);
        examCombo2.setEnabled(false);
        examCombo1.setEnabled(false);
        acYearTxt1.setEnabled(false);
    }

    private void enableFinalPanel() {
        finalPanel.setEnabled(true);
        yearTxt.setEnabled(true);
        examCombo.setEnabled(true);
        acYearTxt.setEnabled(true);
        classCombo.setEnabled(true);
    }

    private void enableRepeatPanel() {
        repeatePanel.setEnabled(true);
        yearTxt1.setEnabled(true);
        examCombo2.setEnabled(true);
        examCombo1.setEnabled(true);
        acYearTxt1.setEnabled(true);
    }

    private void matchClassNames() {
        try {

            String eName = (String) examCombo.getSelectedItem();
            String eYear = yearTxt.getText();
            classCombo.removeAllItems();

            String[] array = SelectClassController.classNamesOfGivenExam(eYear, eName);
            for (String names : array) {
                classCombo.addItem(names);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getFinalExamList() {
        try {
            String year = yearTxt.getText();

            examCombo.removeAllItems();
            examCombo.addItem("none");

            String[] array = ExaminationController.finalExamNameOfAYear(year);
            for (String name : array) {
                examCombo.addItem(name);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getRepeateExamList() {
        try {
            String year = yearTxt1.getText();

            examCombo2.removeAllItems();
            examCombo2.addItem("none");

            String[] array = ExaminationController.repeateExamNameOfAYear(year);
            for (String name : array) {
                examCombo2.addItem(name);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getExamList() {
        try {
            String year = yearTxt1.getText();

            examCombo1.removeAllItems();
            examCombo1.addItem("none");

            String[] array = ExaminationController.examNameOfAYear(year);
            for (String name : array) {
                examCombo1.addItem(name);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getGrade() {
        int c = table.getRowCount();
        table.clearSelection();
        for (int i = 0; i < c; i++) {
            Double pm = (Double) table.getValueAt(i, 3);
            Double tm = (Double) table.getValueAt(i, 4);
            Double tot = pm + tm;
            Double avg = tot / 2;

            String grade = "A";
            if (avg >= 75) {
                grade = "A";
            } else if (avg >= 65) {
                grade = "B";
            } else if (avg >= 55) {
                grade = "C";
            } else if (avg >= 35) {
                grade = "S";
            } else {
                grade = "F";
            }
            table.setValueAt(avg, i, 5);
            table.setValueAt(grade, i, 6);
            if (grade.equals("F")) {
                table.setValueAt("Repeate", i, 7);
            } else {
                table.setValueAt("Pass", i, 7);
            }
        }

    }

    private void arrangeRepeateTable() {
        try {
            String eYear = yearTxt1.getText();
            String acYear = acYearTxt1.getText();
            String eName = (String) examCombo1.getSelectedItem();
            String finalId = IdGenerator.getNewId("ResultTable", "ResultId", "R");
            String next = finalId.substring(finalId.length() - 1);

            ArrayList<Registration> list = RegistrationController.viewRepeateCandidates(eYear, acYear, eName);
            dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);

            int idNumber = Integer.parseInt(next);

            for (Registration registration : list) {

                String id = "R" + idNumber++;
                String name = StudentController.getStNameFromId(registration.getStID());
                System.out.println(name);
                Object[] row = {id, registration.getStID(), name, null, null, null, null};
                dtm.addRow(row);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewAllExaminations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllExaminations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getStudentNameList() {
        try {
            String year = acYearTxt.getText();
            String className = (String) classCombo.getSelectedItem();
            String[] array = StudentController.studentNames(year, className);
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            String finalId = IdGenerator.getNewId("ResultTable", "ResultId", "R");
            String next = finalId.substring(finalId.length() - 1);
            int idNumber = Integer.parseInt(next);

            for (String names : array) {
                String id = "R" + idNumber++;
                String stId = StudentController.getStIdFromName(names);

                Object[] row = {id, stId, names, null, null, null, null};
                dtm.addRow(row);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void printMarkSheet() {
        try {

            String eName = null;
            if (finalPanel.isEnabled()) {
                eName = (String) examCombo.getSelectedItem();
            } else if (repeatePanel.isEnabled()) {
                eName = (String) examCombo2.getSelectedItem();
            }
            // InputStream is=getClass().getResourceAsStream("./src/nanapiyasa/reports/AttendanceSheet.jrxml");
            JasperReport jr = JasperCompileManager.compileReport("./src/com/ijse/sms/reports/MarkSheet.jrxml");
            HashMap hm = new HashMap();
            hm.put("eName", eName);

            JasperPrint jp = JasperFillManager.fillReport(jr, hm, new JRTableModelDataSource(dtm));
            //  JasperPrint jp = JasperFillManager.fillReport(jr, hm, DBConnection.getDBConnection().getConnection());
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(MarkAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        modifyBtn = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        clearBtn = new javax.swing.JButton();
        finalPanel = new javax.swing.JPanel();
        examIdLbl1 = new javax.swing.JLabel();
        classCombo = new javax.swing.JComboBox();
        acYearTxt = new javax.swing.JTextField();
        nameLbl2 = new javax.swing.JLabel();
        yearTxt = new javax.swing.JTextField();
        nameLbl1 = new javax.swing.JLabel();
        examIdLbl = new javax.swing.JLabel();
        examCombo = new javax.swing.JComboBox();
        repeatePanel = new javax.swing.JPanel();
        yearTxt1 = new javax.swing.JTextField();
        nameLbl3 = new javax.swing.JLabel();
        examIdLbl3 = new javax.swing.JLabel();
        examCombo2 = new javax.swing.JComboBox();
        examIdLbl2 = new javax.swing.JLabel();
        examCombo1 = new javax.swing.JComboBox();
        acYearTxt1 = new javax.swing.JTextField();
        nameLbl4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(900, 630));
        jPanel2.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Manage Examination Marks");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(0, 0, 900, 40);

        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/new.png"))); // NOI18N
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveBtnMouseClicked(evt);
            }
        });
        jPanel2.add(saveBtn);
        saveBtn.setBounds(300, 530, 70, 80);

        jLabel9.setText("Save New");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(300, 600, 60, 20);

        jLabel10.setText("Modifications");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(510, 600, 70, 20);

        modifyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/modify.png"))); // NOI18N
        modifyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modifyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyBtnMouseClicked(evt);
            }
        });
        jPanel2.add(modifyBtn);
        modifyBtn.setBounds(510, 530, 70, 80);

        table.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Result Id", "St ID", "Name", "Theory Mark", "Practical Mark", "Total", "Grade", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setFillsViewportHeight(true);
        table.setGridColor(new java.awt.Color(220, 100, 68));
        table.setRowHeight(20);
        table.setSelectionBackground(new java.awt.Color(255, 204, 153));
        table.setSelectionForeground(new java.awt.Color(51, 0, 0));
        table.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tablePropertyChange(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tableKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(1).setMinWidth(100);
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(1).setMaxWidth(100);
            table.getColumnModel().getColumn(2).setMinWidth(200);
            table.getColumnModel().getColumn(2).setPreferredWidth(200);
            table.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(30, 280, 830, 230);

        clearBtn.setBackground(new java.awt.Color(255, 233, 248));
        clearBtn.setText("Set Grades");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        jPanel2.add(clearBtn);
        clearBtn.setBounds(600, 520, 120, 40);

        finalPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Final Exams", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        finalPanel.setOpaque(false);
        finalPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finalPanelMouseClicked(evt);
            }
        });
        finalPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        examIdLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        examIdLbl1.setText("Class Name");
        finalPanel.add(examIdLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 70, 30));

        classCombo.setEditable(true);
        classCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        classCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
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
        finalPanel.add(classCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 240, 30));

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
        finalPanel.add(acYearTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 240, 30));

        nameLbl2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl2.setText("Academic Year");
        finalPanel.add(nameLbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 90, 30));

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
        finalPanel.add(yearTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 180, 30));

        nameLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl1.setText("Exam Year");
        finalPanel.add(nameLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 70, 30));

        examIdLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        examIdLbl.setText("Exam Name");
        finalPanel.add(examIdLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 80, 30));

        examCombo.setEditable(true);
        examCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        examCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
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
        finalPanel.add(examCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 180, 30));

        jPanel2.add(finalPanel);
        finalPanel.setBounds(40, 50, 810, 110);

        repeatePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Repeate Exams"));
        repeatePanel.setOpaque(false);
        repeatePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repeatePanelMouseClicked(evt);
            }
        });
        repeatePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        yearTxt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        yearTxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearTxt1ActionPerformed(evt);
            }
        });
        yearTxt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                yearTxt1KeyTyped(evt);
            }
        });
        repeatePanel.add(yearTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 180, 30));

        nameLbl3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl3.setText("Exam Year");
        repeatePanel.add(nameLbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 70, 30));

        examIdLbl3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        examIdLbl3.setText("Exam Name");
        repeatePanel.add(examIdLbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 80, 30));

        examCombo2.setEditable(true);
        examCombo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        examCombo2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        examCombo2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                examCombo2FocusGained(evt);
            }
        });
        examCombo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examCombo2ActionPerformed(evt);
            }
        });
        examCombo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                examCombo2KeyPressed(evt);
            }
        });
        repeatePanel.add(examCombo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 180, 30));

        examIdLbl2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        examIdLbl2.setText("Repeate On");
        repeatePanel.add(examIdLbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 80, 30));

        examCombo1.setEditable(true);
        examCombo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));
        examCombo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        examCombo1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                examCombo1FocusGained(evt);
            }
        });
        examCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examCombo1ActionPerformed(evt);
            }
        });
        examCombo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                examCombo1KeyPressed(evt);
            }
        });
        repeatePanel.add(examCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 240, 30));

        acYearTxt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        acYearTxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acYearTxt1ActionPerformed(evt);
            }
        });
        acYearTxt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                acYearTxt1KeyTyped(evt);
            }
        });
        repeatePanel.add(acYearTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 240, 30));

        nameLbl4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl4.setText("Academic Year");
        repeatePanel.add(nameLbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 90, 30));

        jPanel2.add(repeatePanel);
        repeatePanel.setBounds(40, 170, 810, 100);

        jButton1.setText("Print Result Sheet");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(730, 520, 130, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background2.png"))); // NOI18N
        jPanel2.add(jLabel8);
        jLabel8.setBounds(0, 90, 835, 520);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void modifyBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyBtnMouseClicked
        new ModifyMarks(null, true).setVisible(true);
    }//GEN-LAST:event_modifyBtnMouseClicked

    private void yearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTxtActionPerformed

    }//GEN-LAST:event_yearTxtActionPerformed

    private void yearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTxtKeyTyped

        if (yearTxt.getText().length() == 3) {
            examCombo.requestFocusInWindow();

        }
    }//GEN-LAST:event_yearTxtKeyTyped

    private void acYearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acYearTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acYearTxtActionPerformed

    private void acYearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_acYearTxtKeyTyped
        if (acYearTxt.getText().length() == 3) {
            classCombo.requestFocusInWindow();

        }
    }//GEN-LAST:event_acYearTxtKeyTyped

    private void examComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_examComboFocusGained
        getFinalExamList();
    }//GEN-LAST:event_examComboFocusGained

    private void classComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_classComboFocusGained
        matchClassNames();
    }//GEN-LAST:event_classComboFocusGained

    private void classComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classComboActionPerformed
        getStudentNameList();
    }//GEN-LAST:event_classComboActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        getGrade();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void tablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tablePropertyChange


    }//GEN-LAST:event_tablePropertyChange

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased

    }//GEN-LAST:event_tableKeyReleased

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed

    }//GEN-LAST:event_tableKeyPressed

    private void examComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examComboActionPerformed

    }//GEN-LAST:event_examComboActionPerformed

    private void examComboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_examComboKeyPressed

    }//GEN-LAST:event_examComboKeyPressed

    private void saveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseClicked
        try {
            ArrayList<ResultTable> result = new ArrayList<>();
            for (int i = 0; i < table.getRowCount(); i++) {
                String resId = (String) table.getValueAt(i, 0);
                String examId = null;
                if (finalPanel.isEnabled()) {
                    examId = ExaminationController.matchId((String) examCombo.getSelectedItem());
                }
                if (repeatePanel.isEnabled()) {
                    examId = ExaminationController.matchId((String) examCombo2.getSelectedItem());
                }
                String stId = (String) table.getValueAt(i, 1);
                double practical = (Double) table.getValueAt(i, 4);
                double theory = (Double) table.getValueAt(i, 3);
                String grade = (String) table.getValueAt(i, 6);
                String status = (String) table.getValueAt(i, 7);

                ResultTable resultTable = new ResultTable(resId, examId, stId, practical, theory, grade, status);
                result.add(resultTable);
            }
            boolean isAdded = ResultTableController.addOrderDetail(result);
            if (isAdded) {
                JOptionPane.showMessageDialog(this, "Saved Succssessfully");
            } else {
                JOptionPane.showMessageDialog(this, "Saving faild");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageMark.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageMark.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveBtnMouseClicked

    private void examCombo1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_examCombo1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_examCombo1KeyPressed

    private void examCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examCombo1ActionPerformed
        arrangeRepeateTable();
    }//GEN-LAST:event_examCombo1ActionPerformed

    private void examCombo1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_examCombo1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_examCombo1FocusGained

    private void examCombo2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_examCombo2FocusGained
        getRepeateExamList();
    }//GEN-LAST:event_examCombo2FocusGained

    private void examCombo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examCombo2ActionPerformed
        getExamList();
    }//GEN-LAST:event_examCombo2ActionPerformed

    private void examCombo2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_examCombo2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_examCombo2KeyPressed

    private void yearTxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearTxt1ActionPerformed

    private void yearTxt1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTxt1KeyTyped

        if (yearTxt1.getText().length() == 3) {
            getExamList();
            examCombo2.requestFocusInWindow();

        }
    }//GEN-LAST:event_yearTxt1KeyTyped

    private void acYearTxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acYearTxt1ActionPerformed
        arrangeRepeateTable();
    }//GEN-LAST:event_acYearTxt1ActionPerformed

    private void acYearTxt1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_acYearTxt1KeyTyped

    }//GEN-LAST:event_acYearTxt1KeyTyped

    private void finalPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalPanelMouseClicked
        enableFinalPanel();
        disableRepeatPanel();
    }//GEN-LAST:event_finalPanelMouseClicked

    private void repeatePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repeatePanelMouseClicked
        enableRepeatPanel();
        disableFinalPanel();
    }//GEN-LAST:event_repeatePanelMouseClicked

    private void tableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyTyped

    }//GEN-LAST:event_tableKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        printMarkSheet();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField acYearTxt;
    private javax.swing.JTextField acYearTxt1;
    private javax.swing.JComboBox classCombo;
    private javax.swing.JButton clearBtn;
    private javax.swing.JComboBox examCombo;
    private javax.swing.JComboBox examCombo1;
    private javax.swing.JComboBox examCombo2;
    private javax.swing.JLabel examIdLbl;
    private javax.swing.JLabel examIdLbl1;
    private javax.swing.JLabel examIdLbl2;
    private javax.swing.JLabel examIdLbl3;
    private javax.swing.JPanel finalPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel modifyBtn;
    private javax.swing.JLabel nameLbl1;
    private javax.swing.JLabel nameLbl2;
    private javax.swing.JLabel nameLbl3;
    private javax.swing.JLabel nameLbl4;
    private javax.swing.JPanel repeatePanel;
    private javax.swing.JLabel saveBtn;
    private javax.swing.JTable table;
    private javax.swing.JTextField yearTxt;
    private javax.swing.JTextField yearTxt1;
    // End of variables declaration//GEN-END:variables
}
