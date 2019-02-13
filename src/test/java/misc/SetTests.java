package misc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author Samuel Nuttall
 *
 * SetTests uses whitebox testing to test all of the methods of the misc.Set Class
 */
public class SetTests {

    private static final Logger log = LoggerFactory.getLogger(SetTests.class);

    private Set testSet;

    @BeforeEach
    public void setUp() throws Exception {
        // Create an instance of the test class before each @Test method is executed
        testSet = new Set();
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Destroy reference to the instance of the test class after each @Test method is executed
        testSet = null;
    }

    /**
     * Tests the different possible input types for the Misc.reverse() method
     * Test calls reverse() with a String array and tests that it works correctly
     */
    @Test
    @DisplayName("Test String Reverse")
    public void testToArray() {

    }

}
