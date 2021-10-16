package nqgy.sep.streams;

import java.util.ArrayList;
import java.util.List;
import nqgy.sep.streams.filehandler.FileExporter;
import nqgy.sep.streams.filehandler.SimpleFileReader;
import nqgy.sep.streams.utils.ExtractUtils;

/** Starter class for the Stream and FileHandling project. */
public class Main {

  /**
   * Start method for this project.
   *
   * @param args array of command line arguments: first: input csv file name, path relative to src/
   *     directory second: output csv file name, will be in the root directory of the class files
   *     third: columns to extract, example use "1,3,4" to extract the 2nd, 4th and 5th column,
   *     quotes must be used!
   */
  public static void main(String[] args) {

    if (args.length != 3) {
      System.out.println("Wrong count of command line arguments. Read the docs!");
      return;
    }

    // "/" is added to make the path relative to the directory "src/"
    String inputFileName = "/" + args[0].trim();
    String outputFileName = args[1].trim();

    SimpleFileReader fileParser = new SimpleFileReader(inputFileName);

    List<String> outputList = new ArrayList<>();
    String[] stringArrayOfColumnsToExtract =
        ExtractUtils.removeLeadingTrailingQuotes(args[2].trim()).split(",");
    List<Integer> columnsToExtract = new ArrayList<>();
    for (int i = 0; i < stringArrayOfColumnsToExtract.length; i++) {
      columnsToExtract.add(Integer.parseInt(stringArrayOfColumnsToExtract[i].trim()));
    }

    for (String line : fileParser.getLineList()) {
      String outputLine = "";
      for (int i = 0; i < columnsToExtract.size(); i++) {
        outputLine += ExtractUtils.extractColumnFromCsvLine(line, columnsToExtract.get(i)) + ";";
      }
      outputLine = outputLine.substring(0, outputLine.length() - 1); // remove last ";"
      outputList.add(outputLine);
    }
    FileExporter fileExporter = new FileExporter(outputFileName);
    fileExporter.dumpToFile(outputList);
  }
}
