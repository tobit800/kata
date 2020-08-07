package de.kvwl.demo;

import java.time.LocalDate;

public record Friend(String vorname, String nachname, LocalDate geburtstag, String eMail) {

    int getGeburtstag() {
        return geburtstag().getDayOfYear();
    }
}
