package projeto_final;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    public static Connection connectDb(){
        try{
            // Para MySQL Connector/J 9.x
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(
                "jdbc:mysql://localhost/employee", 
                "root", 
                "");
            return connect;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}