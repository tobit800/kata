package kata.badminton;

import org.junit.jupiter.api.Test;

import static kata.badminton.Richtung.links;
import static org.assertj.core.api.Assertions.assertThat;

class SeiteTest {
    private final Seite seite = new Seite(links, Spieler.A, Spieler.B);

    @Test
    void linkeSeite() {
        assertThat(seite.richtung).isEqualTo(links);
    }

    @Test
    void mitSpielerVorhanden() {
        var mitspieler = seite.mitspieler(Spieler.A);
        assertThat(mitspieler).containsSame(Spieler.B);
    }

    @Test
    void mitSpielerNichtVorhanden() {
        var mitspieler = seite.mitspieler(Spieler.C);
        assertThat(mitspieler).isEmpty();
    }

}