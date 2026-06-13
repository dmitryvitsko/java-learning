public class Practicum {

    public static void main(String[] args) {
        String highestGrossingFilm = findHighestGrossingFilm();
        System.out.println("Самый кассовый фильм: " + highestGrossingFilm);
    }

    public static String findHighestGrossingFilm() {
        String film1 = "Титаник";
        int income1 = 2194;

        String film2 = "Аватар";
        int income2 = 2810;

        String film3 = "Тёмный рыцарь";
        int income3 = 1084;

        int[] arrayPrices = {income1, income2, income3};
        String[] arrayNames = {film1, film2, film3};
        int maxPrice = income1;
        int maxIndex = 0;

        for (int i = 0; i < arrayPrices.length; i++) {
            if (maxPrice <= arrayPrices[i]) {
                maxPrice = arrayPrices[i];
                maxIndex = i;
            }
        }
        return arrayNames[maxIndex];
    }
}