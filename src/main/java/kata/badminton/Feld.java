package kata.badminton;

import java.util.EnumMap;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Optional.empty;
import static kata.badminton.Richtung.links;
import static kata.badminton.Richtung.rechts;

/**
 * Ein Feld besteht aus den zwei Seiten mit den Richtungen links und rechts.
 * Auf jeder Seite stehen genau zwei Spieler.
 */
public class Feld {
    private final EnumMap<Richtung, Seite> seiten = new EnumMap<>(Richtung.class);

    /**
     * Platziert die vier Spiler in diesem Feld, zwei je Seite.
     *
     * @param s1 1. Spieler auf die linke Seite
     * @param s2 2. Spieler auf die linke Seite
     * @param s3 3. Spieler auf die rechte Seite
     * @param s4 4. Spieler auf die rechte Seite
     */
    public Feld(final Spieler s1, final Spieler s2, final Spieler s3, final Spieler s4) {
        seiten.put(links, new Seite(links, s1, s2));
        seiten.put(rechts, new Seite(rechts, s3, s4));
    }

    Seite links() {
        return seiten.get(links);
    }

    Seite rechts() {
        return seiten.get(rechts);
    }

    Set<Spieler> linkeSpieler() {
        return links().getSpielers();
    }

    Set<Spieler> rechteSpieler() {
        return rechts().getSpielers();
    }

    Set<Spieler> alleSpieler() {
        var alleSpieler = linkeSpieler();
        alleSpieler.addAll(rechteSpieler());
        return alleSpieler;
    }

    Stream<Spieler> alleSpielerStream() {
        return alleSpieler().stream();
    }

    Optional<Seite> seiteVon(Spieler spieler) {
        if (linkeSpieler().contains(spieler)) {
            return Optional.of(links());
        }
        if (rechteSpieler().contains(spieler)) {
            return Optional.of(rechts());
        }
        return empty();
    }

    boolean contains(Spieler spieler) {
        return alleSpieler().contains(spieler);
    }

    Spieler mitspieler(Spieler spieler) {
        return links().mitspieler(spieler)
                      .orElseGet(rechts().mitspieler(spieler)::get);
    }

    Seite gegenseite(Seite seite) {
        return seiten.get(seite.richtung.gegen());
    }

    Optional<Seite> gegenseite(Spieler spieler) {
        return seiteVon(spieler).map(this::gegenseite);
    }

    Set<Spieler> gegner(final Spieler spieler) {
        return gegenseite(spieler).<Set<Spieler>>map(Seite::getSpielers).orElseGet(Set::of);
    }
}
