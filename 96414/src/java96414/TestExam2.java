package java96414;

public class TestExam2 {
	public static void main(String[] args) {
        int[] numbers = {21, 44, 89, 54, 67, 78, 96, 37, 83, 59};
        System.out.print("ข้อมูลในอาร์เรย์คือ : ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.print("\nตัวเลขที่หารด้วย 11 ลงตัว: ");
        boolean found = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 11 == 0) {
                System.out.println(numbers[i] + " (Index " + i + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("ไม่มีตัวเลขในอาร์เรย์ที่หารด้วย 11 ลงตัว");
        }
    }
}
