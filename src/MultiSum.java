public class MultiSum extends Function{
    private Function [] fx;
    public MultiSum(Function firstFunction,Function...arr){
            fx = new Function[arr.length + 1];
            fx[0] = firstFunction;
            for (int i = 1; i < fx.length; i++) {
                fx[i] = arr[i - 1];
            }
    }

    @Override
    public String toString() {
        String finalString = "(";
        for (int i = 0; i < fx.length;i++){
            finalString = finalString + fx[i].toString();
            if (i == fx.length-1)   break;
            finalString += " + ";
        }
        finalString += ")";
        return finalString;
    }

    @Override
    public double valueAt(double x) {
        double sum = 0;
        for (int i = 0 ;i < fx.length;i++){
            sum += fx[i].valueAt(x);
        }
        return sum;
    }

    @Override
    public Function derivative() {
        Function [] array = new Function[fx.length-1];
        for (int i = 0 ;i < array.length ;i++){
            array[i] = fx[i+1].derivative();
        }
        return new MultiSum(fx[0].derivative(),array);
    }
}
