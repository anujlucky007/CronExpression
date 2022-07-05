package CronExpression.descriptor;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class DayOfMonthDescriptionBuilderTest {
    @Test
    public void shouldGiveFullDescription(){
        DayOfMonthDescriptionBuilder dayOfMonthDescriptionBuilder = new DayOfMonthDescriptionBuilder();
        List actualMessage = dayOfMonthDescriptionBuilder.getSTARDescription();
        String expectedMessage="1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGiveDescriptionOfBetweenInterval(){
        DayOfMonthDescriptionBuilder dayOfMonthDescriptionBuilder = new DayOfMonthDescriptionBuilder();
        List actualMessage = dayOfMonthDescriptionBuilder.getBetweenDescription("5","6");
        String expectedMessage="5 6";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }
    @Test
    public void shouldGiveDOMBasedOnExpressionPassed(){
        DayOfMonthDescriptionBuilder dayOfMonthDescriptionBuilder = new DayOfMonthDescriptionBuilder();
        String actualMessage = dayOfMonthDescriptionBuilder.getSingleItemDescription("5");
        String expectedMessage="5";
        assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void shouldGiveErrorIfDOMIsOutOfRange(){

        DayOfMonthDescriptionBuilder dayOfMonthDescriptionBuilder = new DayOfMonthDescriptionBuilder();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            dayOfMonthDescriptionBuilder.getSingleItemDescription("32");
        });
        String actualMessage = exception.getMessage();
        String expectedMessage="Day Of month cannot be less than 0 or greater than 31";
        assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void shouldGiveValueWithFixedFrequencyOf2Day(){
        DayOfMonthDescriptionBuilder dayOfMonthDescriptionBuilder = new DayOfMonthDescriptionBuilder();
        List actualMessage = dayOfMonthDescriptionBuilder.getIntervalDescription("2");
        String expectedMessage="1 3 5 7 9 11 13 15 17 19 21 23 25 27 29 31";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGiveValueWithFixedFrequencyOf15Day(){
        DayOfMonthDescriptionBuilder dayOfMonthDescriptionBuilder = new DayOfMonthDescriptionBuilder();
        List actualMessage = dayOfMonthDescriptionBuilder.getIntervalDescription("15");
        String expectedMessage="1 16 31";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGetExpressionSTARIntoDescription(){
        DayOfMonthDescriptionBuilder dayOfMonthDescriptionBuilder = new DayOfMonthDescriptionBuilder();
        List actualMessage= dayOfMonthDescriptionBuilder.getSegmentDescription("*");
        String expectedMessage="1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGetExpressionIntervalIntoDescription(){
        DayOfMonthDescriptionBuilder dayOfMonthDescriptionBuilder = new DayOfMonthDescriptionBuilder();
        List actualMessage= dayOfMonthDescriptionBuilder.getSegmentDescription("5-6");
        String expectedMessage="5 6";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGetSingleDayOfMonthExpressionIntoDescription(){
        DayOfMonthDescriptionBuilder dayOfMonthDescriptionBuilder = new DayOfMonthDescriptionBuilder();
        List actualMessage= dayOfMonthDescriptionBuilder.getSegmentDescription("5");
        String expectedMessage="5";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGetCommaSeparatedDayOfMonthExpressionIntoDescription(){
        DayOfMonthDescriptionBuilder dayOfMonthDescriptionBuilder = new DayOfMonthDescriptionBuilder();
        List actualMessage= dayOfMonthDescriptionBuilder.getSegmentDescription("1,2,5");
        String expectedMessage="1 2 5";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGetSlashSeparatedDayOfMonthExpressionIntoDescription(){
        DayOfMonthDescriptionBuilder dayOfMonthDescriptionBuilder = new DayOfMonthDescriptionBuilder();
        List actualMessage= dayOfMonthDescriptionBuilder.getSegmentDescription("*/2");
        String expectedMessage="1 3 5 7 9 11 13 15 17 19 21 23 25 27 29 31";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldReturnErrorIfWrongExpressionIsEntered(){
        DayOfMonthDescriptionBuilder dayOfMonthDescriptionBuilder = new DayOfMonthDescriptionBuilder();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            dayOfMonthDescriptionBuilder.getSegmentDescription("99");
        });
        String actualMessage = exception.getMessage();
        String expectedMessage="Day Of month cannot be less than 0 or greater than 31";
        assertEquals(actualMessage,expectedMessage);
    }


    public String getStreamAsString(List listData){
        return  listData.stream().map(Object::toString).collect(Collectors.joining(" ")).toString();
    }
}