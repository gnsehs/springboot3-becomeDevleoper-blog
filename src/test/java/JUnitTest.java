import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class JUnitTest {
    /* 테스트가 성공하는 케이스 */
    @DisplayName("1 + 2는 3이다.") // 테스트 이름
    @Test
    public void junitTest() {
        int a = 1;
        int b = 2;
        int sum = 3;

        Assertions.assertEquals(sum,a+b); // a + b와 sum의 값이 같은지 확인

        // 첫번째 인수에는 기대하는 값 두번째 인수에는 실제로 검증할 값
    }

    /* 테스트가 실패하는 케이스 */

//    @DisplayName("1 + 3은 4이다.")
//    @Test
//    public void junitFailedTest() {
//        int a = 1;
//        int b = 3;
//        int sum = 3;
//
//        Assertions.assertEquals(sum,a+b);
//    }

    /* JUnit는 하나라도 테스트를 실패하면 전체 테스트를 실패한다. */

}
