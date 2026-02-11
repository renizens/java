import java.util.Scanner;

public class Main {

    // чтение целого числа
    public static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Ошибка. Введите целое число: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    // ввод массива с клавиатуры
    public static int[] inputArray(Scanner scanner) {
        System.out.print("Введите размер массива: ");
        int size = readInt(scanner);

        while (size < 0) {
            System.out.print("Размер не может быть отрицательным. Введите снова: ");
            size = readInt(scanner);
        }

        int[] arr = new int[size];

        if (size > 0) {
            System.out.println("Введите элементы массива:");
            for (int i = 0; i < size; i++) {
                System.out.print("Элемент " + i + ": ");
                arr[i] = readInt(scanner);
            }
        }
        return arr;
    }

    // вывод массива
    public static void printArray(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Массив пуст");
            return;
        }

        System.out.print("Массив: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // индекс последнего четного элемента
    public static int lastChetIndex(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] % 2 == 0) {
                return i;
            }
        }
        return -1;
    }

    // индекс последнего нечетного элемента
    public static int lastNechetIndex(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] % 2 != 0) {
                return i;
            }
        }
        return -1;
    }

    // сумма элементов между последним четным и последним нечетным
    public static int solution(int[] arr) {
        int evenIdx = lastChetIndex(arr);
        int oddIdx = lastNechetIndex(arr);

        if (evenIdx == -1 || oddIdx == -1) {
            return 0;
        }

        int left = Math.min(evenIdx, oddIdx);
        int right = Math.max(evenIdx, oddIdx);

        if (right - left <= 1) {
            return 0;
        }

        int sum = 0;
        for (int i = left + 1; i < right; i++) {
            sum += arr[i];
        }

        return sum;
    }

    // запуск тестов
    public static void runTests() {
        System.out.println("\nТЕСТЫ:\n");

        int[][] tests = {
                {7, 2, 9, 4, 11, 6, 13},
                {8, 1, 6, 3, 4, 5, 2},
                {0, 2, 4, 6, 8, 1},
                {1, 3, 5, 7, 2},
                {-2, -4, -6, -1, -3, -5},
                {5, 4, 3, 2, 1, 0},
                {2, 3, 4, 5},
                {9, 8},
                {10, 11},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {-1, 0, 1},
                {0, 2, 0, 3, 0, 4}
        };

        for (int i = 0; i < tests.length; i++) {
            System.out.println("Тест " + (i + 1) + ":");
            printArray(tests[i]);
            int result = solution(tests[i]);
            System.out.println("Сумма: " + result);
            System.out.println();
        }

        System.out.println("КОНЕЦ ТЕСТОВ\n");
    }

    public static void main(String[] args) {

        if (args.length > 0) {
            int[] arr = new int[args.length];

            try {
                for (int i = 0; i < args.length; i++) {
                    arr[i] = Integer.parseInt(args[i]);
                }

                printArray(arr);
                int result = solution(arr);
                System.out.println("Сумма: " + result);

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: аргументы должны быть целыми числами");
            }

        } else {

            Scanner scanner = new Scanner(System.in);

            System.out.println("1 - тесты");
            System.out.println("2 - свой массив");
            System.out.print("Выбор: ");

            int choice = readInt(scanner);

            if (choice == 1) {
                runTests();
            } else if (choice == 2) {
                int[] arr = inputArray(scanner);
                printArray(arr);
                int result = solution(arr);
                System.out.println("Сумма: " + result);
            } else {
                System.out.println("Неверный выбор");
            }

            scanner.close();
        }
    }
}
