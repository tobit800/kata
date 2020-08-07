package de.kvwl.demo.friends.dao;

import de.kvwl.demo.friends.dao.filebased.Default;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class BufferedLineReader implements LineReader {
  private final Path csvPath;

  BufferedLineReader(Path csvPath) {
    this.csvPath = csvPath;
    assert Files.exists(csvPath);
  }

  @Override
  public Stream<String> readLines() throws IOException {
    List<String> lines = new ArrayList<>();
    try (BufferedReader reader = Files.newBufferedReader(csvPath, Default.CHARSET)) {
      String line = null;
      while ((line = reader.readLine()) != null) {
        lines.add(line);
      }
    } finally {
      return lines.stream();
    }
  }
}
