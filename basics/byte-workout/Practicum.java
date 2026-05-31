public class Practicum {
    public static void main(String[] args) {

        int circles = 5;
        String press = "Качаем пресс";
        String running = "Бегаем в колесе";
        String pushUps = "Отжимаемся";

        for (int i = 1; i <= 5; i++) {
            System.out.println("Круг " + i);
            if (i % 2 == 0) System.out.println(press);
            else System.out.println(pushUps);
            System.out.println(running);
        }

        System.out.println("Отлично позанимались сегодня! Вы молодец!");
    }
}