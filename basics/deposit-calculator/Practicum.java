public class Practicum {
    public static void main(String[] args) {
        double exchangeRateUSD = 94.8;
        double exchangeRateEUR = 103.8;
        double exchangeRateCNY = 13.1;

        double interestRateRUB = 7;
        double interestRateUSD = 1;
        double interestRateEUR = 0.8;
        double interestRateCNY = 1.5;


        System.out.println("Введите номер валюты:");
        System.out.println("1 – рубли;");
        System.out.println("2 – доллары;");
        System.out.println("3 – евро;");
        System.out.println("4 – юани.");

        int currency = NumberReader.getInteger();

        double exchangeRate = 1;
        double interestRate;
        String currencySymbol;

        if (currency == 1) {
            interestRate = interestRateRUB;
            currencySymbol = "RUB";
        } else if (currency == 2) {
            exchangeRate = exchangeRateUSD;
            interestRate = interestRateUSD;
            currencySymbol = "USD";
        } else if (currency == 3) {
            exchangeRate = exchangeRateEUR;
            interestRate = interestRateEUR;
            currencySymbol = "EUR";
        } else if (currency == 4) {
            exchangeRate = exchangeRateCNY;
            interestRate = interestRateCNY;
            currencySymbol = "CNY";
        } else {
            System.out.println("Ошибка: выбрана некорректная валюта. Валюта по умолчанию — рубли.");
            currency = 1;
            interestRate = interestRateRUB;
            currencySymbol = "RUB";
        }

        System.out.println("Введите начальную сумму в выбранной валюте:");
        double amount = NumberReader.getDouble();

        System.out.println("Введите количество лет для расчёта:");
        int years = NumberReader.getInteger();

        for (int i = 1; i <= years; i++) {
            amount = amount + amount * (interestRate / 100);
            if (i % 3 == 0) {
                amount = amount + amount * 0.01;
            }
        }

        System.out.println("К окончанию срока сумма составит: " + amount + " " + currencySymbol);

        if (currency != 1) {
            double roubles = amount * exchangeRate;
            System.out.println("В рублях это будет: " + roubles + " руб.");
        }

        System.out.println("Работа с программой завершена.");
    }
}