import java.util.ArrayList;

public class LostAndFoundOffice {

    ArrayList<Object> things = new ArrayList<>();

    public void put(Object object) {
        things.add(object);
    }

    public boolean check(Object object) {
        return things.contains(object);
    }
}