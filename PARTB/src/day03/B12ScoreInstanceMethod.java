package day03;

// 우리, 개발자가 정의하는 클래스에 Instance Method 추가해보기
public class B12ScoreInstanceMethod {

    public static void main(String[] args) {

        Score JohnDoe = new Score();
        JohnDoe.name = "존 도";
        JohnDoe.kor = 100;
        JohnDoe.eng = 100;
        JohnDoe.math = 100;

        System.out.println("객체의 값 유효성 검사하기 -------");
        System.out.println("name : " + JohnDoe.isNameValid());
        System.out.println("kor : " + JohnDoe.isKorValid());
        System.out.println("eng : " + JohnDoe.isEngValid());
        System.out.println("math : " + JohnDoe.isMathValid());
        System.out.println("모든 점수 : " + JohnDoe.isScoresValid());
        System.out.println("점수 수정 중......");

        JohnDoe.eng = 100;
        if (JohnDoe.isScoresValid()) {
            // 점수 합계
            System.out.println("총점: " + JohnDoe.sum());
            System.out.println("평균: " + JohnDoe.average());
            System.out.println("학점: " + JohnDoe.getGrade());
        } else {
            // 이스케이프 문자 \\ , \"
            System.out.println("점수값 오류 (\"모든 과목의 점수는 \\0~100\\ 로 합니다.\")");
            System.out.println("학점:" + JohnDoe.getGrade()); // 'E'
        }

        int grade = 100;

        switch (grade / 10) { // grade를 10으로 나눈 몫을 기준으로 스위치
            case 10: // 100점대 (grade가 100이면 몫이 10)
                System.out.println("학점: S");
                break;
            case 9: // 90점대 (grade가 90~99이면 몫이 9)
                System.out.println("학점: A");
                break;
            case 8: // 80점대 (grade가 80~89이면 몫이 8)
                System.out.println("학점: B");
                break;
            case 7: // 70점대
                System.out.println("학점: C");
                break;
            case 6: // 60점대
                System.out.println("학점: D");
                break;
            default: // 60점 미만 (나머지, 0~59점대)
                System.out.println("학점: F");
                break;

        }
    }

}

class Score {
    String name;
    int kor;
    int eng;
    int math;

    // 점수의 합계 구하기 - int 리턴

    int sum() {
        return kor + eng + math;
    }

    double average() {
        // 나눗셈 결과를 실수로 하고 싶다면 ..... 2개의 정수 증 하나를 실수로 변경
        // 강제 형변환-casting. 값 앞에 (double) 변수명. 기본형 끼리 (primitive type) 끼리만 변환 할 있너
        // 정수와 실수는 둘다 수치
        // 문자열과 실수는 성격이 다름. -> 강제 캐스팅 X, Double.valueOf 만 가능하노라
        //
        return (double) sum() / 3;
    }

    // 평균 90 점 이상 A, 80점 이상 B, 70점 이상 C, 그 외에는 F - char return
    // ㄴ 정수 / / 정수 = 정수 (몫)
    char getGrade() {

        int average = sum() / 3;
        char grade;

        switch (average / 10) {
            case 10, 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6, 5, 4, 3, 2, 1, 0:
                grade = 'F';
                break;
            default:
                grade = 'E';
                break;
        }
        return grade;
    }

    // 이름 패턴 검사 - True or False를 반환(Return), 즉 정규식을 통과하면 참(True), 통과 못하면 거짓(False).
    // Return method는 isXXXXX
    boolean isNameValid() {
        return name.matches("[가-힣]{2,5}$");
    }

    boolean isScoresValid() {
        return isKorValid() && isEngValid() && isMathValid();
    }
    // kor : 0~100 isKorValid

    // eng: 0~100 isEngValid

    // math: 0~100 isMathValid

    boolean isKorValid() {
        return kor >= 0 && kor <= 100;
    }

    boolean isEngValid() {
        return eng >= 0 && eng <= 100;
    }

    boolean isMathValid() {
        return math >= 0 && math <= 100;
    }

    @Override
    public String toString() {
        // return name + " : " + kor + "," + eng + "," + math;
        return String.format("%s : %d, %d, %d", name, kor, eng, math);
        // "출력 포맷을 데이터형식("따옴표") 기호로 작성", %d 순서에 맞는 순서대로 값을 나열. 마치 위 처럼
    }
}