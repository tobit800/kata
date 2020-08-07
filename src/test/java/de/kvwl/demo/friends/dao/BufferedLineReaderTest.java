package de.kvwl.demo.friends.dao;

import de.kvwl.demo.friends.dao.filebased.Default;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BufferedLineReaderTest {
  private final String content = """
          last_name, first_name, date_of_birth, email
          Doe, John, 1982-10-08, john.doe@foobar.com
          Ann, Mary, 1975-09-11, mary.ann@foobar.com
          """;
  private BufferedLineReader sut;

  @BeforeEach
  void setUp() throws Exception{
    Path tempFilePath = Files.createTempFile("BufferedLineReaderTest", "csv");
    try (BufferedWriter writer = Files.newBufferedWriter(tempFilePath, Default.CHARSET)) {
      writer.write(content, 0, content.length());
    }
    sut = new BufferedLineReader(tempFilePath);
  }

  @Test
  void readLines() throws IOException {
    Stream<String> lines = sut.readLines();

    assertThat(lines).hasSize(3);
  }
}