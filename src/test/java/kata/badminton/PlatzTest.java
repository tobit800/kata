package kata.badminton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class PlatzTest {
    Feld feld1 = new Feld(Spieler.A, Spieler.B, Spieler.C, Spieler.D);
    Feld feld2 = new Feld(Spieler.E, Spieler.F, Spieler.G, Spieler.H);

    Platz platz;

    @BeforeEach
    void setUp() {
        platz = new Platz(feld1, feld2);
    }

    @Test
    void alleSpielerSpielen() {
        var gesamt = EnumSet.allOf(Spieler.class);
        Set<Spieler> alle = platz.alleSpieler();
        assertThat(alle).containsAll(gesamt);
    }
}