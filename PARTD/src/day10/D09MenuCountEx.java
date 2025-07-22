package day10;

import java.util.*;

public class D09MenuCountEx {
    public static void main(String[] args) {
        String[] votes = { "치킨", "떡볶이", "스파게티", "삼겹살", "곱창", "피자", "오마카세", "쌀국수", "마파두부", "락사" };

        // 배열의 값을 Map으로 저장하면서 동시에 메뉴(key)가 몇번 나왔는지(Value) 카운트
        Map<String, Integer> menuCount = new HashMap<>();
        for (String key : votes) {
            if (menuCount.containsKey(key)) {
                menuCount.put(key, menuCount.get(key) + 1); // 한번 나온 메뉴. map에 저장된 상태
            } else {
                menuCount.put(key, 1); // 처음 나온 메뉴. map에 저장 안된 상태
            }

        }

        Map<String, Integer> menuCount2 = new HashMap<>();
        for (String key : votes) {
            menuCount2.put(key, menuCount2.getOrDefault(key, 0) + 1);
            // 위 for 문의 if 역할 method 사용합니다.
            // getOrDefault는 key 값이 있으면 가져오고 없으면 기본값 0으로 리턴
        }

        // System.out.println("메뉴 득표수");
        // for (String key : menuCount.keySet()) {
        // System.out.println(key + " : " + menuCount.get(key));
        System.out.println("메뉴 득표수");
        for (String key : menuCount2.keySet()) {
            System.out.println(key + " : " + menuCount.get(key));
        }
    }
}
