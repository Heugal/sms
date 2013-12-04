package studentmanagementsystem.menu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import studentmanagementsystem.managers.ItemManager;
import studentmanagementsystem.SanitizeInputs;
import studentmanagementsystem.managers.UserManager;

public class deleteStudentMenu extends javax.swing.JFrame {
    ResultSet rs = null;
    /**
     * Creates new form deleteStudentMenu
     */
    public deleteStudentMenu() {
        super("Delete Student Menu");
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

        deleteBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        studentIDTxtField = new javax.swing.JTextField();
        lastNameTxtField = new javax.swing.JTextField();
        firstNameTxtField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        deleteBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 51, 51));
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        cancelBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Delete Student");

        jLabel2.setText("Student ID:");

        jLabel3.setText("First Name:");

        jLabel4.setText("Last Name:");

        jLabel5.setText("Please fill out student's ID or first name and last name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(studentIDTxtField)
                            .addComponent(lastNameTxtField)
                            .addComponent(firstNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(studentIDTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(firstNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lastNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int areYouSure = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the specified user?");
        if (areYouSure == 0){
            String tempIDString = SanitizeInputs.removeNonDigitFromIDString(studentIDTxtField.getText());
            int studentID = (tempIDString.equals("")) ? 0 : Integer.parseInt(studentIDTxtField.getText());
            String firstName = SanitizeInputs.sanitizeInputString(firstNameTxtField.getText());
            String lastName = SanitizeInputs.sanitizeInputString(lastNameTxtField.getText());
            String sql = "delete from students where ";
            boolean photoPresent = false;
            ResultSet studentSearch = null;
            if ((studentID > 0) || ((!firstName.equals("")) && (!lastName.equals("")))){
                try {
                    if (studentID > 0){
                        photoPresent = ItemManager.checkIfPhotoPresent(studentID);
                        sql = ((!firstName.equals("") && (!lastName.equals("")))) ?
                                sql + "student_id = "+studentID+" and upper(first_name) = upper('"+firstName
                                    +"') and upper(last_name) = upper('"+lastName+"')" :
                                sql + "student_id = "+studentID;
                    }
                    // I can just write else because the second condition is verified at 
                    // this point by reaching this section of code
                    else{
                        sql = sql + "upper(first_name) = upper('"+firstName
                                    +"') and upper(last_name) = upper('"+lastName+"')";
                        String searchSql = "select student_id from students where first_name = '"
                                +firstName+"' and last_name = '"+lastName+"'";
                        // we have to delete the students photo from the DB, so
                        // if the user only provided us with a first_last name, then
                        // we have to query the DB for the student ID
                        studentSearch = ItemManager.getSearchItems(searchSql);
                        if (studentSearch.next()){
                            studentID = studentSearch.getInt("student_id");
                            photoPresent = ItemManager.checkIfPhotoPresent(studentID);
                        }
                    }
                    
                    // goodbye
                    UserManager.executeQuery(sql);
                    if (true == photoPresent){
                        sql = "delete from student_photo where student_id = "+studentID;
                        UserManager.executeQuery(sql);
                    }
                    Item item = new Item();
                    item.setVisible(true);
                    setVisible(false);

                } catch (SQLException ex) {
                    Logger.getLogger(deleteStudentMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Must enter either a student ID or first name+last name");
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        Item item = new Item();
        item.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_cancelBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField firstNameTxtField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField lastNameTxtField;
    private javax.swing.JTextField studentIDTxtField;
    // End of variables declaration//GEN-END:variables
}