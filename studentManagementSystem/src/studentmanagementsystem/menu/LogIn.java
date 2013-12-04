package studentmanagementsystem.menu;

import studentmanagementsystem.beans.UserBean;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import studentmanagementsystem.managers.UserManager;

public class LogIn extends JFrame implements ActionListener{
    private JPanel panel;
    private JTextField txtUserName;
    private JPasswordField txtPassword;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private int state = 0;
    private int passCheck = 0;
    
    public LogIn(){
        super("Student Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initiliazePanel();
        setSize(400,200);
        setLocation(100, 100);
        setVisible(true);
    }
    
    public void initiliazePanel(){
        panel = new JPanel(new BorderLayout());
        JPanel panelTop = new JPanel();
        JPanel panelBottom = new JPanel(new GridLayout(3,2));
        
        panel.add(panelTop, BorderLayout.NORTH);
        panel.add(panelBottom, BorderLayout.SOUTH);
        
        String title = "";
        if (state == 0)
            title = "Enter your user name and password.";
        else if (state == 1)
            title = "New user created. Enter your login credentials.";
        JLabel lblTitle = new JLabel(title);
        panelTop.add(lblTitle);
        
        JLabel lblUserName = new JLabel("User Name:");
        txtUserName = new JTextField(30);
        
       
        JLabel lblPassword = new JLabel("Password:");
        txtPassword = new JPasswordField();
        
        JButton btnLogin = new JButton("Login");
        JButton createUser = new JButton("New User");
        
        panelBottom.add(lblUserName);
        panelBottom.add(txtUserName);
        
        panelBottom.add(lblPassword);
        panelBottom.add(txtPassword);
        
        panelBottom.add(createUser);
        panelBottom.add(btnLogin);
        createUser.addActionListener(this);
        btnLogin.addActionListener(this);
        
        add(panel);
        
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            case "New User":
                createNewUserWindow();
                break;
            case "Login":
                tryLogin();
                break;
            case "Submit":
                try {
                    createNewUser();
                    getContentPane().removeAll();
                    setSize(400,200);
                    state = 1;
                    initiliazePanel();
                    repaint();
                } catch (SQLException ex) {
                    Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
        }
    }
    
    public void createNewUser() throws SQLException{
        String userName = txtUserName.getText();
        String pass = txtPassword.getText();
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        UserManager manager = new UserManager();
        manager.insertUser(userName, pass, firstName, lastName);
    }
    
    public void createNewUserWindow(){
        getContentPane().removeAll();
        setSize(400,250);
        JPanel newUserPanel = new JPanel(new BorderLayout());
        JPanel panelTop = new JPanel();
        JPanel panelBottom = new JPanel(new GridLayout(5,2));
        
        newUserPanel.add(panelTop, BorderLayout.NORTH);
        newUserPanel.add(panelBottom, BorderLayout.SOUTH);
        
        JLabel lblTitle = new JLabel("Enter your desired credentials");
        panelTop.add(lblTitle);
        
        JLabel lblUserName = new JLabel("User Name:");
        txtUserName = new JTextField(30);
        
       
        JLabel lblPassword = new JLabel("Password:");
        txtPassword = new JPasswordField();
        
        JLabel lblFirstName = new JLabel("First Name:");
        txtFirstName = new JTextField(20);
        
        JLabel lblLastName = new JLabel("Last Name:");
        txtLastName = new JTextField(20);
        
        panelBottom.add(lblUserName);
        panelBottom.add(txtUserName);
        
        panelBottom.add(lblPassword);
        panelBottom.add(txtPassword);
        
        panelBottom.add(lblFirstName);
        panelBottom.add(txtFirstName);
        
        panelBottom.add(lblLastName);
        panelBottom.add(txtLastName);
        
        JButton btnSubmit = new JButton("Submit");
        JLabel lblDummy = new JLabel();
        panelBottom.add(lblDummy);
        panelBottom.add(btnSubmit);
        btnSubmit.addActionListener(this);
        
        
        getContentPane().add(newUserPanel);
        repaint();
    }
    
    public void tryLogin(){
        String username = txtUserName.getText();
        try{
            UserBean bean = UserManager.getUser(username);
            if(bean == null){
                JOptionPane.showMessageDialog(null, "User does not exist");
            }
            else{
                char[] pass = txtPassword.getPassword();  
                String passString = new String(pass);
                if(passString.equals(bean.getPassword())){
                    JOptionPane.showMessageDialog(null,username + 
                            " is logged in.");
                    UserManager.logUserHistory(username);
                    Item itemFrame = new Item();
                    itemFrame.setVisible(true);
                    setVisible(false);
                } else{
                    if (passCheck < 3){
                        JOptionPane.showMessageDialog(null,"Incorrect password");
                        passCheck++;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Too many "+
                                "incorrect password attempts.");
                        System.exit(-1);
                    }
                }
            }
        }catch (SQLException ex) {
             System.err.println(ex);
        }
    }
}
