package edu.berkeley.aep;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GolfTest {
    @Test
    public void SamplePartiesInto3Groups() {
        Integer[] parties = {2, 3, 1, 4};
        assertEquals(Golf.TeeGroupAssigner(parties), 3);
    }

    @Test
    public void zeroPartyIntoZeroGroups() {
        Integer[] parties = {};
        assertEquals(Golf.TeeGroupAssigner(parties), 0);
    }

    @Test
    public void OnePartyIntoOneGroup(){
        Integer[] parties = {1};
        assertEquals(Golf.TeeGroupAssigner(parties), 1);
    }
}
