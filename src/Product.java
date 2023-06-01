public class Product extends Function{
    private Function function1;
    private Function function2;
    public Product(Function f1, Function f2){
        function1 = f1;
        function2 = f2;
    }

    @Override
    public String toString() {
        if (function1.getClass() == Constant.class && (function1).valueAt(1) == 1.0){
            return function2.toString();
        }
        if (function1.getClass() == Constant.class && (function1).valueAt(1) == -1.0){
            return "-" + function2.toString();
        }
        return function1.toString()+function2.toString();
    }
}
