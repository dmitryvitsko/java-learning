import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Пожалуйста, введите сумму перевода в рублях.");
        double sum = scanner.nextDouble();

        boolean isValid = TransactionValidator.isValidAmount(sum);
        if (isValid)
            System.out.println("Спасибо! Ваш перевод на сумму " + sum + " р. успешно выполнен.");
    }
}