import java.util.Scanner;

public class teste9 {
    public Scanner __Scanner = new Scanner(System.in); // Scanner para fazer a leitura de entrada pelo teclado


    Integer f_retorno_00(Integer x) {
        Integer y;
        y = ((2 * x) + 1);
        if((y < 10)) {
            return y;
        } else {
            return y;
        }

    }

    Float f_retorno_01(Integer x) {
        Integer y;
        y = ((2 * x) + 1);
        if((y < 10)) {
            return 1.5f;
        } else {
            return 1.5f;
        }

    }

    int main() {
        Integer x;
        Integer h;
        Float z;
        z = f_retorno_01(10);
        x = f_retorno_00(10);
        System.out.print(x);
        h = (2 + f_retorno_00(10));
        return 0;
    }

    public static void main(String args[]) {
        teste9 m = new teste9();
        m.main();
    }
}