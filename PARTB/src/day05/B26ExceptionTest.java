package day05;

import java.util.Arrays;

public class B26ExceptionTest {

    public static void main(String[] args) {
        B26ExceptionTest test = new B26ExceptionTest();
        test.nullpointer();

        // try 써보면 package에 try_catch 뜨지? 그거 누르고 엔터치면 밑에 처럼 자동 완성된다.
        try {
            test.inputNumber(); // 실행 중 오류가 생기면 catch로 간다아

        } catch (Exception e) { // 예외 정보는 변수 e에 저장된다
            System.out.println("예외 발생: " + e.getMessage());

        } finally {
            // 정살 실행(try) 또는 비정상 실행(catch) 종료 후 정리 작업
            System.out.println("프로그램 종료합니다. 모든 자원을 해제합니다.");
            // XXXX.close()
        }

    }

    /*
     * 아래 3개의 메소드를 실행하면 Exception 이 발생한다.
     * 예외(Exception) : 프로그램 실행이 비정상적인 상황을 만나서 프로그램이 비정상적 종료
     * ㄴ 실행 중에 사용자의 잘못된 입력.
     * ㄴ 개발자가 예측 못한 상황
     * ㄴ 아래 3개의 예외는 실행 중에 발생하는 RuntimeException 종류
     * (컴파일러가 예외 가능성을 모르는 예외)
     * 예외를 예상한다면 ... 개발자는 try{}catch{}finally{}구문 처리
     * 
     * 🔥 Runtime 예외는 try ~ catch(예외처리) 필수가 아닙니다.
     * 🔥 Checked 예외는 반드시 예외처리 해야 한다. Method 중에는 특히 입출력 작업 method는 IOException 예외를 발생시키느니라.
     * IOException이야말로 대표적인 Checked 예외를 발생 시킨다
     * 불꽃은 중요하다
     */

    public void inputNumber() {
        String temp = System.console().readLine("정수값 입력 >>> ");
        int num = Integer.parseInt(temp); // Integer.valueOf(temp) 도 실행 가능하다.
        System.out.println("입력값 + 1 : " + (++num));
        //
        // Integ
        // System.out.println("입력값 + 1 : " + (num++));
        // ++ 앞에도 붙일 수 있고 뒤에도 붙일 수 있다
    }

    public void indexExceptionTest() {
        int[] nums = new int[5];
        nums[2] = 22;
        nums[5] = 55; // java.lang.ArrayIndexOutOfBoundsException
        System.out.println(Arrays.toString(nums));
    }

    public void nullpointer() {
        String message = null; // null로 인해 message 변수에 참조되는 것이 없다. 참조 되려면 객체가 있어야하는데 객체가 없다는 뜻이지
        // 객체가 메소드 또는 속성 접근할 때, 객체가 null 이면 발생.
        System.out.println(message.toUpperCase());
        // java.lang.NullPinterException
    }
}
