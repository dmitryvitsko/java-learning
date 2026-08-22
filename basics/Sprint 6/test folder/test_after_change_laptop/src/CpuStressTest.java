import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CpuStressTest {

    private static final int LIMIT = 10_000_000; // Диапазон поиска чисел

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("=== СТРЕСС-ТЕСТ ПРОЦЕССОРА НА JAVA ===");
        System.out.println("Процессор видит потоков: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Ищем простые числа от 1 до " + LIMIT + "...\n");

        // 1. Однопоточный тест
        System.out.println("[1/2] Запуск на ОДНОМ потоке...");
        long startSingle = System.currentTimeMillis();
        long countSingle = countPrimesSequentially(LIMIT);
        long durationSingle = System.currentTimeMillis() - startSingle;
        System.out.println(">> Найдено чисел: " + countSingle);
        System.out.println(">> Время на одном ядре: " + durationSingle + " мс\n");

        // 2. Многопоточный тест (на всю мощность)
        System.out.println("[2/2] Запуск на ВСЕХ доступных потоках...");
        long startMulti = System.currentTimeMillis();
        long countMulti = countPrimesParallel(LIMIT);
        long durationMulti = System.currentTimeMillis() - startMulti;
        System.out.println(">> Найдено чисел: " + countMulti);
        System.out.println(">> Время на всех ядрах: " + durationMulti + " мс\n");

        // Итог
        double acceleration = (double) durationSingle / durationMulti;
        System.out.printf("=== ИТОГ: Многопоточность ускорила вычисления в %.2f раз! ===\n", acceleration);
    }

    // Метод проверки числа на простоту (умышленно не самый оптимальный для нагрузки CPU)
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Однопоточный перебор
    private static long countPrimesSequentially(int limit) {
        long count = 0;
        for (int i = 1; i <= limit; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    // Многопоточный перебор (разделение задачи на пулл потоков)
    private static long countPrimesParallel(int limit) throws InterruptedException, ExecutionException {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        List<Future<Long>> results = new ArrayList<>();

        int chunkSize = limit / cores;

        for (int i = 0; i < cores; i++) {
            final int start = i * chunkSize + 1;
            final int end = (i == cores - 1) ? limit : (start + chunkSize - 1);

            results.add(executor.submit(() -> {
                long chunkCount = 0;
                for (int k = start; k <= end; k++) {
                    if (isPrime(k)) chunkCount++;
                }
                return chunkCount;
            }));
        }

        long totalCount = 0;
        for (Future<Long> result : results) {
            totalCount += result.get();
        }

        executor.shutdown();
        return totalCount;
    }
}
