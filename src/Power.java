public class Power extends Function{
    private Constant exponent;
    private Function function;
    public Power(Function function1,Constant exponent1){
        this.exponent = exponent1;
        this.function = function1;
    }

    @Override
    public String toString() {
        if (isX() == true){
            return "x^" + exponent.toString();
        }
        return "(" + this.function.toString() + "^" + exponent.toString()  + ")";
    }

    @Override
    public double valueAt(double x) {
        if (exponent.getConstant() == 0)  return 1;
        double value = this.function.valueAt(x);
        return Math.pow(value,exponent.getConstant());
    }

    @Override
    public Function derivative() {
        if (exponent.getConstant() > 1){
            Constant newconst = new Constant(exponent.getConstant());
            Power newpow = new Power(this.function,new Constant(exponent.getConstant()-1));
            return new MultiProduct(newconst,newpow,function.derivative());
        }
        return new Product(new Constant(1),function.derivative());
    }

    public boolean isX() {
        double[] arr = {0, 1.0};
        if (this.function.getClass() == Polynomial.class && ((Polynomial) function).getPolynom().equals(arr)) {
            return true;
        }
        return false;
    }

    public boolean isExponentZero(){
        if(this.exponent.getConstant() == 0)    return true;
        return false;
    }
}
