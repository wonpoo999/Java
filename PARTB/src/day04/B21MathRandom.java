package day04;

import java.util.Arrays;

public class B21MathRandom {
    public static void main(String[] args) {
        int[] result = new int[6];
        int[] balls = new int[45];

        for (int i = 0; i < 45; i++)
            balls[i] = i + 1; // 명령문이 하나만 반복할 떄는 { } 생량

        // 간단 테스트
        for (int i = 0; i < 6; i++) {
            // System.out.println(Math.random()); // 0보다 크고 1보다 작은 실수
            double rndNum = Math.random();
            // 공을 뽑을 index 랜덤 만들기
            int range = 45 - i; // 0보다 크고 (45-i)보다 작은 랜덤값으로 범위 줄여나감
            System.out.print((rndNum * range) + "\t");
            System.out.println((int) (rndNum * range)); // 잘림. Math.round()는 반올림
            int ballIndex = (int) (rndNum * range);

            // random index로 공 뽑기 -> result 배열에 저장
            result[i] = balls[ballIndex];
            // ballIndex 위치의 값은 빼고 복사하여 새로운 배열로 계속하기
            // 메소드 실행 결과 -> balls 기존 배열로 리턴 가능합니다.
            balls = newBalls(balls, ballIndex);
            // (1) return 저장 balls 주소 (2) 인자의 balls 주소 / 배열 순서대로 해야지 니 임의대로 balls 배열 바꿔버리면
            // 코드 꼬인다. 인자는 int balls 저장하잖아. balls 주소는 밑에 newBalls 주소 저장하잖냐. 배열이름은 동일해도 주소는
            // 다르단 말이다.
            // (2)는 newBalls를 실행하고 나면 더 이상 참조되지 않는다 이 얘기여. JVM이 GC (Garbage collection)을
            // 실행한다고. 즉 더 이상 쓰이지 않고 참조되지 않고 나돌아다니는, 쓰레기나 마찬가지인 참조값을 수거한다, 이 얘기여.
            // 🔥 메모리 누수라고 아나? 참조는 되고 있으나 사용하지 않는 거. 그거 왜 있잖아. 메모리 사용량 많은 걸로 잡히는데 정작 메모리
            // 사용하는 앱을 보면 얼마 없다고. 그렇기에 GC가 중요하다고.
            System.out.println(Arrays.toString(result));
            System.out.println(Arrays.toString(balls));
        }

        // 배열 복사 메소드 : System 클래스

    }

    // 뽑힌 공 인덱스 ballIndex 의 값을 빼고 새로운 배열 만들기 -> 참조값 리턴
    private static int[] newBalls(int[] balls, int ballIndex) {
        int[] result = new int[balls.length - 1];
        // 예시: balls.length가 45 이면 새로 만드는 배열은 44개
        // 그리고 ballIndex 가 7이면
        // 첫번째 복사는 0부터 7개 복사
        System.arraycopy(balls, 0, result, 0, ballIndex); // 7개
        // 두번째 복사는 8번 인덱스 부터 45-7-1 = 37개
        // target 배열 result 는 7번 인덱스부터 저장 시키기
        System.arraycopy(balls, ballIndex + 1,
                result, ballIndex, balls.length - ballIndex - 1);
        return result;
    }

    // System 클래스 메소드의 복사를 활용해 보세요.
    private static int[] mergeOfArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length]; // arr1 크기 + arr2의 크기

        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);

        return result; // 배열의 참조값을 전달하기
    }

}