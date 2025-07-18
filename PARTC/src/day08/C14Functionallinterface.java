package day08;

public class C14Functionallinterface {

    public static void main(String[] args) {
        // ITestA 인터페이수 구현한 익명 클래스 정의
        ITestA ta = new ITestA() {
            @Override
            public void testa(String message) {
                System.out.println("testa: " + message);
                ITestC tc = (a, b) -> a * b;
                System.out.println("결과 : " + tc.testc(10, 4));
            }
        };

        ta.testa("오늘은 신나는 금요일!!");

        ITestA ta2 = (message) -> System.out.println("testa: " + message);
        ta2.testa("굿바이~~");
        // ta2.testa(34); //오류: 인자 타입은 선언된 String으로 해야함.
        // 아니면 이 주석 처리된 거 처럼 오류 뜬다
    }
}

/*
 * 자바의 인터페이스 중에는 인자, 리턴값의 유무 등등에 따라
 * 다양한 형식의 인터페이스가 있다.
 * 이 인터페이스들의 특징은 추상 메소드가 딱 1개만 정의되어있어.
 * 이것을 다른 프로그래밍언어의 함수처럼 사용한다
 * 자바는 함수 개념은 없고 객체를 중심으로하는 메소드만 있다했지?
 * 그래서 인터페이스를 이용해서 다른 프로그래밍의 함수처럼 써. 어떻게보면
 * 콜백함수처럼 쓰기 위해 이런게 존재한다 생각하면 된다.
 * 함수형 인터페이스를 익명 클래스로 만들 때 람다식을 써.
 * 자바스크립트에서는 람다식이 화살표 함수였지?
 * 
 * 인자, 리턴 / 있다(O)? 없다(X)?
 */

interface ITestA {
    void testa(String message); // 인자 0, 리턴 X
}

interface ITestB {
    int testb(); // 인자 X, 리턴 O
}

interface ITestC {
    int testc(int a, int b); // 인자 O, 리턴 O
}
