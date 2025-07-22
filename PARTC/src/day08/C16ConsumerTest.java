package day08;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

// [함수형 인터페이스]를 사용하는 것은 Stream 타입의 자료구조 메소드
// Stream : 배열과 같은 자료구조. 자바스크립트의 map, filter 메소드와 같은 방식으로 데이터를 다룹니다.
//          자바에서는 Stream 타입의 자료구조 병렬처리를 지원하는 메소드가 있습니다.
// Stream 대신에 List 자료구조를 이용해서 forEach 메소드에 활용해 봅시다.
public class C16ConsumerTest {
  public static void main(String[] args) {
    Integer[] arr = { 2, 4, 8, 10 }; // 배열은 forEach 사용 못함.
    // forEach를 List 로 변환
    List<Integer> numbers = Arrays.asList(arr);
    System.out.println("numbers list : " + numbers); // [2, 4, 8, 10]

    // Math.pow(2, t) : 2의 t 제곱 구하기
    Consumer<Integer> consumer = (t) -> System.out.println(String.format("Math.pow(2, %d)= %f", t, Math.pow(2, t)));

    // 배열의 값을 하나씩 가져다가 t에 대입하여 2의 t 승 연산하여 출력하기
    // forEach 의 인자 타입은 Consumer 인터페이스 구현 객체 -> 익명 클래스를 람다식으로 표현해서 전달.
    numbers.forEach(consumer);

    numbers.forEach((t) -> System.out.println(t * 10)); // 🔥

    System.out.println("~~~ ✅ 람다식이 아닌 익명 클래스 객체 대입 ~~~");
    numbers.forEach(new Consumer<Integer>() {
      @Override
      public void accept(Integer t) {
        System.out.println("t*11 =" + (t * 11));
      }
    });

    


  }

}
