package ua.khpi.oop.Ohonkova03;
public class Main {
	 public static void main(String[] args) {
		    int word = 0;
		    int begin_of_word = 0;
		    String str1 = "Hello Petere How are you";
		    System.out.println(str1);
		    
		    int count = 0;
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

		    Helper.ChangeText(wordArr);

		    StringBuilder strBuild = new StringBuilder();
		    for (String s : wordArr) {
		      strBuild.append(s);
		      strBuild.append(" ");
		    }
		    str1 = strBuild.toString();
		    System.out.println(str1);
		 
	 }    
}
