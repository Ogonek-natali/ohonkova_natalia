package ua.khpi.oop.Ohonkova07;

public class Lab07 {
	  public static void main(String[] args) {
	        Container contains = new Container();
	        Store rec1 = new Store();
	        Store rec2 = new Store();
	        rec1.generateProducts();
	        contains.add(rec1);
	        System.out.println("\n");
	        rec2.generateProducts();
	        contains.add(rec2);
	        contains.show();
	    }
	}
