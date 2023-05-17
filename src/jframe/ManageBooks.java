/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.table.TableModel;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author varsh
 */
public class ManageBooks extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    String bookName,author,bookNamee;
    int quantity,bookId;
    DefaultTableModel model;
    
    public ManageBooks() {
        initComponents();
        setBookDetailsToTable();
    }
             public void setBookDetailsToTable(){
                 try{
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");

                  Statement st= con.createStatement();
                  ResultSet rs= st.executeQuery("select*from book_details");
                  
                  while(rs.next()){
                  String bookId = rs.getString("book_id");
                  String bookName =rs.getString("book_name");
                  String author = rs.getString("author");
                  int quantity = rs.getInt("quantity");
                  
                  Object[]obj = {bookId, bookName,author,quantity};
                  model= (DefaultTableModel) tbl_bookDetails.getModel();
                  model.addRow(obj);
                 
                  }
}catch(Exception e){
e.printStackTrace();
}
         }                 
           public boolean addBook(){
               boolean isAdded= false;

           bookId= Integer.parseInt(txt_bookID.getText());
           bookName = txt_bookName.getText();
           author= txt_author.getText();
           quantity=Integer.parseInt(txt_quantity.getText()); 

          try{
          Connection con =DBConnection.getConnection();
          String sql = "insert into book_details values(?,?,?,?)";
          PreparedStatement pst = con.prepareStatement(sql);
          pst.setInt(1,bookId);
          pst.setString(2,bookName);
          pst.setString(3,author);
          pst.setInt(4,quantity);

            int rowCount = pst.executeUpdate();
            if(rowCount>0){
            isAdded = true;
           } else{
             isAdded =false;
          }
           }catch (Exception e){
            e.printStackTrace();
          }
          return isAdded;
}       
           public boolean updateBook(){
          boolean isUpdated= false;

           bookId= Integer.parseInt(txt_bookID.getText());
           bookName = txt_bookName.getText();
           author= txt_author.getText();
           quantity=Integer.parseInt(txt_quantity.getText()); 

           try{
           Connection con = DBConnection.getConnection();
           String sql = "update book_details set book_name=?,author =?,quantity = ? where book_id =?";
           PreparedStatement pst = con.prepareStatement(sql);
          pst.setString(1, bookName);
           pst.setString(2, author);
           pst.setInt(3, quantity);
           pst.setInt(4, bookId);
           

           int rowCount = pst.executeUpdate();
           if(rowCount>0){
           isUpdated = true;
           }else{
           isUpdated =false;
           }
           }catch (Exception e){
           e.printStackTrace();
           }
           return isUpdated;
      }
           
           public boolean deleteBook(){
           boolean isDeleted= false;

           bookId= Integer.parseInt(txt_bookID.getText());
           
           
           try{
           Connection con = DBConnection.getConnection();
           String sql = "delete from book_details where book_id=?"; 
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setInt(1, bookId);

           int rowCount = pst.executeUpdate();
           if(rowCount>0){
           isDeleted = true;
           }else{
           isDeleted =false;
          }
        }catch (Exception e){
         e.printStackTrace();
        }
       return isDeleted;
}     
           public void clearTable(){
          DefaultTableModel model = (DefaultTableModel) tbl_bookDetails.getModel();
          model.setRowCount(0);
}
  
           
           
           public void findBook(){
               String bookNamee = lbl_bookname.getText();
               
               try{
                   Connection con = DBConnection.getConnection();
                    String sql = " select*from book_details where book_name=?";
                    PreparedStatement pst = con.prepareStatement(sql);
   
                    pst.setString(1,bookNamee);
                    
                    ResultSet rs = pst.executeQuery();
                    if(rs.next()){
                        txt_bookID.setText(rs.getString("book_id"));
                        txt_bookName.setText(rs.getString("book_name"));
                        txt_author.setText(rs.getString("author"));
                        txt_quantity.setText(rs.getString("quantity"));
                        lbl_errorr.setText(rs.getString(""));
                    }else{
                        txt_bookID.setText("");
                        txt_bookName.setText("");
                        txt_author.setText("");
                        txt_quantity.setText("");
                        lbl_errorr.setText("book not found");
                    }
                   
               }catch (Exception e){
         e.printStackTrace();
               
           }}
            


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_bookID = new app.bolivia.swing.JCTextField();
        txt_quantity = new app.bolivia.swing.JCTextField();
        txt_bookName = new app.bolivia.swing.JCTextField();
        txt_author = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rSMaterialButtonCircle5 = new rojerusan.RSMaterialButtonCircle();
        lbl_errorr = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle4 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle5 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle6 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle7 = new rojerusan.RSMaterialButtonRectangle();
        lbl_bookname = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Contact_26px.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 30, 50));

        txt_bookID.setBackground(new java.awt.Color(0, 0, 0));
        txt_bookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        txt_bookID.setForeground(new java.awt.Color(255, 255, 255));
        txt_bookID.setPhColor(new java.awt.Color(255, 255, 255));
        txt_bookID.setPlaceholder("enter Book ID...");
        txt_bookID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIDFocusLost(evt);
            }
        });
        jPanel1.add(txt_bookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 280, -1));

        txt_quantity.setBackground(new java.awt.Color(0, 0, 0));
        txt_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        txt_quantity.setForeground(new java.awt.Color(255, 255, 255));
        txt_quantity.setPhColor(new java.awt.Color(255, 255, 255));
        txt_quantity.setPlaceholder("Number of Books...");
        txt_quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_quantityFocusLost(evt);
            }
        });
        txt_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantityActionPerformed(evt);
            }
        });
        jPanel1.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 280, -1));

        txt_bookName.setBackground(new java.awt.Color(0, 0, 0));
        txt_bookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        txt_bookName.setForeground(new java.awt.Color(255, 255, 255));
        txt_bookName.setPhColor(new java.awt.Color(255, 255, 255));
        txt_bookName.setPlaceholder("enter book name...");
        txt_bookName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookNameFocusLost(evt);
            }
        });
        jPanel1.add(txt_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 280, -1));

        txt_author.setBackground(new java.awt.Color(0, 0, 0));
        txt_author.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        txt_author.setForeground(new java.awt.Color(255, 255, 255));
        txt_author.setPhColor(new java.awt.Color(255, 255, 255));
        txt_author.setPlaceholder("enter the name of author...");
        txt_author.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_authorFocusLost(evt);
            }
        });
        jPanel1.add(txt_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 280, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel10.setText("jLabel10");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 30, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jLabel11.setText("jLabel10");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 30, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Unit_26px.png"))); // NOI18N
        jLabel12.setText("jLabel10");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 30, -1));

        jLabel7.setFont(new java.awt.Font("HP Simplified", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Quantity");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 70, -1));

        jLabel9.setFont(new java.awt.Font("HP Simplified", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Enter Book ID");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, 20));

        jLabel13.setFont(new java.awt.Font("HP Simplified", 3, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Enter Book Name");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 120, 20));

        jLabel14.setFont(new java.awt.Font("HP Simplified", 3, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Author Name");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 100, -1));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 0, 51));
        rSMaterialButtonCircle3.setText(" Delete   ");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 520, 640, 60));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(0, 153, 0));
        rSMaterialButtonCircle4.setText("Add");
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, 400, 680, 60));

        jPanel4.setBackground(new java.awt.Color(255, 153, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 5, 50));

        jLabel1.setFont(new java.awt.Font("MV Boli", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 140, 30));

        jLabel2.setFont(new java.awt.Font("MV Boli", 3, 36)); // NOI18N
        jLabel2.setText("Manage Books ");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 270, 50));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 50));

        rSMaterialButtonCircle5.setBackground(new java.awt.Color(51, 0, 255));
        rSMaterialButtonCircle5.setText("Update ");
        rSMaterialButtonCircle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle5ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 460, 580, 60));

        lbl_errorr.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lbl_errorr.setForeground(new java.awt.Color(255, 153, 0));
        jPanel1.add(lbl_errorr, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 250, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 830));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Book Name", "Author", "Quantity "
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(255, 153, 0));
        tbl_bookDetails.setRowHeight(40);
        tbl_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_bookDetails);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 960, 300));

        jLabel3.setFont(new java.awt.Font("HP Simplified", 3, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel3.setText("Directory ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, 50));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(255, 0, 0));
        rSMaterialButtonRectangle2.setText("Log Out");
        rSMaterialButtonRectangle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle2ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle3.setBackground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonRectangle3.setText("Home");
        rSMaterialButtonRectangle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle3ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle4.setBackground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonRectangle4.setText("Student Portal");
        rSMaterialButtonRectangle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle4ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle5.setBackground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonRectangle5.setText("Issue books");
        rSMaterialButtonRectangle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle5ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle6.setBackground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonRectangle6.setText("Return Book");
        rSMaterialButtonRectangle6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle6ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle7.setBackground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonRectangle7.setText("Issued Books");
        rSMaterialButtonRectangle7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSMaterialButtonRectangle3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSMaterialButtonRectangle4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(rSMaterialButtonRectangle5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSMaterialButtonRectangle6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSMaterialButtonRectangle7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMaterialButtonRectangle3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 850, 40));

        lbl_bookname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 153, 0)));
        lbl_bookname.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_bookname.setPhColor(new java.awt.Color(255, 153, 0));
        lbl_bookname.setPlaceholder("enter book name...");
        lbl_bookname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_booknameFocusLost(evt);
            }
        });
        lbl_bookname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_booknameActionPerformed(evt);
            }
        });
        jPanel3.add(lbl_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 420, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Search:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 150, -1));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(0, 153, 255));
        rSMaterialButtonRectangle1.setText("Search");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 190, 150, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 1050, 830));

        setSize(new java.awt.Dimension(1553, 835));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
      HomePage home= new HomePage();
      home.setVisible(true);
      dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_bookIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIDFocusLost

    }//GEN-LAST:event_txt_bookIDFocusLost

    private void txt_quantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantityFocusLost

       
    }//GEN-LAST:event_txt_quantityFocusLost

    private void txt_bookNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookNameFocusLost

    private void txt_authorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_authorFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_authorFocusLost

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
      if (deleteBook()==true){
    JOptionPane.showMessageDialog(this, "Book Deleted Successfully");
    clearTable(); 
    setBookDetailsToTable();
     }else{
     JOptionPane.showMessageDialog(this,"Book Deletion Failed");
     }  // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void txt_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
    if (addBook()==true){
    JOptionPane.showMessageDialog(this, "Book Added Successfully");
    clearTable(); 
    setBookDetailsToTable();
     }else{
     JOptionPane.showMessageDialog(this,"Book Addition Failed");
     }
        
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void rSMaterialButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5ActionPerformed
       if (updateBook()==true){
    JOptionPane.showMessageDialog(this, "Book Updated Successfully");
    clearTable(); 
    setBookDetailsToTable();
}else{
JOptionPane.showMessageDialog(this,"Book Updation Failed");
}
      
    }//GEN-LAST:event_rSMaterialButtonCircle5ActionPerformed

    private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked
                int rowNo =tbl_bookDetails.getSelectedRow();
                TableModel model = tbl_bookDetails.getModel();

                txt_bookID.setText(model.getValueAt(rowNo, 0).toString());
                txt_bookName.setText(model.getValueAt(rowNo,1).toString());
                txt_author.setText(model.getValueAt(rowNo,2).toString());
                txt_quantity.setText(model.getValueAt(rowNo, 3).toString());
     // TODO add your handling code here:
    }//GEN-LAST:event_tbl_bookDetailsMouseClicked

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

    private void rSMaterialButtonRectangle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle5ActionPerformed
        IssueBooks issue = new IssueBooks();
        issue.setVisible(true);
        dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle5ActionPerformed

    private void rSMaterialButtonRectangle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2ActionPerformed
      SignupPage signup = new SignupPage();
        signup.setVisible(true);
        dispose();  // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle2ActionPerformed

    private void rSMaterialButtonRectangle6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle6ActionPerformed
        DeleteBook delete= new DeleteBook();
       delete.setVisible(true);
       dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle6ActionPerformed

    private void rSMaterialButtonRectangle7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle7ActionPerformed
              IssuedBooks issued = new IssuedBooks();
          issued.setVisible(true);
           dispose();          // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle7ActionPerformed

    private void lbl_booknameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_booknameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_booknameFocusLost

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
       findBook();        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void lbl_booknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_booknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_booknameActionPerformed

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
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private app.bolivia.swing.JCTextField lbl_bookname;
    private javax.swing.JLabel lbl_errorr;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle5;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle4;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle5;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle6;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle7;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private app.bolivia.swing.JCTextField txt_author;
    private app.bolivia.swing.JCTextField txt_bookID;
    private app.bolivia.swing.JCTextField txt_bookName;
    private app.bolivia.swing.JCTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
}
