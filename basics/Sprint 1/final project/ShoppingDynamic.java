import java.util.Scanner;

public class ShoppingDynamic {

    public static void main(String[] args) {

        System.out.println("Вас приветствует список покупок!");

        int currentListSize = 8;
        String[] shoppingList = new String[currentListSize];
        int productCount = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите одну из команд:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Отобразить список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить программу");

            int actionNumber = scanner.nextInt();

            if (actionNumber == 1) {
                if (productCount == currentListSize) {
                    int newListSize = currentListSize * 2;
                    String[] newShoppingList = new String[newListSize];
                    for (int i = 0; i < shoppingList.length; i++) {
                        newShoppingList[i] = shoppingList[i];
                    }
                    shoppingList = newShoppingList;
                    currentListSize = newShoppingList.length;
                }
                System.out.println("Введите название товара:");
                String productName = scanner.next();
                shoppingList[productCount] = productName;
                productCount++;
                System.out.println("Товар " + productName + " добавлен в список под номером " + productCount);
            } else if (actionNumber == 2) {
                for (int i = 0; i < productCount; i++) {
                    System.out.println(i + 1 + ". " + shoppingList[i]);
                }
            } else if (actionNumber == 3) {
                for (int i = 0; i < productCount; i++) {
                    shoppingList[i] = null;
                }
                productCount = 0;
                System.out.println("Список очищен!");
            } else if (actionNumber == 4) {
                break;
            } else {
                System.out.println("Неизвестная команда!");
            }
        }
    }
}