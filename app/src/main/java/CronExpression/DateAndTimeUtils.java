package CronExpression;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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
        return  StringUtils.leftPad(""+localTime.getHourOfDay(), 2, '0');
    }

    public static String getDayOfWeekName(int dayOfWeek) {
        return new DateTime().withDayOfWeek(dayOfWeek).dayOfWeek().getAsText();
    }


    public static String formatMinutes(String minutesExpression) {
        if (StringUtils.contains(minutesExpression, ",")) {
            StringBuilder formattedExpression = new StringBuilder();
            for (String minute : StringUtils.split(minutesExpression, ',')) {
                formattedExpression.append(StringUtils.leftPad(minute, 2, '0'));
                formattedExpression.append(",");
            }
            return formattedExpression.toString();
        }
        return StringUtils.leftPad(minutesExpression, 2, '0');
    }

}
