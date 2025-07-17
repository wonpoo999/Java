package day06;

// 다형성 테스트
//   ㄴ 자식 클래스를 부모 타입 변수에 대입하기
//   ㄴ 메소드의 인자 또는 리턴값 부모 타입으로 하기 : 모든 자식객체는 인자 또는 리턴값이 될수 있음.
public class C04PolymorphismTest {
    public static void main(String[] args) {
        // 변수타입이 부모클래스
        YourParent child1 = new YourChild(); // 메소드 재정의한 자식
        YourParent child2 = new YourChild2(); // isFail 속성 추가
        // 변수타입이 자식클래스
        YourChild2 child3 = new YourChild2(true);

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

        child2.setMessage("hi java");
        child2.setName("sana");
        test(child2);

        child3.setMessage("hi 리액트");
        child3.setName("사나");
        test(child3);

        child1 = makeChild(0, "김모모");
        System.out.println(child1);
        child1 = makeChild(1, "kim momo");
        System.out.println(child1);

    }

    // 메소드 인자가 YourParent : YourParent 클래스를 상속받은 클래스의 객체는 모두 가능.
    private static void test(YourParent child) {
        System.out.println(child);
    }

    // 메소드 리턴 타입이 YourParent :
    private static YourParent makeChild(int type, String name) {
        // type 이 0이면 첫번째 자식, 1이면 두번째 자식 리턴
        YourParent child = null;
        if (type == 0) {
            child = new YourChild();
            child.setMessage("goodbye~");
            // return new YourChild();
        } else {
            child = new YourChild2();
            // return new YourChild2();
        }

        // name 을 인자로 받아서 객체에 저장한다.
        // 부모타입으로 물려받은 메소드는 자식 객체 종류 상관없이 실행 가능.
        child.setName(name);
        return child;
    }
}