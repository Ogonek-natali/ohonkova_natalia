package ua.khpi.oop.Ohonkova05;
import java.util.Scanner;
/*
 * class Function in which all used functions are stored
 *
    * @author NATALIA
    * @version 4.2
    * Here start point of the program
    * */
public class Func {
    /*
     * Function that show user point of menu that he can choose
     * */
    static void ChooseMenu() {
          System.out.println("\n\nChoose the right variant:");
          System.out.println("1. Create string");
          System.out.println("2. Show string");
          System.out.println("3. Split text");
          System.out.println("4. Counting now");
          System.out.println("0. The End");
          System.out.print("Write:");
      }
    /*
     * Function show our string that we wrote
     * @param str is our string
     * */
    
    public static void ShowString(String str){
      System.out.println("Your string:");
      
              System.out.println(str);
      }
    
    /*
     * Function reads input string
     * @return str1 as our used string
     * */
    public static String InitializeString(){
          Scanner scan = new Scanner(System.in);
          System.out.print("Enter your word: ");
          String str1 = new String();
          str1 = scan.nextLine();
          return str1;
      }
    /*
     * Function truncates a string to a point and show the first sentence
     * @param index1 looking for dot
     * @return str 
     * */
    public static String CutText (String str) {
      int index1=str.indexOf('.');
      str = str.substring(index1+1);
      return str;
    }
    /*
     * Function truncates a string to a point and show the second sentence
     * @param index1 looking for dot
     * @return str 
     * */
    public static String CutText2 (String str) {
      int index1=str.indexOf('.');
      str = str.substring(0, index1+1);
      return str;
    }
    
    
    
  }