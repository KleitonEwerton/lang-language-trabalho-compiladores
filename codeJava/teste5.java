import java.util.Scanner;

public class teste5 {
    public Scanner __Scanner = new Scanner(System.in); // Scanner para fazer a leitura de entrada pelo teclado

    public class Ponto {
        Integer x;
        Integer y;
    };

    int main() {
        Ponto[] p;
        Integer i;
        Integer k;
        k = 5;
        p = new Ponto[k];
        i = 0;
        for (int _Indice_Loop_1 = 0, _Indice_Loop_1_EndLoop = k; _Indice_Loop_1 < _Indice_Loop_1_EndLoop; _Indice_Loop_1++) {
            p[i] = new Ponto();
            p[i].x = (12 + i);
            p[i].y = (12 - i);
            System.out.print(p[i].y);
            System.out.print('\n');
            i = (i + 1);
        }
        System.out.print('\n');
        return 0;
    }

    public static void main(String args[]) {
        teste5 m = new teste5();
        m.main();
    }
}