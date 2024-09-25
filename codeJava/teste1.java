import java.util.Scanner;

public class teste1 {
    public Scanner __Scanner = new Scanner(System.in); // Scanner para fazer a leitura de entrada pelo teclado


    int main() {
        Integer q;
        Integer res;
        Integer quo;
        Integer n;
        n = 13;
        q = 5;
        quo = divMod_retorno_00(n, q);
        res = divMod_retorno_01(n, q);
        System.out.print('Q');
        System.out.print(':');
        System.out.print(quo);
        System.out.print('\n');
        System.out.print('R');
        System.out.print(':');
        System.out.print(res);
        System.out.print('\n');
        return 0;
    }

    Integer divMod_retorno_00(Integer n, Integer q) {
        return (n / q);
    }

    Integer divMod_retorno_01(Integer n, Integer q) {
        return (n % q);
    }

    public static void main(String args[]) {
        teste1 m = new teste1();
        m.main();
    }
}