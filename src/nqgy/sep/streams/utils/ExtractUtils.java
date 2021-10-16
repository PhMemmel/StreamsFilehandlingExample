package nqgy.sep.streams.utils;

public class ExtractUtils {

  public static String extractColumnFromCsvLine(String line, int columnNumber) {
    line = line.trim();
    String column = line.split(";")[columnNumber].trim();
    // the following is just to remove eventually existing leading or trailing quotes which
    // csv files happen to use to encapsulate the columns
    if (column.startsWith("\"") && column.endsWith("\"")) {
      column = column.substring(1, column.length() - 1);
    }
    return column;
  }
}
