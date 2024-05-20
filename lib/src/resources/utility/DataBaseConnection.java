package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// This class will setup database connection to store log files
public class DataBaseConnection {
    public static String date = null;

    public static void databaseConnection() {
        date = DataGenerator.generateDate();
        try (Connection conn = DriverManager.getConnection(Environment.getValue("DB", "URL"),
                Environment.getValue("DB", "USERNAME"),
                Environment.getValue("DB", "PASSWORD"));
                Statement statement = conn.createStatement();) {
            String sql = "CREATE TABLE LOG_" + date +
                    "(DATE VARCHAR(100) NOT NULL, " +
                    "LOGGER  VARCHAR(50)    NOT NULL," +
                    "LEVEL   VARCHAR(10)    NOT NULL," +
                    "MESSAGE VARCHAR(1000)  NOT NULL)";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
