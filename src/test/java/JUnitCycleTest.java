import org.junit.jupiter.api.*;
/* 테스트는 보통 메서드 단위로 실행됨 */
/* 테스트 단위로 실행객체를 만듦 */
public class JUnitCycleTest {

    @BeforeAll // 전체 테스트를 시작하기 전에 1회 실행하므로 메서드는 static으로 // 클래스 레벨 설정
    public static void beforeAll() { // 테스트 마다 객체를 만드는데 어떤 케이스도 실행되기 전에 실행되므로 객체없이도 실행 되어야 함
        System.out.println("@BeforeAll");
    }

    @BeforeEach // 메서드 레벨 설정
    public void beforeEach() { // 테스트 케이스를 시작하기 전마다 실행
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }

    @AfterAll
    public static void afterAll() { // 전체테스트를 마치고 종료하기 전에 1회 실행하므로 static으로 선언
        System.out.println("@AfterAll");
    }

    @AfterEach
    public void afterEach() { // 테스트 케이스를 종료하기 전마다 실행
        System.out.println("@AfterEach");
    }
}

/*@BeforeAll
@BeforeEach
test1
@AfterEach
@BeforeEach
test2
@AfterEach
@BeforeEach
test3
@AfterEach
@AfterAll*/