public class Product extends Function{
    private Function function1;
    private Function function2;
    public Product(Function f1, Function f2){
        function1 = f1;
        function2 = f2;
    }

    @Override
    public String toString() {
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
        return "(("+function1.toString()+")" + " * " +"("+ function2.toString()+"))";
    }

    @Override
    public double valueAt(double x) {
        return function1.valueAt(x)* function2.valueAt(x);
    }

    @Override
    public Function derivative() {
        Product p1 = new Product(function1.derivative(),function2);
        Product p2 = new Product(function2.derivative(),function1);
        return new MultiSum(p1,p2);
    }
}
