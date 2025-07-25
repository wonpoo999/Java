package day11;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
// import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class D12ObjectConcept {
    public static void main(String[] args) {

        String test = "java";
        String test2 = "java"; // test와 test2는 같은 literal
        String test3 = new String("java"); // 새로운 객체를 만들어라!

        System.out.println("동일성 확인 -----");
        System.out.println(test == test3); // false
        System.out.println(test == test2); // true : 문자열 literal은 불변 객체

        System.out.println("동등성 확인 -----"); //
        System.out.println(test.equals(test3)); // true
        System.out.println(test.equals(test2)); // true

    }
}

// @EqualsAndHashCode // 동등성을 구현 재정의 코드 생성
@ToString
@Getter
@Setter // final 아닌 것만 setter 만들어진다.
// @NoArgsConstructor
@RequiredArgsConstructor // 얘는 final 키워드를 갖는 속성을 초기화하는 인자를 갖는다. 지금은 2개만 final로 해서 밑에 오류가 안 나지 3개 했으면 "어차이
                         // final이라 속성값이 변경 안 될텐데" 라며 에러가 나기 시작.
@AllArgsConstructor // 모든 속성값을 초기화하는 인자를 갖는다
class People {
    // final은 값을 변경 못함. 그래서 생성자에서 필수로 초기화해줘야 해.
    private final int id;
    private final String name;
    private double etc;

    // @EqualsAndHashCode
}
