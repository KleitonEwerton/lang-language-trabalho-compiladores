/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */
package lang.ast;

import lang.visitors.Visitor;

public class CharDexp extends LValue {

    private char value;

    public CharDexp(int line, int column, String value) {
        super(line, column);
        this.interpretChar(value);
    }

    private void interpretChar(String valueString) {
        if (valueString.length() > 2 && valueString.charAt(1) == '\\') {
            char escapeChar = valueString.charAt(2);
            switch (escapeChar) {
                case 'n':
                    this.value = '\n';
                    break;
                case 't':
                    this.value = '\t';
                    break;
                case 'b':
                    this.value = '\b';
                    break;
                case 'r':
                    this.value = '\r';
                    break;
                case '\\':
                    this.value = '\\';
                    break;
                case '\'':
                    this.value = '\'';
                    break;
                default:
                    throw new IllegalArgumentException("Invalid escape sequence: \\" + escapeChar);
            }
        } else {
            this.value = valueString.charAt(1);
        }
    }

    public void setValue(char value) {
        this.value = value;
    }

    public String getValue() {
        return value + "";
    }

    @Override
    public String toString() {
        return value + "";
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String getName() {
        return getName();
    }
}
