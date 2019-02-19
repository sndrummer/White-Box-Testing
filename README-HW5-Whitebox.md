# Whitebox Testing HW:

# 1. Test Set Methods

### Coverage 
The following tests are found in the SetTests class file
**Note- As these coverage tests were written, bugs were discovered using the tests discussed in [Whitebox Tests for functionality](#whitebox-tests-for-functionality) "Whitebox Tests for functionality" section below**

1. toArray() Input Options for full branch coverage:
    - Insert one item, size is now greater than zero, then call toArray(),
    hits every branch.
    
2.  insert(int x) Input Options for full branch coverage: 
    - Insert a high x and a low x (8 then 5)
    - new Set insert two equal values for x (0 and 0)
    - new Set, insert a low value of x and then a higher (0 then 1), now all branches are covered.
    
3.  member(int x) Input Options for full branch coverage: 
    - An element of a is > than x (an element of a that is indexed before an element > x can't be equal to x)
    - An element of a is equal to x where a previously indexed element of a is not > x  
    - An element of a is less than x 
    
4.  section() Input Options for full branch coverage:
    - Call section on from an empty set with another set as input, this covers the false branch of
     i < a.size
    - Create two sets where set1 contains 0,1,6 and set2 contains 0,2,4. Call set1.section(set2), this
    covers `a.get(i).equals(s.a.get(j)` both true and false. Also hits `else if (a.get(i) < s.a.get(j))`
    Running this test with coverage confirms that all branches are covered.
    
5.  containsArithTriple() Input Options for full branch coverage:
    - Create a set that contains an arithTriple and call containsArithTriple()
    - Create a set that does not contain an arithTriple and call containsArithTriple()
    These two sets should achieve full coverage and running a junit test with coverage confirms
    that all branches are hit with these two sets calling containsArithTriple().   

### Whitebox Tests for functionality
To uncover some of the bugs with the Set class I wrote the following tests and fixed the bugs. 
Additional documentation can be found in the SetTests class, and changes made in the Set class.
1. **Testing insert(int x)**: 
    1. To test the functionality of insert, I created a test which asserts only one 
    value is inserted each time and compares the set values to a `java.util.Set` with the same input. 
    Order is not tested since toArray needs to be tested to determine if order is working. 
        - **Bugs Discovered and Fixed:** Pre-corrected Set class did not have correct set insert behavior.
         Certain values were being added twice because a break statement was used 
         rather than a return to prevent this.
    2. Next I created a test that assured that insert will not insert values already contained int the set.
         - **Bugs Discovered and Fixed:** None
         
2. **Testing toArray()**: 
    1. In order to make sure that all subsequent methods in the Set class were working as they should, 
    I first had to determine if the toArray method was working. Since this is a whitebox test, we can use 
    our knowledge of the Set class implementation to test functionality. In this case we compare the 
    array resulting from inserting 3,1, then 2
    to the elements of an ArrayList<Integer> with the same sorted values (1,2,3). 

3. **Testing member(int x)**: 
    1. To determine if the `member()` method was working correctly I created a test to determine 
    to test that it functions by checking whether an int element is a member of the set or not.
        - **Bugs Discovered and Fixed:** No problems were found although the `else { if()}` was changed
         to `else if()` for readability. 
         
4. **Testing section(Set s)**: 
    1. Created a test to see if section did as intended that is: removes from the set any element 
    that is equal to an element in s.
        - **Bugs Discovered and Fixed:** There was a bug with the iteration through the set values
        after a.remove. To fix this I removed `i++;` after the `a.remove(i)` because it did not take into account
        that by removing the ith element of a, it was effectively iterating to the next element of a anyway,
        so `i++;` was causing problems.
        
5. **Testing containsArithTriple()**:
    1. I created a test to see if containsArithTriple was working. I created sets of three numbers 
    and inserted arithTriples into the first two
     (1,2,3) and (1,3,5) and then one that that was not an arithTriple (5,7,1). 
        - **Bugs Discovered and Fixed:** This test revealed that the problem with this method was 
        that it would incorrectly return true because it would iterate over the same elements and have no checks 
        on what is going as input into the member method. In other words, it failed to make sure x,y, and z were all unique values from the set.
        Before correcting it, it would check if plugging in the same values produced an arithTriple. 
        This was fixed by adding a boolean statement to the if statement to make sure the same values
        were not used for x and y.
        
## 2. Additional MC/DC tests 
**Location**: towards the end of the SetTests class file starting after the comment `ADDITIONAL MC/DC TESTS`
1. toArray():
    - Call toArray from an empty Set, this will cover a unique path were the inside of the for loop 
    is never hit 
    
2.  insert(int x):
    - No additional tests required as all of the entry and exit points are already invoked,
    as well as every possible outcome. 
    
3.  member(int x): 
    - Every path has been taken here except for when Set is empty the inside of the for loop would be 
    skipped so that is one that could be added. 
    - To examine the independent effect of each branch, we could test a set of size one, and call member
    three times with different values of x in order to hit every branch once and give us insight to the effects
    of each branch independent of any other input or set state. (Refer to testMemberIndependentPaths in SetTests)

4.  section(Set s):
    - Test when only hitting one decision i.e. use a size of one with different sets to show how the 
    sets independently affect the outcome, this should be 3 tests for the if, if-else, and else branches
    
5.  containsArithTriple():
    - All of the paths/decisions have been tested. Perhaps a test that could be added is an empty set
    calling containsArithTriple() since it would skip the nested for loops and therefore have a unique path
    through the method that has not been tested yet.

## 3. Additional Tests for Complexity Coverage -- Located at the end of the SetTests class file
**Node**: no extra tests added reasoning given below
1.  toArray():
    - With the other tests we have exhausted all paths and decisions so there would be no benefit in examining any 
    linearly independent paths in the toArray method. Running complexity coverage reports no missed complexity. 
    
2.  insert(int x):
    - Because insert has fairly simple and abrupt paths/decisions that have all been tested,
    there would be no reason to conceive of additional tests of its cyclomatic complexity. 
    Running complexity coverage reports no missed complexity.

3.  member(int x): 
    - The tests for member also have no missed complexity. All paths/decisions were tested thoroughly.
    
4.  section(Set x):
    - Section is a bit more complex than the others but we have missed no complexity by hitting all the 
    branches as well as doing a condition analysis in further MC/DC tests. So nothing more can be done here
    in terms of testing independent paths complexity. The tests done in MC/DC may actually qualify as 
    cyclomatic complexity tests as well given we are taking each independent path. 

5.  containsArithTriple():
    - Despite the nested for loops of this method, the complexity is quite easy to analyze given that
    it only has one path to true and one to false. We have exhausted all the possible decisions here as 
    well so more complexity tests would be useless. Running complexity coverage reports no missed complexity. 
