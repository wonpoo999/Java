package day07.interfac;

public class Dog implements Runnable {
    private String type; // 견종

    @Override
    public String beable() {
        return "짖고 싸우기 잘함!!!";
    }

    @Override
    public String run(int speed) {
        return "매우 잘 달림 - " + speed;
    }

}