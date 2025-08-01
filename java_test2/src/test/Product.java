package src.test;

public class Product {
    private int pid;
    private String title;
    private double price;

    public Product(int pid, String title, double price) {
        this.pid = pid;
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    // 꼭 필요한 메소드 1개 추가 ✅ // 전체 상품을 바꾸는 게 아니라 가격만 바꾸는 거니까 setter method 하나 넣고 그걸 호출해서 가격만 수정. set으로
    // 시작하는 메서드는 가변 객체. 즉 가격을 바꿀 수 있다. String, Integer, Double 등은 내부 값을 바꿀 수 있는 set 메서드 없음. 값을 바꾸려면
    // 새로운 객체를 만들어야 하는데 이건 불변 객체

    public void setPrice(double price) {
        this.price = price;
    }



    @Override
    public String toString() {
        return "Product (pid=" + pid + ", title=" + title + ", price=" + price + ")";
    }

}
