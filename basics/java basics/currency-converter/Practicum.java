public class Practicum {
    public static void main(String[] args) {

        double rateUSD = 81.9;
        double rateEUR = 87.7;
        double rateCNY = 11.49;

        System.out.println("Введите сумму рублей для конвертации:");
        double roubles = NumberReader.getDouble();

        System.out.println("Введите номер валюты, в какую перевести рубли:");
        System.out.println("1 – доллары;");
        System.out.println("2 – евро;");
        System.out.println("3 – юани;");

        int command = NumberReader.getInteger();

        double rate;
        String currencyName;

        if (command == 1) {
            rate = rateUSD;
            currencyName = "долларах";
        } else if (command == 2) {
            rate = rateEUR;
            currencyName = "евро";
        } else if (command == 3) {
            rate = rateCNY;
            currencyName = "юанях";
        } else {
            System.out.println("Такой команды нет.");
            System.out.println("Работа с программой завершена.");
            return;
        }

        double result = roubles / rate;
        if (result < 0) {
            System.out.println("Ошибка: некорректные значения.");
        } else {
            System.out.println("Было введено " + roubles + ", в " + currencyName + " это " + result);
        }

        System.out.println("Работа с программой завершена.");
    }
}