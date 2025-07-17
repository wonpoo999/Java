package day06;

public class C05LecturerVersionShapeParent {
    public static void main(String[] args) {
        TShape s1 = new TRectangle(10, 10, 220, 190, "yellow");
        TShape s2 = new TCircle(10, 20, 0, 0, "blue");
        TShape s3 = new TTriangle(50, 100, 400, 500, "orange");

        // 부모 클래스로 객체 생성 가능
        TShape s4 = new TShape();
        // 너무 추상적인 객체 => 부모클래스는 객체 못함.

        System.out.println(s1.getId());
        System.out.println(s2.getId());
        System.out.println(s3.getId());

        s1.draw();
        s2.draw();
        s3.draw();

        // 자식클래스는 다른 객체를 만듭니다. 이 다른 객체를 부모 타입으로 참조했을 때
        // 실제 객체의 타입 검사 : instanceof 연산자(boolean 리턴)

        System.out.println("rec instanceof TRectangle : " + (s1 instanceof TRectangle)); // true
        System.out.println("rec instanceof TTriangle : " + (s1 instanceof TTriangle)); // false
        System.out.println("rec instanceof TCircle :" + (s1 instanceof TCircle)); // fasle

        // 사용할 모든 도형을 배열 자료구조에 저장하기 (예시)
        TShape[] shapes = new TShape[] { s1, s2, null, s3, null }; // 맨처음 초기화할때만 {s1,s2,null,s3,null} 가능
        // shapes[0]=s1;

        // 모든 도형 중에 'Circle' 만 반지름을 지정해서 그리기: TCircle 클래스는 radius 정의.
        for (TShape sh : shapes) { // sh = shapes[i] (i값은 자동으로 증가)
            if (sh instanceof TCircle) { // null instanceof TCircle 는 false
                System.out.println("원(circle) 입니다." + sh.toString());
                // 🔥 setRadius 를 실행하기 위해 TCircle 타입으로 캐스팅해야합니다.
                // sh.setRadius() 는 객체는 TCircle 타입이지만 현재 참조는 부모 타입이므로 실행 못함.
                TCircle temp = (TCircle) sh; // 부모타입 변수를 자식타입으로 참조 X.
                temp.setRadius(40);
                temp.draw();
            } else {
                System.out.println("기타 도형 입니다. " + sh); // sh.toString()은 NullPointerException 발생
            }
        }

        // shapes 를 다시 새로운 배열로 대입할 때는 반드시 shapes = new TShape[]{s1,s2,null,s3,null}

    }
}

class TShape {
    private int posX;
    private int posY;
    private int width;
    private int height;
    private String color;
    private int id;

    private static int count = 0;

    TShape() {
        count++;
        this.id = count;
        this.color = "black";
    }

    TShape(int posX, int posY, int width, int height, String color) {
        this(); // 기본생성자 호출
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("shape id[%d] pos(%d, %d) size(%d, %d) %s",
                id, posX, posY, width, height, color);
    }

    // setter
    public void move(int offsetX, int offsetY) {
        this.posX += offsetX;
        this.posY += offsetY;
    }

    // setter
    public void resize(int offsetW, int offsetH) {
        this.width += offsetW;
        this.height += offsetH;
    }

    public void color(String color) {
        this.color = color;
    }

    public double calcArea() { // 넓이 계산 후 리턴
        return width * height;
    }

    public void draw() {
        System.out.println("도형 그리기 : " + this.toString() + "  area: " + calcArea());
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public int[] getPosition() {
        return new int[] { posX, posY };
    }

    public int[] getSize() {
        return new int[] { width, height };
    }

}

class TRectangle extends TShape {

    // 부모클래스의 커스텀 생성자를 사용하기 위해서 자식 클래스도 정의합니다.
    TRectangle() {
        super(); // 생략 가능
    }

    TRectangle(int posX, int posY, int width, int height, String color) {
        super(posX, posY, width, height, color); // 부모 클래스의 커스텀 생성자 호출
                                                 // 인자의 형식, 개수는 일치
    }

    @Override
    public void draw() {
        super.draw(); // 부모가 정의 draw() 실행하기
        System.out.println("■■■■■■■■■■■");
        System.out.println("■         ■");
        System.out.println("■         ■");
        System.out.println("■         ■");
        System.out.println("■         ■");
        System.out.println("■■■■■■■■■■■");
    }

}

class TTriangle extends TShape {

    TTriangle() {
        super(); // 생략 가능
    }

    TTriangle(int posX, int posY, int width, int height, String color) {
        super(posX, posY, width, height, color);
    }

    @Override
    public double calcArea() {
        return super.calcArea() / 2; // 삼각형의 넓이
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("    #    ");
        System.out.println("   #  #   ");
        System.out.println("  #    #  ");
        System.out.println(" #      # ");
        System.out.println("##########");
    }

}

class TCircle extends TShape {
    // 원에 필요한 반지름을 새로운 속성으로 추가
    private int radius;
    private static final double PI = 3.14; // 상수로 선언.

    TCircle() {
        super(); // 생략 가능
    }

    TCircle(int posX, int posY, int width, int height, String color) {
        super(posX, posY, width, height, color);
    }

    @Override
    public double calcArea() {
        return radius * radius * PI;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("   @ @ @  ");
        System.out.println(" @       @ ");
        System.out.println("@         @");
        System.out.println("@         @");
        System.out.println(" @       @ ");
        System.out.println("   @ @ @    ");
    }
}