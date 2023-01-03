package main;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum_Leetcode {
	  public int[] answerQueries(int[] nums, int[] queries) {

          int[] res = new int[queries.length];
          //sorting the array
          Arrays.sort(nums);
          
          //Replacing original value of nums to sum of nums[i] + nums[i-1].
          for(int i=1; i<nums.length; i++){
              nums[i]+=nums[i-1];
          }
          //Sarching the element and storing to the result array.
          for(int i=0; i<queries.length; i++){
               res[i] = binarySearch(nums,queries[i]);
          }
      return res;
    }

    public int binarySearch(int[] nums, int query){
        int start=0, end=nums.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == query){        return mid + 1;        }
            else if(nums[mid] > query){     end = mid - 1;        }
            else{                           start = mid + 1;      }
        }
        return start;
    }
}
