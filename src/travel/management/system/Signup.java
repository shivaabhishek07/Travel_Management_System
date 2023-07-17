package Travel_Management_System.src.travel.management.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Signup extends JFrame implements ActionListener{
    JButton create, back;
    JTextField tfUserName, tfName, tfPassword, tfAnswer;
    Choice security;

    Signup(){
        setBounds(350, 200, 900, 360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        
        add(p1);

        JLabel lblUserName = new JLabel("User Name");
        lblUserName.setBounds(50,20,125,25);
        lblUserName.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p1.add(lblUserName);
        
        tfUserName = new JTextField();
        tfUserName.setBounds(190,20,180,25);
        tfUserName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfUserName);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(50,60,180,25);
        lblName.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p1.add(lblName);
        
        tfName = new JTextField();
        tfName.setBounds(190,60,180,25);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfName);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(50,100,180,25);
        lblPassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p1.add(lblPassword);
        
        tfPassword = new JPasswordField();
        tfPassword.setBounds(190,100,180,25);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfPassword);

        JLabel lblSecurity = new JLabel("Security Question");
        lblSecurity.setBounds(50,140,125,25);
        lblSecurity.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p1.add(lblSecurity);

        security = new Choice();
        security.add("Fav character from The Boys");
        security.add("Fav Marvel superhero");
        security.add("Your lucky number");
        security.add("Your childhood superhero");
        security.setBounds(190, 140, 180, 25);
        p1.add(security);

        JLabel lblAnswer = new JLabel("Answer");
        lblAnswer.setBounds(50,180,125,25);
        lblAnswer.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p1.add(lblAnswer);
        
        tfAnswer = new JTextField();
        tfAnswer.setBounds(190,180,180,25);
        tfAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfAnswer);

        create = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133, 193, 233));
        create.setFont(new Font("SAN SERIF", Font.PLAIN, 14));
        create.setBounds(80, 250, 100, 30 );
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("SAN SERIF", Font.PLAIN, 14));
        back.setBounds(250, 250, 100, 30 );
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(System.getProperty("user.dir")+"./Travel_Management_System/utils/signup.png");
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == create){
            String username = tfUserName.getText();
            String name = tfName.getText();
            String password = tfPassword.getText();
            String question = security.getSelectedItem();
            String answer = tfAnswer.getText();

            String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account created successfully!");
                setVisible(false);
                new Login();
            }
            catch(Exception ee){}
        }
        else if(e.getSource() == back){
            setVisible(false);
            new Login();
        }
    }

    public static void main(String...args){
        new Signup();
    }
}
