package java96414;
//6596007010 นางสาวขนิษฐา ตันตรงดี กลุ่ม 3

public class Square {
    double side;
    double calArea() {
        return Math.pow(side, 2);
    }
    double findPerimeter() {
        return 4 * side;
    }
    void showResult() {
        System.out.printf("พื้นที่ของสี่เหลี่ยม: %.2f\n", calArea());
        System.out.printf("ความยาวเส้นรอบรูป: %.2f\n", findPerimeter());
    }
}
