package kata.badminton;

import java.util.EnumSet;

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
}
