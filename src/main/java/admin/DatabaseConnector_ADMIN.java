/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

import Dao.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * @author hanqi
 */
public class DatabaseConnector_ADMIN {

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

    // Use for AdminPanel to CRUD customers
    public static List<Customer> getAllCustomer() throws SQLException {
        String sql = "SELECT * FROM `Customer`";

        List<Customer> customers = new ArrayList<Customer>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getString("Address"),
                        rs.getString("City"),
                        rs.getString("State"),
                        rs.getString("ZipCode"),
                        rs.getString("Country")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors
        }
        return customers;
    }

    // Update Customers
    public static boolean updateCustomer(Customer customer) {

        String sql = "UPDATE `Customer` SET name = ?, email = ?, phone = ?, address = ?, city = ?, state = ?, zip_code = ?, country = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getEmail());
            pstmt.setString(3, customer.getPhone());
            pstmt.setString(4, customer.getAddress());
            pstmt.setString(5, customer.getCity());
            pstmt.setString(6, customer.getState());
            pstmt.setString(7, customer.getZipCode());
            pstmt.setString(8, customer.getCountry());
            pstmt.setInt(9, customer.getID());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Update successful");
            } else {
                System.out.println("Update failed");
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    //Delete customer
    public static boolean deleteCustomer(Customer customer) {

        String sql = "DELETE FROM users WHERE id = ?";


        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, customer.getID());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Delete successful");
            } else {
                System.out.println("Delete failed");
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
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
