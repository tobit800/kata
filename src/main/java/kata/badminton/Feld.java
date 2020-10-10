package kata.badminton;

import java.util.EnumSet;

import static java.text.MessageFormat.format;

public class Feld {
    private Seite links, rechts;

    public Feld(final Spieler s1, final Spieler s2, final Spieler s3, final Spieler s4) {
        links = new Seite(s1, s2);
        rechts = new Seite(s3, s4);
    }

    EnumSet<Spieler> links() {
        return links.getSpielers();
    }

    EnumSet<Spieler> rechts() {
        return rechts.getSpielers();
    }

    Seite gegenüber(Seite seite) {
        return seite == links ? rechts : links;
    }

    EnumSet<Spieler> alle() {
        var spielers = EnumSet.copyOf(links());
        spielers.addAll(rechts());
        return spielers;
    }

    EnumSet<Spieler> gegner(Spieler spieler) {
        return gegenüber(seite(spieler)).getSpielers();
    }

    private Seite seite(final Spieler spieler) {
        if (links().contains(spieler)) {
            return links;
        } else if (rechts().contains(spieler)) {
            return rechts;
        } else {
            var msg = format("Spieler {0} spielt nicht auf diesem Feld!", spieler);
            throw new IllegalArgumentException(msg);
        }
    }

    Spieler mitspieler(Spieler spieler) {
        return seite(spieler).getSpielers()
                             .stream()
                             .filter(s -> s != spieler)
                             .findFirst()
                             .orElseThrow();
    }


}
