public class Power extends Function{
    private int exponent;
    private Function function;
    public Power(Function function1,int exponent1){
        this.exponent = exponent1;
        this.function = function1;
    }

    @Override
    public String toString() {
        if (isX() == true){
            return "x^" + String.valueOf(exponent);
        }
        return "(" + this.function.toString() + "^" + String.valueOf(exponent)  + ")";
    }

    @Override
    public double valueAt(double x) {
        if (exponent == 0)  return 1;
        double value = this.function.valueAt(x);
        return Math.pow(value,exponent);
    }

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

    public boolean isX() {
        double[] arr = {0,1};
        /*
        System.out.println(((Polynomial)function).getPolynom());
        System.out.println(this.function.getClass() == Polynomial.class && ((Polynomial)function).getPolynom().equals(arr));
        if (this.function.getClass() == Polynomial.class && ((Polynomial)function).getPolynom().equals(arr)) {
            System.out.println(((Polynomial)function).getPolynom());
        }
        return false;

         */



       if (this.function.getClass() == Polynomial.class){
            for (int i = 0; i < ((Polynomial)function).getLength();i++){
                if (arr[i] != ((Polynomial)function).getPlace(i))    return  false;
            }
            return true;
        }
        return false;


    }

    public boolean isExponentZero(){
        if(this.exponent == 0)    return true;
        return false;
    }
}
