package studentmanagementsystem.menu;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import studentmanagementsystem.ConnectDB;
import studentmanagementsystem.managers.ItemManager;
import studentmanagementsystem.SanitizeInputs;

public class createStudentMenu extends javax.swing.JFrame {
    ImageIcon icon = null;
    String fileName;
    /**
     * Creates new form createStudentMenu
     */
    public createStudentMenu() {
        super("Create Student Menu");
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550,450);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelBtn = new javax.swing.JButton();
        createBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        addressTxtField = new javax.swing.JTextField();
        phoneTxtField = new javax.swing.JTextField();
        emailTxtField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dobTxtField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lastNameTxtField = new javax.swing.JTextField();
        firstNameTxtField = new javax.swing.JTextField();
        studentImageLbl = new javax.swing.JLabel();

        cancelBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        createBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        createBtn.setText("Save");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Create Student");

        jLabel5.setText("Enter student's credentials");

        jLabel7.setText("Address:");

        jLabel8.setText("Phone:");

        jLabel9.setText("Email:");

        addressTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTxtFieldActionPerformed(evt);
            }
        });

        jLabel6.setText("Date of Birth:");

        jLabel2.setText("First Name:");

        jLabel10.setText("Last Name:");

        studentImageLbl.setBackground(new java.awt.Color(204, 204, 255));
        studentImageLbl.setForeground(new java.awt.Color(51, 51, 255));
        studentImageLbl.setText("       Student Image");
        studentImageLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        studentImageLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentImageLblMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)))
                            .addGap(42, 42, 42)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(phoneTxtField)
                                    .addComponent(addressTxtField)
                                    .addComponent(emailTxtField)
                                    .addComponent(dobTxtField)
                                    .addComponent(lastNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(firstNameTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentImageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(firstNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lastNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(studentImageLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dobTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(createBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        Item item = new Item();
        item.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        String firstName = SanitizeInputs.sanitizeInputString(firstNameTxtField.getText());
        String lastName = SanitizeInputs.sanitizeInputString(lastNameTxtField.getText());
        String address = SanitizeInputs.sanitizeInputString(addressTxtField.getText());
        String phone = SanitizeInputs.sanitizeInputString(phoneTxtField.getText());
        String email = SanitizeInputs.sanitizeInputString(emailTxtField.getText());
        String dob = SanitizeInputs.sanitizeInputString(dobTxtField.getText());
        int studentID;
        if ((!firstName.equals("")) && (!lastName.equals("")) && (!address.equals(""))
                && (!phone.equals("")) && (!email.equals("")) && (!dob.equals(""))){
            Connection conn = null;
            CallableStatement stmt = null;
            ResultSet rs = null;
            String statement_call = "{call INSERT_NEW_STUDENT(?, ?, ?, ?, ?, ?)}";
            try {
                conn = ConnectDB.getConnection();
                stmt = conn.prepareCall(statement_call, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                stmt.setString(1, firstName);
                stmt.setString(2, lastName);
                stmt.setString(3, dob);
                stmt.setString(4, address);
                stmt.setString(5, phone);
                stmt.setString(6, email);
                stmt.executeQuery();
                conn.commit();
                JOptionPane.showMessageDialog(null, firstName+" "+lastName+" has been entered into the system.");
                Item item = new Item();
                item.setVisible(true);
                setVisible(false);
                
                if (icon != null){
                    String sql = "select student_id from students where first_name = '"
                            +firstName+"' and last_name = '" + lastName + "'";
                    rs = ItemManager.getSearchItems(sql);
                    if (rs.next()){
                        studentID = rs.getInt("student_id");
                        try (PreparedStatement pstmt = conn.prepareStatement("insert into student_photo (student_id, picture) "
                                 + "values ("+studentID+", ?)")) {
                            File file = new File(fileName);
                            FileInputStream fis = new FileInputStream(file);
                            pstmt.setBinaryStream(1, fis, (int)file.length()); 
                            pstmt.executeUpdate();
                            conn.commit();
                        }
                        conn.close();
                    }
                }
            } catch (SQLException | FileNotFoundException ex) {
                Logger.getLogger(createStudentMenu.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if (conn != null)
                    conn = null;
                if (rs != null)
                    rs = null;
                if (stmt != null)
                    stmt = null;
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Must complete all fields to create a new student");
    }//GEN-LAST:event_createBtnActionPerformed

    private void addressTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTxtFieldActionPerformed

    private void studentImageLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentImageLblMouseClicked
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            fileName = file.getAbsolutePath();
            fileName = fileName.replaceAll("\\\\\\\\", "\\\\");
            fileName = fileName.replace("C:\\", "C:\\\\");
            try {
                BufferedImage image = ImageIO.read(file);
                BufferedImage resizedImage=resize(image,126,126);
                icon = new ImageIcon(resizedImage);
            } catch (IOException ex) {
                Logger.getLogger(createStudentMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            studentImageLbl.setIcon(icon);
        }
    }//GEN-LAST:event_studentImageLblMouseClicked

    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTxtField;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton createBtn;
    private javax.swing.JTextField dobTxtField;
    private javax.swing.JTextField emailTxtField;
    private javax.swing.JTextField firstNameTxtField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lastNameTxtField;
    private javax.swing.JTextField phoneTxtField;
    private javax.swing.JLabel studentImageLbl;
    // End of variables declaration//GEN-END:variables
}
