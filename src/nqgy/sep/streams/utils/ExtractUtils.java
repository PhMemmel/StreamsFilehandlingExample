package nqgy.sep.streams.utils;

/**
 * Utility class providing useful string operation methods.
 */
public class ExtractUtils {

  /**
   * Extracts the column out of a parsed csv file line.
   *
   * @param line the line to extract the needed column from
   * @param columnNumber the column number to extract (starting with index 0)
   * @return the extracted column string, eventually existing quotes have been removed
   */
  public static String extractColumnFromCsvLine(String line, int columnNumber) {
    line = line.trim();
    String column = line.split(";")[columnNumber].trim();
    // the following is just to remove eventually existing leading or trailing quotes which
    // csv files happen to use to encapsulate the columns
    column = removeLeadingTrailingQuotes(column);
    return column;
  }

  /**
   * removes trailing and leading quotes out of a given string
   *
   * @param stringToRemoveQuotes the string to remove quotes from
   * @return the string without trailing and leading quotes
   */
  public static String removeLeadingTrailingQuotes(String stringToRemoveQuotes) {
    if (stringToRemoveQuotes.startsWith("\"") && stringToRemoveQuotes.endsWith("\"")) {
      stringToRemoveQuotes = stringToRemoveQuotes.substring(1, stringToRemoveQuotes.length() - 1);
    }
    return stringToRemoveQuotes;
  }
}
