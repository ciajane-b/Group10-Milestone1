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

    public UserSession authenticate(String u, String p) {
        String sql = "SELECT rank FROM users WHERE username=? COLLATE NOCASE AND password=?";
        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u); ps.setString(2, p);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return new UserSession(u, rs.getString("rank"));
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public void saveLog(String user, String action) {
        String sql = "INSERT INTO audit_logs (user, action) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user); ps.setString(2, action);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
