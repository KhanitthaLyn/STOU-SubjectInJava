package java96414;

import java.util.Scanner;

public class TestCalculation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("กรุฯากรอกตัวเลขที่ 1 : "); 
		int a = sc.nextInt();
		System.out.println("กรุฯากรอกตัวเลขที่ 2 : "); 
		int b = sc.nextInt();

		Calculation cal = new Calculation();
		System.out.println("ผลบวดคือ " + cal.add (a, b) );
		System.out.println("ผลลบคือ " + cal.subtract (a, b) );
		System.out.println("ผลคูณคือ " + cal.multiply (a, b) );
		if (b==0) {
			System.out.println("what");
		} else {
		System.out.println("ผลหารคือ " + cal.divide (a, b) );
		}
		sc.close();
		
	}

}
