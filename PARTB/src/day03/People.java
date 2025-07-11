package day03;

// 자바에서 데이터를 거장하는 VO (Value Object) 클래스의 기본 령식이니라 .

public class People {
    // 객체의
    private String name;
    private int age;
    private boolean isAdult; // setAdult, isAdult

    // 값의 접근 : 메소드 구현(일반적으로 메소드는 퍼블릭 권한을 준단다.)
    // 값을 가져오기 getter(getXXXX), 값을 지정하기(setXXX)

    // getter
    // name 가져오기 - this keyword는 객체의 필드를 가리키는 단어.
    public String getName() {
        return name;
    }

    public int getAge() {
        return this.age;
    }

    public boolean isAdult() {
        return this.isAdult;
    }

    // setter : 인자 타입 주의
    public void setName(String name) { // name 변수에 원하는 값이 저장된거야
        this.name = name;
        // 🔥this는 객체가 만들어졌을 때 자기 자신을 가리킨다.
        // this.name은 객체의 field name, 인자로 전달된 name.
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAdult(boolean isAdult) {
        this.isAdult = isAdult;

    }
}
