package main;

import java.util.*;

public class BusRoutes_Leetcode {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=0; i<routes.length; i++){
            for(int j=0; j<routes[i].length; j++){
                int busStopNoKey = routes[i][j];
                ArrayList<Integer> busNoValue = map.getOrDefault(busStopNoKey, new ArrayList<>());
                busNoValue.add(i);
                map.put(busStopNoKey,busNoValue);
            }
        }

        HashSet<Integer> busNoVisited = new HashSet<>();
        HashSet<Integer> busStopNoVisited = new HashSet<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int level = 0;

        q.add(source);
        while(q.size() > 0)
        {
            int size = q.size();
            while(size-->0){
                int rem = q.remove();
                if(rem == target)
                   return level;

                 ArrayList<Integer> buses = map.get(rem);
                 for(int bus : buses)
                 {
                     if(busNoVisited.contains(bus)){
                         continue;
                     }
                     busNoVisited.add(bus);

                     int[] busStops = routes[bus];
                     for(int busStop : busStops){
                         if(busStopNoVisited.contains(busStop)){
                             continue;
                         }
                         q.add(busStop);
                         busStopNoVisited.add(busStop);
                     }

                 }
            }
            level++;
        }
        
         return -1;


    }
}