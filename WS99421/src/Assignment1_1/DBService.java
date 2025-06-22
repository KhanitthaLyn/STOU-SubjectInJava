package Assignment1_1;

import java.sql.*;
import java.util.ArrayList;

public class DBService {
    private Connection conn;

    public DBService() {
        DBConnection.loadClass();
        conn = DBConnection.getConnection();
    }

    public void insertUser(String name, String username, String password) {
        String sql = "INSERT INTO User (name, username, password) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(String name, String username, String password) {
        String sql = "UPDATE User SET name = ?, password = ? WHERE username = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.setString(3, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String username) {
        String sql = "DELETE FROM User WHERE username = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String[]> selectUser() {
        ArrayList<String[]> list = new ArrayList<>();
        String sql = "SELECT * FROM User";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String[] data = {
                    rs.getString("name"),
                    rs.getString("username"),
                    rs.getString("password")
                };
                list.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<String[]> selectUser(String keyword) {
        ArrayList<String[]> list = new ArrayList<>();
        String sql = "SELECT * FROM User WHERE username LIKE ? OR name LIKE ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String[] data = {
                    rs.getString("name"),
                    rs.getString("username"),
                    rs.getString("password")
                };
                list.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void closeConnection() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
