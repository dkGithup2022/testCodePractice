import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tags.Tag1Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class TaggingTest {


    @Tag1Test @DisplayName("tag1 test")
    public void tagging_tag1_1(){
        System.out.println("this is tag 1 ");
        assertNull(null);
    }

    @Test
    @DisplayName("no tag test")
    public void tagging_no_tag_1(){
        System.out.println("this is no tag ");
        assertNull(null);
    }
}
