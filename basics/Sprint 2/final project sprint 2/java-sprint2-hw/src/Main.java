import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        boolean flag = true;

        while (flag) {

            printMenu();

            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                case 2:
                    stepTracker.changeStepGoal();
                    break;
                case 3:
                    stepTracker.printStatistic();
                    break;
                case 4:
                    System.out.println("Программа завершена!");
                    flag = false;
                    break;
                default:
                    System.out.println("Такой команды нет.");
                    break;
            }
        }
    }

    static void printMenu() {
        System.out.println("Введите код команды: ");
        System.out.println("1. - ввести количество шагов за определённый день");
        System.out.println("2. - изменить цель по количеству шагов в день");
        System.out.println("3. - напечатать статистику за определённый месяц");
        System.out.println("4. - выйти из приложения");
    }
}