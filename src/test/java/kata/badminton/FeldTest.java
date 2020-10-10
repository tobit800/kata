package kata.badminton;

import org.junit.jupiter.api.Test;

import static kata.badminton.Richtung.links;
import static kata.badminton.Richtung.rechts;
import static org.assertj.core.api.Assertions.assertThat;

class FeldTest {
    Feld feld = new Feld(Spieler.A, Spieler.B, Spieler.C, Spieler.D);

    @Test
    void linkeSpieler() {
        var spielers = feld.linkeSpieler();
        assertThat(spielers).containsExactly(Spieler.A, Spieler.B);
    }

    @Test
    void rechteSpieler() {
        var spielers = feld.rechteSpieler();
        assertThat(spielers).containsExactly(Spieler.C, Spieler.D);
    }

    @Test
    void alleSpieler() {
        var alleSpieler = feld.alleSpieler();
        assertThat(alleSpieler).containsAll(feld.linkeSpieler())
                               .containsAll(feld.rechteSpieler());
    }

    @Test
    void seiteVonSpielerA() {
        var seite = feld.seiteVon(Spieler.A)
                        .get();
        assertThat(seite.richtung).isEqualTo(links);
    }

    @Test
    void seiteVonSpielerD() {
        var seite = feld.seiteVon(Spieler.D)
                        .get();
        assertThat(seite.richtung).isEqualTo(rechts);
    }

    @Test
    void seiteVonSpielereE() {
        var seite = feld.seiteVon(Spieler.E);
        assertThat(seite).isEmpty();
    }

    @Test
    void gegenseite() {
        var linkeSeite = feld.links();
        var gegenSeite = feld.gegen(linkeSeite);
        assertThat(gegenSeite.richtung).isEqualTo(rechts);
    }

    @Test
    void gegenspielerSpielerA() {
        var gegner = feld.gegner(Spieler.A);
        assertThat(gegner).containsExactly(Spieler.C, Spieler.D);
    }

    @Test
    void gegenspielerSpielerD() {
        var gegner = feld.gegner(Spieler.D);
        assertThat(gegner).containsExactly(Spieler.A, Spieler.B);
    }

    @Test
    void gegenspielerSpielerE() {
        var gegner = feld.gegner(Spieler.E);
        assertThat(gegner).isEmpty();
    }
}