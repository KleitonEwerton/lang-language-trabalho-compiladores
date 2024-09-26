import java.util.Scanner;

public class teste12 {
    public Scanner __Scanner = new Scanner(System.in); // Scanner para fazer a leitura de entrada pelo teclado


    Boolean even_retorno_00(Integer n) {
        if((n == 0)) {
            return (n == 0);
        } else {
            return odd_retorno_00((n - 1));
        }

    }

    Boolean odd_retorno_00(Integer n) {
        if((n == 0)) {
            return (n == 0);
        } else {
            return even_retorno_00((n - 1));
        }

    }

    int main() {
        Boolean r;
        r = even_retorno_00(3);
        if(r) {
            System.out.print('P');
            System.out.print('A');
            System.out.print('R');
        } else {
            System.out.print('I');
            System.out.print('M');
            System.out.print('P');
            System.out.print('A');
            System.out.print('R');
        }

        return 0;
    }

    public static void main(String args[]) {
        teste12 m = new teste12();
        m.main();
    }
}