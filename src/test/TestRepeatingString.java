package test;

import main.RepeatingString;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.junit.Assert.assertEquals;

public class TestRepeatingString {

    RepeatingString repeatingString;

    @Rule
    ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp(){
         repeatingString = new RepeatingString();
    }

    @Test
    public void testEmptyStringThrowsException(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("You cannot submit an empty string.");
        repeatingString.repeatedString("", 1);
    }

    @Test
    public void testStringLongerThanOneHundredThrowsException(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("You cannot submit a string of over 100 characters.");
        String testString = "";
        for(int i = 0; i < 101; i++){
            testString = testString.concat("b");
        }
        repeatingString.repeatedString(testString, 1);
    }

    @Test
    public void testRepeatingStringLengthLessThanOneThrowsException(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid length for new string. Please submit a length between 1 and 10^12");
        repeatingString.repeatedString("a", 0);
    }

    @Test
    public void testRepeatingStringLengthGreaterThanTenPowTwelveThrowsException(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid length for new string. Please submit a length between 1 and 10^12");
        repeatingString.repeatedString("a", (long) Math.pow(10, 12) + 1);
    }

    @Test
    public void testMaximumStringSizeRuns(){
        String testString = "";
        for(int i = 0; i < 101; i++){
            testString = testString.concat("b");
        }
        assertEquals(Math.pow(10, 12) * 100, repeatingString.repeatedString(testString, (long) Math.pow(10,12)));
    }

    @Test
    public void testMinimumRepeatSizeRuns(){
        assertEquals(1, repeatingString.repeatedString("a", 1));
    }

    @Test
    public void testMaximumRepeatSizeRuns(){
        assertEquals(Math.pow(10,12), repeatingString.repeatedString("a", (long) Math.pow(10,12)));
    }
}
