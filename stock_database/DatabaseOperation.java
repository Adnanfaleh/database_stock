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
