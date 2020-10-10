package kata.badminton;

/**
 * Die zwei Richtungen links und rechts.
 * Im Sinne von Ausrichtung.
 */
enum Richtung implements Gegenrichtung {
    links {
        @Override
        public Richtung gegen() {
            return rechts;
        }
    }, rechts {
        @Override
        public Richtung gegen() {
            return links;
        }
    };

    @Override
    public Richtung gegen() {
        return null;
    }
}
