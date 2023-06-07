public class Power extends Function{
    private int exponent;
    private Function function;


    /**
     * constructor for power
     * @param function1 the function
     * @param exponent1 the exponent of the function
     */
    public Power(Function function1,int exponent1){
        this.exponent = exponent1;
        this.function = function1;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        if (isX() == true){
            if (exponent == 1)  return "x";
            if (exponent == 0)  return "1";
            return "x^" + String.valueOf(exponent);
        }
        return "(" + this.function.toString() + "^" + String.valueOf(exponent)  + ")";
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public double valueAt(double x) {
        if (exponent == 0)  return 1;
        double value = this.function.valueAt(x);
        return Math.pow(value,exponent);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Function derivative() {
        double[] arr = {0,1};

       // System.out.println(this.function.getClass() == Polynomial.class && ((Polynomial)function).getPolynom().equals(arr));
        if (exponent == 0)  return new Constant(0);
        if (exponent > 1){
            Constant newconst = new Constant(exponent);
            Power newpow = new Power(this.function,exponent - 1);
            if (isX() == true){
                return new MultiProduct(newconst,newpow,new Constant(1));
            }
            return new MultiProduct(newconst,newpow,function.derivative());
        }
        if (isX() == true){
            return new Product(new Constant(1),new Constant(1));
        }
        return new Product(new Constant(1),function.derivative());
    }


    /**
     * this function check if the parameter we want use power on i x
     * @return true if so, and false either
     */
    public boolean isX() {
        double[] arr = {0,1};



       if (this.function.getClass() == Polynomial.class){
            for (int i = 0; i < ((Polynomial)function).getLength();i++){
                if (arr[i] != ((Polynomial)function).getPlace(i))    return  false;
            }
            return true;
        }
        return false;


    }


    /**
     * this method check if the current exponent is equal to zero
     * @return true if the exponent is zero and false otherwise
     */
    public boolean isExponentZero(){
        if(this.exponent == 0)    return true;
        return false;
    }
}
