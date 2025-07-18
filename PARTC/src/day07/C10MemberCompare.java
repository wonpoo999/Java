package day07;

public class C10MemberCompare {

    public static void main(String[] args) {
        Member m1 = new Member("sana", 29);
        // clone 실행
        try {
            Member m2 = m1.clone();
            m2.print(); // clone 결과 확인
        } catch (CloneNotSupportedException e) {
            System.out.println("clone exception~!");
        }

        // compareTo 실행
        Member m3 = new Member("momo", 33);

        // compareTo 비교를 age, name 각각 비교해보기
        int diff = m1.compareTo(m3); // this는 m1, 다른 하나 m3
        System.out.println("m1과 m3 name 비교 : " + diff);

        diff = m3.compareTo(m1); // this는 m3, 다른 하나 m1
        System.out.println("m3과 m1 name 비교 : " + diff);

        // m1과 m3 age 비교 : -4
        // m3과 m1 age 비교 : 4

        // m1과 m3 name 비교 : 6
        // m3과 m1 name 비교 : -6
    }

}

class Member implements Cloneable, Comparable<Member> {
    private String name;
    private int age;

    Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override // Cloneable 인터페이스 재정의
    protected Member clone() throws CloneNotSupportedException { // 예외 처리 위임

        return (Member) super.clone();
        // Object java.lang.Object.clone() throws CloneNotSupportedException
        // 메소드 원형 throws 뒤의 예외는 Checked 예외 -> try ~ catch 필요 -> 다른곳으로 위임
    }

    @Override // Comparable 인터페이스 재정의- Member 객체의 어떤 속성값 비교할 것인지....
    public int compareTo(Member o) { // this 와 상대객체 o 를 비교
        // 1) name 속성으로 비교
        return this.name.compareTo(o.name);
        // 2) age 속성으로 비교
        // return this.age - o.age;
    }

    void print() {
        System.out.println(String.format("%s (%d)", name, age));
    }

}