package de.kvwl.demo;

import java.util.ArrayList;
import java.util.stream.Stream;

public class FriendDatabase {

    private ArrayList<Friend> friends = new ArrayList<>();

    Stream<Friend> stream() {
        return friends.stream();
    }

    public void add(final Friend friend) {
        friends.add(friend);
    }
}
