package day04;

public class B20PeopleArrTest {

    public static void main(String[] args) {
        People[] members = new People[4];
        members[0] = new People("모모", 18, false);
        members[1] = new People("나연", 27, true);
        members[2] = new People("다현", 28, true);
        members[3] = new People("지효", 24, true);

        // 1. members 배열이 참조하는 People 객체 중 이름을 모두 출력하기
        // 예시 : members[0].getName()
        System.out.println("~~~~ 멤버 이름 출력하기 1 ~~~~");
        for (int i = 0; i < members.length; i++) {
            System.out.println("\t" + members[i].getName());
        }

        // 2번 인덱스의 객체를 변경하기 : "사나", 19, false
        members[2] = new People("사나", 19, false);
        // ㄴ 성인이 아닌 멤버 출력(toString() 리턴값 받아서)하기
        System.out.println("~~~~ 청소년 멤버 출력하기 ~~~~");
        for (int i = 0; i < members.length; i++) {
            if (!members[i].isAdult())
                System.out.println(members[i]);

        }

        System.out.println("~~~~ 멤버 이름 출력하기 2 ~~~~");
        int total = 0;
        for (People p : members) { // p = members[i]와 동일함. i는 순서대로 자동 증가
            System.out.println("\t" + p.getName());
            // 멤버들 평균 나이를 구하기 위해 나이의 합곌를 연산하기
            total += p.getAge();
        }
        System.out.println("평균 나이 : " + (double) total / members.length);

    }

}
