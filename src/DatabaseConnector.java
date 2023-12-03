import java.sql.*;

public class DatabaseConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/walmart_ecommerce";
    private static final String USER = "root";
    private static final String PASSWORD = "aaaaaa1479";

    // 验证用户名和密码的方法
    public static boolean validateUser(String username, String password) {
        String query = "SELECT password FROM User WHERE username = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String retrievedPassword = rs.getString("password");
                return retrievedPassword.equals(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean registerNewUser(String username, String password) {
        // 检查用户名是否已存在（根据实际情况可能需要此步骤）

        // 插入新用户的SQL语句，根据您的数据表结构可能需要调整字段名
        String sql = "INSERT INTO User (username, password) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);  // 假设 getConnection() 是您已有的建立连接的方法
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // 设置参数
            pstmt.setString(1, username);
            pstmt.setString(2, password); // 使用一个方法来哈希密码

            // 执行更新
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // 根据错误类型，这里应该处理各种异常情况，比如用户名重复等
            return false;
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/walmart_ecommerce";
        String user = "root";
        String password = "aaaaaa1479";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database.");

            // 示例查询
            String query = "SELECT * FROM User";
            try (Statement stmt = connection.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    String username = rs.getString("username");
                    String pwd = rs.getString("password");
                    System.out.println("Username: " + username + ", Password: " + pwd);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to the database");
            e.printStackTrace();
        }
    }
}
