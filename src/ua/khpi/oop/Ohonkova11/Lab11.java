package ua.khpi.oop.Ohonkova11;

import java.io.IOException;

public class Lab11 {
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