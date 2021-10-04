package nqgy.sep.streams;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import nqgy.sep.streams.filehandler.FileDumper;
import nqgy.sep.streams.filehandler.FileParser;

/** Starter class for the Stream and FileHandling project. */
public class Main {

  /**
   * Start method for this project.
   *
   * @param args ignored
   */
  public static void main(String[] args) {
    Random random = new Random();
    FileParser fileParser = new FileParser();
    System.out.print("Random word: ");
    System.out.println(
        fileParser.getWordSet().toArray()[random.nextInt(fileParser.getWordSet().size())]);

    List<String> wordsWithThreeChars =
        fileParser.getWordSet().stream()
            .filter(word -> word.length() < 3)
            .collect(Collectors.toList());
    FileDumper fileDumper = new FileDumper();
    fileDumper.dumpToFile(wordsWithThreeChars);
  }
}
