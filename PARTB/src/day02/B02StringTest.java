package day02;

// String 타입의 객체 특징
public class B02StringTest {

   public static void main(String[] args) {
      String n1 = "shinmajoku";
      String n2 = "gumajoku";

      System.out.println(n1);
      System.out.println(n2);
      System.out.println(n1.hashCode()); // B01 shinmajoku의 참조값 16진수. hashcode() method는 10진수. 왜 이런 차이가 있을까??
      System.out.println(n2.hashCode());

      n1 = "shinmajoku"; // 245155773
      n2 = "gumajoku"; // 1201986703

      // 문자열은 불변 객체, immutable object - 메모리에 object가 한번 들어가면 바뀔 수 없어. 예를 들어 n1이
      // object를 참조하고 있는데 다른 객체의 주소를 불러올 때 기존 object 정보를 끊고 새로 참조하는 건 가능해도 이전 참조하던
      // object 주소를 변경하는 것은 불가능하다는 것이다. 특정 문자열이 메모리에 저장되었을 때 그 주소가 100이라면 주소 100에는 다른
      // 문자열로 바뀌어서 저장될 수 없다는 것이니라.

      String n3 = "신마적"; // 49467929
      String n4 = "구마적"; // 44190117
      System.out.println(n3.hashCode() + "," + n4.hashCode()); // n3와 n4 안에 있는 이름이 n1과 n2와 동일했다면 동일하게 값은 각각 245155773과
                                                               // 1201986703이었을테네

      String n5 = "shinmajoku";
      System.out.println(n5.hashCode() + ","); // 봐봐. n1과 참조값이 같잖아. 245155773 이잖아

      // 참조값이 변경된다는 것은 객체가 새로 생성된다는 뜻이여.

   }

}
