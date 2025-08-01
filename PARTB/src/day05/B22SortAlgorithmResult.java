package day05;

// 배열을 문자열로 보기 좋게 출력해주는 Arrays.toString() 사용을 위해 import
import java.util.Arrays; // 배열 출력용 import 필요

public class B22SortAlgorithmResult {

    public static void main(String[] args) {
        // 오름차순: 가장 작은 값을 순서대로 찾아서 앞에부터 놓기
        // -> 선택 정렬
        // i = 0 j= i+ 1 ~ 5 => i < j (비교) 우리가 정해놓은 규칙에 따르면 i가 j 보다 작아야하는데 그렇지
        // 않다?(false). 그럼 갚을 교환한다.
        // 예를 들어 32가 i고 14가 j야. 그러면 i가 14가 되고 j가 32가 된다. 그 이후14가 된 i는 그 다음 숫자들이랑 비교하지.
        // 하지만 다른 숫자 보다 가장 작기 떄문에
        // 14 32 31 39 41 17이 되지.
        // i는 0부터 5까지 총 6개 있지? 그래서 한번 비교가 끝나면 그 다음 index로 넘어가. j의 경우 i 다음 번호에서 그 다음
        // index랑 비교해야 하잖아. 그렇기에 i의 번호에 1을 더해서 그 다음 index랑 비교할 수 있는거지. 결국 j는 i의 이전 번호가 될
        // 수 없으니 이 비교 작업은 계속 이루어지는겨. 밑에 process가 계속 이어질겨.
        // 보면 j = i + 1 ~5로 되어 있잖냐. j + 1 해서 2번째 인덱스에서 (32)에서 시작하고 비교를 개시하지. 그러면? 32보다
        // 작은 건 맨 마지막 17 밖에 없잖냐. 다른 거랑 비교하다가 맨 마지막에 17이랑 비교해서 위치를 바꾸면? 그러면 14 17 32 39
        // 41 31이 되지.
        // 이게 끝까지 반복되는겨
        // 근데 변수의 교환이라는 게 얘기 처럼 쉽게 뒤바뀌는 게 아니라고. 예를 들어 나 하고 임민수님이 위 식 논리에 따라 자리를 교환할 때 내가
        // 임하형이 앉아있던 자리로 옮기고 임민수님이 내 자리로 옮기면 내가 그 다음 임민수님 자리로 옮기는 식이지. 얘기만 들어보면 상당히
        // 비효율적이라 할 수 있다.
        //
        // 🔸 정렬 대java_workspace/PARTB/src/day05/B22SortAlgorithm.java상 배열 (숫자들을 오름차순으로
        // 정렬할 예정)
        int[] nums = { 32, 14, 31, 39, 41, 17 };

        // 🔁 바깥 for문: 현재 비교 대상이 되는 인덱스 i를 0부터 시작
        // nums.length - 1 까지만 도는 이유? 마지막 원소는 어차피 제자리일 것이므로
        for (int i = 0; i < nums.length - 1; i++) {
            // 🔁 안쪽 for문: i 바로 다음 인덱스부터 끝까지 비교
            // i보다 더 뒤에 있는 값들과 차례대로 비교
            for (int j = i + 1; j < nums.length; j++) {
                // 🔍 현재 i 위치의 값이 j 위치의 값보다 크다면 (=오름차순 조건 위반)
                if (nums[i] > nums[j]) {
                    // 더 작은 값이 있으면 교환
                    // ↔️ 두 값을 교환 (스왑)
                    // 임시 변수 temp를 사용해서 값을 잠깐 저장해두고 서로 교환함
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                // ⛔ nums[i] <= nums[j]라면 아무 일도 안 일어남 (위치 유지)
            }

            // ✅ 이 시점에서 nums[i]는 해당 위치에 들어갈 "가장 작은 값"이 됨
        }
        // 📤 정렬이 완료된 배열을 출력
        // Arrays.toString()은 배열을 문자열 형태로 보기 좋게 바꿔줌
        System.out.println("Sort Result: " + Arrays.toString(nums));
    }

}
