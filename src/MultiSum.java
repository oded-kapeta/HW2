public class MultiSum extends Function{
    private Function [] fx;
    public MultiSum(Function firstFunction,Function...arr){
       // if (firstFunction.toString().equals("0")){
         //   fx = new Function[arr.length];
           // for (int i = 0; i < fx.length;i++){
             //   fx[i] = arr[i];
            //}
        //}else {
            fx = new Function[arr.length + 1];
            fx[0] = firstFunction;
            for (int i = 1; i < fx.length; i++) {
                fx[i] = arr[i - 1];
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
        /*
        String finalString = "(";
        for (int i = 0; i < fx.length;i++){
            finalString = finalString + fx[i].toString();
            if (i == fx.length-1)   break;
            finalString += " + ";
        }
        finalString += ")";
         */
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
