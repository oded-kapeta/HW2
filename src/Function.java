public abstract class Function {

    @Override
    public abstract String toString();

    public abstract double valueAt(double x);
    public double power(double x,int exp){
        if(exp == 0) return 1;
        if (exp == 1)   return x;
        double newx = x;
        while (exp >1){
            newx *= x;
            exp--;
        }
        return newx;
    }
}
