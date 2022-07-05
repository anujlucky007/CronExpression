package CronExpression.descriptor;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class HoursDescriptionBuilderTest {
    @Test
    public void shouldGiveFullDescription(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        List actualMessage = hoursDescriptionBuilder.getSTARDescription();
        String expectedMessage="0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGiveDescriptionOfBetweenInterval(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        List actualMessage = hoursDescriptionBuilder.getBetweenDescription("5","6");
        String expectedMessage="5 6";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }


    @Test
    public void shouldGiveHourTimeBasedOnExpressionPassed(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        String actualMessage = hoursDescriptionBuilder.getSingleItemDescription("5");
        String expectedMessage="5";
        assertEquals(actualMessage,expectedMessage);
    }


    @Test
    public void shouldGiveErrorIfHourExpressionIsOutOfRange(){

        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            hoursDescriptionBuilder.getSingleItemDescription("25");
        });
        String actualMessage = exception.getMessage();
        String expectedMessage="Hour expression cannot be less than 0 or greater than 23";
        assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void shouldGiveValueWithFixedFrequencyOf2Hour(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        List actualMessage = hoursDescriptionBuilder.getIntervalDescription("2");
        String expectedMessage="0 2 4 6 8 10 12 14 16 18 20 22";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGiveValueWithFixedFrequencyOf5Hour(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        List actualMessage = hoursDescriptionBuilder.getIntervalDescription("5");
        String expectedMessage="0 5 10 15 20";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGetExpressionSTARIntoDescription(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        List actualMessage= hoursDescriptionBuilder.getSegmentDescription("*");
        String expectedMessage="0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGetExpressionIntervalIntoDescription(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        List actualMessage= hoursDescriptionBuilder.getSegmentDescription("5-6");
        String expectedMessage="5 6";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGetSingleHourExpressionIntoDescription(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        List actualMessage= hoursDescriptionBuilder.getSegmentDescription("5");
        String expectedMessage="5";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGetCommaSeparatedHourExpressionIntoDescription(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        List actualMessage= hoursDescriptionBuilder.getSegmentDescription("1,2,5");
        String expectedMessage="1 2 5";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGetSlashSeparatedWeekExpressionIntoDescription(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        List actualMessage= hoursDescriptionBuilder.getSegmentDescription("*/2");
        String expectedMessage="0 2 4 6 8 10 12 14 16 18 20 22";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldReturnErrorIfWrongExpressionIsEntered(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            hoursDescriptionBuilder.getSegmentDescription("99");
        });
        String actualMessage = exception.getMessage();
        String expectedMessage="Hour expression cannot be less than 0 or greater than 23";
        assertEquals(actualMessage,expectedMessage);
    }
    public String getStreamAsString(List listData){
        return  listData.stream().map(Object::toString).collect(Collectors.joining(" ")).toString();
    }
}