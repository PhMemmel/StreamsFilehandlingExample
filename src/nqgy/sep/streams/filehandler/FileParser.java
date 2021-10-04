package nqgy.sep.streams.filehandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * FileParser class. Parses a file and stores its content in a Set.
 */
public class FileParser {

  // list origin: https://github.com/dwyl/english-words, for copyright information see the link
  private static final String WORD_DATABASE_FILENAME = "../words_alpha.txt";
  private Set<String> words;

  public FileParser() {
    words = new HashSet<>();
    initializeWordDatabase();
  }

  private void initializeWordDatabase() {
    File wordsFile =
        new File(Objects.requireNonNull(getClass().getResource(WORD_DATABASE_FILENAME)).getFile());
    BufferedReader bufferedFileReader;
    try {
      bufferedFileReader = new BufferedReader(new FileReader(wordsFile, StandardCharsets.UTF_8));
    } catch (FileNotFoundException e) {
      System.out.println("File " + WORD_DATABASE_FILENAME + " not found!");
      return;
    } catch (IOException e) {
      System.out.println("Wrong encoding!");
      return;
    }
    System.out.println("Parsing file into collection...");

    String tmp;
    try {
      while (bufferedFileReader.ready()) {
        tmp = bufferedFileReader.readLine();
        words.add(tmp);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    // the elegant way using stream and lambda expression
    /*bufferedFileReader
    .lines()
    .forEach(
        word -> {
          word = word.trim();
          if (!words.contains(word)) {
            words.add(word);
          }
        });*/
    try {
      bufferedFileReader.close();
    } catch (IOException e) {
      System.out.println("Couldn't close stream.");
      e.printStackTrace();
    }
  }

  public Set<String> getWordSet() {
    return words;
  }
}
