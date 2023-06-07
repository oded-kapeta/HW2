public class Product extends Function{
    private Function function1;
    private Function function2;
    private double mekadem;


    /**
     * constructor for product of two functions
     * @param f2 the first function
     * @param f1 the second function
     */
    public Product(Function f1, Function f2){
        function1 = f1;
        function2 = f2;
    }

    /**
     * constructor for product of a function and a constant
     * @param a a constant in double format
     * @param f1 the function
     */
    public Product(double a,Function f1){
        this.mekadem = a;
        this.function1 = f1;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        if (function2 == null) {
            if (((Power) function1).isX() == true) {
                if ((((Power) function1).isExponentZero()) == true) {
                    if ((int)mekadem == mekadem) {
                        return String.valueOf((int)mekadem);
                    }
                    return String.valueOf(mekadem);
                }
                if (mekadem == 1) {
                    return function1.toString();
                }
                if (mekadem == -1) {
                    return function1.toString();
                }
                if ((int) mekadem == mekadem) {
                    return String.valueOf((int) mekadem) + function1.toString();
                }
                return String.valueOf(mekadem) + function1.toString();
            }
        }
        return "(" + function1.toString()  + " * " +  function2.toString() + ")";
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public double valueAt(double x) {
        return function1.valueAt(x) * function2.valueAt(x);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Function derivative() {
        Product p1 = new Product(function1.derivative(),function2);
        Product p2 = new Product(function2.derivative(),function1);
        return new MultiSum(p1,p2);
    }
}
