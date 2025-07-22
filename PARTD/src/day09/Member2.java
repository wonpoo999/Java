// package day09;

// import lombok.*;

// @Getter
// @Setter
// @ToString
// @NoArgsConstructor // 기본 생성자
// @AllArgsConstructor // 모든 속성을 초기화하는 커스텀 생성자

// public class Member2 {
// // final 키워드로 변수 선언 : 생성자에게 꼭 초기화 해야 한다.
// // 이유는? final은 값을 변경할 수 없기 때문에
// // 예) private final int id;

// private int id;
// private String name;
// private double point;
// private double score;

// // byte code .class 파일을 가보면 lombok이 만들어준 코드가 있다

// public Member2(int id, String name, double score) {
// this.id = id;
// this.name = name;
// this.score = score;

// }

// public String getName() {
// return name;
// }

// public double getScore() {
// return score;
// }

// @Override
// public String toString() {
// return "Member{id=" + id + ", name='" + name + "', score=" + score + "}";
// }

// }
