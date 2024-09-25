import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/SYSTEM"; 
        String username = "SYSTEM"; 
        String password = "SYSTEM"; 
        String tableName = "product"; 
        String createTableQuery = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(25) NOT NULL," +
                "color VARCHAR(50) NOT NULL," +
                "category VARCHAR(50) NOT NULL," +
                "price DOUBLE NOT NULL" +
                ");";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            statement.executeUpdate(createTableQuery);

            System.out.println("Table 'product' created successfully.");

            statement.close();
            connection.close();
            System.out.println("Connection Closed.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
