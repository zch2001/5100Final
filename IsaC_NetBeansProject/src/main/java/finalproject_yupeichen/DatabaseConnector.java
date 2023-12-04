package finalproject_yupeichen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import finalproject_yupeichen.StockManagerUI;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class DatabaseConnector {

    // Database URL, username and password should be secured
    private static final String URL = "jdbc:mysql://localhost:3306/stockmanager?serverTimezone=America/New_York&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "Aisa937!";


    
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
    
    // Add additional methods to handle CRUD operations if needed

    // Main method for testing the connection
    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                System.out.println("Connected to the database successfully!");
                // Perform database operations here
                connection.close(); // Close the connection when done
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
