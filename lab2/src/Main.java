import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        exercise6();
    }

    static void exercise6() {
        Scanner scanner = new Scanner(System.in);

        //ввод данных
        System.out.print("Введите x (|x| < 1): ");
        double x = scanner.nextDouble();
        System.out.print("Введите n (кол-во слагаемых): ");
        int n = scanner.nextInt();
        System.out.print("Введите e (эпсилон): ");
        double e = scanner.nextDouble();

        //проверка области сходимости ряда (R = 1)
        if (Math.abs(x) >= 1) {
            System.out.println("Ошибка: |x| должен быть < 1");
            return;
        }

        double a = 0;          //текущий член ряда a
        double sumN = 0;       //сумма первых n слагаемых
        double sumE = 0;       //сумма слагаемых > e
        double sumE10 = 0;     //сумма слагаемых > e/10

        //цикл для вычисления всех сумм
        for (int k = 1; k <= n; k++) {
            //вычисление k-го члена ряда через рекуррентную формулу:
            if (k == 1) {
                a = x;  //первый член ряда
            } else {
                //рекуррентная формула
                a = a * (-1) * ((2L * k - 3) * (2L * k - 3) * x * x)
                        / ((2L * k - 2) * (2L * k - 1));
            }

            //сумма n слагаемых
            sumN += a;

            //сумма слагаемых, превышающих e по модулю
            if (Math.abs(a) > e) {
                sumE += a;
            }

            //сумма слагаемых, превышающих e/10 по модулю
            if (Math.abs(a) > e / 10) {
                sumE10 += a;
            }
        }
        //через Math
        double mathValue = Math.log(x + Math.sqrt(x * x + 1));

        //вывод
        System.out.println("Сумма " + n + " слагаемых: " + sumN);
        System.out.println("Сумма слагаемых > e: " + sumE);
        System.out.println("Сумма слагаемых > e/10: " + sumE10);
        System.out.println("Math.log(x + sqrt(x^2+1)): " + mathValue);
    }
}