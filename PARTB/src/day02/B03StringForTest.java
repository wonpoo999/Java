package day02;

public class B03StringForTest {

    public static void main(String[] args) {

        // for (초기값; 조건식; 증감식)

        // int는 i라고 초기값을 줘보자

        String test = "테스트";
        for (int i = 0; i < 5; i++) {
            test = test + " " + i; // " " = 공백이니라 //기존 test 문자열에 공백과 i 값을 연결해서 test 변수로 참조시켜라 . 보다보면 기존 테스트에 공백을
                                   // 연결하여 테스트를 변수로 참조시키는겨.
            System.out.println(test);
        }
        // test가 초기값 이후 5번이나 변경된겨. -> 6개의 문자열 객체가 생성
        // 객체를 사용하는 관점에서 동일하게 유지하고 싶다면 StringBuffer, StringBuilder 클래스 사용. 즉 이건 불변객체가
        // 아니다 immutable object가 아니라니까. 자바에는 클래스가 많으니 알아두거라.

    }

}
