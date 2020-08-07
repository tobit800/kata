package de.kvwl.demo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.Stream;

class BirthdayReminder {
  private Sender sender;
  private FriendsDao friendsDao;

  public BirthdayReminder(Sender sender, FriendsDao friendsDao) {
    this.sender = sender;
    this.friendsDao = friendsDao;
  }

  void start() throws IOException {
    FriendDatabase friendDatabase = friendsDao.loadAllFriends();
    Stream<Friend> stream = friendDatabase.stream();
    int todayDayOfYear = getDayOfYear();
    stream.filter(friend -> friend.getGeburtstag() == todayDayOfYear)
            .forEach(sender::sendHappyBirthday);
  }

  /**
   * @return Aktuellen Tag des Jahres
   */
  private int getDayOfYear() {
    return LocalDate
            .now()
            .getDayOfYear();
  }
}
