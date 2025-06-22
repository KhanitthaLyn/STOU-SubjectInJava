package java96414;
import java.util.Scanner;

//6596007010 นางสาวขนิษฐา ตันตรงดี กลุ่ม 3

public class TestExam1 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // รับค่ารัศมี (Radius)
        System.out.print("กรอกรัศมีของกระบอก : ");
        double radius = scanner.nextDouble();

        // รับค่าความสูง (Height)
        System.out.print("กรอกความสูงของกระบอก : ");
        double height = scanner.nextDouble();
        scanner.close();

        double volume = 3.14 * radius * radius * height;
        System.out.println("ปริมาตรของกระบอกคือ: " + volume);
    }
}