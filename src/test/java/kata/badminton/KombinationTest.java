package kata.badminton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static kata.badminton.Kombination.ANZAHL_SPIELFELDER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KombinationTest {
    private Kombination kombination;

    @BeforeEach
    void setUp() {
        kombination = new Kombination();
    }

    @Test
    void neueKombinationEnthältSets() {
        assertThat(kombination).hasSize(ANZAHL_SPIELFELDER);
    }

    @Test
    void putFunktioniert() {
        kombination.put(0, 0, 1);
        kombination.put(1, 2, 3);
        kombination.put(2, 4, 5);
        kombination.put(3, 6, 7);
        assertThat(kombination.get(0)).containsExactly(0, 1);
        assertThat(kombination.get(1)).containsExactly(2, 3);
        assertThat(kombination.get(2)).containsExactly(4, 5);
        assertThat(kombination.get(3)).containsExactly(6, 7);
    }

    @Test
    void putErlaubtNurPositiveSpielfeldnummern() throws Exception {
        assertThrows(IndexOutOfBoundsException.class, () -> kombination.put(-1, 1, 2));
    }

    @Test
    void putErlaubtNurGültigeSpielfeldnummern() throws Exception {
        assertThrows(IndexOutOfBoundsException.class, () -> kombination.put(4, 1, 2));
    }

    @Test
    void putErlaubtNurGültigeSpielernummern() {
        assertThrows(IndexOutOfBoundsException.class, () -> kombination.put(0, 0, 8));
    }


    @Test
    void isGültigJedesSetGenauZweiElemente() {
        kombination.put(1, 1, 2);
    }
}