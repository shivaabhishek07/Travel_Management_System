package Travel_Management_System.src.travel.management.system;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class bookPackage extends JFrame implements ActionListener{
    Choice cPackage;
    JTextField tfPersons;
    JLabel labelTotal, labelUsername, labelId, labelNumber, labelPhone;
    JButton checkPrice, bookPackage, back;
    String username;

    bookPackage(String username){
        this.username = username;
        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,70,100,20);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblusername);

        labelUsername = new JLabel();
        labelUsername.setBounds(250,70,100,20);
        labelUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelUsername);

        JLabel lblSelectpkg = new JLabel("Select Package");
        lblSelectpkg.setBounds(40,110,150,20);
        lblSelectpkg.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblSelectpkg);

        cPackage = new Choice();
        cPackage.add("Gold package");
        cPackage.add("Silver package");
        cPackage.add("Brownze package");
        cPackage.setBounds(250,110,200,20);
        add(cPackage);

        JLabel lblPersons = new JLabel("Total persons");
        lblPersons.setBounds(40,150,150,20);
        lblPersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblPersons);

        tfPersons = new JTextField("1");
        tfPersons.setBounds(250,150,200,25);
        add(tfPersons);

        JLabel lblId = new JLabel("id");
        lblId.setBounds(40,190,150,20);
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblId);

        labelId = new JLabel();
        labelId.setBounds(250,190,100,20);
        labelId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelId);

        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(40,230,150,20);
        lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNumber);

        labelNumber = new JLabel();
        labelNumber.setBounds(250,230,150,20);
        labelNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelNumber);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(40,270,150,20);
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblPhone);

        labelPhone = new JLabel();
        labelPhone.setBounds(250,270,150,20);
        labelPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelPhone);
        
        JLabel lblTotal = new JLabel("Total price");
        lblTotal.setBounds(40,310,150,20);
        lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblTotal);

        labelTotal = new JLabel();
        labelTotal.setBounds(250,310,150,20);
        labelTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelTotal);

        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelUsername.setText(rs.getString("username"));
                labelId.setText(rs.getString("id_type"));
                labelNumber.setText(rs.getString("number"));
                labelPhone.setText(rs.getString("phone"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        checkPrice = new JButton("Check Price");
        checkPrice.setBackground(Color.BLACK);
        checkPrice.setForeground(Color.WHITE);
        checkPrice.setBounds(40,380,120,25);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookPackage = new JButton("Book package");
        bookPackage.setBackground(Color.BLACK);
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setBounds(200,380,120,25);
        bookPackage.addActionListener(this);
        add(bookPackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(System.getProperty("user.dir")+"./Travel_Management_System/utils/bookpackage.jpg");
        Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,50, 500,300);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
        else if(ae.getSource() == bookPackage){
            try{
                 Conn c = new Conn();
                 String query = "insert into bookPackage values('"+labelUsername.getText()+"','"+cPackage.getSelectedItem()+"','"+tfPersons.getText()+"','"+labelId.getText()+"','"+labelNumber.getText()+"','"+labelPhone.getText()+"','"+labelTotal.getText()+"')";
                 c.s.executeUpdate(query);

                 JOptionPane.showMessageDialog(null, "Package booked successfully");
                 setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == checkPrice){
            String pkg = cPackage.getSelectedItem();
            int cost = 0;
            if(pkg.equals("Gold package")){
                cost+=12000;
            }
            else if(pkg.equals("Silver package")){
                cost+=25000;
            }
            else if(pkg.equals("Brownze package")){
                cost+=32000;
            }

            int persons = Integer.parseInt(tfPersons.getText());
            cost *=persons;
            labelTotal.setText(cost+"");
        }
    }
    public static void main(String...args){
        new bookPackage("shi");
    }
}
