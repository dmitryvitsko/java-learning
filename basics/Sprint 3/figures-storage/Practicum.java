import java.util.ArrayList;

public class Main {
    public static ArrayList<int[]> figures = new ArrayList<>(); // Придумайте тип хранилища фигур

    public static void main(String[] args) {
        addTriangle(3, 4, 5);
        addTriangle(5, 6, 10);
        addRectangle(15, 25);
        addStar5(1, 2, 3, 3, 2);
        addStar5(2, 2, 2, 2, 2);


        for (int[] figure: figures) {
            System.out.print(figure[0]);
            for (int i = 1; i < figure.length; i++) {
                System.out.print(",");
                System.out.print(figure[i]);
            }
            System.out.println();
        }
    }

    public static void addTriangle(int a, int b, int c) {
        int[] tri = {3, a, b, c};
        figures.add(tri);

    }

    public static void addRectangle(int width, int height) {
        int[] rect = {4, width, height};
        figures.add(rect);

    }

    public static void addStar5(int l0, int l1, int l2, int l3, int l4) {
        int[] star = {5, l0, l1, l2, l3, l4};
        figures.add(star);

    }
}