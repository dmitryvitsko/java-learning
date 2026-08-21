import java.util.Comparator;

public class DateTimeComparator implements Comparator<DateTime> {

    @Override
    public int compare(DateTime dt1, DateTime dt2) {
        int result = Integer.compare(dt1.year, dt2.year);
        if (result != 0) return result;

        result = Integer.compare(dt1.month, dt2.month);
        if (result != 0) return result;

        result = Integer.compare(dt1.day, dt2.day);
        if (result != 0) return result;

        result = Integer.compare(dt1.hours, dt2.hours);
        if (result != 0) return result;

        result = Integer.compare(dt1.minutes, dt2.minutes);
        if (result != 0) return result;

        result = Integer.compare(dt1.seconds, dt2.seconds);
        if (result != 0) return result;

        return 0;
    }
}