package misc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Samuel Nuttall
 *
 * This class is the set of the branch coverage tests of a few of the set class methods, made before
 * changes to the Set class to get functionality.
 * it work.
 */
public class InitialSetTests {
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
     * Tests the different input of toArray to get Branch coverage
     */
    @Test
    @DisplayName("Test toArray Coverage")
    public void testToArray() {
        testSet.insert(4);
        testSet.toArray();
    }

    /**
     * Tests the different input of Set.insert() to achieve full branch coverage
     */
    @Test
    @DisplayName("Test insert Coverage")
    public void testInsert() {
        testSet.insert(8);
        testSet.insert(5);

        testSet = null;
        testSet = new Set();
        testSet.insert(0);
        testSet.insert(0);

        testSet = null;
        testSet = new Set();
        testSet.insert(0);
        testSet.insert(1);
    }


    /**
     * Tests the different input of Set.member() to achieve full branch coverage
     */
    @Test
    @DisplayName("Test member Coverage")
    public void testMember() {
        testSet.insert(8);
        testSet.member(5);

        testSet = null;
        testSet = new Set();
        testSet.insert(0);
        testSet.member(0);

        testSet = null;
        testSet = new Set();
        testSet.insert(0);
        testSet.member(1);
    }
}
