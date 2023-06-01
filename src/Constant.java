public class Constant extends Function{
    protected double constant;

    public Constant(double number){
        this.constant = number;
    }

    @Override
    public String toString() {
        return String.valueOf(this.constant);
    }

    @Override
    public double valueAt(double x) {
        return this.constant;
    }

    @Override
    public String derivative() {
        return "0";
    }
}
