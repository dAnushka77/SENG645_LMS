/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax. swing.*;
import static jframe.DBConnection.con;
import java.sql.ResultSet;

/**
 *
 * @author varsh
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form SignupPage
     */
    public LoginPage() {
        initComponents();
    }
         public boolean validateLogin(){
             String name = txt_name.getText();
             String pwd  = txt_pwd.getText();
       
                         if(name.equals("")){
                             JOptionPane.showMessageDialog(this,"Please enter username");
                             return false;
                                     
                         }if(pwd.equals("")){
                             JOptionPane.showMessageDialog(this,"Please enter password");
                             return false;
                         }
                         return true;
             }
             
         
         
         public void Login(){
             String name = txt_name.getText();
             String pwd  = txt_pwd.getText();
             
             try{
            Class.forName("com.mysql.cj.jdbc.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
                PreparedStatement pst = con.prepareStatement("Select * from users where name = ? and pwd = ?");
                
                pst.setString(1, name);
                pst.setString(2 , pwd);
                 
                ResultSet rs= pst.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(this,"Login Successful!!!");
                    
                    HomePage home= new HomePage();
                    home.setVisible(true);
                    this.dispose();
                    
                }else{
                    JOptionPane.showMessageDialog(this,"Invalid Credentials!!!");
                }
                    
                
                        }catch (Exception e){
                 e.printStackTrace();
        }
   
             
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_name = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_pwd = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("HP Simplified", 3, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("University of Maryland, Baltimore County ");
        jLabel1.setAutoscrolls(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 900, 50));

        jLabel2.setFont(new java.awt.Font("HP Simplified", 3, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Advance Library Management System");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 780, 70));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/library-book-bookshelf-read.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 880, 330));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Library-Automation-01.png"))); // NOI18N
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 290));

        jLabel16.setForeground(new java.awt.Color(232, 0, 0));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/umb.png"))); // NOI18N
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 400, 370));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 1350));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Dawgs-Eye-View-Retriever19-6895-scaled.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-950, -240, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 830));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("HP Simplified", 3, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Log In ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("HP Simplified", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Log In to Your Account Here...");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 380, -1));

        jLabel7.setFont(new java.awt.Font("HP Simplified", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Username ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 50, -1));

        txt_name.setBackground(new java.awt.Color(0, 0, 0));
        txt_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        txt_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_name.setPhColor(new java.awt.Color(255, 255, 255));
        txt_name.setPlaceholder("enter username...");
        txt_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nameFocusLost(evt);
            }
        });
        jPanel2.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        jLabel9.setFont(new java.awt.Font("HP Simplified", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Password");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 70, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secure_50px.png"))); // NOI18N
        jLabel10.setText("jLabel10");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 50, -1));

        txt_pwd.setBackground(new java.awt.Color(0, 0, 0));
        txt_pwd.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        txt_pwd.setForeground(new java.awt.Color(255, 255, 255));
        txt_pwd.setPhColor(new java.awt.Color(255, 255, 255));
        txt_pwd.setPlaceholder("enter password...");
        jPanel2.add(txt_pwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 0, 51));
        rSMaterialButtonCircle1.setText("Sign Up ");
        rSMaterialButtonCircle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle1MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 280, 60));

        rSMaterialButtonCircle2.setText("Log In ");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 280, 60));

        jLabel15.setFont(new java.awt.Font("HP Simplified", 3, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("or");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 20, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, 640, 890));

        setSize(new java.awt.Dimension(1523, 835));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
    
       
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void txt_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nameFocusLost
        
        
    }//GEN-LAST:event_txt_nameFocusLost
    
    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
      if(validateLogin()){
        Login();  
      }
          // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed
    
    private void rSMaterialButtonCircle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1MouseClicked
         SignupPage signup= new SignupPage();
         signup.setVisible(true);
         dispose();// TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle1MouseClicked
      
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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_name;
    private app.bolivia.swing.JCTextField txt_pwd;
    // End of variables declaration//GEN-END:variables
}
