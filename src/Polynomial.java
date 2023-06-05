import java.sql.SQLOutput;

public class Polynomial extends Function{
    private double [] polynom;
    public Polynomial(double...x){
        polynom = new double[x.length];
        for(int i = 0 ;i < polynom.length;i++){
            polynom[i] = x[i];
        }
    }


    @Override
    public String toString() {
        String ourPolynom = "(";
        for(int i = 0; i< polynom.length;i++){
            if (polynom[i] == 0.0 )   continue;
            ourPolynom += new Product(polynom[i],new Power(new Polynomial(0,1),i))
                    .toString();
            if (i == polynom.length - 1)    break;
            if (polynom[i+1] == 0.0)   continue;
            ourPolynom += " + ";
        }
        ourPolynom += ")";
        /*
        String ourPolynom = "(";
        for(int i = 0; i< polynom.length;i++){
            if (polynom[i] == 0.0 )   continue;
            ourPolynom += new Product(new Constant(polynom[i]),new Power(new Polynomial(0,1),i))
                    .toString();
            if (i == polynom.length - 1)    break;
            ourPolynom += " + ";
        }
        ourPolynom += ")";

         */
        /*
        if (polynom[0] == (int)polynom[0]){
            if ((int)polynom[0] > 0){
                ourPolynom = ourPolynom + String.valueOf((int)polynom[0]) + " ";
            }
            if ((int)polynom[0] < 0){
                ourPolynom = ourPolynom + "- " +String.valueOf(-(int)polynom[0]) + " ";
            }
        }else{
            if ((int)polynom[0] > 0){
                ourPolynom = ourPolynom + String.valueOf(polynom[0])  + " ";
            }
            if ((int)polynom[0] < 0){
                ourPolynom = ourPolynom + "- " +String.valueOf(-polynom[0])  + " ";
            }
        }
        for (int i = 1; i < this.polynom.length;i++){
            if(polynom[i] == 0.0) continue;
            if (polynom[i] == 1.0){
                ourPolynom = ourPolynom + "+ x^" + String.valueOf(i) + " ";
                continue;
            }
            if (polynom[i] == -1.0){
                ourPolynom = ourPolynom + "- x^" + String.valueOf(i) + " ";
                continue;
            }
            if (polynom[i] == (int)polynom[i]){
                if ((int)polynom[i] > 0){
                    ourPolynom = ourPolynom + "+ " +String.valueOf((int)polynom[i]) + "x^" + String.valueOf(i) + " ";
                }
                if ((int)polynom[i] < 0){
                    ourPolynom = ourPolynom + "- " +String.valueOf(-(int)polynom[i]) + "x^" + String.valueOf(i) + " ";
                }
            }else{
                if ((int)polynom[i] > 0){
                    ourPolynom = ourPolynom + "+ " +String.valueOf(polynom[i]) + "x^" + String.valueOf(i) + " ";
                }
                if ((int)polynom[i] < 0){
                    ourPolynom = ourPolynom + "- " +String.valueOf(-polynom[i]) + "x^" + String.valueOf(i) + " ";
                }
            }
        }
         */

        return ourPolynom;
    }

    @Override
    public double valueAt(double x) {
        //System.out.println(polynom.length);
        double sum = polynom[0];
        for (int i = 1;i < polynom.length;i++){
            sum+= polynom[i]*Math.pow(x,i);
        }
        return sum;
    }

    @Override
    public Function derivative() {
        /*
        Constant const1 = new Constant(0);
        Function [] arr = new Function[polynom.length];
        arr[0] = new Constant(0);
        for (int i = 1;i < polynom.length;i++){
            if (polynom[i] == 0.0){
                arr[i] = new Constant(0);
                continue;
            }
            double ab = polynom[i] * i;
            arr[i] = new Product(new Constant(ab),new Power(new Polynomial(0,1),i-1));
        }

         */
        double arr [] = new double[polynom.length-1];
        for (int i = 0; i < arr.length;i++){
            arr[i] = (i+1)*polynom[i+1];
        }
        return new Polynomial(arr);
    }

    public double[] getPolynom() {
        return polynom;
    }

    public int getLength(){
        return polynom.length;
    }

    public double getPlace(int i){
        return polynom[i];
    }
}
