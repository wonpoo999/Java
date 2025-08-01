package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductManagerAppAnswer {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        // 문제 1 ("ㅁㅁㅁㅁ 상품 관리 프로그램입니다. ㅁㅁㅁㅁ"); V
        System.out.println(" ~~~~ 상품 관리 프로그램입니다. ~~~~");
        initProductList(list); // ✅ 여기에 넣기

        boolean status = true;
        while (status) {
            System.out.println("\n작업 메뉴를 선택하세요.");
            System.out.println("[A] 상품 추가   [R] 상품 삭제   [U] 가격 변경   \n" +
                    "[L] 전체 상품 목록   [S] 상품 조회   [E] 종료   ");
            String menu = System.console().readLine("선택 >>>");

            try {
                switch (menu.toUpperCase()) {
                    case "A":
                        addProduct(list);
                        break;

                    case "R":
                        // 문제 2, 에러나고 있는 이거 수정 V
                        String index = System.console().readLine("\t삭제할 인덱스 입력 >>>>");
                        int idx = Integer.parseInt(index);
                        if (confirm("삭제")) {
                            Product p = list.remove(idx);
                            System.out.println("\t삭제 데이터 : " + p);
                        } else {
                            System.out.println("\t삭제를 취소했습니다.");
                        }
                        break;

                    case "U":
                        System.out.println("\t수정할 인덱스 입력 >>>>");
                        // 문제4 수정
                        int uidx = Integer.parseInt(System.console().readLine());
                        double newPrice = Double.parseDouble(System.console().readLine("\t판매 가격 입력>>>"));
                        if (confirm("포인트 변경")) { // 문제 5
                            // 문제6 수정
                            list.get(uidx).setPrice(newPrice);
                            System.out.println("\t 업데이트 결과 : " + list.get(uidx));
                        } else {
                            System.out.println("\t포인트 변경을 취소했습니다.");
                        }
                        break;

                    case "L":
                        System.out.println("\t\t상품 리스트");
                        for (int i = 0; i < list.size(); i++) // 문제 7 중간에 매꿀 게 있는 거 같다 ..
                            System.out.println("\t" + i + ": " + list.get(i));
                        break;

                    case "S":
                        String keyword = System.console().readLine("\t찾는 상품 제목 단어 입력 >>>"); // 문제 8
                        for (int i = 0; i < list.size(); i++) {
                            // 문제9
                            Product p = list.get(i);
                            if (p.getTitle().contains(keyword)) {
                                System.out.println("\t" + i + ": " + p);
                            }
                        }
                        break;

                    case "E":
                        // 문제 10 V
                        System.out.println("\t앱을 종료하시겠습니까?");
                        if (confirm("종료")) {
                            status = false;
                        } else {
                            System.out.println("앱 종료를 취소했습니다");
                        }
                        break;

                    default:
                        System.out.println("잘못된 메뉴 선택입니다.");
                        break;
                } // switch end
            } catch (NumberFormatException e) { // 문제 11 수정
                System.out.println("숫자만 입력하세요.");
            }
        }
        System.out.println("숫자만 입력하세요.");
    } // while end
      // main end

    // -------------------------------------------------------------------

    private static void initProductList(List<Product> list) {

        Product p1 = new Product(1212, "LG그램", 345600.0);
        Product p2 = new Product(2499, "LG스탠바이", 190100.0);
        Product p3 = new Product(1213, "삼성OLED", 554500.0);
        Product p4 = new Product(4546, "바디프랜드", 632000.0);
        // 문제 12
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
    }

    // -------------------------------------------------------------------

    private static void addProduct(List<Product> list) {
        // 문제 13
        int pid = new Random().nextInt(8889) + 1111;
        String title = System.console().readLine("\t상품 제목 입력 >>>");
        double price = Double.parseDouble(System.console().readLine("\t상품 가격 입력>>>"));
        if (confirm("상품 등록")) {
            Product p = new Product(pid, title, price);
            // 문제 14
            list.add(p);
            System.out.println("\t등록 확인 : " + pid);
        } else {
            System.out.println("\t 등록 취소 했습니다.");
        }
    }

    // -------------------------------------------------------------------

    private static boolean confirm(String task) {
        String yn = System.console().readLine(task + " 을(를) 실행할까요? (확인:엔터, 취소: N) ");
        return yn.length() != 0 && yn.toUpperCase().equals("N") ? false : true;
    }
}
