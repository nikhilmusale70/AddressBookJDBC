package AddressBook_JDBC;

import java.sql.*;

public class AddressBook {
    ConnectionWithMySql conJDBC = new ConnectionWithMySql();;
    Connection con = null;

    public AddressBook() {
        this.con = conJDBC.connect();
    }

    public void retrieveFromDB(String query){
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

    public void updateInDB(String query){
        try {
            PreparedStatement statement = con.prepareStatement(query);
            int rowsChanged = statement.executeUpdate();
            System.out.println(rowsChanged + " rows modified");
            }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
