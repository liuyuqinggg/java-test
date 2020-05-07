package Time;

import java.sql.Date;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class getTimeMinutes {
    private static long timeCurrPre;
    private static String timeCurrStrPre;

    public static void main(String[] args) {

        new Thread(()->{
            while (true){
                System.out.println(getTime());
                try {
                    TimeUnit.MILLISECONDS.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    private static String getTime() {
        long time = System.currentTimeMillis();
        int monitor_time = 60 * 1000;
        long timeCurr = (time / monitor_time);
        timeCurr = timeCurr * monitor_time;
        if (timeCurrPre != timeCurr) {
            timeCurrPre = timeCurr;
            Calendar now = Calendar.getInstance();
            now.setTime(new Date(timeCurr));

            String year = Integer.toString(now.get(Calendar.YEAR));
            String mon = Integer.toString(now.get(Calendar.MONTH) + 1);
            String day = Integer.toString(now.get(Calendar.DAY_OF_MONTH));
            String hours = Integer.toString(now.get(Calendar.HOUR_OF_DAY));
            String minute = Integer.toString(now.get(Calendar.MINUTE));
            String second = Integer.toString(now.get(Calendar.SECOND));

            mon = (mon.length() == 1) ? "0" + mon : mon;
            day = (day.length() == 1) ? "0" + day : day;
            hours = (hours.length() == 1) ? "0" + hours : hours;
            minute = (minute.length() == 1) ? "0" + minute : minute;
            second = (second.length() == 1) ? "0" + second : second;
            timeCurrStrPre = year + "-" + mon + "-" + day + " " + hours + ":" + minute + ":" + second;
            return timeCurrStrPre;
        } else {
            return timeCurrStrPre;
        }
    }
}
