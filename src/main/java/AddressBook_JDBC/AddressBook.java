package AddressBook_JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressBook {


    public void retrieveFromDB(String query){
        ConnectionWithMySql conJDBC = new ConnectionWithMySql();;
        Connection con = conJDBC.connect();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println(String.format("%-15s","City") +String.format("%-15s","State") + String.format("%-15s","ZipCode") + String.format("%-15s","AddressId \n") );
            while (rs.next()) {
                System.out.print(String.format("%-15s", rs.getString("city")));
                System.out.print(String.format("%-15s", rs.getString("state")));
                System.out.print(String.format("%-15s", rs.getString("zipCode")));
                System.out.print(String.format("%-15s", rs.getInt("addId")));
                System.out.println();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
