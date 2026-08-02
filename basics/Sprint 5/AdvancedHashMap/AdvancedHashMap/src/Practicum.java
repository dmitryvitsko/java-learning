import java.util.ArrayList;
import java.util.HashMap;

public class Practicum {
    public static void main(String[] args) {
        AdvancedHashMap<String, Integer, String> timetable = new AdvancedHashMap<>();

        timetable.put("Понедельник", 1, "Русский язык");
        timetable.put("Понедельник", 2, "Математика");
        timetable.put("Вторник", 1, "Физкультура");
        timetable.put("Вторник", 2, "Русский язык");

        System.out.println(timetable.get("Вторник", 1));

        ArrayList<String> mondayLessons = timetable.getAll("Понедельник");
        System.out.println(mondayLessons);
    }

}

class AdvancedHashMap <K1, K2, V> {
    HashMap<K1, HashMap<K2, V>> internalHashMap = new HashMap<>();

    public void put(K1 key1, K2 key2, V value) {
        HashMap<K2, V> innerHashMap = internalHashMap.get(key1);
        if (innerHashMap == null) {
            innerHashMap = new HashMap<>();
        }
        innerHashMap.put(key2, value);
        internalHashMap.put(key1, innerHashMap);
    }

    public V get(K1 key1, K2 key2) {
        HashMap<K2, V> innerHashMap = internalHashMap.get(key1);
        if (innerHashMap == null) {
            return null;
        }
        return innerHashMap.get(key2);
    }

    public ArrayList<V> getAll(K1 key1) {
        HashMap<K2, V> innerHashMap = internalHashMap.get(key1);
        if (innerHashMap == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(innerHashMap.values());
    }
}