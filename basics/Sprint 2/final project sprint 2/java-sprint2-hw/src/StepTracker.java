import java.util.Arrays;
import java.util.Scanner;

public class StepTracker {
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Scanner scanner;
    Converter converter = new Converter();

    public StepTracker(Scanner sc) {
        scanner = sc;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void addNewNumberStepsPerDay() {
        int month = 0;
        int day = 0;
        int steps = -1;

        while (month < 1 || month > 12) {
            System.out.print("Введите номер месяца: ");
            month = scanner.nextInt();
            if (month < 1 || month > 12) {
                System.out.println("Такого месяца нет!");
            }
        }

        while (day < 1 || day > 30) {
            System.out.print("Введите день от 1 до 30 (включительно): ");
            day = scanner.nextInt();
            if (day < 1 || day > 30) {
                System.out.println("Такого дня нет!");
            }
        }

        while (steps <= 0) {
            System.out.print("Введите количество шагов: ");
            steps = scanner.nextInt();
            if (steps <= 0) {
                System.out.println("Отрицательного количества шагов либо ноль шагов быть не может!");
            }
        }

        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;
    }

    public void changeStepGoal() {
        int newGoalByStepsPerDay = 0;
        while (newGoalByStepsPerDay <= 0) {
            System.out.print("Введите цель шагов за день: ");
            newGoalByStepsPerDay = scanner.nextInt();
            if (newGoalByStepsPerDay <= 0) {
                System.out.println("Цель шагов за день должна быть явно больше!");
            }
            goalByStepsPerDay = newGoalByStepsPerDay;
        }
    }

    public void printStatistic() {
        System.out.println("Введите номер месяца, где 1 - Январь, 2 - Февраль, 3 - Март, 4 - Апрель, 5 - Май, 6 - Июнь,\n" + "7 - Июль, 8 - Август, 9 - Сентябрь, 10 - Октябрь, 11 - Ноябрь, 12 - Декабрь");
        int sc = scanner.nextInt();
        int monthData = sc - 1;
        MonthData currentMonth = monthToData[monthData];

        int sumStepsMonth = currentMonth.sumStepsFromMonth();
        int maxStepsMonth = currentMonth.maxSteps();
        int countDaysSteps = 0;

        for (int i = 0; i < currentMonth.days.length; i++) {
            if (currentMonth.days[i] != 0) {
                countDaysSteps++;
            }
        }

        if (countDaysSteps == 0) {
            System.out.println("В этом месяце статистики нет");
        } else {
            int averageSteps = sumStepsMonth / 30;
            int stepsToKilometer = converter.convertToKm(sumStepsMonth);
            int stepsToKilokalories = converter.convertStepsToKilocalories(sumStepsMonth);
            int bestSeriesDays = currentMonth.bestSeries(goalByStepsPerDay);

            System.out.println("Количество пройденных шагов по дням: ");
            currentMonth.printDaysAndStepsFromMonth();
            System.out.println("*** Общее количество шагов за месяц: " + sumStepsMonth);
            System.out.println("*** Максимальное пройденное количество шагов за месяц: " + maxStepsMonth);
            System.out.println("*** Среднее количество шагов: " + averageSteps);
            System.out.println("*** Пройденная дистанция (в км): " + stepsToKilometer + " км");
            System.out.println("*** Количество сожжённых килокалорий: " + stepsToKilokalories + " килокалорий");
            System.out.println("*** Лучшая серия: " + bestSeriesDays + " дней");
            System.out.println();
        }
    }
}
