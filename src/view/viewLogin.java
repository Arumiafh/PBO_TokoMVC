/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.controllerLoginKoneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author arumia
 */
public class viewLogin extends javax.swing.JFrame {

    static String user;
    
    /**
     * Creates new form viewLogin
     */
    public viewLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        buttonSignIn = new javax.swing.JButton();
        buttonSignUp = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtextUsername = new javax.swing.JTextField();
        jtextPassword = new javax.swing.JTextField();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 51));
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(null);

        buttonSignIn.setText("Sign In");
        buttonSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSignInActionPerformed(evt);
            }
        });
        jPanel2.add(buttonSignIn);
        buttonSignIn.setBounds(30, 20, 70, 30);

        buttonSignUp.setText("Sign Up");
        buttonSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSignUpActionPerformed(evt);
            }
        });
        jPanel2.add(buttonSignUp);
        buttonSignUp.setBounds(110, 20, 80, 30);

        buttonExit.setText("Exit");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });
        jPanel2.add(buttonExit);
        buttonExit.setBounds(200, 20, 80, 30);

        jPanel3.add(jPanel2);
        jPanel2.setBounds(30, 230, 300, 70);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Username");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 20, 300, 30);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Password");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 100, 300, 30);

        jtextUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jtextUsername);
        jtextUsername.setBounds(60, 50, 180, 30);

        jtextPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtextPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(jtextPassword);
        jtextPassword.setBounds(60, 130, 180, 30);

        jPanel3.add(jPanel1);
        jPanel1.setBounds(30, 30, 300, 190);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 370, 340);

        setBounds(0, 0, 381, 374);
    }// </editor-fold>//GEN-END:initComponents

    private void jtextPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextPasswordActionPerformed

    private void buttonSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSignInActionPerformed
        
        Connection connection; 
        PreparedStatement ps; 
        try { 
                connection = DriverManager.getConnection("jdbc:mysql://localhost/pbo_tokomvc?zeroDateTimeBehavior=convertToNull", "root", ""); 
                ps = connection.prepareStatement("SELECT * FROM `tb_akun` WHERE `username` = ? AND `password` = ?"); 
                ps.setString(1, jtextUsername.getText()); 
                ps.setString(2, jtextPassword.getText()); 
                ResultSet result = ps.executeQuery(); 
                if(result.next())
                { 
                    new viewHome().show(); 
                    user = jtextUsername.getText();
                //perlu deklarasi user diclass utama. 
                    this.dispose(); 
                } 
                else
                { 
                    JOptionPane.showMessageDialog(rootPane, "Salah!"); 
                    jtextPassword.setText(""); 
                    jtextUsername.requestFocus(); 
                } 
            }
            catch (SQLException ex)
            { 
                JOptionPane.showMessageDialog(rootPane,"Gagal!"); 
            }
    }//GEN-LAST:event_buttonSignInActionPerformed

    private void buttonSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSignUpActionPerformed
        
        String username = jtextUsername.getText();
        String password = jtextPassword.getText();
        
        try{
            try(Statement statement = (Statement) controllerLoginKoneksi.GetConnection().createStatement())
            {
            statement.executeUpdate("INSERT INTO tb_akun (username, password) VALUES ('"+username+"','"+password+"');");
            }
            JOptionPane.showMessageDialog(null,"Selamat! Anda berhasil Sign Up!");
    }
        catch(Exception t)
        {
            JOptionPane.showMessageDialog(null, "Mohon maaf, ulangi lagi prosedur!");
        }
        
    }//GEN-LAST:event_buttonSignUpActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        dispose();
    }//GEN-LAST:event_buttonExitActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonSignIn;
    private javax.swing.JButton buttonSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField jtextPassword;
    private javax.swing.JTextField jtextUsername;
    // End of variables declaration//GEN-END:variables
}
