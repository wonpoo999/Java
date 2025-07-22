package day09;

import java.util.List;
import java.util.ArrayList;

// ArrayList : List Interface를 구현한 Class
public class D03ArrayList {
    public static void main(String[] args) {
        // ArrayList 만들기
        List<String> list = new ArrayList<>(); // 왼쪽은 Interface 이름, 오른쪽은 구현한 class 이름

        // 데이터 저장하기
        list.add("apple"); // index 0
        list.add("mango"); // index 1
        list.add("guava"); // index 2
        list.add("banana"); // index 3
        list.add("watermelon"); // index 4
        System.out.println(list);

        // 리스트의 크기 (가변적)
        int size = list.size();
        System.out.println("리스트의 크기 : " + size);

        String result = list.remove(1);
        System.out.println("remove return : " + result);
        System.out.println("삭제 후 list: " + list);
        System.out.println("삭제 후 list 크기 : " + list.size());

        // list index를 [] 기호로 지정하지 않고 get(index) method
        System.out.println("bring list data 1 by 1");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\t" + list.get(i));

            // list의 특정 위치 값 변경 : set(index, 값)
            list.set(list.size() - 1, "guava");
            System.out.println("마지막 요소 값 변경");
            for (String s : list) { // list.get(i) 역할
                System.out.println("\t" + s);
            }

            // 특정 요소 찾기
            list.add("watermelon"); // 같은 문자열 하나 추가
            list.add("mango");
            System.out.println(list);
            System.out.println("melon의 위치 찾기");
            System.out.println("\tlist.indexOf :" + list.indexOf("melon"));
            System.out.println("\tlist.lastIndexOf :" + list.lastIndexOf("melon"));

            System.out.println("특정 데이터의 저장 여부 : contains");

            System.out.println("\tmango 있어?" + list.contains("mango"));
            System.out.println("\tblueberry 있어? " + list.contains("blueberry"));

            // 정렬
            list.sort(null);
            System.out.println("정렬 후 : " + list);

        }

    }

}
