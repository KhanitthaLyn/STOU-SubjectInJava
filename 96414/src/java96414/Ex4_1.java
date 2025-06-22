package java96414;

import java.util.Scanner;

public class Ex4_1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("กรอกคะแนน : "); 
		int score = sc.nextInt();
		if(score>=80) {
			System.out.println("ได้เกรด A"); 
		} else {
			if (score>=70-79) {
				System.out.println("ได้เกรด B"); 
			} else {
				if (score>=60-69) {
					System.out.println("ได้เกรด C"); 
				} else {
					if (score>=50-59) {
						System.out.println("ได้เกรด D");
					} else {
					System.out.println("ได่้เกรด F"); 
				}
				}
			}
		}
	}
}
			
