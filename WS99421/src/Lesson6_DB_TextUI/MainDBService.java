package Lesson6_DB_TextUI;

import java.util.ArrayList;

public class MainDBService {

	public static void main(String[] args) {
		DBService dbs = new DBService();
		System.out.println(dbs.con);
		
//		Product p1 = new Product("p0001","TV");
//		dbs.insertProduct(p1);
		
//		Product p2 = new Product("p0002","Table");
//		dbs.insertProduct(p2);

//		dbs.deleteProduct("p03");	
//		dbs.deleteProduct(p1);

//		// update
		
//		Product p3 = new Product("p9999","bed");
//		dbs.insertProduct(p3);
		
//		p3.setProductname("bedcloth");
//		dbs.updateProduct(p3);
		
//		select
		ArrayList<Product> result = dbs.selectProduct();
		System.out.println(result);
		

		

		
	}
		
	}
