package day05;

import java.util.Arrays;

public class B22SortAlgorithmbubbleSort {

    public static void main(String[] args) {
        int[] nums = { 32, 14, 31, 39, 41, 17 };

        System.out.println("🟡 초기 배열 상태: " + Arrays.toString(nums));
        System.out.println("==== 버블 정렬 과정 시작 ====\n");

        // 실행 시간 측정 시작
        long startTime = System.nanoTime();

        bubbleSort(nums); // 버블 정렬 메소드 호출

        // 실행 시간 측정 종료
        long endTime = System.nanoTime();

        System.out.println("\n✅ 최종 정렬 결과: " + Arrays.toString(nums));

        // 소요 시간 출력 (나노초 및 밀리초 단위)
        System.out.println("⏰ 정렬 소요 시간: " + (endTime - startTime) + " 나노초");
        System.out.println("⏰ (밀리초 단위: " + (endTime - startTime) / 1_000_000.0 + " ms)");
    }

    // 🔧 버블 정렬 메소드
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        // 바깥 루프: 전체 배열을 n-1번 반복
        for (int i = 0; i < n - 1; i++) {
            System.out.println("🔽 [Pass " + (i + 1) + "]");

            boolean swapped = false; // 최적화: 교환이 일어났는지 확인

            // 안쪽 루프: 인접한 요소끼리 비교
            for (int j = 0; j < n - 1 - i; j++) {
                System.out.print("   → 비교: arr[" + j + "]=" + arr[j] + " vs arr[" + (j + 1) + "]=" + arr[j + 1]);

                if (arr[j] > arr[j + 1]) {
                    // 교환
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    System.out.println("  👉 교환 발생! → " + Arrays.toString(arr));
                    swapped = true;
                } else {
                    System.out.println("  ❌ 교환 없음");
                }
            }

            System.out.println("✅ 현재 상태 (pass " + (i + 1) + "): " + Arrays.toString(arr) + "\n");

            // 교환이 한 번도 없었다면 이미 정렬 완료
            if (!swapped) {
                System.out.println("✅ 이미 정렬 완료! 더 이상 반복하지 않음.\n");
                break;
            }
        }
    }
}
