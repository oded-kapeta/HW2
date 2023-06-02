public class MultiProduct extends Function{
    private Function [] fx;
    private Function first;
    public MultiProduct(Function firstFunction,Function...arr){
        this.first = firstFunction;
        fx = new Function[arr.length];
        for (int i = 0; i < arr.length;i++){
            fx[i] = arr[i];
        }
    }

    @Override
    public String toString() {
        String finalString = "(" ;
        if (!(first.toString().equals("1")) && first.getClass() == Constant.class){
            finalString = finalString + "(" + first.toString() + ")" + " * ";
        }
        if (!(first.toString().equals("1")) && first.getClass() != Constant.class){
            finalString = finalString  + first.toString() + " * " ;
        }
        for (int i = 0 ;i < fx.length;i++){
            if (fx[i].toString().equals("1"))  continue;
            if (fx[i].getClass() == Constant.class){
                finalString = finalString + "(" + fx[i].toString() + ")";
            }else {
                finalString = finalString +  fx[i].toString();
            }
            if (i == fx.length-1)   break;
            finalString = finalString + " * ";
        }
        finalString = finalString + ")";
        return finalString;
    }

    @Override
    public double valueAt(double x) {
        double sum = first.valueAt(x);
        for (int i = 0; i < fx.length;i++){
            sum *= fx[i].valueAt(x);
        }
        return sum;
    }

    @Override
    public Function derivative() {
        Function [] arrUnit = new Function[fx.length + 1];
        arrUnit[0] = first;
        for (int i = 0; i < fx.length;i++){
            arrUnit[i+1] = fx[i];
        }
        Function [] tempArr = new Function[arrUnit.length-1];
        Function [] finalArr = new Function[arrUnit.length];
        for (int i = 0; i < arrUnit.length;i++){
            for (int j = 0; j < arrUnit.length;j++){
                if(i == j)  continue;
                tempArr[j] = arrUnit[j];
            }
            finalArr[i] = new MultiProduct(arrUnit[i].derivative(), tempArr);
        }
        return new MultiSum(new Constant(0), finalArr);
    }
}
