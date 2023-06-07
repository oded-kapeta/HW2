public class Negation extends Function{
    private Function f1;


    /**
     * constructor for negation
     * @param function1 the function
     */
    public Negation(Function function1){
        this.f1 = function1;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "(-" + f1.toString() +")";
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public double valueAt(double x) {
        return f1.valueAt(x)*(-1);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Function derivative() {
        return new Negation(f1.derivative());
    }
}
