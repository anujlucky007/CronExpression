package CronExpression.descriptor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HoursDescriptionBuilderTest {
    @Test
    public void shouldGiveFullDescription(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        String actualMessage = hoursDescriptionBuilder.getAllDescription();
        String expectedMessage="0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23";
        assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void shouldGiveDescriptionOfBetweenInterval(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        String actualMessage = hoursDescriptionBuilder.getBetweenDescription("5-6","5","6");
        String expectedMessage="5 6";
        assertEquals(actualMessage,expectedMessage);
    }


    @Test
    public void shouldGiveHourTimeBasedOnExpressionPassed(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        String actualMessage = hoursDescriptionBuilder.getSingleItemDescription("5");
        String expectedMessage="05";
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
        String expectedMessage="Value 25 for hourOfDay must be in the range [0,23]";
        assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void shouldGiveValueWithFixedFrequencyOf2Hour(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        String actualMessage = hoursDescriptionBuilder.getIntervalDescription("2");
        String expectedMessage="0 2 4 6 8 10 12 14 16 18 20 22";
        assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void shouldGiveValueWithFixedFrequencyOf5Hour(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        String actualMessage = hoursDescriptionBuilder.getIntervalDescription("5");
        String expectedMessage="0 5 10 15 20";
        assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void shouldGetExpressionSTARIntoDescription(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        String actualMessage= hoursDescriptionBuilder.getSegmentDescription("*");
        String expectedMessage="0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23";
        assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void shouldGetExpressionIntervalIntoDescription(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        String actualMessage= hoursDescriptionBuilder.getSegmentDescription("5-6");
        String expectedMessage="5 6";
        assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void shouldGetSingleHourExpressionIntoDescription(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        String actualMessage= hoursDescriptionBuilder.getSegmentDescription("5");
        String expectedMessage="05";
        assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void shouldGetCommaSeparatedHourExpressionIntoDescription(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        String actualMessage= hoursDescriptionBuilder.getSegmentDescription("1,2,5");
        String expectedMessage="01 02 05 ";
        assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void shouldGetSlashSeparatedWeekExpressionIntoDescription(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        String actualMessage= hoursDescriptionBuilder.getSegmentDescription("*/2");
        String expectedMessage="0 2 4 6 8 10 12 14 16 18 20 22";
        assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void shouldReturnErrorIfWrongExpressionIsEntered(){
        HoursDescriptionBuilder hoursDescriptionBuilder = new HoursDescriptionBuilder();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            hoursDescriptionBuilder.getSegmentDescription("99");
        });
        String actualMessage = exception.getMessage();
        String expectedMessage="Value 99 for hourOfDay must be in the range [0,23]";
        assertEquals(actualMessage,expectedMessage);
    }
}