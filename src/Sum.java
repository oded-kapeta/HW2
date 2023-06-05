public class Sum extends Function{
    private Function f1;
    private Function f2;
    public Sum(Function function1,Function function2){
        this.f1 = function1;
        this.f2 = function2;
    }

    @Override
    public String toString() {
        /*
        String s1 = "";
        String s2 = "";
        String finalString = "(";
        if (!(f1.toString().equals("0"))){
            if(f1.getClass() == Constant.class){
                s1 = s1 +  "(" + f1.toString() + ")";
            }else {
                s1 = s1 + f1.toString();
            }
        }
        if (!(f2.toString().equals("0"))){
            if(f2.getClass() == Constant.class){
                s2 = s2 +  "(" + f2.toString() + ")";
            }else {
                s2 = s2 + f2.toString();
            }
        }
        finalString = s1 + " + "  + s2 + ")";
         */
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
