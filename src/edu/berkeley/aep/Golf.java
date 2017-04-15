package edu.berkeley.aep;

import java.util.*;

//Understand how to assign tee groups of Golf
public class Golf {
    public static int TeeGroupAssigner(Integer[] toAssign) {
        List<Integer> parties = new ArrayList<>(Arrays.asList(toAssign));
        int numberOfGroups = 0;
        while (parties.size()>0)
        {
            int group = parties.remove(0);
            int currentIndex = 0;
            while (group < 4 && currentIndex < parties.size()) {
                group += parties.get(currentIndex);
                if (group <= 4) {
                    parties.remove(currentIndex);
                }
                else {
                    group -= parties.get(currentIndex);
                    currentIndex++;
                }
            }
            numberOfGroups++;
        }
        return numberOfGroups;
    }

    // Just use the iterator, no need if/else
}
