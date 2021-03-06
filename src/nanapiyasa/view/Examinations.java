/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nanapiyasa.view;

import java.awt.Component;
import java.awt.HeadlessException;

/**
 *
 * @author Randula
 */
public class Examinations extends javax.swing.JFrame {

    /**
     * Creates new form Examinations
     */
    public Examinations() {
        initComponents();
    }

    public Examinations(String title) throws HeadlessException {
        initComponents();
        if (title == "ViewExam") {
            viewAllExams();
        }
        if (title == "ViewResult") {
            viewAllResult();
        }
        if (title == "ReleaseCertificate") {
            releaseCertificate();
        }
        if (title == "ManageMarks") {
            manageMarks();
        }
    }

    public void viewAllExams() {
        ViewAllExaminations f1 = new ViewAllExaminations();
        panel.removeAll();
        f1.setSize(panel.getSize());
        Component add = panel.add(f1);
        panel.repaint();
        panel.revalidate();
    }

    public void viewAllResult() {
        ViewAllResult f1 = new ViewAllResult();
        panel.removeAll();
        f1.setSize(panel.getSize());
        Component add = panel.add(f1);
        panel.repaint();
        panel.revalidate();
    }

    public void releaseCertificate() {
        ReleaseCertificate f1 = new ReleaseCertificate();
        panel.removeAll();
        f1.setSize(panel.getSize());
        Component add = panel.add(f1);
        panel.repaint();
        panel.revalidate();
    }

    public void manageMarks() {
        ManageMark f1 = new ManageMark();
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
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Examinations");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setLayout(null);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nanapiyasa/view/Images/background2.png"))); // NOI18N
        panel.add(jLabel16);
        jLabel16.setBounds(0, 0, 900, 630);

        jPanel1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 630));

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
            java.util.logging.Logger.getLogger(Examinations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Examinations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Examinations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Examinations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Examinations().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
