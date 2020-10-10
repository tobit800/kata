package kata.badminton;

import org.junit.jupiter.api.Test;

import static kata.badminton.Richtung.links;
import static kata.badminton.Richtung.rechts;
import static org.assertj.core.api.Assertions.assertThat;

class RichtungTest {

    @Test
    void gegen() {
        assertThat(links.gegen()).isEqualTo(rechts);
        assertThat(rechts.gegen()).isEqualTo(links);
    }

    @Test
    void values() {
        var values = Richtung.values();
        assertThat(values).hasSize(2);
    }
}