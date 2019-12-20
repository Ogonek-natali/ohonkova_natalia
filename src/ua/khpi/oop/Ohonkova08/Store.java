package ua.khpi.oop.Ohonkova08;

import java.util.Scanner;

class Store {
    private String name;
    private String unit;
    private int count;
    private int unit_price;

    private String data_of_receipt;
    private String attribute;
    private String value;
   
    Store() {
    	name = null;
    	unit =  null;
    	count = 0;
    	unit_price = 0;
    	data_of_receipt = null;
    	attribute = null;
    	value = null;
    
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
    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setUnitPrice(int unit_price) {
        this.unit_price = unit_price;
    }
    
    public void setDataOfReceipt(String data_of_receipt) {
        this.data_of_receipt = data_of_receipt;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
    
    public void setValue(String value) {
        this.value = value;
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
}