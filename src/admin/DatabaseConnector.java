/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hanqi
 */
public class DatabaseConnector {

    private static final String URL = "jdbc:mysql://localhost:55001/walmart_ecommerce";
    private static final String USER = "root";
    private static final String PASSWORD = "hanqi123";

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
        // 检查用户名是否已存在

        // 插入新用户的SQL语句，根据数据表结构可能需要调整字段名
        String sql = "INSERT INTO User (username, password) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);  // 假设 getConnection() 是您已有的建立连接的方法
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // 设置参数
            pstmt.setString(1, username);
            pstmt.setString(2, password); // 先使用明文密码

            // 执行更新
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // 根据错误类型，这里应该处理各种异常情况，比如用户名重复等
            return false;
        }
    }


    public static DefaultTableModel getCustomerData() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name", "Email", "Phone", "Address", "City", "State", "ZipCode", "Country"}, 0);
        String sql = "SELECT * FROM Customer";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getString("Address"),
                        rs.getString("City"),
                        rs.getString("State"),
                        rs.getString("ZipCode"),
                        rs.getString("Country")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors
        }
        return model;
    }

    public static DefaultTableModel getOrderData() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"OID", "CustomerID", "OrderDate", "Status", "TotalAmount", "PaymentMethod", "ShippingAddress", "BillingAddress", "Notes"}, 0);
        String sql = "SELECT * FROM `Order`";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("OID"),
                        rs.getString("CustomerID"),
                        rs.getString("OrderDate"),
                        rs.getString("Status"),
                        rs.getString("TotalAmount"),
                        rs.getString("PaymentMethod"),
                        rs.getString("ShippingAddress"),
                        rs.getString("BillingAddress"),
                        rs.getString("Notes")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors
        }
        return model;
    }

    public static DefaultTableModel getProductData() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ProductID", "Name", "Price", "Quantity"}, 0);
        String sql = "SELECT * FROM `Product`";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("ProductID"),
                        rs.getString("Name"),
                        rs.getString("Price"),
                        rs.getString("Quantity")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors
        }
        return model;
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:55001/walmart_ecommerce";
        String user = "root";
        String password = "hanqi123";

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
