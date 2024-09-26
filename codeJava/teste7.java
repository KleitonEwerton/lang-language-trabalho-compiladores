import java.util.Scanner;

public class teste7 {
    public Scanner __Scanner = new Scanner(System.in); // Scanner para fazer a leitura de entrada pelo teclado


    int main() {
        Integer[][] x;
        Integer i;
        Integer z;
        Integer k;
        k = 5;
        x = new Integer[k][];
        i = 0;
        for (int _Indice_Loop_1 = 0, _Indice_Loop_1_EndLoop = k; _Indice_Loop_1 < _Indice_Loop_1_EndLoop; _Indice_Loop_1++) {
            x[i] = new Integer[k];
            i = (i + 1);
        }
        i = 0;
        for (int _Indice_Loop_1 = 0, _Indice_Loop_1_EndLoop = k; _Indice_Loop_1 < _Indice_Loop_1_EndLoop; _Indice_Loop_1++) {
            x[i][i] = ((2 * i) + 1);
            i = (i + 1);
        }
        z = x[3][3];
        return 0;
    }

    public static void main(String args[]) {
        teste7 m = new teste7();
        m.main();
    }
}