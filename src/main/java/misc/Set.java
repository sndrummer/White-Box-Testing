package misc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Set is a sorted set of Integers where lower values come first.
 */
public class Set {
    private static final Logger log = LoggerFactory.getLogger(Set.class);


    private ArrayList<Integer> a;

    /**
     * Set elements stored as an array list
     */
    public Set() {
        a = new ArrayList<>();
    }

    public int[] toArray() {
        int[] ia = new int[a.size()];
        for (int i = 0; i < ia.length; i++) {
            ia[i] = a.get(i);
        }
        return ia;
    }


    /**
     * Insert an int x into the set. There should be no guarantees on item order according to the definition
     * of the set I think so the order should not matter. We are worried about there not being duplicates however.
     * <p>
     * Problems: The original breaking out of the for loop and adding the value a second time
     *
     * @param x
     */
    public void insert(int x) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == x) {
                return;
            } else if (a.get(i) > x) {
                a.add(i, x);
                return;
            }
        }
        a.add(x);
    }

    /**
     * A method to determine if int x is a contained within the Set.
     *
     * @param x an int value
     * @return a boolean indicating whether x is contained within the Set.
     * <p>
     * Changed else{ if } to else if() because it looks cleaner, more readable
     */
    public boolean member(int x) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > x) {
                return false;
            } else if (a.get(i) == x) {
                return true;
            }
        }
        return false;
    }


    /**
     * section(Set s) : removes from this set any element that is equal to an element in s.
     * <p>
     * Changed: removed i++; after the a.remove(i) because it did not take into account that by removing
     * i was effectively moved up in the array anyway
     *
     * @param s a set to
     */
    public void section(Set s) {
        for (int i = 0, j = 0; i < a.size() && j < s.a.size(); ) {
            if (a.get(i).equals(s.a.get(j))) {
                a.remove(i);
                j++;
            } else if (a.get(i) < s.a.get(j)) {
                i++;
            } else {
                j++;
            }

        }
    }

    /**
     * containsArithTriple() : returns true iff there are three elements, x, y, and z, in this set
     * such that y - x = z - y.
     * z = 2y - x
     * ex) x = 1, y = 3, z = 5
     *
     * @return boolean true if set contains an arithTriple, false if not
     * Changed: Added checks to make sure x,y,z were unique values from the set
     */
    public boolean containsArithTriple() {
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (!a.get(i).equals(a.get(j))) {
                    int y = a.get(i);
                    int x = a.get(j);
                    int z = (2 * y) - x;
                    if (z != x && z != y && member(z)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
