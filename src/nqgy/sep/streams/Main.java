package nqgy.sep.streams;

import java.util.List;
import java.util.Random;
import nqgy.sep.streams.filehandler.FileExporter;
import nqgy.sep.streams.filehandler.SimpleFileReader;

/** Starter class for the Stream and FileHandling project. */
public class Main {

  /**
   * Start method for this project.
   *
   * @param args ignored
   */
  public static void main(String[] args) {
    Random random = new Random();
    SimpleFileReader fileParser = new SimpleFileReader("/Adressen.csv");

    // for now it's just read in and dump it to outputfile without any changes
    List<String> addresses = fileParser.getLineList();
    FileExporter fileExporter = new FileExporter();
    fileExporter.dumpToFile(addresses);
  }
}
