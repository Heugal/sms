package studentmanagementsystem.menu;

import studentmanagementsystem.managers.ItemManager;
import studentmanagementsystem.beans.ItemBean;
import studentmanagementsystem.menu.createStudentMenu;
import studentmanagementsystem.menu.deleteStudentMenu;
import studentmanagementsystem.menu.editStudentMenu;
import studentmanagementsystem.menu.studentHistoryMenu;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Blob;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import studentmanagementsystem.SanitizeInputs;
import static studentmanagementsystem.menu.createStudentMenu.resize;

public class Item extends javax.swing.JFrame {
    private ResultSet rs;
    ItemBean item = new ItemBean();
    ImageIcon icon = null;
    String fileName = ".\\temp.dat";
    /**
     * Creates new form NewJFrame
     */
    public Item() {
        super("Student Database");
        initComponents();
        
        try{
            rs = ItemManager.getItems();
        } catch(SQLException ex){
            System.err.println(ex);
        }
    }
    
    public void displayStudentItem() throws SQLException, FileNotFoundException, IOException{
        int studentID = item.getStudentID();
        String firstName = item.getFirstName();
        String lastName = item.getLastName();
        String dob = item.getDOB();
        String address = item.getAddress();
        String phone = item.getPhone();
        String email = item.getEmail();
        Blob picture = ItemManager.getPicture(studentID);
        if (picture != null){
            item.setPicture(picture);
            createImage(picture);
            try {
                File file = new File(fileName);
                BufferedImage image = ImageIO.read(file);
                BufferedImage resizedImage=resize(image,164,161);
                icon = new ImageIcon(resizedImage);
            } catch (IOException ex) {
                Logger.getLogger(createStudentMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            studentPic.setIcon(icon);
        }
        else
            studentPic.setIcon(null);
        
        String HTMLEntity = "<html><style>body{font-family: Arial}</style><body><p>Student ID: "+studentID
                +"</p><p>First Name: "+firstName
                +"</p><p>Last Name: "+lastName
                +"</p><p>DOB: "+dob
                +"</p><p>Address: "+address
                +"</p><p>Phone: "+phone
                +"</p><p>Email: "+email
                +"</p></body></html>";
        
        jTextPane1.setContentType("text/html");
        jTextPane1.setText(HTMLEntity);
    }
    
    public void createImage(Blob picture) throws SQLException, FileNotFoundException, IOException{
        InputStream in = picture.getBinaryStream();
        FileOutputStream outstream = new FileOutputStream(fileName);
        int bufferSize = 1024;
        int length = (int) picture.length();
        byte[] buffer = new byte[bufferSize];
        while((length = in.read(buffer)) != -1){
            outstream.write(buffer,0,length);
        }
        in.close();
        outstream.close();
    }
    
    public void setItem(ResultSet rs){
        DateFormat df = new SimpleDateFormat("MM/dd/yy");
        try{
            item.setStudentID(rs.getInt("student_id"));
            item.setFirstName(rs.getString("first_name"));
            item.setLastName(rs.getString("last_name"));
            item.setDOB(df.format(rs.getDate("dob")));
            item.setAddress(rs.getString("address"));
            item.setPhone(rs.getString("phone"));
            item.setEmail(rs.getString("email"));
            
        } catch(SQLException ex){
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        firstNameTxtField = new javax.swing.JTextField();
        lastNameTxtField = new javax.swing.JTextField();
        studentIDTxtField = new javax.swing.JTextField();
        firstBtn = new javax.swing.JButton();
        previousBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        lastBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        studentPic = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        historyMenu = new javax.swing.JMenu();
        editMenu = new javax.swing.JMenu();
        deleteStudentMenu = new javax.swing.JMenuItem();
        editStudentMenu = new javax.swing.JMenuItem();
        createStudentMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("First Name:");

        jLabel2.setText("Last Name:");

        searchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student ID", "First Name", "Last Name", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(searchTable);

        jLabel3.setText("Student ID:");

        firstNameTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTxtFieldActionPerformed(evt);
            }
        });

        firstBtn.setText("First");
        firstBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstBtnActionPerformed(evt);
            }
        });

        previousBtn.setText("Previous");
        previousBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousBtnActionPerformed(evt);
            }
        });

        nextBtn.setText("Next");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        lastBtn.setText("Last");
        lastBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Student search");

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        studentPic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jScrollPane2.setViewportView(jTextPane1);

        jScrollPane3.setViewportView(jTextPane2);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Student Information");

        historyMenu.setText("User History");
        historyMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(historyMenu);

        editMenu.setText("Edit");

        deleteStudentMenu.setText("Delete Student");
        deleteStudentMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStudentMenuActionPerformed(evt);
            }
        });
        editMenu.add(deleteStudentMenu);

        editStudentMenu.setText("Edit Student");
        editStudentMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editStudentMenuActionPerformed(evt);
            }
        });
        editMenu.add(editStudentMenu);

        createStudentMenu.setText("Add Student");
        createStudentMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createStudentMenuActionPerformed(evt);
            }
        });
        editMenu.add(createStudentMenu);

        jMenuBar1.add(editMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(firstNameTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(lastNameTxtField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(studentIDTxtField, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(firstBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(previousBtn))
                            .addComponent(jScrollPane3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lastBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(studentPic, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2))
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(113, 113, 113))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(firstNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(lastNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(studentIDTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentPic, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstBtn)
                            .addComponent(previousBtn)
                            .addComponent(nextBtn)
                            .addComponent(lastBtn))
                        .addGap(25, 25, 25))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstNameTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTxtFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        boolean allSearch = true;
        DefaultTableModel userTableModel = 
                new DefaultTableModel( new Object[]{ "Student_id", "first_name", "last_name", "email" }, 0 );
        String sql;
        ResultSet search;
        String tempIDString = SanitizeInputs.removeNonDigitFromIDString(studentIDTxtField.getText());
        int studentID = (tempIDString.equals("")) ? 0 : Integer.parseInt(studentIDTxtField.getText());
        String firstName = SanitizeInputs.sanitizeInputString(firstNameTxtField.getText());
        String lastName = SanitizeInputs.sanitizeInputString(lastNameTxtField.getText());
        
        if ((studentID > 0) || (!firstName.equals("")) || (!lastName.equals(""))){
            allSearch = false;
            sql = "select * from students where ";
            int check = 0;
            if (studentID > 0){
                sql = sql+"student_id =" + studentID;
                check++;
            }
            if (!firstName.equals("")){
                sql = (check > 0) ? sql+" and upper(first_name) = upper('" + firstName+"')" :
                        sql+"upper(first_name) = upper('"+firstName+"')";
                check++;
            }
            if (!lastName.equals("")){
                sql = (check > 0) ? sql+" and upper(last_name) = upper('" + lastName + "')" :
                        sql+"upper(last_name) = upper('" + lastName +"')";
            }
        }
        else{
            sql = "select * from students";
        }
        try {
            search = ItemManager.getSearchItems(sql);
            if (search != null){
                while(search.next()){
                    Vector<Object> vector = new Vector<>();
                    setItem(search);
                    vector.add(item.getStudentID());
                    vector.add(item.getFirstName());
                    vector.add(item.getLastName());
                    vector.add(item.getEmail());
                    userTableModel.addRow(vector);
                }
                searchTable.setModel(userTableModel);
                try{
                    if (false == allSearch)
                        this.rs = search;
                    if (rs.first()){
                        setItem(this.rs);
                        displayStudentItem();
                    } 
                    else
                        JOptionPane.showMessageDialog(null, "Can't move to first");
                } catch(SQLException ex){
                    System.err.println(ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_searchButtonActionPerformed

    private void firstBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstBtnActionPerformed
        try{
            if (rs.first()){
                setItem(this.rs);
                displayStudentItem();
                nextBtn.setEnabled(true);
                previousBtn.setEnabled(false);
            } 
            else{
                JOptionPane.showMessageDialog(null, "Can't move to first");
            }
        } catch(SQLException ex){
            System.err.println(ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_firstBtnActionPerformed

    private void previousBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousBtnActionPerformed
        try {
            if(rs.previous())
            {
                setItem(this.rs);
                displayStudentItem();
                nextBtn.setEnabled(true);
            }
            else
            {
                rs.next();
                previousBtn.setEnabled(false);
                JOptionPane.showMessageDialog(null, "start of table.");
            }
                
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_previousBtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        try {
            if(rs.next())
            {
                setItem(this.rs);
                displayStudentItem();
                previousBtn.setEnabled(true);
            }
            else
            {
                rs.previous();
                nextBtn.setEnabled(false);
                JOptionPane.showMessageDialog(null, "End of table.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nextBtnActionPerformed

    private void lastBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastBtnActionPerformed
        try{
            if(rs.last())
            {
                setItem(this.rs);
                displayStudentItem();
                nextBtn.setEnabled(false);
                previousBtn.setEnabled(true);
            }
            else
            {
                 JOptionPane.showMessageDialog(null, "Can't move to first");
            }
        }catch(SQLException ex)
        {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lastBtnActionPerformed

    private void deleteStudentMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStudentMenuActionPerformed
        deleteStudentMenu deleteMenu = new deleteStudentMenu();
        deleteMenu.setLocation(100,100);
        deleteMenu.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_deleteStudentMenuActionPerformed

    private void editStudentMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editStudentMenuActionPerformed
        editStudentMenu editMenu = new editStudentMenu();
        editMenu.setLocation(100, 100);
        editMenu.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_editStudentMenuActionPerformed

    private void createStudentMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createStudentMenuActionPerformed
        createStudentMenu createMenu = new createStudentMenu();
        createMenu.setLocation(100,100);
        createMenu.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_createStudentMenuActionPerformed

    private void historyMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyMenuMouseClicked
        studentHistoryMenu studentHistoryMenu = new studentHistoryMenu();
        studentHistoryMenu.setLocation(100,100);
        studentHistoryMenu.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_historyMenuMouseClicked

    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem createStudentMenu;
    private javax.swing.JMenuItem deleteStudentMenu;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem editStudentMenu;
    private javax.swing.JButton firstBtn;
    private javax.swing.JTextField firstNameTxtField;
    private javax.swing.JMenu historyMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JButton lastBtn;
    private javax.swing.JTextField lastNameTxtField;
    private javax.swing.JButton nextBtn;
    private javax.swing.JButton previousBtn;
    private javax.swing.JButton searchButton;
    private javax.swing.JTable searchTable;
    private javax.swing.JTextField studentIDTxtField;
    private javax.swing.JLabel studentPic;
    // End of variables declaration//GEN-END:variables
}
