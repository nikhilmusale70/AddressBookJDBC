package AddressBook_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionWithMySql {
    private String url = "jdbc:mysql://localhost:3306/addressbook?useSSL=false";

    public Connection connect(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","1234");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return con;
    }

}
