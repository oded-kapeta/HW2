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
        if (!(first.toString().equals("1"))){
            finalString = finalString  + first.toString() + " * " ;
        }
        for (int i = 0 ;i < fx.length;i++){
            if (fx[i].toString().equals("1"))  continue;
            finalString = finalString +  fx[i].toString();
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
        if (fx.length == 1){
            return new Product(first,fx[0]).derivative();
        }
        Function [] arrUnit = new Function[fx.length + 1];
        arrUnit[0] = first;
        for (int i = 0; i < fx.length;i++){
            arrUnit[i+1] = fx[i];
        }
        Function [] temp = new Function[arrUnit.length-1];
        for (int i = 0 ; i < temp.length;i++){
            temp[i] =arrUnit[i+1];
        }
        Function multifirst = new MultiProduct(arrUnit[0].derivative(),temp);
        Function [] tempArr = new Function[arrUnit.length-1];
        Function [] finalArr = new Function[arrUnit.length-1];
        for (int i = 1; i < arrUnit.length;i++){
            for (int j = 0; j < i;j++){
                tempArr[j] = arrUnit[j];
            }
            if (tempArr[0] == null){
                for (int j = i; j < tempArr.length;j++){
                    tempArr[j] = arrUnit[j+1];
                }
            }else{
                for (int j = i+1; j < tempArr.length+1;j++){
                    tempArr[j-1] = arrUnit[j];
                }
            }

            finalArr[i-1] = new MultiProduct(arrUnit[i].derivative(),tempArr);
        }
        return new MultiSum(multifirst, finalArr);

    }
}
