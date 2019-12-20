package ua.khpi.oop.Ohonkova04;

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
        System.out.println("1. Create text");
        System.out.println("2. Show text");
        System.out.println("3. Input word");
        System.out.println("4. Show new text");
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
	 * function alphabet counting vowel and other 
	 * @param v our vowels
	 * */
	public static void ChangeText (String str1, String str3) {
		int word = 0;
		int begin_of_word = 0;
		int count = 0;
		int number = 5;
		String str2 = null;
	    for (int i = 0; i < str1.length(); i++) {
	      if (str1.charAt(i) == ' ') {
	        count++;
	      }
	    }
	    String[]wordArr = new String[++count];

	    for (int i = 0; i<str1.length();i++) {
	      if(str1.charAt(i)==' ') {
	        wordArr[word] = str1.substring(begin_of_word,i);
	        word++;
	        begin_of_word = i+1;
	      }
	    }
	    wordArr[word] = str1.substring(begin_of_word);

	    for (int i = 0; i < wordArr.length; i++) {
	      str2 = wordArr[i];
	      if (str2.length() == number) {
	        wordArr[i] = str3;
	      }
	    }

	    StringBuilder strBuild = new StringBuilder();
	    for (String s : wordArr) {
	      strBuild.append(s);
	      strBuild.append(" ");
	    }
	    str1 = strBuild.toString();
	    System.out.println(str1);
    }
	/*
	 * Function reads input string
	 * @return str1 as our used string
	 * */
	public static String InitializeString(){
        Scanner scan = new Scanner(System.in);
        String str1 = new String();
        str1 = scan.nextLine();
        return str1;
		}
}