package java96414;
import java.util.Scanner;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] number = new int[20];
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int i=0;i<number.length;i++) {
			System.out.println("กรุฯากรอกจำนวนเต็ม ลำดับที่ " + (i+1));
			
			int value = sc.nextInt();
			number[i] = value;
			sum=sum+number[i];
			
		}
		System.out.println("ผลรวมเท่ากับ " + sum);
		double average = (double)sum/number.length;
		System.out.println("ค่าเฉลี่ยเท่ากับ " + String.format("%.2f", average));
		
		double summation =0;
		
		for(int i=0;i<number.length;i++) {
			summation = summation + Math.pow(number[i] - average, 2); 
		}
		double sd = Math.sqrt(summation/number.length);
		System.out.println("ส่วนเบี่บงเบนมาตรฐานเท่ากับ " + sd);
	}

}
