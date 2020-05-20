package ua.khpi.oop.Ohonkova13;

import ua.khpi.oop.Ohonkova13.Container;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.InputMismatchException;

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
    
    public static <T extends Store> String search(Container<T> obj) {
        if (obj.notEmpty()) {
            int count = 0;
            for (Store s : obj) {
                Pattern p1 = Pattern.compile("[a-z]");
                Matcher m1 = p1.matcher(s.getName());
                if (m1.find()) {
                        Pattern p2 = Pattern.compile("[0-9]{2}.[0][4].[0-9]{4}");
                        Matcher m2 = p2.matcher(s.getDataOfReceipt());
                        if (m2.find()) {
                            System.out.println("Products:");
                            System.out.println("№" + (++count));
                            System.out.println(s);
                           
                        }
                    }
                }
            }
        return obj.toString();
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
        System.out.println("10. Search product.");
        System.out.println("0. End of work.");
        System.out.print("Write your choose there: ");
    }
}

