package Travel_Management_System.src.travel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    JButton login, signup, password;
    JTextField tfUserName, tfPassword;
    Login(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0,0, 400,400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(System.getProperty("user.dir")+"./Travel_Management_System/utils/login.png");
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 70, 200, 200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        JLabel lblUserName = new JLabel("User Name");
        lblUserName.setBounds(60,20,200,25);
        lblUserName.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblUserName);

        tfUserName = new JTextField();
        tfUserName.setBounds(60,50,300,30);
        tfUserName.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfUserName);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(60,110,200,25);
        lblPassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblPassword);

        tfPassword = new JTextField();
        tfPassword.setBounds(60,140,300,30);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfPassword);

        JLabel text = new JLabel("Trouble in Login");
        text.setBounds(260, 170, 150, 20);
        text.setForeground(Color.RED);
        p2.add(text);

        login = new JButton("Login");
        login.setBounds(60, 190, 130, 30);
        login.setBackground(new Color(131, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(230, 190, 130, 30);
        signup.setBackground(new Color(131, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.addActionListener(this);
        p2.add(signup);

        password = new JButton("Forgot Password");
        password.setBounds(146, 240, 130, 30);
        password.setBackground(new Color(131, 193, 233));
        password.setForeground(Color.WHITE);
        password.setBorder(BorderFactory.createEmptyBorder());
        password.addActionListener(this);
        p2.add(password);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            try{
                String username = tfUserName.getText();
                String pass = tfPassword.getText();

                String query = "select * from account where username = '"+username+"' and password = '"+pass+"'";

                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new Signup();

        }
        else if(ae.getSource() == password){
            setVisible(false);
            new ForgetPassword();
        }
    }
    public static void main(String...args){
        new Login();
    }
}
