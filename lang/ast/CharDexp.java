/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

package lang.ast;

import lang.visitors.*;

public class CharDexp extends LValue {

    private char value;
    private String originalValue;

    public CharDexp(int line, int column, String value) {
        super(line, column);
        interpretChar(value);
    }

    public String getValue() {
        return Character.toString(value);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "'" + value + "'";
    }

    private void interpretChar(String valueString) {
        this.originalValue = valueString;
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

    @Override
    public String getId() {
        return null; // CharDexp does not have an identifier, so return null
    }

    public String getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(String originalValue) {
        this.originalValue = originalValue;
    }
}