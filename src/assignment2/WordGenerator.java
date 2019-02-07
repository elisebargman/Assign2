package assignment2;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;



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
     
    return text.next();
    
  }


 public int getWordCount() {
  
   while (text.hasNext()) {
     
     text.next();
     wordCount++;
   }
    return wordCount;
  }


  public int getSentenceCount() {
    
    
    while (text.hasNext()) {
      String str = text.next();
      char lastLetter = str.charAt(str.length() - 1);
      if(lastLetter=='?'||lastLetter=='!'|| lastLetter=='.')
         sentenceCount++;
    }
       
    return sentenceCount;
  }
  


  public static void main(String[] args) throws IOException {

    WordGenerator generator = new WordGenerator("Hello.txt");

    generator.getSentenceCount();

    System.out.println(generator.getSentenceCount());

  }


}


