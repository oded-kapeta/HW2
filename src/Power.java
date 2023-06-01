public class Power extends Function{
    private Constant exponent;
    private Function function;
    public Power(Function function1,Constant exponent1){
        this.exponent = exponent1;
        this.function = function1;
    }

    @Override
    public String toString() {
        double [] arr = {0,1.0};
        if (this.function.getClass() == Polynomial.class && ((Polynomial)function).getPolynom().equals(arr)){
            return "x^" + exponent.toString();
        }
        return "(" + this.function.toString() + "^" + exponent.toString()  + ")";
    }

    @Override
    public double valueAt(double x) {
        if (exponent.valueAt(1) == 0)  return 1;
        double value = this.function.valueAt(x);
        return Math.pow(value,x);
    }

    @Override
    public String derivative() {
        if (this.exponent.valueAt(1)== 1)   return this.function.derivative();
        Power p = new Power(function,new Constant(exponent.valueAt(1)-1));
        String tempString = "(" + String.valueOf(exponent.valueAt(1)-1) ;
        String tempString2 = "*" + new Power(function,new Constant(exponent.valueAt(1)-1)).toString();
        String tempString3 = "*" +  (function.derivative()).toString() + ")";
    }
}
