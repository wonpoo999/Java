package day02;

public class B07AMyCalculatorTest {

    public static void main(String[] args) {

        // 파일 안엣서 MyCalculator 클래스 정의

        // Method static
        // - add (data1, data2) : 덧겜 결과 리턴
        // - substract (data1, data2) : 뺄셈 결과 리턴
        // - multiply (data1, data2) : 곱셈 결과 리턴
        // - divide (data1, data2) : 나눗셈 결과 리턴
        // ㄴ 0 으로 나눌 수 없음.

    }

    // 덧셈 메소드
    public static int add(int data1, int data2) {
        return data1 + data2;
    }

    // 뺄셈 메소드
    public static int subtract(int data1, int data2) {
        return data1 - data2;
    }

    // 곱셈 메소드
    public static int multiply(int data1, int data2) {
        return data1 * data2;
    }

    // 나눗셈 메소드 (0으로 나누는 경우 처리)
    public static double divide(int data1, int data2) {
        if (data2 == 0) {
            System.out.println("오류: 0으로 나눌 수 없습니다!");
            return Double.NaN; // Not a Number 반환 (오류를 나타내는 특별한 double 값)
        }
        return (double) data1 / data2;
    }
}
