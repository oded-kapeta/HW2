public class Product extends Function{
    private Function function1;
    private Function function2;
    private double mekadem;
    public Product(Function f1, Function f2){
        function1 = f1;
        function2 = f2;
    }
    public Product(double a,Function f1){
        this.mekadem = a;
        this.function1 = f1;
    }

    @Override
    public String toString() {
        /*
        if (function1.getClass() == Constant.class && function2.getClass() == Power.class ){
            if (((Power)function2).isX() == true){
                if ((((Power)function2).isExponentZero()) == true){
                    return function1.toString();
                }
                if (((Constant)function1).getConstant() == 1){
                    return  function2.toString();
                }
                if (((Constant)function1).getConstant() == -1){
                    return function2.toString();
                }
                return function1.toString() + function2.toString();
            }
        }

         */
        if (function2 == null) {
            if (((Power) function1).isX() == true) {
                if ((((Power) function1).isExponentZero()) == true) {
                    if ((int) mekadem == mekadem) {
                        return String.valueOf((int) mekadem);
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

    @Override
    public double valueAt(double x) {
        return function1.valueAt(x) * function2.valueAt(x);
    }

    @Override
    public Function derivative() {
        Product p1 = new Product(function1.derivative(),function2);
        Product p2 = new Product(function2.derivative(),function1);
        return new MultiSum(p1,p2);
    }
}
