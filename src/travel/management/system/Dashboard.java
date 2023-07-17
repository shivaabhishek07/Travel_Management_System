package Travel_Management_System.src.travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dashboard extends JFrame implements ActionListener{
    JButton addPersonalDetails, updatePersonalDetails, viewPersonalDetails, deletePersonalDetails, checkPackages, bookPackage;
    JButton viewPackage, destinations;
    Dashboard(){
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(0,0,1600,1000);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65); 
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(System.getProperty("user.dir")+"./Travel_Management_System/utils/dashboard.png");
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(5, 0, 70, 70);
        p1.add(image);
        
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300, 900); 
        p2.setLayout(null);
        add(p2);

        addPersonalDetails = new JButton("Add personal details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update personal details");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View personal details");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p2.add(viewPersonalDetails);

        deletePersonalDetails = new JButton("Delete personal details");
        deletePersonalDetails.setBounds(0,150,300,50);
        deletePersonalDetails.setBackground(new Color(0,0,102));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p2.add(deletePersonalDetails);

        checkPackages = new JButton("Check packages");
        checkPackages.setBounds(0,200,300,50);
        checkPackages.setBackground(new Color(0,0,102));
        checkPackages.setForeground(Color.WHITE);
        checkPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkPackages.addActionListener(this);
        p2.add(checkPackages);

        bookPackage = new JButton("Book package");
        bookPackage.setBounds(0,250,300,50);
        bookPackage.setBackground(new Color(0,0,102));
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        viewPackage = new JButton("View package");
        viewPackage.setBounds(0,300,300,50);
        viewPackage.setBackground(new Color(0,0,102));
        viewPackage.setForeground(Color.WHITE);
        viewPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p2.add(viewPackage);

        JButton viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0,350,300,50);
        viewHotels.setBackground(new Color(0,0,102));
        viewHotels.setForeground(Color.WHITE);
        viewHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p2.add(viewHotels);

        JButton bookHotels = new JButton("Book Hotel");
        bookHotels.setBounds(0,400,300,50);
        bookHotels.setBackground(new Color(0,0,102));
        bookHotels.setForeground(Color.WHITE);
        bookHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p2.add(bookHotels);

        JButton viewBookedHotels = new JButton("View Booked Hotel");
        viewBookedHotels.setBounds(0,450,300,50);
        viewBookedHotels.setBackground(new Color(0,0,102));
        viewBookedHotels.setForeground(Color.WHITE);
        viewBookedHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p2.add(viewBookedHotels);

        destinations = new JButton("Destinations");
        destinations.setBounds(0,500,300,50);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p2.add(destinations);

        JButton payments = new JButton("Payments");
        payments.setBounds(0,550,300,50);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p2.add(payments);

        JButton calculator = new JButton("Calculators");
        calculator.setBounds(0,600,300,50);
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p2.add(calculator);

        JButton notepad = new JButton("Notepad");
        notepad.setBounds(0,650,300,50);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p2.add(notepad);

        JButton about = new JButton("About");
        about.setBounds(0,700,300,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma", Font.PLAIN, 20));
        p2.add(about);

        ImageIcon i4 = new ImageIcon(System.getProperty("user.dir")+"./Travel_Management_System/utils/home.jpg");
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(0, 0, 1650, 1000);
        add(image2);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addPersonalDetails){

        }
        else if(ae.getSource() == updatePersonalDetails){

        }
        else if(ae.getSource() == viewPersonalDetails){

        }
        else if(ae.getSource() == deletePersonalDetails){

        }
        else if(ae.getSource() == checkPackages){
            new checkPackages();
        }
        else if(ae.getSource() == bookPackage){
            new bookPackage("username");
        }
        else if(ae.getSource() == viewPackage){
            new viewPackage("username");
        }
        else if(ae.getSource() == destinations){
            new destinations();
        }
    }
    public static void main(String...args){
        new Dashboard();
    }
}
