package CronExpression;


import CronExpression.descriptor.*;
import org.apache.commons.lang3.StringUtils;

public class CronExpDescriptor {

     String getFullDescription(String expression) {
         String[] expressionParts;
         String description= "";
         try {
             expressionParts = ExpressionParser.parseExpression(expression);
             description = getMinutesDescription(expressionParts) + System.lineSeparator()+
                     getHoursDescription(expressionParts) + System.lineSeparator() +
                     getDayOfMonthDescription(expressionParts) + System.lineSeparator()+
                     getMonthDescription(expressionParts) + System.lineSeparator()+
                     getDayOfWeekDescription(expressionParts) + System.lineSeparator() +
                     getCommandDescription(expressionParts);
         }catch (Exception e){
             description = e.getMessage();
             System.out.println("Exception parsing expression ");
         }

        return description;
    }
    private  String getMinutesDescription(String[] expressionParts) {
        return new MinutesDescriptionBuilder().getParsedDescriptionString(expressionParts[0]);
    }

    private  String getHoursDescription(String[] expressionParts) {
        return new HoursDescriptionBuilder().getParsedDescriptionString(expressionParts[1]);
    }
    private  String getDayOfMonthDescription(String[] expressionParts) {
        return new DayOfMonthDescriptionBuilder().getParsedDescriptionString(expressionParts[2]);
    }

    private  String getMonthDescription(String[] expressionParts) {
        return new MonthDescriptionBuilder().getParsedDescriptionString(expressionParts[3]);
    }
    private  String getDayOfWeekDescription(String[] expressionParts) {
        return new DayOfWeekDescriptionBuilder().getParsedDescriptionString(expressionParts[4]);
    }

    private  String getCommandDescription(String[] expressionParts) {
        return StringUtils.rightPad("Command",15," " ) + expressionParts[5];
    }

}
