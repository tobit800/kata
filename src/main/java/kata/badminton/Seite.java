package kata.badminton;

import java.util.EnumSet;
import java.util.Optional;

/**
 * Die Seite hat eine Richtung und zwei Spieler.
 */
class Seite {
    final Richtung richtung;
    private final EnumSet<Spieler> spielers;

    Seite(final Richtung richtung, Spieler sp1, Spieler sp2) {
        this.richtung = richtung;
        this.spielers = EnumSet.of(sp1, sp2);
    }

    @Override
    public String toString() {
        return "Seite{ %s spielers=%s}".formatted(richtung, spielers);
    }

    EnumSet<Spieler> getSpielers() {
        return spielers;
    }

    Optional<Spieler> mitspieler(Spieler spieler) {
        var copy = EnumSet.copyOf(spielers);
        if (copy.remove(spieler)) {
            return copy.stream()
                       .findAny();
        } else {
            return Optional.empty();
        }
    }
}
