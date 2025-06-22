package java96414;

import java.util.Scanner;

public class EX3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("fill number 1 : ");
		int a =sc.nextInt();
		int sum = 0;
		int i =1;
		while (a>=0) {
			sum = sum +a;
			System.out.println("number : " + (i+1) + " : ");
			a = sc.nextInt();
			i = i+1;
		}
		System.out.println("ผลบวกคือ " + sum);
	}

}
