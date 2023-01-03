package graph;

import java.util.Arrays;

public class JumpII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           int i = jump(new int[] {2,3,1,1,4});
           System.out.println(i);
	}

      public static  int jump(int[] nums) {

			if (nums.length == 1)
				return 1;

			int[] visited = new int[nums.length];
			Arrays.fill(visited, -1);
			return mJump(nums, 0, visited);

		}
        static int value = Integer.MAX_VALUE; // 1
        
		public static int mJump(int[] arr, int i, int[] visited) {

			if(i >= arr.length-1) {
				return 0;
			}
			
			if (visited[i] != -1) {
				return visited[i];
			}

			int n = arr[i];
			
			for (int k = n; k >= 1; k--) {
				int res = 1 + mJump(arr, i + k, visited);
				value = Math.min(value, res);
				visited[i+k] = value;
                
			}
			
			return value;	
			
			
		}

	}


