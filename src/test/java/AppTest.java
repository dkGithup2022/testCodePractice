import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class AppTest {

    @Test
    void createTest(){
        App app = new App();
        assertNotNull(app);
    }



}