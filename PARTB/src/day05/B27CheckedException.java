package day05;

import java.io.IOException;

public class B27CheckedException {

    public static void main(String[] args) {

        Score s1 = new Score();
        // s1.setScore(-9); // java. lang. IllegalArgumentException
        try {
            s1.setScore(-9); // score 값 오류 !! IOException 발생시켰으므로 예외처리 필수.
        } catch (Exception e) {

        }
    }

}

class Score {
    private int score; // 0~100 제한
    // getScore 쳐보면 package에서 고를 수 있는데 그거 고르고 엔터치면 자동으로 밑에 처럼 생성

    public int getScore() {
        return score;
    }

    // 여기서 직접 try-catch 안하면 사용하는 main에서 하라고 위임하는거지
    public void setScore(int score) throws IOException { // throw는 새로운 예외를 발생시키는 거고 throws는 직접 처리하지 않하고 던져버리는 것
        if (score >= 0 && score <= 100) {
            this.score = score;
        } else {
            // 잘못된 값 -> 예외 발생 처리
            // throw new IllegalArgumentException("score 값 오류!!"); // Checked 예외 아님
            throw new IOException("score 값 오류!!"); // Checked 예외로 발생
        }
    }
}
