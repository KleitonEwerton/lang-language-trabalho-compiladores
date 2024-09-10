package lang.ast;

public class BooleanValue extends LValue {
    private boolean value;

    public BooleanValue(int line, int column, boolean value) {
        super(line, column);
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }

    @Override
    public String getId() {
        return Boolean.toString(value);
    }

}
