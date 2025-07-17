package day07.interfac;

// 기능에 대한 정의
public interface Beable {

    // public abstract String beable(); // 인터페이스에서 public abstarct 키워드 생략
    String beable();
}

interface Cookable {
    int MAX_TIME = 20; // public static final 키워드 생략

    void cook(String material); // 요리하다.
}

interface Runnable extends Beable {
    String run(int speed); // 달리다
}

interface Thinkable {
    void think(String what);

    int calculate(int a, int b);
}