package Travel_Management_System.src.travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*; 
import javax.swing.*;

public class ForgetPassword extends JFrame implements ActionListener{
    JTextField tfUserName, tfName, tfQuestion, tfAnswer, tfPassword;
    JButton search, retrive, back;

    ForgetPassword(){
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);

        ImageIcon i1 = new ImageIcon(System.getProperty("user.dir")+"./Travel_Management_System/utils/forgotpassword.jpg");
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);

        JLabel lblUserName = new JLabel("User Name");
        lblUserName.setBounds(40,20,100,25);
        lblUserName.setFont(new Font("SAN SERIF", Font.PLAIN, 14));
        p1.add(lblUserName);
        
        tfUserName = new JTextField();
        tfUserName.setBounds(220,20,150,25);
        tfUserName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfUserName);

        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380,20, 100,25);
        search.addActionListener(this);
        p1.add(search);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(40,60,100,25);
        lblName.setFont(new Font("SAN SERIF", Font.PLAIN, 14));
        p1.add(lblName);
        
        tfName = new JTextField();
        tfName.setBounds(220,60,150,25);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfName);

        JLabel lblQuestion = new JLabel("Your security question");
        lblQuestion.setBounds(40,100,150,25);
        lblQuestion.setFont(new Font("SAN SERIF", Font.PLAIN, 14));
        p1.add(lblQuestion);
        
        tfQuestion = new JTextField();
        tfQuestion.setBounds(220,100,150,25);
        tfQuestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfQuestion);

        JLabel lblAnswer = new JLabel("Answer");
        lblAnswer.setBounds(40,140,150,25);
        lblAnswer.setFont(new Font("SAN SERIF", Font.PLAIN, 14));
        p1.add(lblAnswer);
        
        tfAnswer = new JTextField();
        tfAnswer.setBounds(220,140,150,25);
        tfAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfAnswer);

        retrive = new JButton("Retrive");
        retrive.setBackground(Color.GRAY);
        retrive.setForeground(Color.WHITE);
        retrive.setBounds(380,140, 100,25);
        retrive.addActionListener(this);
        p1.add(retrive);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(40,180,150,25);
        lblPassword.setFont(new Font("SAN SERIF", Font.PLAIN, 14));
        p1.add(lblPassword);
        
        tfPassword = new JTextField();
        tfPassword.setBounds(220,180,150,25);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfPassword);

        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(150,230, 100,25);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            try{
                String query = "select * from account where username = '"+tfUserName.getText()+"';";
                Conn c = new Conn();

                ResultSet res = c.s.executeQuery(query);
                while(res.next()){
                    tfName.setText(res.getString("name"));
                    tfQuestion.setText(res.getString("security"));
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == retrive){
            try{
                String query = "select * from account where answer = '"+tfAnswer.getText()+"';";
                Conn c = new Conn();

                ResultSet res = c.s.executeQuery(query);
                while(res.next()){
                    tfPassword.setText(res.getString("password"));
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    public static void main(String...args){
        new ForgetPassword();
    }
}
