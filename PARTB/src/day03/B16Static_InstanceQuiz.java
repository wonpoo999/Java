package day03;

public class B16Static_InstanceQuiz {

    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        System.out.println(Counter.getCount())
    }

}

class Counter {
    private static int count = 0;

    public Counter() {
        count++;
    }

    // count 값을 리턴하는 getter 만들기
}
