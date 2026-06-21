public class Converter {

    public int convertToKm(int steps) {
        return (int) ((steps * 0.75) / 1000);
    }

    public int convertStepsToKilocalories(int steps) {
        return (int) ((steps * 50) / 1000);
    }
}
