package day08;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

// 자바에서 제공하는 함수형 인터페이스 알아보기
// 인자만 있는 Consumer, 리턴만 있는 Supplier, 둘다 있는 Function   : 제너릭 타입
public class C15JavaFunctionalInterface {

  public static void main(String[] args) {
    // 1. Consumer<T> : T는 accept 메소드의 인자 타입
    Consumer<String> f1 = new Consumer<String>() {
      @Override
      public void accept(String t) {
        System.out.println("Consumer accept : " + t);
      }
    };
    Consumer<Double> f2 = new Consumer<Double>() {
      @Override
      public void accept(Double t) {
        System.out.println("Consumer accept : " + t);
      }
    };
    Consumer<Double> f22 = (t) -> System.out.println("Consumer accept : " + t);

    f1.accept("test");
    f2.accept(3.14);
    // 2. Supplier<T> : 리턴값의 타입 T
    Supplier<Integer> f3 = new Supplier<Integer>() {
      @Override
      public Integer get() {
        return 100;
      }
    };
    System.out.println(f3.get());

    // 3. Function<T, R> : T는 인자1개 타입, R은 리턴 타입
    Function<String, Integer> f4 = new Function<String, Integer>() {
      @Override
      public Integer apply(String t) {
        return t.lastIndexOf("hello"); // 입력값 t 문자열에서 "hello" 의 마지막 인덱스 위치
      }
    };
    int index = f4.apply("hello *** hello *** hello");
    System.out.println("last index : " + index);

    Predicate<String> f5 = new Predicate<String>() {
      @Override
      public boolean test(String t) {
        return t.length() < 10;
      }
    };
    System.out.println(f5.test("abc**1234"));
  }
}
