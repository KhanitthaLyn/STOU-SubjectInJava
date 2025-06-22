package java96414;
import java.util.Scanner;

//6596007010 นางสาวขนิษฐา ตันตรงดี กลุ่ม 3

public class TestExam3 {

	public static void main(String[] args) {
        Square square = new Square();
        Scanner scanner = new Scanner(System.in);
        System.out.print("รอกความยาวด้านของสี่เหลี่ยม: ");
        square.side = scanner.nextDouble();
        scanner.close();

        square.showResult();
    }
}