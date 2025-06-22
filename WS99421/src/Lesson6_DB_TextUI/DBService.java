package Lesson6_DB_TextUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*public class DBService {
	// create method insertProduct, deleteProduct, updateProduct, selectProduct 
	// , selectProductByProductid
	
	Connection con = null;
	
	public DBService() {
		// สร้าง DB Connection
		DBConnection db = new DBConnection();
		db.loadDriver();
		con = db.getConnection();
	}
	
	public void insertProduct(Product p) {
		// sql insert 
		//insert into productdb.product values("p99","book"); 
		String insertcmd = "insert into product values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(insertcmd);
			ps.setString(1, p.getProductid());
			ps.setString(2, p.getProductname());
			// insert into product values("p0001","TV")
			ps.executeUpdate();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void deleteProduct(Product p) {
		// delete from product where productid = "p02";
		String deletecmd = "delete from product where productid = ?";
		try {
			PreparedStatement ps = con.prepareStatement(deletecmd);
			ps.setString(1, p.getProductid());
			// delete from product where productid = "p0001"
			ps.executeUpdate();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}
	
	public void deleteProduct(String pid) {
		// delete from product where productid = "p02";
		String deletecmd = "delete from product where productid = ?";
		try {
			PreparedStatement ps = con.prepareStatement(deletecmd);
			ps.setString(1, pid);
			// delete from product where productid = "p0001"
			ps.executeUpdate();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

	
	public void updateProduct(Product p) {
		// update product set productname = ? where productid = ?

		String updatecmd = "update product set productname = ? where productid = ?";
		try {
			PreparedStatement ps = con.prepareStatement(updatecmd);
			ps.setString(1, p.getProductname());
			ps.setString(2, p.getProductid());
			ps.executeUpdate();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	public ArrayList<Product> selectProduct() {
		ArrayList<Product> products = new ArrayList<>();
		String selectcmd = "select * from product";
		try {
			PreparedStatement ps = con.prepareStatement(selectcmd);
			ResultSet result = ps.executeQuery();
			while(result.next()) {
//				System.out.println(result.getString(1) + " --- " +result.getString(2));
				Product p = new Product(result.getString(1),result.getString(2));
//				System.out.println(p);
				products.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	

	
	public void selectProductByProductid(String id) {
		
	}
	
	public void selectProductByProductname(String name) {
		
	}

}
*/

import java.sql.*;
import java.util.ArrayList;

public class DBService {

    public static boolean insertUser(String name, String username, String password) {
        String sql = "INSERT INTO User(name, username, password) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, username);
            stmt.setString(3, password);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateUser(String name, String username, String password) {
        String sql = "UPDATE User SET name=?, password=? WHERE username=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.setString(3, username);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteUser(String username) {
        String sql = "DELETE FROM User WHERE username=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<String[]> selectUser() {
        ArrayList<String[]> list = new ArrayList<>();
        String sql = "SELECT * FROM User";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String[] row = new String[3];
                row[0] = rs.getString("name");
                row[1] = rs.getString("username");
                row[2] = rs.getString("password");
                list.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<String[]> selectUserByUsername(String keyword) {
        ArrayList<String[]> list = new ArrayList<>();
        String sql = "SELECT * FROM User WHERE username LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String[] row = new String[3];
                    row[0] = rs.getString("name");
                    row[1] = rs.getString("username");
                    row[2] = rs.getString("password");
                    list.add(row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

