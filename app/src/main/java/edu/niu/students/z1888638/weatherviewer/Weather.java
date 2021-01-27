package edu.niu.students.z1888638.weatherviewer;



import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Weather {
    public final String dayOfweek;
    public final String minTemp;
    public final String maxTemp;
    public final String humidity;
    public final String description;
    public final String iconURL;

    public Weather(long timestamp, double minTemp, double maxTemp, double humidity,
                   String description, String iconName)
    {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(0);

        this.dayOfweek = convertTimestampToDay(timestamp);
        this.minTemp = numberFormat.format(minTemp) +"\u00B0F";
        this.maxTemp = numberFormat.format(maxTemp) +"\u00B0F";
        this.humidity = NumberFormat.getPercentInstance().format(humidity / 100);
        this.description = description;
        this.iconURL = "http://openweathermap.org/img/w/"+ iconName + ".png";
    }

    private String convertTimestampToDay(long timestamp) {
        Calendar calendar= Calendar.getInstance();
        calendar.setTimeInMillis(timestamp*1000);
        TimeZone tz = TimeZone.getDefault();
        calendar.add(Calendar.MILLISECOND,tz.getOffset(calendar.getTimeInMillis()));
        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE");
        return dateFormatter.format(calendar.getTime());
    }

}