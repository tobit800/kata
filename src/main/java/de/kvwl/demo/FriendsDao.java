package de.kvwl.demo;

public interface FriendsDao {
    /**
     * Lädt alle Freunde
     * @return Datenbank mit allen Freunden
     */
    FriendDatabase loadAllFriends();
}
