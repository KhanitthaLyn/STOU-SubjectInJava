package Lesson6_DB_TextUI;

public class TestProduct {

	public static void main(String[] args) {
		// create 2 product
		Product p1 = new Product("p0001","TV");
		p1.setProductname("Smart TV");
		System.out.println(p1);
		
		Product p2 = new Product("p0001","Fridge");
		p2.setProductid("p1000");
		System.out.println(p2);
	}
}
