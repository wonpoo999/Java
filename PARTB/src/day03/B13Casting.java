package day03;

public class B13Casting {
    /*
     * 기본형식 데이터 타입간의 변환 : 캐스팅 casting
     * byte < short < int < long < float < double // char는 음수 표현이 안 되기 떄문에 넣기
     * 애매하느니라. 넣는다면 byte와 short 사이에 넣으면 될게다
     * 
     * 1. 자동 캐스팅 - 표현의 범위가 더 큰쪽으로 대입하는 경우 자동 캐스팅이니라
     * 2. 강제 캐스팅 - 표현의 범위가 더 작은쪽으로 대입해야하는 경우는 강제로 데이터 짤려도 상관없으니 캐스팅해! 라는 것이니라.
     * 
     * 그럼 어떤 경우가
     *
     */;

    public static void main(String[] args) {
        double test = 23; // 왼쪽의 변수는 double 변수에 int 값을 대입하는 것이니, 자동 캐스팅해도 된다

        int num = (int) 2147483648L; // 이건 long 값이지? 정수에 대입하고 싶으면 강제로 괄호 사이에 int를 넣는거다. // int 변수 = long 값; 은 값이 잘림.
                                     // 강제로 변환, 즉 강제 캐스팅이여

        System.out.println(test);
        System.out.println(num);

        // B12 에서 변수를 사용했다면 double temp = sum(); <= 요렇게 하면 자동 캐스팅이 된다. double은 변수고
        // sum()은 int 이니까.
        // 변수를 선언하지 않고 바로 실수로 변환하기 위해 (double)sum() / 3
        // 변수를 선언하지 않으려고 바로 위처럼 해서 강제 캐스팅 하는겨.

    }

}
