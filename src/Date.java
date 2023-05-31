public class Date {
    public int day = 1;
    public int month = 1;
    public int year = 0;

    public Date(int myyear,int mymonth,int myday){
        setDay(myday);
        setYear(myyear);
        setMonth(mymonth);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)    return true;
        if (obj == null)    return false;
        return (this.hashCode() == obj.hashCode());

    }

    @Override
    public String toString() {
        String dayString = String.valueOf(this.day);
        String monthString = String.valueOf(this.month);
        String yearString = String.valueOf(this.year);
        int lengthDay = dayString.length();
        int lengthMonth = monthString.length();
        int lengthYear = yearString.length();
        while (lengthYear<4 || lengthDay<2 || lengthMonth<2){
            if (lengthYear < 4){
                System.out.println(yearString);
                yearString = "0"+yearString;
                System.out.println(yearString);
                lengthYear++;
            }
            if (lengthMonth < 2){
                monthString = "0"+monthString;
                lengthMonth++;
            }
            if (lengthDay < 2){
                dayString = "0"+dayString;
                lengthDay++;
            }
        }
        String finalString = dayString + "/" + monthString + "/" + yearString;
        return finalString;
    }

    @Override
    public int hashCode() {
        return 3999*this.year + 31*this.month + 12*this.year;
    }

    public void setDay(int day) {
        if (day >=1 && day<=31) this.day = day;
    }

    public void setMonth(int month) {
        if(month <=12 && month>=1)  this.month = month;
    }

    public void setYear(int year) {
        if(year<=3999 && year>=-3999)   this.year = year;
    }
}
