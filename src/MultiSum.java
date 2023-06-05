public class MultiSum extends Function{
    private Function [] fx;
    private Function first;
    public MultiSum(Function firstFunction,Function...arr){
        this.first = firstFunction;
        fx = new Function[arr.length];
        for (int i = 0; i < arr.length;i++){
            fx[i] = arr[i];
        }
    }

    @Override
    public String toString() {
        /*
        String finalString = "(" ;
        if (!(first.toString().equals("0")) && first.getClass() == Constant.class){
            finalString = finalString + "(" + first.toString() + ")" + " + ";
        }
        if (!(first.toString().equals("0")) && first.getClass() != Constant.class){
            finalString = finalString  + first.toString() + " + " ;
        }
        for (int i = 0 ;i < fx.length;i++){
            if (fx[i].toString().equals("0"))  continue;
            if (fx[i].getClass() == Constant.class){
                finalString = finalString + "(" + fx[i].toString() + ")";
            }else {
                finalString = finalString +  fx[i].toString();
            }
            if (i == fx.length-1)   break;
            finalString = finalString + " + ";
        }
        finalString = finalString + ")";
         */
        String finalString = "(" + first.toString() + " + ";
        for (int i = 0; i < fx.length;i++){
            finalString = finalString + fx[i].toString();
            if (i == fx.length-1)   break;
            finalString += " + ";
        }
        return finalString;
    }

    @Override
    public double valueAt(double x) {
        double sum = 0;
        sum += first.valueAt(x);
        for (int i = 0 ;i < fx.length;i++){
            sum += fx[i].valueAt(x);
        }
        return sum;
    }

    @Override
    public Function derivative() {
        Function [] array = new Function[fx.length];
        for (int i = 0 ;i < fx.length;i++){
            array[i] = fx[i].derivative();
        }
        return new MultiSum(first.derivative(),array);
    }
}
