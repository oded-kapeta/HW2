public class Sum extends Function{
    private Function f1;
    private Function f2;

    /**
     * constructor for sum
     * @param function1 the first function in the sum
     * @param function2 the second function in the sum
     */
    public Sum(Function function1,Function function2){
        this.f1 = function1;
        this.f2 = function2;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "(" + f1.toString() + " + " + f2.toString() + ")" ;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public double valueAt(double x) {
        return f1.valueAt(x) + f2.valueAt(x);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Function derivative() {
        return new Sum(f1.derivative(),f2.derivative());
    }
}
