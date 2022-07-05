package CronExpression.descriptor;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class DayOfWeekDescriptionBuilderTest {
    @Test
    public void shouldGiveFullDescription(){
        DayOfWeekDescriptionBuilder dayOfWeekDescriptionBuilder = new DayOfWeekDescriptionBuilder();
        List actualMessage = dayOfWeekDescriptionBuilder.getSTARDescription();
        String expectedMessage="0 1 2 3 4 5 6";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }
    @Test
    public void shouldGiveDescriptionOfBetweenInterval(){
        DayOfWeekDescriptionBuilder dayOfWeekDescriptionBuilder = new DayOfWeekDescriptionBuilder();
        List actualMessage = dayOfWeekDescriptionBuilder.getBetweenDescription("5","6");
        String expectedMessage="5 6";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);    }
    @Test
    public void shouldGiveDayOfWeekBasedOnExpressionPassed(){
        DayOfWeekDescriptionBuilder dayOfWeekDescriptionBuilder = new DayOfWeekDescriptionBuilder();
        String actualMessage = dayOfWeekDescriptionBuilder.getSingleItemDescription("5");
        String expectedMessage="5";
        assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void shouldGiveErrorIfDayOfWeekIsOutOfRange(){

        DayOfWeekDescriptionBuilder dayOfWeekDescriptionBuilder = new DayOfWeekDescriptionBuilder();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            dayOfWeekDescriptionBuilder.getSingleItemDescription("13");
        });
        String actualMessage = exception.getMessage();
        String expectedMessage="Day Of week expression cannot be less than 0 or greater than 6";
        assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void shouldGiveErrorIfMonthIsOutOfRangeLessThan0(){

        DayOfWeekDescriptionBuilder dayOfWeekDescriptionBuilder = new DayOfWeekDescriptionBuilder();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            dayOfWeekDescriptionBuilder.getSingleItemDescription("-1");
        });
        String actualMessage = exception.getMessage();
        String expectedMessage="Day Of week expression cannot be less than 0 or greater than 6";
        assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void shouldGiveValueWithFixedFrequencyOf2DayOfWeek(){
        DayOfWeekDescriptionBuilder dayOfWeekDescriptionBuilder = new DayOfWeekDescriptionBuilder();
        List actualMessage = dayOfWeekDescriptionBuilder.getIntervalDescription("2");
        String expectedMessage="0 2 4 6";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }
    @Test
    public void shouldGiveValueWithFixedFrequencyOf5DayOfWeek(){
        DayOfWeekDescriptionBuilder dayOfWeekDescriptionBuilder = new DayOfWeekDescriptionBuilder();
        List actualMessage = dayOfWeekDescriptionBuilder.getIntervalDescription("5");
        String expectedMessage="0 5";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGetExpressionSTARIntoDescription(){
        DayOfWeekDescriptionBuilder dayOfWeekDescriptionBuilder = new DayOfWeekDescriptionBuilder();
        List actualMessage= dayOfWeekDescriptionBuilder.getSegmentDescription("*");
        String expectedMessage="0 1 2 3 4 5 6";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGetExpressionIntervalIntoDescription(){
        DayOfWeekDescriptionBuilder dayOfWeekDescriptionBuilder = new DayOfWeekDescriptionBuilder();
        List actualMessage= dayOfWeekDescriptionBuilder.getSegmentDescription("5-6");
        String expectedMessage="5 6";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

   @Test
    public void shouldGetSingleDaYOfWeekExpressionIntoDescription(){
        DayOfWeekDescriptionBuilder dayOfWeekDescriptionBuilder = new DayOfWeekDescriptionBuilder();
        List actualMessage= dayOfWeekDescriptionBuilder.getSegmentDescription("5");
        String expectedMessage="5";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGetCommaSeparatedWeekExpressionIntoDescription(){
        DayOfWeekDescriptionBuilder dayOfWeekDescriptionBuilder = new DayOfWeekDescriptionBuilder();
        List actualMessage= dayOfWeekDescriptionBuilder.getSegmentDescription("1,2,5");
        String expectedMessage="1 2 5";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGetSlashSeparatedWeekExpressionIntoDescription(){
        DayOfWeekDescriptionBuilder dayOfWeekDescriptionBuilder = new DayOfWeekDescriptionBuilder();
        List actualMessage= dayOfWeekDescriptionBuilder.getSegmentDescription("*/2");
        String expectedMessage="0 2 4 6";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldReturnErrorIfWrongExpressionIsEntered(){
        DayOfWeekDescriptionBuilder dayOfWeekDescriptionBuilder = new DayOfWeekDescriptionBuilder();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            dayOfWeekDescriptionBuilder.getSegmentDescription("99");
        });
        String actualMessage = exception.getMessage();
        String expectedMessage="Day Of week expression cannot be less than 0 or greater than 6";
        assertEquals(actualMessage,expectedMessage);
    }

    public String getStreamAsString(List listData){
        return  listData.stream().map(Object::toString).collect(Collectors.joining(" ")).toString();
    }
}