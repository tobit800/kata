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
    void mitspielerSpielerA() {
        var mitspieler = platz.mitspieler(Spieler.A);
        assertThat(mitspieler).isEqualTo(Spieler.B);
    }

    @Test
    void mitspielerSpielerH() {
        var mitspieler = platz.mitspieler(Spieler.H);
        assertThat(mitspieler).isEqualTo(Spieler.G);
    }

    @Test
    void alleSpielerSpielen() {
        var gesamt = EnumSet.allOf(Spieler.class);
        Set<Spieler> alle = platz.alleSpieler();
        assertThat(alle).containsAll(gesamt);
    }

    @Test
    void alleMitspielerJedesSpielers() {
        var gesamt = EnumSet.allOf(Spieler.class);
        var alleMitSpieler = platz.alleMitSpieler();
        assertThat(alleMitSpieler).containsOnlyKeys(gesamt);
    }

    @Test
    void alleMitSpielerSpielerA() {
        var mitSpieler = platz.alleMitSpieler()
                              .get(Spieler.A);
        assertThat(mitSpieler).isEqualTo(Spieler.B);
    }

    @Test
    void alleMitSpielerSpielerH() {
        var mitSpieler = platz.alleMitSpieler()
                              .get(Spieler.H);
        assertThat(mitSpieler).isEqualTo(Spieler.G);
    }
}