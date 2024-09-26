import java.util.Scanner;

public class teste11 {
    public Scanner __Scanner = new Scanner(System.in); // Scanner para fazer a leitura de entrada pelo teclado


    int main() {
        Integer nlines;
        Integer i;
        nlines = 5;
        for (int _Indice_Loop_1 = 0, _Indice_Loop_1_EndLoop = nlines; _Indice_Loop_1 < _Indice_Loop_1_EndLoop; _Indice_Loop_1++) {
            i = nlines;
            for (int _Indice_Loop_2 = 0, _Indice_Loop_2_EndLoop = i; _Indice_Loop_2 < _Indice_Loop_2_EndLoop; _Indice_Loop_2++) {
                System.out.print('*');
            }
            nlines = (nlines - 1);
            System.out.print('\n');
        }
        return 0;
    }

    public static void main(String args[]) {
        teste11 m = new teste11();
        m.main();
    }
}