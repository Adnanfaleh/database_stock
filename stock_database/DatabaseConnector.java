import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/swing_demo";
    private static final String USERNAME = "admim"; //Hello
    private static final String PASSWORD = "admin";

    public static Connection connectDB() {
        try {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return con;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}

public class DatabaseOperation {
    public static void login(String userName, String password) {
        Connection con = DatabaseConnector.connectDB();
        if (con!= null) {
            try {
                PreparedStatement st = con.prepareStatement("Select name, password from student where name=? and password=?");
                st.setString(1, userName);
                st.setString(2, password);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    // Login successful
                } else {
                    // Login failed
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
