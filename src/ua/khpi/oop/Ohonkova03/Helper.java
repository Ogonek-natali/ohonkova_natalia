package ua.khpi.oop.Ohonkova03;

public class Helper {
	public static void ChangeText(String[] wordArr) {
		String str3 = "Letter";
		String str2;
		int number = 5;
		for (int i = 0; i < wordArr.length; i++) {
		      str2 = wordArr[i];
		      if (str2.length() == number) {
		        wordArr[i] = str3;
		      }
		    }
		
	}

	
}
