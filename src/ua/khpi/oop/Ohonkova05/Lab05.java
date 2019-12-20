package ua.khpi.oop.Ohonkova05;
import java.util.Arrays;
import java.util.Scanner;

import ua.khpi.oop.Ohonkova05.Container.IteratorMine;

import static ua.khpi.oop.Ohonkova04.Func.*;

public class Lab05 {
  /**
    * @author  NATALIA
    * @version 4.0
    * Here start point of the program
    * Function in which menu actions are performed
    * until the user presses exit program does not end
    * 
    * */
  public static void main(String[] args) {
    Container container = new Container();
        String str3;
        str3 = Func.InitializeString();
        Func.ShowString(str3);
        String str1 = "Hello my friend.";
        System.out.println();
        container.aDDBack(str1);
        container.aDDBack(str1);
        container.aDDBack(str1);
        System.out.println("\n");
        System.out.println("Show Array: ");
        container.showArray();
        System.out.println("\n\n\n");
        container.ChangeText(str1, str3);
        System.out.println(container.arrayToStr());
        System.out.println("\nWrite with iterator: ");
        IteratorMine iter = (IteratorMine) container.iterator();//перемещаться по элементам
        for (String s : container) {
            System.out.println(s);
        }
            iter.next();
            iter.remove();
        System.out.println("\n");
        System.out.println("Show new Array: ");
        container.showArray();
        int size = container.getSize();
        System.out.println("\n");
        System.out.println("Size of Array: " + size);
  }
}