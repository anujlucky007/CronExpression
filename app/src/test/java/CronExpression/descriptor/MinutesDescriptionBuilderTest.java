package CronExpression.descriptor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinutesDescriptionBuilderTest {

    @Test
    public void shouldGiveFullDescription(){
       MinutesDescriptionBuilder minutesDescriptionBuilder = new MinutesDescriptionBuilder();
       String actualMessage = minutesDescriptionBuilder.getAllDescription();
       String expectedMessage="0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59";
       assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void shouldGiveDescriptionOfBetweenInterval(){
        MinutesDescriptionBuilder minutesDescriptionBuilder = new MinutesDescriptionBuilder();
        String actualMessage = minutesDescriptionBuilder.getBetweenDescription("5-6","5","6");
        String expectedMessage="5 6";
        assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void shouldGiveValueWithFixedFrequencyOf2Min(){
        MinutesDescriptionBuilder minutesDescriptionBuilder = new MinutesDescriptionBuilder();
        String actualMessage = minutesDescriptionBuilder.getIntervalDescription("2");
        String expectedMessage="0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 52 54 56 58";
        assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void shouldGiveValueWithFixedFrequencyOf15Min(){
        MinutesDescriptionBuilder minutesDescriptionBuilder = new MinutesDescriptionBuilder();
        String actualMessage = minutesDescriptionBuilder.getIntervalDescription("15");
        String expectedMessage="0 15 30 45";
        assertEquals(actualMessage,expectedMessage);
    }
}