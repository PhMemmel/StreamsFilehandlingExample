package nqgy.sep.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import nqgy.sep.streams.filehandler.FileExporter;
import nqgy.sep.streams.filehandler.SimpleFileReader;
import nqgy.sep.streams.utils.ExtractUtils;

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

    List<String> addresses = fileParser.getLineList();
    List<String> outputList = new ArrayList<>();
    for (String line : addresses) {
      // extract (in this order): surname, first name and phone number
      outputList.add(
          ExtractUtils.extractColumnFromCsvLine(line, 1)
              + ";"
              + ExtractUtils.extractColumnFromCsvLine(line, 0)
              + ";"
              + ExtractUtils.extractColumnFromCsvLine(line, 5));
    }
    FileExporter fileExporter = new FileExporter();
    fileExporter.dumpToFile(outputList);
  }
}
