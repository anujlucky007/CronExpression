package CronExpression.descriptor;

import CronExpression.DateAndTimeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class HoursDescriptionBuilder extends AbstractDescriptionBuilder {


    @Override
    protected String getAllDescription() {
        List fullHourDescription= new ArrayList();
        IntStream.range(0, 24).forEach(
                val -> fullHourDescription.add(val)
        );
        return getStreamAsString(fullHourDescription);
    }

    @Override
    protected String getBetweenDescription(String expression, String initialLimit, String endLimit) {
        List betweenHourDescription= new ArrayList();
        int startLimit= Integer.parseInt(initialLimit);
        int endList= Integer.parseInt(endLimit);
        IntStream.rangeClosed(startLimit, endList).forEach(
                val -> betweenHourDescription.add(val)
        );
        return getStreamAsString(betweenHourDescription);
    }

    @Override
    protected String getIntervalDescription(String expression) {
        return null;
    }

    @Override
    protected String getSingleItemDescription(String expression) {
        return DateAndTimeUtils.formatTime(expression, "0");
    }

}
