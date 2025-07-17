package day07;

public class C08CompareTest {
    public static void main(String[] args) {
        // wrapper 클래스 : Integer, Double, ...
        // compareTo 메소드가 있다 => implements Comparable

        Integer n1 = 23; // int가 Integer 타입으로 자동 캐스팅 저장
        Integer n2 = 34;
        // 기본적 비교
        System.out.println(n1 < n2);
        int diff = n1 - n2; // diff > 0 일때 n1>n2 , diff < 0 일때는 n1 < n2

        // Comparable 인터페이스의 추상 메소드 : compareTo
        // Integer, Double,.. 등의 Wrapper class는 compareTo 메소드는 -1, 0, 1 return
        diff = n1.compareTo(n2);
        System.out.println("n1.compareTo(n2) : " + diff); // -1 n1 - n2 < 0 이라서 -1 return
        diff = n2.compareTo(n1);
        System.out.println("n2.compareTo(n1) : " + diff); // 1 n2 - n1 > 0 이라서 1 return

        // String 타입의 compareTo는 문자의 차이
        String name1 = "aoxaa";
        String name2 = "aozbb";
        // diff = name1 - name2;
        // System.out.println(name1 < name2);
        diff = name1.compareTo(name2);
        System.out.println("name1.compareTo(name2): " + diff);

    }
}
