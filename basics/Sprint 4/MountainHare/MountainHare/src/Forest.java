import java.util.ArrayList;

public class Forest {
    private ArrayList<MountainHare> hares;
    private static String season;

    public Forest(String season) {
        this.season = season;
    }

    public static void setSeason(String newSeason) {
        season = newSeason;
        if (newSeason.equals("Зима")) {
            MountainHare.color = "Белый";
        } else {
            MountainHare.color = "Серо-рыжий";
        }
    }

    public void printHares(ArrayList<MountainHare> hares) {
        for (MountainHare h : hares) {
            System.out.println(h.toString());
        }
    }
}