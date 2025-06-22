package java96414;
import java.util.Scanner;

public class TestExam1 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("กรอกรัศมีของกระบอก : ");
        double radius = scanner.nextDouble();

        System.out.print("กรอกความสูงของกระบอก : ");
        double height = scanner.nextDouble();
        scanner.close();

        double volume = 3.14 * radius * radius * height;
        System.out.println("ปริมาตรของกระบอกคือ: " + volume);
    }
}
