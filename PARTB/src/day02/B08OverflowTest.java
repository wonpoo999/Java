// Java는 Backend. Frontend 보다 더 처리하는 일이 많아

package day02;

public class B08OverflowTest {

    public static void main(String[] args) {
        System.out.println("데이터 타입별 크기");
        System.out.println("int: " + Integer.SIZE + "비트, " + Integer.BYTES + "바이트");
        System.out.println("int: " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
        // -2147483648 ~ 2147483647
        System.out.println("Long: " + Long.SIZE + " ~ " + Long.BYTES + "바이츠");
        System.out.println("Long: " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
        // -9223372036854775808 ~ 9223372036854775807

        int a = 2147483647;
        int b = a + 1; // 표현의 범위가 넘어감(초과 ) : overflow
        System.out.println("int b=" + b); // -2147483648 기대값과 다릅니다.

        long c = a + 1L; // a + 1은 둘다 int이므로 int 계산, a+1L 와 같이 적어도 하나는 long 데이터로 해야 하느니라.
        System.out.println("long c=" + c);

        System.out.println("Math.addExact(a, 1L): " + Math.addExact(a, 1L));
        System.out.println("Math.addExact(a, 1): " + Math.addExact(a, 1)); // 예외 발생

    }
}
