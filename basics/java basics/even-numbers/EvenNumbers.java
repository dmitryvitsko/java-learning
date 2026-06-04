public class EvenNumbers {
    public int onlyEvenNumbers(int[] arrNumbers) {
        int sum = 0;
        for (int num : arrNumbers) {
            if (num % 2 == 0) sum += num;
        }
        return sum;
    }
}