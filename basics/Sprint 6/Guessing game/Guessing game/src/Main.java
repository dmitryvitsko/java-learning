import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int target = random.nextInt(1000) + 1;
        System.out.println("Я загадал число. Попробуйте угадать!");

        Scanner s = new Scanner(System.in);
        int userGuess = -1;

        while (userGuess != target) {
            int guess = s.nextInt();
            if (guess == target) {
                System.out.println("Правильный ответ");
                userGuess = guess;
            } else if (guess > target) {
                System.out.println("Ваше число больше");
            }  else if (guess < target) {
                System.out.println("Ваше число меньше");
            }
        }
    }
}