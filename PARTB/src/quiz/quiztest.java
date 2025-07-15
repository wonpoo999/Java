package quiz;

public class quiztest {
    private String name;
    private int grade;

    // 기본 생성자
    public quiztest() {
        name = "Anonymous";
        grade = 1;
    }

    // 정보 출력 메서드
    public void printInfo() {
        System.out.println("Name: " + name + ", Grade: " + grade);
    }

    // main 메서드 (실행용)
    public static void main(String[] args) {
        quiztest s = new quiztest(); // 객체 생성
        s.printInfo(); // 출력
    }
}
