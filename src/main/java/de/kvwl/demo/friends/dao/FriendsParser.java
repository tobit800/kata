package de.kvwl.demo.friends.dao;

import de.kvwl.demo.Friend;
@FunctionalInterface
interface FriendsParser {
  Friend parse(String[] token) ;
}
