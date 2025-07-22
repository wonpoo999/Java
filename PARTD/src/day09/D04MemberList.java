package day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// List 를 불변 객체로 만들어 보기
//   of : static 메소드
public class D04MemberList {
    public static void main(String[] args) {
        List<String> names = List.of("apple", "kiwi", "mango", "banana");
        System.out.println(names);

        // names.add("melon"); // 불변 객체로 만들어져서 값을 추가,삭제 못함.=> 오류
        // names.set(2, "망고"); // 오류
        System.out.println(names);

        String[] temp = { "apple", "kiwi", "mango", "banana" };
        List<String> fruits = Arrays.asList(temp); // 불변객체? yes
        // fruits.add("melon");

        System.out.println("Member 타입 객체로 테스트");
        Member m1 = new Member(1, "김땡떙", 3.4);
        Member m2 = new Member(2, "반하나", 1.9);
        Member m3 = new Member(3, "최사과", 5.4);
        Member m4 = new Member(4, "박모모", 6.3);

        List<Member> members = List.of(m1, m2, m3, m4); // 불변 객체
        // 1) members 를 순서대로 출력(toString)
        System.out.println("members 출력");
        for (Member m : members) { // m = members.get(i)
            System.out.println(m);
        }
        System.out.println("members 출력 한번더");
        for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i));
        }

        // 2) 2번 인덱스의 값 가져와서 이름을 출력하기
        System.out.println("2번 인덱스 객체의 이름 : " + members.get(2).getName());

        // 3) members 정렬 확인하기 : 오류 => 불변 객체이므로 sort 못합니다.
        // members.sort(null); // sort 메소드는 members 리스트를 변경합니다.

        // 🔥가변 객체로 변경하기 :
        List<Member> members2 = new ArrayList<>(members);
        // members2.sort(null); // 오류 : members2 의 데이터들이 비교 기준이 없음.

        members2.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.getName().compareTo(o2.getName());
                // 두 객체의 비교 기준 속성을 알려주기
            }
        });

        // compare와 compareTo 메소드 비교는 C12 번 소스 파일 참고
        System.out.println("정렬 후 (name 비교) : ");
        for (Member m : members2) {
            System.out.println("\t" + m);
        }

        // 두번째 정렬은 point 속성값으로 합니다.
        /*
         * members2.sort(new Comparator<Member>() {
         * 
         * @Override
         * public int compare(Member o1, Member o2) {
         * return Double.compare(o1.getPoint(), o2.getPoint());
         * }
         * });
         */
        // 위의 new 익명클래스 구현을 람다식으로 바꾸기
        // 오름 차순
        // members2.sort((o1, o2) -> Double.compare(o1.getPoint(), o2.getPoint()));
        // 내림 차순
        members2.sort((o1, o2) -> Double.compare(o2.getPoint(), o1.getPoint()));
        System.out.println("정렬 후 (point 비교) : ");
        for (Member m : members2) {
            System.out.println("\t" + m);
        }

        // ✅결론 : Member 클래스를 Comparable 로 정의하지 않았다면 (예제는 C11 소스)
        // sort 메소드 인자로 Comparator 인터페이스를 구현하면 됩니다.
        // 메소드 이름이 다르지만 구현하는 return 내용은 2개 인터페이스가 동일함.
    }

}