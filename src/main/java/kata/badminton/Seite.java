package kata.badminton;

import java.util.EnumSet;
import java.util.Optional;

class Seite {
    private final EnumSet<Spieler> spielers;

    Seite(Spieler spieler1, Spieler spieler2) {
        this.spielers = EnumSet.of(spieler1, spieler2);
    }

    EnumSet<Spieler> getSpielers() {
        return spielers;
    }

    @Override
    public String toString() {
        return "Seite{" + "spielers=" + spielers + '}';
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


}
