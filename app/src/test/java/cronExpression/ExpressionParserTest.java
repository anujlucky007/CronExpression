package cronExpression;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.text.ParseException;


class ExpressionParserTest {

    @Test
    public void shouldFailIfNumberOfParameterIsMoreThan6(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            ExpressionParser.parseExpression("1 2 3 4 5 6 7");
        });

        String expectedMessage = "expression having more or less  than expected arguments";
        String actualMessage = exception.getMessage();

        assertSame(actualMessage,expectedMessage);
    }

    @Test
    public void shouldFailIfNumberOfParameterIsLessThan6(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {
            ExpressionParser.parseExpression("1 2 3 4 5");
        });

        String expectedMessage = "expression having more or less  than expected arguments";
        String actualMessage = exception.getMessage();

        assertSame(actualMessage,expectedMessage);
    }

    @Test
    public void shouldFailIfNumberOfParameterIsEmpty(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->{ExpressionParser.parseExpression("");});

        String expectedMessage = "expression empty exception";
        String actualMessage = exception.getMessage();

        assertSame(actualMessage,expectedMessage);
    }

    @Test
    public void shouldSplitExpressionRemovingExtraSpaceInArgument(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->{ ExpressionParser.parseExpression("1  2    3 4     5  6   7   ");;});

        String expectedMessage = "expression having more or less  than expected arguments";
        String actualMessage = exception.getMessage();

        assertSame(actualMessage,expectedMessage);
    }

    @Test
    public void shouldSplitExpressionRemovingExtraSpaceInArgumentAndReturningParsedString() throws ParseException {
        String [] parsed = ExpressionParser.parseExpression("* *   * * *   cmd");
        assertSame(6,parsed.length);
        assertEquals("*",parsed[0]);
        assertEquals("*",parsed[1]);
        assertEquals("*",parsed[2]);
        assertEquals("*",parsed[3]);
        assertEquals("*",parsed[4]);
        assertEquals("cmd",parsed[5]);

    }


}