public class Constant extends Function{
    protected double constant;

    /**
     * constructor for constant
     * @param number double number
     */
    public Constant(double number){
        this.constant = number;
    }

    /**
     * overriding tostring()
     * @return string of the constant
     */
    @Override
    public String toString() {
        if (this.constant == (int)constant){
            return  "(" + String.valueOf((int)constant) + ")";
        }
        return "(" + String.valueOf(this.constant) + ")";
    }

    /**
     * override of valueAt
     * @param x the index we want to calculate the value
     * @return
     */
    @Override
    public double valueAt(double x) {
        return this.constant;
    }

    /**
     * drivative for constant
     * @return  new constant of 0
     */
    @Override
    public Function derivative() {
        return new Constant(0);
    }

}
