// class = 참조값 저장한다
// 변수는 참조형 타입으로 객체의 주소를 저장한다.

public class PeopleTest {

    public static void main(String[] args) {
        //People class를 이용하여 객체를 만든다.
        // -> 객체를 만드는 연산은 new 입니다.
        People leedaehan = new People();   // 클래스타입 변수명 = new 클래스이름()       
        People kokohan = new People();      // 객체를 만들 때는 class를 통해 만드는겨

        System.out.println("name:"+leedaehan.name); // null(참조형 기본값) null은 아무것도 참조하고 있지 않다는 뜻
        System.out.println("age: " +kokohan.isAdult);   // false
        System.out.println("isAdult:" +leedaehan.isAdult);   // false
        System.out.println("gender:"+kokohan.gender); // ' '

        // kokoha 객체에 속성값을 저장하기
        // 객체(Object)는 데이터의 대상이 여러 값으로 표현될 때 사용한단다. 혹은 method를 갖고 있을 떄 ,또는 기능 표현될 때.
        kokohan.name = "고고한";
        kokohan.age = 32;
        kokohan.isAdult=true;
        kokohan.gender='M';

        leedaehan.name = "이대한";
        leedaehan.age = 32;
        leedaehan.isAdult=true;
        leedaehan.gender='M';


        System.out.println("kokohan People 객체 정보 (속성 저장값 확인) -------");
        System.out.println("name:" + kokohan.name);
        System.out.println("name:" + kokohan.age);
        System.out.println("name:" + kokohan.isAdult);
        System.out.println("name:" + kokohan.gender);
        System.out.println("name:" + leedaehan.name);
        System.out.println("name:" + leedaehan.age);
        System.out.println("name:" + leedaehan.isAdult);
        System.out.println("name:" + leedaehan.gender);

        //문자열 객체 생성 참고
        String test = new String();
        String test2 = "Yainshidae";         // 객체를 만들 때 쓰는 연산은 new니라 
    }
}
