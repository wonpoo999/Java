package day09;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 속성을 초기화하는 커스텀 생성자
public class Member {
  // final 키워드로 변수 선언 : 생성자에서 꼭 초기화 해야 합니다.
  // why? final 은 값을 변경할 수 없으므로.
  // 예시) private final int id;
  private int id;
  private String name;
  private double point;

  // 바이트 코드 .class 파일을 가보면 롬복이 만들어준 코드가 있습니다.

}