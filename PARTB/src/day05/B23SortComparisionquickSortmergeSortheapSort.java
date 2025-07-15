package day05;

import java.util.Arrays;

public class B23SortComparisionquickSortmergeSortheapSort {

    public static void main(String[] args) {
        // 테스트용 원본 배열 (정렬 전 상태)
        int[] original = { 32, 14, 31, 39, 41, 17, 50, 28, 5, 7, 44 };

        System.out.println("🟡 원본 배열: " + Arrays.toString(original) + "\n");

        // 퀵 정렬 테스트
        int[] arrQuick = Arrays.copyOf(original, original.length);
        System.out.println("==== 퀵 정렬 시작 ====");
        long startQuick = System.nanoTime(); // 퀵 정렬 시작 시간 측정
        quickSort(arrQuick, 0, arrQuick.length - 1); // 퀵 정렬 수행
        long endQuick = System.nanoTime(); // 퀵 정렬 종료 시간 측정
        System.out.println("✅ 퀵 정렬 결과: " + Arrays.toString(arrQuick));
        System.out.println("⏰ 퀵 정렬 시간: " + (endQuick - startQuick) + " ns\n");

        // 병합 정렬 테스트
        int[] arrMerge = Arrays.copyOf(original, original.length);
        System.out.println("==== 병합 정렬 시작 ====");
        long startMerge = System.nanoTime(); // 병합 정렬 시작 시간 측정
        arrMerge = mergeSort(arrMerge); // 병합 정렬 수행 (재귀 메소드라 리턴된 배열로 받음)
        long endMerge = System.nanoTime(); // 병합 정렬 종료 시간 측정
        System.out.println("✅ 병합 정렬 결과: " + Arrays.toString(arrMerge));
        System.out.println("⏰ 병합 정렬 시간: " + (endMerge - startMerge) + " ns\n");

        // 힙 정렬 테스트
        int[] arrHeap = Arrays.copyOf(original, original.length);
        System.out.println("==== 힙 정렬 시작 ====");
        long startHeap = System.nanoTime(); // 힙 정렬 시작 시간 측정
        heapSort(arrHeap); // 힙 정렬 수행
        long endHeap = System.nanoTime(); // 힙 정렬 종료 시간 측정
        System.out.println("✅ 힙 정렬 결과: " + Arrays.toString(arrHeap));
        System.out.println("⏰ 힙 정렬 시간: " + (endHeap - startHeap) + " ns\n");
    }

    /*
     * 퀵 정렬(Quick Sort)
     * 배열을 피벗을 기준으로 작은 값은 왼쪽, 큰 값은 오른쪽으로 분할하며 정렬하는 대표적인 분할 정복 알고리즘.
     * 평균 시간복잡도는 O(n log n)이고, 불안정 정렬이다.
     * 재귀 호출로 동작하며, partition 메소드가 배열을 두 부분으로 나누는 역할을 한다.
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high); // 분할: 피벗 위치 찾기
            System.out.println("퀵 정렬: partition index " + p + ", 배열 상태: " + Arrays.toString(arr));

            quickSort(arr, low, p - 1); // 피벗 왼쪽 부분 정렬 재귀 호출
            quickSort(arr, p + 1, high); // 피벗 오른쪽 부분 정렬 재귀 호출
        }
    }

    // partition: 피벗을 기준으로 작은 값과 큰 값을 나누고, 피벗 위치 반환
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 일반적으로 배열 끝값을 피벗으로 사용
        int i = low - 1; // 작은 값들의 경계 인덱스

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) { // 피벗보다 작거나 같으면
                i++;
                swap(arr, i, j); // i와 j 위치 값 교환하여 작은 값들을 왼쪽에 모음
            }
        }
        swap(arr, i + 1, high); // 피벗을 작은 값들의 바로 다음 위치로 옮김
        return i + 1; // 피벗 위치 반환
    }

    /*
     * 병합 정렬(Merge Sort)
     * 배열을 절반씩 분할해 각각 정렬 후 병합하는 안정적인 분할 정복 알고리즘.
     * 시간복잡도는 항상 O(n log n)으로 안정적이며 큰 배열에 적합.
     * 재귀로 분할하고 merge 함수에서 두 정렬된 배열을 병합.
     */
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1)
            return arr; // 배열 크기가 1 이하면 이미 정렬된 상태

        int mid = arr.length / 2;

        // 배열을 절반씩 나눠 재귀 호출
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        // 정렬된 두 배열 병합
        int[] merged = merge(left, right);
        System.out.println("병합 정렬: 병합된 배열 상태: " + Arrays.toString(merged));

        return merged; // 병합 후 배열 반환
    }

    // 두 정렬된 배열 left와 right를 하나의 정렬된 배열로 병합
    private static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int l = 0, r = 0, idx = 0;

        // 두 배열 원소를 비교하며 작은 쪽부터 merged 배열에 삽입
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r])
                merged[idx++] = left[l++];
            else
                merged[idx++] = right[r++];
        }

        // left 배열에 남은 원소 추가
        while (l < left.length)
            merged[idx++] = left[l++];
        // right 배열에 남은 원소 추가
        while (r < right.length)
            merged[idx++] = right[r++];

        return merged;
    }

    /*
     * 힙 정렬(Heap Sort)
     * 완전 이진 트리를 기반으로 최대 힙을 구성한 후,
     * 루트(최대값)를 배열 끝으로 보내면서 정렬하는 비교 기반 알고리즘.
     * 시간복잡도는 O(n log n)이며, 불안정 정렬.
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 1. 최대 힙 구성 (배열을 최대 힙 구조로 만듦)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i); // 힙 속성 유지
            System.out.println("힙 구성 중 (heapify): " + Arrays.toString(arr));
        }

        // 2. 최대 힙에서 루트와 마지막 노드 교환하며 정렬
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i); // 최대값을 배열 끝으로 이동
            System.out.println("힙 정렬: swap 후 배열 상태: " + Arrays.toString(arr));
            heapify(arr, i, 0); // 힙 속성 유지 (i는 줄어든 힙 크기)
            System.out.println("힙 정렬: heapify 후 배열 상태: " + Arrays.toString(arr));
        }
    }

    // 힙 속성을 유지하도록 배열을 재조정 (재귀)
    private static void heapify(int[] arr, int heapSize, int rootIdx) {
        int largest = rootIdx; // 가장 큰 값의 인덱스 초기화
        int left = 2 * rootIdx + 1; // 왼쪽 자식 노드 인덱스
        int right = 2 * rootIdx + 2; // 오른쪽 자식 노드 인덱스

        // 왼쪽 자식이 힙 범위 내이고, 값이 현재 최대값보다 크면 largest 갱신
        if (left < heapSize && arr[left] > arr[largest])
            largest = left;
        // 오른쪽 자식도 검사
        if (right < heapSize && arr[right] > arr[largest])
            largest = right;

        // 최대값이 루트가 아니면 서로 교환 후 재귀 호출로 하위 트리 재정렬
        if (largest != rootIdx) {
            swap(arr, rootIdx, largest);
            heapify(arr, heapSize, largest);
        }
    }

    // 배열 내 두 인덱스의 값 교환
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
