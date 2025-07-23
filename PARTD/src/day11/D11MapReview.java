package day11;

import java.util.HashMap;
import java.util.Map;

//Map 복습 : 활요예시 일회성으로 데이터를 저장하고 전달하는 목적
//        클래스 정의를 대신할 수 있습니다. => 자바스크립트의 객체 형식과 유사합니다.
public class D11MapReview {

    public static void main(String[] args) {

        // Map 에 저장할 데이터 : id,name,point
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1000); // Integer value
        map.put("name", "김사나"); // String value
        map.put("point", 3.14); // Double value

        MapTest test = new MapTest();
        test.setMember(map);
        System.out.println("test : " + test);

        // 퀴즈 : test 객체에 저장된 member 를 가져와서. id, name, point 를 출력해보세요.(각각)
        // hint : a) Object 타입을 직접 출력해보고. b) casting 하여 출력도 해보세요.
        // 1. getter 로 Map타입 member 가져오기
        Map<String, Object> member = test.getMember();
        // 2. 1번 Map타입 member 에서 key 값 모두 가져오기
        System.out.println("keySet : " + member.keySet()); // [id, name, point]
        // a) toString 출력은 Object 타입에서 실제 데이터의 타입으로 자동 다운 캐스팅
        System.out.println(member.get("id")); // 1000 (Object타입이 Integer 타입으로 다운)
        System.out.println(member.get("name")); // "김사나" (Object타입이 String 타입으로 다운)
        System.out.println(member.get("point")); // 3.14 (Object타입이 Double 타입으로 다운)

        // 3. (key-value 출력)
        // b) 변수에 저장하려면 직접 강제 캐스팅
        int id2 = (int) member.get("id");
        String name2 = (String) member.get("name");
        double point2 = (double) member.get("point");
        System.out.println("id=" + id2);
        System.out.println("name=" + name2);
        System.out.println("point=" + point2);

    }
}

// Map 타입 인자 or 리턴 메소드 예시
class MapTest {
    private Map<String, Object> member;

    public Map<String, Object> getMember() {
        return member;
    }

    public void setMember(Map<String, Object> member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return member.toString();
    }
}