package CronExpression.descriptor;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MonthDescriptionBuilder extends AbstractDescriptionBuilder {

    @Override
    protected String getAllDescription() {
        List fullMonthDescription= new ArrayList();
        IntStream.rangeClosed(1, 12).forEach(
                val -> fullMonthDescription.add(val)
        );
        return getStreamAsString(fullMonthDescription);
    }

    @Override
    protected String getBetweenDescription(String expression, String initialLimit, String endLimit) {
        List betweenMonthDescription= new ArrayList();
        int startLimit= Integer.parseInt(initialLimit);
        int endList= Integer.parseInt(endLimit);
        IntStream.rangeClosed(startLimit, endList).forEach(
                val -> betweenMonthDescription.add(val)
        );
        return getStreamAsString(betweenMonthDescription);
    }

    @Override
    protected String getIntervalDescription(String expression) {
        int frequency= Integer.parseInt(expression);
        return getValuesWithFixedFrequency(frequency,1,12);
    }

    @Override
    protected String getSingleItemDescription(String expression) {
        int month= Integer.parseInt(expression);
        if(month>0 && month<=12)
            return StringUtils.leftPad(expression, 2, '0');
        else
            throw new IllegalArgumentException("Month expression cannot be less than 0 or greater than 12");
    }
}