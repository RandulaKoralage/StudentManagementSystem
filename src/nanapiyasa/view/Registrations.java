/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import com.ijse.sms.controller.StudentController;
import com.ijse.sms.util.Validation;
import com.ijse.sms.model.Student;

/**
 *
 * @author Randula
 */
public class Registrations extends javax.swing.JPanel {

    int notNullValues = 0;
    int counter = 3;
    private AdminSettings as;
    String user;

    /**
     * Creates new form Registration
     */
    public Registrations() {
        initComponents();
        arrangeId();
        nextBtn.setEnabled(false);

    }
    /* public Registrations(String user) {
     initComponents();
     arrangeId();
     nextBtn.setEnabled(false);
        
     }*/

    public void arrangeId() {
        String id = null;
        try {
            id = StudentController.getStId();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registrations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registrations.class.getName()).log(Level.SEVERE, null, ex);
        }
        String last4 = id.substring(3);

        int idTemp = Integer.parseInt(last4) + 1;
        stIdTxt.setText("GB/" + idTemp);
    }

    boolean validateTelNum(String TelNum) {
        boolean status = false;
        String telNumCheck = TelNum;
        Pattern pattern = Pattern.compile("[0-9]{10}");
        Matcher matcher = pattern.matcher(telNumCheck);
        if (matcher.matches()) {
            status = true;
        } else {
            status = false;

        }
        return status;
    }

    private void save() {
        try {
            String id = stIdTxt.getText();
            String name = nameTxt.getText();
            String address = addressTxt.getText();
            String tel = telTxt.getText();
            String dob = yearTxt.getText() + "-" + monthTxt.getText() + "-" + dayTxt.getText();
            String gender = "Female";
            if (maleBtn.isSelected()) {
                gender = "Male";
            }
            String guardName = guardTxt.getText();
            String occupation = occupationTxt.getText();
            String relationship = relationshipTxt.getText();
            String gurdTel = guardTelTxt.getText();

            Student student = new Student(id, name, address, tel, dob, gender, guardName, occupation, relationship, gurdTel);
            boolean isAdded = StudentController.addStudent(student);
            if (isAdded) {
                GetDetails f1 = new GetDetails(id, name);
                panel.removeAll();
                f1.setSize(panel.getSize());
                Component add = panel.add(f1);
                panel.repaint();
                panel.revalidate();
            } else {
                JOptionPane.showMessageDialog(this, "Notified an error in Registration Form");
            }
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {

            Logger.getLogger(Registrations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderGroup = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        guardTelTxt = new javax.swing.JTextField();
        dobLbl = new javax.swing.JLabel();
        idLbl1 = new javax.swing.JLabel();
        telLbl = new javax.swing.JLabel();
        addressLbl = new javax.swing.JLabel();
        relationshipLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        occupationLbl = new javax.swing.JLabel();
        genderLbl = new javax.swing.JLabel();
        guardTelLbl = new javax.swing.JLabel();
        guardLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        occupationTxt = new javax.swing.JTextField();
        relationshipTxt = new javax.swing.JTextField();
        guardTxt = new javax.swing.JTextField();
        monthTxt = new javax.swing.JTextField();
        dayTxt = new javax.swing.JTextField();
        yearTxt = new javax.swing.JTextField();
        telTxt = new javax.swing.JTextField();
        addressTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        stIdTxt = new javax.swing.JTextField();
        cancelBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        femaleBtn = new javax.swing.JRadioButton();
        maleBtn = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(900, 630));
        panel.setLayout(null);

        guardTelTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        guardTelTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardTelTxtActionPerformed(evt);
            }
        });
        guardTelTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                guardTelTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                guardTelTxtKeyTyped(evt);
            }
        });
        panel.add(guardTelTxt);
        guardTelTxt.setBounds(270, 460, 470, 35);

        dobLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dobLbl.setText("DOB  ");
        panel.add(dobLbl);
        dobLbl.setBounds(200, 230, 40, 20);

        idLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        idLbl1.setText("Student ID");
        panel.add(idLbl1);
        idLbl1.setBounds(200, 60, 70, 20);

        telLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        telLbl.setText("Telephone ");
        panel.add(telLbl);
        telLbl.setBounds(200, 190, 70, 20);

        addressLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        addressLbl.setText("Address");
        panel.add(addressLbl);
        addressLbl.setBounds(200, 140, 60, 35);

        relationshipLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        relationshipLbl.setText("Relationship");
        panel.add(relationshipLbl);
        relationshipLbl.setBounds(200, 420, 80, 30);

        nameLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLbl.setText("Name  ");
        panel.add(nameLbl);
        nameLbl.setBounds(200, 100, 50, 20);

        occupationLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        occupationLbl.setText("Occupation");
        panel.add(occupationLbl);
        occupationLbl.setBounds(200, 380, 70, 35);

        genderLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        genderLbl.setText("Gender");
        panel.add(genderLbl);
        genderLbl.setBounds(200, 270, 50, 20);

        guardTelLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        guardTelLbl.setText("Telephone ");
        panel.add(guardTelLbl);
        guardTelLbl.setBounds(200, 460, 70, 30);

        guardLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        guardLbl.setText("Guardian");
        panel.add(guardLbl);
        guardLbl.setBounds(200, 340, 60, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Register Students");
        panel.add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 40);

        occupationTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        occupationTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                occupationTxtActionPerformed(evt);
            }
        });
        occupationTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                occupationTxtKeyReleased(evt);
            }
        });
        panel.add(occupationTxt);
        occupationTxt.setBounds(270, 380, 470, 35);

        relationshipTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        relationshipTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relationshipTxtActionPerformed(evt);
            }
        });
        panel.add(relationshipTxt);
        relationshipTxt.setBounds(270, 420, 470, 35);

        guardTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        guardTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardTxtActionPerformed(evt);
            }
        });
        guardTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                guardTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                guardTxtKeyTyped(evt);
            }
        });
        panel.add(guardTxt);
        guardTxt.setBounds(270, 340, 470, 35);

        monthTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        monthTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        monthTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        monthTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                monthTxtKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                monthTxtKeyTyped(evt);
            }
        });
        panel.add(monthTxt);
        monthTxt.setBounds(430, 220, 150, 35);

        dayTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dayTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dayTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        dayTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dayTxtKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dayTxtKeyTyped(evt);
            }
        });
        panel.add(dayTxt);
        dayTxt.setBounds(590, 220, 150, 35);

        yearTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        yearTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        yearTxt.setToolTipText("Year");
        yearTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        yearTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                yearTxtKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                yearTxtKeyTyped(evt);
            }
        });
        panel.add(yearTxt);
        yearTxt.setBounds(270, 220, 150, 35);

        telTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        telTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telTxtActionPerformed(evt);
            }
        });
        panel.add(telTxt);
        telTxt.setBounds(270, 180, 470, 35);

        addressTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        addressTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTxtActionPerformed(evt);
            }
        });
        panel.add(addressTxt);
        addressTxt.setBounds(270, 140, 470, 35);

        nameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        nameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTxtActionPerformed(evt);
            }
        });
        nameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameTxtKeyTyped(evt);
            }
        });
        panel.add(nameTxt);
        nameTxt.setBounds(270, 100, 470, 35);

        stIdTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        stIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        stIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stIdTxtActionPerformed(evt);
            }
        });
        panel.add(stIdTxt);
        stIdTxt.setBounds(271, 50, 470, 35);

        cancelBtn.setBackground(new java.awt.Color(255, 233, 248));
        cancelBtn.setText("Cancel");
        panel.add(cancelBtn);
        cancelBtn.setBounds(550, 530, 110, 30);

        nextBtn.setBackground(new java.awt.Color(255, 233, 248));
        nextBtn.setText("Next");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });
        panel.add(nextBtn);
        nextBtn.setBounds(350, 530, 110, 30);

        femaleBtn.setBackground(new java.awt.Color(255, 255, 255));
        genderGroup.add(femaleBtn);
        femaleBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        femaleBtn.setText("Female");
        femaleBtn.setContentAreaFilled(false);
        femaleBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                femaleBtnKeyPressed(evt);
            }
        });
        panel.add(femaleBtn);
        femaleBtn.setBounds(450, 270, 93, 25);

        genderGroup.add(maleBtn);
        maleBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        maleBtn.setText("Male");
        maleBtn.setContentAreaFilled(false);
        maleBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                maleBtnKeyPressed(evt);
            }
        });
        panel.add(maleBtn);
        maleBtn.setBounds(280, 270, 93, 25);

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

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        save();
    }//GEN-LAST:event_nextBtnActionPerformed

    private void stIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stIdTxtActionPerformed
        nameTxt.requestFocusInWindow();
    }//GEN-LAST:event_stIdTxtActionPerformed

    private void nameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTxtActionPerformed
        if (stIdTxt.getText() != null) {
            notNullValues++;
        } else {
            nextBtn.setEnabled(false);
        }

        addressTxt.requestFocusInWindow();
    }//GEN-LAST:event_nameTxtActionPerformed

    private void addressTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTxtActionPerformed

        telTxt.requestFocusInWindow();
    }//GEN-LAST:event_addressTxtActionPerformed

    private void yearTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            monthTxt.requestFocusInWindow();
        }
    }//GEN-LAST:event_yearTxtKeyPressed

    private void telTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telTxtActionPerformed

        if (validateTelNum(telTxt.getText())) {
            yearTxt.requestFocusInWindow();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Phone Number");
            telTxt.setText(null);
        }

    }//GEN-LAST:event_telTxtActionPerformed

    private void monthTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_monthTxtKeyPressed

    }//GEN-LAST:event_monthTxtKeyPressed

    private void dayTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dayTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            maleBtn.requestFocusInWindow();
            maleBtn.setSelected(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            monthTxt.requestFocusInWindow();
        }
    }//GEN-LAST:event_dayTxtKeyPressed

    private void maleBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_maleBtnKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            femaleBtn.requestFocusInWindow();
            femaleBtn.setSelected(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            dayTxt.requestFocusInWindow();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            guardTxt.requestFocusInWindow();
        }
    }//GEN-LAST:event_maleBtnKeyPressed

    private void femaleBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_femaleBtnKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            guardTxt.requestFocusInWindow();
        }
    }//GEN-LAST:event_femaleBtnKeyPressed

    private void guardTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardTxtActionPerformed
        occupationTxt.requestFocusInWindow();
    }//GEN-LAST:event_guardTxtActionPerformed

    private void occupationTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_occupationTxtActionPerformed

        relationshipTxt.requestFocusInWindow();
    }//GEN-LAST:event_occupationTxtActionPerformed

    private void relationshipTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relationshipTxtActionPerformed
        guardTelTxt.requestFocusInWindow();
    }//GEN-LAST:event_relationshipTxtActionPerformed

    private void yearTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTxtKeyTyped
        Validation.textYear(yearTxt);
        if (yearTxt.getText().length() == 3) {
            monthTxt.requestFocusInWindow();
        }
    }//GEN-LAST:event_yearTxtKeyTyped

    private void monthTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_monthTxtKeyTyped
        Validation.numberOnly(monthTxt);
        if (monthTxt.getText().length() == 1) {
            dayTxt.requestFocusInWindow();
        }
    }//GEN-LAST:event_monthTxtKeyTyped

    private void dayTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dayTxtKeyTyped
        Validation.numberOnly(dayTxt);
    }//GEN-LAST:event_dayTxtKeyTyped

    private void guardTelTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_guardTelTxtKeyReleased
        if (guardTelTxt.getText().length() == 10) {
            if (validateTelNum(guardTelTxt.getText())) {

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Phone Number");
                guardTelTxt.setText(null);
            }
        }

    }//GEN-LAST:event_guardTelTxtKeyReleased

    private void occupationTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_occupationTxtKeyReleased
        if (guardTxt.getText() != null) {
            notNullValues++;
        } else {
            nextBtn.setEnabled(false);
        }

    }//GEN-LAST:event_occupationTxtKeyReleased

    private void nameTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTxtKeyReleased
        if (nameTxt.getText() != null) {
            notNullValues++;
        }

    }//GEN-LAST:event_nameTxtKeyReleased

    private void guardTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_guardTxtKeyReleased
        if (notNullValues >= 3) {
            nextBtn.setEnabled(true);

        }

    }//GEN-LAST:event_guardTxtKeyReleased

    private void guardTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_guardTxtKeyTyped

    }//GEN-LAST:event_guardTxtKeyTyped

    private void nameTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTxtKeyTyped

    }//GEN-LAST:event_nameTxtKeyTyped

    private void guardTelTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardTelTxtActionPerformed
        save();
    }//GEN-LAST:event_guardTelTxtActionPerformed

    private void guardTelTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_guardTelTxtKeyTyped
        Validation.phoneNumber(guardTelTxt, evt);
    }//GEN-LAST:event_guardTelTxtKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLbl;
    private javax.swing.JTextField addressTxt;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField dayTxt;
    private javax.swing.JLabel dobLbl;
    private javax.swing.JRadioButton femaleBtn;
    private javax.swing.ButtonGroup genderGroup;
    private javax.swing.JLabel genderLbl;
    private javax.swing.JLabel guardLbl;
    private javax.swing.JLabel guardTelLbl;
    private javax.swing.JTextField guardTelTxt;
    private javax.swing.JTextField guardTxt;
    private javax.swing.JLabel idLbl1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton maleBtn;
    private javax.swing.JTextField monthTxt;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JButton nextBtn;
    private javax.swing.JLabel occupationLbl;
    private javax.swing.JTextField occupationTxt;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel relationshipLbl;
    private javax.swing.JTextField relationshipTxt;
    private javax.swing.JTextField stIdTxt;
    private javax.swing.JLabel telLbl;
    private javax.swing.JTextField telTxt;
    private javax.swing.JTextField yearTxt;
    // End of variables declaration//GEN-END:variables
}
