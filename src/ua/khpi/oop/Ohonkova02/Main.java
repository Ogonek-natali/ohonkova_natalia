package ua.khpi.oop.Ohonkova02;
import java.util.Random;
public class Main {
	public static int Func1(int a,int b) {
        while (b !=0) {
            int res = a%b;
            a = b;
            b = res;
        }
        return a;
    }
	public static void main(String[]args) {
		Random rnd = new Random(System.currentTimeMillis()); // Инициализируем генератор
		for (int i = 1; i<=10; i++) {
			int num1 = 1 + rnd.nextInt(100 - 1 + 1); // Получаем случайное число в диапазоне от 1 до 20 (включительно)
			int num2 = 1 + rnd.nextInt(100 - 1 + 1);
				if(num1>num2)
				{
					System.out.println(i + ". divider " + num1 + " and " + num2 + " = " + Func1(num1, num2));
				} else if (num2>num1)
				{
					System.out.println(i + ". divider " + num1 + " and " + num2 + " = " + Func1(num2, num1));
				}	
		}
	}
}
