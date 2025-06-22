package java96414;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = 0;
		for(int i=0; i<10;i++) {
			System.out.println("กรอกตัวเลข " + (i+1) + " : ");
			a = a + sc.nextInt();
			
			
		}
		System.out.println("ผลยวกคือ " + a);
		System.out.println("ค่าเฉลี่ยคือ " + (double)a/10);
	}

}
