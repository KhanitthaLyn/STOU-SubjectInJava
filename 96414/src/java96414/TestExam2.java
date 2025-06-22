package java96414;

//6596007010 นางสาวขนิษฐา ตันตรงดี กลุ่ม 3

public class TestExam2 {
	public static void main(String[] args) {
        // ประกาศและกำหนดค่าให้กับอาร์เรย์
        int[] numbers = {21, 44, 89, 54, 67, 78, 96, 37, 83, 59};

        // แสดงข้อมูลในอาร์เรย์
        System.out.print("ข้อมูลในอาร์เรย์คือ : ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        // ตรวจสอบและแสดงผลตัวเลขที่หารด้วย 11 ลงตัวพร้อม index ลำดับ
        System.out.print("\nตัวเลขที่หารด้วย 11 ลงตัว: ");
        boolean found = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 11 == 0) {
                System.out.println(numbers[i] + " (Index " + i + ")");
                found = true;
            }
        }

        // ถ้าไม่มีตัวเลขที่หารด้วย 11 ลงตัว
        if (!found) {
            System.out.println("ไม่มีตัวเลขในอาร์เรย์ที่หารด้วย 11 ลงตัว");
        }
    }
}
