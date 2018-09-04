/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.border.LineBorder;

/**
 *
 * @author Randula
 */
public class RegisterStudent extends javax.swing.JFrame {

    /**
     * Creates new form RegisterStudent
     */
    public RegisterStudent() {
        initComponents();
        Registrations f1 = new Registrations();
        panel.removeAll();
        f1.setSize(panel.getSize());
        Component add = panel.add(f1);
        panel.repaint();
        panel.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        quickRegistrationLbl = new javax.swing.JLabel();
        registerStudentLbl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        changeRegistrationLbl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        searchStudentLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setLayout(null);

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setPreferredSize(new java.awt.Dimension(900, 630));
        panel2.setLayout(null);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background2.png"))); // NOI18N
        panel2.add(jLabel10);
        jLabel10.setBounds(0, 90, 835, 520);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panel.add(jPanel2);
        jPanel2.setBounds(0, 0, 900, 630);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background2.png"))); // NOI18N
        panel.add(jLabel2);
        jLabel2.setBounds(0, 82, 835, 528);

        jPanel1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 900, 630));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Register Students");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 120, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Quick Registrations");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 120, 50));

        quickRegistrationLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        quickRegistrationLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/labelSize.png"))); // NOI18N
        quickRegistrationLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        quickRegistrationLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quickRegistrationLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quickRegistrationLblMouseClicked(evt);
            }
        });
        jPanel1.add(quickRegistrationLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 210, 50));

        registerStudentLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        registerStudentLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/labelSize.png"))); // NOI18N
        registerStudentLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        registerStudentLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerStudentLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerStudentLblMouseClicked(evt);
            }
        });
        jPanel1.add(registerStudentLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 210, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Change Registration Details");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 170, 50));

        changeRegistrationLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        changeRegistrationLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/labelSize.png"))); // NOI18N
        changeRegistrationLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        changeRegistrationLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        changeRegistrationLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeRegistrationLblMouseClicked(evt);
            }
        });
        jPanel1.add(changeRegistrationLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 210, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Search Students");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 140, 50));

        searchStudentLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchStudentLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/labelSize.png"))); // NOI18N
        searchStudentLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        searchStudentLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchStudentLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchStudentLblMouseClicked(evt);
            }
        });
        jPanel1.add(searchStudentLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 210, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1160, 596));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void quickRegistrationLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quickRegistrationLblMouseClicked
        GetDetails f1 = new GetDetails();
        panel.removeAll();
        f1.setSize(panel.getSize());
        Component add = panel.add(f1);
        panel.repaint();
        panel.revalidate();

        quickRegistrationLbl.setBorder(new LineBorder(Color.orange, 3));
        registerStudentLbl.setBorder(new LineBorder(new Color(204, 0, 0), 1));
        changeRegistrationLbl.setBorder(new LineBorder(new Color(204, 0, 0), 1));
        searchStudentLbl.setBorder(new LineBorder(new Color(204, 0, 0), 1));


    }//GEN-LAST:event_quickRegistrationLblMouseClicked

    private void registerStudentLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerStudentLblMouseClicked
        Registrations f1 = new Registrations();
        panel.removeAll();
        f1.setSize(panel.getSize());
        Component add = panel.add(f1);
        panel.repaint();
        panel.revalidate();

        registerStudentLbl.setBorder(new LineBorder(Color.orange, 3));
        quickRegistrationLbl.setBorder(new LineBorder(new Color(204, 0, 0), 1));
        changeRegistrationLbl.setBorder(new LineBorder(new Color(204, 0, 0), 1));
        searchStudentLbl.setBorder(new LineBorder(new Color(204, 0, 0), 1));
    }//GEN-LAST:event_registerStudentLblMouseClicked

    private void changeRegistrationLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeRegistrationLblMouseClicked
        ChangeRegistration f1 = new ChangeRegistration();
        panel.removeAll();
        f1.setSize(panel.getSize());
        Component add = panel.add(f1);
        panel.repaint();
        panel.revalidate();

        changeRegistrationLbl.setBorder(new LineBorder(Color.orange, 3));
        registerStudentLbl.setBorder(new LineBorder(new Color(204, 0, 0), 1));
        quickRegistrationLbl.setBorder(new LineBorder(new Color(204, 0, 0), 1));
        searchStudentLbl.setBorder(new LineBorder(new Color(204, 0, 0), 1));
    }//GEN-LAST:event_changeRegistrationLblMouseClicked

    private void searchStudentLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchStudentLblMouseClicked
        ManageStudent f1 = new ManageStudent();
        panel.removeAll();
        f1.setSize(panel.getSize());
        Component add = panel.add(f1);
        panel.repaint();
        panel.revalidate();

        searchStudentLbl.setBorder(new LineBorder(Color.orange, 3));
        registerStudentLbl.setBorder(new LineBorder(new Color(204, 0, 0), 1));
        changeRegistrationLbl.setBorder(new LineBorder(new Color(204, 0, 0), 1));
        quickRegistrationLbl.setBorder(new LineBorder(new Color(204, 0, 0), 1));
    }//GEN-LAST:event_searchStudentLblMouseClicked

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
            java.util.logging.Logger.getLogger(RegisterStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel changeRegistrationLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel2;
    private javax.swing.JLabel quickRegistrationLbl;
    private javax.swing.JLabel registerStudentLbl;
    private javax.swing.JLabel searchStudentLbl;
    // End of variables declaration//GEN-END:variables
}