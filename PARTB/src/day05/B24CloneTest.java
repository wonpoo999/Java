package day05;

public class B24CloneTest {
    // clone() 은 Object 클래스 최상위 부모로부터 상속
    // → 자식 클래스에서 clone() 메서드 오버라이딩 필요
    // → 단순 대입(x), 복제된 새로운 객체를 만들고자 할 때 사용

    public static void main(String[] args) {
        try {
            Student sana = new Student("최사나", 29); // 원본 객체 생성

            // clone() 메서드 호출 시 Object 타입이므로 Student로 형변환 필요
            Student sanaClone = (Student) sana.clone(); // 복제본 생성 (얕은 복사)
            // checked 예외 : 컴파일러가 메소드의 예외 가능성을 알고 있다.
            // -> 예외 처리 필수.

            System.out.println("sanaClone: " + sanaClone.getName()
                    + "," + sanaClone.getAge()); // 복제된 객체의 필드 출력

            System.out.println("sana 주소 : " + sana); // 원본 객체 주소
            System.out.println("sanaClone 주소 : " + sanaClone); // 복제 객체 주소
            // → 서로 다른 주소 출력 → clone() 성공적으로 동작한 것 확인
        } catch (Exception e) {
            System.out.println("clone예외 발생!!");
        }
    }
}

class Student implements Cloneable { // Cloneable 인터페이스 구현 필수
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getName / getAge 치고 나오는 패키지에서 저 이름 나오는 거 누르고 엔터쳐봐.
    // 밑에 처럼 팍 만들어진다
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // clone 치고 나오는 패키지에서 저 이름 나오는 거 누르고 엔터쳐봐.
    // 밑에 처럼 팍 만들어진다
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub

        // 부모는 Object → Object 클래스의 clone() 호출
        // 리턴 타입이 Object → Student로 캐스팅 필요 (main에서 형변환 처리)
        return super.clone();

        // 부모가 물려준 clone() 메소드 실행한다
        // 리턴 타입이 Object 입니다. -> Student로 캐스팅
    }

    // ※ 참고: toString() 오버라이드하면 주소 대신 필드 출력 가능
    // @Override
    // public String toString() {
    // return "Student{name='" + name + "', age=" + age + "}";
    // }
}
