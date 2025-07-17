package day07.interfac;

public class Human implements Runnable, Cookable {
    private String hobby;

    @Override
    public String run(int speed) {
        return "달리기 잘함 : 평균 속도 - " + speed;
    }

    @Override
    public String beable() {
        return hobby + " 취미가 있음.";
    }

    @Override
    public void cook(String material) {
        System.out.println("오늘은 " + material + " 저녁 요리를 합니다.");
    }

}
