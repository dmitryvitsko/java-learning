import java.util.Scanner;

public class Practicum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int monthNumber;

        while (true) {
            System.out.println("Когда планируется путешествие? Введите номер месяца от 1 до 12.");
            monthNumber = scanner.nextInt();

            if (monthNumber >= 1 && monthNumber <= 12) {
                break;
            } else {
                System.out.println("Некорректный номер месяца. Введите ещё раз.");
            }
        }

        String season;
        if (monthNumber <= 2 || monthNumber == 12) {
            season = "Зима";
        } else if (monthNumber <= 5) {
            season = "Весна";
        } else if (monthNumber <= 8) {
            season = "Лето";
        } else {
            season = "Осень";
        }

        if (season.equals("Лето")) {
            System.out.println("Летом лучше остаться в Москве.");
        } else {
            System.out.println("Укажите стоимость прямых билетов из Москвы в Париж:");
            int ticketMoscowParis = scanner.nextInt();
            System.out.println("Укажите стоимость билетов из Москвы в Париж с пересадкой в Лондоне:");
            int ticketMoscowLondonParis = scanner.nextInt();
            System.out.println("У вас есть британская виза?");
            System.out.println("1 - да, виза есть");
            System.out.println("0 - визы нет");
            int britainVisa = scanner.nextInt();

            if (ticketMoscowParis < ticketMoscowLondonParis) {
                System.out.println("Летим напрямую в Париж!");
            } else if (britainVisa == 1) {
                System.out.println("Летим через Лондон!");
            } else {
                System.out.println("Летим напрямую в Париж!");
            }
        }
    }
}