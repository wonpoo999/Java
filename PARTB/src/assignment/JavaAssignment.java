package assignment;

import java.util.Scanner; // 사용자 입력을 위한 클래스         // 참고: B05ConsoleInput.java
import java.util.Random; // 랜덤 숫자 생성을 위한 클래스      // 참고: B21MathRandom.java

public class JavaAssignment {

    static class GameValue { // 게임 결과를 담는 static 내부 클래스 구조 // 참고: ScoreDoneByMe.java
        String gamer; // 참가자 이름 // 참고: ScoreDoneByMe.java
        int tryCount; // 시도 횟수 // 참고: ScoreDoneByMe.java
        boolean success; // 성공 여부 // 참고: ScoreDoneByMe.java
        int answer; // 정답 번호 저장용 필드 // 🔹 추가된 필드

        public GameValue(String gamer, int tryCount, boolean success, int answer) { // 생성자 초기화
            this.gamer = gamer;
            this.tryCount = tryCount;
            this.success = success;
            this.answer = answer;
        }

        public void showResult() { // 결과 출력 메서드 // 참고: B12ScoreInstanceMethod.java
            System.out.println("GameValue 객체 확인");
            System.out.println("gamer : " + gamer);
            System.out.println("시도횟수 : " + tryCount);
            System.out.println("성공여부 : " + success);
            System.out.println("정답 : " + answer); // 🔹 정답도 함께 출력
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 사용자 입력을 위한 Scanner 객체 생성 // 참고: B05ConsoleInput.java
        Random rand = new Random(); // 1~50 범위의 랜덤 숫자를 만들기 위한 Random 객체 // 참고: B21MathRandom.java

        System.out.println("【【【【【 숫자게임을 시작합니다. 】】】】】");
        System.out.println("- AI는 숫자를 결정했습니다.");
        System.out.println("- 너 휴먼은 맞춰보세요. (숫자는 1부터 50 안에서 정하세요.) -");
        System.out.println("@@@ 시도 제한 횟수는 5입니다. @@@");

        int answer = rand.nextInt(50) + 1; // 정답 숫자 생성: 1~50 범위 // 참고: B21MathRandom.java
        int maxTry = 5; // 최대 시도 횟수 정의
        int[] inputs = new int[maxTry]; // 사용자 입력값 저장할 배열 // 참고: B19MyArrayMethod.java
        int count = 0; // 현재까지 시도 횟수
        boolean success = false; // 정답 여부 플래그

        System.out.print("참가자 닉네임 (종료:end) >>> "); // 사용자 입력 요청
        String name = sc.nextLine(); // 참가자 이름 입력 // 참고: B05ConsoleInput.java

        if (name.equalsIgnoreCase("end")) { // 종료 조건 판단 // 참고: B11StringInstanceMethod.java
            System.out.println("::프로그램 종료::");
            sc.close(); // 💡 입력 스트림 닫기 // 참고: 리소스 누수 경고 해결
            return;
        }

        do { // do~while 반복문 시작 // 새 문법: 본 과제에서 최초 사용
            System.out.print("너 휴먼 생각한 숫자 입력 (남은 기회 : " + (maxTry - count) + ") >>> ");
            int guess = sc.nextInt(); // 사용자 숫자 입력 // 참고: B05ConsoleInput.java
            inputs[count] = guess; // 배열에 입력값 저장 // 참고: B19MyArrayMethod.java
            count++; // 시도 횟수 증가

            if (guess == answer) { // 정답인 경우
                System.out.println("딩동댕!! 정답입니다!");
                success = true;
                break;
            } else if (guess < answer) {
                System.out.println("아닙니다. 더 큰값입니다.");
            } else {
                System.out.println("아닙니다. 더 작은값입니다.");
            }
        } while (count < maxTry); // 시도 횟수가 5회 미만인 동안 반복

        System.out.print("✓ 입력했던 숫자 : "); // 사용자가 입력한 숫자 나열
        for (int i = 0; i < count; i++) {
            System.out.print(inputs[i]);
            if (i < count - 1)
                System.out.print(", ");
        }
        System.out.println();

        if (success) { // 성공 여부에 따른 메시지
            System.out.println("숫자 맞추기 성공!!");
        } else {
            System.out.println("아쉽지만 기회를 다 쓰셨습니다. 게임을 다시 시작하세요..!!");
        }

        GameValue result = new GameValue(name, count, success, answer); // 결과 객체 생성 (정답 포함) // 참고: ScoreDoneByMe.java
        result.showResult(); // 결과 출력 메서드 호출 // 참고: B12ScoreInstanceMethod.java

        sc.close(); // 💡 Scanner 객체 닫기 (리소스 누수 방지) // 참고: 리소스 경고 해결
    }
}
