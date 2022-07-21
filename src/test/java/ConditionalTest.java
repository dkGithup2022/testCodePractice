import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class ConditionalTest {
    @Test
    @DisplayName("환경변수 LOCAL 일 때만 실행")
    void conditional_test_1(){
        String localEnv = System.getenv("TEST_ENV");
        localEnv = "LOCAL";
        assumeTrue("LOCAL".equalsIgnoreCase(localEnv));
        assertNull(null);
    }

    @Test
    @DisplayName(" assumingThat  함수 테스트")
    void conditional_test_2(){
        assumingThat(true,()->{
            System.out.println("test goes if former returns true ");
            assertNull(null);
        });
        assumingThat(true,()->{
            System.out.println("test goes if former returns true  2");
            assertNull(null);
        });
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void conditional_test_3(){
        System.out.println("this is mac");
        assertNull(null);
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    @Disabled
    void conditional_test_4(){
        System.out.println("this is linux");
        assertNull(null);
    }
    @Test
    @EnabledOnJre(JRE.JAVA_16)
    void conditional_test_5(){
        System.out.println("this is java version 16");
        assertNull(null);
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    @Disabled
    void conditional_test_6(){
        System.out.println("this is java version 11");
        assertNull(null);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    @Disabled
    void conditional_test_7(){
        System.out.println(" ${TEST_ENV} is LOCAL");
        assertNull(null);
    }







}
