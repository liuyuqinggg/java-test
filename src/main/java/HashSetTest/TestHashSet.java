package HashSetTest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestHashSet {
    public static void main(String[] args) {
        Set<Long> numberSet = new HashSet<>();
        numberSet.add(11L);
        numberSet.add(22L);
        numberSet.add(33L);
        numberSet.add(44L);


        Iterator<Long> iterator = numberSet.iterator();
        while (iterator.hasNext()){
            for (Integer i = 0; i < numberSet.size(); i++) {
                System.out.println(iterator.next());
            }

        }
    }
}
