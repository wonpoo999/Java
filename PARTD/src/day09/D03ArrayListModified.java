package day09;

import java.util.List;
import java.util.ArrayList;

public class D03ArrayListModified {
    public static void main(String[] args) {
        // List 인터페이스 타입으로 ArrayList 생성 (문자열 저장)
        List<String> list = new ArrayList<>(); // ArrayList는 List를 구현한 클래스

        // ✅ 요소 추가 (add)
        list.add("apple"); // index 0
        list.add("mango"); // index 1
        list.add("guava"); // index 2
        list.add("banana"); // index 3
        list.add("watermelon"); // index 4

        System.out.println("초기 리스트 : " + list);

        // ✅ 리스트 크기 확인 (size)
        int size = list.size();
        System.out.println("리스트의 크기 : " + size); // 출력: 5

        // ✅ 요소 삭제 (remove by index)
        String removed = list.remove(1); // mango 제거
        System.out.println("remove 반환값 : " + removed); // 출력: mango
        System.out.println("삭제 후 리스트 : " + list);
        System.out.println("삭제 후 리스트 크기 : " + list.size());

        // ✅ 요소 출력 (get + for문)
        System.out.println("리스트 요소 1개씩 출력:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\t" + list.get(i));
        }

        // ✅ 특정 위치 값 변경 (set)
        list.set(list.size() - 1, "guava"); // 마지막 요소를 "guava"로 변경
        System.out.println("마지막 요소 값 변경 후:");
        for (String s : list) { // 향상된 for문 (foreach)
            System.out.println("\t" + s);
        }

        // ✅ 중복 요소 추가
        list.add("watermelon");
        list.add("mango");
        System.out.println("중복 요소 추가 후 리스트: " + list);

        // ✅ 특정 요소 위치 찾기 (indexOf, lastIndexOf)
        System.out.println("melon의 위치 찾기:");
        System.out.println("\tlist.indexOf(\"melon\") : " + list.indexOf("melon")); // 없는 값: -1
        System.out.println("\tlist.indexOf(\"mango\") : " + list.indexOf("mango")); // 첫 번째 mango 위치
        System.out.println("\tlist.lastIndexOf(\"mango\") : " + list.lastIndexOf("mango")); // 마지막 mango 위치

        // ✅ 특정 요소 포함 여부 확인 (contains)
        System.out.println("특정 데이터 포함 여부:");
        System.out.println("\t\"mango\" 포함? " + list.contains("mango")); // true
        System.out.println("\t\"blueberry\" 포함? " + list.contains("blueberry")); // false

        // ✅ 리스트 정렬 (sort)
        list.sort(null); // null은 기본 정렬 (알파벳 오름차순)
        System.out.println("정렬 후 리스트 : " + list);
    }
}
