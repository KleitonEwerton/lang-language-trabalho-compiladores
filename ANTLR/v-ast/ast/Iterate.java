package ast;

import java.util.HashMap;

public class Iterate extends Node {

    public Expr teste;
    public Node faca;

    public Iterate(int lin, int col, Expr teste, Node faca) {
        super(lin, col);
        this.teste = teste;
        this.faca = faca;
    }

    public int interpret(HashMap<String, Integer> m) {

        int n = teste.interpret(m);

        for (String key : m.keySet()) {
            System.out.println(" -I " + key + " = " + m.get(key) + " teste = " + this.teste + " faca = " + this.faca);
        }

        return n;
    }

}
