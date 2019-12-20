package ua.khpi.oop.Ohonkova08;

final class Func {
	
	private Func() {
        //default constructor
    }

    static void chooseMenu() {
        System.out.println("\n\nВыберите вариант:");
        System.out.println("1. Добавить товар");
        System.out.println("2. Показать существующие товары");
        System.out.println("3. Удалить товар");
        System.out.println("4. Очистить список товаров");
        System.out.println("5. Использовать XML");
        System.out.println("6. Работа с файлами");
        System.out.println("0. Завершить работу");
        System.out.print("Выберите: ");
    }

    static void chooseMenuFile() {
        System.out.println("\n\nВыберите вариант:");
        System.out.println("1. Сохранить файл в текущую директорию");
        System.out.println("2. Просмотреть содержание директории");
        System.out.println("3. Просмотреть дерево к файлу");
        System.out.println("4. Сохранить файл в необходимый путь");
        System.out.println("5. Переименовать файл");
        System.out.println("6. Прочитать файл из памяти");
        System.out.println("0. Завершить работу");
        System.out.print("Выберите: ");
    }
}
