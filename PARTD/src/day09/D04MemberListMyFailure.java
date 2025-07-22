package day09;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import lombok.*;

public class D04MemberListMyFailure {
    public static void main(String[] args) {
        // 불변 문자열 리스트 생성
        List<String> names = List.of("guava", "blackberry", "raspberry", "mangosteen");
        System.out.println(names);

        // 배열을 리스트로 변환 (Arrays.asList 사용 → 크기 변경 불가 리스트)
        String[] temp = { "guava", "blackberry", "raspberry", "mangosteen" };
        List<String> fruits = Arrays.asList(temp);
        // fruits.add("melon"); // ❌ UnsupportedOperationException 발생

        System.out.println("Member 타입 객체로 테스트");

        // Member 객체 생성: (id, name, point)
        Member2 m1 = new Member2(1, "구아바", 3.4);
        Member2 m2 = new Member2(2, "블랙베리", 1.9);
        Member2 m3 = new Member2(3, "라즈베리", 5.4);
        Member2 m4 = new Member2(4, "망고스틴", 6.3);

        List<Member2> members = List.of(m1, m2, m3, m4); // 불변 객체

        // 1) members를 순서대로 출력 (toString 자동 호출)
        System.out.println("멤버의 이름: " + names); // 문자열 리스트 출력
        System.out.println("members 리스트:");
        for (Member2 m : members) { // m = members.get(i)
            System.out.println(m); // lombok의 @ToString에 의해 출력 형식 자동 처리
        }

        System.out.println("members 출력 한번 더"); // index 기반 출력
        for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i));
        }

        // 2) 2번 index의 값 가져와서 이름을 출력하기
        System.out.println("2번 인덱스의 이름: " + members.get(2).getName());

        // 3) members 정렬 확인하기 (score 기준 오름차순 정렬)
        List<Member2> sortable = new ArrayList<>(members); // List.of는 불변이므로 복사 필요
        sortable.sort((a, b) -> Double.compare(a.getScore(), b.getScore())); // 람다식 정렬
        System.out.println("점수(score) 오름차순 정렬 결과:");
        for (Member2 m : sortable) {
            System.out.println(m); // 정렬된 toString 출력
        }

        // sort method는 리스트 내부 순서를 바꾸는 메서드
        // ❗ 불변 객체(List.of)는 정렬 불가 → 가변 객체로 복사해서 작업해야 함

        // 🔥 가변 객체로 만들기 (name 기준 정렬)
        List<Member2> members2 = new ArrayList<>(members);
        members2.sort(new Comparator<Member2>() {
            @Override
            public int compare(Member2 o1, Member2 o2) {
                return o1.getName().compareTo(o2.getName()); // 두 객체의 비교 기준 속성을 name으로 지정
            }
            // compare와 compareTo method 비교는 C12번 수업 내용 참고
        });
        System.out.println("정렬 후 (name 기준 오름차순): ");
        for (Member2 m : members2) {
            System.out.println("\t" + m);
        }

        // 두번째 정렬은 point 속성값으로 한다
        // 3-3) point 기준 오름차순 정렬
        List<Member2> members3 = new ArrayList<>(members); // 가변 리스트 복사
        members3.sort(new Comparator<Member2>() {
            @Override
            public int compare(Member2 o1, Member2 o2) {
                return Double.compare(o1.getPoint(), o2.getPoint()); // point 기준 비교
            }
        });
        System.out.println("정렬 후 (point 기준 오름차순):");
        for (Member2 m : members3) {
            System.out.println("\t" + m);
        }
    }
}
