import java.util.Scanner;

public class teste6 {
    public Scanner __Scanner = new Scanner(System.in); // Scanner para fazer a leitura de entrada pelo teclado

    public class Ponto {
        Integer x;
        Integer y;
    };

    void printP(Ponto p) {
        System.out.print('(');
        System.out.print(p.x);
        System.out.print(',');
        System.out.print(p.y);
        System.out.print(')');
    }

    void printV(Ponto[] v, Integer n) {
        Integer i;
        System.out.print('{');
        if((0 < n)) {
            printP(v[0]);
            i = 1;
            for (int _Indice_Loop_1 = 0, _Indice_Loop_1_EndLoop = (n - 1); _Indice_Loop_1 < _Indice_Loop_1_EndLoop; _Indice_Loop_1++) {
                System.out.print(',');
                printP(v[i]);
                i = (i + 1);
            }
        }
        System.out.print('}');
    }

    void sort(Ponto[] v, Integer n) {
        Ponto aux;
        Integer i;
        Integer j;
        i = 0;
        for (int _Indice_Loop_1 = 0, _Indice_Loop_1_EndLoop = (n - 1); _Indice_Loop_1 < _Indice_Loop_1_EndLoop; _Indice_Loop_1++) {
            j = (i + 1);
            for (int _Indice_Loop_2 = 0, _Indice_Loop_2_EndLoop = (n - (i + 1)); _Indice_Loop_2 < _Indice_Loop_2_EndLoop; _Indice_Loop_2++) {
                if((v[i].x < v[j].x)) {
                    aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
                j = (j + 1);
            }
            i = (i + 1);
        }
    }

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
            i = (i + 1);
        }
        printV(p, k);
        sort(p, k);
        System.out.print('\n');
        printV(p, k);
        System.out.print('\n');
        return 0;
    }

    public static void main(String args[]) {
        teste6 m = new teste6();
        m.main();
    }
}