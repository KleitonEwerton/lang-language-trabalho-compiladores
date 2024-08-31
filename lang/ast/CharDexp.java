package lang.ast;

import lang.visitors.Visitor;

public class CharDexp extends LValue {

    private char value;

    public CharDexp(int line, int column, String valueString) {
        super(line, column);
        this.treatString(valueString);
    }

    public void treatString(String valueString) {
        if (valueString.charAt(1) == '\\') {
            String symbol = valueString.substring(1, valueString.length() - 1);
            switch (symbol.charAt(1)) {
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
    public String getId() {
        return getId();
    }
}
