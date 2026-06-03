public class Practicum {
    public static void main(String[] args) {

        int flatsNumber = 5; // количество квартир на этаже
        int floorsNumber = 10; // количество этажей

        for(int i = 1; i <= floorsNumber; i++) {
            for(int j = 1; j <= flatsNumber; j++) {
                int currentFlat = (i - 1) * flatsNumber + j;
                System.out.println("Этаж " + i + " квартира " + currentFlat + " — доставлено.");
            }
        }
    }
}