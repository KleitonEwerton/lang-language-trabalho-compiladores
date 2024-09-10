package lang.ast;

public class CharLitteral extends LValue {

    private char value;

    public CharLitteral(int line, int column, char value) {
        super(line, column);
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Character.toString(value);
    }

    @Override
    public String getId() {
        return Character.toString(value);
    }

}
