public class Main {

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private String gradeToString(String grade) {
        switch (grade) {
            case "5": {
                return "Безупречно";
            }
            case "4": {
                return "Потрясающе";
            }
            case "3": {
                return "Восхитительно";
            }
            case "2": {
                return "Прекрасно";
            }
            default:
                return "Очаровательно";
        }
    }

    public void gradeBeautifier(String grades) {
        String[] array = grades.split(";");

        for (String str : array) {
            String[] secondArray = str.split(",");
            String name = capitalize(secondArray[0]);
            String surname = capitalize(secondArray[1]);
            String discipline = secondArray[2].toLowerCase();
            String grade = gradeToString(secondArray[3]);
            String dash = "—";
            System.out.println(String.join(" ", name, surname, discipline, dash, grade));
        }
    }
}