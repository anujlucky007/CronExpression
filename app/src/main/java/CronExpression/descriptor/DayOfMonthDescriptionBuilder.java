package CronExpression.descriptor;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DayOfMonthDescriptionBuilder extends AbstractDescriptionBuilder {


    @Override
    protected String getAllDescription() {
        List fullDayOfMonthDescription= new ArrayList();
        IntStream.rangeClosed(1, 31).forEach(
                val -> fullDayOfMonthDescription.add(val)
        );
        return getStreamAsString(fullDayOfMonthDescription);
    }

    @Override
    protected String getBetweenDescription(String expression, String initialLimit, String endLimit) {
        List betweenDOMDescription= new ArrayList();
        int startLimit= Integer.parseInt(initialLimit);
        int endList= Integer.parseInt(endLimit);
        IntStream.rangeClosed(startLimit, endList).forEach(
                val -> betweenDOMDescription.add(val)
        );
        return getStreamAsString(betweenDOMDescription);
    }

    @Override
    protected String getIntervalDescription(String expression) {
        return null;
    }

    @Override
    protected String getSingleItemDescription(String expression) {
        int dayOfMonth= Integer.parseInt(expression);
        if(dayOfMonth>0 && dayOfMonth<=31)
            return StringUtils.leftPad(expression, 2, '0');
        else
            throw new IllegalArgumentException("Day Of month cannot be less than 0 or greater than 31");
    }


}
