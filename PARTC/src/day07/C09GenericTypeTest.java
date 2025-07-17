package day07;

import day07.interfac.AI;

public class C09GenericTypeTest {

    public static void main(String[] args) {
        MyBox<String> box1 = new MyBox<String>();
        box1.setItem("나는 String");

        MyBox<AI> box2 = new MyBox<AI>();
        box2.setItem(new AI("GPT"));

        System.out.println("box1 : " + box1.getItem());
        System.out.println("box2 : " + box2.getItem());

    }
}

// 제너릭 타입 T : 클래스 또는 메소드에서 `데이터 타입을 일반화`하는 목적으로 사용
// 실행 타입은 <T> 기호 T에 해당 타입을 표기
// 코드의 재사용성(타입은 다르지만 하는일은 같은 클래스), 타입을 일치 필수(타입 안전성)
class MyBox<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}