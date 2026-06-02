import java.util.Scanner;

class Practicum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Сколько денег у вас осталось до зарплаты?");
        double moneyBeforeSalary = scanner.nextDouble();

        if (moneyBeforeSalary < 3000) {
            System.out.println("Сегодня лучше поесть дома.");
        } else if (moneyBeforeSalary >= 3000 && moneyBeforeSalary < 10000) {
            System.out.println("Можно заказать пиццу!");
        } else if (moneyBeforeSalary >= 10000 && moneyBeforeSalary < 30000) {
            System.out.println("Неплохо! Сегодня можно поужинать в кафе.");
        } else if (moneyBeforeSalary >= 30000) {
            System.out.println("Отлично! Можно сходить в ресторан.");
        }
    }
}