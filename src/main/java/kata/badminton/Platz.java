package kata.badminton;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Der Platz enthält zwei Felder.
 */
class Platz {
    private final List<Feld> felder;

    Platz(Feld feld1, Feld feld2) {
        felder = Arrays.asList(feld1, feld2);
    }

    public Set<Spieler> alleSpieler() {
        return felder.stream()
                     .flatMap(Feld::alleSpielerStream)
                     .collect(Collectors.toSet());
    }
}
