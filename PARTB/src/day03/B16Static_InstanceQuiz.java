Java Quiz 1 (문제 9개)
문제 1 (데이터 타입)
문제: 자바 기본 타입(primitive type)이 아닌 것은?

int

String

boolean

double

정답: String

풀이:
기본 타입은 값 자체를 저장합니다. int, boolean, double 모두 기본 타입입니다.
String은 객체(참조 타입)로, 실제 문자열 데이터는 힙 영역에 저장되고, 변수는 객체의 참조(주소)를 가집니다.

참고 수업:

day02 - B02StringTest.java (문자열 타입과 기본 타입 차이 설명, 10~30줄)

문제 2 (불변 객체)
java
복사
편집
String str1 = "Hello";
String str2 = "Hello";
String str3 = new String("Hello");

System.out.println(str1 == str2);
System.out.println(str1 == str3);
출력:
true
false

풀이:

str1과 str2는 같은 리터럴 "Hello"를 가리켜서 참조 주소가 같습니다.

str3는 new 연산자로 새 객체 생성, 다른 참조 주소입니다.

==는 참조 주소 비교이므로 str1==str2는 true, str1==str3는 false.

참고 수업:

day02 - B03StringForTest.java (문자열 리터럴과 new String 비교, 20~50줄)

문제 3 (참조값)
java
복사
편집
class Person {
    String name;
    int age;
}

Person p1 = new Person();
Person p2 = new Person();
Person p3 = p1;

System.out.println(p1 == p2);
System.out.println(p1 == p3);
출력:
false
true

풀이:

p1과 p2는 각각 다른 객체, 다른 참조 주소 → false

p3는 p1과 같은 객체 참조 → true

참고 수업:

day02 - B04OverrideTest.java (객체 참조 비교, 10~40줄)

문제 4 (toString 재정의)
java
복사
편집
class Student {
    String name;
    int age;

    // toString() 재정의 작성
    @Override
    public String toString() {
        return "이름: " + name + ", 나이: " + age;
    }
}
풀이:

Object 클래스의 toString()을 재정의해서 사람이 읽기 쉬운 문자열 출력 가능.

참고 수업:

day02 - B04OverrideTest.java (toString 재정의 예제, 45~70줄)

문제 5 (static 메소드 특징)
객체 생성해야 호출한다? X

클래스 이름으로 직접 호출 가능? O

모든 변수 자유롭게 접근 가능? X

오버라이딩 가능? X

정답: 클래스 이름으로 직접 호출할 수 있다

풀이:
static 메소드는 클래스 소속이라 객체 없이 호출 가능하지만



나의 말:
야 고철아 문제 2 불변 객체라 쓰고 코드만 쓰면 어떤 문젠지 어떻게 아냐

ChatGPT의 말:
알겠습니다. 이번엔 문제 제목, 문제 설명, 코드, 출력 예상, 풀이, 왜 그런지, 참고 수업명+줄 번호까지 완전 꼼꼼하게 한 문제씩, 왕초보가 이해할 수 있도록 아주 자세히 제대로 할게요.

Java Quiz 1 (9문제) — 세세하고 친절한 풀이와 참고수업 명확 표시
문제 1: 자바 기본 타입(primitive type)이 아닌 것은?
설명: 자바에는 여러 기본 타입이 있는데, 여기서 기본 타입이 아닌 걸 고르세요.

보기:

int

String

boolean

double

정답: String

왜?

int, boolean, double은 자바가 기본으로 제공하는 'primitive type' 입니다.

String은 객체(참조 타입)입니다. 즉, 메모리에 주소값을 저장하는 변수이고 실제 문자열 데이터는 객체 내부에 저장돼요.

기본 타입은 변수에 직접 값을 저장하지만, String은 참조값(주소)을 저장합니다.

참고 수업:

day02/B02StringTest.java

참고 코드: 10~30줄 (String과 기본 타입 차이 설명)

문제 2: 문자열 불변 객체와 == 연산자 비교
문제 설명:
아래 코드를 보고 출력 결과를 맞히고 왜 그런지 설명하세요.

java
복사
편집
String str1 = "Hello";
String str2 = "Hello";
String str3 = new String("Hello");

System.out.println(str1 == str2);
System.out.println(str1 == str3);
예상 출력:
true
false

풀이:

str1과 str2는 같은 문자열 리터럴 "Hello"를 가리킵니다. 자바는 리터럴 문자열을 상수 풀(constant pool)에 저장해서 같은 문자열 리터럴은 메모리에서 하나만 관리합니다. 그래서 두 변수는 같은 주소를 참조해요.

str3는 new String("Hello")로 새롭게 힙(heap) 메모리에 문자열 객체를 만듭니다. 그래서 주소가 다릅니다.

== 연산자는 주소(참조값)를 비교하기 때문에, str1 == str2는 true, str1 == str3는 false입니다.

참고 수업:

day02/B03StringForTest.java

코드 참고: 20~50줄 (문자열 리터럴과 new String 차이 설명)

문제 3: 객체 참조값 비교
문제 설명: 다음 Person 객체의 참조값 비교 결과와 이유를 쓰세요.

java
복사
편집
class Person {
    String name;
    int age;
}

Person p1 = new Person();
Person p2 = new Person();
Person p3 = p1;

System.out.println(p1 == p2);
System.out.println(p1 == p3);
예상 출력:
false
true

풀이:

p1과 p2는 각각 새롭게 만든 서로 다른 Person 객체입니다. 그래서 참조 주소가 달라 == 비교 시 false입니다.

p3는 p1과 같은 객체를 가리키는 참조 변수입니다. 주소가 같으므로 ==는 true입니다.

참고 수업:

day02/B04OverrideTest.java

줄 10~40 (객체 참조 비교 및 기본 개념 설명)

문제 4: toString() 메소드 재정의
문제 설명:
Student 클래스에서 toString() 메소드를 재정의하여 객체 정보를 "이름: 홍길동, 나이: 20" 형식으로 출력하세요.

java
복사
편집
class Student {
    String name;
    int age;

    // toString() 메소드 재정의 위치
}
정답 코드:

java
복사
편집
@Override
public String toString() {
    return "이름: " + name + ", 나이: " + age;
}
풀이:

모든 자바 클래스는 Object 클래스의 toString() 메소드를 상속받습니다.

기본 toString()은 클래스명@해시코드 형태라 사람이 읽기 어렵습니다.

원하는 형태로 출력하려면 toString()을 재정의해야 합니다.

@Override는 이 메소드가 상위 클래스 메소드를 덮어쓴다는 의미입니다.

참고 수업:

day02/B04OverrideTest.java

45~70줄 (toString() 재정의 예시)

문제 5: static 메소드 특징
문제 설명: 다음 중 static 메소드 특징으로 올바른 것은?

객체를 생성해야만 호출할 수 있다

클래스 이름으로 직접 호출할 수 있다

모든 변수에 자유롭게 접근할 수 있다

오버라이딩이 가능하다

정답: 2) 클래스 이름으로 직접 호출할 수 있다

풀이:

static 메소드는 객체 생성 없이 클래스 이름으로 바로 호출할 수 있습니다.

인스턴스 변수에 직접 접근할 수 없으며, 오버라이딩도 안 됩니다.

참고 수업:

day03/B16Static_InstanceQuiz.java

5~25줄 (static 메소드 기본 개념)

문제 6: 2의 n승 계산 for 반복문
문제 설명:
2를 n번 곱해 2의 n승을 계산하는 메소드를 작성하세요. n=0일 때 결과는 1이어야 합니다.

java
복사
편집
class MyCalculator {
    static int powerOfTwo(int count) {
        // for문 사용, n=0일 때 1 반환
    }
}
정답 코드 예시:

java
복사
편집
static int powerOfTwo(int count) {
    int result = 1;
    for (int i = 0; i < count; i++) {
        result *= 2;
    }
    return result;
}
풀이:

2의 0승은 1로 정의합니다.

for문을 사용해 count 횟수만큼 2를 곱합니다.

반복문을 돌며 누적 곱셈을 수행하면 됩니다.

참고 수업:

day02/B07AMyCalculatorTest.java

15~40줄 (반복문과 메소드 사용법)

문제 7: byte 타입 오버플로우
문제 설명: 아래 코드 출력 결과와 이유를 설명하세요.

java
복사
편집
byte b = 127;
b++;
System.out.println(b);
출력:
-128

풀이:

byte 타입은 -128부터 127까지 표현 가능합니다.

127에서 1을 더하면 범위를 초과해 값이 다시 -128로 돌아갑니다 (오버플로우).

이는 1바이트 메모리의 순환 특성 때문입니다.

참고 수업:

day02/B08OverflowTest.java

10~35줄 (기본 타입 범위 및 오버플로우 설명)

문제 8: 변수 Scope 문제
문제 설명: 아래 코드에서 왜 컴파일 에러가 발생하는지 설명하세요.

java
복사
편집
public class ScopeTest {
    public static void main(String[] args) {
        if (true) {
            int x = 10;
        }
        System.out.println(x); // 컴파일 에러
    }
}
풀이:

변수 x는 if 블록 내부에서 선언되어 블록 밖에서는 인식되지 않습니다.

변수의 유효 범위(scope)는 선언된 블록 내부에만 한정됩니다.

따라서 System.out.println(x);에서 x를 찾을 수 없어 컴파일 에러 발생.

참고 수업:

day02/B09VariableScope.java

5~30줄 (변수 유효 범위 개념)

문제 9: switch문 학점 출력
문제 설명: 정수 점수 grade를 10으로 나눈 몫을 사용하여 학점을 출력하는 switch 문을 작성하세요.

java
복사
편집
int grade = 85;

// switch 문 작성
정답 코드:

java
복사
편집
switch (grade / 10) {
    case 10:
    case 9:
        System.out.println("A");
        break;
    case 8:
        System.out.println("B");
        break;
    case 7:
        System.out.println("C");
        break;
    case 6:
        System.out.println("D");
        break;
    default:
        System.out.println("F");
        break;
}
풀이:

grade를 10으로 나누면 90 이상은 9 또는 10, 80대는 8 등이 됩니다.

각 case마다 학점을 출력하면 됩니다.

90 이상 두 case를 묶어서 처리하는 게 깔끔합니다.

참고 수업:

day02/B10SwitchCaseTest.java

10~40줄 (switch 기본 문법과 사례)