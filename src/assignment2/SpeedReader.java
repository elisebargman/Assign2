package assignment2;

import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.awt.Font;
import java.io.PrintWriter;

public class SpeedReader {


  static WordGenerator gen;


  /**
   * Renders and animates text in a pop-up panel 
   * 
   * @param filename : this is the filename to be read 
   * @param width : an integer, width of panel 
   * @param height: an integer, height of panel 
   * @param fontSize: an integer, font size of text in panel 
   * @param wpm : an integer, words per minute
   * @throws InterruptedException
   */
  
  public static void demonstratePanel(String filename, int width, int height, int fontSize, int wpm)
      throws InterruptedException {

    DrawingPanel panel = new DrawingPanel(width, height);
    Graphics g = panel.getGraphics();
    Font f = new Font("Courier", Font.BOLD, fontSize);
    g.setFont(f);
    // g.drawString("Hello World!", 100, 100);

    int sleepTime = 60000 / wpm;


    while (gen.hasNext()) {
      String nextword = gen.next();
      g.drawString(nextword, 100, 100);
      Thread.sleep(sleepTime);
      panel.clear();
    }
  }
  
  /**
   * The main of SpeedReader. 
   * 
   * @param args
   * @throws FileNotFoundException
   * @throws InterruptedException
   */
  
  public static void main(String[] args) throws FileNotFoundException, InterruptedException {

    PrintWriter pen = new PrintWriter(System.out, true);

    PrintWriter error = new PrintWriter(System.err, true);

    String filename = args[0];

    int width = Integer.valueOf(args[1]);

    int height = Integer.valueOf(args[2]);

    int fontSize = Integer.valueOf(args[3]);

    int wpm = Integer.valueOf(args[4]);

    gen = new WordGenerator(filename);


    // This checks to make sure that there is a correct number of parameters
    if (args.length != 5) {
      error.println(
          "Please enter number of correct parameters : <filename> <width> <height> <font size> <wpm>\n");

      System.exit(1);
    } else {

      demonstratePanel(filename, width, height, fontSize, wpm);

      pen.println("Word count: " + gen.getWordCount());
      pen.println("Sentence count: " + gen.getSentenceCount());


    }
  }



}


