import java.util.HashMap;
import java.util.Map;

public class Practicum {
    private Map<String, Integer> orders = new HashMap<>();

    public static void main(String[] args) {
        Practicum pizzeria = new Practicum();
        pizzeria.openPizzeria();
        pizzeria.printStatistics();
    }

    private void openPizzeria() {
        newOrder("Леонардо");
        newOrder("Донателло");
        newOrder("Рафаэль");
        newOrder("Леонардо");
        newOrder("Микеланджело");
        newOrder("Шреддер");
        newOrder("Донателло");
    }

    private void newOrder(String clientName) {
        if (orders.containsKey(clientName)) {
            orders.put(clientName, orders.get(clientName) + 1);
        } else {
            orders.put(clientName, 1);
        }
    }

    private void printStatistics() {

        int sumOrders = 0;

        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            System.out.println("Заказов от " + entry.getKey() + ": " + entry.getValue());
            sumOrders += entry.getValue();
        }
        System.out.println("Всего заказов: " + sumOrders);
    }
}