package day02;

public class B07BTestCalculator {

    public static void main(String[] args) {
        System.out.println("계산기이니라");
        System.out.println("숫자와 연산자를 입력하거라");
        System.out.println("일부 IDE에서는 System.console()이 작동하지 않을 수 있음을 알라");
        System.out.println("만약 input prompt가 보이즈 않는다면 terminal에서 직접 실행해보거라");

        // System.console() 은 콘솔 객체를 반환한다.
        // 이 Object가 null이 아닐 때만 사용자 입력을 받을 수 있느니라
        if (System.console() != null) {
            // 첫 번째 숫자 입력 받기
            String num1Str = System.console().readLine("첫 번째 숫자 입력: ");
            // 두 번째 숫자 입력 받기
            String num2Str = System.console().readLine("두 번째 숫자 입력:");
            // 연산자 입력 받기
            String operator = System.console().readLine("연산자 입력 (+, -, *, /):");

            // 입력받은 문자열을 정수(int)로 변환합니다. (B05ConsoleInput 참조)
            int num1 = Integer.valueOf(num1Str);
            int num2 = Integer.valueOf(num2Str);

            double result = 0; // 계산 결과를 저장할 변수

            // switch 문을 사용하여 입력받은 연산자에 따라 다른 계산 수행
            switch (operator) {
                case "+":
                    result = B07AMyCalculatorTest.add(num1, num2);
                    System.out.println("결과: " + num1 + " + " + num2 + " = " + result);
                    break; // 해당 case가 끝나면 switch 문을 빠져나옵니다.
                case "-":
                    result = B07AMyCalculatorTest.subtract(num1, num2);
                    System.out.println("결과: " + num1 + " - " + num2 + " = " + result);
                    break;
                case "*":
                    result = B07AMyCalculatorTest.multiply(num1, num2);
                    System.out.println("결과: " + num1 + " * " + num2 + " = " + result);
                    break;
                case "/":
                    result = B07AMyCalculatorTest.divide(num1, num2);
                    // B07AMyCalculatorTest.divide() 메소드에서 0으로 나눌 경우 이미 오류 메시지를 출력하고 0.0을 반환합니다.
                    // 따라서 결과가 0.0이 아니고, 실제로 num2가 0이 아닐 때만 정상적인 나눗셈 결과를 출력합니다.
                    if (result != 0.0 || num2 != 0) {
                        System.out.println("결과: " + num1 + " / " + num2 + " = " + result);
                    }
                    break;
                default: // 위에 정의된 연산자가 아닌 경우
                    System.out.println("오류: 지원하지 않는 연산자입니다. (+, -, *, / 중 하나를 입력해주세요)");
            }
        } else {
            System.out.println("\n--- System.console()을 사용할 수 없는 환경입니다. ---");
            System.out.println("이 프로그램은 System.console()을 사용합니다. ");
            System.out.println("VS Code의 'Run' 버튼 대신, 터미널(명령 프롬프트)에서 직접 컴파일 후 실행해야 합니다.");
            System.out.println("예시: ");
            System.out.println("  1. day02 폴더로 이동: cd your_project_path/day02");
            System.out.println("  2. 컴파일: javac MyCalculator.java InteractiveCalculator.java");
            System.out.println("  3. 실행: java InteractiveCalculator");
            System.out.println("위와 같이 실행하면 콘솔에서 직접 값을 입력할 수 있습니다.");
        }

        System.out.println("\n===== 콘솔 계산기 앱 종료 =====");
    }
}
