
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/* 퀴즈 */
public class JUnitQuiz {

    @Test
    public void junitTest() {
        String name1 = "홍길동";
        String name2 = "홍길동";
        String name3 = "홍길은";

        // 모든 변수가 null이 아닌지 확인
        // 1 2 같은지
        // 1 3 다른지

        assertThat(name1).isNotEmpty();
        assertThat(name2).isNotEmpty();
        assertThat(name3).isNotEmpty();
        assertThat(name1).isEqualTo(name2);
        assertThat(name1).isNotEqualTo(name3);

    }

    public void junitTest2() {
        int num1 = 15;
        int num2 = 0;
        int num3 = -5;

        // n1 양수인지
        // n2 0
        // n3 negative
        // n1 > n2
        // n3 < n2

        assertThat(num1).isPositive();
        assertThat(num2).isZero();
        assertThat(num3).isNegative();
        assertThat(num1).isGreaterThan(num2);
        assertThat(num3).isLessThan(num2);
    }
}
