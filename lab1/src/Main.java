
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        exercise5();
    }
    static void exercise5() {
        Scanner scanner = new Scanner(System.in);

        //ввод
        System.out.print("Введите высоту прямоугольника: ");
        int h = scanner.nextInt();
        System.out.print("Введите ширину прямоугольника: ");
        int w = scanner.nextInt();
        scanner.close();

        //цикл по высоте
        for (int i = 0; i < h; i++){
            //цикл по ширине
            for (int j = 0; j < w; j++) {
                //находимся ли мы на верхней или нижней границе
                if (i == 0 || i == h - 1) {
                    //на верхней или нижней границе
                    if (j == 0 || j == w - 1) {
                        System.out.print('*');
                    } else {
                        System.out.print('-');
                    }
                }
                //если не на границе
                else {
                    if (j == 0 || j == w - 1) {
                        System.out.print('|');
                    } else {
                        System.out.print(' ');
                    }
                }
            }
            System.out.println(); //переход на новую строку
        }
    }
}