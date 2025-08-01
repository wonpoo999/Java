package src.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductManagerApp {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        // ✅ 4개의 메서드 목롱 중 딱 처음에만 호출되는 초기 전용, 리스트에 상품을 미리 채우는 역할. init, add, remove, modify 중 가장 처음
        // 등장 프로그램 실행 직후 목록이 아예 없으면 확인이 안 되기 때문.
        initProductList(list);
        System.out.println("ㅁㅁㅁㅁ 상품 관리 프로그램입니다. ㅁㅁㅁㅁ");
        boolean status = true;
        while (status) {
            System.out.println("\n작업 메뉴를 선택하세요.");
            System.out.println("[A] 상품 추가    [R] 상품 삭제    [U] 가격 변경  \n"
                    + "[L] 전체 상품 목록    [S] 상품 조회    [E] 종료  ");
            String menu = System.console().readLine("선택 >>>> ");
            try {
                switch (menu.toUpperCase()) {
                    case "A":
                        addProduct(list);
                        break;
                    case "R":
                        int index =
                                Integer.parseInt(System.console().readLine("\t삭제할 인덱스 입력 >>>>"));
                        removeProduct(list, index);
                        break;
                    case "U":
                        index = Integer.parseInt(System.console().readLine("\t수정할 인덱스 입력 >>>>"));
                        modifyProduct(list, index);
                        // ✅ 1줄 / 사용자가 가격을 바꾸고 싶은 상품을 몇 번째인지 직접 고르게 하기 위해 존재. modifyProduct(list,
                        // index)는 인덱스를 기반으로 동작. 그러면 그 index는 사용자에게 받아야 함. 숫자 입력 받아 인덱스로 씀. 첫줄 입력 받은
                        // 문자열을 정수로 변환해 index에 저장하고 둘째줄에서 해당 인덱스를 바탕으로 상품 수정 기능 실행
                        break;
                    case "L":
                        System.out.println("\t\t상품리스트");
                        // ✅ 전체 상품을 순회해서 어떤 조건을 만족하는 상품을 찾거나 출력하기 위해 사용. 상품이 저장된 list에서 전부 확인하려면 반복문
                        // 필요.
                        for (int i = 0; i < list.size(); i++)
                            System.out.println("\t" + i + ": " + list.get(i));
                        break;
                    case "S":
                        String find = System.console().readLine("\t찾는 상품 제목 단어 입력 >>> "); // 수정 ✅
                                                                                          // 사용자가
                                                                                          // 상품을 찾고
                                                                                          // 싶을 때
                                                                                          // 검색어를
                                                                                          // 입력해야 함.
                                                                                          // 그 입력을
                                                                                          // 저장하기 위한
                                                                                          // 변수.
                        for (int i = 0; i < list.size(); i++) {
                            Product p = list.get(i); // 수정✅ 리스트를 순회할 때 i 번째 상품을 꺼내서 p라는 변수로 사용하려고 함.
                            if (p.getTitle().contains(find)) {
                                System.out.println("\t" + i + ": " + p);
                            }
                        }
                        break;
                    case "E":
                        status = false;
                        break;

                    default:
                        System.out.println("잘못된 메뉴 선택입니다.");
                        break;
                } // switch end
                  // ✅ 사용자가 입력값을 int, double로 변환할 때 문자가 들어오면 오류 발생. 그걸 막기 위해 try-catch로 감싸는 구조. try로
                  // 감싼 블록에서 숫자 변환 중 오류 나면 여기에 걸려서 사용자에게 안매 메세지 출력. 프로그램이 멈추지 않고 다시 while로 돌아감
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력하세요.");
            }
        } // while end
    } // main end

    private static void initProductList(List<Product> list) {
        Product p1 = new Product(1212, "LG그램", 345600.0);
        Product p2 = new Product(2499, "LG스탠바이", 190100.0);
        Product p3 = new Product(1213, "삼성OLED", 554500.0);
        Product p4 = new Product(4546, "바디프랜드", 632000.0);
        Product p5 = new Product(7890, "삼성 갤럭시북", 452000.0);
        // ✅ 밑에 문장이 필요한 이유는 앱을 실행했을 때 미리 상품들이 등록되어 있게 하기 위해 사용. 이게 없으면 목록 보기 시 아무것도 안 나옴. 위에 P1~P5
        // 미리 만든 걸 봤으면 목록에 다 넣ㄹ어야 하고 addAll()이 유력. List.of로 묶어서 한번에 넣어야 함
        list.addAll(List.of(p1, p2, p3, p4, p5));
    }

    private static void addProduct(List<Product> list) {
        // ✅ 상품을 추가하는 메서드. 성품 번호, 이름 가격이 필요. 랜덤 생성을 위해 Random, 정수 번호 출력을 위해 int는 정수 / Random id 생성 /
        // readline - 이름 및 가격 입력 / new Product - 객체 생성 / list.add = 리스트에 추가 / addProduct의 목적 알아둬야함
        int id = new Random().nextInt(9999 - 111) + 1111;
        String title = System.console().readLine("\t상품 제목 입력 >>> ");
        double price = Double.parseDouble(System.console().readLine("\t상품 가격 입력 >>> "));
        if (confirm("상품 등록")) {
            Product p = new Product(id, title, price);
            // ✅ 사용자가 입력한 정보를 바탕으로 실제 Product 객체 하나를 생성하기 위한 코드. 그래서 new Product(id, title, price);를
            // Product p에 대입.
            list.add(p); // 그래서 위에 Product 객체를 실제 상품 목록에 추가. 변수 이름이 list이고 List<Product> 타입이니
                         // list.add(...)는 뭔가를 목록에 집어넣는 함수로 예상가능. 앞줄에서 Product p를 만들었으니 넣는 대상은 p
            System.out.println("\t등록 확인 : " + p);
        } else {
            System.out.println("\t등록 취소했습니다.");
        }
    }

    private static void removeProduct(List<Product> list, int index) {
        if (confirm("삭제")) {
            // ✅ 삭제할 Product의 위치가 index로 전달
            Product p = list.remove(index);
            System.out.println("\t삭제 데이터 : " + p);
        } else {
            System.out.println("\t삭제를 취소했습니다.");
        }
    }

    private static void modifyProduct(List<Product> list, int index) {
        double pr = Double.parseDouble(System.console().readLine("\t판매 가격 입력 >>>> ")); // 수정 ✅
        if (confirm("가격 변경")) {
            Product p = list.get(index); // 수정 ✅ get으로 객체를 꺼내고 setPrice로 가격 변경
            p.setPrice(pr);
            System.out.println("\t업데이트 결과 : " + p);
        } else {
            System.out.println("\t가격 변경을 취소했습니다.");
        }
    }

    private static boolean confirm(String task) {
        String yn = System.console().readLine(task + "을(를) 실행할까요?(확인:엔터, 취소:N)  ");
        return yn.length() != 0 && yn.toUpperCase().equals("N") ? false : true;
    }
}
