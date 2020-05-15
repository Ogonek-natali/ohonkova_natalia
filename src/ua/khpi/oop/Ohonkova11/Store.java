package ua.khpi.oop.Ohonkova11;

import java.io.Serializable;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ua.khpi.oop.Ohonkova11.Store;

public class Store implements Serializable{
    private String name;
    private String unit;
    private int count;
    private int unit_price;

    private String data_of_receipt;
    private String attribute;
    private String value;
   
   Store() {
    	name = "lemon";
    	unit =  "kg";
    	count = 50;
    	unit_price = 95;
    	data_of_receipt = "20.12.2020";
    	attribute = "tasty";
    	value = "fruits";
    
    }
   
    Store (final Store obj) {
    	name = obj.name;
    	unit =  obj.unit;
    	count = obj.count;
    	unit_price = obj.unit_price;
    	data_of_receipt = obj.data_of_receipt;
    	attribute = obj.attribute;
    	value = obj.value;
    	
    }

  
    public void setAttribute(String attribute) {
        if (checkAttribute(attribute)) {
            this.attribute = attribute;
        } else {
            throw new InputMismatchException();
        }
    }

    
    private boolean checkAttribute(final String attribute) {
        Pattern pattern = Pattern.compile("[\\s\\w%$+#@^()=!_\\\\-]*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(attribute);
        return matcher.matches();
    }

    
    public void setName(String name) {
        if (checkName(name)) {
            this.name = name;
        } else {
            throw new InputMismatchException();
        }
	}

    private boolean checkName(final String name) {
        Pattern pattern = Pattern.compile("[a-z]*-?\\s?", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public void setUnit(String unit) {
        if (checkUnit(unit)) {
            this.unit = unit;
        } else {
            throw new InputMismatchException();
        }
	}

    private boolean checkUnit(final String unit) {
        Pattern pattern = Pattern.compile("[\\s\\w%$+#@^()=!_\\\\-]*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(unit);
        return matcher.matches();
    }

    public void setValue(String value) {
        if (checkValue(value)) {
            this.value = value;
        } else {
            throw new InputMismatchException();
        }
    }

    private boolean checkValue(final String value) {
        Pattern pattern = Pattern.compile("[a-z]*-?\\s?", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
    
    public void setDataOfReceipt(String data_of_receipt) {
        if (checkDataOfReceipt(data_of_receipt)) {
            this.data_of_receipt = data_of_receipt;
        } else {
            throw new InputMismatchException();
        }
    }

    private boolean checkDataOfReceipt(final String data_of_receipt) {
        Pattern pattern = Pattern.compile("[0-9]{2}.[0-9]{2}.[0-9]{4}");
        Matcher matcher = pattern.matcher(data_of_receipt);
        return matcher.matches();
    }
    
    
    
    public void setUnitPrice(int unit_price) {
        this.unit_price = unit_price;
    }
    public void setCount(int count) {
        this.count = count;
    }
   
    
    public String getName() {
        return name;
    }
    public String getUnit() {
            return unit;
    }
    public int getCount() {
            return count;
    }
    public int getUnitPrice() {
            return unit_price;
    }
    public String getDataOfReceipt() {
            return data_of_receipt;
    }
    public String getAttribute() {
            return attribute;
    }
    public String getValue() {
            return value;
    }
	

    void generateProducts() {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        int choose = 0;
        System.out.print("¬ведите название товара: ");
        name = scan2.nextLine();
        System.out.print("¬ведите единицу измирени€: ");
        unit = scan2.nextLine();
        System.out.print("¬ведите количество товара: ");
        count = scan.nextInt();
        System.out.print("¬ведите цену за единицу товара: ");
        unit_price = scan.nextInt();
        System.out.print("¬ведите дату получени€: ");
        data_of_receipt = scan2.nextLine();
        System.out.print("—войства: ");
        attribute = scan2.nextLine();
        System.out.print("«начение: ");
        value = scan2.nextLine();
       
    }


	@Override
	public String toString() {
	      return "Name = " + name + "\n" +"Unit = " + unit +"\n" + "Count = "
	          + count + "\n" +"Unit_price = " + unit_price + "\n" +"Data_of_receipt = " + data_of_receipt + "\n" + "Attribute = " 
	          + attribute + "\n" +"Value = " + value;
	    }
	    //компоратор - это функци€ дл€ сравнени€ обьектов по определенному полю в контейнере
	    //используетс€ в встроенном методе sort
		public static final Comparator<Store> compareByProducts = new Comparator<Store>() {
	        @Override
	        public int compare(Store o1, Store o2) {
	            return o1.getName().compareTo(o2.getName());
	        }
	    };
	    public static final Comparator<Store> compareByPrice = new Comparator<Store>() {
	        @Override
	        public int compare(Store o1, Store o2) {
	            return o1.getUnitPrice() - o2.getUnitPrice();
	        }
	    };
	    public static final Comparator<Store> compareByDate = new Comparator<Store>() {
	        @Override
	        public int compare(Store o1, Store o2) {
	            return o1.getDataOfReceipt().compareTo(o2.getDataOfReceipt());
	        }
	    };
    
    
}