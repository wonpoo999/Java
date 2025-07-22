package day10;

import java.util.LinkedHashMap;
import java.util.*;

public class D08TodayVote {
    public static void main(String[] args) {
        // 투표 : 각 메뉴마다 득표 수를 저장
        String menu = "치킨, 떡볶이, 스파게티, 삼겹살, 곱창";
        Map<String, Integer> map = new LinkedHashMap<>();
        // 메뉴 등록 (value 값은 득표수)
        map.put("치킨", 0);
        map.put("떡볶이", 0);
        map.put("스파게티", 0);
        map.put("삼겹살", 0);
        map.put("곱창", 0);

        System.out.println("오늘의 저녁 메뉴 투표입니다.");
        System.out.println("메뉴 목록 : " + menu);
        Scanner sc = new Scanner(System.in); // 콘솔 입력
        // 반복해서 원하는 메뉴 입력
        while (true) {
            System.out.println("투표하세요 (메뉴 목록 참고) >>> ");
            String key = sc.next();
            if (key.equals("end"))
                break; // 반복 종료는 end 입력
            // 입력된 key에 해당하는 현재 value를 가져와서 +1 하여 다시 저장하기
            if (map.containsKey(key)) {
                int value = map.get(key); // key 에 해당하는 value. 없는 key는 오류.
                value++;
                map.put(key, value);
            } else {
                System.out.println("없는 메뉴이니라.");
            }
        }
        System.out.println("투표 결과");
        for (String k : map.keySet()) {
            System.out.println(k + ":" + map.get(k) + "표");
        }
        // System.out.println(map);
        sc.close();
    }
}
