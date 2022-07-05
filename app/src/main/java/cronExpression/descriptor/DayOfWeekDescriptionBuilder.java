package cronExpression.descriptor;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DayOfWeekDescriptionBuilder extends AbstractDescriptionBuilder {

    String headerDisplayString ="Day of week";
    @Override
    protected List getSTARDescription() {
        List dayOfWeekList= new ArrayList();
        IntStream.rangeClosed(0, 6).forEach(
                val -> dayOfWeekList.add(val)
        );
        return dayOfWeekList;
    }

    @Override
    protected List getBetweenDescription(String initialLimit, String endLimit) {
        List betweenDOWDescription= new ArrayList();
        int startLimit= Integer.parseInt(initialLimit);
        int endList= Integer.parseInt(endLimit);
        IntStream.rangeClosed(startLimit, endList).forEach(
                val -> betweenDOWDescription.add(val)
        );
        return betweenDOWDescription;
    }

    @Override
    protected List getIntervalDescription(String expression) {
        int frequency= Integer.parseInt(expression);
        return getValuesWithFixedFrequency(frequency,0,6);
    }

    @Override
    protected String getSingleItemDescription(String expression) {
        int dayOfWeek= Integer.parseInt(expression);
        if(dayOfWeek>=0 && dayOfWeek<=6)
            return expression;
        else
            throw new IllegalArgumentException("Day Of week expression cannot be less than 0 or greater than 6");


    }

    @Override
    public String getHeaderDisplayString() {
        return headerDisplayString;
    }
}
