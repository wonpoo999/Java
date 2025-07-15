package day05;

import java.util.Arrays;

// 학생 성적 시스템 (재미요소 포함)
// 점수, 평균, 등급 외에도 칭호(title), 합격여부, 이모지 출력까지 포함
public class B25ScoreArrayEx {
    public static void main(String[] args) {
        // 빈 점수 배열을 가진 학생 생성
        StudentScore sana = new StudentScore("미나");

        // 점수 포함한 학생 생성
        StudentScore momo = new StudentScore("김모모", 78, 100, 88);

        // 점수 갱신 (sana는 생성 시 점수가 없으므로 세 과목 모두 입력)
        sana.updateScores(99, 90, 89);

        // momo의 국어 점수 수정
        momo.setKor(92);

        // 학생 정보 출력 (toString 오버라이딩 덕분에 객체 출력만으로 정보 출력됨)
        System.out.println(sana);
        System.out.println(momo);
    }
}

class StudentScore {
    // 1. 필드 선언
    private String name; // 학생 이름
    private int[] scores; // 국어, 영어, 수학 점수를 담는 배열

    // 2. 과목 인덱스를 상수로 정의 (magic number 방지, 가독성 향상)
    private static final int KOR = 0;
    private static final int ENG = 1;
    private static final int MATH = 2;

    // 3. 생성자 정의

    // 이름만 받는 생성자 → 점수는 0으로 초기화된 배열로 세팅
    public StudentScore(String name) {
        this.name = name;
        this.scores = new int[3]; // [0, 0, 0] 으로 초기화
    }

    // 이름과 점수를 모두 받는 생성자
    public StudentScore(String name, int kor, int eng, int math) {
        this.name = name;
        this.scores = new int[3];
        this.scores[KOR] = kor;
        this.scores[ENG] = eng;
        this.scores[MATH] = math;
    }

    // 4. 점수 개별 설정 (setter / getter)
    public void setKor(int kor) {
        this.scores[KOR] = kor;
    }

    public void setEng(int eng) {
        this.scores[ENG] = eng;
    }

    public void setMath(int math) {
        this.scores[MATH] = math;
    }

    public int getKor() {
        return this.scores[KOR];
    }

    public int getEng() {
        return this.scores[ENG];
    }

    public int getMath() {
        return this.scores[MATH];
    }

    public String getName() {
        return this.name;
    }

    // 5. 전체 점수 배열 반환
    public int[] getScores() {
        return this.scores;
    }

    // 6. 총점 계산
    public int getTotal() {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum;
    }

    // 7. 평균 계산 (소수점 둘째자리까지 절사)
    public double getAverage() {
        return Math.floor(getTotal() * 100.0 / scores.length) / 100;
    }

    // 8. 등급 계산
    public String getGrade() {
        int avg = (int) getAverage();
        return switch (avg / 10) {
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> "F";
        };
    }

    // 9. 칭호(title) 부여 로직
    public String getTitle() {
        double avg = getAverage();
        if (avg >= 95)
            return "천재";
        else if (avg >= 90)
            return "공부왕";
        else if (avg >= 80)
            return "수재";
        else if (avg >= 70)
            return "노력파";
        else
            return "반성 요망";
    }

    // 10. 이모지로 반응 출력 (텍스트 설명 포함)
    public String getEmoji() {
        double avg = getAverage();
        return switch ((int) avg / 10) {
            case 10, 9 -> "최상🔥";
            case 8 -> "우수😊";
            case 7 -> "보통😅";
            case 6 -> "아슬아슬😓";
            default -> "위험😭";
        };
    }

    // 11. 합격 여부 (평균 60 이상 합격)
    public String getPassFail() {
        return getAverage() >= 60 ? "합격 ✅" : "불합격 ❌";
    }

    // 12. 점수 한꺼번에 업데이트
    public void updateScores(int kor, int eng, int math) {
        this.scores[KOR] = kor;
        this.scores[ENG] = eng;
        this.scores[MATH] = math;
    }

    // 13. 최고 점수 구하기
    public int getMaxScore() {
        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }

    // 14. 최소 점수 구하기
    public int getMinScore() {
        int min = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        return min;
    }

    // 15. toString 오버라이딩 → 객체 자체를 출력하면 정보 자동 출력
    @Override
    public String toString() {
        return "[" + name + "] 성적: " + Arrays.toString(scores)
                + ", 평균: " + getAverage()
                + ", 등급: " + getGrade()
                + ", 최소점수: " + getMinScore()
                + ", 최고점수: " + getMaxScore()
                + ", 칭호: " + getTitle()
                + ", 반응: " + getEmoji()
                + ", 상태: " + getPassFail();
    }
} // end StudentScore
