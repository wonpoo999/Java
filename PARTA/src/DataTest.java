public class DataTest {

    public static void main(String[] args) {
        // System 클래스의 out 속성 (객체타입)이 printIn() 메소드 제공
        // -> 콘솔 (터미널) 출력
        System.out.println("2025년 7월 9일 수요일 자바 첫번째 코드 ----------");
        //(1) 변수 활용 - 변수 선언할 때 데이터형식과 변수명이 필요하다. (int, double, boolean, char, String)
        int myage = 16;                     //myage 변수이름에 int 정수 데이터 저장
        double weight = 49.456;         //weight                double 실수
        boolean isAdult=false;             //isAdult                boolean 블린
        char gender = 'F';                  //gender                char 문자(반드시1개)-기호 '  '
        String name="shirasoni";       //nam                    String 클래스 문자열 -기호 " "

        System.out.println("myage:" + myage);  // + 는 문자열에서 연결 연산을 한다.
        System.out.println("weight:" + weight);
        System.out.println("name:" + name);
        System.out.println("isAdult:"+ (isAdult? "성인":"청소년") );
        System.out.println("isAdult:"+ isAdult);
        System.out.println("gender:" + gender);

        //(2) 변수의 초기값 변경
        name="Shirasoni ★";
        weight = 45;   // double로 만들어진 변수이니라. 값은 정수(true)값 저장 가능해. 아무 문제 없어.
        myage=16;     // init                     .실수(false) 데이터는 저장 못하느니라 기존에 정해둔 16 미만은 안 된다.

        // 왜? 메모리 저장 공간 int 4 바이트, double은 8바이트. 자바스크립트 할 때는 브라우저가 모든 걸 똑같이 취급하고 알아서 처리하니까. 근데 자바에서는 int에 큰 데이터인 double을 넣으면 안 된다니까.

        // 정수: 메모리에 저장되는 크기 (용량)에 따라 4가지가 있느니
        //          byte: 1 byte 저장할 수 있는 데이터의 범위는 : -128 ~ 127
        //          short: 2 byte 저장할 수 있는 데이터의 범위: -32768 ~ 32767
        //          int: 4 byte. 정수의 기본 형식 : 저장할 수 있는 데이터의 범위 : -2147483648 ~ 2147483647
        //          long 8 byte.
        //          float
        //          double
        //          char
        //          boolean 는
        // primitive (기본 / 원형) 타입들 - 데이터를 stack에 저장한다네.    [소문자다] 기본타입이라네

        // Java에서는 Byte, Short, Integer, Long, Float, Double, Character, Boolean       [대문자이니라] [객체로 다루기 위해]
        // Class (기본 데이터 타입을 객체로 다룰 수 있는 wrapper class를 갖고 있느니)

        
    }
}
