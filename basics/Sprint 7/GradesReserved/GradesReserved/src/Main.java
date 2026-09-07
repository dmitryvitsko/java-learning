public class Main {
    static void main() {
        String[] arrayMain = new String[3];
        arrayMain[0] = "Вероника Чехова физика — Безупречно";
        arrayMain[1] = "Анна Строкова математика — Потрясающе";
        arrayMain[2] = "Иван Петров геометрия — Безупречно";

        System.out.println(serializeGrades(arrayMain));
    }

    private static String gradeStringToInt(String grade) {
        switch (grade) {
            case "Безупречно": {
                return "5";
            }
            case "Потрясающе": {
                return "4";
            }
            case "Восхитительно": {
                return "3";
            }
            case "Прекрасно": {
                return "2";
            }
            default:
                return "1";
        }
    }

    public static String serializeGrades(String[] grades) {
        StringBuilder builder = new StringBuilder();
        for (String str : grades) {
            String strWithoutDash = str.replace("— ", "");
            String[] arr = strWithoutDash.split(" ");
            arr[0] = arr[0].toLowerCase();
            arr[1] = arr[1].toLowerCase();
            arr[3] = gradeStringToInt(arr[3]);
            builder.append(String.join(",", arr)).append(";");
        }
        return builder.toString();
    }
}