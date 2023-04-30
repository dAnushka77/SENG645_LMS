/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;
import java.sql.Connection;

import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author varsh
 */
public class IssueBooks extends javax.swing.JFrame {

    /**
     * Creates new form IssueBooks
     */
    public IssueBooks() {
        initComponents();
    }
     
    
            public void getBookDetails(){
                int bookId = Integer.parseInt(txt_bookID.getText());

                   try{
                        Connection  con =  DBConnection.getConnection();
                          PreparedStatement pst= con.prepareStatement("select * from book_details where book_id=?");
                           pst.setInt(1,bookId);
                            ResultSet rs = pst.executeQuery();

                                 if(rs.next()){
                                  lbl_bookID.setText(rs.getString("book_id"));
                                    lbl_bookName.setText(rs.getString("book_name"));
                                       lbl_author.setText(rs.getString("author"));
                                        lbl_quantity.setText(rs.getString("quantity"));
                                
                                 }else{
                                      lbl_bookError.setText("invalid  Book ID");
                                 }

                            }catch (Exception e){
                              e.printStackTrace();
                }
            }
            
            
            
            public void getStudentDetails(){
                int studentId = Integer.parseInt(txt_studentID.getText());

                   try{
                        Connection  con =  DBConnection.getConnection();
                          PreparedStatement pst= con.prepareStatement("select * from student_details where student_id=?");
                           pst.setInt(1,studentId);
                            ResultSet rs = pst.executeQuery();

                                 if(rs.next()){
                                  lbl_studentID.setText(rs.getString("student_id"));
                                    lbl_studentName.setText(rs.getString("name"));
                                       lbl_course.setText(rs.getString("course"));
                                        lbl_branch.setText(rs.getString("branch"));
                                } else{
                                     lbl_studentError.setText("invalid  Student ID");
                                 }

                            }catch (Exception e){
                              e.printStackTrace();
                }
            }
            
            
            
             public boolean issueBook(){
                boolean isIssued =false; 
                int bookId = Integer.parseInt(txt_bookID.getText());
                int studentId= Integer.parseInt(txt_studentID.getText());
                 String bookName = lbl_bookName.getText();
                 String studentName = lbl_studentName.getText();

                 Date uIssueDate = date_issueDate.getDatoFecha();
                 Date uDueDate = date_dueDate.getDatoFecha();

                        long l1 = uIssueDate.getTime(); 
                         long l2 = uDueDate.getTime();

                  java.sql.Date sIssueDate = new java.sql.Date(l1);
                  java.sql.Date sDueDate = new java.sql.Date(l2);

                      try{
                             Connection con = DBConnection.getConnection();
                             String sql = "insert into issue_bookdetails(book_id,book_name,student_id,student_name,issue_date,due_Date,status)values(?,?,?,?,?,?,?)";

                              PreparedStatement pst = con.prepareStatement(sql);
                              pst.setInt(1, bookId);
                              pst.setString(2, bookName);
                               pst.setInt(3, studentId);
                                        pst.setString(4, studentName);
                                    pst.setDate(5, sIssueDate);
                                       pst.setDate(6, sDueDate);
                                 pst.setString(7, "pending");

                                    int rowCount = pst.executeUpdate();
                                      if(rowCount>0){
                                           isIssued = true;
                                                    }else{
                                                 isIssued= false;
                                            }
                                           }catch (Exception e){
                                                e.printStackTrace();
                                            }
                                                 return isIssued;
}

public void updateBookCount(){
int bookId = Integer.parseInt(txt_bookID.getText());
try{
Connection con = DBConnection.getConnection();
String sql = " update book_details set quantity = quantity -1 where book_id=?";
PreparedStatement pst =con.prepareStatement(sql);
pst.setInt(1, bookId);

int rowCount = pst.executeUpdate();

if (rowCount>0){
JOptionPane.showMessageDialog(this,"book count updated");
    int initialCount= Integer.parseInt(lbl_quantity.getText());
    lbl_quantity.setText(Integer.toString(initialCount-1));
}else{
JOptionPane.showMessageDialog(this,"can't update book count ");
}}catch (Exception e){
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle4 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle5 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle7 = new rojerusan.RSMaterialButtonRectangle();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_bookID = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl_studentError = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_studentID = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_studentID = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_bookID = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel12 = new javax.swing.JLabel();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel16 = new javax.swing.JLabel();
        rSMaterialButtonRectangle6 = new rojerusan.RSMaterialButtonRectangle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 0));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("HP Simplified Hans", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Issue Books");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, -20, 290, 80));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(255, 0, 0));
        rSMaterialButtonRectangle1.setText("Log out ");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, -10, 120, -1));

        jLabel2.setFont(new java.awt.Font("MV Boli", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 140, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 80));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle2.setText("Issued Books");

        rSMaterialButtonRectangle3.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle3.setText("Home");
        rSMaterialButtonRectangle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle3ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle4.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle4.setText("Student Portal");
        rSMaterialButtonRectangle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle4ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle5.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle5.setText("Manage books");
        rSMaterialButtonRectangle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle5ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle7.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle7.setText("Return Book");
        rSMaterialButtonRectangle7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSMaterialButtonRectangle3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSMaterialButtonRectangle5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSMaterialButtonRectangle4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSMaterialButtonRectangle7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 700, 40));

        jPanel5.setBackground(new java.awt.Color(255, 102, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("HP Simplified", 3, 36)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel3.setText("Book Details");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 310, -1));

        lbl_bookError.setFont(new java.awt.Font("HP Simplified Hans", 2, 24)); // NOI18N
        jPanel5.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 220, 30));

        lbl_quantity.setFont(new java.awt.Font("HP Simplified Hans", 2, 24)); // NOI18N
        jPanel5.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 200, 30));

        jLabel7.setFont(new java.awt.Font("HP Simplified Hans", 2, 24)); // NOI18N
        jLabel7.setText("   Book Name:");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 150, -1));

        jLabel8.setFont(new java.awt.Font("HP Simplified Hans", 2, 24)); // NOI18N
        jLabel8.setText("   Author :");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 120, -1));

        jLabel9.setFont(new java.awt.Font("HP Simplified Hans", 2, 24)); // NOI18N
        jLabel9.setText("    Book ID:");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 140, -1));

        lbl_bookID.setFont(new java.awt.Font("HP Simplified Hans", 2, 24)); // NOI18N
        jPanel5.add(lbl_bookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 210, 30));

        lbl_bookName.setFont(new java.awt.Font("HP Simplified Hans", 2, 24)); // NOI18N
        jPanel5.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 200, 30));

        lbl_author.setFont(new java.awt.Font("HP Simplified Hans", 2, 24)); // NOI18N
        jPanel5.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 190, 30));

        jLabel18.setFont(new java.awt.Font("HP Simplified Hans", 2, 24)); // NOI18N
        jLabel18.setText("  Quantity: ");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 120, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 380, 470));

        jPanel6.setBackground(new java.awt.Color(153, 0, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_studentError.setFont(new java.awt.Font("HP Simplified Hans", 2, 24)); // NOI18N
        jPanel6.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 220, 30));

        jLabel14.setFont(new java.awt.Font("HP Simplified Hans", 2, 24)); // NOI18N
        jLabel14.setText("    Course :");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 280, 110, -1));

        jLabel15.setFont(new java.awt.Font("HP Simplified Hans", 2, 24)); // NOI18N
        jLabel15.setText("    Student Name :");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 230, 190, -1));

        lbl_branch.setFont(new java.awt.Font("HP Simplified Hans", 2, 24)); // NOI18N
        jPanel6.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 170, 30));

        jLabel17.setFont(new java.awt.Font("HP Simplified Hans", 2, 24)); // NOI18N
        jLabel17.setText("     Student ID :");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 180, 180, -1));

        lbl_course.setFont(new java.awt.Font("HP Simplified Hans", 2, 24)); // NOI18N
        jPanel6.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 200, 30));

        lbl_studentName.setFont(new java.awt.Font("HP Simplified Hans", 2, 24)); // NOI18N
        lbl_studentName.setText("      ");
        jPanel6.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 180, -1));

        lbl_studentID.setFont(new java.awt.Font("HP Simplified Hans", 2, 24)); // NOI18N
        jPanel6.add(lbl_studentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 180, 30));

        jLabel6.setFont(new java.awt.Font("HP Simplified", 3, 36)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel6.setText("Student Details ");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel19.setFont(new java.awt.Font("HP Simplified Hans", 2, 24)); // NOI18N
        jLabel19.setText("    Branch :");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 330, 120, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 380, 470));

        jLabel4.setFont(new java.awt.Font("HP Simplified", 3, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel4.setText("Issue Book ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 190, -1, -1));

        txt_studentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 102, 0)));
        txt_studentID.setPlaceholder("Please enter Student ID .");
        txt_studentID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIDFocusLost(evt);
            }
        });
        txt_studentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIDActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 340, 240, -1));

        jLabel10.setFont(new java.awt.Font("HP Simplified", 2, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 102, 51));
        jLabel10.setText("Due Date:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 470, 120, -1));

        txt_bookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 102, 0)));
        txt_bookID.setPlaceholder("Please enter Book ID...");
        txt_bookID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIDFocusLost(evt);
            }
        });
        txt_bookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIDActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 280, 240, -1));

        jLabel11.setFont(new java.awt.Font("HP Simplified", 2, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 102, 51));
        jLabel11.setText("Book ID:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 280, 90, -1));

        date_issueDate.setColorBackground(new java.awt.Color(255, 102, 0));
        date_issueDate.setPlaceholder("mm/dd/yyyy");
        jPanel1.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 400, -1, -1));

        jLabel12.setFont(new java.awt.Font("HP Simplified", 2, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 102, 51));
        jLabel12.setText(" Student ID: ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 340, 120, -1));

        date_dueDate.setColorBackground(new java.awt.Color(255, 102, 0));
        date_dueDate.setPlaceholder("mm/dd/yyyy");
        jPanel1.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 470, -1, -1));

        jLabel16.setFont(new java.awt.Font("HP Simplified", 2, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 102, 51));
        jLabel16.setText("Issue Date:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 410, 120, -1));

        rSMaterialButtonRectangle6.setBackground(new java.awt.Color(255, 102, 0));
        rSMaterialButtonRectangle6.setBorder(new javax.swing.border.MatteBorder(null));
        rSMaterialButtonRectangle6.setForeground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonRectangle6.setText("Issue Book ");
        rSMaterialButtonRectangle6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle6ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 540, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 660));

        setSize(new java.awt.Dimension(1273, 666));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        SignupPage signup= new SignupPage();
    signup.setVisible(true);
    dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void rSMaterialButtonRectangle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle5ActionPerformed
       ManageBooks books= new ManageBooks();
       books.setVisible(true);
       dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle5ActionPerformed

    private void rSMaterialButtonRectangle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3ActionPerformed
      HomePage home= new HomePage();
      home.setVisible(true);
      dispose();// TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle3ActionPerformed

    private void rSMaterialButtonRectangle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4ActionPerformed
       ManageStudents student= new ManageStudents();
       student.setVisible(true);
       dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle4ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        HomePage home= new HomePage();
        home.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt_studentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIDActionPerformed

    private void txt_bookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIDActionPerformed
     
    }//GEN-LAST:event_txt_bookIDActionPerformed
    
    private void txt_bookIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIDFocusLost
    if(!txt_bookID.getText().equals("")){
        getBookDetails();
}      
    }//GEN-LAST:event_txt_bookIDFocusLost

    private void txt_studentIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIDFocusLost
      if(!txt_studentID.getText().equals("")){
        getStudentDetails();  // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIDFocusLost
    }
    private void rSMaterialButtonRectangle6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle6ActionPerformed
    if(issueBook()==true){
     JOptionPane.showMessageDialog(this, "BOOK ISSUED SUCCESSFULLY!!!");
     updateBookCount();
    }else{
        JOptionPane.showMessageDialog(this, "BOOK ISSUE Failed!!!");
    }

    }//GEN-LAST:event_rSMaterialButtonRectangle6ActionPerformed

    private void rSMaterialButtonRectangle7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle7ActionPerformed
        IssueBooks issue = new IssueBooks();
        issue.setVisible(true);
        dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle7ActionPerformed
    
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
            java.util.logging.Logger.getLogger(IssueBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookID;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentID;
    private javax.swing.JLabel lbl_studentName;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle4;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle5;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle6;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle7;
    private app.bolivia.swing.JCTextField txt_bookID;
    private app.bolivia.swing.JCTextField txt_studentID;
    // End of variables declaration//GEN-END:variables
}
