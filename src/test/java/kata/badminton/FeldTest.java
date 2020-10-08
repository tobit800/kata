package kata.badminton;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FeldTest {

    @Test
    void mitspielerFinden() {
        var feld = new Feld(Spieler.a, Spieler.b, Spieler.c, Spieler.d);
        var mitspieler = feld.mitspieler(Spieler.c);
        assertThat(mitspieler).isEqualTo(Spieler.d);
    }

    @Test
    void gegenspielerFinden() {
        var feld = new Feld(Spieler.a, Spieler.b, Spieler.c, Spieler.f);
        var gegner = feld.gegner(Spieler.b);
        assertThat(gegner).containsExactly(Spieler.c, Spieler.f);
    }
}