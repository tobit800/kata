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

    EnumSet<Spieler> getSpielers() {
        return spielers;
    }

    Optional<Spieler> mitspieler(Spieler spieler) {
        if (spielers.contains(spieler)) {
            return spielers.stream()
                           .filter(sp -> !sp.equals(spieler))
                           .findFirst();
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String toString() {
        return "Seite{ %s spielers=%s}".formatted(richtung, spielers);
    }
}
