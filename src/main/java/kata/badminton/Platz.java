package kata.badminton;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Der Platz enthält zwei Felder.
 */
class Platz {
    private final List<Feld> felder;

    Platz(Feld feld1, Feld feld2) {
        felder = Arrays.asList(feld1, feld2);
    }

    Feld feldVon(Spieler spieler) {
        return felder.stream()
                     .filter(feld -> feld.contains(spieler))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException(
                             "Spieler {0} ist nicht auf diesem Platz {}".formatted(spieler, this)));
    }

    public Set<Spieler> alleSpieler() {
        return felder.stream()
                     .flatMap(Feld::alleSpielerStream)
                     .collect(Collectors.toSet());
    }

    Spieler mitspieler(final Spieler spieler) {
        return feldVon(spieler).mitspieler(spieler);
    }

    public Map<Spieler, Spieler> alleMitSpieler() {
        return alleSpieler().stream()
                            .collect(Collectors.toMap(Function.identity(), spieler -> mitspieler(spieler)));
    }

    Set<Spieler> gegner(Spieler spieler) {
        return feldVon(spieler).gegner(spieler);
    }

    public Map<Spieler, Set<Spieler>> alleGegner() {
        return alleSpieler().stream()
                            .collect(Collectors.toMap(Function.identity(), spieler -> gegner(spieler)));
    }
}
