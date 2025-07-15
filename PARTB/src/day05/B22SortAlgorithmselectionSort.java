package day05;

import java.util.Arrays;

public class B22SortAlgorithmselectionSort {

    public static void main(String[] args) {
        int[] nums = { 32, 14, 31, 39, 41, 17 };

        System.out.println("🟡 초기 배열 상태: " + Arrays.toString(nums));
        System.out.println("==== 정렬 과정 시작 ====\n");

        // 실행 시간 비교 : 성능 측정 nanoTime() method
        long startTime = System.nanoTime();

        selectionSort(nums); // 정렬 메소드 호출

        long endTime = System.nanoTime();

        System.out.println("\n✅ 최종 정렬 결과: " + Arrays.toString(nums));

        // 소요 시간 출력 (나노초 단위)
        System.out.println("⏰ 정렬 소요 시간: " + (endTime - startTime) + " 나노초");
        System.out.println("⏰ (밀리초 단위: " + (endTime - startTime) / 1_000_000.0 + " ms)");
    }

    // 🔧 선택 정렬 메소드: 배열을 정렬하면서 매 단계 상태를 출력함
    public static void selectionSort(int[] arr) {
        // 바깥 루프: i가 현재 위치
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("🔽 [i = " + i + "] 현재 기준 값: " + arr[i]);

            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("   → [j = " + j + "] 비교 대상: " + arr[j]);

                if (arr[i] > arr[j]) {
                    // 값이 작으면 교환
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    System.out.println("  👉 교환 발생! → " + Arrays.toString(arr));
                } else {
                    System.out.println("  ❌ 교환 없음");
                }
            }

            System.out.println("✅ 현재 상태 (i = " + i + "): " + Arrays.toString(arr) + "\n");
        }
    }
}
