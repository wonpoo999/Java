package day04;

public class B17ConstructorTest {

    public static void main(String[] args) {
        People sana = new People();
        // 기본 생성자 실행

        // 커스텀 생성자 실행
        People momo = new People("김모모", 24, true);
        // 구현하기 전에 에러 날껄?
        // 생성자의 3개 인자값이 생성자로 전달되어 인스턴스 변수의 초기값으로 설정됩니다.
        // setter 실행하지 않고 객체 만들 때 값 초기화

        System.out.println("기본 생성자로 만든 sana: " + sana);
        System.out.println("커스텀 생성자로 만든 momo: " + momo);

    }

    // 1) 기본 생성자는 컴파일러가 알아서 자동으로 만들어준다.
    // 그래서 이거 때문에 new People()로 객체생성할 때 People()가 기본 생성자 method 실행합니다.

}
