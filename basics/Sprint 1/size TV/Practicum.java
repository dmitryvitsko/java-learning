import java.util.Scanner;

public class Practicum {

    public static void main(String[] args) {
        double cmInInch = 2.54;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размер диагонали в дюймах:");
        double lengthInInch = scanner.nextDouble();
        double lengthInCm = lengthInInch * cmInInch;

        System.out.println("Размер диагонали в сантиметрах: " + lengthInCm);
    }
}