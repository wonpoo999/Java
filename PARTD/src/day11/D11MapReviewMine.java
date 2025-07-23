package day11;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Map 복습 : 활용 예시 - 일회성 데이터 저장 및 전달 목적으로 클래스 대신 Map 사용 가능
public class D11MapReviewMine {
    public static void main(String[] args) {

        // Map에 저장할 데이터 : id, name, point
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1000); // int
        map.put("name", "김사나"); // String
        map.put("point", 3.14); // double

        MapTestMine test = new MapTestMine();
        test.setMember(map);
        System.out.println("test member : " + test); // toString() 출력

        // 🔍 퀴즈: test 객체에 저장된 member를 가져와서 각각 id, name, point를 출력해보세요
        // 1. getter로 Map 타입 member 가져오기
        // 2. keySet()으로 key 목록 얻기
        // 3. 향상된 for문으로 key와 value 출력

        Map<String, Object> memberMap = test.getMember(); // 1.
        Set<String> keys = memberMap.keySet(); // 2.

        System.out.println("\n🔎 Map 내용 출력:");
        for (String key : keys) { // 3.
            Object value = memberMap.get(key);
            System.out.println(key + " : " + value);
        }
    }
}

class MapTestMine {
    private Map<String, Object> member;

    public Map<String, Object> getMember() {
        return member;
    }

    public void setMember(Map<String, Object> member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "MapTestMine{member=" + member + "}";
    }
}
