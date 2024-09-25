import java.util.Scanner;

public class teste14 {
    public Scanner __Scanner = new Scanner(System.in); // Scanner para fazer a leitura de entrada pelo teclado


    int main() {
        Integer maior;
        Integer x;
        Integer y;
        Integer z;
        x = 1;
        y = 2;
        z = 3;
        maior = x;
        if((x < y)) {
            if((y < z)) {
                maior = z;
            } else {
                maior = y;
            }

        } else {
            if((x < z)) {
                maior = z;
            } else {
                maior = x;
            }

        }

        System.out.print('M');
        System.out.print('a');
        System.out.print('i');
        System.out.print('o');
        System.out.print('r');
        System.out.print(':');
        System.out.print(' ');
        System.out.print(maior);
        System.out.print('\n');
        return 0;
    }

    public static void main(String args[]) {
        teste14 m = new teste14();
        m.main();
    }
}