public abstract class Function {
    /**
     * this function calculates the roots of the given function with an error of epsilon using the bisection method
     * @param a
     * @param b
     * @param epsilon
     * @return the roots of the function
     */
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

    /**
     * this function calculates the roots of the given function with an error of 10^-5 using the bisection method
     * @param a
     * @param b
     * @return the roots of the function
     */
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

    /**
     * this method calculates the roots of the given function with an error of 10^-5 using the newton raphson method
     * @param a
     * @return the roots of the function
     */
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


    /**
     * this method calculates the roots of the given function with an error of epsilon using the newton raphson method
     * @param a
     * @param epsilon
     * @return the roots of the function
     */
    public double newtonRaphsonMethod(double a, double epsilon)
    {
        double xK = a;
        while(Math.abs(this.valueAt(xK)) >= epsilon)
        {
            xK = xK - ((this.valueAt(xK))/(this.derivative().valueAt(xK)));
        }
        return xK;
    }


    /**
     * this method calculates the taylor polynom with the order of n (around 0) of the given function
     * @param n
     * @return the taylor polynom of the function
     */
    public Function taylorPolynomial(int n)
    {
        int counter = 0;
        double [] arr = new double[n+1];
        Function derivative= this.derivative();
        double factorial = 1;
        arr[0] = this.valueAt(0);
        for (int i=1; i<=n;i++)
        {
            factorial = factorial*i;
            arr[i] = derivative.valueAt(0)/factorial;
            derivative = derivative.derivative();
        }
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0.0)  counter++;
        }
        if (counter == arr.length){
            return new Constant(0);
        }
        return new Polynomial(arr);
    }


    /**
     * this method recieves the given function and returns it in a string format
     * @return
     */
    @Override
    public abstract String toString();


    /**
     * this method calculates the value of the given function at x
     * @param x - where we want to calculate our value
     * @return the value of the function in double format
     */
    public abstract double valueAt(double x);


    /**
     * this method calculates the derivative of the given function
     * @return the derivative (a function)
     */
    public abstract Function derivative();
}
