package ua.khpi.oop.Ohonkova10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import ua.khpi.oop.Ohonkova10.Store;

public class Container<T extends Store> implements Linked<T>, Serializable {

	
    public Container() {
        head = new Node<>(null, null, tail);
        tail = new Node<>(null, head, null);
        head = new Node<>(null, null, tail);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < size;
            }

            @Override
            public T next() {
                if (this.hasNext()) {
                    return getElementByIndex(position++);
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    @Override
    public boolean notEmpty() {
        return size > 0;
    }

    @Override
    public void clear() {
        for (Node<T> x = head; x != null; ) {
            Node<T> next = x.nextElem;
            x.currentElem = null;
            x.nextElem = null;
            x.prevElem = null;
            x = next;
        }
        head = null;
        tail = null;
        tail = new Node<>(null, head, null);
        head = new Node<>(null, null, tail);
        size = 0;
    }

    @Override
    public void add(final T obj) {
        addLast(obj);
    }

    @Override
    public void saveAll() {
        try {
            File file = new File("save.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            System.out.println();
            pw.println(size);
            for (int i = 0; i < size; i++) {
                pw.println(getElementByIndex(i));
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }
    
    public void saveIn(Linked<T> obj) throws IOException {
        FileOutputStream file = new FileOutputStream("save.natacha");
        ObjectOutputStream object = new ObjectOutputStream(file);
        object.writeObject(obj);
        object.close();
    }
    
    @Override
    public void saveRec() {
        try {
            File file = new File("save.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            Store temp;
            System.out.println();
            pw.println(size);
            for (int i = 0; i < size; i++) {
                temp = (Store) getElementByIndex(i);
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

    @Override
    public void readAll() {
        try (BufferedReader br = new BufferedReader(new FileReader("save.txt"))) {
            Object temp;
            String line;
            line = br.readLine();
            int count = Integer.parseInt(line);
            for (int i = 0; i < count; i++) {
                line = br.readLine();
                temp = line;
                add((T) temp);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void readRec() throws IOException {
    	BufferedReader br = null;
        Store temp = new Store();
        try {
            br = new BufferedReader(new FileReader("1.txt"));
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
                add((T) new Store(temp));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            br.close();
        }
    }
        
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> temp = head; i < size; temp = temp.nextElem) {
            result[i++] = temp.currentElem;
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    private Node<T> head; //первый элемент
    private Node<T> tail; //последний элемент
    private int size = 0; //размер списка


    @Override
    public void addLast(final T obj) {
        Node<T> prev = tail; //сохранение данных хвоста
        prev.setCurrentElem(obj); //установка значения
        tail = new Node<>(null, prev, null); //изменение указателя хвоста
        prev.setNextElem(tail); //установка указателя на хвост
        size++; //увелечение размера списка
    }

    @Override
    public void addFirst(final T obj) {
        Node<T> next = head;
        next.setCurrentElem(obj);
        head = new Node<>(null, null, next);
        next.setPrevElem(head);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getElementByIndex(final int index) {
        Node<T> target = head.getNextElem(); //следующий элемент первого узла
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target.getCurrentElem();
    }
    //head-null&tail-null
    //null<-prevElem[head(t=null)]nextElem->&prevElem[head(t=null)]nextElem->null
    private Node<T> getNextElement(final Node<T> index) {
        return index.getNextElem();
    }

    // head -> null & tail -> null
    // null <- prevElem [head(t = null)] nextElem-> & <- prevElem [head(t = null)] nextElem -> null
    private class Node<T> implements Serializable {
        private T currentElem; //текущий
        private Node<T> prevElem; //предыдущий
        private Node<T> nextElem; //следующий

        //конструктор копирования
        Node(final T currentElem, final Node<T> prevElem, final Node<T> nextElem) {
            this.currentElem = currentElem;
            this.prevElem = prevElem;
            this.nextElem = nextElem;
        }

        
        public T getCurrentElem() {
            return currentElem;
        }

        public void setCurrentElem(final T currentElem) {
            this.currentElem = currentElem;
        }

        public Node<T> getPrevElem() {
            return prevElem;
        }

        public void setPrevElem(final Node<T> prevElem) {
            this.prevElem = prevElem;
        }

        public Node<T> getNextElem() {
            return nextElem;
        }

        public void setNextElem(final Node<T> nextElem) {
            this.nextElem = nextElem;
        }
    }
}