package ua.khpi.oop.Ohonkova14;

import java.io.IOException;
import java.util.Scanner;

import ua.khpi.oop.Ohonkova14.Container;
import ua.khpi.oop.Ohonkova14.Store;
import ua.khpi.oop.Ohonkova14.Util;

public class UI {
	public static void auto() throws IOException {
		Store temp = new Store();
		Container<Store> container = new Container<>();
		
		System.out.println(container.size());
	    container.add(temp);
		System.out.println(container.size());
		container.readRec();
		System.out.println("==================");
		
		int counter = 0;
		for (Store s : container) {
			System.out.println("#" + ++counter);
		    System.out.println(s);
		}
		System.out.println("==================");
		System.out.println(container.size());
		System.out.println("==================");
		container.saveIn(container);
		Util.search(container);
        System.out.println("==================");
		System.out.println(container.getElementByIndex(2));
		container.clear();
		System.out.println(container.size());
	}

	public static void menu() throws IOException {
	    System.out.println("It is menu mode");
	    Container<Store> linkedContainer = new Container<>();
	    Store rec1 = new Store();
	    Scanner scan = new Scanner(System.in);
	    boolean loop = true;
	    while (loop) {
	        Util.chooseMenu();
	        int choose = scan.nextInt();
	        switch (choose) {
	            case 1:
	               rec1.generateProducts();
	                linkedContainer.add(rec1);
	                System.out.println("Done!");
	                break;
	            case 2:
	                if (linkedContainer.notEmpty()) {
	                	int count = 0;
	                    for (Store s : linkedContainer) {
	                    	System.out.println();
	                    	System.out.println(++count);
	                        System.out.println(s);
	                    }
	                } else {
	                    System.out.println("List is empty!");
	                }
	                break;
	            case 3:
	                if (linkedContainer.notEmpty()) {
	                    linkedContainer.clear();
	                    System.out.println("Successfully!");
	                } else {
	                    System.out.println("Array is empty!");
	                }
	                break;
	            case 4:
	                if (linkedContainer.notEmpty()) {
	                    System.out.println("Your container have data.");
	                } else {
	                    System.out.println("Your container doesn`t have data.");
	                }
	                break;
	            case 5:
	                    System.out.println("Size of container: " + linkedContainer.size());
	                break;
	            case 6:
	                if (linkedContainer.notEmpty()) {
	                    System.out.print("Entered index from 0 to " + (linkedContainer.size() - 1) + ": ");
	                    int choose1 = scan.nextInt();
	                    if (choose1 > (linkedContainer.size() - 1) || choose1 < 0) {
	                        System.out.println("Repeat enter");
	                    } else {
	                        System.out.println(linkedContainer.getElementByIndex(choose1));
	                    }
	                    break;
	                }
	            case 7:
	                if (linkedContainer.notEmpty()) {
	                    linkedContainer.saveRec();
	                } else {
	                    System.out.println("Your container is empty");
	                }
	                break;
	            case 8:
	                if (linkedContainer.notEmpty()) {
	                    linkedContainer.clear();
	                }
	                linkedContainer.readRec();
	                break;
	            case 9:
	                if (linkedContainer.notEmpty()) {
	                    System.out.println("What field do you want to sort by?");
	                    System.out.println("1. Sort by products");
	                    System.out.println("2. Sort by price");
	                    System.out.println("3. Sort by date");
	                    int choose2 = scan.nextInt();
	                    boolean loop2 = true;
	                    while (loop2) {
	                        switch (choose2) {
	                            case 1:
	                                Util.sortProducts(linkedContainer);
	                                loop2 = false;
	                                break;
	                            case 2:
	                                Util.sortPrice(linkedContainer);
	                                loop2 = false;
	                                break;
	                            case 3:
	                                Util.sortDate(linkedContainer);
	                                loop2 = false;
	                                break;
	                            default:
	                                System.out.println("Wrong number!");
	                                break;
	                        }
	                    }
	                } else {
	                    System.out.println("Your container is empty");
	                }
	                break;
	            case 10:
                    if (linkedContainer.notEmpty()) {
                    	System.out.println("\n");
                        Util.search(linkedContainer);
                    } else {
                        System.out.println("Your container is empty");
                    }
                    break;
	            case 0:
	                System.out.println("Thanks for working!");
	                loop = false;
	                break;
	            default:
	                System.out.println("Wrong number!");
	                break;
	        		}
	    	}
		}
}
