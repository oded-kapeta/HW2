public abstract class Function {
    public double bisectionMethod(double a, double b, double epsilon)
    {
        double left = a;
        double right = b;
        while((right-left) > epsilon)
        {
            double mid = (left+right)/2;
            if((this.valueAt(left)*this.valueAt(mid)) > 0) {
                left = mid;
            }
            else{
                right = mid;
            }
        }
        return ((left+right)/2);

    }
    public double bisectionMethod(double a, double b)
    {
        double left = a;
        double right = b;
        double defaultError = Math.pow(10,-5);
        while((right-left) > defaultError)
        {
            double mid = (left+right)/2;
            if((this.valueAt(left)*this.valueAt(mid)) > 0) {
                left = mid;
            }
            else{
                right = mid;
            }
        }
        return ((left+right)/2);
    }

    public double newtonRaphsonMethod(double a)
    {
        double xK = a;
        double deafultError = Math.pow(10,-5);
        while(Math.abs(this.valueAt(xK)) >= deafultError)
        {
            xK = xK - ((this.valueAt(xK))/(this.derivative().valueAt(xK)));
        }
        return xK;
    }

    public double newtonRaphsonMethod(double a, double epsilon)
    {
        double xK = a;
        while(Math.abs(this.valueAt(xK)) >= epsilon)
        {
            xK = xK - ((this.valueAt(xK))/(this.derivative().valueAt(xK)));
        }
        return xK;
    }

    public Function taylorPolynomial(int n)
    {
        double [] arr = new double[n];
        Polynomial taylor = new Polynomial();
        Function derivative= this.derivative();
        int factorial = 1;
        arr[0] = this.valueAt(0);

        for (int i=1; i<=n;i++)
        {
            factorial = factorial*i;
            arr[i] = derivative.valueAt(0)/factorial;
            derivative = derivative.derivative();

        }
        return new Polynomial(arr);
    }

    @Override
    public abstract String toString();

    public abstract double valueAt(double x);

    public abstract Function derivative();
}
