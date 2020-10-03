package kata.badminton;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BadmintonTest {

    private Badminton badminton = new Badminton();

    @BeforeEach
    void setUp() {
    }

    @Test
    void kombinationenNichtLeer() {
        var kombinationen = badminton.erzeugeKombinationen();
        assertThat(kombinationen).isNotEmpty();
    }

    @Test
    void kombinationenAlleGültig() {
        var kombinationen = badminton.erzeugeKombinationen();
        Condition<Kombination> gültig = new Condition<>(Kombination::isGültig, "Gültig");
        assertThat(kombinationen).are(gültig);
    }
}