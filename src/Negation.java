public class Negation extends Function{
    private Function f1;
    public Negation(Function function1){
        this.f1 = function1;
    }

    @Override
    public String toString() {
        if (f1.getClass() == Constant.class){
            return "-(" + f1.toString() +")";
        }
        return "-" + f1.toString();
    }

    @Override
    public double valueAt(double x) {
        return f1.valueAt(x)*(-1);
    }

    @Override
    public Function derivative() {
        return new Product(new Constant(-1.0),f1.derivative());
    }
}
