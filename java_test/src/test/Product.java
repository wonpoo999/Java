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

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() { // ✅ 추가
        return title;
    }

    @Override
    public String toString() {
        return "Product [pid=" + pid + ", title=" + title + ", price=" + price + "]";
    }
}
