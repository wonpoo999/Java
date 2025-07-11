package day02;

public class B06MyMethodTest {

    public static void main(String[] args) {
        MyClass.hello("String language");
        MyClass.message = "Yo, it's chronic~ Intoxication";
        System.out.println(MyClass.message);
        MyClass.hello("React");
        MyClass.hello("HTML");

        System.out.println("MyClass message 변수 문자열 :" + MyClass.getMessage());
        System.out.println("MyClass message 변수 문자열 :" + MyClass.getMessageLength());

    }

};

// *
// * 메소드의 형식.
// * ㄴ 정해진 기능을 처리. 재사용성을 위한 함수 형식
// * ㄴ 인자, 리턴, 유무, 조합으로 4가지 형식 가능
// *
// * static 키워드 : 객체를 new 연산으로 만들지 않고 클래스이름으로 바로 사용할 수 있는 형식이다. static는 객체 개념과
// 상관이 없어.
// *

class MyClass {

    static String message;

    // 메소드 인자가 없는 것 vs 있는 것
    static void hello() {
        System.out.println("__________________");
        System.out.println("Welcome to java world");
        System.out.println("__________________");
    }

    static void hello(String language) {
        System.out.println("__________________");
        System.out.println("Welcome to java world" + language); // language 변수는 메소드 입력값 => 인자로 선언

        System.out.println("__________________");

    }

    // return 있는 method
    static String getMessage() {
        return message;
    }

    // 숫자는 int

    static int getMessageLength() {
        return message.length(); // length() : 문자열의 길이를 구하는 메소드
    }

    // getStringInfo(문자열) 실행하면 문자열의 길이를 리턴하는 method 이니라
    static int getStringInfo(String data) {
        return data.length();
    }
}
