알겠습니다. 요청하신 대로 20개의 Java 코딩 테스트 문제를 정답 코드를 제외하고 문제 형식으로 다시 정리해 드리겠습니다.

-----

### 문제 1: 학생 성적 평균 계산기

**설명:**
여러 학생의 과목별 성적을 `Map`에 저장하고, 각 학생의 평균 점수를 계산하여 출력하는 프로그램을 작성하세요. `List`를 사용하여 여러 학생의 정보를 관리합니다.

**요구사항 명세서:**

1.  학생의 정보는 `Map<String, Object>` 형태로 관리하며, 이름(`name`)과 성적(`scores`)을 키로 가집니다.
2.  성적(`scores`)은 다시 `Map<String, Integer>` 형태로, 과목명을 키로, 점수를 값으로 가집니다.
3.  `calculateAverage` 메서드는 학생의 성적 `Map`을 인자로 받아, 모든 과목의 평균 점수를 계산하여 반환합니다.
4.  `main` 메서드에서는 여러 학생의 정보를 `List`에 담고, 반복문을 사용하여 각 학생의 이름과 평균 점수를 "실행 예"와 같이 출력해야 합니다.

**제공된 코드:**

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradeCalculator {

    public static double calculateAverage(Map<String, Integer> scores) {
        double sum = 0;
        // TODO: scores 맵의 모든 점수를 합산하여 합계를 구하는 코드를 작성하시오.

        // TODO: 합산된 점수를 과목 수로 나누어 평균을 계산하고 반환하는 코드를 작성하시오.
        // 단, 과목이 없을 경우 0점을 반환해야 합니다.
        return 0.0;
    }

    public static void main(String[] args) {
        List<Map<String, Object>> students = new ArrayList<>();

        Map<String, Object> student1 = new HashMap<>();
        student1.put("name", "홍길동");
        Map<String, Integer> scores1 = new HashMap<>();
        scores1.put("국어", 85);
        scores1.put("영어", 90);
        scores1.put("수학", 95);
        student1.put("scores", scores1);
        students.add(student1);

        Map<String, Object> student2 = new HashMap<>();
        student2.put("name", "김철수");
        Map<String, Integer> scores2 = new HashMap<>();
        scores2.put("국어", 75);
        scores2.put("영어", 80);
        scores2.put("과학", 88);
        student2.put("scores", scores2);
        students.add(student2);

        // TODO: students 리스트를 순회하며 각 학생의 이름과 평균 점수를 출력하시오.
        // calculateAverage 메서드를 반드시 사용해야 합니다.
    }
}
```

**실행 예:**

```
학생: 홍길동, 평균 점수: 90.0
학생: 김철수, 평균 점수: 81.0
```

-----

### 문제 2: 간단한 음료 자판기 시뮬레이터

**설명:**
간단한 음료 자판기 프로그램을 `switch` 문을 사용하여 구현합니다. 사용자가 번호를 선택하면 해당 음료의 이름과 가격을 출력하고, 잘못된 번호를 입력하면 오류 메시지를 출력합니다.

**요구사항 명세서:**

1.  `VendingMachine` 클래스에 `selectDrink` 메서드를 구현합니다. 이 메서드는 `int` 타입의 `choice`를 인자로 받습니다.
2.  `selectDrink` 메서드 내에서 `switch` 문을 사용하여 `choice` 값에 따라 다른 음료 정보를 출력합니다.
      * 1번: "콜라 - 1,000원"
      * 2번: "사이다 - 1,200원"
      * 3번: "물 - 800원"
3.  `case`에 해당하지 않는 번호가 입력되면 `default` 문을 사용하여 "잘못된 번호입니다."를 출력합니다.
4.  `main` 메서드에서 `Scanner`를 사용하여 사용자로부터 음료 번호를 입력받고, `selectDrink` 메서드를 호출하여 결과를 출력합니다. 프로그램은 한 번의 선택 후 종료됩니다.

**제공된 코드:**

```java
import java.util.Scanner;

class VendingMachine {
    public void selectDrink(int choice) {
        // TODO: switch문을 사용하여 choice 값에 따라 음료 이름과 가격을 출력하시오.
        // 1: "콜라 - 1,000원", 2: "사이다 - 1,200원", 3: "물 - 800원"
        // 그 외의 번호는 "잘못된 번호입니다." 출력
    }
}

public class Simulator {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- 자판기 ---");
        System.out.println("1. 콜라 | 2. 사이다 | 3. 물");
        System.out.print("음료 번호를 선택하세요: ");

        int choice = scanner.nextInt();
        machine.selectDrink(choice);

        scanner.close();
    }
}
```

**실행 예 1 (올바른 입력):**

```
--- 자판기 ---
1. 콜라 | 2. 사이다 | 3. 물
음료 번호를 선택하세요: 2
사이다 - 1,200원
```

**실행 예 2 (잘못된 입력):**

```
--- 자판기 ---
1. 콜라 | 2. 사이다 | 3. 물
음료 번호를 선택하세요: 5
잘못된 번호입니다.
```

-----

### 문제 3: 배열에서 특정 점수 찾기

**설명:**
주어진 정수 배열에서 특정 점수 이상인 학생이 몇 명인지 계산하는 프로그램을 작성하세요. `for` 문과 `if` 문을 사용하여 배열을 순회하고 조건을 확인해야 합니다.

**요구사항 명세서:**

1.  `countPassingStudents` 메서드는 점수 배열 `scores`와 통과 기준 점수 `passingScore`를 인자로 받습니다.
2.  메서드는 `scores` 배열을 순회하며 `passingScore` 이상인 점수의 개수를 셉니다.
3.  계산된 학생 수를 반환합니다.
4.  `main` 메서드에서 `scores` 배열과 `passingScore`를 정의하고, `countPassingStudents` 메서드를 호출하여 결과를 "실행 예"와 같이 출력하세요.

**제공된 코드:**

```java
public class ScoreAnalyzer {

    public int countPassingStudents(int[] scores, int passingScore) {
        int passingStudentsCount = 0;
        // TODO: for문을 사용하여 scores 배열을 순회하고,
        // if문을 사용하여 passingScore 이상인 학생 수를 세는 코드를 작성하시오.

        return passingStudentsCount;
    }

    public static void main(String[] args) {
        ScoreAnalyzer analyzer = new ScoreAnalyzer();
        int[] scores = {88, 95, 72, 68, 77, 91, 60};
        int passingScore = 75;

        // TODO: countPassingStudents 메서드를 호출하고 결과를 출력하시오.
    }
}
```

**실행 예:**

```
75점 이상으로 통과한 학생은 4명입니다.
```

-----

### 문제 4: 설정 관리자 (Singleton 패턴)

**설명:**
애플리케이션 전체에서 단 하나의 인스턴스만 존재해야 하는 설정 관리자 클래스를 **싱글톤(Singleton) 패턴**을 사용하여 구현합니다.

**요구사항 명세서:**

1.  `SettingsManager` 클래스는 `private static`인 자기 자신 타입의 `instance` 필드를 가집니다.
2.  생성자는 `private`으로 선언하여 외부에서 직접 객체를 생성할 수 없도록 합니다.
3.  `getInstance()` `public static` 메서드를 제공하여, `instance`가 `null`일 경우에만 새로운 객체를 생성하고, 항상 동일한 인스턴스를 반환하도록 합니다.
4.  `main` 메서드에서 `getInstance()`를 두 번 호출하여 얻은 두 객체가 동일한 객체인지 `==` 연산자로 확인하여 "실행 예"와 같이 출력하세요.

**제공된 코드:**

```java
class SettingsManager {
    // TODO: private static 필드로 instance를 선언하시오.

    // TODO: 생성자를 private으로 선언하시오.

    // TODO: public static getInstance() 메서드를 구현하시오.
    // instance가 null일 때만 객체를 생성하고, 항상 같은 instance를 반환해야 합니다.

}

public class Application {
    public static void main(String[] args) {
        // TODO: SettingsManager의 인스턴스를 두 번 가져와서 두 변수에 할당하시오.

        // TODO: 두 인스턴스가 같은지(==) 비교하여 결과를 출력하시오.
        // 예: "두 인스턴스는 동일합니다." 또는 "두 인스턴스는 다릅니다."
    }
}
```

**실행 예:**

```
두 인스턴스는 동일합니다.
```

-----

### 문제 5: 상품 재고 관리 (사용자 정의 예외)

**설명:**
상품 재고를 관리하는 프로그램에서 재고가 부족할 때 사용자 정의 예외 `OutOfStockException`을 발생시키고 처리하는 코드를 작성하세요.

**요구사항 명세서:**

1.  `Exception` 클래스를 상속받는 `OutOfStockException` 사용자 정의 예외 클래스를 만듭니다.
2.  `Product` 클래스에 `decreaseStock` 메서드를 구현합니다. 이 메서드는 요청 수량(`quantity`)이 현재 재고(`stock`)보다 많으면 `OutOfStockException`을 발생시킵니다.
3.  재고가 충분하면 `stock`에서 `quantity`만큼 차감합니다.
4.  `main` 메서드에서 `try-catch` 블록을 사용하여 `decreaseStock` 메서드를 호출하고, `OutOfStockException`이 발생했을 때 적절한 메시지를 "실행 예"와 같이 출력하세요.

**제공된 코드:**

```java
// TODO: Exception을 상속받는 OutOfStockException 클래스를 작성하시오.

class Product {
    private String name;
    private int stock;

    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public void decreaseStock(int quantity) throws OutOfStockException {
        // TODO: quantity가 stock보다 크면 OutOfStockException을 발생시키는 코드를 작성하시오.
        // 그렇지 않으면 stock을 quantity만큼 감소시킵니다.
    }

    public int getStock() {
        return stock;
    }
}

public class InventoryManager {
    public static void main(String[] args) {
        Product laptop = new Product("노트북", 10);
        int orderQuantity = 15;

        // TODO: try-catch 블록을 사용하여 laptop.decreaseStock()을 호출하고,
        // OutOfStockException을 처리하여 실행 예와 같이 출력하시오.
    }
}
```

**실행 예:**

```
재고 부족: 15개 주문 불가. 현재 재고: 10개.
```

-----

### 문제 6: 회원 정보 관리 (Getter/Setter와 유효성 검사)

**설명:**
회원 정보를 관리하는 `Member` 클래스를 작성합니다. 필드는 `private`으로 보호하고, `public` 메서드(Setter)를 통해 필드 값을 설정할 때 유효성 검사를 수행하도록 합니다.

**요구사항 명세서:**

1.  `Member` 클래스는 `private` 필드로 `name` (이름)과 `age` (나이)를 가집니다.
2.  `setName` 메서드는 이름이 `null`이거나 2글자 미만일 경우 "유효하지 않은 이름입니다."를 출력하고 값을 변경하지 않습니다.
3.  `setAge` 메서드는 나이가 0세 미만이거나 120세 초과일 경우 "유효하지 않은 나이입니다."를 출력하고 값을 변경하지 않습니다.
4.  `main` 메서드에서 `Member` 객체를 생성하고, 유효한 값과 유효하지 않은 값으로 각각 `setName`과 `setAge`를 호출하여 "실행 예"와 같이 결과가 출력되도록 하세요.

**제공된 코드:**

```java
class Member {
    private String name;
    private int age;

    // TODO: name에 대한 Getter와 Setter를 작성하시오.
    // Setter에는 이름이 null이 아니고 2글자 이상인지 검증하는 로직을 추가하시오.

    // TODO: age에 대한 Getter와 Setter를 작성하시오.
    // Setter에는 나이가 0에서 120 사이인지 검증하는 로직을 추가하시오.

    public void printInfo() {
        System.out.println("이름: " + name + ", 나이: " + age);
    }
}

public class MemberManagement {
    public static void main(String[] args) {
        Member member = new Member();

        // TODO: 유효한 이름("이순신")과 유효하지 않은 나이(150)를 설정하고 정보를 출력하시오.
        // TODO: 유효하지 않은 이름("김")과 유효한 나이(30)를 설정하고 정보를 출력하시오.
        // TODO: 유효한 이름("강감찬")과 유효한 나이(45)를 설정하고 정보를 출력하시오.
    }
}
```

**실행 예:**

```
유효하지 않은 나이입니다.
이름: 이순신, 나이: 0
유효하지 않은 이름입니다.
이름: 이순신, 나이: 30
이름: 강감찬, 나이: 45
```

-----

### 문제 7: 도형 넓이 계산기 (추상 클래스)

**설명:**
다양한 도형의 넓이를 계산하는 프로그램을 **추상 클래스**를 이용하여 구현합니다. 공통 기능을 부모 추상 클래스에 정의하고, 각 도형 클래스에서 이를 상속받아 구체적인 넓이 계산 로직을 구현합니다.

**요구사항 명세서:**

1.  `Shape` 추상 클래스를 만듭니다. 이 클래스는 `calculateArea()`라는 `abstract` 메서드를 가집니다.
2.  `Shape`를 상속받는 `Circle` 클래스와 `Rectangle` 클래스를 구현합니다.
3.  `Circle`은 반지름(`radius`) 필드를, `Rectangle`은 가로(`width`)와 세로(`height`) 필드를 가집니다.
4.  각 클래스에서 `calculateArea()` 메서드를 오버라이딩하여 원과 사각형의 넓이를 계산하는 로직을 구현합니다. (원주율은 3.14로 계산)
5.  `main` 메서드에서 `Circle`과 `Rectangle` 객체를 생성하고, 각 도형의 넓이를 "실행 예"와 같이 출력하세요.

**제공된 코드:**

```java
// TODO: calculateArea() 추상 메서드를 가진 Shape 추상 클래스를 작성하시오.

// TODO: Shape을 상속받고, 반지름(radius)을 필드로 가지는 Circle 클래스를 작성하시오.
// calculateArea() 메서드를 오버라이딩하여 원의 넓이를 계산하시오. (원주율 = 3.14)

// TODO: Shape을 상속받고, 가로(width)와 세로(height)를 필드로 가지는 Rectangle 클래스를 작성하시오.
// calculateArea() 메서드를 오버라이딩하여 사각형의 넓이를 계산하시오.

public class AreaCalculator {
    public static void main(String[] args) {
        // TODO: 반지름이 10인 원(Circle) 객체를 생성하고 넓이를 출력하시오.
        // TODO: 가로가 5, 세로가 8인 사각형(Rectangle) 객체를 생성하고 넓이를 출력하시오.
    }
}
```

**실행 예:**

```
원의 넓이: 314.0
사각형의 넓이: 40.0
```

-----

### 문제 8: 알림 서비스 (인터페이스)

**설명:**
다양한 채널(이메일, SMS)로 알림을 보내는 서비스를 **인터페이스**를 사용하여 구현합니다. 각 알림 방식은 동일한 인터페이스를 구현하지만, 실제 동작은 다르게 작성됩니다.

**요구사항 명세서:**

1.  `send(String message)` 추상 메서드를 가진 `Notification` 인터페이스를 정의합니다.
2.  `Notification` 인터페이스를 구현하는 `EmailNotification`과 `SmsNotification` 클래스를 작성합니다.
3.  각 클래스의 `send` 메서드는 "실행 예"와 같이 채널에 맞는 알림 메시지를 출력합니다.
4.  `main` 메서드에서 두 클래스의 객체를 생성하고, `send` 메서드를 호출하여 각각 다른 메시지를 전송하는 코드를 작성하세요.

**제공된 코드:**

```java
// TODO: send(String message) 추상 메서드를 가진 Notification 인터페이스를 작성하시오.

// TODO: Notification 인터페이스를 구현하는 EmailNotification 클래스를 작성하시오.
// send 메서드는 "이메일 발송: [메시지]" 형식으로 출력합니다.

// TODO: Notification 인터페이스를 구현하는 SmsNotification 클래스를 작성하시오.
// send 메서드는 "SMS 발송: [메시지]" 형식으로 출력합니다.

public class Notifier {
    public static void main(String[] args) {
        // TODO: EmailNotification 객체를 생성하고 "주문이 완료되었습니다." 메시지를 보내시오.
        // TODO: SmsNotification 객체를 생성하고 "배송이 시작되었습니다." 메시지를 보내시오.
    }
}
```

**실행 예:**

```
이메일 발송: 주문이 완료되었습니다.
SMS 발송: 배송이 시작되었습니다.
```

-----

### 문제 9: 사용자 정보 생성 (Lombok 빌더 패턴)

**설명:**
Lombok의 `@Builder` 애너테이션을 사용하여 사용자(`User`) 객체를 생성하는 코드를 작성하세요. 빌더 패턴을 사용하면 생성자보다 유연하고 가독성 좋게 객체를 생성할 수 있습니다.

**요구사항 명세서:**

1.  `User` 클래스는 `username`, `email`, `age` 필드를 가집니다.
2.  `@Builder`와 `@ToString` Lombok 애너테이션을 클래스에 추가합니다.
3.  `main` 메서드에서 빌더 패턴을 사용하여 두 명의 `User` 객체를 생성합니다.
      * 첫 번째 사용자는 모든 필드(username, email, age)를 가집니다.
      * 두 번째 사용자는 `username`과 `email` 필드만 가집니다 (age는 기본값 0).
4.  생성된 두 객체를 콘솔에 출력하여 "실행 예"와 같이 결과가 나오도록 하세요.

**제공된 코드:**

```java
import lombok.Builder;
import lombok.ToString;

// TODO: Lombok의 @Builder와 @ToString 애너테이션을 추가하시오.
class User {
    private String username;
    private String email;
    private int age;
}

public class UserFactory {
    public static void main(String[] args) {
        // TODO: 빌더 패턴을 사용하여 username="user1", email="user1@example.com", age=25 인 User 객체를 생성하고 출력하시오.

        // TODO: 빌더 패턴을 사용하여 username="user2", email="user2@example.com" 인 User 객체를 생성하고 출력하시오.
    }
}
```

**실행 예:**

```
User(username=user1, email=user1@example.com, age=25)
User(username=user2, email=user2@example.com, age=0)
```

-----

### 문제 10: 다양한 타입의 데이터 상자 (제네릭 클래스)

**설명:**
어떤 타입의 데이터든 담을 수 있는 제네릭 `Box` 클래스를 작성하여, 문자열과 정수를 각각 담고 출력하는 프로그램을 만드세요.

**요구사항 명세서:**

1.  제네릭 타입 `T`를 사용하는 `Box<T>` 클래스를 정의합니다.
2.  `Box` 클래스는 `T` 타입의 `content` 필드를 가집니다.
3.  `content` 필드에 대한 생성자와 Getter 메서드를 작성합니다.
4.  `main` 메서드에서 `String`을 담는 `Box`와 `Integer`를 담는 `Box` 객체를 각각 생성하고, `getContent()` 메서드를 이용해 "실행 예"와 같이 내용물을 출력하세요.

**제공된 코드:**

```java
// TODO: 제네릭 타입 T를 사용하는 Box 클래스를 작성하시오.
// 필드: private T content
// 생성자: content를 인자로 받아 초기화
// 메서드: public T getContent()

public class GenericBoxExample {
    public static void main(String[] args) {
        // TODO: "Hello World" 문자열을 담는 Box<String> 객체를 생성하고 내용물을 출력하시오.

        // TODO: 숫자 123을 담는 Box<Integer> 객체를 생성하고 내용물을 출력하시오.
    }
}
```

**실행 예:**

```
문자열 상자 내용: Hello World
정수 상자 내용: 123
```

-----

### 문제 11: 장바구니 상품 관리 (`ArrayList`)

**설명:**
`ArrayList`를 사용하여 장바구니에 상품을 추가, 삭제, 조회하는 간단한 프로그램을 작성하세요.

**요구사항 명세서:**

1.  `main` 메서드에서 `String` 타입의 요소를 저장하는 `ArrayList`인 `cart`를 생성합니다.
2.  `cart`에 "사과", "우유", "빵"을 순서대로 추가합니다.
3.  "우유"를 `cart`에서 삭제합니다.
4.  `cart`의 첫 번째 상품을 조회하여 출력합니다.
5.  최종적으로 `cart`에 담긴 모든 상품 목록을 "실행 예"와 같이 출력하세요.

**제공된 코드:**

```java
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public static void main(String[] args) {
        List<String> cart = new ArrayList<>();

        // TODO: cart에 "사과", "우유", "빵"을 추가하시오.

        // TODO: cart에서 "우유"를 삭제하시오.

        // TODO: cart의 첫 번째 항목을 조회하여 "첫 번째 상품: [상품명]" 형식으로 출력하시오.

        // TODO: 최종 장바구니 목록을 "최종 목록: [리스트]" 형식으로 출력하시오.
    }
}
```

**실행 예:**

```
첫 번째 상품: 사과
최종 목록: [사과, 빵]
```

-----

### 문제 12: 회의 참석자 명단 관리 (`HashSet`)

**설명:**
`HashSet`을 사용하여 회의에 참석한 사람의 명단을 관리하는 프로그램을 작성하세요. `HashSet`은 중복된 이름을 자동으로 걸러줍니다.

**요구사항 명세서:**

1.  `String` 타입의 이름을 저장하는 `HashSet`인 `attendees`를 생성합니다.
2.  "김철수", "이영희", "박지성", "김철수" 순서로 `attendees`에 이름을 추가합니다. ("김철수"는 두 번 추가)
3.  "박지성"이 참석자 명단에 있는지 확인하고 결과를 `boolean` 값으로 출력합니다.
4.  최종 참석자 수를 `size()` 메서드를 이용해 "실행 예"와 같이 출력합니다.

**제공된 코드:**

```java
import java.util.HashSet;
import java.util.Set;

public class MeetingAttendees {
    public static void main(String[] args) {
        Set<String> attendees = new HashSet<>();

        // TODO: "김철수", "이영희", "박지성", "김철수"를 attendees에 추가하시오.

        // TODO: "박지성"이 명단에 있는지 확인하고, "박지성 참석 여부: [true/false]" 형식으로 출력하시오.

        // TODO: 최종 참석자 수를 "최종 참석자 수: [숫자]" 형식으로 출력하시오.

        System.out.println("전체 명단: " + attendees);
    }
}
```

**실행 예:**

```
박지성 참석 여부: true
최종 참석자 수: 3
전체 명단: [박지성, 김철수, 이영희]
```

-----

### 문제 13: 간단한 스레드 실행 (람다식)

**설명:**
람다(Lambda) 표현식을 사용하여 `Runnable` 인터페이스를 구현하고, 새로운 스레드에서 메시지를 출력하는 간단한 멀티스레드 프로그램을 작성하세요.

**요구사항 명세서:**

1.  `Runnable` 인터페이스의 익명 구현체를 람다식으로 작성합니다.
2.  람다식의 내용은 "새로운 스레드에서 실행 중..."이라는 메시지를 콘솔에 출력하는 것입니다.
3.  이 `Runnable` 객체를 사용하여 `Thread` 객체를 생성합니다.
4.  생성된 스레드를 `start()` 메서드로 시작하고, "메인 스레드 종료."가 먼저 출력될 수 있도록 합니다.

**제공된 코드:**

```java
public class LambdaThread {
    public static void main(String[] args) {
        // TODO: "새로운 스레드에서 실행 중..."을 출력하는 Runnable을 람다식으로 작성하시오.

        // TODO: 위에서 작성한 Runnable을 사용하여 Thread 객체를 생성하고 시작(start)하시오.

        System.out.println("메인 스레드 종료.");
    }
}
```

**실행 예 (순서는 바뀔 수 있음):**

```
메인 스레드 종료.
새로운 스레드에서 실행 중...
```

-----

### 문제 14: 계산기 (메서드 오버로딩)

**설명:**
다양한 숫자 타입(정수, 실수)의 덧셈을 수행할 수 있도록 **메서드 오버로딩**을 이용하여 `add` 메서드를 구현하세요.

**요구사항 명세서:**

1.  `Calculator` 클래스 안에 이름이 `add`인 메서드를 두 개 정의합니다.
2.  첫 번째 `add` 메서드는 두 개의 `int`를 인자로 받아 합을 반환합니다.
3.  두 번째 `add` 메서드는 두 개의 `double`을 인자로 받아 합을 반환합니다.
4.  `main` 메서드에서 두 `add` 메서드를 각각 호출하여 결과를 "실행 예"와 같이 출력하세요.

**제공된 코드:**

```java
class Calculator {
    // TODO: 두 개의 int를 더하는 add 메서드를 작성하시오.

    // TODO: 두 개의 double을 더하는 add 메서드를 작성하시오.
}

public class OverloadingCalculator {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // TODO: 5와 10을 더한 결과를 "정수 덧셈 결과: [결과]" 형식으로 출력하시오.

        // TODO: 3.5와 2.5를 더한 결과를 "실수 덧셈 결과: [결과]" 형식으로 출력하시오.
    }
}
```

**실행 예:**

```
정수 덧셈 결과: 15
실수 덧셈 결과: 6.0
```

-----

### 문제 15: 상품 개수 카운터 (`static`)

**설명:**
`static` 키워드를 사용하여 생성된 상품(`Product`) 객체의 총 개수를 추적하는 프로그램을 작성하세요.

**요구사항 명세서:**

1.  `Product` 클래스에 `private static int totalProducts` 필드를 선언하고 0으로 초기화합니다.
2.  `Product` 클래스의 생성자에서 `totalProducts` 값을 1씩 증가시킵니다.
3.  `public static int getTotalProducts()` 메서드를 만들어 `totalProducts` 값을 반환하도록 합니다.
4.  `main` 메서드에서 `Product` 객체를 여러 개 생성한 후, 클래스 이름을 통해 `getTotalProducts()`를 호출하여 총 생성된 상품 개수를 "실행 예"와 같이 출력하세요.

**제공된 코드:**

```java
class Product {
    private String name;
    // TODO: 생성된 상품 수를 추적하기 위한 private static int 필드를 선언하시오.

    public Product(String name) {
        this.name = name;
        // TODO: 객체가 생성될 때마다 static 필드의 값을 1 증가시키시오.
    }

    // TODO: static 필드의 값을 반환하는 public static 메서드를 작성하시오.
}

public class ProductCounter {
    public static void main(String[] args) {
        System.out.println("초기 상품 수: " + Product.getTotalProducts());

        new Product("사과");
        new Product("바나나");
        new Product("오렌지");

        // TODO: 총 상품 수를 static 메서드를 통해 출력하시오.
    }
}
```

**실행 예:**

```
초기 상품 수: 0
총 상품 수: 3
```

-----

### 문제 16: 사용자 정보 JSON 만들기 (Gson)

**설명:**
Google의 Gson 라이브러리를 사용하여 `JsonObject`를 만들고, 이를 사람이 읽기 좋은 형태의 JSON 문자열로 변환하는 프로그램을 작성하세요.

**요구사항 명세서:**

1.  `JsonObject` 객체를 생성합니다.
2.  `addProperty` 메서드를 사용하여 `username` (문자열, "guest"), `isMember` (불리언, `true`), `visitCount` (정수, 15) 세 가지 속성을 추가합니다.
3.  `GsonBuilder`를 사용하여 `setPrettyPrinting()` 옵션이 활성화된 `Gson` 객체를 생성합니다.
4.  생성된 `Gson` 객체의 `toJson` 메서드를 사용하여 `JsonObject`를 보기 좋게 포맷팅된 문자열로 변환하고, 이를 콘솔에 출력하세요.

**제공된 코드:**

```java
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class JsonCreator {
    public static void main(String[] args) {
        // TODO: JsonObject를 생성하시오.

        // TODO: username("guest"), isMember(true), visitCount(15) 속성을 추가하시오.

        // TODO: setPrettyPrinting()이 활성화된 Gson 객체를 생성하시오.

        // TODO: JsonObject를 보기 좋은 형태의 JSON 문자열로 변환하여 출력하시오.
    }
}
```

**실행 예:**

```json
{
  "username": "guest",
  "isMember": true,
  "visitCount": 15
}
```

-----

### 문제 17: 동물 소리 내기 (업캐스팅과 다운캐스팅)

**설명:**
동물(`Animal`) 클래스와 이를 상속받는 개(`Dog`), 고양이(`Cat`) 클래스를 통해 **다형성**을 구현합니다. 업캐스팅된 객체를 다루고, 필요한 경우 다운캐스팅하여 자식 클래스 고유의 메서드를 호출하는 프로그램을 작성하세요.

**요구사항 명세서:**

1.  `makeSound()` 메서드를 가진 `Animal` 클래스를 만듭니다.
2.  `Animal`을 상속하고 `makeSound()`를 오버라이딩하는 `Dog`와 `Cat` 클래스를 만듭니다.
3.  `Dog` 클래스에는 고유 메서드인 `fetch()`를 추가합니다.
4.  `Animal` 타입의 배열 `animals`에 `Dog`와 `Cat` 객체를 업캐스팅하여 저장합니다.
5.  반복문을 통해 배열의 모든 동물이 각자의 소리를 내도록 `makeSound()`를 호출합니다.
6.  `instanceof` 연산자로 `Dog` 객체를 확인한 후, **다운캐스팅**하여 `fetch()` 메서드를 호출합니다.

**제공된 코드:**

```java
class Animal {
    public void makeSound() {
        System.out.println("동물이 소리를 냅니다.");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() { /* TODO: "멍멍!" 출력 */ }
    public void fetch() { /* TODO: "공을 가져옵니다." 출력 */ }
}

class Cat extends Animal {
    @Override
    public void makeSound() { /* TODO: "야옹~" 출력 */ }
}

public class PolymorphismExample {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        // TODO: animals 배열의 0번 인덱스에 Dog 객체를, 1번 인덱스에 Cat 객체를 할당하시오.

        // TODO: 반복문을 사용하여 모든 동물의 makeSound() 메서드를 호출하시오.
        // 추가로, instanceof를 사용해 Dog일 경우 다운캐스팅하여 fetch() 메서드를 호출하시오.
    }
}
```

**실행 예:**

```
멍멍!
공을 가져옵니다.
야옹~
```

-----

### 문제 18: 과일 이름 출력 (향상된 for문)

**설명:**
문자열 배열에 담긴 과일 이름을 \*\*향상된 for문(enhanced for loop)\*\*을 사용하여 간결하게 출력하는 프로그램을 작성하세요.

**요구사항 명세서:**

1.  `String` 타입의 배열 `fruits`를 선언하고 "사과", "바나나", "딸기", "포도"로 초기화합니다.
2.  향상된 for문을 사용하여 `fruits` 배열의 각 요소를 순서대로 "맛있는 [과일이름]" 형식으로 출력합니다.

**제공된 코드:**

```java
public class FruitPrinter {
    public static void main(String[] args) {
        String[] fruits = {"사과", "바나나", "딸기", "포도"};

        // TODO: 향상된 for문을 사용하여 배열의 모든 과일 이름을 지정된 형식으로 출력하시오.

    }
}
```

**실행 예:**

```
맛있는 사과
맛있는 바나나
맛있는 딸기
맛있는 포도
```

-----

### 문제 19: 나눗셈 예외 처리 (`try-catch`)

**설명:**
두 정수를 나누는 과정에서 발생할 수 있는 `ArithmeticException` (0으로 나누기)을 `try-catch` 블록을 사용하여 처리하는 프로그램을 작성하세요.

**요구사항 명세서:**

1.  `divide` 메서드는 두 정수 `a`, `b`를 인자로 받아 나눗셈 결과를 출력합니다.
2.  `main` 메서드에서 `try-catch` 블록을 사용합니다.
3.  `try` 블록 안에서 10을 0으로 나누는 `divide` 메서드를 호출합니다.
4.  `catch` 블록에서 `ArithmeticException`을 잡아 "0으로 나눌 수 없습니다." 라는 메시지를 출력합니다.
5.  `finally` 블록을 사용하여 예외 발생 여부와 상관없이 "계산을 종료합니다." 메시지를 출력합니다.

**제공된 코드:**

```java
public class DivisionCalculator {
    public static void divide(int a, int b) {
        System.out.println("나눗셈 결과: " + (a / b));
    }

    public static void main(String[] args) {
        // TODO: try-catch-finally 블록을 사용하여 10을 0으로 나누는 코드를 작성하고 예외를 처리하시오.
        // divide(10, 0)을 호출해야 합니다.

    }
}
```

**실행 예:**

```
0으로 나눌 수 없습니다.
계산을 종료합니다.
```

-----

### 문제 20: 학생 정보 객체 생성 (생성자 오버로딩)

**설명:**
다양한 방법으로 학생(`Student`) 객체를 생성할 수 있도록 **생성자 오버로딩**을 구현하세요.

**요구사항 명세서:**

1.  `Student` 클래스는 `studentId` (학번, `int`)와 `name` (이름, `String`) 필드를 가집니다.
2.  세 가지 종류의 생성자를 정의합니다.
      * 기본 생성자: `studentId`는 -1, `name`은 "미정"으로 초기화합니다.
      * 학번만 받는 생성자: `name`은 "미정"으로 초기화합니다.
      * 학번과 이름을 모두 받는 생성자
3.  `main` 메서드에서 세 가지 생성자를 각각 사용하여 객체를 생성하고, 각 객체의 정보를 "실행 예"와 같이 출력하세요.

**제공된 코드:**

```java
class Student {
    int studentId;
    String name;

    // TODO: 기본 생성자를 작성하시오. (studentId: -1, name: "미정")

    // TODO: 학번(studentId)만 받는 생성자를 작성하시오. (name: "미정")

    // TODO: 학번(studentId)과 이름(name)을 모두 받는 생성자를 작성하시오.

    public void printInfo() {
        System.out.println("학번: " + studentId + ", 이름: " + name);
    }
}

public class StudentFactory {
    public static void main(String[] args) {
        // TODO: 세 가지 생성자를 각각 사용하여 Student 객체를 생성하고 printInfo()를 호출하시오.
    }
}
```

**실행 예:**

```
학번: -1, 이름: 미정
학번: 2025001, 이름: 미정
학번: 2025002, 이름: 홍길동
```