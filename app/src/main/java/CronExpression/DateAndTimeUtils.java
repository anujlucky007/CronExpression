package CronExpression;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;

public final class DateAndTimeUtils {

    private DateAndTimeUtils() {
    }

    public static String formatTime(String hoursExpression, String minutesExpression) {
        return formatTime(hoursExpression, minutesExpression, "");
    }


    public static String formatTime(String hoursExpression, String minutesExpression, String secondsExpression) {
        int hour = Integer.parseInt(hoursExpression);
        int minutes = Integer.parseInt(minutesExpression);

        LocalTime localTime;

            if (!StringUtils.isEmpty(secondsExpression)) {
                final int seconds = Integer.parseInt(secondsExpression);
                localTime = new LocalTime(hour, minutes, seconds);
            } else {
                localTime = new LocalTime(hour, minutes);
            }
        return  ""+localTime.getHourOfDay();
    }

    public static String getDayOfWeekName(int dayOfWeek) {
        return new DateTime().withDayOfWeek(dayOfWeek).dayOfWeek().getAsText();
    }

}
