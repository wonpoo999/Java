package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductManagerAppAnswer {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        System.out.println("📦📦📦 상품 관리 프로그램입니다. 📦📦📦"); // 문제 1

        initProductList(list); // list 초기화

        boolean status = true;
        while (status) {
            System.out.println("\n작업 메뉴를 선택하세요.");
            System.out.println("[A] 상품 추가   [R] 상품 삭제   [U] 가격 변경   \n[L] 전체 상품 목록   [S] 상품 조회   [E] 종료");
            String menu = System.console().readLine("선택 >>> ");

            try {
                switch (menu.toUpperCase()) {
                    case "A":
                        addProduct(list); // 문제 2
                        break;

                    case "R":
                        String index = System.console().readLine("\t삭제할 인덱스 입력 >>> ");
                        int idx = Integer.parseInt(index); // 문제 3
                        if (confirm("삭제")) {
                            Product p = list.remove(idx); // 문제 3
                            System.out.println("\t삭제 데이터 : " + p); // 문제 3
                        } else {
                            System.out.println("\t삭제를 취소했습니다.");
                        }
                        break;

                    case "U":
                        int uidx = Integer.parseInt(System.console().readLine("\t수정할 인덱스 입력 >>> ")); // 문제 4
                        double price = Double.parseDouble(System.console().readLine("\t판매 가격 입력 >>> ")); // 문제 4
                        if (confirm("가격 변경")) { // 문제 5
                            list.get(uidx).setPrice(price); // 문제 6
                            System.out.println("\t업데이트 결과 : " + list.get(uidx)); // 문제 6
                        } else {
                            System.out.println("\t포인트 변경을 취소했습니다.");
                        }
                        break;

                    case "L":
                        System.out.println("\t\t상품 리스트");
                        for (int i = 0; i < list.size(); i++) // 문제 7
                            System.out.println("\t" + i + ": " + list.get(i));
                        break;

                    case "S":
                        String keyword = System.console().readLine("\t찾는 상품 제목 단어 입력 >>> "); // 문제 8
                        for (int i = 0; i < list.size(); i++) {
                            Product p = list.get(i); // 문제 9
                            if (p.getTitle().contains(keyword)) { // 문제 9
                                System.out.println("\t" + i + ": " + p); // 문제 9
                            }
                        }
                        break;

                    case "E":
                        System.out.println("\t앱을 종료하시겠습니까?");
                        if (confirm("종료")) { // 문제 10
                            status = false; // 문제 10
                        } else {
                            System.out.println("앱 종료를 취소했습니다.");
                        }
                        break;

                    default:
                        System.out.println("잘못된 메뉴 선택입니다.");
                        break;
                }

            } catch (NumberFormatException e) { // 문제 11
                System.out.println("숫자만 입력하세요."); // 문제 11
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    private static void initProductList(List<Product> list) {
        Product p1 = new Product(1212, "LG그램", 345600.0);
        Product p2 = new Product(2499, "LG스탠바이", 190100.0);
        Product p3 = new Product(1213, "삼성OLED", 554500.0);
        Product p4 = new Product(4546, "바디프랜드", 632000.0);
        list.add(p1); // 문제 12
        list.add(p2); // 문제 12
        list.add(p3); // 문제 12
        list.add(p4); // 문제 12
    }

    private static void addProduct(List<Product> list) {
        int pid = new Random().nextInt(8889) + 1111; // 문제 13
        String title = System.console().readLine("\t상품 제목 입력 >>> ");
        double price = Double.parseDouble(System.console().readLine("\t상품 가격 입력 >>> "));
        if (confirm("상품 등록")) {
            Product p = new Product(pid, title, price);
            list.add(p); // 문제 14
            System.out.println("\t등록 확인 : " + pid);
        } else {
            System.out.println("\t등록을 취소했습니다.");
        }
    }

    private static boolean confirm(String task) {
        String yn = System.console().readLine(task + " 을(를) 실행할까요? (확인:엔터, 취소: N) ");
        return yn.length() != 0 && yn.toUpperCase().equals("N") ? false : true;
    }
}
