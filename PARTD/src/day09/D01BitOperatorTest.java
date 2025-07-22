package day09;

public class D01BitOperatorTest {
    public static void main(String[] args) {
        System.out.println("1) 10진수 값의 2진수 문자열 출력");
        System.out.println("Integer.toBinaryString(24): " + Integer.toBinaryString(24));
        // int는 32비트 : 32자리 문자열 출력하려면
        System.out.println("32자리 문자열 " + String.format("%32s", Integer.toBinaryString(24)).replace(" ", "0"));
        System.out.println("");
        System.out.println("\n\n");
        System.out.println("2. Bit AND");
        int result = 24 & 129;
        System.out.println("24 & 129 = " + result);
        System.out.println(to32BitBinary(24));
        System.out.println(to32BitBinary(129));
        System.out.println(to32BitBinary(result));
        System.out.println("3. Bit 배타적 OR[EXCLUSIVE OR] - 두개의 다른 값의 비트를 탐색(2개의 비트가 다를 때)");
        result = 24 | 129;
        System.out.println("24 | 129 = " + result);
        System.out.println(to32BitBinary(24));
        System.out.println(to32BitBinary(129));
        System.out.println(to32BitBinary(result));
        result = 24 ^ 129;
        System.out.println("24 ^ 136 = " + result);
        System.out.println(to32BitBinary(24));
        System.out.println(to32BitBinary(136));
        System.out.println(to32BitBinary(result));

        System.out.println("4. Bit Not - 비트의 반전");
        result = ~24;
        System.out.println("result : " + result); // 음수 표현은 2의 보수 방식으로 표현. ~ not 연산 +1
        System.out.println(to32BitBinary(24) + "(양수 24)");
        System.out.println(to32BitBinary(result) + "(24의 비트 반전 -25)");
        System.out.println(to32BitBinary(-24) + "24의 2의 보수 (-24)");

        // 10 진수를 2진수로 바꿀 때 : 163 = 128 + 32 + 2 + 1 => 00000000 00000000 00000000
        // 10100011
        // 2진수의 자리값은..... 4096 2048 1024 512 256 128 64 32 16 8 4 2 1

        System.out.println("참고: 2진수 문자열을 10진수 int로 변환");
        System.out.println("10100011): " + Integer.parseInt("10100011", 2));
        // 모든 음수값은 맨 좌측 bit가 '1' 입니다.
        // 모든 2진수를 양수로 변환한다. 음수는 - 기호로 사용
        System.out.println("1000101000101010001010100010 : " + Integer.parseInt("10100011", 2));
    }

    private static String to32BitBinary(int x) {
        return String.format("%32s", Integer.toBinaryString(x)).replace(" ", "0");
    }

    // 만약에 양수를 음수로 변화시키는 메소드를 만든다면 부호 반전 + 1을 해야한다
}
