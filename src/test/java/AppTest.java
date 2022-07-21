import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class AppTest {

    @Test
    @DisplayName("객체 생성 | 생성자 없음 ")
    void create_test(){
        App app = new App();
        assertNotNull(app);
    }

    @Disabled
    @DisplayName("deprecated 된 코드 ")
    @Test void test_test(){
        assertNotNull(null);
    }

    // static 으로만 선언
    @BeforeAll
    static void beforeAll(){
        System.out.println("Before all");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After all");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Before each");
    }

    @AfterEach
    void afterEach(){
        System.out.println("After each");
    }
}