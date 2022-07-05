package CronExpression.descriptor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonthDescriptionBuilderTest {
    @Test
    public void shouldGiveFullDescription(){
        MonthDescriptionBuilder monthDescriptionBuilder = new MonthDescriptionBuilder();
        String actualMessage = monthDescriptionBuilder.getAllDescription();
        String expectedMessage="1 2 3 4 5 6 7 8 9 10 11 12";
        assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void shouldGiveDescriptionOfBetweenInterval(){
        MonthDescriptionBuilder monthDescriptionBuilder = new MonthDescriptionBuilder();
        String actualMessage = monthDescriptionBuilder.getBetweenDescription("5-6","5","6");
        String expectedMessage="5 6";
        assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void shouldGiveMonthBasedOnExpressionPassed(){
        MonthDescriptionBuilder monthDescriptionBuilder = new MonthDescriptionBuilder();
        String actualMessage = monthDescriptionBuilder.getSingleItemDescription("5");
        String expectedMessage="05";
        assertEquals(actualMessage,expectedMessage);
    }


    @Test
    public void shouldGiveErrorIfMonthIsOutOfRange(){

        MonthDescriptionBuilder monthDescriptionBuilder = new MonthDescriptionBuilder();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            monthDescriptionBuilder.getSingleItemDescription("13");
        });
        String actualMessage = exception.getMessage();
        String expectedMessage="Month expression cannot be less than 0 or greater than 12";
        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void shouldGiveErrorIfMonthIsOutOfRangeLessThan1(){

        MonthDescriptionBuilder monthDescriptionBuilder = new MonthDescriptionBuilder();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            monthDescriptionBuilder.getSingleItemDescription("0");
        });
        String actualMessage = exception.getMessage();
        String expectedMessage="Month expression cannot be less than 0 or greater than 12";
        assertEquals(actualMessage,expectedMessage);
    }
}