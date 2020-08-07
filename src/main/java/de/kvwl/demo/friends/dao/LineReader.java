package de.kvwl.demo.friends.dao;

import java.io.IOException;
import java.util.stream.Stream;

@FunctionalInterface
public interface LineReader {
  Stream<String> readLines() throws IOException;
}
