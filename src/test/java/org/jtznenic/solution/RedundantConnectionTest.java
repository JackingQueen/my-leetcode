package org.jtznenic.solution;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class RedundantConnectionTest {

    @Test
    public void testFindRedundantConnection() {
        int[][] input = {
            {1,2},{1,3},{2,3}
        };

        int[] expected = {2,3};

        int[] result = new RedundantConnection().findRedundantConnection(input);

        assertThat(result, equalTo(expected));
    }
}
