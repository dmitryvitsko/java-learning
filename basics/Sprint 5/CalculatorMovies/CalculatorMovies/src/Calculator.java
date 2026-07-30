import java.util.List;

public class Calculator {

    private Calculator() {}

    public static double calculate(List<MediaItem> mediaItems) {
        double sumDays = 0;

        for(MediaItem el : mediaItems) {
            if (el instanceof Movie) {
                sumDays += (double) el.getRuntime();
            } else {
                Series series = (Series) el;
                sumDays += (double) (series.getSeriesCount() * el.getRuntime());
            }
        }
        return sumDays / 1440;
    }
}