package day04;

import java.util.Arrays;

// 배열은 변수에 참조값을 저장합니다. 메소드의 인자가 배열인 경우를 예시로 봅시다.
public class B19MyArrayMethod {

    public static void main(String[] args) {
        int[] scores = { 78, 99, 67, 100, 88 };

        // 메소드 실행
        changeArrayValue(scores, 2, 69);
        System.out.println("메소드 실행 후 : " + Arrays.toString(scores));

        int[] scores2 = { 72, 90, 79 };

        System.out.println("sumOfArrayValue - scores 배열 : " + sumOfArrayValue(scores));
        System.out.println("sumOfArrayValue - scores2 배열 : " + sumOfArrayValue(scores2));

        int[] mergeArr = mergeOfArray(scores, scores2);
        System.out.println("합친 배열의 크기 : " + mergeArr.length);
        System.out.println("합친 배열 요소 : " + Arrays.toString(mergeArr));
    }

    // 인자가 배열 : arr은 배열이고 참조값이 전달됩니다.
    private static void changeArrayValue(int[] arr, int index, int value) {
        arr[index] = value;
    }

    // 인자가 배열 : 전달 받은 배열의 합을 구해서 리턴
    private static int sumOfArrayValue(int[] arr) {
        // arr 배열의 합계 구하기
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // sum= sum+arr[i]
        }

        return sum;
    }

    // 리턴이 배열 : 2개의 배열을 인자로 받아서 합치기
    // Arrays.copyOf 는 배열을 1개만 지정하고 target 배열 지정을 못해요.
    private static int[] mergeOfArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length]; // arr1 크기 + arr2의 크기

        // for문으로 실행하기- 2개의 for문
        int i;
        // arr1 을 target 배열 result 에 복사
        for (i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }
        // arr2 을 target 배열 result 에 복사
        // 첫번째 반복문이 끝나면 result 인덱스 변수 i=arr1.length부터 시작하기
        for (i = 0; i < arr2.length; i++) {
            result[arr1.length + i] = arr2[i];
        }

        return result; // 배열의 참조값을 전달하기
    }

}