package misc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Samuel Nuttall
 * <p>
 * SetTests uses whitebox testing to test all of the methods of the misc.Set Class
 * The first set of tests examine if branch coverage could be acheived with the given code. The next
 * set of tests after the initial coverage tests test the functionality of the code so that bugs could
 * be eliminated.
 * Any changes to branch behavior from the fixes are documented.
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
     * Tests the different input of toArray to get Branch coverage
     */
    @Test
    @DisplayName("Test toArray Coverage")
    public void testToArrayCoverage() {
        testSet.insert(4);
        testSet.toArray();
    }

    /**
     * Tests the different input of Set.insert() to achieve full branch coverage
     */
    @Test
    @DisplayName("Test insert Coverage")
    public void testInsertCoverage() {
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
    public void testMemberCoverage() {
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

    /**
     * Tests the different input of Set.section() to achieve full branch coverage
     */
    @Test
    @DisplayName("Test Section Coverage")
    public void testSectionCoverage() {

        Set set2 = new Set();

        //Covers i < a.size by calling when size = 0
        testSet.section(set2);

        testSet.insert(0);
        testSet.insert(1);
        testSet.insert(6);

        set2.insert(0);
        set2.insert(2);
        set2.insert(4);


        testSet.section(set2);

        log.debug("SET2: {}", set2.toArray());
        log.debug("testSet: {}", testSet.toArray());

    }

    /**
     * Tests branch coverage of arithTripleCoverage using a set that contains an arithTriple and one
     * that does not
     */
    @Test
    @DisplayName("Test containsArithTriple Coverage")
    public void testArithTripleCoverage() {

        //testSet contains an arithTriple, should return true
        int x = 1;
        int y = 2;
        int z = 3;
        testSet.insert(x);
        testSet.insert(y);
        testSet.insert(z);

        assertTrue(testSet.containsArithTriple());

        //Set2 does not contain an arithTriple, should return false
        Set set2 = new Set();
        x = 5;
        y = 7;
        z = 1;
        set2.insert(x);
        set2.insert(y);
        set2.insert(z);

        assertFalse(set2.containsArithTriple());

    }



    /**
     * Tests that the insert method works correctly.
     * It appears that Set is trying to sort things on insert by having smaller values come first,
     * so that functionality will be maintained.
     * <p>
     * This tests that only one value is inserted each time and compares the set values to a
     * java.util.Set with the same input
     * <p>
     * <b>Bugs Discovered and Fixed</b>: Pre-corrected Set class did not have correct set insert behavior as
     * I discovered in this test. Certain values were being added twice because a break statement was
     * used rather than a return to prevent this.
     */
    @Test
    @DisplayName("Test Insert Functionality")
    public void testInsertFunctionality() {

        Set set2 = new Set();
        set2.insert(4);
        set2.insert(2);
        set2.insert(1);

        ArrayList<Integer> expected = new ArrayList<>();
        int[] setVals = set2.toArray();
        log.info("setVals {}", setVals);

        assertEquals(3, setVals.length);

        java.util.Set<Integer> trueSet = new HashSet<>();

        trueSet.add(4);
        trueSet.add(2);
        trueSet.add(1);


        assertTrue(trueSet.contains(setVals[0]));
        assertTrue(trueSet.contains(setVals[1]));
        assertTrue(trueSet.contains(setVals[2]));
    }

    /**
     * Tests that the toArray method works properly (refer to README-HW5-Whitebox.md for more info)
     * <p>
     * <b>Bugs Discovered and Fixed</b>: None
     */
    @Test
    @DisplayName("Test toArray Functionality")
    public void testToArrayFunctionality() {

        testSet.insert(3);
        testSet.insert(1);
        testSet.insert(2);

        int[] actual = testSet.toArray();
        log.info("setVals {}", actual);
        ArrayList<Integer> expected = new ArrayList<>();
        //Since insert sorts smallest to biggest, order expected accordingly
        expected.add(1);
        expected.add(2);
        expected.add(3);

        for (int i = 0; i < actual.length; i++) {
            assertEquals((int) expected.get(i), actual[i]);
        }

    }

    /**
     * Tests that insert will not insert values already contained int the set
     * <p>
     * <b>Bugs Discovered and Fixed</b>: None
     */
    @Test
    @DisplayName("Test Insert Equal Element")
    public void testInsertEqualElement() {

        Set set2 = new Set();
        set2.insert(3);
        set2.insert(2);
        set2.insert(1);
        set2.insert(3);

        ArrayList<Integer> expected = new ArrayList<>();
        int[] setVals = set2.toArray();
        log.info("setVals {}", setVals);

        assertEquals(3, setVals.length);

        java.util.Set<Integer> trueSet = new HashSet<>();
        trueSet.add(1);
        trueSet.add(2);
        trueSet.add(3);


        assertTrue(trueSet.contains(setVals[0]));
        assertTrue(trueSet.contains(setVals[1]));
        assertTrue(trueSet.contains(setVals[2]));
    }


    /**
     * Tests that the member method of the set class correctly determines whether an int element is
     * a member of the set or not.
     * <p>
     * <b>Bugs Discovered and Fixed</b>: No problems were found, although the `else { if()}` could be
     * more readable so that was changed to and `else if()`.
     */
    @Test
    @DisplayName("Test Member Functionality")
    public void testMemberFunctionality() {

        testSet.insert(5);
        testSet.insert(0);
        testSet.insert(1);
        testSet.insert(2);
        testSet.insert(4);

        assertTrue(testSet.member(0));
        assertTrue(testSet.member(1));
        assertTrue(testSet.member(2));
        assertTrue(testSet.member(4));
        assertTrue(testSet.member(5));

        assertFalse(testSet.member(3));
        assertFalse(testSet.member(7));

        ArrayList<Integer> expected = new ArrayList<>();
        int[] setVals = testSet.toArray();
        log.info("setVals {}", setVals);

        assertEquals(5, setVals.length);
    }


    /**
     * Tests that section method removes from the set any element that is equal to an element in s.
     * <p>
     * <b>Bugs Discovered and Fixed</b>: There was a bug with the iteration through the set values
     * after a.remove. To fix this I removed `i++;` after the `a.remove(i)` because it did not take into account
     * that by removing the ith element of a, it was effectively iterating to the next element of a anyway,
     * so `i++;` was causing problems.
     */
    @Test
    @DisplayName("Test Section Functionality")
    public void testSectionFunctionality() {

        Set set2 = new Set();

        testSet.insert(0);
        testSet.insert(1);
        testSet.insert(3);
        testSet.insert(4);
        testSet.insert(6);
        testSet.insert(5);

        set2.insert(4);
        set2.insert(0);
        set2.insert(2);
        set2.insert(1);
        set2.insert(5);

        testSet.section(set2);

        // The result should be a set with 3 and 6
        int[] setVals = testSet.toArray();
        log.info("Set values: {}", setVals);
        assertEquals(2, setVals.length);
        assertEquals(3, setVals[0]);
        assertEquals(6, setVals[1]);

    }


    /**
     * Tests that arithTriple() method returns true if the set contains an arithTriple, false if not
     * <p>
     * <b>Bugs Discovered and Fixed</b>: This test revealed that the problem with this method was
     * that it would incorrectly return true because it would iterate over the same elements and have no checks
     * on what is going as input into the member method.
     * In other words, it failed to make sure x,y, and z were all unique values from the set. Before
     * correcting it, it would check if plugging in the same values produced an arithTriple. This was
     * fixed by adding a boolean statement to the if statement to make sure the same values
     * were not used for x and y.
     */
    @Test
    @DisplayName("Test ArithTriple Functionality")
    public void testArithTripleFunctionality() {

        int x = 1;
        int y = 2;
        int z = 3;
        testSet.insert(x);
        testSet.insert(y);
        testSet.insert(z);

        assertTrue(testSet.containsArithTriple());

        Set set2 = new Set();
        x = 1;
        y = 3;
        z = 5;

        set2.insert(x);
        set2.insert(y);
        set2.insert(z);

        assertTrue(set2.containsArithTriple());

        Set set3 = new Set();
        x = 5;
        y = 7;
        z = 1;
        set3.insert(x);
        set3.insert(y);
        set3.insert(z);

        assertFalse(set3.containsArithTriple());
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
    //ADDITIONAL MC/DC TESTS




}
