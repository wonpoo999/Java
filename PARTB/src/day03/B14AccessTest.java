package day03;

/*
 * 접근권한 방식
 *
 * - Class : public, default (기본)
 * - method : public, default, private
 * - 전역변수 : public, default, private
 *
 * - 접근 권한 protected 는 상속 (inheritance)에서 나오는 것이고 [이후 진도에서 배워볼것이니라
 *
 * - public : 모든 클래스에서 사용 가능하다.
 * - default : 같은 패키지에서 사용 가능함
 * - private : 현재 클래스에서 사용 가능함
 */

public class B14AccessTest {

    public static void main(String[] args) {
        // --- Code related to Score2 (from your original example comments) ---
        // Score2 김두한 = new Score2(); // This would work if Score2 was a top-level class
        // with default access in the same package.
        // As an inner class here, it needs to be static or B14AccessTest instance.
        // For demonstration based on your comments, let's assume it's meant to be
        // a standalone class with default access.

        // If Score2 is defined as a top-level default class:
        Score2 김두한 = new Score2();
        김두한.name = "Kim Doohan";
        김두한.kor = 100;
        김두한.eng = 20;
        김두한.math = 5;
        // The 'grade' field in Score2 is private, so you can't access it directly here:
        // 김두한.grade = 90; // Error: grade has private access in Score2

        System.out.println("--- Score2 Example ---");
        System.out.println("Name: " + 김두한.name);
        System.out.println("Korean Score: " + 김두한.kor);
        System.out.println("English Score: " + 김두한.eng);
        System.out.println("Math Score: " + 김두한.math);
        System.out.println("---------------------\n");

        // --- Code related to Score class (your main logic) ---
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
        // isScoresValid() is private, so you can't call it directly from here:
        // System.out.println("모든 점수 : " + JohnDoe.isScoresValid()); // Error:
        // isScoresValid() has private access in Score
        // To check validity from outside, you would need a public method that calls it,
        // or make it public.
        // For now, let's assume you wanted to call it within the conditional logic.
        System.out.println("모든 점수 : (private method - check within class)");

        System.out.println("점수 수정 중......");

        JohnDoe.eng = 100; // This line effectively does nothing if it was already 100.
                           // Let's modify one to demonstrate the validation.
        JohnDoe.eng = -5; // Make English score invalid for demonstration

        if (JohnDoe.isKorValid() && JohnDoe.isEngValid() && JohnDoe.isMathValid()) { // Directly call public checks or
                                                                                     // have a public wrapper
            System.out.println("총점: " + JohnDoe.sum());
            System.out.println("평균: " + JohnDoe.average());
            System.out.println("학점: " + JohnDoe.getGrade());
        } else {
            System.out.println("점수값 오류 (\"모든 과목의 점수는 \\0~100\\ 로 합니다.\")");
            System.out.println("학점:" + JohnDoe.getGrade()); // 'E' (or 'F' based on your getGrade logic if average is
                                                            // low)
        }

        System.out.println("\n--- Grade Calculation Example ---");
        int sampleGradeAverage = 85; // This is a standalone example, not necessarily JohnDoe's average
        switch (sampleGradeAverage / 10) {
            case 10:
                System.out.println("학점: S");
                break;
            case 9:
                System.out.println("학점: A");
                break;
            case 8:
                System.out.println("학점: B");
                break;
            case 7:
                System.out.println("학점: C");
                break;
            case 6:
                System.out.println("학점: D");
                break;
            default:
                System.out.println("학점: F");
                break;
        }
    }
}

// --- Top-level classes ---

// Score2 class (moved outside B14AccessTest to be a top-level class with
// default access)
// It will be accessible within the same package (day03)
class Score2 {
    String name; // default access
    int kor; // default access
    int eng; // default access
    int math; // default access
    private int grade; // private access, only accessible within Score2 class
}

// Score class (moved outside B14AccessTest to be a top-level class with default
// access)
// It will be accessible within the same package (day03)
class Score {
    String name;
    int kor;
    int eng;
    int math;

    int sum() {
        return kor + eng + math;
    }

    double average() {
        return (double) sum() / 3;
    }

    char getGrade() {
        // Ensure scores are valid before calculating grade accurately
        if (!isScoresValid()) {
            return 'E'; // Or some other indicator for invalid scores
        }

        int average = sum() / 3;
        char grade;

        switch (average / 10) {
            case 10:
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D'; // Changed to D as per typical grading
                break;
            case 5:
            case 4:
            case 3:
            case 2:
            case 1:
            case 0:
                grade = 'F';
                break;
            default: // This case typically won't be reached if scores are validated (0-100)
                grade = 'E'; // Catch-all for unexpected average, or specifically for invalid scores
                break;
        }
        return grade;
    }

    boolean isNameValid() {
        // Check if name is not null before calling matches
        return name != null && name.matches("[가-힣]{2,5}$");
    }

    // Changed to public so it can be called from main for validation check or
    // kept private if only used internally by getGrade.
    // For demonstration purposes, I'll keep it private and explain.
    private boolean isScoresValid() {
        return isKorValid() && isEngValid() && isMathValid();
    }

    // These are private methods, so they can only be called from within the Score
    // class itself.
    // To check individual score validity from outside, you would need public getter
    // methods or make these public.
    public boolean isKorValid() { // Changed to public to allow external checking
        return kor >= 0 && kor <= 100;
    }

    public boolean isEngValid() { // Changed to public to allow external checking
        return eng >= 0 && eng <= 100;
    }

    public boolean isMathValid() { // Changed to public to allow external checking
        return math >= 0 && math <= 100;
    }

    @Override
    public String toString() {
        return String.format("%s : %d, %d, %d", name, kor, eng, math);
    }
}