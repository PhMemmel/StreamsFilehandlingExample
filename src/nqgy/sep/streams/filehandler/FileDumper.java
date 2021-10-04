package nqgy.sep.streams.filehandler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

/** Class writing out a given List to a txt file. */
public class FileDumper {

  private static final String EXPORT_FILENAME = "/outputfile.txt";

  /**
   * Writes out the given list of strings to a file. Care: The output file will be in the root
   * directory of the class files.
   *
   * @param listToPrint the list to print to a file
   */
  public void dumpToFile(List<String> listToPrint) {

    String dir = getClass().getResource("/").getFile();
    OutputStream outputStream;
    PrintStream printStream;
    try {
      outputStream = new FileOutputStream(dir + EXPORT_FILENAME);
      printStream = new PrintStream(outputStream);

      // for (String word : listToPrint) wouldn't neccessarily preserve order
      for (int i = 0; i < listToPrint.size(); i++) {
        printStream.println(listToPrint.get(i));
      }
      // the elegant way with stream/lambda/method reference:
      // listToPrint.forEach(printStream::println);

      printStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
