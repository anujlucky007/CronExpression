package CronExpression;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CronExpDescriptorTest {

    @Test
    public void shouldReturnCronDescription(){
        CronExpDescriptor cronExpDescriptor= new CronExpDescriptor();
        String actualMessage=cronExpDescriptor.getFullDescription("*/15 0 1,15 * 1-5 /usr/bin/find");
        String expectedMessage = "Minutes        0 15 30 45\n" +
                "Hour           0\n" +
                "Day of month   1 15\n" +
                "Month          1 2 3 4 5 6 7 8 9 10 11 12\n" +
                "Day of week    1 2 3 4 5\n" +
                "Command        /usr/bin/find";

        assertEquals(actualMessage,expectedMessage);

    }

    @Test
    public void shouldReturnCronDescriptionWithDifferentExpression(){
        CronExpDescriptor cronExpDescriptor= new CronExpDescriptor();
        String actualMessage=cronExpDescriptor.getFullDescription("*/15 1,2 1,15 * 1-5 /usr/bin/find");
        String expectedMessage = "Minutes        0 15 30 45\n" +
                "Hour           1 2\n" +
                "Day of month   1 15\n" +
                "Month          1 2 3 4 5 6 7 8 9 10 11 12\n" +
                "Day of week    1 2 3 4 5\n" +
                "Command        /usr/bin/find";

        assertEquals(actualMessage,expectedMessage);

    }

    @Test
    public void shouldReturnExceptionIndescriptionWhenWrongDataIsInserted(){
        CronExpDescriptor cronExpDescriptor= new CronExpDescriptor();
        String actualMessage=cronExpDescriptor.getFullDescription("*/15 55 1,15 * 1-5 /usr/bin/find");
        String expectedMessage = "Hour expression cannot be less than 0 or greater than 23";

        assertEquals(actualMessage,expectedMessage);

    }

}