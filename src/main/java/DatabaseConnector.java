
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.sql.*;
import javax.swing.JOptionPane;

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

    public static boolean deleteCustomer(int customerId) {
        String sql = "DELETE FROM Customer WHERE ID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, customerId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean updateCustomer(int customerID, String name, String email, String phone, String address, String city, String state, String zipCode, String country) {
        String sql = "UPDATE Customer SET Name = ?, Email = ?, Phone = ?, Address = ?, City = ?, State = ?, ZipCode = ?, Country = ? WHERE ID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setString(4, address);
            pstmt.setString(5, city);
            pstmt.setString(6, state);
            pstmt.setString(7, zipCode);
            pstmt.setString(8, country);
            pstmt.setInt(9, customerID);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    /**
     * Adds a new customer to the database.
     *
     * @param name     The customer's name.
     * @param email    The customer's email.
     * @param phone    The customer's phone number.
     * @param address  The customer's address.
     * @param city     The customer's city.
     * @param state    The customer's state.
     * @param zipCode  The customer's zip code.
     * @param country  The customer's country.
     * @return boolean True if the operation is successful, false otherwise.
     */
    public static boolean addCustomer(String name, String email, String phone, String address, String city, String state, String zipCode, String country) {
        // SQL statement to insert a new customer
        String sql = "INSERT INTO Customer (Name, Email, Phone, Address, City, State, ZipCode, Country) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setString(4, address);
            pstmt.setString(5, city);
            pstmt.setString(6, state);
            pstmt.setString(7, zipCode);
            pstmt.setString(8, country);

            // Execute the update
            int affectedRows = pstmt.executeUpdate();
            // Check if a row was added
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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

    public static boolean deleteOrder(int orderId) {
        String sql = "DELETE FROM `Order` WHERE OID = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, orderId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateOrder(int orderId, String customerId, String orderDate, String status, BigDecimal totalAmount, String paymentMethod, String shippingAddress, String billingAddress, String notes) {
        String sql = "UPDATE `Order` SET CustomerID = ?, OrderDate = ?, Status = ?, TotalAmount = ?, PaymentMethod = ?, ShippingAddress = ?, BillingAddress = ?, Notes = ? WHERE OID = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // 设置 SQL 参数
            pstmt.setString(1, customerId);
            pstmt.setString(2, orderDate);
            pstmt.setString(3, status);
            pstmt.setBigDecimal(4, totalAmount);
            pstmt.setString(5, paymentMethod);
            pstmt.setString(6, shippingAddress);
            pstmt.setString(7, billingAddress);
            pstmt.setString(8, notes);
            pstmt.setInt(9, orderId);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static DefaultTableModel getProductData() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ProductID", "Name", "Price", "Quantity"}, 0);
        String sql = "SELECT * FROM `product`";

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

    public static boolean deleteProduct(int productId) {
        String sql = "DELETE FROM product WHERE ProductID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, productId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateProduct(int productId, String name, BigDecimal price, int quantity) {
        String sql = "UPDATE product SET Name = ?, Price = ?, Quantity = ? WHERE ProductID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setBigDecimal(2, price);
            pstmt.setInt(3, quantity);
            pstmt.setInt(4, productId);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static DefaultTableModel getTopFiveProducts() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ProductID", "Name", "Price", "Quantity"}, 0);
        String sql = "SELECT * FROM product LIMIT 5";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("ProductID"),
                        rs.getString("Name"),
                        rs.getBigDecimal("Price"),
                        rs.getInt("Quantity")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors
        }
        return model;
    }
    
    //YuPei Chen
        public static ResultSet getProducts() throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
        return rs;
    }

    public static void deleteRowFromDatabase(Object id) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
        // Create a connection to the database
        connection = DriverManager.getConnection(URL, USER, PASSWORD);

        // Create SQL delete statement
        String sql = "DELETE FROM Product WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(sql);
        // Assuming id is an integer
        preparedStatement.setInt(1, (Integer) id);

        // Execute delete statement
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Row deleted successfully.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error deleting row.");
    } finally {
        // Close the resources
        try {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
    
       public static void updateProductInDatabase(int productId, String newName, double newPrice, int newQuantity) {
        // Connection and PreparedStatement must be closed after use, hence the try-with-resources statement
        String url = URL; // Replace with your database URL
        String user = USER; // Replace with your database username
        String password = PASSWORD; // Replace with your database password
        String sql = "UPDATE Product SET Name = ?, Price = ?, Quantity = ? WHERE ProductID = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // Set the parameters for the prepared statement
            pstmt.setString(1, newName);
            pstmt.setDouble(2, newPrice);
            pstmt.setInt(3, newQuantity);
            pstmt.setInt(4, productId);
            
            // Execute the update
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating product failed, no rows affected.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any SQL exceptions here, such as showing an error dialog
            // JOptionPane.showMessageDialog(null, "Error updating product.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void addProductToDatabase(String name, double price, int quantity) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
        // Replace with your database connection details
        conn = DriverManager.getConnection(URL, USER, PASSWORD);

        // SQL INSERT statement to add a new product to the database
        String sql = "INSERT INTO Product (name, price, quantity) VALUES (?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setDouble(2, price);
        pstmt.setInt(3, quantity);

        // Execute the insert operation
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(null, "Product added successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Product could not be added.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error adding product to the database.", "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Clean up the resources
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

    
    // Method to establish a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
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

