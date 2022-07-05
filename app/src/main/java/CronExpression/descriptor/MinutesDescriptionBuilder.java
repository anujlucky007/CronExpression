package CronExpression.descriptor;


import CronExpression.DateAndTimeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;


public class MinutesDescriptionBuilder extends AbstractDescriptionBuilder {


    @Override
    protected String getAllDescription() {
        List fullMinuteDescription= new ArrayList();
        IntStream.range(0, 60).forEach(
                val -> fullMinuteDescription.add(val)
        );
        return getStreamAsString(fullMinuteDescription);
    }

    @Override
    protected String getBetweenDescription(String expression, String initialLimit, String endLimit) {
        List betweenMinuteDescription= new ArrayList();
        int startLimit= Integer.parseInt(initialLimit);
        int endList= Integer.parseInt(endLimit);
        IntStream.rangeClosed(startLimit, endList).forEach(
                val -> betweenMinuteDescription.add(val)
        );
        return getStreamAsString(betweenMinuteDescription);
    }

    @Override
    protected String getIntervalDescription(String expression) {
        int frequency= Integer.parseInt(expression);
        return getValuesWithFixedFrequency(frequency,0,59);
    }

    @Override
    protected String getSingleItemDescription(String expression) {
        return DateAndTimeUtils.formatMinutes(expression);
    }


}
