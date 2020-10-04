package kata.badminton;

import java.util.AbstractList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Entspricht einer Besetzung der vier Spielfelder mit acht Spielern.
 * Die Spieler haben einfach die Nummern 1 bis 8
 * Die Spielfelder sind jeweils ein Set vom Typ Integer und soll jeweils genau zwei Spieler enthalten.
 */
class Kombination extends AbstractList<SortedSet> {
    public static final int ANZAHL_SPIELFELDER = 4;
    public static final int ANZAHL_SPIELER = 2 * ANZAHL_SPIELFELDER;
    private final Map<Integer, SortedSet<Integer>> besetzung;

    Kombination() {
        besetzung = new HashMap<>();
        IntStream.range(0, ANZAHL_SPIELFELDER)
                 .forEach(i -> besetzung.put(i, new TreeSet<Integer>()));
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
        return size() == 4 && anzahlSpieler() == 8;
    }

    /**
     * @return Anzahl der <b>unterschiedlicher</b> Spieler auf allen Spielfeldern
     */
    int anzahlSpieler() {
        return besetzung.values()
                        .stream()
                        .flatMap(Set::stream)
                        .collect(Collectors.toSet())
                        .size();

    }


    /**
     * Bitte keine Doppelten
     *
     * @param feld     Nummer des Spielfelds startend mit 0
     * @param spieler1 Nummer des ersten Spielers
     * @param spieler2 Nummer des zweiten Spielers
     */
    void put(final int feld, final int spieler1, int spieler2) {
        Objects.checkIndex(feld, besetzung.size());
        Objects.checkIndex(spieler1, ANZAHL_SPIELER);
        Objects.checkIndex(spieler2, ANZAHL_SPIELER);

        var spielfeld = get(feld);
        spielfeld.add(spieler1);
        spielfeld.add(spieler2);
    }
}
