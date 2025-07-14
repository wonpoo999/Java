package day04;

public class People {
    private String name;
    private int age;
    private boolean isAdult;

    // 1) 기본 생성자는 컴파일러가 자동으로 만들어준다.
    // ㄴ new People()로 객체생성할 때 People()가 기본 생성자 메소드 실행한다.
    public People() {
        System.out.println("People 기본 생성자 실행한다.");
    }

    // 2) 커스텀 생성자
    public People(String name, int age, boolean isAdult) {
        // 인스턴스 변수 초기화
        this.name = name;
        this.age = age;
        this.isAdult = isAdult;
    }

    // 기본 생성자를 사용할 때에는 setter가 필수야. 기본 생성자로 만들면 값을 줄 수 없잖냐?
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAdult(boolean isAdult) {
        this.isAdult = isAdult;
    }

    // 🔥 오버로딩 (overloading): method 이름은 같고, method의 인자가 타입과 개수가 다른 형태
    // 생성자를 포함해서 모든 method에 적용되는 개념이니라. method 인자의 타입과 개수가 다르면 가능하다는거여. 이걸 method
    // overloading 이라 한다.
    //

    // 값을 읽기 위해서는 공통적으로 무엇이 필요하다? getter가 필요하느니라. 복습해보자꾸나
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public boolean isAdult() {
        return this.isAdult;
    }

    // toString() method override(재정의)
    // 출력되는 문자를 바꿔보자꾸나
    @Override
    public String toString() {
        return String.format("%s - %d %s", this.name, this.age, this.isAdult);
    }

}
