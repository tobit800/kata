package kata.badminton;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Entspricht einer Besetzung der vier Spielfelder mit acht Spielern.
 * Die Spieler haben einfach die Nummern 1 bis 8
 * Die Spielfelder sind jeweils ein Set vom Typ Integer und soll jeweils genau zwei Spieler enthalten.
 */
class Kombination extends AbstractList<SortedSet> {
    public static final int ANZAHL_SPIELFELDER = 4;
    private final List<SortedSet<Integer>> besetzung;

    Kombination() {
        besetzung = new ArrayList<>();
        for (int i = 0; i < ANZAHL_SPIELFELDER; i++) {
            besetzung.add(new TreeSet<Integer>());
        }
    }

    @Override
    public SortedSet get(final int index) {
        return besetzung.get(index);
    }

    @Override
    public int size() {
        return besetzung.size();
    }

    boolean isGültig() {
        return false;
    }

    /**
     * Bitte keine Doppelten
     *
     * @param feldNr Nummer des Spielfelds startend mit 0
     * @param nr1    Nummer des ersten Spielers
     * @param nr2    Nummer des zweiten Spielers
     */
    void put(final int feldNr, final int nr1, int nr2) {
        Objects.checkIndex(feldNr, besetzung.size());
        Objects.checkIndex(nr1, 8);
        Objects.checkIndex(nr2, 8);

        var spielfeld = get(feldNr);
        spielfeld.add(nr1);
        spielfeld.add(nr2);
    }
}
