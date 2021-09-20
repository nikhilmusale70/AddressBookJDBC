package AddressBook_JDBC_Test;

import AddressBook_JDBC.AddressBook;
import org.junit.Test;

import java.sql.SQLException;

public class AddressBookTest {
    @Test
    public void printsData_InDatabase_IfPresent() throws SQLException {
        AddressBook ab = new AddressBook();
        String query = "SELECT * FROM address";
        ab.retrieveFromDB(query);
    }
}
