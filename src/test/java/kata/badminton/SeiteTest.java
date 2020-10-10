package kata.badminton;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SeiteTest {

    private final Seite seite = new Seite(Spieler.a, Spieler.b);

    @Test
    void mitSpielerVorhanden() {
        var mitspieler = seite.mitspieler(Spieler.a);
        assertThat(mitspieler).containsSame(Spieler.b);
    }

    @Test
    void mitSpielerNichtVorhanden() {
        var mitspieler = seite.mitspieler(Spieler.c);
        assertThat(mitspieler).isEmpty();
    }

}