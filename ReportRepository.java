import java.sql.*;

public class ReportRepository {
    private final String URL = "jdbc:sqlite:molms.db";

    public ReportRepository() {
        try (Connection conn = DriverManager.getConnection(URL); Statement s = conn.createStatement()) {
            s.execute("CREATE TABLE IF NOT EXISTS users (username TEXT PRIMARY KEY, password TEXT, rank TEXT)");
            s.execute("CREATE TABLE IF NOT EXISTS audit_logs (user TEXT, action TEXT, time DATETIME DEFAULT CURRENT_TIMESTAMP)");

            // Seed Data
            s.execute("INSERT OR IGNORE INTO users VALUES ('Ciara', 'admin123', 'CPT')");
            s.execute("INSERT OR IGNORE INTO users VALUES ('Aldrian', 'user123', 'PVT')");
        } catch (SQLException e) { e.printStackTrace(); }
    }
