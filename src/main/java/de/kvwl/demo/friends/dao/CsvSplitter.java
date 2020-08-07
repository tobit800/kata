package de.kvwl.demo.friends.dao;

@FunctionalInterface
interface CsvSplitter {
  String[] split(String line);
}
