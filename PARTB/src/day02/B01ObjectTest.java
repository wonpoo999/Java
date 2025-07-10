package day02;

/*
 * .java source file에 class는 여러개 정의 가능하다.
 * public class는 1개만 존재할 수 있다. public class 이름 = file 이름 같아야 한다.
 * 
 */
public class B01ObjectTest {

    public static void main(String[] args) {

        // Score 타입 객체를 생성 -> 변수로 참조 시켜야지 우리가 그 객체를 활용할 수 있지? 그래서 변수는 참조형이라고 하니. 변수는 객체의
        // 주소를 참조한다는 걸 알고 있어라
        Score shinmajoku = new Score();

        shinmajoku.name = "마적";
        shinmajoku.yain = 100;
        shinmajoku.irryat = 50;
        shinmajoku.jpn = 20;

        System.out.println("shinmajoku의 정보: " + shinmajoku);
        // day02.Score@372f7a8d는 패키지명. 클래스명@객체의 참조값. 객체의 참조값은 필드값 이용해서 만들고
        // 객체의 주소를 찾아갈 때 사용.
        System.out.println(
                "---" + shinmajoku.name + "," + shinmajoku.yain + "," + shinmajoku.irryat + "," + shinmajoku.jpn);

        Score gumajoku = shinmajoku; // shinmajoku의 참조값(주소)를 gumajoku 변수에 저장. 타입은 반드시 Score로 한다.
        System.out.println("gumajoku의 정보: " + gumajoku);
        System.out.println("---" + gumajoku.name + "," + gumajoku.yain + "," + gumajoku.irryat + "," + gumajoku.jpn);

        shinmajoku.name = "shinmajoku";
        shinmajoku.yain = 120;
        shinmajoku.irryat = 120;
        shinmajoku.jpn = 120;
        System.out.println("shinmajoku의 정보: " + shinmajoku); // 참조값은 변경되지 아니한다.

        // 결론, 여기까지 object는 몇개일까?

        // 문자열은 불변 객체, immutable object - 메모리에 object가 한번 들어가면 바뀔 수 없어. 예를 들어 n1이
        // object를 참조하고 있는데 다른 객체의 주소를 불러올 때 기존 object 정보를 끊고 새로 참조하는 건 가능해도 이전 참조하던
        // object 주소를 변경하는 것은 불가능하다는 것이다. 특정 문자열이 메모리에 저장되었을 때 그 주소가 100이라면 주소 100에는 다른
        // 문자열로 바뀌어서 저장될 수 없다는 것이니라.

    }
}

// Score와 관련된 특징값 또는 기능을 정의
class Score {
    // 자바가 뿌려주는 Class 이름 가지고 오류 메세지를 보면 Field니 Propery니 뿌려대는데 java가 이런 이름으로 뿌려주니
    // 참고하라.
    String name; // 학생이름
    int yain;
    int irryat;
    int jpn;

    // method는 다음 진도에서
}
