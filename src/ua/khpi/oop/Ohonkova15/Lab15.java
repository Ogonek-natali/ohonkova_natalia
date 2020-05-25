package ua.khpi.oop.Ohonkova15;

import java.io.IOException;

import ua.khpi.oop.Ohonkova15.UI;

public class Lab15 {
	public static void main(String[] args) throws IOException {
		 if (args.length != 0) {
	            if (args[0].equals("-auto")) {
	                UI.auto();
	            } else {
	                System.out.println("Repeat entered with params -auto");
	            }
	        } else {
	            UI.menu();
	        }
	    }
}
