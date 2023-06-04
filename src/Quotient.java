public class Quotient extends Function{
    private Function f1;
    private Function f2;
    public Quotient(Function function1,Function function2){
        this.f1 = function1;
        this.f2 = function2;
    }

    @Override
    public String toString() {
        return "(" + f1.toString() + " / " + f2.toString() + ")";
    }

    @Override
    public double valueAt(double x) {
        return f1.valueAt(x)/ f2.valueAt(x);
    }

    @Override
    public Function derivative() {
        Product product1 = new Product(f1.derivative(),f2);
        Product product2 = new Product(f2.derivative(),f1);
        Difference dif1 = new Difference(product1, product2);
        Power pow1 = new Power(f2,2);
        return new Quotient(dif1,pow1);
    }
}
