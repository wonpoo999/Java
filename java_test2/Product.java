package test;

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

    // 꼭 필요한 메소드 1개 추가 ✅
    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product (pid=" + pid + ", title=" + title + ", price=" + price + ")";
    }

}
