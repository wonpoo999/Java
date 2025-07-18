package day07;

import java.util.Arrays;

public class C11MemberSort {

    public static void main(String[] args) {
        int[] numbers = { 7, 9, 5, 8, 3 };
        String[] names = { "momo", "nayeon", "dahyeon", "sana", "apple" };

        Arrays.sort(numbers);
        System.out.println("numbers 정렬 후 : " + Arrays.toString(numbers));

        Arrays.sort(names);
        System.out.println("numbers 정렬 후 : " + Arrays.toString(names));

        Member[] members = new Member[4];
        members[0] = new Member("strawberry", 25);
        members[1] = new Member("lemon", 23);
        members[2] = new Member("banana", 27);
        members[3] = new Member("kiwi", 22);

        Arrays.sort(members); // 🔥 Comparable interface 사용(구현)한 객체의 배열만 sort() 가능하다.
        for (Member m : members)
            m.print();
    }

}
