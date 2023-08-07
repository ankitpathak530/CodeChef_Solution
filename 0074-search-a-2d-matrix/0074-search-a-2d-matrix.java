class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
          
          int row = solve(0, matrix.length-1, matrix, target);
          
          if(row == -1) return false;


          for(int j=0; j<matrix[0].length; j++){
              if(matrix[row][j] == target){
                  return true;
              }
          }
          return false;

    }

    public int solve(int low, int high, int[][] matrix, int target){


          while(low <= high){
              int mid = low + (high-low)/2;

              if(matrix[mid][0] < target){
                  low = mid+1;
              }
              else if(matrix[mid][0] > target){
                  high = mid-1;  
              }else{
                  return mid;
              }
          }
          return high;   
    }
}