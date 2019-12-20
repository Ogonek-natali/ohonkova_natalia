package ua.khpi.oop.Ohonkova08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;

import ua.khpi.oop.Ohonkova08.Store;

class Container implements Serializable {

	 /**
     * First size for array.
     */
    private final int size = 10;
    /**
     * Array contains all data.
     */
    private int count = 0;

    private Store[] mass = new Store[size];


    void add(final Store temp){
    	Store buff = new Store(temp);
        if (count == mass.length) {
            mass = Arrays.copyOf(mass, mass.length * 2);
            mass[count++] = temp;
        } else {
            mass[count++] = temp;
        }
    }

    void show() {  
        if (count == 0) {
            System.out.println("Ошибка! Массив пустой!");
        } else {
            System.out.println();
            for (int i = 0; i < count; i++) {
                System.out.println("Товар №" + (i+1));
                System.out.println("Название: " + mass[i].getName());
                System.out.println("Единица измерения: " + mass[i].getUnit());
                System.out.println("Количество: " + mass[i].getCount());
                System.out.println("Цена за единицу: " + mass[i].getUnitPrice());
                System.out.println("Дата получения: " + mass[i].getDataOfReceipt());
                System.out.println("Свойства: " + mass[i].getAttribute());
                System.out.println("Значение: " + mass[i].getValue());
                System.out.println("\n");
            }
        }
    }


    void clear() {
        for (int i = 0; i < count; i++) {
        	mass[i] = null;
        }
        count = 0;
    }

    public void remove(int index) {
        for (int i = index; i < count; i++) {
        	mass[index++] = mass[i + 1];
        }
        count--;
    }
    

    int size() {
        return count;
    }
    
    void save() {
        try {
            File file = new File("save.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            System.out.println();
            for (int i = 0; i < count; i++) {
                pw.println(count);
                pw.println(mass[i].getName());
                pw.println(mass[i].getUnit());
                pw.println(mass[i].getCount());
                pw.println(mass[i].getUnitPrice());
                pw.println(mass[i].getDataOfReceipt());
                pw.println(mass[i].getAttribute());
                pw.println(mass[i].getValue());
                }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    void save(final String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            System.out.println();
            for (int i = 0; i < count; i++) {
            	pw.println(count);
                pw.println(mass[i].getName());
                pw.println(mass[i].getUnit());
                pw.println(mass[i].getCount());
                pw.println(mass[i].getUnitPrice());
                pw.println(mass[i].getDataOfReceipt());
                pw.println(mass[i].getAttribute());
                pw.println(mass[i].getValue());
                }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    void read() throws IOException {
        BufferedReader br = null;
        Store temp = new Store();
        try {
            br = new BufferedReader(new FileReader("save.txt"));
            String line;
            line = br.readLine();
            count = Integer.parseInt(line);
            for (int i = 0; i < count; i++) {
                line = br.readLine();
                temp.setName(line);
                line = br.readLine();
                temp.setUnit(line);
                line = br.readLine();
                temp.setCount(Integer.parseInt(line));
                line = br.readLine();
                temp.setUnitPrice(Integer.parseInt(line));
                line = br.readLine();
                temp.setDataOfReceipt(line);
                line = br.readLine();
                temp.setAttribute(line);
                line = br.readLine();
                temp.setValue(line);
	           
	            mass[i] = new Store(temp);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            br.close();
        }
    }
}
