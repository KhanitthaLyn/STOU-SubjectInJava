package java96414;
import java.util.*;
public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("กรุฯากรอกตัวเลขที่ 1 : "); 
		int a = sc.nextInt();
		System.out.println("กรุฯากรอกตัวเลขที่ 2 : "); 
		int b = sc.nextInt();
	
	
		int add = a+b;
		int subtract = a-b;
		int multiply = a*b;
		double divide = (double)a/(double)b;
		
		System.out.println("ผลพวกคือ " + add); 
		System.out.println("ผลลบคือ " + subtract); 
		System.out.println("ผลคูณคือ " + multiply); 
		System.out.println("ผลหารคือ " + String.format("%.2f", divide)); 
		sc.close();
	}

}
