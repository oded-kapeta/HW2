public class Negation extends Function{
    private Function f1;
    public Negation(Function function1){
        this.f1 = function1;
    }

    @Override
    public String toString() {
        return "(-" + f1.toString() +")";
    }

    @Override
    public double valueAt(double x) {
        return f1.valueAt(x)*(-1);
    }

    @Override
    public Function derivative() {
        return new Negation(f1.derivative());
    }
}
