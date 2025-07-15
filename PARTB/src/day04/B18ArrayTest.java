package day04;

import java.util.Arrays;
// 자바에서 java.lang 기본패키지 이외의 것들을  import하고 사용.
// java.lang 패키지 소속: String, System Integer와 같은 Wrapper 클래스 등등

public class B18ArrayTest {

    public static void main(String[] args) {
        // 자바의 배열 선언: 배열 타입은 [] 기호, 배열 리터럴 {}
        int[] arr1 = { 11, 22, 33, 44, 55 };
        int[] arr2 = new int[10]; // 10개 요소 메모리 공간 확보. 기본값 0

        System.out.println("arr1: " + arr1);
        System.out.println("arr2: " + arr2);

        double[] darr1 = { 3.4, 5, 8.88, 1.23, 9.99 };
        double[] darr2 = { 3.4, 5, 8.88, 1.23, 9.99 };
        System.out.println("darr1: " + darr1); // darr1 : []
        System.out.println("darr2: " + darr2); // darr1 : []

        // 배열의 기본속성 (method 아님)
        System.out.println("arr1: " + arr1.length); // 5
        System.out.println("arr2: " + arr2.length); // 10

        // 배열요소는 인덱스로 지정한다. 자바의 인덱스는 자바 스크립트 처럼 0부터 시작.
        // arr1, arr2 배열 마지막 요소를 99로 저장하기
        arr1[arr1.length - 1] = 99;
        arr2[arr2.length - 1] = 99;
        System.out.println("arr1[4]: " + arr1[4]);
        System.out.println("arr2[9]: " + arr2[9]);

        // 자바스크립트는 배열 메소드 중에 push(), pull()로 배열의 크기 (length)가 동적으로 변경
        // 자바는 배열 크기는 고정된 크기 입니다.
        // 자바는 배열관련 method는 Arrays라는 클래스에서 static method를 사용해야한다.
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));

        // 2. 배열 요소를 특정 값으로 채우기
        Arrays.fill(arr2, 3);
        System.out.println("arr2 : " + Arrays.toString(arr2));
        Arrays.fill(arr2, 2, 5, 7); // 7로 채워지는 인덱스 : 2, 3, 4
        System.out.println("arr2 : " + Arrays.toString(arr2));

        // 3. 배열의 비교
        System.out.println("실수배열 참조값 비교: " + (darr1 == darr2)); // 참조값 비교. false
        System.out.println("실수배열 배열요소값 비교: " + Arrays.equals(darr1, darr2)); // 참조값 비교. true

        // 4. 배열의 복사
        int[] newarr1 = Arrays.copyOf(arr1, 3);
        // 첫번째 인자 배열에서 복사하기, 두번째 인자는 복사할 갯수
        System.out.println("복사한 배열: " + Arrays.toString(newarr1));

        // 5. 배열의 정렬
        int[] sarr1 = { 56, 45, 77, 64, 72 };
        Arrays.sort(sarr1);
        System.out.println("정렬 후 sarr1 배열: " + Arrays.toString(sarr1));

        // Arrays의 method 중에서 fill, sort는 return type이 void 이며, 배열의 element 값들을 변경하게 돼.
        // sort도 변경이고
    }
}
