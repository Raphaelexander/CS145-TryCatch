import java.util.Scanner;

public class ReadFile {
  public static void main(String[] args) {
    //take the url and convert it to a URL
    String URLString = "https://liveexample.pearsoncmg.com/data/Lincoln.txt";
       
    try {
      //import URL class and turn URLString into URL object
      java.net.URL url = new java.net.URL(URLString); 
      //initilize character count and wordcount
      int count = 0;
      int wordCount = 0;

      //Scan the URL with .openStream()
      Scanner input = new Scanner(url.openStream());
      while (input.hasNext()) {
        String line = input.nextLine();//takes 1 line in url, stores it as string object
        count += line.length();//adds last line object to total character count
        String[] words = line.split("\\s+"); //.split() splits the string into words, \\s+ ignores multiple instances of whitespace
        wordCount += words.length; //adds the word count of line to total word count
      } 
      
      //prints out final character and word count
      System.out.println("The file size is " + count + " characters and " + wordCount + " words.");
    }
    //catches an invalid URL exception and prints Invalid URL instead
    catch (java.net.MalformedURLException ex) {
      System.out.println("Invalid URL");
    }
    //catches read error or file not found and prints IO Errors instead
    catch (java.io.IOException ex) {
      System.out.println("IO Errors");
    }
  }
}   