public class Sum extends Function{
    private Function f1;
    private Function f2;
    public Sum(Function function1,Function function2){
        this.f1 = function1;
        this.f2 = function2;
    }

    @Override
    public String toString() {
        return "(" + f1.toString() + " + " + f2.toString() + ")" ;
    }

    @Override
    public double valueAt(double x) {
        return f1.valueAt(x) + f2.valueAt(x);
    }

    @Override
    public Function derivative() {
        return new Sum(f1.derivative(),f2.derivative());
    }
}
