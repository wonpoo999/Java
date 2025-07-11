package day02;

public class B10SwitchCaseTest {

    public static void main(String[] args) {

        String operator; // +, -, *, / 이 값만 사용 할것이다

        // readLine 문자열로 저장
        boolean status = true;
        while (status) {
            operator = System.console().readLine("연산 선택하기 (+, -, *, /)  | 종료는 N 입력하라>>>");

            switch (operator) {
                case "+":
                    System.out.println("더하기를 선택하였느니라");
                    break;
                case "-":
                    System.out.println("빼기를 선택하였느니라");
                    break;
                case "*":
                    System.out.println("곱하기를 선택하였느니라");
                    break;
                case "/":
                    System.out.println("나누기를 선택하였느니라");
                    break;
                case "N", "n": // while에 대한 종료 조건
                    status = false;
                    break;
                default:
                    System.out.println("잘못된 선택이니라. +, -, &, /, 아니면 N/n 값만 사용하라니까. 반항하는건가?");
                    break;

            }
        }

    }

}
