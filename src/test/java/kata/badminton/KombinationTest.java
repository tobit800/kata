package kata.badminton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

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
        IntStream.range(0, 4)
                 .forEach(i -> kombination.put(i, i * 2, i * 2 + 1));
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

    @Test
    void anzahlSpieler() {
        assertThat(kombination.anzahlSpieler()).isZero();
        kombination.put(0, 0, 1);
        assertThat(kombination.anzahlSpieler()).isEqualTo(2);
    }

    @Test
    void anzahlSpielerMitDoppelten() {
        kombination.put(0, 0, 1);
        kombination.put(1, 1, 2);//Spieler 1 spielt doppelt !
        assertThat(kombination.anzahlSpieler()).isEqualTo(3);
    }
}