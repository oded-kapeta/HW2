public class Polynomial extends  Function{
    private double [] polynom;
    public Polynomial(double...x){
        polynom = new double[x.length];
        for(int i = 0 ;i < polynom.length;i++){
            polynom[i] = x[i];
        }
    }
    @Override
    public String toString() {
        String ourPolyinom = "(";
        if (polynom[0] == (int)polynom[0]){
            if ((int)polynom[0] > 0){
                ourPolyinom = ourPolyinom + String.valueOf((int)polynom[0]) + " ";
            }
            if ((int)polynom[0] < 0){
                ourPolyinom = ourPolyinom + "- " +String.valueOf(-(int)polynom[0]) + " ";
            }
        }else{
            if ((int)polynom[0] > 0){
                ourPolyinom = ourPolyinom  + String.valueOf(polynom[0])  + " ";
            }
            if ((int)polynom[0] < 0){
                ourPolyinom = ourPolyinom + "- " +String.valueOf(-polynom[0])  + " ";
            }
        }
        for (int i = 1; i < this.polynom.length;i++){
            if(polynom[i] == 0.0) continue;
            if (polynom[i] == 1.0){
                ourPolyinom = ourPolyinom + "+ x^" + String.valueOf(i) + " ";
                continue;
            }
            if (polynom[i] == -1.0){
                ourPolyinom = ourPolyinom + "- x^" + String.valueOf(i) + " ";
                continue;
            }
            if (polynom[i] == (int)polynom[i]){
                if ((int)polynom[i] > 0){
                    ourPolyinom = ourPolyinom + "+ " +String.valueOf((int)polynom[i]) + "x^" + String.valueOf(i) + " ";
                }
                if ((int)polynom[i] < 0){
                    ourPolyinom = ourPolyinom + "- " +String.valueOf(-(int)polynom[i]) + "x^" + String.valueOf(i) + " ";
                }
            }else{
                if ((int)polynom[i] > 0){
                    ourPolyinom = ourPolyinom + "+ " +String.valueOf(polynom[i]) + "x^" + String.valueOf(i) + " ";
                }
                if ((int)polynom[i] < 0){
                    ourPolyinom = ourPolyinom + "- " +String.valueOf(-polynom[i]) + "x^" + String.valueOf(i) + " ";
                }
            }
        }
        ourPolyinom = ourPolyinom + ")";
        return ourPolyinom;
    }

    @Override
    public double valueAt(double x) {
        double sum = polynom[0];
        for (int i = 1;i < polynom.length;i++){
            sum+= polynom[i]*power(x,i);
        }
        return sum;
    }
}
