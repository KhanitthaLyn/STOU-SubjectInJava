package java96414;
import java.util.Scanner;

public class Assignment5 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	StatCal st = new StatCal();
	int count = st.getCount();
	for(int i=0;i<count;i++) {
		
		System.out.println("กรุณากรอกจำนวนเต็ม ลำดับที่ " + (i+1));
		int value = sc.nextInt();
		st.enter(i, value);
		}
	System.out.println("ผมรวมเท่ากับ " + st.getSum());
	System.out.println("ค่าเฉลี่ยเท่ากับ " + st.getMean());
	System.out.println("ส่วนเบี่บงเบนมาตรฐานเท่ากับ " + st.getStdDeviation());
	}
}
	