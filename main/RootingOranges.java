package main;

import java.util.ArrayDeque;




public class RootingOranges {

    static class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int orangesRotting(int[][] grid) {

         ArrayDeque<Pair> q = new ArrayDeque<>();   
         int fresh = 0;
         int gcol = grid[0].length-1;
         int grow = grid.length-1;

         for(int i=0; i<grid.length; i++){
             for(int j=0; j<grid[i].length; j++){
                 if(grid[i][j] == 0) continue;
                 else if(grid[i][j] == 2)
                    q.add(new Pair(i,j));
                 else if(grid[i][j] == 1){
                    fresh++;
                 }
             }
         }
         if(fresh == 0) return 0;

         int minute = -1;
         while(q.size() > 0)
         {
               int size =   q.size();
               while(size-->0)
               {
                        Pair pair = q.pop();
                        int i = pair.i;
                        int j = pair.j;

                        //top
                        if(i-1 >=0 && grid[i-1][j] == 1)
                        {
                            grid[i-1][j] = 0;
                            q.add(new Pair(i-1,j));  
                            fresh--;
                        }
                        //right
                        if(j+1 <= gcol && grid[i][j+1] == 1)
                        {
                            grid[i][j+1] = 0;
                            q.add(new Pair(i,j+1));
                             fresh--;
                        }
                        //bottom
                        if(i+1 <= grow && grid[i+1][j] == 1)
                        {
                                grid[i+1][j] = 0;
                                q.add(new Pair(i+1,j));
                                 fresh--;
                        }
                        //left
                        if(j-1 >=0 && grid[i][j-1] == 1)
                        {
                                grid[i][j-1] = 0;
                                q.add(new Pair(i,j-1));
                                 fresh--;
                        }
                } 
                minute++;      
        }

        return (fresh == 0) ? minute : -1;
    
}
}