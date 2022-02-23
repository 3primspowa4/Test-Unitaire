import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AssertTest {
    @Test
    public void asserttest(){
        assertThat(5).isBetween(2,3);
    }
}