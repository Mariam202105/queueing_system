
import java.sql.*;

public class QueueingSystem {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/queue_system";
    private static final String USER = "root";
    private static final String PASS = "password";  // Replace with your database password

    public static void main(String[] args) {
        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            
            // Create the table if it doesn't exist
            String createTableSQL = "CREATE TABLE IF NOT EXISTS customers (" +
                                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                                    "name VARCHAR(100)," +
                                    "service_status BOOLEAN)";
            stmt.executeUpdate(createTableSQL);

            // Add a customer to the queue
            String insertSQL = "INSERT INTO customers (name, service_status) VALUES ('John Doe', FALSE)";
            stmt.executeUpdate(insertSQL);

            // View the customers in the queue
            String selectSQL = "SELECT * FROM customers WHERE service_status = FALSE";
            ResultSet rs = stmt.executeQuery(selectSQL);
            System.out.println("Customers in Queue:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Remove customer from the queue after service
            String updateSQL = "UPDATE customers SET service_status = TRUE WHERE id = 1";  // Update the first customer as served
            stmt.executeUpdate(updateSQL);

            // Close connections
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
