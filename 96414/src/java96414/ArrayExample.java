package java96414;
import java.util.Scanner;

public class ArrayExample {

	public static void main(String args[]){ 
    	
		int a[] = new int[5];
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<a.length;i++) {
		System.out.println("กรุฯากรอกตัวเลขที่ : " + i +" : " );  
		
			a[i] = sc.nextInt();
		}
		int max = a[0]; 
		int min = a[0];
		for (int i=1; i<a.length;i++) {
			if (a[i]>max) {
			max = a[i];
		}
			if (a[i]<min) {
				min = a[i];
			}
   
        System.out.println( "ค่าสูงสุดคือ "+max );
        System.out.println( "ค่าต่ำสุดคือ "+min );
    }
}
}