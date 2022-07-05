package CronExpression.descriptor;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MinutesDescriptionBuilderTest {

    @Test
    public void shouldGiveFullDescription(){
       MinutesDescriptionBuilder minutesDescriptionBuilder = new MinutesDescriptionBuilder();
        List actualMessage = minutesDescriptionBuilder.getSTARDescription();
       String expectedMessage="0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59";
       assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGiveDescriptionOfBetweenInterval(){
        MinutesDescriptionBuilder minutesDescriptionBuilder = new MinutesDescriptionBuilder();
        List actualMessage = minutesDescriptionBuilder.getBetweenDescription("5","6");
        String expectedMessage="5 6";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGiveValueWithFixedFrequencyOf2Min(){
        MinutesDescriptionBuilder minutesDescriptionBuilder = new MinutesDescriptionBuilder();
        List actualMessage = minutesDescriptionBuilder.getIntervalDescription("2");
        String expectedMessage="0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 52 54 56 58";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGiveValueWithFixedFrequencyOf15Min(){
        MinutesDescriptionBuilder minutesDescriptionBuilder = new MinutesDescriptionBuilder();
        List actualMessage = minutesDescriptionBuilder.getIntervalDescription("15");
        String expectedMessage="0 15 30 45";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGiveValueWithFixedFrequencyOf5min(){
        MinutesDescriptionBuilder minutesDescriptionBuilder = new MinutesDescriptionBuilder();;
        List actualMessage = minutesDescriptionBuilder.getIntervalDescription("5");
        String expectedMessage="0 5 10 15 20 25 30 35 40 45 50 55";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGetExpressionSTARIntoDescription(){
        MinutesDescriptionBuilder minutesDescriptionBuilder = new MinutesDescriptionBuilder();
        List actualMessage= minutesDescriptionBuilder.getSegmentDescription("*");
        String expectedMessage="0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGetExpressionIntervalIntoDescription(){
        MinutesDescriptionBuilder minutesDescriptionBuilder = new MinutesDescriptionBuilder();
        List actualMessage= minutesDescriptionBuilder.getSegmentDescription("5-6");
        String expectedMessage="5 6";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGetSingleHourExpressionIntoDescription(){
        MinutesDescriptionBuilder minutesDescriptionBuilder = new MinutesDescriptionBuilder();
        List actualMessage= minutesDescriptionBuilder.getSegmentDescription("5");
        String expectedMessage="5";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGetCommaSeparatedHourExpressionIntoDescription(){
        MinutesDescriptionBuilder minutesDescriptionBuilder = new MinutesDescriptionBuilder();
        List actualMessage= minutesDescriptionBuilder.getSegmentDescription("1,2,5");
        String expectedMessage="1 2 5";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldGetSlashSeparatedWeekExpressionIntoDescription(){
        MinutesDescriptionBuilder minutesDescriptionBuilder = new MinutesDescriptionBuilder();
        List actualMessage= minutesDescriptionBuilder.getSegmentDescription("*/15");
        String expectedMessage="0 15 30 45";
        assertEquals(getStreamAsString(actualMessage),expectedMessage);
    }

    @Test
    public void shouldReturnErrorIfWrongExpressionIsEntered(){
        MinutesDescriptionBuilder minutesDescriptionBuilder = new MinutesDescriptionBuilder();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            minutesDescriptionBuilder.getSegmentDescription("99");
        });
        String actualMessage = exception.getMessage();
        String expectedMessage="Minutes expression cannot be less than 0 or greater than 59";
        assertEquals(actualMessage,expectedMessage);
    }

    public String getStreamAsString(List listData){
        return  listData.stream().map(Object::toString).collect(Collectors.joining(" ")).toString();
    }
}