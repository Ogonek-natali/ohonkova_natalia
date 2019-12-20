package ua.khpi.oop.Ohonkova04;
import java.util.Arrays;
import java.util.Scanner;

import static ua.khpi.oop.Ohonkova04.Func.*;

public class Lab04 {
	/**
	  * @author NATALIA
	  * @version 4.0
	  * Here start point of the program
	  * Function in which menu actions are performed
	  * until the user presses exit program does not end
	  * 
	  * */
	public static void main(String[] args) {
        ArgsCMD Arguments = new ArgsCMD(args);
        if (!Arguments.isEmpty()) {
            Arguments.arguments();
        }
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        int choose;
        String str1 = null;
        String str3 = null;
       
        while (loop) {
            ChooseMenu();
            choose = scan.nextInt();
            switch (choose) {
                case 1:
                    if (str1 != null){
                        if (ArgsCMD.DBG)
                        System.out.println("Error! Text shouldn`t be created.");
                        break;
                    }
                    else {
                        if(ArgsCMD.DBG)
                            System.out.println("You choose 1. Creating text");
                        System.out.print("Enter text: ");
                        str1 = InitializeString();
                        break;
                    }
                case 2:
                    if (str1 == null){
                        if(ArgsCMD.DBG) 
                        System.out.println("Error! Text is empty!");
                        break;
                    }
                    else {
                        if (ArgsCMD.DBG) {
                            System.out.println("You choose 2. Showing your text");
                        }
                        
                        ShowString(str1);
                        break;
                    }
                case 3:
                    if (str1 == null){
                        if(ArgsCMD.DBG)
                        System.out.println("Error! Text is empty!");
                        break;
                    }
                    else {
                        if (ArgsCMD.DBG)
                            System.out.println("You choose 3. Input word");
                        System.out.println("\nEnter the word:");
                        str3 = InitializeString();
                        System.out.println("Successfully!");
                        break;
                    }
                case 4:
                    if (str1 == null){
                        if (ArgsCMD.DBG)
                        System.out.println("Error! Text is empty!");
                        break;
                    }
                    else {
                        if (ArgsCMD.DBG)
                            System.out.println("You choose 4. Showing your new text");
                        ChangeText(str1,str3);
                
                        System.out.println("Successfully!");
                        break;
                    }
                case 0:
                    if (ArgsCMD.DBG)
                        System.out.println("You choose 0. End of Work");
                    System.out.println("\n\nThanks for working!");
                    loop = false;
                    break;
                default:
                    System.out.println("Error. Mistake number!");
                    break;
            }
        }
    }

	
}


