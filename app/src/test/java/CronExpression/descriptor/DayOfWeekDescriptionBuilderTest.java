package CronExpression.descriptor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayOfWeekDescriptionBuilderTest {
    @Test
    public void shouldGiveFullDescription(){
        DayOfWeekDescriptionBuilder dayOfWeekDescriptionBuilder = new DayOfWeekDescriptionBuilder();
        String actualMessage = dayOfWeekDescriptionBuilder.getAllDescription();
        String expectedMessage="0 1 2 3 4 5 6";
        assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void shouldGiveDescriptionOfBetweenInterval(){
        DayOfWeekDescriptionBuilder dayOfWeekDescriptionBuilder = new DayOfWeekDescriptionBuilder();
        String actualMessage = dayOfWeekDescriptionBuilder.getBetweenDescription("5-6","5","6");
        String expectedMessage="5 6";
        assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void shouldGiveDayOfWeekBasedOnExpressionPassed(){
        DayOfWeekDescriptionBuilder dayOfWeekDescriptionBuilder = new DayOfWeekDescriptionBuilder();
        String actualMessage = dayOfWeekDescriptionBuilder.getSingleItemDescription("5");
        String expectedMessage="05";
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

}