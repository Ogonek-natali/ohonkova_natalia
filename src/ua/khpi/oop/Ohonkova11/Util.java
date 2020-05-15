package ua.khpi.oop.Ohonkova11;


import ua.khpi.oop.Ohonkova11.Container;

import java.util.Arrays;

//параметрез. методы
public class Util {
	public static <T extends Store> void sortProducts(Container<T> obj) {
		Store[] array = new Store[obj.size()];
        for (int i = 0; i < obj.size(); i++) {
            array[i] = obj.getElementByIndex(i);
        }
        Arrays.sort(array, Store.compareByProducts);
        obj.clear();
        for (int i = 0; i < array.length; i++) {
            obj.add((T) array[i]);
        }
    }

    public static <T extends Store> void sortPrice(Container<T> obj) {
    	Store[] array = new Store[obj.size()];
        for (int i = 0; i < obj.size(); i++) {
            array[i] = obj.getElementByIndex(i);
        }
        Arrays.sort(array, Store.compareByPrice);
        obj.clear();
        for (int i = 0; i < array.length; i++) {
            obj.add((T) array[i]);
        }
    }

    public static <T extends Store> void sortDate(Container<T> obj) {
    	Store[] array = new Store[obj.size()];
        for (int i = 0; i < obj.size(); i++) {
            array[i] = obj.getElementByIndex(i);
        }
        Arrays.sort(array, Store.compareByDate);
        obj.clear();
        for (int i = 0; i < array.length; i++) {
            obj.add((T) array[i]);
        }
        
    }
    

    public static void chooseMenu() {
        System.out.println();
        System.out.println("1. Add product.");
        System.out.println("2. Show all products.");
        System.out.println("3. Clear container.");
        System.out.println("4. Check elements in container.");
        System.out.println("5. Size of container.");
        System.out.println("6. Get element by index.");
        System.out.println("7. Save data to file.");
        System.out.println("8. Read data from file.");
        System.out.println("9. Sorting data in container.");
        System.out.println("0. End of work.");
        System.out.print("Write your choose there: ");
    }
}
