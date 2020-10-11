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
    void feldVonSpielerA() {
        var feld = platz.feldVon(Spieler.A);
        assertThat(feld).isEqualTo(feld1);
    }

    @Test
    void feldVonSpielerH() {
        var feld = platz.feldVon(Spieler.H);
        assertThat(feld).isEqualTo(feld2);
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

    @Test
    void gegnerVonSpielerA() {
        var gegner = platz.gegner(Spieler.A);
        assertThat(gegner).contains(Spieler.C, Spieler.D);
    }

    @Test
    void gegnerVonSpielerG() {
        var gegner = platz.gegner(Spieler.G);
        assertThat(gegner).contains(Spieler.E, Spieler.F);
    }

    @Test
    void alleGegnerKomplett() {
        var gesamt = EnumSet.allOf(Spieler.class);
        var alleGegner = platz.alleGegner();
        assertThat(alleGegner).containsOnlyKeys(gesamt);
    }

    @Test
    void alleGegnerSpielerA() {
        var alleGegner = platz.alleGegner();
        assertThat(alleGegner.get(Spieler.A)).containsExactly(Spieler.C, Spieler.D);
    }

    @Test
    void alleGegnerSpielerG() {
        var alleGegner = platz.alleGegner();
        assertThat(alleGegner.get(Spieler.G)).containsExactly(Spieler.E, Spieler.F);
    }
}