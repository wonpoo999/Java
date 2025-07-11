package day03;

// People 클래스 활용
public class B15PeopleTest {
    public static void main(String[] args) {
        People bang = new People();
        bang.getName();
        bang.getName();
        System.out.println("회원 이름: " + bang.getName()); // 객체의 기본값

        // momo 객체에게 name 필드를 "뱅" 하고 싶은데....
        bang.setName("뱅");
        System.out.println("bang 회원 이름: " + bang.getName());

        People seonpung = new People();
        seonpung.setName("선풍");
        System.out.println("seonpung 회원 이름: " + seonpung.getName());

    }
}
