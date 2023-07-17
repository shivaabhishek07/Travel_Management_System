package Travel_Management_System.src.travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class viewPackage extends JFrame implements ActionListener{
    JButton back;
    JLabel labelUsername, labelPackage, labelPersons, labelId, labelNumber, labelPhone, labelPrice;
    viewPackage(String username){
        setBounds(450,200,900,450);

        JLabel text = new JLabel("View package details");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(60,0,300,30);
        add(text);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30,50,150,25);
        add(lblUsername);

        labelUsername = new JLabel();
        labelUsername.setBounds(220,50,150,25);
        add(labelUsername);

        JLabel lblPackage = new JLabel("Package");
        lblPackage.setBounds(30,90,150,25);
        add(lblPackage);

        labelPackage = new JLabel();
        labelPackage.setBounds(220,90,150,25);
        add(labelPackage);

        JLabel lblPersons = new JLabel("Total persons");
        lblPersons.setBounds(30,130,150,25);
        add(lblPersons);

        labelPersons = new JLabel();
        labelPersons.setBounds(220,130,150,25);
        add(labelPersons);

        JLabel lblId = new JLabel("Id");
        lblId.setBounds(30,170,150,25);
        add(lblId);

        labelId = new JLabel();
        labelId.setBounds(220,170,150,25);
        add(labelId);

        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30,210,150,25);
        add(lblNumber);

        labelNumber = new JLabel();
        labelNumber.setBounds(220,210,150,25);
        add(labelNumber);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(30,250,150,25);
        add(lblPhone);

        labelPhone = new JLabel();
        labelPhone.setBounds(220,250,150,25);
        add(labelPhone);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(30,290,150,25);
        add(lblPrice);

        labelPrice = new JLabel();
        labelPrice.setBounds(220,290,150,25);
        add(labelPrice);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,360,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(System.getProperty("user.dir")+"./Travel_Management_System/utils/bookedDetails.jpg");
        Image i2 = i1.getImage().getScaledInstance(500,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,20, 500,400);
        add(image);
        
        try{
            Conn c = new Conn();
            String query = "select * from bookPackage where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelUsername.setText(rs.getString("username"));
                labelPackage.setText(rs.getString("package"));
                labelPersons.setText(rs.getString("persons"));
                labelId.setText(rs.getString("id"));
                labelNumber.setText(rs.getString("number"));
                labelPhone.setText(rs.getString("phone"));
                labelPrice.setText(rs.getString("price"));
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }
    public static void main(String...args){
        new viewPackage("shi");
    }
}
