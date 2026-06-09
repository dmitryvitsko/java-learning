import java.util.Scanner;

public class Practicum {

    public static void main(String[] args) {
        String[] items1913 = {"Корова", "Курица", "Рубашка", "Шапка гусарская", "Гармонь", "Рояль"};
        String[] items1984 = {"Банка сгущёнки", "Мороженое", "Карта мира", "Кассетный магнитофон", "Пальто осеннее"};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму в современных рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите год (1913 или 1984)");
        int year = scanner.nextInt();

        double koef = -1;

        switch (year) {
            case 1913:
                koef = 1.0 / 884;
                break;
            case 1984:
                koef = 1.0 / 337;
                break;
        }

        if(koef < 0){
            System.out.println("Для этого года у нас нет данных.");
            koef = 0;
        }

        double amountByYear = amount * koef;

        System.out.println("В " + year + " году эта сумма приблизительно равнялась бы "
                + amountByYear + " р. "
                + "На эти деньги вы могли бы купить следующие товары:");

        switch (year) {
            case 1913:
                for (int i = 0; i < items1913.length; i++) {
                    String item = items1913[i];
                    double price = 0.0;
                    switch (item){
                        case "Корова":
                            price = 60.0;
                            break;
                        case "Курица":
                            price = 0.6;
                            break;
                        case "Рубашка":
                            price = 1.0;
                            break;
                        case "Шапка гусарская":
                            price = 12.0;
                            break;
                        case "Гармонь":
                            price = 7.50;
                            break;
                        case "Рояль":
                            price = 200.0;
                            break;
                    }
                    int quantity = (int) (amountByYear / price);
                    if(quantity > 0) {
                        System.out.println(item + " — " + quantity + " шт.");
                    }
                }

                break;
            case 1984:
                for (int i = 0; i < items1984.length; i++) {
                    String item = items1984[i];
                    double price = 0.0;
                    switch (item){
                        case "Банка сгущёнки":
                            price = 0.55;
                            break;
                        case "Мороженое":
                            price = 0.2;
                            break;
                        case "Карта мира":
                            price = 0.54;
                            break;
                        case "Кассетный магнитофон":
                            price = 95.0;
                            break;
                        case "Пальто осеннее":
                            price = 100.0;
                            break;
                    }
                    int quantity = (int) (amountByYear / price);
                    if(quantity > 0) {
                        System.out.println(item + " — " + quantity + " шт.");
                    }
                }
                break;
        }
    }

}