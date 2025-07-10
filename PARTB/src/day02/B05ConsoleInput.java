package day02;

// console input은 여러 Class로부터 지원을 받을 수 있느니라
public class B05ConsoleInput {

    public static void main(String[] args) {
        // System.out.println();
        String name = System.console().readLine("이름 >>> ");
        // 입력값 저장변수는 String 타입. System.console().readLine()의 결과로 콘솔에 입력한 문자열을 리턴한다.
        System.out.println("입력된 이름: " + name);

        int age; // 나이는 정수로 저장하고 싶다

        String temp = System.console().readLine("나이>>>");
        // 문자열을 정수로 변환 age 변수에 저장
        age = Integer.valueOf(temp); // integer는 class이니라

        // double 이라는 Class 이름
        double weight; // 몸무게는 실수로 저장하고 싶다
        temp = System.console().readLine("몸무게>>>");

        // 문자열을 실수로 변환하여 weight 변수에 저장
        weight = Double.valueOf(temp);
        System.out.println("나이: " + age + "," + "몸무게: " + weight);

        // 정수, 실수, 불린, 이런 값들을 문자열로 변환시켜주는 method가 있느니라. 무엇이냐고?
        // String.valueOf(이 괄호 안에 어떤 값이든 간에 문자열로 변환시켜주느리라);
        // 자바는 이름을 바꾸지 않는다. String에 method들끼리 연관성을 만들어서 구현을 해놨다.

    }

}
