package ua.khpi.oop.Ohonkova13;

import java.io.IOException;

import ua.khpi.oop.Ohonkova13.UI;

public class Lab13 {
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
