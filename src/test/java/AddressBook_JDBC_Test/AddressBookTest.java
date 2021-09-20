package AddressBook_JDBC_Test;

import AddressBook_JDBC.AddressBook;
import org.junit.Test;

import java.sql.SQLException;

public class AddressBookTest {
    @Test //uc16
    public void printsData_InDatabase_IfPresent() throws SQLException {
        AddressBook ab = new AddressBook();
        String query = "SELECT * FROM address";
        ab.retrieveFromDB(query);
    }
    @Test //uc17
    public void updateData_InDatabase() throws SQLException {
        AddressBook ab = new AddressBook();
        String query = "UPDATE address SET city = 'Chandrapur' WHERE addId = 1; ";
        ab.updateInDB(query);
    }

    @Test //uc18
    public void gettingID_FromDB_WithStartDate() throws SQLException {
        AddressBook ab = new AddressBook();
        String query = "SELECT addId FROM address WHERE start BETWEEN ('2019-12-05') AND DATE(now());\n";
        ab.retrieveDateBetFromDB(query);
    }
}
