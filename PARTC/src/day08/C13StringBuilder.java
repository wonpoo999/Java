package day08;

// 문자열 저장 객체(클래스 타입) : String(불변객체), StringBuilder(1.5버전), StringBuffer(1.0 버전)
// String과 StringBuilder 비교
public class C13StringBuilder {

    public static void main(String[] args) {
        // 불변 객체
        String str = new String("Hello~");
        // 가변 객체
        StringBuilder sb = new StringBuilder("Hello~");

        System.out.println("~~~ 초기 상태의 참조값 ~~~");
        System.out.println("str hashcode : " + Integer.toHexString(str.hashCode()));
        System.out.println("sb hashcode : " + Integer.toHexString(sb.hashCode()));

        // 각 str, sb에 문자열 "자바!!" 를 연결한다
        str += " 자바!!";
        sb.append(" 자바!!");

        System.out.println("~~~ 다른 문자열 연결 후 ~~~");
        System.out.println("String str: " + str);
        System.out.println("StringBuilder sb: " + sb);

        System.out.println("~~~ 다른 문자열 연결 후 참조값 ~~~");
        System.out.println("str hashcode : " + Integer.toHexString(str.hashCode()));
        System.out.println("sb hashcode : " + Integer.toHexString(sb.hashCode())); // 전후가 같아야 한다, 즉 초기 상태와 같은 값.

        // 문자열의 메-소드 중 일부는 CharSequence 인터페이스 구현(없었던 것을 만드는거) (재정의) 메소드
        System.out.println(str.length());
        System.out.println(str.charAt(2)); // 추상 메소드 재정의해서 쓰는거.
        System.out.println(str.toString());
        System.out.println(str.isEmpty()); // default 메소드로 정의
        // 결론 : 🔥String, StringBuilder는 CharSequence interface를 구현한 class이다.
        System.out.println("sb 메소드 실행");
        System.out.println(str.length());
        System.out.println(str.charAt(2));
        System.out.println(str.toString());
        System.out.println(str.isEmpty());
        // String 문자열 메소드는 인자 타입으로 CharSequence 것이 있다.
        str = "Hello~ java, react";
        StringBuilder temp = new StringBuilder("java");
        System.out.println(str.contains(temp));
        System.out.println(str.replace(temp, "자바"));

        // StringBuilder는 문자열 저장 가변객체를 생성한다
        // 문자열을 변경하려 append(), insert(), delete(),
        temp.append("자바").append(",").append(10).replace(2, 4, "*");
        // "va" 문자열을 "*"로 치환
        System.out.println(temp);

    }

}
