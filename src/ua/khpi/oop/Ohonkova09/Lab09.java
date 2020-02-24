package ua.khpi.oop.Ohonkova1;

import java.io.IOException;

import ua.khpi.oop.Ohonkova1.Container;
import ua.khpi.oop.Ohonkova1.Store;

public class Lab09 {
	public static void main(String[] args) throws IOException {
		Store temp = new Store();
		Container<Store> container = new Container<>();
		temp.generateProducts();

		System.out.println(container.size());
		container.add(temp);
		System.out.println(container.size());
		container.readRec();
		System.out.println("==================");

		int counter = 0;
		for (Store s : container) {
			System.out.println("#" + ++counter);
			System.out.println(s);
		}
		System.out.println("==================");
		System.out.println(container.size());
		System.out.println("==================");
		container.saveIn(container);
		System.out.println(container.getElementByIndex(0));
		container.clear();
		System.out.println(container.size());
	}

}