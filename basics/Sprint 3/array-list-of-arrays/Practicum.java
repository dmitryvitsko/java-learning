import java.util.ArrayList;

public class Praktikum {
    public static void main(String[] args) {
        ArrayList<int[]> list = new ArrayList<>();

        // добавьте массивы разной длины
        list.add(new int[]{1, 2, 3});
        list.add(new int[]{10, 20});
        list.add(new int[]{5, 6, 7, 8});

        for (int[] arr: list) {
            if (arr.length > 0) {
                System.out.print(arr[0]);
                for (int i = 1; i < arr.length; i++) {
                    System.out.print("," + arr[i]);
                }
            }
            System.out.println();
        }
    }
}