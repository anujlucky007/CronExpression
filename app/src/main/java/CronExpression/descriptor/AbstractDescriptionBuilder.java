package CronExpression.descriptor;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public abstract class AbstractDescriptionBuilder {

    protected final char[] SpecialCharsMinusStar = new char[]{'/', '-', ','};

    public String getSegmentDescription(String expression) {
        String description = "";
        if (StringUtils.isEmpty(expression)) {
            description = "";
        }
        else if ("*".equals(expression)) {
            description = getAllDescription();
        }
        else if (!StringUtils.containsAny(expression, SpecialCharsMinusStar)) {
            description = getSingleItemDescription(expression);
        }
        else if (expression.contains("-")) {
            String[] segments = expression.split("-");
            description = getBetweenDescription(expression, getSingleItemDescription(segments[0]), getSingleItemDescription(segments[1]));
        }
        else if (expression.contains(",")) {
            String[] segments = expression.split(",");
            StringBuilder descriptionContent = new StringBuilder();
            for (int i = 0; i < segments.length; i++) {
                descriptionContent.append(getSingleItemDescription(segments[i]));
                descriptionContent.append(" ");
            }
            description = descriptionContent.toString();
        }
        else if (expression.contains("/")) {
            String[] segments = expression.split("/");
            description = getIntervalDescription(segments[1]);
        }
        return description;
    }

    protected abstract String getAllDescription();

    protected abstract String getBetweenDescription(String expression, String initialLimit, String endLimit);

    protected abstract String getIntervalDescription(String expression);

    protected abstract String getSingleItemDescription(String expression);

    public String getStreamAsString(List listData){
      return  listData.stream().map(Object::toString).collect(Collectors.joining(" ")).toString();
    }


    String getValuesWithFixedFrequency(int frequency,int start,int endIncluded) {
        List frequencyList= IntStream.iterate(start, i -> i <= endIncluded, i -> i + frequency)
                .boxed()
                .collect(toList());

        return getStreamAsString(frequencyList);
    }

    abstract public String getHeaderDisplayString();

    public String getParsedDescriptionString(String expressionPart) {
        return StringUtils.rightPad(getHeaderDisplayString(),15," " ) + getSegmentDescription(expressionPart);
    }
}
