package day10;

import java.util.*;

public class D07MapTestMine {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        // 1 . 데이터 저장 (toString으로 추가도되고 변경도 된다)
        map.put("t1", "사나");
        map.put("t2", "모모");
        map.put("t3", "나연");
        map.put("t4", "다현");
        map.put("t1", "나나"); // key "t1" 의 value 가 사나 -> 나나로 변경

        // 2. map의 크기
        System.out.println("map 크기 : " + map.size());

        // 3. toString 출력
        System.out.println("map: " + map);

        // 생성자로 전달된 map의 값을 linkMap에 저장하기
        Map<String, String> linkMap = new LinkedHashMap<>();
        linkMap.put("t1", "사나");
        linkMap.put("t2", "모모");
        linkMap.put("t3", "나연");
        linkMap.put("t4", "다현");
        System.out.println("linkedHashMap : " + linkMap);

        // 5. TreeMap

        Map<String, String> treeMap = new TreeMap<>(map);
        System.out.println("treeMap : " + treeMap);

        // 6. key로 value 가져오기
        String temp = treeMap.get("t1");
        System.out.println("t1의 value : " + temp);
        temp = treeMap.get("t2");
        System.out.println("t2의 value : " + temp);

        //
        System.out.println("keyset : " + treeMap.keySet());

        // 7. map의 반복문
        for (String key : treeMap.keySet()) { // map 의 key 값만 모아서 set을 만들고 (keyset) 여기서 key를 가져와 반복. keyset 안 가져오면
                                              // string 가져올 수 없다
            System.out.println(key + ":" + treeMap.get(key));
        }

        System.out.println("Map.Entry 내부클래스는 k,v를 한쌍으로 저장. ");
        System.out.println("\nentry set: " + treeMap.entrySet().toString());
        System.out.println("~~~ entry set 반복문(stream) ~~~");
        System.out.println("key와 value의 getter는 entry 타입에서 각각 가져올 수 있음.");
        // for 문 작성해보자.
        treeMap.entrySet().stream()
                .forEach(entry -> System.out.println(entry + " " + entry.getKey() + "," + entry.getValue()));

        System.out.println("values : " + treeMap.values());
    }

}

/*
 * 
 * hash (hash 함수)
 * 입력값 --> hash 함수 --> 출력값
 * 
 * "abc"
 * 3.14 hash 함수를 통과하면 -> 고유한 식별값을 만든다. --. 객체의 참조값 (hashcode)
 * 999
 * Member 객체
 * Set 또는 Map에 저장된 요소(객체) -> 각각의 요소를 저장하면 접근을 위한 참조값이 필요하다
 * 참조값은 hash 함수를 사용하여 만들고 hash table을 저장한다
 * Map은 Key 값을 입력으로 하여 hash 값을 생성한다. -> value 객체의 참조값
 * 
 * ✅Map을 예시로하면 key, key의 객체가 저장된 참조값(hash)를 표 형식으로 저장
 * 
 * hash 함수 사용 예시 : 비밀번호 저장 등에 사용.
 * 
 * ✅hash 함수 특징 : hash값을 다시 평문(입력값)으로 변환할 수 없음.
 * 입력값이 다르면 hash 값도 다르게 나온다 나오고 반드시 그렇게 나와야 한다.
 * 이게 알고리즘을 잘 사용해야하는 이유다
 */