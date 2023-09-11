
import java.util.*;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
          
        List<Integer>[] res = new ArrayList[500];
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<500; i++) res[i] = new ArrayList<>();

        List<List<Integer>> finalRes = new ArrayList<>();


        for(int i=0; i<groupSizes.length; i++){
            int idx = groupSizes[i]; //3
            set.add(idx);
            res[idx].add(i);
        }


        for(int i : set){ 
            List<Integer> element = res[i];
            // i -> 3    elemstSize- 6
            AtomicInteger counter = new AtomicInteger();
            System.out.println("Counter: - "+counter);
            
            final Collection<List<Integer>> list =   element.stream().collect(Collectors.groupingBy(e -> counter.getAndIncrement() / i))
                            .values(); 

            for(List<Integer> l : list){
                finalRes.add(l);
            }                
        }



        return finalRes;
    }
}