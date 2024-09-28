import java.util.Scanner;

public class -genFile {

    int main() {
        Integer nlines;
        Integer i;
        nlines = 5;
        i = nlines;
        int iLoop1 = nlines;
        while (iLoop1 > 0) {
            int iLoop2 = i;
            while (iLoop2 > 0) {
                System.out.print('*');
                iLoop2--;
            }
            i = (i - 1);
            System.out.print('\n');
            iLoop1--;
        }
        return 0;
    }

    public static void main(String args[]) {
        -genFile m = new -genFile();
        m.main();
    }
}