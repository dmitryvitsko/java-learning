public class Practicum {

    public static void main(String[] args) {
        int money = 500;
        int foodPerDay = 100;
        int days = 0;

        for (int i = money; i > 0; i -= foodPerDay) {
            days += 3;
            System.out.println("На " + days + "-й день останется " + (i - foodPerDay) + " рублей.");
        }

        System.out.println("Денег хватит на " + days + " дней.");
    }
}