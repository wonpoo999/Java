package day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class D13PeopleEquality {
    public static void main(String[] args) {
        List<People> list = new ArrayList<>();
        People p1 = new People(0001, "김모모");
        People p2 = new People(0002, "최진실");
        People p3 = new People(0003, "이스터에그");
        People p4 = new People(0004, "김두한");
        list.add(p1);
        list.add(p3);
        list.add(p4);
        list.add(p2);
        list.add(p4);

        // 동일성 검사
        System.out.println("\t1. 동일성 검사");
        People temp = new People(0002, "최진실"); // false // new는 완전히 새로운 객체를 만드는 것이여
        System.out.println("p2 == temp : " + (p2 == temp));

        System.out.println("**다른 객체에 대해 동등성 구현하면 해시코드 값이 같도록 한다. 단, 실체는 다르니라.**");
        System.out.println("p2.hashCode() : " + p2.hashCode());
        System.out.println("temp.hashCode() : " + temp.hashCode());

        // 동등성 검사
        System.out.println("\t2. 동등성 검사");
        boolean result = p2.equals(temp); // false
        System.out.println("p4.equals(temp) : " + result);
        System.out.println("p4.hashCode() : " + p4.hashCode());
        System.out.println("temp.hashCode() : " + temp.hashCode());

        // List는 indexOf method: 값을 전달하면 리스트에 저장된 index를 return해준다.
        // p2 객체가 몇 번째 있는지 알고 싶다면.........
        System.out.println("\t3. p2와 동등성인 객체의 index를 찾는 것이여");
        int index = list.indexOf(temp);
        System.out.println("indexOf p2 : " + index);

        System.out.println("\t4. p4와 동등성인 객체의 lastIndex를 찾는 것이여");
        temp = new People(0004, "김두한");
        index = list.lastIndexOf(temp);
        System.out.println("lastIndexOf p4 : " + index);

        // set의 동등성 테스트를 위해 새로운 객체 추가
        list.add(temp);
        list.add(new People(0002, "최진실")); // false)

        Set<People> set = new HashSet<>(list);
        System.out.println("\t5. 동등성과 Set - Set은 중복된 값을 저장하지 않는다. Set에 저장된 값은 유일한 값만 저장한다.");
        System.out.println("set 크기 : " + set.size());
        System.out.println("set : " + set);

        // People 클래스 @EqualsAndHashCode 구현이 있느냐 없느냐 에 따라 동등성 검사 여부 결정
        // 테스트 하기 : @EqualsAndHashCode 있을 때 없을 때 비교해서 정리하세요.
        // ✅ @EqualsAndHashCode 구현이 있으면 동등성 검사를 할 수 있다.
        // ✅ 결론 : @EqualsAndHashCode 구현하여 내용이 같으면 '동등하다 (equality)'고 판단합니다. 그러면 굳이 중복되는
        // 걸 저장하지 않아.
        // 예시 : 내용이 같으면 equals() 결과 참, indexOf() 찾기, Set 자료구조 중복되지 않고 저장.

    }

}
