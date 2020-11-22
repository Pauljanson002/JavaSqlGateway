import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/my";
        String username = "root";
        String password = "root0";
        try {
            Connection connection = DriverManager.getConnection(dbUrl,username,password);
            DatabaseMetaData meta = connection.getMetaData();
            System.out.println(meta.getURL());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
