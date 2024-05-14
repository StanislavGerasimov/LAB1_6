import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Генеруємо масив з 100 чисел
        int[] array = {
                319, 320, 910, 977, 308, 867, 594, 957, 304, 120,
                463, 225, 624, 531, 807, 365, 343, 943, 262, 890,
                497, 274, 439, 965, 291, 340, 739, 749, 238, 116,
                668, 825, 619, 679, 207, 729, 360, 518, 672, 375,
                424, 890, 632, 185, 89, 535, 713, 55, 271, 898,
                146, 435, 862, 377, 333, 850, 860, 749, 22, 485,
                453, 14, 303, 580, 712, 700, 166, 192, 247, 181,
                408, 963, 804, 999, 350, 71, 790, 708, 446, 735,
                371, 173, 669, 310, 199, 261, 303, 418, 875, 595,
                337, 701, 233, 763, 470, 696, 132, 570, 950, 379
        };

        // Виводимо початковий масив
        System.out.println("Початковий масив:");
        //printArray(array);

        // Сортування низхідним злиттям
        System.out.println("Сортування низхідним злиттям:");
        for (int i = 1; i <= 15; i++) {
            System.out.println("\nСортування №" + i + ":");
            double duration = mergeSortAndMeasureTime(array, true);
            System.out.println("Час сортування: " + duration + " мс");
        }

        // Сортування висхідним злиттям
        System.out.println("\nСортування висхідним злиттям:");
        for (int i = 1; i <= 15; i++) {
            System.out.println("\nСортування №" + i + ":");
            double duration = mergeSortAndMeasureTime(array, false);
            System.out.println("Час сортування: " + duration + " мс");
        }
    }

    // Генеруємо випадковий масив заданої довжини
    public static int[] generateArray(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(1000); // Генеруємо випадкове число в діапазоні від 0 до 999
        }
        return array;
    }

    // Метод для вимірювання часу сортування методом злиття
    public static double mergeSortAndMeasureTime(int[] array, boolean descending) {
        double startTime = System.nanoTime();
        if (descending) {
            mergeSortDescending(array, 0, array.length - 1);
        } else {
            mergeSortAscending(array, 0, array.length - 1);
        }
        double endTime = System.nanoTime();
        return (endTime - startTime) / 1000000; // Переводимо час в мілісекунди
    }

    // Рекурсивний метод сортування низхідним злиттям
    public static void mergeSortDescending(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSortDescending(array, left, middle); // Сортуємо ліву половину
            mergeSortDescending(array, middle + 1, right); // Сортуємо праву половину
            mergeDescending(array, left, middle, right); // Об'єднуємо відсортовані половини
        }
    }

    // Рекурсивний метод сортування висхідним злиттям
    public static void mergeSortAscending(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSortAscending(array, left, middle); // Сортуємо ліву половину
            mergeSortAscending(array, middle + 1, right); // Сортуємо праву половину
            mergeAscending(array, left, middle, right); // Об'єднуємо відсортовані половини
        }
    }

    // Метод для об'єднання відсортованих підмасивів низхідним злиттям
    public static void mergeDescending(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Створюємо тимчасові підмасиви
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Копіюємо дані в тимчасові підмасиви
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[middle + 1 + j];
        }

        // Об'єднуємо тимчасові підмасиви
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] >= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Копіюємо залишок елементів з лівого підмасиву (якщо є)
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Копіюємо залишок елементів з правого підмасиву (якщо є)
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Метод для об'єднання відсортованих підмасивів висхідним злиттям
    public static void mergeAscending(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Створюємо тимчасові підмасиви
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Копіюємо дані в тимчасові підмасиви
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[middle + 1 + j];
        }

        // Об'єднуємо тимчасові підмасиви
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Копіюємо залишок елементів з лівого підмасиву (якщо є)
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Копіюємо залишок елементів з правого підмасиву (якщо є)
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Метод для виведення масиву на консоль
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
