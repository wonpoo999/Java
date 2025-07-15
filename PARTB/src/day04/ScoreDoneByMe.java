package day04;

public class ScoreDoneByMe {
    private String name;
    private int kor;
    private int eng;
    private int math;

    // 기본 생성자
    public ScoreDoneByMe() {
        System.out.println("커스텀 생성자 만들기");
    }

    // 전체 초기화 생성자
    public ScoreDoneByMe(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    // 이름만 초기화
    public ScoreDoneByMe(String name) {
        this.name = name;
    }

    // 단일 과목 점수 초기화 - 구분 가능하게 메서드명 변경하거나 제거
    // 또는 예시처럼 static 팩토리 메서드 형태로 분리 가능

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public void setMath(int math) {
        this.math = math;
    }

    // Getter
    public String getName() {
        return name;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMath() {
        return math;
    }

    // toString 재정의
    @Override
    public String toString() {
        return String.format("%s - 국어: %d, 영어: %d, 수학: %d", name, kor, eng, math);
    }
}
