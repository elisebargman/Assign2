package assignment2;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;



public class WordGenerator {

  // When you call this in main you need to specify file name in constructor, and
  // you need new in main.
  // Scanner text = new Scanner (System.in);
  // System in specifies inputting item through keyboard ,and if you have

  Scanner text;

  int wordCount = 0;
  int sentenceCount = 0;

  public WordGenerator(String filename) throws FileNotFoundException {

    text = new Scanner(new File(filename));

    // constructs a new generator that processes text from the given file.
  }


  public boolean hasNext() {
    if (text.hasNext()) {
      return true;
    } else
      return false;
  }



  public String next() {
    
    wordCount++;
    String str = text.next();
    char lastLetter = str.charAt(str.length() - 1);
    if (lastLetter == '?' || lastLetter == '!' || lastLetter == '.') {
      sentenceCount++;
    }
  

    return str;

  }



  public int getWordCount() {
    return wordCount;
  }


  public int getSentenceCount() {
    return sentenceCount;
  }


  public static void main(String[] args) throws IOException {
   
    PrintWriter pen = new PrintWriter(System.out, true);

    WordGenerator generator = new WordGenerator("Hello.txt");

    
    while (generator.hasNext()){
      
      pen.println(generator.next() + " " +generator.getWordCount() + " " +generator.getSentenceCount());
      
    }

  }


}


