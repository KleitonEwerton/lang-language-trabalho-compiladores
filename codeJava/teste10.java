import java.util.Scanner;

public class teste10 {
    public Scanner __Scanner = new Scanner(System.in); // Scanner para fazer a leitura de entrada pelo teclado


    Integer fibonacci_retorno_00(Integer n) {
        if((n < 1)) {
            return n;
        }
        if((n == 1)) {
            return n;
        }
        return (fibonacci_retorno_00((n - 1)) + fibonacci_retorno_00((n - 2)));
    }

    int main() {
        Integer v;
        v = fibonacci_retorno_00(5);
        System.out.print(v);
        return 0;
    }

    public static void main(String args[]) {
        teste10 m = new teste10();
        m.main();
    }
}