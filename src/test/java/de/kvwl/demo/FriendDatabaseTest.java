package de.kvwl.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class FriendDatabaseTest {
    private FriendDatabase sut;

    @BeforeEach
    public void setUp() {
        sut = new FriendDatabase();
    }

    @Test
    void steamIsNotNull() {
        Assert.assertNotNull(sut.stream());
    }

    @Test
    void addOneGetOne() {
        Friend friend = new Friend("vor", "nach", LocalDate.now(), "a@be.de");
        sut.add(friend);
        Assert.assertEquals(1, sut.stream().count());
    }
}