package day05; // 패키지 명칭

import java.util.Arrays; // 배열 출력용 유틸리티 클래스 import

public class B26ExceptionTest2 {

    public static void main(String[] args) {
        // B26ExceptionTest 클래스의 객체 생성
        B26ExceptionTest test = new B26ExceptionTest();

        try {
            // 예외 발생 가능성이 있는 메소드 호출
            test.nullpointer(); // null 값에 접근해서 NullPointerException 유발
            test.inputNumber(); // 사용자 입력 처리, 입력값이 숫자 아닐 시 NumberFormatException 발생
            test.indexExceptionTest(); // 배열 인덱스 초과 접근 → ArrayIndexOutOfBoundsException 발생

        } catch (NumberFormatException e) {
            // 숫자 형식이 잘못되었을 때 처리
            System.out.println("❌ 숫자 형식 오류: " + e.getMessage());

        } catch (ArrayIndexOutOfBoundsException e) {
            // 배열 인덱스를 벗어난 경우 처리
            System.out.println("❌ 배열 인덱스 오류: " + e.getMessage());

        } catch (NullPointerException e) {
            // null 객체에 메서드 접근 시 발생
            System.out.println("❌ NullPointer 오류: " + e.getMessage());

        } catch (Exception e) {
            // 위에서 잡지 못한 모든 예외를 처리하는 범용 catch 문
            System.out.println("❌ 예외 발생: " + e.getClass().getSimpleName() + " - " + e.getMessage());

        } finally {
            // 정상/비정상 실행 모두 끝난 뒤 항상 실행됨 (자원 정리용)
            System.out.println("✅ 프로그램 종료: 모든 자원을 해제합니다.");
        }
    }

    // 사용자에게 정수를 입력받고 1을 더해 출력하는 메서드
    public void inputNumber() {
        // 콘솔에서 입력받음 (단, IDE에서는 null이 될 수 있으니 Scanner 사용 권장)
        String temp = System.console().readLine("정수값 입력 >>> ");

        // 입력값을 문자열에서 정수로 변환 (예외 가능성 존재)
        int num = Integer.parseInt(temp);

        // 입력값에 1 더해서 출력
        System.out.println("입력값 + 1 : " + (++num));
    }

    // 배열 인덱스 초과 접근으로 예외 발생시키는 메서드
    public void indexExceptionTest() {
        int[] nums = new int[5]; // 길이 5짜리 배열 생성 (0~4 인덱스)
        nums[2] = 22; // 정상 범위에 값 대입
        nums[5] = 55; // 오류 발생: 존재하지 않는 인덱스 5에 접근
        System.out.println(Arrays.toString(nums));
    }

    // null 값을 참조하려고 해서 NullPointerException 발생시키는 메서드
    public void nullpointer() {
        String message = null; // null 로 초기화 (아무 객체도 참조하지 않음)
        System.out.println(message.toUpperCase()); // null 에 메서드 호출 → 예외 발생
    }
}
