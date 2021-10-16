package nqgy.sep.streams.utils;

public class ExtractUtils {

  public static String extractColumnFromCsvLine(String line, int columnNumber) {
    line = line.trim();
    String column = line.split(";")[columnNumber].trim();
    // the following is just to remove eventually existing leading or trailing quotes which
    // csv files happen to use to encapsulate the columns
    column = removeLeadingTrailingQuotes(column);
    return column;
  }

  public static String removeLeadingTrailingQuotes(String stringToRemoveQuotes) {
    if (stringToRemoveQuotes.startsWith("\"") && stringToRemoveQuotes.endsWith("\"")) {
      stringToRemoveQuotes = stringToRemoveQuotes.substring(1, stringToRemoveQuotes.length() - 1);
    }
    return stringToRemoveQuotes;
  }
}
