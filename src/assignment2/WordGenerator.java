package assignment2;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// When you call this in main you need to specify file name in constructor, and
// you need new in main.
// Scanner text = new Scanner (System.in);
// System in specifies inputting item through keyboard ,and if you have

/**
 * @author Elise and Kedamawit
 *
 */

public class WordGenerator {

  /**
   * creates a scanner object
   */
  Scanner text;


  /**
   * sets counter to 0
   *
   */
  int wordCount = 0;


  /**
   * sets counter to 0
   */
  int sentenceCount = 0;


  /**
   * constructs a new generator that processes text from the given file.
   * 
   * @param filename
   * @throws FileNotFoundException
   */

   WordGenerator(String filename) throws FileNotFoundException {
    text = new Scanner(new File(filename));
  }



  /**
   * returns true iff the underlying Scanner of this WordGenerator has text left to process.
   * 
   * @return boolean value
   */
   boolean hasNext() {
    if (text.hasNext()) {
      return true;
    } else
      return false;
  }



  /**
   * returns the next word of the underlying Scanner. If the Scanner does not have words left, then
   * the behavior of next() is undefined (i.e., you don’t have to check or handle this case).
   * 
   * 
   * @return string str
   */
   String next() {

    wordCount++;

    String str = text.next();
    char lastLetter = str.charAt(str.length() - 1);
    if (lastLetter == '?' || lastLetter == '!' || lastLetter == '.') {
      sentenceCount++;
    }

    return str;
  }



  /**
   * returns the number of words produced by the WordGenerator so far.
   * 
   * @return int wordcount
   */
   int getWordCount() {
    return wordCount;
  }


  /**
   * returns the number of sentences produced by the WordGenerator so far. Define a sentence to be
   * the number of occurrences a sentence-ending punctuation mark appears at the end of a word—'.',
   * '!', or '?'.
   * 
   * @return int
   */
   int getSentenceCount() {
    return sentenceCount;
  }



  /**
   * /** USED FOR TESTING
   *
   *
   * @param args
   * @throws IOException
   * 
   *         public static void main(String[] args) throws IOException {
   * 
   *         PrintWriter pen = new PrintWriter(System.out, true);
   * 
   *         WordGenerator generator = new WordGenerator("Hello.txt");
   * 
   * 
   *         while (generator.hasNext()){
   * 
   *         pen.println(generator.next() + " " +generator.getWordCount() + " "
   *         +generator.getSentenceCount());
   * 
   *         } }
   * 
   */

}
