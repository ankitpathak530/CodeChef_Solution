class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        //we can touch four boundry

        int i = 0;
        int j = -1;
        int min = Integer.MIN_VALUE;

        while(true){
             
             //move right
             for(j = j+1; j<matrix[0].length; j++){
                  //visited
                  if(matrix[i][j] == min){
                       j--;
                       break;
                  }
                  else{
                         list.add(matrix[i][j]);
                      matrix[i][j] = min;
                    
                  }
             }

             if(j == matrix[0].length) j = j -1;

             //move bottom
             for(i = i+1; i<matrix.length; i++){
                  //visited
                  if(matrix[i][j] == min){
                       i--;
                       break;
                  }
                  else{
                        list.add(matrix[i][j]);
                      matrix[i][j] = min;
                    
                  }
             }

             if(i == matrix.length) i = i -1;

             //move left
              for(j = j-1; j>=0; j--){
                  //visited
                  if(matrix[i][j] == min){
                       j++;
                       break;
                  }
                  else{
                        list.add(matrix[i][j]);
                      matrix[i][j] = min;
                    
                  }
             }

             if(j < 0) j = 0;

             

             //move up
              for(i = i-1; i>=0; i--){
                  //visited
                  if(matrix[i][j] == min){
                       i++;
                       break;
                  }
                  else{
                        list.add(matrix[i][j]);
                      matrix[i][j] = min;
                    
                  }
             }

             if( i < 0) i = 0;


             if(list.size() == matrix.length * matrix[0].length){
                 break;
             }
        }


        return list;
        
    }
}