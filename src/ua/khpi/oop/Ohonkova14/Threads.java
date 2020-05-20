package ua.khpi.oop.Ohonkova14;

import ua.khpi.oop.Ohonkova14.Store;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Threads {

    public static class MyTread1 implements Callable<Boolean> 
    {
        Container<Store> container;

        @Override
        public Boolean call() throws InterruptedException {
        	MaxMinUnitPrice();
            return true;
        }

        private void MaxMinUnitPrice() throws InterruptedException 
        {
        	TimeUnit.MILLISECONDS.sleep(10);
            int max = container.getElementByIndex(0).getUnitPrice();
            int min = container.getElementByIndex(0).getUnitPrice();
            for (int i = 0; i < container.size(); i++) {
                if (container.getElementByIndex(i).getUnitPrice() < min) {
                    min = container.getElementByIndex(i).getUnitPrice();
                }
                if (container.getElementByIndex(i).getUnitPrice() > max) {
                    max = container.getElementByIndex(i).getUnitPrice();
                }
            }
            System.out.println("Max unit price = " + max);
            System.out.println("Min unit price = " + min);
        }

        public void set(Container<Store> container) {
            this.container = container;
        }


    }

    public static class MyTread2 implements Callable<Boolean> 
    {
        Container<Store> container;


        private void sumAvgUnitPrice() throws InterruptedException 
        {
        	TimeUnit.MILLISECONDS.sleep(10);
            int sum = 0;
            int avg = 0;
            for (int i = 0; i < container.size(); i++) {
                sum += container.getElementByIndex(i).getUnitPrice();
            }
            avg = sum / container.size();
            System.out.println("Sum unit price = " + sum);
            System.out.println("Avg unite price = " + avg);
        }

        public void set(Container<Store> container) {
            this.container = container;
        }

        @Override
        public Boolean call() throws Exception {
        	sumAvgUnitPrice();
            return true;
        }
    }

    public static class MyTread3 implements Callable<Boolean> 
    {
        public static final int HIGHER_UNIT_PRICE = 1000;
        Container<Store> container;

        @Override
        public Boolean call() throws Exception {
        	countHigherUnitPrice();
            return true;
        }

        private void countHigherUnitPrice() throws InterruptedException 
        {
        	TimeUnit.MILLISECONDS.sleep(10);
            int count = 0;
            for (int i = 0; i < container.size(); i++) {
                if (container.getElementByIndex(i).getUnitPrice() >= HIGHER_UNIT_PRICE) {
                    count++;
                }
            }
            System.out.println("Number of product with higher unit price: " + count);
        }

        public void set(Container<Store> container) {
            this.container = container;
        }
    }
}
