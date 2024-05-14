import java.util.Random;

public class NewMain {

    // Метод для сортування масиву низхідним злиттям
    public static void mergeSortDescending(int[] array) {
        if (array.length <= 1) return;

        int middle = array.length / 2;
        int[] left = new int[middle];
        int[] right = new int[array.length - middle];
        System.arraycopy(array, 0, left, 0, middle);
        System.arraycopy(array, middle, right, 0, array.length - middle);

        mergeSortDescending(left);
        mergeSortDescending(right);

        mergeDescending(array, left, right);
    }

    // Метод для об'єднання двох підмасивів
    private static void mergeDescending(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] >= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    // Метод для сортування масиву висхідним злиттям
    public static void mergeSortAscending(int[] array) {
        if (array.length <= 1) return;

        int middle = array.length / 2;
        int[] left = new int[middle];
        int[] right = new int[array.length - middle];
        System.arraycopy(array, 0, left, 0, middle);
        System.arraycopy(array, middle, right, 0, array.length - middle);

        mergeSortAscending(left);
        mergeSortAscending(right);

        mergeAscending(array, left, right);
    }

    // Метод для об'єднання двох підмасивів
    private static void mergeAscending(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] array;
        double totalDurationDescending;
        double totalDurationAscending;
        int numTrials = 5; // Кількість прогонів для кожного алгоритму

        // Генерація та сортування масиву у зростаючому порядку
        array = generateSortedArray(10000);
        totalDurationDescending = 0;
        totalDurationAscending = 0;

        for (int i = 0; i < numTrials; i++) {
            int[] clonedArray = array.clone();

            double startTime = System.nanoTime();
            mergeSortDescending(clonedArray);
            double endTime = System.nanoTime();
            totalDurationDescending += (endTime - startTime);

            clonedArray = array.clone();

            startTime = System.nanoTime();
            mergeSortAscending(clonedArray);
            endTime = System.nanoTime();
            totalDurationAscending += (endTime - startTime);
        }

        double averageDurationDescending = totalDurationDescending / numTrials;
        double averageDurationAscending = totalDurationAscending / numTrials;

        System.out.println("Середній час виконання низхідного сортування (зростаючий масив): " + averageDurationDescending + " наносекунд");
        System.out.println("Середній час виконання висхідного сортування (зростаючий масив): " + averageDurationAscending + " наносекунд");

        // Генерація та сортування масиву у спадаючому порядку
        array = generateSortedArrayDescending(10000);
        totalDurationDescending = 0;
        totalDurationAscending = 0;

        for (int i = 0; i < numTrials; i++) {
            int[] clonedArray = array.clone();

            double startTime = System.nanoTime();
            mergeSortDescending(clonedArray);
            double endTime = System.nanoTime();
            totalDurationDescending += (endTime - startTime);

            clonedArray = array.clone();

            startTime = System.nanoTime();
            mergeSortAscending(clonedArray);
            endTime = System.nanoTime();
            totalDurationAscending += (endTime - startTime);
        }

        averageDurationDescending = totalDurationDescending / numTrials;
        averageDurationAscending = totalDurationAscending / numTrials;

        System.out.println("Середній час виконання низхідного сортування (спадаючий масив): " + averageDurationDescending + " наносекунд");
        System.out.println("Середній час виконання висхідного сортування (спадаючий масив): " + averageDurationAscending + " наносекунд");

        // Генерація та сортування масиву у змішаному порядку
        array = generateArray(10000);
        totalDurationDescending = 0;
        totalDurationAscending = 0;

        for (int i = 0; i < numTrials; i++) {
            int[] clonedArray = array.clone();

            double startTime = System.nanoTime();
            mergeSortDescending(clonedArray);
            double endTime = System.nanoTime();
            totalDurationDescending += (endTime - startTime);

            clonedArray = array.clone();

            startTime = System.nanoTime();
            mergeSortAscending(clonedArray);
            endTime = System.nanoTime();
            totalDurationAscending += (endTime - startTime);
        }

        averageDurationDescending = totalDurationDescending / numTrials;
        averageDurationAscending = totalDurationAscending / numTrials;

        System.out.println("Середній час виконання низхідного сортування (змішаний масив): " + averageDurationDescending + " наносекунд");
        System.out.println("Середній час виконання висхідного сортування (змішаний масив): " + averageDurationAscending + " наносекунд");
    }


    // Метод для створення масиву, що відсортований у зростаючому порядку
    public static int[] generateSortedArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = i;
        }
        return array;
    }
    public static int[] FillArrayAscendingDescending(int size)
    {
        int[] array = new int[size];
        int half = size / 2;

        // Заповнення першої половини масиву числами у зростаючому порядку
        for (int i = 0; i < half; i++)
        {
            array[i] = i + 1;
        }

        // Заповнення другої половини масиву числами у спадаючому порядку
        for (int i = half, j = size; i < size; i++, j--)
        {
            array[i] = j;
        }

        return array;
    }
    public static int[] generateSortedArrayDescending(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = length - i;
        }
        return array;
    }
    public static int[] generateArray(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(1000); // Генеруємо випадкове число в діапазоні від 0 до 999
        }
        return array;
    }

}

