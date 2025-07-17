package day07.interfac;

// AI 클래스가 인터페이스를 구현(implements 키워드)하도록 예시 만들기
public class AI implements Thinkable {
    private String model;

    public AI(String model) {

    }

    @Override
    public int calculate(int a, int b) {
        return a * b;
    }

    @Override
    public void think(String what) {
        System.out.println(what + " 이해와 생성을 잘함.");
    }

}
