package Travel_Management_System.src.travel.management.system;

import java.sql.*;
import java.sql.DriverManager;

public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_management", "root", "Snan@8378");

            s = c.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
