package Lesson6_DB_TextUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// public class DBConnection {
	// attribute
	
	// method
	// empty constructor
//	public DBConnection() {
		//System.out.println("Hello Database");
		// 1) 
		// loadDriver();
		// 2)
		// getConnection();
	//}
	
	// loadClass
	//public void loadDriver() {
		//System.out.println("Loading Driver....");
		//try {
		//	Class.forName("com.mysql.cj.jdbc.Driver");
		//	System.out.println("Driver loaded successfully....");			
		//} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
	//		System.out.println("Cannot load driver");			
	//	}
//	}
	
	//public Connection getConnection() {
	//	System.out.println("Connecting Database....");
	//	try {
		//	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb?user=root&password=Pirom1446262B@");
		//	System.out.println("Database Connected");
		//	return con;
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	System.out.println("Cannot Connect!!!!");
		//	e.printStackTrace();
	///		return null;
	//	}		
//	}	
//}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static void loadClass() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/UserDB";
        String user = "assign3";          
        String password = "123456";          
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
