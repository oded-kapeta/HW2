public class DateTime extends Date {
    private int minute = 0;
    private int hour = 0;
    public DateTime(int myday,int mymonth,int myyear,int myminute,int myhour){
        super(myyear,mymonth,myday);
        setHour(myhour);
        setMinute(myminute);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)    return true;
        if (obj == null || !(obj instanceof DateTime))    return false;
        DateTime newobj = (DateTime) obj;
        return super.day==newobj.day && super.month== newobj.month && super.year==newobj.year && this.hour==newobj.hour && this.minute==newobj.minute ;
    }

    @Override
    public String toString() {
        String superToString = super.toString();
        String minuteString = String.valueOf(this.minute);
        String hourString = String.valueOf(this.hour);
        int lengthMinute = minuteString.length();
        int lengthHour = hourString.length();
        while (lengthHour <2 || lengthMinute <2){
            if (lengthHour < 2){
                hourString = "0"+hourString;
                lengthHour++;
            }
            if (lengthMinute < 2){
                minuteString = "0"+minuteString;
                lengthMinute++;
            }
        }
        String finalString = superToString + " " + hourString + ":" + minuteString;
        return finalString;
    }


    @Override
    public int hashCode() {
        return 3999*this.year + 31*this.month + 12*this.year + 23*this.hour + 59*this.minute;
    }

    public void setMinute(int minute) {
        if(minute<=59 && minute>=0) this.minute = minute;
    }

    public void setHour(int hour) {
        if(hour<=23 && hour>=0) this.hour = hour;
    }
}
