package org.jtznenic.solution;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SubstringWithoutRepeatingCharactersTest {

    private SubstringWithoutRepeatingCharacters obj;

    private String input;
    private int expected;

    public SubstringWithoutRepeatingCharactersTest(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> prepareData() {
        Object[][] object = {
            {"abcabcbb", 3},
            {"bbbbb", 1},
            {"pwwkew", 3},
            {"", 0},
            {" ", 1}
        };

        return Arrays.asList(object);
    }

    @Before
    public void setUp() {
        obj = new SubstringWithoutRepeatingCharacters();
    }

    @Test
    public void testLengthOfLongestSubstring() {
        int result = obj.lengthOfLongestSubstring(input);

        assertThat(result, equalTo(expected));
    }
}
