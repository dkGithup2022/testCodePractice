import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {
    @Test
    @DisplayName("스터디 만들기 : Active, 10")
    void create_study_1() {
        Study s1 = new Study(StudyDraft.ACTIVE, 10);
        assertNotNull(s1, "스터디 만들기 실패");
    }

    @Test
    @DisplayName("assert error message  : Excutable 객체 넣어보기 ")
    void create_study_2() {
        Study s1 = new Study(StudyDraft.ACTIVE, 1);
        assertNull(s1, new Supplier<String>() {
            @Override
            public String get() {
                return "excutable 객체 직접 정의해보기";
            }
        });
    }

    @Test
    @DisplayName("assert error message  : 람다 넣어보기  ")
    void create_study_3() {
        Study s1 = new Study(StudyDraft.ACTIVE, 1);
        assertNull(s1, () -> "람다 넣어보기");
    }

    @Test
    @DisplayName("assert error message  : 간략하게 메세지만   ")
    void create_study_4() {
        Study s1 = new Study(StudyDraft.ACTIVE, 11);
        assertNull(s1, "메세지만 ");
    }

    @Test
    @DisplayName(" 에러 발생 테스트 해보기 -> assertThrows")
    void throw_invalid_parameter_on_study() {
        assertThrows(IllegalArgumentException.class, () -> {
            Study s1 = new Study(StudyDraft.ACTIVE, -1);
        });
    }

    @Test
    @DisplayName(" 에러 발생 테스트 해보기 -> 에러 메세지 까지 확인 ")
    void throw_invalid_parameter_on_study_2() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Study s1 = new Study(StudyDraft.ACTIVE, -1);
        });

        assertEquals("사람이 적어요", e.getMessage(), "에러 메세지가 다름  ");
    }

    @Test
    @DisplayName("시간 재기")
    void test_assert_timeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(1000);
        }, "시간초과");
    }

    @Test
    @DisplayName("시간 재기 preemtively")
    void test_assert_timeout_preemtively() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(1000);
        }, "시간초과");
    }

    @Test
    @DisplayName("여러 값 한번에 확인")
    void check_values_at_once() {
        assertAll(
                () -> assertEquals(1, 1),
                () -> assertEquals(2, 2),
                () -> assertEquals(3, 3)
        );
    }
}