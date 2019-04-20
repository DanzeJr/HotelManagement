package hotel.views;

import hotel.daos.StaffDAO;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danze
 */
public class LoginJFrame extends javax.swing.JFrame {
    
    /**
     * Creates new form LoginJFrame
     */
    public LoginJFrame() {
        initComponents();
        setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        llblPassword = new javax.swing.JLabel();
        llblUsername = new javax.swing.JLabel();
        lbtnLogin = new javax.swing.JButton();
        llblMsgU = new javax.swing.JLabel();
        llblMsgP = new javax.swing.JLabel();
        ltxtUsername = new javax.swing.JTextField();
        ltxtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Quản Lý Khách Sạn");

        lblLogin.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(51, 153, 255));
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setText("Đăng nhập");

        llblPassword.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        llblPassword.setText("Mật khẩu:");

        llblUsername.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        llblUsername.setText("Mã nhân viên:");

        lbtnLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbtnLogin.setForeground(new java.awt.Color(0, 153, 255));
        lbtnLogin.setText("Đăng nhập");
        lbtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbtnLoginActionPerformed(evt);
            }
        });

        llblMsgU.setForeground(new java.awt.Color(255, 51, 0));

        llblMsgP.setForeground(new java.awt.Color(255, 51, 0));

        ltxtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ltxtUsernameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ltxtUsernameKeyReleased(evt);
            }
        });

        ltxtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ltxtPasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ltxtPasswordKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(llblUsername)
                    .addComponent(llblPassword))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(llblMsgU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(llblMsgP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ltxtUsername)
                    .addComponent(ltxtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(lbtnLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(llblUsername)
                    .addComponent(ltxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(llblMsgU, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(llblPassword)
                    .addComponent(ltxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(llblMsgP, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(lbtnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void login() {
        String id = ltxtUsername.getText().toLowerCase();        
        String password = new String(ltxtPassword.getPassword());
        
        if (id.isEmpty())
            llblMsgU.setText("Mã nhân viên không được bỏ trống");
        else {
            llblMsgU.setText("");
        }
        if (password.isEmpty())
            llblMsgP.setText("Mật khẩu không được bỏ trống");
        
        boolean valid = llblMsgU.getText().isEmpty() && llblMsgP.getText().isEmpty();
        
        if (valid) {
            try {
                StaffDAO dao = new StaffDAO();
                boolean check = dao.checkLogin(id, password);
                if (check) {
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                    new StaffJFrame(id).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không đúng!");
                }
            } catch (Exception e) {
                Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
            
    private void lbtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbtnLoginActionPerformed
        login();
    }//GEN-LAST:event_lbtnLoginActionPerformed

    private void ltxtUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ltxtUsernameKeyReleased
        String id = ltxtUsername.getText();
        if (id.isEmpty())
            llblMsgU.setText("Mã nhân viên không được bỏ trống");
        else
            llblMsgU.setText("");
    }//GEN-LAST:event_ltxtUsernameKeyReleased

    private void ltxtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ltxtPasswordKeyReleased
        String password = new String(ltxtPassword.getPassword());
        if (password.isEmpty())
            llblMsgP.setText("Mật khẩu không được bỏ trống");
        else
            llblMsgP.setText("");
    }//GEN-LAST:event_ltxtPasswordKeyReleased

    private void ltxtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ltxtUsernameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            login();
    }//GEN-LAST:event_ltxtUsernameKeyPressed

    private void ltxtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ltxtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            login();
    }//GEN-LAST:event_ltxtPasswordKeyPressed

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
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JButton lbtnLogin;
    private javax.swing.JLabel llblMsgP;
    private javax.swing.JLabel llblMsgU;
    private javax.swing.JLabel llblPassword;
    private javax.swing.JLabel llblUsername;
    private javax.swing.JPasswordField ltxtPassword;
    private javax.swing.JTextField ltxtUsername;
    // End of variables declaration//GEN-END:variables
}
