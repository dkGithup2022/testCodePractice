import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class AppTest {

    @Test
    void createTest(){
        App app = new App();
        assertNotNull(app);
    }

    @Disabled
    @Test void testtest(){
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