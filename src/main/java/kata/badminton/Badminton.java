package kata.badminton;

import java.util.SortedSet;

public class Badminton {
    public static void main(String[] args) {
        new Badminton().start();
    }

    private void start() {
        System.out.println("Starte...");
        SortedSet<Kombination> kombinationen = erzeugeKombinationen();
    }

    /**
     * Erzeugt eine Menge von Kombinationen
     *
     * @return Optimale Kombinationen
     */
    SortedSet<Kombination> erzeugeKombinationen() {
        return null;
    }


}
