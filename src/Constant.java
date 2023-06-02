public class Constant extends Function{
    protected double constant;

    public Constant(double number){
        this.constant = number;
    }

    @Override
    public String toString() {
        if (this.constant == (int)constant) return String.valueOf((int)constant);
        return String.valueOf(this.constant);
    }

    @Override
    public double valueAt(double x) {
        return this.constant;
    }

    @Override
    public Function derivative() {
        return new Constant(0);
    }

    public double getConstant() {
        if (this.constant == (int)constant) return (int)constant;
        return constant;
    }
}
