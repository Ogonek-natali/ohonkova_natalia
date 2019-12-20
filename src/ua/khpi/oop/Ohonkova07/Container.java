package ua.khpi.oop.Ohonkova07;

import java.util.Arrays;

class Container {

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
}