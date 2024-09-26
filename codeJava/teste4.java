import java.util.Scanner;

public class teste4 {
    public Scanner __Scanner = new Scanner(System.in); // Scanner para fazer a leitura de entrada pelo teclado

    public class Ponto {
        Float x;
        Float y;
    };

    int main() {
        Ponto p;
        p = new Ponto();
        p.x = 10.0f;
        p.y = 10.0f;
        System.out.print('(');
        System.out.print(p.x);
        System.out.print(',');
        System.out.print(' ');
        System.out.print(p.y);
        System.out.print(')');
        System.out.print('\n');
        return 0;
    }

    public static void main(String args[]) {
        teste4 m = new teste4();
        m.main();
    }
}