package test;

public class MyTest01 {

    public static void main(String[] args) {
        String name = "김두한";

        System.out.println(name);
        System.out.println(name.toString());

        int grade = 100;

        switch (grade / 10) { // grade를 10으로 나눈 몫을 기준으로 스위치
            case 10: // 100점대 (grade가 100이면 몫이 10)
                System.out.println("학점: S");
                break;
            case 9: // 90점대 (grade가 90~99이면 몫이 9)
                System.out.println("학점: A");
                break;
            case 8: // 80점대 (grade가 80~89이면 몫이 8)
                System.out.println("학점: B");
                break;
            case 7: // 70점대
                System.out.println("학점: C");
                break;
            case 6: // 60점대
                System.out.println("학점: D");
                break;
            default: // 60점 미만 (나머지, 0~59점대)
                System.out.println("학점: F");
                break;
        }
        byte b = 127;
        b++;
        System.out.println(b);

        class Person {
            String name;
            int age;
        }

        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = p1;

        System.out.println(p1 == p2);
        System.out.println(p1 == p3);

        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
    }

}
