import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<String> passengerNames = List.of(
            "Василий Петров",
            "Анна Ягирская",
            "Виктория Сотова",
            "Игорь Серов",
            "Людмила Ульянова"
    );

    public static void main(String[] args) {
        Map<String, Integer> seats = assignSeats(passengerNames);
        System.out.println("Места пассажиров: " + seats);
    }

    public static Map<String, Integer> assignSeats(List<String> passengerNames) {

        Map<String, Integer> seatsOfPassanger = new HashMap<>();

        for (int i = 0; i < passengerNames.size(); i++) {
            seatsOfPassanger.put(passengerNames.get(i), i);
        }

        return seatsOfPassanger;
    }
}