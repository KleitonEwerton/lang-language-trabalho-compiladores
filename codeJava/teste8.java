import java.util.Scanner;

public class teste8 {
    public Scanner __Scanner = new Scanner(System.in); // Scanner para fazer a leitura de entrada pelo teclado


    Integer fat_retorno_00(Integer n) {
        if((n == 0)) {
            return 1;
        }
        return (n * fat_retorno_00((n - 1)));
    }

    Integer spook_retorno_00(Integer n) {
        if((n == 1)) {
            return (2 * n);
        }
        if((n == 2)) {
            return ((2 * n) + 1);
        }
        return (n - 1);
    }

    int main() {
        Integer k;
        k = fat_retorno_00(6);
        k = spook_retorno_00(2);
        System.out.print(k);
        System.out.print('\n');
        return 0;
    }

    public static void main(String args[]) {
        teste8 m = new teste8();
        m.main();
    }
}