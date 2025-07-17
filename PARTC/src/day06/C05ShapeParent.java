package day06;

public class C05ShapeParent {
    public static void main(String[] args) {
        // 자식 클래스를 부모 타입 변수로 사용하여 다형성 테스트
        Shape rect = new Rectangle(10, 20, 30, 40); // 사각형 객체 생성
        Shape tri = new Triangle(5, 5, 10, 20); // 삼각형 객체 생성
        Shape circle = new Circle(15, 15, 10, 10); // 원 객체 생성

        // draw() 메소드: 도형의 정보 출력
        rect.draw();
        tri.draw();
        circle.draw();

        // 각 도형의 넓이 출력 (재정의된 calcArea() 호출)
        System.out.println("넓이: " + rect.calcArea());
        System.out.println("넓이: " + tri.calcArea());
        System.out.println("넓이: " + circle.calcArea());

        // 공통 메소드 기능 확인: 이동, 리사이즈, 색상변경
        rect.move(10, 10); // x, y 좌표 이동
        rect.resize(5, 5); // 너비, 높이 증가
        rect.setColor("red"); // 색상 변경
        rect.draw(); // 변경 후 다시 출력
    }
}

// ==========================================
// [부모 클래스] Shape : 도형의 공통 속성과 기능 정의
// ==========================================
abstract class Shape {
    // ✅ 도형의 공통 속성: 좌표, 크기, 색상, 고유 id
    private int posX;
    private int posY;
    private int width;
    private int height;
    private String color;
    private int id;

    // ✅ static count : 객체 수를 세어 ID 부여
    private static int count = 0;

    // ✅ 기본 생성자 : color는 black, id는 count를 증가시켜 자동 지정
    public Shape() {
        count++; // 생성 시마다 count 증가
        this.id = count; // 현재 count를 id로 저장
        this.color = "black"; // 기본 색상
    }

    // ✅ 커스텀 생성자 : 위치와 크기를 초기화
    public Shape(int posX, int posY, int width, int height) {
        this(); // 기본 생성자 호출
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    // ✅ 도형 이동 메소드
    public void move(int offsetX, int offsetY) {
        this.posX += offsetX;
        this.posY += offsetY;
    }

    // ✅ 도형 크기 조절 메소드
    public void resize(int offsetW, int offsetH) {
        this.width += offsetW;
        this.height += offsetH;
    }

    // ✅ 색상 변경
    public void setColor(String color) {
        this.color = color;
    }

    // ✅ 넓이 계산 : 자식 클래스에서 반드시 재정의
    public abstract double calcArea();

    // ✅ 도형 출력 메소드
    public void draw() {
        System.out.printf("[ID: %d] %s 도형 - 위치(%d, %d), 크기(%d x %d), 색상: %s\n",
                id, getClass().getSimpleName(), posX, posY, width, height, color);
    }

    // ✅ Getter & Setter (자식 클래스나 외부에서 접근 위해)
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public int getId() {
        return id;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

// ==========================================
// [자식 클래스] Rectangle : 사각형 도형
// ==========================================
class Rectangle extends Shape {
    // 생성자: 부모 생성자 호출
    public Rectangle(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
    }

    // 넓이 계산: 너비 * 높이
    @Override
    public double calcArea() {
        return getWidth() * getHeight();
    }
}

// ==========================================
// [자식 클래스] Triangle : 삼각형 도형
// ==========================================
class Triangle extends Shape {
    // 생성자: 부모 생성자 호출
    public Triangle(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
    }

    // 넓이 계산: (너비 * 높이) / 2
    @Override
    public double calcArea() {
        return (getWidth() * getHeight()) / 2.0;
    }
}

// ==========================================
// [자식 클래스] Circle : 원 도형
// ==========================================
class Circle extends Shape {
    // 원은 반지름 속성이 추가로 필요함
    private double radius;

    // 생성자: 부모 생성자 호출 + 반지름 초기화
    public Circle(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
        this.radius = width / 2.0; // width를 지름으로 간주
    }

    // 넓이 계산: π * r^2
    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    // 크기 변경 시 반지름도 갱신
    @Override
    public void resize(int offsetW, int offsetH) {
        super.resize(offsetW, offsetH); // 부모 메소드로 width/height 변경
        this.radius = getWidth() / 2.0; // 새 width 기준으로 반지름 재계산
    }

    // draw 메소드 재정의 : 반지름 정보 추가 출력
    @Override
    public void draw() {
        super.draw(); // 기본 도형 정보 출력
        System.out.printf("    (반지름: %.2f)\n", radius);
    }
}
