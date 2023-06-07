public class Difference extends Function{
    private Function f1;
    private Function f2;


    /**
     * constructor for difference
     * @param function1 the first function
     * @param function2 the second function
     */
    public Difference(Function function1,Function function2){
        this.f1 = function1;
        this.f2 = function2;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        String s1 = "";
        String s2 = "";
        String finalString = "";
        if (f1.getClass() == Constant.class){
            s1 = s1 + "(" + f1.toString() + ")";
        }else {
            s1 = s1 + f1.toString();
        }
        if (f2.getClass() == Constant.class){
            s2 = s2 + "(" + f2.toString() + ")";
        }else {
            s2 = s2 + f2.toString();
        }

        return "(" + f1 + " - " + f2 + ")";
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public double valueAt(double x) {
        return f1.valueAt(x) - f2.valueAt(x);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Function derivative() {
        return new Difference(f1.derivative(),f2.derivative());
    }
}
