/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem.menu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import studentmanagementsystem.managers.ItemManager;
import studentmanagementsystem.SanitizeInputs;

/**
 *
 * @author Stephan
 */
public class studentHistoryMenu extends javax.swing.JFrame {
    private ResultSet userHistory;
    /**
     * Creates new form studentHistoryMenu
     */
    public studentHistoryMenu() {
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

        jLabel1 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userHistoryTable = new javax.swing.JTable();
        filterBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        startDateTxtField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        endDateTxtField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("User History");

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        userHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Login Date", "Login Time", "Username", "First Name", "Last Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userHistoryTable);
        userHistoryTable.getColumnModel().getColumn(0).setResizable(false);
        userHistoryTable.getColumnModel().getColumn(1).setResizable(false);
        userHistoryTable.getColumnModel().getColumn(2).setResizable(false);
        userHistoryTable.getColumnModel().getColumn(3).setResizable(false);
        userHistoryTable.getColumnModel().getColumn(4).setResizable(false);

        filterBtn.setText("Filter");
        filterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Start Date:");

        jLabel3.setText("End Date:");

        jLabel4.setText("For dates use DD-Mon-YY format");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(startDateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(139, 139, 139)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(endDateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(filterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(54, 54, 54))
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterBtn)
                    .addComponent(jLabel2)
                    .addComponent(startDateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(endDateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        Item item = new Item();
        item.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_backBtnActionPerformed

    private void filterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBtnActionPerformed
        DefaultTableModel userTableModel = 
                new DefaultTableModel( new Object[]{ "login_date", "login_time", "username", "first_name", "last_name" }, 0 );
        DateFormat df = new SimpleDateFormat("dd-MM-yy");
        String startDate = SanitizeInputs.sanitizeInputString(startDateTxtField.getText());
        String endDate = SanitizeInputs.sanitizeInputString(endDateTxtField.getText());
        String sql = "";
        if ((!startDate.equals("")) || (!endDate.equals(""))){
            sql = "select login_date, login_time, user_history.username, users.first_name, users.last_name "
                        + "from user_history join users on user_history.username = users.username ";
            // just the start date
            if ((!startDate.equals("")) && (endDate.equals("")))
                sql = sql +"where login_date >= to_date('"+startDate+"', 'DD-Mon-YY')";
            // just the end date
            else if ((startDate.equals("")) && (!endDate.equals("")))
                sql = sql + "where login_date <= to_date('"+endDate+"', 'DD-Mon-YY')";
            // both
            else
                sql = sql + "where login_date >= to_date('"+startDate+"', 'DD-Mon-YY') and"
                        + " login_date <= to_date('"+endDate+"', 'DD-Mon-YY')";
        }
        else{
            sql = "select login_date, login_time, user_history.username, users.first_name, users.last_name " 
                    +"from user_history join users on user_history.username = users.username";
        }
        try {
            userHistory = ItemManager.getSearchItems(sql);
            if (userHistory != null){
                while(userHistory.next()){
                    Vector<Object> vector = new Vector<>();
                    vector.add(df.format(userHistory.getDate("login_date")));
                    vector.add(userHistory.getString("login_time"));
                    vector.add(userHistory.getString("username"));
                    vector.add(userHistory.getString("first_name"));
                    vector.add(userHistory.getString("last_name"));
                    userTableModel.addRow(vector);
                }
                userHistoryTable.setModel(userTableModel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(studentHistoryMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_filterBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField endDateTxtField;
    private javax.swing.JButton filterBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField startDateTxtField;
    private javax.swing.JTable userHistoryTable;
    // End of variables declaration//GEN-END:variables
}
