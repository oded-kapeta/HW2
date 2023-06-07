public class Date {
    final int MAX_YEAR = 3999;
    final int MAX_DAY = 31;
    final int MAX_MONTH = 12;
    final int MAX = MAX_DAY+MAX_YEAR+MAX_YEAR;
    public int day = 1;
    public int month = 1;
    public int year = 0;

    /**
     * constructor to Date
     * @param myYear
     * @param myMonth
     * @param myDay
     */
    public Date(int myYear, int myMonth, int myDay){
        setDay(myDay);
        setYear(myYear);
        setMonth(myMonth);
    }

    /**
     * this function override the equals method
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)    return true;
        if (obj == null)    return false;
        return (this.hashCode() == obj.hashCode());

    }

    /**
     * this functon override toString method
     * @return
     */
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
                yearString = "0"+yearString;
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

    /**
     * this function override the hashcode method
     * @return
     */
    @Override
    public int hashCode() {
        return MAX*this.year + MAX*this.day + MAX*this.month;
    }

    /**
     * set of the day
     * @param day
     */
    public void setDay(int day) {
        if (day >=1 && day<=MAX_DAY) this.day = day;
    }

    /**
     * set of the month
     * @param month
     */
    public void setMonth(int month) {
        if(month <=MAX_MONTH && month>=1)  this.month = month;
    }

    /**
     * set of the year
     * @param year
     */
    public void setYear(int year) {
        if(year<=MAX_YEAR && year>=-3999)   this.year = year;
    }
}
