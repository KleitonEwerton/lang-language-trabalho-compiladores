package lang.ast;

public class FloatNumber extends LValue {

    private float value;

    public FloatNumber(int line, int column, float value) {
        super(line, column);
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Float.toString(value);
    }

    @Override
    public String getId() {
        return Float.toString(value);
    }

}
