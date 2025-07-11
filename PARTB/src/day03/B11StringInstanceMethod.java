package day03;

// String 클래스의 인스턴스 메소드
//                        ㄴ InstanceMethod는 생성된 객체를 대상으로 실행하며 객체의 값에따라 결과가 달라진다네
public class B11StringInstanceMethod {

    public static void main(String[] args) {

        String message = "hello";
        // String temp = new String("hello"); // 참조값이 다른 하나가 이 temp이니라. 문제 풀었던 거 생각해보시게나
        // String temp2 ="hello";

        // message 문자열 객체의 Instance Method (JavaScript, python 등 거의 유사하다)
        message = "Yo it's chronic, intoxication!!"; // 무낮열을 구성하는 문자의 위치는 0 부터 시작하느니라
        System.out.println(message); // message.toString()이 override 재정의/덮어쓰기 되어 실행되느니라
        System.out.println(message.length()); // int - - 글자수 - 31
        System.out.println(message.charAt(4)); // 몇번째 letter
        System.out.println(message.toUpperCase()); // String
        System.out.println(message.toLowerCase()); // init
        System.out.println(message.indexOf("chronic")); // boolean 몇번쨰 단어의 위치
        System.out.println(message.startsWith("Yo")); // boolean
        System.out.println(message.endsWith("it's")); // String
        System.out.println(message.replace(" ", "*")); // String
        System.out.println(message.substring(1, 4)); // String 그 위치 letter 뺴와라
        System.out.println(message.substring(1)); // String 그 위치의 단어 뺴와라
        System.out.println(message.lastIndexOf(" ")); // int
        System.out.println(message.concat("!!!!")); // String
        System.out.println(message.equals("Yo it's chronic, intoxication!!")); // boolean 같냐? 출력되야 할 문장이 내가 equal에 쓴
                                                                               // 문장이랑 동일하냐?

        String test = " ";
        System.out.println(test.isBlank()); // test. length() > 0, 공백만 있으면 true
        System.out.println(test.isEmpty()); // 문자열의 길이가 0 일때 true

        // 정규식 패턴을 검사 : 예시 ) 핸드폰 번호 010-숫자4자리-숫자4자리
        String regex = "%010-\\d{4}=\\d{4}$";
        String hpnum = "010-3456-789";

        System.out.println(hpnum.matches(regex)); // true
        System.out.println("011-345-6789"); // false
        System.out.println("0103456789.matches(regex)"); // false

        String name = "김두한"; // 이름은 한글만 허용
        // 순서는 없고, 가능한 문자를 [] 기호 안에 나열, 범위는 a-z 또는 A-Z;// + 기호는 반드시 한글자 이상.;
        regex = "^[가-힣]{2,5}$"; // "^[가-힣]+$"; 는 이름이 1개 문자일때도 허용
        System.out.println(name.matches(regex)); // true
        System.out.println("john".matches(regex)); // false
        // 영문자 검사
        System.out.println("john".matches("^[a-zA-Z\\s]+$")); // true

    }

}
