package java96414;

import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("กรุฯากรอกอายุ : "); 
		int age = sc.nextInt();
		if(age >10) {
			System.out.println("รับประมาน 2 ช้อนชา"); 
		} else {
			if (age>3) {
				System.out.println("รับประมาน 1 ช้อนชา"); 
			} else {
				if (age>1) {
					System.out.println("รับประมาน 1/2 ช้อนชา"); 
				} else {
					System.out.println("ห้ามรับประมาน"); 
				}
			}
		}
		
		//else if (age>3) {
		//System.out.println("รับประมาน 2 ช้อนชา"); 
		// } else if (age>1) {
		// System.out.println("รับประมาน 1/2 ช้อนชา"); 
		// else {
		//System.out.println("ห้ามรับประมาน");

	}

}
