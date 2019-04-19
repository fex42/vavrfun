package life;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PosTest {

    @Test
    public void testWrap() {
        assertThat(Pos.of(-1,10).wrap(10,10)).isEqualTo(Pos.of(9,0));
    }
}
