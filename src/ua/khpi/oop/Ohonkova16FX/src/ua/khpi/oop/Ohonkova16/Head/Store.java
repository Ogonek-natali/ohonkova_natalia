package ua.khpi.oop.Ohonkova16.Head;

import java.io.Serializable;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store implements Serializable {
    private String name;
    private String unit;
    private int count;
    private int unit_price;

    private String data_of_receipt;
    private String attribute;
    private String value;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Store() {
        name = null;
        unit =  null;
        count = 0;
        unit_price = 0;
        data_of_receipt = null;
        attribute = null;
        value = null;
        id = (int) (Math.random() * 9999);
    }
    
    public Store(final Store obj) {
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


    public void generateProducts() {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        int choose = 0;
        System.out.print("Введите название товара: ");
        name = scan2.nextLine();
        System.out.print("Введите единицу измирения: ");
        unit = scan2.nextLine();
        System.out.print("Введите количество товара: ");
        count = scan.nextInt();
        System.out.print("Введите цену за единицу товара: ");
        unit_price = scan.nextInt();
        System.out.print("Введите дату получения: ");
        data_of_receipt = scan2.nextLine();
        System.out.print("Свойства: ");
        attribute = scan2.nextLine();
        System.out.print("Значение: ");
        value = scan2.nextLine();

    }


    @Override
    public String toString() {
        return "Name = " + name + "\n" +"Unit = " + unit +"\n" + "Count = "
                + count + "\n" +"Unit_price = " + unit_price + "\n" +"Data_of_receipt = " + data_of_receipt + "\n" + "Attribute = "
                + attribute + "\n" +"Value = " + value;
    }

    public static final Comparator<Store> compareByProducts = Comparator.comparing(Store::getName);
    public static final Comparator<Store> compareByPrice = Comparator.comparingInt(Store::getUnitPrice);
    public static final Comparator<Store> compareByDate = Comparator.comparing(Store::getDataOfReceipt);
    
    
}
