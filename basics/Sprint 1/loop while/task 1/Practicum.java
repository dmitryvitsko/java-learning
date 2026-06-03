import java.util.Scanner;

class Practicum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько денег у вас сейчас: ");
        double balance = scanner.nextDouble(); // ваши сбережения
        int years = 0;

        while (balance < 1000000) {
            balance = balance + balance * 0.05;
            years = years + 1;
        }

        System.out.println("Через " + years + " лет у вас будет миллион!");
    }
}