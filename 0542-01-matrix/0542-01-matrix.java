class Solution {
    
     static class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
           
        
         int mrow = mat.length-1,mcol = mat[0].length-1;
          ArrayDeque<Pair> q = new ArrayDeque<>();
                    
          // pushing index of all 0th in mat array to the queueu and seting -1 to all the +1          
          for(int i=0; i<mat.length; i++)
            for(int j=0; j<mat[i].length; j++)
              if(mat[i][j] == 0)  
                  q.add(new Pair(i,j));
              else                
                  mat[i][j] = -1;
                
        
        
        while(q.size() > 0){
               Pair pair = q.removeFirst();
               int i = pair.i, j = pair.j;
            
               //top
               if(i-1 >=0 && mat[i-1][j] == -1){
                   mat[i-1][j] = mat[i][j] + 1;
                   q.add(new Pair(i-1, j));
               }
               
               //right
               if(j+1 <= mcol && mat[i][j+1] == -1){
                   mat[i][j+1] = mat[i][j] + 1;
                   q.add(new Pair(i, j+1));
               }  
              //bottom
               if(i+1 <= mrow && mat[i+1][j] == -1){
                   mat[i+1][j] = mat[i][j] + 1;
                   q.add(new Pair(i+1, j));
               }
               //left
               if(j-1 >= 0 && mat[i][j-1] == -1){
                    mat[i][j-1] = mat[i][j] + 1;
                   q.add(new Pair(i,j-1));
               }
           }       
        return mat;
    }
}