import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

        Date parse = simpleDateFormat.parse("08:00:00");
        System.out.println(parse.getTime());

        Calendar calendar = Calendar.getInstance();
        Date today = new Date();
        calendar.setTime(today);// 此处可换为具体某一时间
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        int monthDay = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(weekDay);
        System.out.println(monthDay);
    }
}
