package ua.khpi.oop.Ohonkova16.Container;

import ua.khpi.oop.Ohonkova16.Head.Store;

import java.io.*;
import java.util.LinkedList;

public class Container implements Serializable {

    LinkedList<Store> linkedList = new LinkedList<>();

    public boolean notEmpty() {
        return linkedList.size() > 0;
    }


    public void clear() {
        linkedList.clear();
    }


    public void add(final Store store) {
        addLast(store);
    }


    public void saveAll() {
        try {
            File file = new File("save.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            System.out.println();
            pw.println(linkedList.size());
            for (int i = 0; i < linkedList.size(); i++) {
                pw.println(getElementByIndex(i));
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    public void saveRec() {
        try {
            File file = new File("save.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            Store temp;
            System.out.println();
            pw.println(linkedList.size());
            for (int i = 0; i < linkedList.size(); i++) {
                temp = getElementByIndex(i);
                pw.println(temp.getName());
                pw.println(temp.getUnit());
                pw.println(temp.getCount());
                pw.println(temp.getUnitPrice());
                pw.println(temp.getDataOfReceipt());
                pw.println(temp.getAttribute());
                pw.println(temp.getValue());
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }


    public void readAll() {
        try (BufferedReader br = new BufferedReader(new FileReader("save.txt"))) {
            Object temp;
            String line;
            line = br.readLine();
            int count = Integer.parseInt(line);
            for (int i = 0; i < count; i++) {
                line = br.readLine();
                temp = line;
                add((Store) temp);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void readRec() throws IOException {
        BufferedReader br = null;
        Store temp = new Store();
        try {
            br = new BufferedReader(new FileReader("save.txt"));
            String line;
            line = br.readLine();
            int count = Integer.parseInt(line);
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
                add(new Store(temp));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            br.close();
        }
    }

    public Object[] toArray() {
        return linkedList.toArray();
    }


    public void addLast(final Store obj) {
        linkedList.addLast(obj);
    }


    public void addFirst(final Store obj) {
        linkedList.addFirst(obj);
    }


    public int size() {
        return linkedList.size();
    }

    public Store getElementByIndex(final int index) {
        return linkedList.get(index);
    }

    public void sortProducts() {
        linkedList.sort(Store.compareByProducts);
    }

    public void sortPrice() {
        linkedList.sort(Store.compareByPrice);
    }

    public void sortDate() {
        linkedList.sort(Store.compareByDate);
    }


    public int search(Store obj) {
        int index = 0;
        for (Store store : linkedList) {
            if (store == obj) {
                return index;
            }
        }
        return -1;
    }

    public void saveSerializable() {
        try {
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("save.ser"));
            oo.writeObject(linkedList);
            oo.close();
        } catch (IOException ioe) {
            System.out.println("Error");
        }
    }

    public void readSerializable() {
        try {
            FileInputStream fileInput = new FileInputStream("save.ser");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            LinkedList<Store> temp ;
            temp = (LinkedList<Store>) objectInput.readObject();
            System.out.println(temp);
            objectInput.close();
        } catch (Exception exc) {
            System.out.println("Error");
        }
    }

    public void show() {
        int count = 0;
        for (Store s : linkedList) {
            System.out.println("#" + (++count));
            System.out.println(s.toString());
        }
    }

    public void remove(Store recruitment){
        linkedList.remove(recruitment);
    }


}

