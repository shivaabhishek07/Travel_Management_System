package Travel_Management_System.src.travel.management.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class Loading extends JFrame implements Runnable{
    JProgressBar bar;
    Thread t;

    Loading(String usr){
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Travel and Tourism application");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, please wait...");
        loading.setBounds(230,130,150,30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway", Font.BOLD, 16));
        add(loading);

        JLabel username = new JLabel("Welcome "+usr);
        username.setBounds(20,310,400,40);
        username.setForeground(Color.RED);
        username.setFont(new Font("Raleway", Font.BOLD, 16));
        add(username);

        t = new Thread(this);
        t.start();

        setVisible(true);
    }
    public void run(){
        try{
            for(int i=1;i<=101;i++){
                int max = bar.getMaximum();
                int value = bar.getValue();

                if(value < max){
                    bar.setValue(value + 1);
                }
                else{
                    setVisible(false);
                }
                Thread.sleep(50);
            }
            new Dashboard();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String...args){
        new Loading("String");
    }
}
