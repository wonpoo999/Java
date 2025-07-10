package day02;

/*
 * Overtide는 Class의 '상속' 관련 개념이니라.
 * Java의 모든 Class는 Object라는 이름의 최상위 Class를 자동 inherit상속 받느니라
 * Object는 몇가지 기본 method를 갖고 있는데, 이것을 새로운 클래스를 만들면서 변경할 수 있는데 그것이 'Override" 이니라.'
 * Java에서는 Class 끼리 상속 개념을 많이 쓴다. 객체(Object)를 통해서 덮어쓰기(Override)한다고
 * 
 */
public class B04OverrideTest {

    public static void main(String[] args) {

        Score shinmajoku = new Score();

        shinmajoku.name = "마적";
        shinmajoku.yain = 100;
        shinmajoku.irryat = 50;
        shinmajoku.jpn = 20;

        System.out.println("shinmajoku의 정보: " + shinmajoku);
        System.out.println(
                "---" + shinmajoku.name + "," + shinmajoku.yain + "," + shinmajoku.irryat + "," + shinmajoku.jpn);
        System.out.println("sdjnhflksjhflkjasdhflkjasdhlfkasjdlkf;jsakldjfas" + shinmajoku.toString());
    }

}

class Score { // Score 는여기서 시작해
    String name;
    int yain;
    int irryat;
    int jpn;

    // Object parent class's method : clone(), hashcode(), equals(), toString()
    // toString()은 Overtide (redefine 재정의). @Override는 실행코드가 아니라 개발관련 주석이니라.
    // (Annotation)[주석]. 예를 들어서 toString이라는 게 있지? 근데- toStrings라고 쓰면 오류가 떠. 왜냐하면
    // toString이라는 개발관련 주석은 있어도 toStrings는 없으니 오류가 뜰거다. 내가 toString @Override 한다고
    // 쓰는거지.
    @Override
    public String toString() {
        return ("---" + name + "," + yain + "," + irryat + "," + jpn);

    }
    // 요 method는 여기로 return 하는 method
} // 여기서 Score가 끝나지? 여기까지를 Scope라고 해 (Scope - 범위)
/*
 * 정리:
 * Score2 shinmajoku = new Score2();
 * String gumajoku = "gumajoku";
 * 
 * //아래의 2줄은 모두 shinmajoku.toString(), shinmajoku.toString()을 실행한다.
 * // 기본적으로 '객체참조변수. toString()' 은 참조값을 출력,
 * // toString()을 재정의 (Override)하면 출력 문자열을 바꿀 수 있어.
 * // 🔥toString Class는 이미 toString() method가 재정의 되어서 문자열이 출력된다
 * // 🔥개발자가 만든 클래스는 개발자가 재정의하여 사용한다.
 * System.out.printIn(shinmajoku)
 * Sysyem.out.printIn(gumajoku)
 * 
 * 
 */
