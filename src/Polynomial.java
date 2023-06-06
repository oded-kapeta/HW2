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
        if (polynom.length == 1){
            if ((int)polynom[0] == polynom[0]){
                ourPolynom += String.valueOf((int)polynom[0]);
            }else{
                ourPolynom += String.valueOf(polynom[0]);
            }
        }else{
            for (int i = 0; i < polynom.length; i++) {
                if (polynom[i] == 0.0) continue;
                if (polynom[i] > 0.0) {
                    if (ourPolynom.equals("(")) {
                        ourPolynom += new Product(polynom[i], new Power(new Polynomial(0, 1), i)).toString();
                    } else {
                        ourPolynom += " + ";
                        ourPolynom += new Product(polynom[i], new Power(new Polynomial(0, 1), i)).toString();
                    }
                } else {
                    if (ourPolynom.equals("(")) {
                        ourPolynom += new Product(polynom[i], new Power(new Polynomial(0, 1), i)).toString();
                    } else {
                        ourPolynom += " - ";
                        ourPolynom += new Product(Math.abs(polynom[i]), new Power(new Polynomial(0, 1), i)).toString();
                    }
                }
            }
        }
        ourPolynom += ")";
        return ourPolynom;
    }

    @Override
    public double valueAt(double x) {
        double sum = polynom[0];
        for (int i = 1;i < polynom.length;i++){
            sum+= polynom[i]*Math.pow(x,i);
        }
        return sum;
    }

    @Override
    public Function derivative() {
        if (polynom.length == 1){
            return new Polynomial(0.0);
        }
        double arr [] = new double[polynom.length-1];
        for (int i = 0; i < arr.length;i++){
            arr[i] = (i+1)*polynom[i+1];
        }
        return new Polynomial(arr);
    }

    public int getLength(){
        return polynom.length;
    }

    public double getPlace(int i){
        return polynom[i];
    }
}
